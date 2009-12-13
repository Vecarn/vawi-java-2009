
package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.*;
import AusgabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenObjekte.*;
import Hilfsklassen.*;

/**
 * Die Klasse "Platzkartenliste" wird für die Erzeugung der Platzkarten
 * verwendet.
 * 
 * @author Martin
 * @version 0.1
 */
public class Platzkartenliste {

	private Collection<Buchung> platz_liste;
	
	/**
	 * Konstruktor für die Platzkarten(liste)
	 */
	public Platzkartenliste(){
		 platz_liste = new TreeSet<Buchung>();
	}
	
	
	/**
	 * Fügt eine Platzkarte zur Liste hinzu
	 * 
	 * @param buchung Die Buchung für die eine Platzkarte erstellt wird
	 * @param tag Der Tag für den diese Platzkarte gilt
	 * @param uni Die Universität, für die die Platzkarte gilt
	 * @return boolean flag true oder false
	 */
	public boolean addPlatzkarte(Buchung buchung, String tag, Uni uni){
		
		if(platz_liste.add(buchung)){
		
			return true;
		}
		
		return false;
		
		
		
	}
    
	/** Elementanzahl ausgeben
	 * @return integer mit der Anzahl
	 */
	public int getCount(){
		return platz_liste.size();
	}
	
	/**
	 * Die Platzkarte eines Studenten zurückgeben.
	 * 
	 * @return gibt die Platzkarte zurück
	 */
	public Anwesenheit getPlatzkarte(){
	
		
		return null;
	}
    
 }
