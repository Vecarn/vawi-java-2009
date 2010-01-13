package PruefungsPlanung;

import java.util.Iterator;

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
    	
    	//Variablen für Algorithmus
    	Student studentMaxKurse = new Student("Max","Mustermann",0);
    	int maxKurse = 0;
    	int kurseAktuellerStudent = 0;
    	double maxTage = 0;
    	
    	//Bestimmung des Studenten mit der höchsten Anzahl an Kursen als Engpass für Planung
    	Iterator<Student> it = studentenliste.getStudentIterator();
    	while(it.hasNext()){
    		Student student = it.next();
    		kurseAktuellerStudent = buchungsliste.anzBuchungenStudent(student);
    		if( kurseAktuellerStudent > maxKurse){
    			studentMaxKurse = student;
    			maxKurse = kurseAktuellerStudent;
    		}
    	}
    	
/*    	Iterator<Buchung> it2 = buchungsliste.getIterator();
    	while(it.hasNext()){
    		Kurs kurs = it2.next();
    		kurs.
    	}*/
    	//Bestimmung der maximalen Anzahl an Pruefungstagen
    	maxTage = (maxKurse/this.getPlanungsbedingungen().getPruefungProStudentUndTag());
    	
    	System.out.println("==Student mit der höchsten Anzahl an Kursen: " + studentMaxKurse.getVorname()+ " " + studentMaxKurse.getName());
    	System.out.println("==Anzahl belegter Kurse: " + maxKurse);
    	System.out.println("==Max. Klausuren pro Student pro Tag: " + this.getPlanungsbedingungen().getPruefungProStudentUndTag());
    	System.out.println("==Ergibt mindesten " + maxTage + "Prüfungstage");
    	
    	//
    	return null;
    }

    ;
}
