
package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.*;
import AusgabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenObjekte.*;
import Hilfsklassen.Universitaet;

/**
 * Die Klasse "Platzkartenliste" wird für die Erzeugung der Platzkarten
 * verwendet.
 * 
 * @author Martin
 * @version 0.1
 */
public class Platzkartenliste {

	private Collection<Platzkarte> platz_liste;
	
	/**
	 * Konstruktor für die Platzkarten(liste)
	 */
	public Platzkartenliste(){
		 platz_liste = new TreeSet<Platzkarte>();
	}
	
	
	/**
	 * Fügt eine Platzkarte zur Liste hinzu
	 * 
	 * @param buchung Die Buchung für die eine Platzkarte erstellt wird
	 * @param tag Der Tag für den diese Platzkarte gilt
	 * @param uni Die Universität, für die die Platzkarte gilt
	 * @return boolean flag true oder false
	 */
	public boolean addPlatzkarte(Buchung buchung, String tag, Universitaet uni){
		
		if(platz_liste.add(new Platzkarte(buchung, tag, uni))){
		
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
	
		
		return new Platzkarte();
	}
    
 }
