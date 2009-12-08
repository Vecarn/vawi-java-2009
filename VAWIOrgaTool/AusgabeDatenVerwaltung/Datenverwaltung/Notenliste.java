
package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.*;

import AusgabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenVerwaltung.*;
import Hilfsklassen.Universitaet;

/**
 * Verwaltungsklasse f&uuml;r die Noten eines 
 * Studenten und gleichzeitig Entit&auml;tstyp f&uuml;r eine Notenliste.
 * 
 * @author Martin
 * @version 0.2
 */
public class Notenliste {

    private Collection<Buchung> noten_liste;
    private Buchungsliste buchungsliste;
    

    /**
     * Der Konstruktor f�r die Notenliste. Erzeugt Objekte f�r die Notenliste
     * und die Buchungliste
     * @param buchungsliste Die Buchungsliste der allgemeinen Verwaltung wird
     * an das Objekt �bergeben.
     */
    public Notenliste(Buchungsliste buchungsliste){
    	 noten_liste = new TreeSet<Buchung>();
    	 this.buchungsliste = buchungsliste;
    }
    
	/**
	 * F�gt eine Note zur Liste hinzu
	 * 
	 * @param student Der Student, dessen Anwesenheit hinzugef�gt wird.
	 * @param uni Die Universit�t, f�r die die aktuelle Anwesenheit hinzugef�gt wird.
	 * @param kurse Ein Array mit den drei Kursen, die der Student belegen kann.
	 * @return boolean flag true oder false
	 */
	public boolean addNote(Student student){
		
		for(int i = 0; i < buchungsliste.anzBuchungenStudent(student); i++){
		
			if(noten_liste.add(
					buchungsliste.getBuchung(1, 1))){
			
				return true;
			}
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
	public Buchung getNote(){
		
		
		return new Buchung(student, kurs);
	}
	
	
	
    
    
 }
