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
    }
    


    public Pruefungsterminplan berechnePruefungsTerminPlan(Studentenliste studenten, Buchungsliste buchungen, Kursliste kurse) {
         	
    	this.studentenliste = studenten;
    	this.buchungsliste = buchungen;
    	this.kursliste = kurse;
    	
    	/*
    	 * Variable für Algorithmus
    	 */
    	Kursliste verfgbKurse; //Kursliste mit Kursen, die noch nicht verplant sind
    	Buchungsliste verfgbBuchungen; //Buchungen, die noch nicht verplant sind
    	Studentenliste verfgbStudenten; //Studenten, die noch nicht verplant sind
    	Student studentMaxKurse; //Student mit den meisten aktuellen Buchungen
    	int maxKurse = 0;//Maximale Anzahl an Kursen, die ein Student belegt hat
    	int kurseAktuellerStudent = 0; //Anzahl an Belegungen des aktuellen Studenten
    	double minTage = 0; //Erechnete mind. Anzahl an Tage, die geplant werden müssen
    	int tag=0;
    	int geplKurse=0;
    	
    	//HashMap um zu zählen wie viel Pruefungen der Student am aktuellen Tag schreibt
    	HashMap<Student,Integer> countKurseStudent = new HashMap<Student,Integer>();
    	//Initiale Befüllung der HashMap
    	Iterator<Student> itStudent = this.studentenliste.getStudentIterator();
    	while(itStudent.hasNext()){
    		countKurseStudent.put(itStudent.next(),new Integer(0));
    	}
    	
    	Kursliste kurseAmPruefungsTag = new Kursliste();
    	
    	
    	/*
    	 * 1. Neuen Pruefungsterminplan  + Pruefungstag erstellen
    	 */
    	tag++;
    	pruefungsterminplan = new Pruefungsterminplan();
    	Pruefungstag pTag = new Pruefungstag(tag);
    	
    	/*
    	 * 2. Initialwerte der Listen befüllen
    	 */
    	verfgbKurse = this.kursliste;
    	verfgbStudenten = this.studentenliste;
    	verfgbBuchungen = this.buchungsliste;
    	

    	
    	/*
    	 * 3. Bestimmung des Studenten mit der höchsten Anzahl an Kursen als Engpass für Planung
    	 */
    	studentMaxKurse = null;
    	itStudent = studentenliste.getStudentIterator();
    	while(itStudent.hasNext()){
    		Student student = itStudent.next();
    		kurseAktuellerStudent = buchungsliste.anzBuchungenStudent(student);
    		if( kurseAktuellerStudent > maxKurse){
    			studentMaxKurse = student;
    			maxKurse = kurseAktuellerStudent;
    		}
    	}
    	/*
    	 * 4. Bestimmung des Kurses mit der höchsten Anzahl Teilnehmern an dem der studentMaxKurse teilnimmt
    	 *    und Planung des Kurses in Pruefungstag
    	 */
    	int kursMaxBuchungen=0;
    	int anzBuchungen=0;
    	Kurs maxKurs=null;
    	Kurs aktKurs=null;
    	Iterator<Buchung> itBuchung = verfgbBuchungen.getBuchungen(studentMaxKurse).getIterator();
    	while(itBuchung.hasNext()){
    		Buchung buchung = itBuchung.next();
    		aktKurs = buchung.getKurs();
    		anzBuchungen = buchungsliste.anzBuchungenKurs(aktKurs);
    		if(anzBuchungen > kursMaxBuchungen){
    			kursMaxBuchungen = anzBuchungen;
    			maxKurs = aktKurs;
    		}
    	}
    	kurseAmPruefungsTag.addKurs(maxKurs);
    	
    	//Anzahl der geschriebenen Prüfungen am aktuellen Tag erhöhen
    	Iterator<Student> it = countKurseStudent.keySet().iterator();
    	while(it.hasNext()){
    		int i=0;
    		Student student = it.next();
    		if(verfgbBuchungen.getBuchung(maxKurs.getKursid(), new Integer(student.getMatrikelnr())) !=null){
    			i= countKurseStudent.get(student) + 1;
    			if (i<planungsbedingungen.getPruefungProStudentUndTag()){
    				countKurseStudent.remove(student);
        			countKurseStudent.put(student,i);
    			} else {
    				
    			}
    		
    		}
    	}
    	
    	/*
    	 * 5. Pruefung welche Stundenten an diesem Tag bereits max Kurse schreiben und entfernen dieser Kurse
    	 */
    	Kursliste delKurse = new Kursliste();
    	
    	Iterator<Kurs> itKurs = kurseAmPruefungsTag.getKursIterator();
    	while(itKurs.hasNext()){
    		Kurs kurs = itKurs.next();
    		Buchungsliste buchliste = verfgbBuchungen.getBuchungen(kurs);
    		Iterator<Buchung> it2 = buchliste.getIterator();
    		while(it2.hasNext()){
    			Buchung buchung =it2.next();
    			
    		}
    	}

    	
    	
    	
    	/*
    	 * 6. Aufrauemarbeiten
    	 */
    	//Entfernen der Buchungen des MaxKurse
    	verfgbBuchungen.removeBuchungen(maxKurs) ;
    	//Entfernen des Kurses aus verfgbKurse
    	verfgbKurse.removeKurs(maxKurs);

    	

    	//Bestimmung der maximalen Anzahl an Pruefungstagen
    	minTage = (maxKurse/this.getPlanungsbedingungen().getPruefungProStudentUndTag());
    	
    	System.out.println("==Student mit der höchsten Anzahl an Kursen: " + studentMaxKurse.getVorname()+ " " + studentMaxKurse.getName());
    	System.out.println("==Anzahl belegter Kurse: " + maxKurse);
    	System.out.println("==Max. Klausuren pro Student pro Tag: " + this.getPlanungsbedingungen().getPruefungProStudentUndTag());
    	System.out.println("==Ergibt mindesten " + minTage + "Prüfungstage");
    	
    	//
    	/*
    	 * 3. Prüfung ob Tag schon vollständig geplant ist
    	 */

    		
    	return null;
    }


    ;
}
