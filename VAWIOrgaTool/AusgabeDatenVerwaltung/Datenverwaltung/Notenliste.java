
package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.*;

import AusgabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenVerwaltung.*;

/**
 * Verwaltungsklasse f&uuml;r die Noten eines 
 * Studenten und gleichzeitig Entit&auml;tstyp f&uuml;r eine Notenliste.
 * 
 * @author Martin
 * @version 0.3
 */
public class Notenliste {


    private Buchungsliste buchungsliste;
    

    /**
     * Der Konstruktor für die Notenliste. Erzeugt Objekte für die Notenliste
     * und die Buchungliste
     * @param buchungsliste Die Buchungsliste der allgemeinen Verwaltung wird
     * an das Objekt übergeben.
     */
    public Notenliste(Buchungsliste buchungsliste){
    	 this.buchungsliste = buchungsliste;
    }
    
	/**
	 * Fügt eine Note zur Liste hinzu
	 * 
	 * @param student Der Student, dessen Anwesenheit hinzugefügt wird.
	 * @return boolean flag true oder false
	 */
	public boolean addNote(Student student){
		
	
		return false;
		
	}
	
	/** 
	 * Anzahl der Elemente in der Notenliste ausgeben.
	 * @return integer mit der Anzahl
	 */
	public int getCount(){
		return buchungsliste.getSize();
	}
	
	/**
	 * Methode für die Ausgabe einer einzelnen Note der Liste
	 * @return Note Rückgabewert aus der Liste
	 */
	public Buchung getNote(){
		
		
		return null;
	}
	
	
	
    
    
 }
