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
 * @version 2.6
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
     * @param bedingungen als Randbedingungen zur Pr�fungsplanung
     */
    public PruefungsPlanerAlgo1(Planungsbedingungen bedingungen) {
        super(bedingungen);
        this.planungsbedingungen =bedingungen;
    }
    

    public Pruefungsterminplan berechnePruefungsTerminPlan(Studentenliste studenten, Buchungsliste buchungen, Kursliste kurse) {
        //===> Einsprungspunkt f�r Pr�fungsplanung

    	this.studentenliste = studenten; //Alle Studenten
    	this.buchungsliste = buchungen;  //Alle Buchungen
    	this.kursliste = kurse;          //Alle Kurse
    	
    	int tag=0; //Planungstag als fortlaufende Nummer
    	
    	Kursliste ek = new Kursliste(); //Kursliste mit Kursen ohne Buchung
    	Studentenliste es = new Studentenliste(); //Studentenliste mit Studenten ohne Buchung
    	
    	/*
    	 * Neuen Pruefungsterminplan erstellen und durchf�hren der Tagesplanungungen
    	 */
    	tag++;
    	int i=1; //f�r Nummerierung von Studenten und Kursen
    	System.out.println("===> Start der Planung <===");
    	pruefungsterminplan = new Pruefungsterminplan();
    	
    	//Alle Kurse auflisten
    	System.out.println("Folgende Kurse stehen f�r die Planung zur Verf�gung:");
    	//Loop mit Iterator �ber alle Kurse
    	Iterator<Kurs>itK = this.kursliste.getKursIterator();
    	while(itK.hasNext()){
    		Kurs k = itK.next();
    		int a = buchungsliste.anzBuchungenKurs(k);
    		if(a==0){
    			//Kurse ohne Buchung werden zwischengespeichert und anschlie�end entfernt,
    			//da irrelevant f�r Planung
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
    	//Auflisten der Kurse, die eingplant werden
    	itK = kursliste.getKursIterator();
    	while(itK.hasNext()){
    		System.out.println(i++ +". " + itK.next().getTitel());
    	}
    	
    	//Das gleiche wie f�r die Kurse f�r die Studenten ohne Buchung
    	System.out.println();
    	//Alle Studenten auflisten
    	System.out.println("Folgende Studenten stehen f�r die Planung zur Verf�gung:");
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
    	System.out.println("-> Somit werden Kurse f�r folgende Studenten geplant:");
    	i=1;
    	itS = this.studentenliste.getStudentIterator();
    	while(itS.hasNext()){
    		Student s = itS.next();
    		System.out.println(i++ + ". " + s.getVorname() + " " + s.getName());
    	}
    	System.out.println();
     	
    	//Starten der Planungsl�ufe
    	pruefungsterminplan = erstellePruefungsplan(tag,pruefungsterminplan, kursliste);

    		
    	return pruefungsterminplan;
    }
    
    /**
     * Methode plant rekursiv alle ungeplanteKurse
     * Sie h�lt alle Regeln der Planungsbedingungen ein und versucht dabei eine m�glichst kurze
     * Pr�fungsperiode zu erreichen.
     * @param tag ist der Starttag
     * @param ungeplanteKurse Kurse, die noch eingeplant werden k�nnen
     * @return Pruefungsterminplan der die komplette Planung beeinhaltet 
     */
    private Pruefungsterminplan erstellePruefungsplan(int tag,Pruefungsterminplan plan, Kursliste ungeplanteKurse){
    	/*
    	 * Der Algorithmus geht nach dem Prinzip der Engpassfindung und Eliminierung des Engpasses vor.
    	 * Der Ablauf l�sst sich wie folgt skizzieren:
    	 * 1. Ermittlung des Studenten mit den meisten noch zu schreibenden Kursen
    	 * 2. Ermittlung der Kurse dieses Studenten mit den meisten Buchungen
    	 * 3. Hinzuf�gen des Kurses zur Planung
    	 * 4. Pr�fung ob lt. Planungsbedingungen noch weitere Kurse geplant werden k�nnen
    	 * 5. Rekursiver Aufruf und start von 1.
    	 */
    	Student studentMaxKurse; //Student mit den meisten aktuellen Buchungen
    	Kurs kursMaxTeilnehmer;  //Kurs des Studenten mit den meisten Buchungen
    	
    	int kursNr=0; //fld. Kursnummer des Tages	
    	
    	//Wenn noch Kurse zur Planung vorhanden
    	if(ungeplanteKurse.getSize()>0){
    		
	    	//Liste mit zu schreibenden Pr�fungen an diesem Tag
	    	Kursliste kurseAmPruefungsTag = new Kursliste();
	    	Kursliste entfernteKurse = new Kursliste();
	    	Studentenliste tagesStudentenliste = new Studentenliste();
	    	//Returnwert Pr�fungstag
	    	Pruefungstag pTag = new Pruefungstag(tag);
	    	System.out.println();
	    	System.out.println("* Planungslauf f�r Tag: " + tag + " *");
	    	System.out.println("--------------------------------------");
	    	 	
	    	//Schleife bis Tag komplett geplant ist
	    	do {	    	
	    		kursNr++;
	    		System.out.println();
	    		System.out.println("==> Plane Kurs Nr " + kursNr + " des Tages " + tag);
	    		System.out.println("--------------------------------------");
	    		System.out.println("Zur Planung verbleiben noch " + ungeplanteKurse.getSize()+" Kurse");
		    	/*
		    	 * Bestimmung des Studenten mit der h�chsten Anzahl an Kursen als Engpass f�r Planung
		    	 */
		    	studentMaxKurse = this.getStudentMitMaxKursen(ungeplanteKurse);     
		     	/*
		    	 * Bestimmung des Kurses mit der h�chsten Anzahl Teilnehmern an dem der studentMaxKurse teilnimmt
		    	 */
		    	kursMaxTeilnehmer = this.getKursMitMaxTeilnehmern(ungeplanteKurse, studentMaxKurse);
		    	/*
		    	 * Hinzuf�gen dieses Kurses zum Pruefungstag
		    	 */
		    	kurseAmPruefungsTag.addKurs(kursMaxTeilnehmer);
		    	System.out.println("Der Kurs "+ kursMaxTeilnehmer.getKurztitel() +" wurde f�r den Tag an " + kursNr + ". Stelle eingeplant!");
		    	/*
		    	 * Hinzuf�gen der Teilnehmer zur tagesStudentenliste
		    	 */
		    	Iterator<Buchung> itBuchung = buchungsliste.getBuchungen(kursMaxTeilnehmer).getIterator();
		    	while(itBuchung.hasNext()){
		    		tagesStudentenliste.addStudent(itBuchung.next().getStudent());
		    	}
		    	/*
		    	 * Entfernen dieses Kurses aus der Gesamtplanung
		    	 */
		    	ungeplanteKurse.removeKurs(kursMaxTeilnehmer);
		    	System.out.println("<- Der Kurs " + kursMaxTeilnehmer.getKurztitel() + " wurde aus den noch zu planenden Kursen entfernt!");	
		    	/*
		    	 * Entfernen aller Kurse, die f�r diesen Tag nicht mehr planbar sind aus der Tagesplanung
		    	 */
		    	Iterator<Kurs> itKurse = this.getUnplanbareKurse(kurseAmPruefungsTag, ungeplanteKurse).getKursIterator();
		    	while(itKurse.hasNext()){
		    		Kurs kurs = itKurse.next();
		    		//Zwischenspeichern der Kurse, damit sie am n�chsten Tag wieder hinzugef�gt werden
		    		entfernteKurse.addKurs(kurs);
		    		ungeplanteKurse.removeKurs(kurs);
		    		System.out.println("<- Entferne Kurs " + kurs.getKurztitel() + " aus den planbaren Kursen fuer aktuellen Tag da Teilnehmerkonflikt");
		    	}
	
	    	} while( kurseAmPruefungsTag.getSize() < planungsbedingungen.getPruefungProTag() && ungeplanteKurse.getSize()>0);
	    	
	    	System.out.println("==> Achtung: Die maximal m�gliche Anzahl an Pr�fungen des Tages ist erreicht!");
	    	System.out.println();
	    	System.out.println("Schlie�e den Tag ab und setze die Tageskursliste!");
	    	System.out.println();
	    	
	    	//Entfernte Kurse der Tagesplanung werden f�r die Planung des n�chsten Tages wieder hinzugef�gt
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
    
    /**
     * Gibt den Studenten mit den meisten belegten Kursen aus der Kursliste aus
     * @param kurse
     * @return Student mit den meisten Kursen
     */
    private Student getStudentMitMaxKursen(Kursliste kurse){
    	
    	int maxKurse=0;
    	int kurseAktuellerStudent=0;
    	Student studentMaxKurse = null;
    	//Loop �ber alle Studenten
    	Iterator<Student>itStudent = this.studentenliste.getStudentIterator();
    	Student student=null;
    	while(itStudent.hasNext()){
    		student = itStudent.next();
        	Buchungsliste buchungen = this.buchungsliste.getBuchungen(student);
        	//Loop �ber alle planbaren Kurse, um nur diese Kurse in die Bewertung mit aufzunehmen 
        	Iterator<Kurs> it = kurse.getKursIterator();
        	while(it.hasNext()){
        		Kurs kurs = it.next();
        		//�berpr�fen ob Student Kurs gebucht hat und anschlie�end Z�hler erh�hen
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

    	System.out.println("Student mit der h�chsten Anzahl an Kursen: " + studentMaxKurse.getVorname()+ " " + studentMaxKurse.getName());
    	System.out.println("Anzahl seiner belegten Kurse: " + maxKurse);
		return studentMaxKurse;
    }
    
    /**
     * Gibt den Kurs mit der h�chsten Teilnehmerzahl aus an dem der Student student teilnimmt
     * @param kurse
     * @param student
     * @return Kurs mit den meisten Teilnehmern
     */
    private Kurs getKursMitMaxTeilnehmern(Kursliste kurse, Student student) {
    	
    	int kursMaxBuchungen=0;
    	int anzBuchungen=0;
    	Kurs maxKurs=null;
    	Kurs aktKurs=null;
    	
    	//Loop �ber alle Kurse des Studenten mit Hilfe seiner Buchungen	
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
     * Pr�ft anhand der geplanten Kurse ob Studenten die max. Anzahl an Kursen pro Tag �berschritten haben und l�scht
     * deren Kurse aus der Menge der noch zu planenden Kurse f�r diesen Tag
     * @param geplanteKurse
     * @param ungeplanteKurse
     * @return
     */
    private Kursliste getUnplanbareKurse(Kursliste geplanteKurse,Kursliste ungeplanteKurse){
    	
    	 Kursliste unplanbareKurse = new Kursliste();
    	//Loop �ber alle Studenten zur Kontrolle der Anzahl Pr�fungen am Tag
    	Iterator<Student>itStudent = this.studentenliste.getStudentIterator();
    	while(itStudent.hasNext()){
    		
    		int anzahlPruefungenAmTag=0;
    		Student student = itStudent.next();
    		
    		//Loop �ber alle geplanten Kurse der Tagesplanung
    		Iterator<Kurs> itKurs = geplanteKurse.getKursIterator();
    		while(itKurs.hasNext()){
    			Kurs kurs = itKurs.next();
    			Buchung b = this.buchungsliste.getBuchung(kurs.getKursid(), student.getMatrikelnr());
    			//Wenn Student an einem der Kurse teilnimmt, dann erh�hen der anzahlPruefungenAmTag
    			if (b != null){
    				anzahlPruefungenAmTag++;
    			}
    		}
    		// Wenn Student maximale Anzahl an Pr�fungen pro Tag schreibt
    		if(anzahlPruefungenAmTag == planungsbedingungen.getPruefungProStudentUndTag()){
    			//Loop �ber alle ungeplanten Kurse
    			itKurs = ungeplanteKurse.getKursIterator();
    			while(itKurs.hasNext()){
    				//Schauen ob Student Buchungen
    				Kurs kurs = itKurs.next();
    				Buchung b = this.buchungsliste.getBuchung(kurs.getKursid(), student.getMatrikelnr());
    				//Wenn ja, dann Kurs in unplanbare Kurse aufnehmen
    				if(b !=null){
    					unplanbareKurse.addKurs(kurs);
    				}
    			}
    		}
    	}
    	
    	return unplanbareKurse;
    }
    

}
