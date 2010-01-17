
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
 * @version 1.0
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
     * public final String für die Erzeugung einer Linie in der Ausgabe
     */
    public final String line = 
		new String("---------------------------------------------\n");
    
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

    	
    	anwesenheitsliste = new Anwesenheitsliste
    							(buchungsliste,pruefungsterminplan, this);
    	
    	

    	String outputstream = new String();
    	outputstream = generiereHeader(3) + anwesenheitsliste.generiereListe();
    	//filename setzen
    	fileschreiber.setFile("anwesenheitsliste.txt");
    	//öffne das File zum Schreiben 
    	fileschreiber.openFile();
    	//string an die Ausgabeklasse senden
    	fileschreiber.writer(outputstream);
    	//File schliessen
    	fileschreiber.closeFile();
    	return true;
    }
    
    
    
    /**
     * Methode für das Erzeugen der Notenliste
     * @return true, wenn erfolgreich<br>false, wenn nicht erfolgreich
     */
    public boolean generiereNotenliste() {
    	
    	fileschreiber.setFile("notenliste.txt");
    	
    	
    	notenliste = new Notenliste(buchungsliste, this);
    	
    	//öffne das File zum Schreiben 
    	fileschreiber.openFile();
    	//string an die Ausgabeklasse senden
    	fileschreiber.writer(notenliste.erzeugeListe());
    	//File schliessen
    	fileschreiber.closeFile();
    	
    	return true;
	}
    
    /**
     * Methode für das Erzeugen der Platzkartenliste
     * @return true, wenn erfolgreich<br>false, wenn nicht erfolgreich
     */
    public boolean generierePlatzkartenliste() {
		fileschreiber.setFile("platzkarten.txt");
    	
    	
		platzkartenliste = new Platzkartenliste(buchungsliste, pruefungsterminplan, this);
		
    	String output = new String();
    	output = generiereHeader(4) + platzkartenliste.generiereListe();
		
    	//öffne das File zum Schreiben 
    	fileschreiber.openFile();
    	//string an die Ausgabeklasse senden
    	fileschreiber.writer(output);
    	//File schliessen
    	fileschreiber.closeFile();
    	
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
    	
    	//output String initialisieren
    	String output = new String();
  	    	   	
    	//header erzeugen
    	output = generiereHeader(2);
        	
    	Iterator i1 = pruefungsterminplan.getPruefungsplanIterator();
    	int tagid = 0;
    	
    	while(i1.hasNext()){
    		Pruefungstag p1 = (Pruefungstag) i1.next();
    		
    		if(p1.getTagId() != tagid){
    			output = output + "Pruefungstag " +
    					 p1.getTagId() + "\n";
    			output = output + line;
    		}
    		
    		Kursliste kl1 = p1.getTagesKursliste();
    		Iterator i2 = kl1.getKursIterator();
    		
    		while(i2.hasNext()){
    			
    			Kurs k1 = (Kurs) i2.next();
    			output = output + 
    					k1.getKurztitel() +
    					" - " + 
    					k1.getTitel() +
    					"\n";	
    		}
    		output = output + "\n\n";
    	}
    	
    	
    	//filenamen setzen
    	fileschreiber.setFile("terminplan.txt");
    	//öffne das File zum Schreiben 
    	fileschreiber.openFile();
    	//string an die Ausgabeklasse senden
    	fileschreiber.writer(output);
    	//File schliessen
    	fileschreiber.closeFile();
    	
    	return true;
    }
    
    
    /**
     * Methode zum Erzeugen der Header für die Ausgabelisten
     * @param listenID die ID wird zum Zeitpunkt der Listnerzeugung an die
     * Methode übergeben, damit der entsprechende Header erzeugt werden kann
     * <br> 1 - Notenliste
     * <br> 2 - Terminplan
     * <br> 3 - Anwesenheitsliste
     * @return String Variable, die den Header enthält
     */
    public String generiereHeader(int listenID){
    	
    	
    	String header = new String();
    	Date dt = new Date();
    	
    	
    	switch(listenID){
    	
    	case 1:
    		header = line;
    		header = header +
    				 "VAWi-Orga-Tool - Notenliste\n";
    		header = header +
    				 line;
    		break;
    		
    		
    		
    	case 2:
    		header = line;
    		header = header +
    				 "VAWi-Orga-Tool - Terminplan\n";
    		header = header +
    				 line;
    		break;
    		
    	case 3:
    		header = line;
    		header = header +
    				 "VAWi-Orga-Tool - Anwesenheitsliste\n";
    		header = header +
    				 line;
    		break;
    	case 4:
    		header = line;
    		header = header +
    				 "VAWi-Orga-Tool - Platzkartenliste\n";
    		header = header +
    				 line;
    		break;
    		
    	default:
    		break;
    	
    	}
    	
    	
    	header = header + 
    			 "Liste erzeugt am " + 
    			 dt.toGMTString() + "\n";
    	header = header + 
    			 line + 
    			 "\n\n";
    	
    	return header;
    	
    	
    }

 }
