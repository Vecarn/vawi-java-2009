
package AusgabeDatenVerwaltung;
import java.util.Date;
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
 * @version 0.9
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
     * Der Verweis auf das Datei Objekt, das f�r die Ausgabe ins File zust�ndig ist
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
     * Ein Iterator f�r die Studentenliste
     */
    private Iterator<Student> si;
    /**
     * Ein Iterator f�r die Buchungen
     */
    private Iterator<Buchung> bi;
    

    
    /**
     * Konstruktor fuer die Klasse Ausgabeverwaltung
     * @param studentenliste Die im System vorhandene Studentenliste, die
     * im System zur Verf�gung steht.
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
     * Methode f�r das Erzeugen der Anwesenheitsliste
     * @return true, wenn erfolgreich<br>false, wenn nicht erfolgreich
     */
    public boolean generiereAnwesenheitsliste(){
    	fileschreiber.writer("");
    	
    	return true;
    }
    
    
    
    /**
     * Methode f�r das Erzeugen der Notenliste
     * @return true, wenn erfolgreich<br>false, wenn nicht erfolgreich
     */
    public boolean generiereNotenliste() {
    	
    	notenliste = new Notenliste(buchungsliste, this);
    	
    	//�ffne das File zum Schreiben 
    	fileschreiber.openFile();
    	//sting an die Ausgabeklasse senden
    	fileschreiber.writer(notenliste.erzeugeListe());
    	//File schliessen
    	fileschreiber.closeFile();
    	
    	return true;
	}
    
    /**
     * Methode f�r das Erzeugen der Platzkartenliste
     * @return true, wenn erfolgreich<br>false, wenn nicht erfolgreich
     */
    public boolean generierePlatzkartenliste() {
    	fileschreiber.writer("");
    	
    	return true;
	}
    
    
    /**
     * Methode f�r das Erzeugen der Zufriedenheitsliste
     * @return true, wenn erfolgreich<br>false, wenn nicht erfolgreich
     */
    public boolean generiereZufriefenheitsliste(){
    	fileschreiber.writer("");
    	
    	return true;
    }
    
    /**
     * Methode f�r das Erzeugen der Ausgabe eines Terminplanes
     * @return true, wenn erfolgreich<br>false, wenn nicht erfolgreich
     */
    public boolean generiereTerminplan(){
    	
//    	String output = new String();
    	
//    	Iterator i1 = pruefungsterminplan.getPruefungsplanIterator();
//    	while(i1.hasNext()){
//    		Pruefungstag p = (Pruefungstag) i1.next();
//    		output = output + "Tag " + p.getTagId() + ": \n\r";
//    		output = output + "------------------------------ \n\r";
//    		
//    		Iterator i2 = p.getTagesKursliste().getKursIterator();
//    		while(i2.hasNext()){
//    			
//    			Kurs k = (Kurs) i2.next();
//    			
//    			output = output + k.getKursid() + " - " 
//    					+ k.getKurztitel() + "\n\r";
//    			
//    		}
//    	}
//    	
//    	
//    	fileschreiber.writer(output);
    	
    	return true;
    }
    
    /**
     * Methode zum Erzeugen der Header f�r die Ausgabelisten
     * @param listenID die ID wird zum Zeitpunkt der Listnerzeugung an die
     * Methode �bergeben, damit der entsprechende Header erzeugt werden kann
     * @return String Variable, die den Header enth�lt
     */
    public String generiereHeader(int listenID){
    	String header = new String();
    	Date dt = new Date();
    	
    	
    	switch(listenID){
    	
    	case 1:
    		header = "------------------------------------\n";
    		header = header +
    				 "VAWi-Orga-Tool - Notenliste\n";
    		header = header +
    				 "------------------------------------\n";
    		
    		
    		
    	case 2:
    		
    	case 3:
    		
    	default:
    	
    	}
    	
    	
    	header = header + 
    			 "Liste erzeugt am " + 
    			 dt.toGMTString() + "\n";
    	header = header + 
    			 "------------------------------------\n";
    	
    	return header;
    	
    	
    }

 }
