package PruefungsPlanung;


import java.util.Iterator;

import AusgabeDatenVerwaltung.DatenObjekte.Pruefungstag;
import AusgabeDatenVerwaltung.Datenverwaltung.Pruefungsterminplan;
import EingabeDatenVerwaltung.DatenObjekte.Buchung;
import EingabeDatenVerwaltung.DatenObjekte.Kurs;
import EingabeDatenVerwaltung.DatenObjekte.Student;
import EingabeDatenVerwaltung.DatenVerwaltung.*;

/**
 * PruefungsPlanerAlgo1 ist eine Logik-Klasse, die das Interface Pruefungsplaner implementiert und den PruefungsplanerAbstrakt spezialisiert.. Sie ist zust&auml;ndig f&uuml;r die Pr&uuml;fungsplanung und enth&auml;lt den Algorithmus zur Planung.
 * @author Joern Hauser
 */
public class PruefungsPlanerAlgo1 extends PruefungsplanerAbstrakt implements PruefungsPlaner {

    /**
     * Alle Studenten fuer die geplant wird
     */
    private Studentenliste studentenliste;
    /**
     * Alle Kurse fuer die geplant wird
     */
    private Kursliste kursliste;
    /**
     * Planungsbedingungen als Randbedingungen
     */
    private Planungsbedingungen planungsbedingungen;
    /**
     * Buchungsliste mit allen Buchungen
     */
    private Buchungsliste buchungsliste;
    /**
     * Berechneter Pruefungsterminplan
     */
    private Pruefungsterminplan pruefungsterminplan;

    /**
     * Konstruktor, der die Planungsbedingungen entgegen nimmt
     * @param bedingungen
     */
    public PruefungsPlanerAlgo1(Planungsbedingungen bedingungen) {
        super(bedingungen);
        this.planungsbedingungen =bedingungen;
    }
    

