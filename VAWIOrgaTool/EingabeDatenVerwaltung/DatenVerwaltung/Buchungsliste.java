package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

import EingabeDatenVerwaltung.DatenObjekte.*;


/**
 * Verwaltungsklasse f�r Buchungen
 * 
@author Markus Bode
 */
public class Buchungsliste {
	// vllt. HashSet /TreeSet verwenden um duplicates zu vermeiden
    private Collection<Buchung> buchungen = new TreeSet<Buchung>(new BuchungsComparator());
    
    private HashMap<Kurs,Integer> buchungszahlen = new HashMap<Kurs, Integer>(); 
   
    /**
     * F�gt eine neue Buchung zu einem TreeSet hinzu. Doppelte Buchungen (identischer Kurs und Student) sind ausgeschlossen.
     *  
	 * Dabei wird die Anzahl der Buchungen f�r einen Kurs gez�hlt und in einer HashMap gespeichert.
     *  
     * @param student
     * @param kurs
     * @return  true: wenn Collection ge�ndert wurde <br>
     *			false: wenn Collection nicht ge�ndert wurde (z.B. wenn Objekt bereits in Collection)
     */
    public boolean addBuchung(Student student, Kurs kurs, short erreichtePunkte){
		    	
    	if(buchungszahlen.containsKey(kurs)){
    		buchungszahlen.put(kurs, new Integer((buchungszahlen.get(kurs).intValue())+1));
    	}else{
    		buchungszahlen.put(kurs, new Integer(1));
    	}
    	
    	Buchung buchung = new Buchung(student,kurs);
    	
    	if(buchungen.add(buchung)){
    		buchung.setErreichtePunkte(erreichtePunkte);
    		return true;
    	}
    	
    	return false;
    			    	
    }
    
    /**
     * Liefert die Gesamtanzahl an Buchungen f�r einen Kurs.
     * 
     * @param kurs
     * @return Anzahl an Buchungen f�r einen gegebenen Kurs
     */
    public int anzBuchungenKurs(Kurs kurs){
    	return 0;
    }
    
    /**
     * Liefert die Anzahl an Kursbuchungen f�r einen Student.
	 * 
     * @param student
     * @return Anzahl an Buchungen f�r einen gegebenen Student
     */
    public int anzBuchungenStudent(Student student){
    	return 0;
    }
    /**
     * Liefert einen Iterator �ber Elemente die durch die Verwaltungsklasse verwaltet werden.<br>
     * Die einzelnen Buchungen sind nach der Kurs-ID aufsteigend sortiert.
     * 
     * @return Iterator: �ber alle Buchungs-Objekte.
     */
    public Iterator<Buchung> getIterator(){
		return buchungen.iterator();
    	
    }
    
    
    /**
     * Liefert Set mit der Anzahl Buchungen pro Kurs.<br>
     * Ein Eintrag besteht aus KEY (Kurs) und Value (Anzahl Buchungen).
     * 
     * @return Set: Repr�sentierung der Inhalte des Buchungszaehlers als Set.
     */
    public Set<Entry<Kurs,Integer>> getBuchungszaehlerEntrySet(){
    	return buchungszahlen.entrySet();
   	 
    }
    /**
     * Liefert die Anzahl der existierenden Buchungs-Elemente.
     * 
     * @return int: Anzahl Buchungen
     */
    public int getSize(){
    	return buchungen.size();
    }
       
}
