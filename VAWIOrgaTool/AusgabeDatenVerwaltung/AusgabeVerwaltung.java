
package AusgabeDatenVerwaltung;
import java.util.Iterator;

import AusgabeDatenVerwaltung.Ausgabe.FlatFileSchreiber;
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
 * @version 0.1
 */
public class AusgabeVerwaltung {

    private Pruefungsterminplan pruefungsterminplan;
    private Anwesenheitsliste anwesenheitsliste;
    private Notenliste notenliste;
    private Platzkartenliste platzkartenliste;    
    private FlatFileSchreiber fileschreiber;
    private Datei datei;
    private Studentenliste studentenliste;
    private Buchungsliste buchungsliste;
    private Kursliste kursliste;
    private Iterator<Student> si;
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
    	
    	si = studentenliste.getStudentIterator();
    	bi = buchungsliste.getIterator();
    }
    
    /**
     * @return
     */
    public boolean generiereAnwesenheitsliste(){
    	
    	
    	
    	
    	while (si.hasNext()){
    		
//    		anwesenheitsliste.addAnwesenheit();
    		
    	}
    	
    	
//    	while(studentenliste.getStudentIterator().hasNext()){
//    		
//    		anwesenheitsliste.addAnwesenheit(
//    				uni, tag, studentenliste.getStudentIterator().next());
//    		
//    		
//    	}
    	
    	
    	return true;
    }
    
    
    
    /**
     * @return
     */
    public boolean generiereNotenliste() {
		
    	while(bi.hasNext()){
    		    		
    		
    		
    	}
    	
    	
    	return true;
	}
    
    /**
     * @return
     */
    public boolean generierePlatzkartenliste() {
		return true;
	}

 }