    public Pruefungsterminplan berechnePruefungsTerminPlan(Studentenliste studenten, Buchungsliste buchungen, Kursliste kurse) {
         	
    	this.studentenliste = studenten;
    	this.buchungsliste = buchungen;
    	this.kursliste = kurse;
    	
    	int tag=0;
    	
    	Kursliste ek = new Kursliste();
    	Studentenliste es = new Studentenliste();
    	
    	/*
    	 * Neuen Pruefungsterminplan erstellen und durchführen der Tagesplanungungen
    	 */
    	tag++;
    	int i=1;
    	System.out.println("===> Start der Planung <===");
    	pruefungsterminplan = new Pruefungsterminplan();
    	
    	//Alle Kurse auflisten
    	System.out.println("Folgende Kurse stehen für die Planung zur Verfügung:");
    	Iterator<Kurs>itK = this.kursliste.getKursIterator();
    	while(itK.hasNext()){
    		Kurs k = itK.next();
    		int a = buchungsliste.anzBuchungenKurs(k);
    		if(a==0){
    			//Kurse ohne Buchung
    			ek.addKurs(k);
    			System.out.println(i++ +". " + k.getTitel() + " (" + a + " Buchungen) <-- Keine Buchung (wird entfernt)");
    		} else {
    			System.out.println(i++ +". " + k.getTitel() + " (" + a + " Buchungen)");
    		}
    		
    	}  	
    	//Entfernen der Kurse ohne Buchungen von der Planung
    	itK = ek.getKursIterator();
    	while(itK.hasNext()){
    		kursliste.removeKurs(itK.next());
    	}
    	
    	System.out.println();
    	System.out.println("-> Somit werden folgende Kurse geplant:");
    	i=1;
    	itK = kursliste.getKursIterator();
    	while(itK.hasNext()){
    		System.out.println(i++ +". " + itK.next().getTitel());
    	}
    	
    	System.out.println();
    	//Alle Studenten auflisten
    	System.out.println("Folgende Studenten stehen für die Planung zur Verfügung:");
    	i=1;
    	Iterator<Student>itS = this.studentenliste.getStudentIterator();
    	while(itS.hasNext()){
    		Student s = itS.next();
    		int a = buchungsliste.anzBuchungenStudent(s);
    		if(a==0){
    			//Studenten ohne Buchung
    			es.addStudent(s);
    			System.out.println(i++ +" " + s.getVorname() +" " + s.getName() + "(" + a + " Buchungen) <-- Keine Buchung (wird entfernt)");
    		} else {
    			System.out.println(i++ +". " + s.getVorname() + " " +s.getName() + " (" + a + " Buchungen)");
    		}
    	}
    	//Entfernen der Studenten ohne Buchung
    	itS = es.getStudentIterator();
    	while(itS.hasNext()){
    		studentenliste.removeStudent(itS.next());
    	}
    	System.out.println();
    	System.out.println("-> Somit werden Kurse für folgende Studenten geplant:");
    	i=1;
    	itS = this.studentenliste.getStudentIterator();
    	while(itS.hasNext()){
    		Student s = itS.next();
    		System.out.println(i++ + ". " + s.getVorname() + " " + s.getName());
    	}
    	System.out.println();
     	
    	//Starten der Planungsläufe
    	pruefungsterminplan = erstellePruefungsplan(tag,pruefungsterminplan, kursliste);

    		
    	return pruefungsterminplan;
    }
    /**
     * Gibt den Studenten mit den meisten belegten Kursen aus der Kursliste aus
     * @param kurse
     * @return Student mit den meisten Kursen
     */
    private Student getStudentMitMaxKursen(Kursliste kurse){
    	
    	int maxKurse=0;
    	int kurseAktuellerStudent=0;
    	Student studentMaxKurse = null;
    	//Loop über alle Studenten
    	Iterator<Student>itStudent = this.studentenliste.getStudentIterator();
    	Student student=null;
    	while(itStudent.hasNext()){
    		student = itStudent.next();
        	Buchungsliste buchungen = this.buchungsliste.getBuchungen(student);
        	//Loop über alle planbaren Kurse, um nur diese Kurse in die Bewertung mit aufzunehmen 
        	Iterator<Kurs> it = kurse.getKursIterator();
        	while(it.hasNext()){
        		Kurs kurs = it.next();
        		//Überprüfen ob Student Kurs gebucht hat und anschließend Zähler erhöhen
        		if(buchungen.getBuchung(kurs.getKursid(), student.getMatrikelnr()) != null){
        			kurseAktuellerStudent++;
        		}
        	}
        	//MaxStudent zuweisen
       		if( kurseAktuellerStudent > maxKurse){
    			studentMaxKurse = student;
    			maxKurse = kurseAktuellerStudent;
    		}
        	kurseAktuellerStudent=0;
    	}

    	System.out.println("Student mit der höchsten Anzahl an Kursen: " + studentMaxKurse.getVorname()+ " " + studentMaxKurse.getName());
    	System.out.println("Anzahl seiner belegten Kurse: " + maxKurse);
		return studentMaxKurse;
    }
    
    /**
     * Gibt den Kurs mit der höchsten Teilnehmerzahl aus an dem der Student student teilnimmt
     * @param kurse
     * @param student
     * @return Kurs mit den meisten Teilnehmern
     */
    private Kurs getKursMitMaxTeilnehmern(Kursliste kurse, Student student) {
    	
    	int kursMaxBuchungen=0;
    	int anzBuchungen=0;
    	Kurs maxKurs=null;
    	Kurs aktKurs=null;
    	
    	//Loop über alle Kurse des Studenten mit Hilfe seiner Buchungen	
    	Iterator<Buchung>itBuchung = this.buchungsliste.getBuchungen(student).getIterator();
    	while(itBuchung.hasNext()){
    		Buchung buchung = itBuchung.next();
    		//Ermittlung des Kurses
    		aktKurs = buchung.getKurs();
    		//Wenn Kurs in ungeplanten Kurse ist
    		if (kurse.getKurs(aktKurs.getKursid())!=null){
    			//Ermittlung der absoluten Anzahl an Buchungen
        		anzBuchungen = buchungsliste.anzBuchungenKurs(aktKurs);
        		if(anzBuchungen > kursMaxBuchungen){
        			kursMaxBuchungen = anzBuchungen;
        			maxKurs = aktKurs;
        		}
    		}

    	}
    	System.out.println("Kurs mit der maximalen Teilnehmerzahl des max Studenten: " + maxKurs.getTitel());
    	System.out.println("Anzahl der Buchungen dieses Kurses:" + kursMaxBuchungen);
    	return maxKurs;
    }
    
