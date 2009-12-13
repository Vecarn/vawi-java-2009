
package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.*;
import AusgabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenObjekte.*;
import Hilfsklassen.*;

/**
 * Die Klasse "Platzkartenliste" wird f�r die Erzeugung der Platzkarten
 * verwendet.
 * 
 * @author Martin
 * @version 0.1
 */
public class Platzkartenliste {

	private Collection<Buchung> platz_liste;
	
	/**
	 * Konstruktor f�r die Platzkarten(liste)
	 */
	public Platzkartenliste(){
		 platz_liste = new TreeSet<Buchung>();
	}
	
	
	/**
	 * F�gt eine Platzkarte zur Liste hinzu
	 * 
	 * @param buchung Die Buchung f�r die eine Platzkarte erstellt wird
	 * @param tag Der Tag f�r den diese Platzkarte gilt
	 * @param uni Die Universit�t, f�r die die Platzkarte gilt
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
	 * Die Platzkarte eines Studenten zur�ckgeben.
	 * 
	 * @return gibt die Platzkarte zur�ck
	 */
	public Anwesenheit getPlatzkarte(){
	
		
		return null;
	}
    
 }
