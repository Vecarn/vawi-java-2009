
package AusgabeDatenVerwaltung;
import java.util.Iterator;

import AusgabeDatenVerwaltung.Ausgabe.FlatFileSchreiber;
import AusgabeDatenVerwaltung.DatenObjekte.Pruefungstag;
import AusgabeDatenVerwaltung.Datenverwaltung.*;
import EingabeDatenVerwaltung.DatenVerwaltung.*;
import EingabeDatenVerwaltung.DatenObjekte.*;
import Hilfsklassen.Datei;

/**
 * Dies AusgabeVerwaltung ist eine 
 * Verwaltungsklasse, welche alle Ausgaben-Entit&auml;ten 
 * setzen und zur&uuml;ckgeben kann. Sie dient dazu, 
 * die Logik der Bef&uuml;llung der Datenklassen von der
 * Logik der eigentlichen Ausgabe der Daten zu trennen, 
 * mit dem Ziel redundante Logik f&uuml;r unterschiedliche
 * Ausgabeformen zu vermeiden..
 * 
 * @author Martin
 * @version 0.6
 */
/**
 * @author Martin
 * @version 0.8
 *
 */
public class AusgabeVerwaltung {

    /**
     * Der Pruefungsterminplan, der generiert wurde
     */
    private Pruefungsterminplan pruefungsterminplan;
    /**
     * Die Anwesenheitsliste
     */
    private Anwesenheitsliste anwesenheitsliste;
    /**
     * Die Notenliste
     */
    private Notenliste notenliste;
    /**
     * Die Platzkartenliste
     */
    private Platzkartenliste platzkartenliste;    
    /**
     * Der FlatFileSchreiber, der die Ausgabestreams zusammenstellt
     */
    private FlatFileSchreiber fileschreiber;
    /**
     * Der Verweis auf das Datei Objekt, das für die Ausgabe ins File zuständig ist
     */
    private Datei datei;
    /**
     * Die im System verwaltete Studentenliste
     */
    private Studentenliste studentenliste;
    /**
     * Die im System verwaltete Buchungsliste
     */
    private Buchungsliste buchungsliste;
    /**
     * Die im System verwaltet Kursliste
     */
    private Kursliste kursliste;
    /**
     * Ein Iterator für die Studentenliste
     */
    private Iterator<Student> si;
    /**
     * Ein Iterator für die Buchungen
     */
    private Iterator<Buchung> bi;
    

    
    /**
     * Konstruktor fuer die Klasse Ausgabeverwaltung
     * @param studentenliste Die im System vorhandene Studentenliste, die
     * im System zur Verfügung steht.
     * @param pruefungsterminplan Der Pruefungsterminplan, der 
     * zusammengestellt wurde
     * @param kursliste Die Kursliste, mit den im System verwalteten Kursen
     * @param buchungsliste Die Buchungsliste mit den im System 
     * vorhandenen Buchungen
     */
    public AusgabeVerwaltung(Studentenliste studentenliste, 
    		Pruefungsterminplan pruefungsterminplan, Kursliste kursliste,
    		Buchungsliste buchungsliste){
    	
    	fileschreiber = new FlatFileSchreiber(this);
    	this.studentenliste = studentenliste;
    	this.buchungsliste = buchungsliste;
    	this.studentenliste = studentenliste;
    	this.kursliste = kursliste;
    	this.pruefungsterminplan = pruefungsterminplan;
    	
    	si = studentenliste.getStudentIterator();
    	bi = buchungsliste.getIterator();
    }
    
    /**
     * Methode für das Erzeugen der Anwesenheitsliste
     * @return true, wenn erfolgreich<br>false, wenn nicht erfolgreich
     */
    public boolean generiereAnwesenheitsliste(){
    	fileschreiber.writer("");
    	
    	return true;
    }
    
    
    
    /**
     * Methode für das Erzeugen der Notenliste
     * @return true, wenn erfolgreich<br>false, wenn nicht erfolgreich
     */
    public boolean generiereNotenliste() {
    	
    	String output = new String();
    	
    	Iterator i1 = buchungsliste.getIterator();
    	
    	int kursid = 0;
    	
    	while(i1.hasNext()){
    		Buchung b = (Buchung) i1.next();
    		if(kursid != b.getKurs().getKursid()){
    			output = output + "Kurs " 
    					+ b.getKurs().getKursid() +
    					" - " + b.getKurs().getKurztitel() + "\n\r";
    		}
    		
    		output = output + b.getStudent().getName() + ", "
    					+ b.getStudent().getVorname();
    		
    		if(b.getKurs().getHatTeilleistungen() == true){
    			output = output + ":" + b.getErreichtePunkte();
    		}
    		
    		output = output + "\n\r";
    		
    		
    		kursid =  b.getKurs().getKursid();
    	}
    	
    	
    	
    	
    	fileschreiber.writer(output);
    	
    	return true;
	}
    
    /**
     * Methode für das Erzeugen der Platzkartenliste
     * @return true, wenn erfolgreich<br>false, wenn nicht erfolgreich
     */
    public boolean generierePlatzkartenliste() {
    	fileschreiber.writer("");
    	
    	return true;
	}
    
    
    /**
     * Methode für das Erzeugen der Zufriedenheitsliste
     * @return true, wenn erfolgreich<br>false, wenn nicht erfolgreich
     */
    public boolean generiereZufriefenheitsliste(){
    	fileschreiber.writer("");
    	
    	return true;
    }
    
    /**
     * Methode für das Erzeugen der Ausgabe eines Terminplanes
     * @return true, wenn erfolgreich<br>false, wenn nicht erfolgreich
     */
    public boolean generiereTerminplan(){
    	
    	String output = new String();
    	
    	Iterator i1 = pruefungsterminplan.getPruefungsplanIterator();
    	while(i1.hasNext()){
    		Pruefungstag p = (Pruefungstag) i1.next();
    		output = output + "Tag " + p.getTagId() + ": \n\r";
    		output = output + "------------------------------ \n\r";
    		
    		Iterator i2 = p.getTagesKursliste().getKursIterator();
    		while(i2.hasNext()){
    			
    			Kurs k = (Kurs) i2.next();
    			
    			output = output + k.getKursid() + " - " 
    					+ k.getKurztitel() + "\n\r";
    			
    		}
    	}
    	
    	
    	fileschreiber.writer(output);
    	
    	return true;
    }

 }
