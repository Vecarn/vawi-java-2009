package PruefungsPlanung;

import java.util.HashMap;
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
    	 	
    	
    	/*
    	 * Neuen Pruefungsterminplan erstellen und durchführen der Tagesplanungungen
    	 */
    	tag++;
    	pruefungsterminplan = new Pruefungsterminplan();

    	 pruefungsterminplan = erstelleTagesplanung(tag,pruefungsterminplan, kurse);

    		
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
    	Iterator<Student>itStudent = studentenliste.getStudentIterator();
    	Student student=null;
    	while(itStudent.hasNext()){
    		student = itStudent.next();
        	Buchungsliste buchungen = this.buchungsliste.getBuchungen(student);
        	
        	Iterator<Kurs> it = kurse.getKursIterator();
        	while(it.hasNext()){
        		Kurs kurs = it.next();
        		if(buchungen.getBuchung(kurs.getKursid(), student.getMatrikelnr()) != null){
        			kurseAktuellerStudent++;
        		}
        	}
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
    private Pruefungsterminplan erstelleTagesplanung(int tag,Pruefungsterminplan plan, Kursliste ungeplanteKurse){
    	
    	Student studentMaxKurse; //Student mit den meisten aktuellen Buchungen
    	Kurs kursMaxTeilnehmer;
    	
    	int kursNr=0;	
    	
    	if(ungeplanteKurse.getSize()>0){
    		
	    	//Liste mit zu schreibenden Prüfungen an diesem Tag
	    	Kursliste kurseAmPruefungsTag = new Kursliste();
	    	Kursliste entfernteKurse = new Kursliste();
	    	//Returnwert Prüfungstag
	    	Pruefungstag pTag = new Pruefungstag(tag);
	    	System.out.println("* Planungslauf für Tag: " + tag + " *");
	    	 	
	    	do {
		    	
	    		kursNr++;
	    		System.out.println("==> Plane Kurs Nr " + kursNr + " des Tages");
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
		    	 * Entfernen dieses Kurses aus der Planung
		    	 */
		    	ungeplanteKurse.removeKurs(kursMaxTeilnehmer);
		    	System.out.println("Der Kurs " + kursMaxTeilnehmer.getKurztitel() + " wurde aus den noch zu planenden Kursen entfernt!");
		    	
		    	/*
		    	 * Entfernen aller Kurse, die für diesen Tag nicht mehr planbar sind
		    	 */
		    	Iterator<Kurs> itKurse = this.getUnplanbareKurse(kurseAmPruefungsTag, ungeplanteKurse).getKursIterator();
		    	while(itKurse.hasNext()){
		    		Kurs kurs = itKurse.next();
		    		//Zwischenspeichern der Kurse, damit sie am nächsten Tag wieder hinzugefügt werden
		    		entfernteKurse.addKurs(kurs);
		    		ungeplanteKurse.removeKurs(kurs);
		    		System.out.println("-> Entferne Kurs " + kurs.getKurztitel() + " aus den planbaren Kursen fuer aktuellen Tag da Teilnehmerkonflikt");
		    	}
	
	    	} while( kurseAmPruefungsTag.getSize() <= planungsbedingungen.getPruefungProTag());
	    	
	    	System.out.println("Die maximal mögliche Anzahl an Prüfungen des Tages ist erreicht!");
	    	System.out.println("Setze die Tageskursliste");
	    	
	    	Iterator<Kurs> itKurse = entfernteKurse.getKursIterator();
	    	while(itKurse.hasNext()){
	    		ungeplanteKurse.addKurs(itKurse.next());
	    	}
	    	System.out.println("Kurse wegen Teilnehmerkonflikt werden wieder hinzugefügt!");
	    	
	    	//Setzen aller Kurse des Pruefungstages
	    	pTag.setTagesKursliste(kurseAmPruefungsTag);
	    	
	    	//Hinzufuegen des Pruefungstages zum Pruefungsplan
	    	plan.addPruefungstag(pTag);
	    	
	    	//Rekursiver Aufruf der Methode
	    	return this.erstelleTagesplanung(tag+1, plan, ungeplanteKurse);
    	}
    	
    	return plan;
    }
    


    ;
}