    /**
     * Prüft anhand der geplanten Kurse ob Studenten die max. Anzahl an Kursen pro Tag überschritten haben und löscht
     * deren Kurse aus der Menge der noch zu planenden Kurse für diesen Tag
     * @param geplanteKurse
     * @param ungeplanteKurse
     * @return
     */
    private Kursliste getUnplanbareKurse(Kursliste geplanteKurse,Kursliste ungeplanteKurse){
    	
    	 Kursliste unplanbareKurse = new Kursliste();
    	//Loop über alle Studenten
    	Iterator<Student>itStudent = this.studentenliste.getStudentIterator();
    	while(itStudent.hasNext()){
    		
    		int anzahlPruefungenAmTag=0;
    		Student student = itStudent.next();
    		
    		//Loop über alle geplanten Kurse
    		Iterator<Kurs> itKurs = geplanteKurse.getKursIterator();
    		while(itKurs.hasNext()){
    			Kurs kurs = itKurs.next();
    			Buchung b = this.buchungsliste.getBuchung(kurs.getKursid(), student.getMatrikelnr());
    			if (b != null){
    				anzahlPruefungenAmTag++;
    			}
    		}
    		// Wenn Student maximale Anzahl an Prüfungen pro Tag schreibt
    		if(anzahlPruefungenAmTag == planungsbedingungen.getPruefungProStudentUndTag()){
    			//Loop über alle ungeplanten Kurse
    			itKurs = ungeplanteKurse.getKursIterator();
    			while(itKurs.hasNext()){
    				//Schauen ob Student Buchungen
    				Kurs kurs = itKurs.next();
    				Buchung b = this.buchungsliste.getBuchung(kurs.getKursid(), student.getMatrikelnr());
    				if(b !=null){
    					unplanbareKurse.addKurs(kurs);
    				}
    			}
    		}
    	}
    	
    	return unplanbareKurse;
    }
    
    
    /**
     * Planung aller Kurse eines Tages aus den noch ungeplanten Kursen
     * @param tag
     * @param ungeplanteKurse
     * @return Pruefungstag 
     */
    private Pruefungsterminplan erstellePruefungsplan(int tag,Pruefungsterminplan plan, Kursliste ungeplanteKurse){
    	
    	Student studentMaxKurse; //Student mit den meisten aktuellen Buchungen
    	Kurs kursMaxTeilnehmer;
    	
    	int kursNr=0;	
    	
    	if(ungeplanteKurse.getSize()>0){
    		
	    	//Liste mit zu schreibenden Prüfungen an diesem Tag
	    	Kursliste kurseAmPruefungsTag = new Kursliste();
	    	Kursliste entfernteKurse = new Kursliste();
	    	Studentenliste tagesStudentenliste = new Studentenliste();
	    	//Returnwert Prüfungstag
	    	Pruefungstag pTag = new Pruefungstag(tag);
	    	System.out.println();
	    	System.out.println("* Planungslauf für Tag: " + tag + " *");
	    	System.out.println("--------------------------------------");
	    	 	
	    	do {	    	
	    		kursNr++;
	    		System.out.println();
	    		System.out.println("==> Plane Kurs Nr " + kursNr + " des Tages " + tag);
	    		System.out.println("--------------------------------------");
	    		System.out.println("Zur Planung verbleiben noch " + ungeplanteKurse.getSize()+" Kurse");
		    	/*
		    	 * Bestimmung des Studenten mit der höchsten Anzahl an Kursen als Engpass für Planung
		    	 */
		    	studentMaxKurse = this.getStudentMitMaxKursen(ungeplanteKurse);     
		     	/*
		    	 * Bestimmung des Kurses mit der höchsten Anzahl Teilnehmern an dem der studentMaxKurse teilnimmt
		    	 */
		    	kursMaxTeilnehmer = this.getKursMitMaxTeilnehmern(ungeplanteKurse, studentMaxKurse);
		    	/*
		    	 * Hinzufügen dieses Kurses zum Pruefungstag
		    	 */
		    	kurseAmPruefungsTag.addKurs(kursMaxTeilnehmer);
		    	System.out.println("Der Kurs "+ kursMaxTeilnehmer.getKurztitel() +" wurde für den Tag an " + kursNr + ". Stelle eingeplant!");
		    	/*
		    	 * Hinzufügen der Teilnehmer zur tagesStudentenliste
		    	 */
		    	Iterator<Buchung> itBuchung = buchungsliste.getBuchungen(kursMaxTeilnehmer).getIterator();
		    	while(itBuchung.hasNext()){
		    		tagesStudentenliste.addStudent(itBuchung.next().getStudent());
		    	}
		    	/*
		    	 * Entfernen dieses Kurses aus der Planung
		    	 */
		    	ungeplanteKurse.removeKurs(kursMaxTeilnehmer);
		    	System.out.println("<- Der Kurs " + kursMaxTeilnehmer.getKurztitel() + " wurde aus den noch zu planenden Kursen entfernt!");	
		    	/*
		    	 * Entfernen aller Kurse, die für diesen Tag nicht mehr planbar sind
		    	 */
		    	Iterator<Kurs> itKurse = this.getUnplanbareKurse(kurseAmPruefungsTag, ungeplanteKurse).getKursIterator();
		    	while(itKurse.hasNext()){
		    		Kurs kurs = itKurse.next();
		    		//Zwischenspeichern der Kurse, damit sie am nächsten Tag wieder hinzugefügt werden
		    		entfernteKurse.addKurs(kurs);
		    		ungeplanteKurse.removeKurs(kurs);
		    		System.out.println("<- Entferne Kurs " + kurs.getKurztitel() + " aus den planbaren Kursen fuer aktuellen Tag da Teilnehmerkonflikt");
		    	}
	
	    	} while( kurseAmPruefungsTag.getSize() < planungsbedingungen.getPruefungProTag() && ungeplanteKurse.getSize()>0);
	    	
	    	System.out.println("==> Achtung: Die maximal mögliche Anzahl an Prüfungen des Tages ist erreicht!");
	    	System.out.println();
	    	System.out.println("Schließe den Tag ab und setze die Tageskursliste!");
	    	System.out.println();
	    	
	    	Iterator<Kurs> itKurse = entfernteKurse.getKursIterator();
	    	while(itKurse.hasNext()){
	    		Kurs k = itKurse.next();
	    		System.out.println("-> Kurs " + k.getKurztitel() +" wird wieder zur Planung hinzugefuegt (da neuer Tag)");
	    		ungeplanteKurse.addKurs(k);
	    	}
	    		    	
	    	//Setzen aller Kurse des Pruefungstages
	    	pTag.setTagesKursliste(kurseAmPruefungsTag);
	    	
	    	//Setzen aller Studenten, die an diesem Tag schreiben
	    	pTag.setTagesStudentenliste(tagesStudentenliste);
	    	
	    	
	    	//Hinzufuegen des Pruefungstages zum Pruefungsplan
	    	plan.addPruefungstag(pTag);
	    	
	    	
	    	//Rekursiver Aufruf der Methode
	    	return this.erstellePruefungsplan(tag+1, plan, ungeplanteKurse);
    	}
    	
    	return plan;
    }

}
