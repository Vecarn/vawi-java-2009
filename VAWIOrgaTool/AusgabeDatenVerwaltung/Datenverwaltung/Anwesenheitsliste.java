
package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.Collection;
import java.util.TreeSet;

import AusgabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenObjekte.*;
import Hilfsklassen.*;

/**
 * Verwaltungsklasse f&uuml;r die Anwesenheiten 
 * und gleichzeitig Entit&auml;tstyp f&uuml;r eine Anwesenheitsliste.
 * 
 * @author Martin
 * @version 0.1
 */
public class Anwesenheitsliste {

	private Collection<Anwesenheit> anw_liste;
	
	/**
	 * Konstruktor für die Anwesenheitsliste
	 */
	public Anwesenheitsliste(){
		 anw_liste = new TreeSet<Anwesenheit>();
	}
	
	
	/**
	 * Fügt eine Anwesenheit zur Liste hinzu
	 * 
	 * @param student Der Student, dessen Anwesenheit hinzugefügt wird.
	 * @param uni Die Universität, für die die aktuelle Anwesenheit hinzugefügt wird.
	 * @param kurse Ein Array mit den drei Kursen, die der Student belegen kann.
	 * @return boolean flag true oder false
	 */
	public boolean addAnwesenheit(Student student, Universitaet uni, 
			Kurs[] kurse){
		
		if(anw_liste.add(new Anwesenheit(student, uni, kurse))){
		
			return true;
		}
		
		return false;
		
		
		
	}
    
	/** Elementanzahl ausgeben
	 * @return integer mit der Anzahl
	 */
	public int getCount(){
		return anw_liste.size();
	}
	
	/**
	 * Die Anwesenheit eines Studenten zurückgeben.
	 * 
	 * @return gibt die Anwesenheit zurück
	 */
	public Anwesenheit getAnwesenheit(){
	
		
		return new Anwesenheit();
	}
	
	
    
	
    
 }
