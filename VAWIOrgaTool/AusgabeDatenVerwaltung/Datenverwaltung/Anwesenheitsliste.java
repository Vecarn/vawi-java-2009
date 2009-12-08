
package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.Collection;
import java.util.TreeSet;

import AusgabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenVerwaltung.*;
import Hilfsklassen.*;

/**
 * Verwaltungsklasse f&uuml;r die Anwesenheiten 
 * und gleichzeitig Entit&auml;tstyp f&uuml;r eine Anwesenheitsliste.
 * 
 * @author Martin
 * @version 0.2
 */
public class Anwesenheitsliste {

	private Collection<Anwesenheit> anw_liste;
	private Buchungsliste buchungsliste;
	
	
	/**
	 * Konstruktor f�r die Anwesenheitsliste. Erzeugt ein neues TreeSet f�r die
	 * Liste der Anwesenheiten und gibt an die lokale Variable buchungsliste
	 * den Verweis auf die allgemeine Buchungsliste zur�ck.
	 * @param buchungsliste Die Buchungsliste, die im System gef�hrt wird.
	 */
	public Anwesenheitsliste(Buchungsliste buchungsliste){
		 anw_liste = new TreeSet<Anwesenheit>();
		 this.buchungsliste = buchungsliste;
	}
	
	
	/**
	 * F�gt eine Anwesenheit zur Liste hinzu
	 * 
	 * @param student Der Student, dessen Anwesenheit hinzugef�gt wird.
	 * @param uni Die Universit�t, f�r die die aktuelle Anwesenheit hinzugef�gt wird.
	 * @param tag Ein Integer Wert, der den Pruefungstag angibt.
	 * @return boolean flag true oder false
	 */
	public boolean addAnwesenheit(Universitaet uni, int tag, Student student){
		
		for(int i = 0; i < buchungsliste.anzBuchungenStudent(student); i++){
		
			//Beispiel f�r den Aufruf
			buchungsliste.getBuchung(1, student.getMatrikelnr());			
//		if(anw_liste.add(new Anwesenheit(Universtitaet uni, int tag){
//		
//			return true;
//		}
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
	 * Die Anwesenheit eines Studenten zur�ckgeben.
	 * 
	 * @return gibt die Anwesenheit zur�ck
	 */
	public Anwesenheit getAnwesenheit(){
	
		
		return new Anwesenheit();
	}
	
	
    
	
    
 }
