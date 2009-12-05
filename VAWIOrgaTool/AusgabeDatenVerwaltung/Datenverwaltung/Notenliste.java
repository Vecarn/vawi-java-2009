
package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.*;

import AusgabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenObjekte.*;
import Hilfsklassen.Universitaet;

/**
 * Verwaltungsklasse f&uuml;r die Noten eines 
 * Studenten und gleichzeitig Entit&auml;tstyp f&uuml;r eine Notenliste.
 * 
 * @author Martin
 * @version 0.1
 */
public class Notenliste {

    private Collection<Noten> noten_liste;
    
    
    /**
     * Konstruktor f�r die Notenliste
     */
    public Notenliste(){
    	 noten_liste = new TreeSet<Noten>();
    }
    
	/**
	 * F�gt eine Note zur Liste hinzu
	 * 
	 * @param student Der Student, dessen Anwesenheit hinzugef�gt wird.
	 * @param uni Die Universit�t, f�r die die aktuelle Anwesenheit hinzugef�gt wird.
	 * @param kurse Ein Array mit den drei Kursen, die der Student belegen kann.
	 * @return boolean flag true oder false
	 */
	public boolean addNote(Buchung buchung, int note){
		
		if(noten_liste.add(new Noten(buchung, note))){
		
			return true;
		}
		
		return false;
		
	}
	
	/** 
	 * Anzahl der Elemente in der Notenliste ausgeben.
	 * @return integer mit der Anzahl
	 */
	public int getCount(){
		return noten_liste.size();
	}
	
	/**
	 * Methode f�r die Ausgabe einer einzelnen Note der Liste
	 * @return Note R�ckgabewert aus der Liste
	 */
	public Noten getNote(){
		
		
		return new Noten();
	}
	
	
	
    
    
 }
