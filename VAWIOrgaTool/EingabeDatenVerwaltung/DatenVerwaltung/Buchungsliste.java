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
 * Verwaltungsklasse für Buchungen
 * 
@author Markus Bode
 */
public class Buchungsliste {
	// vllt. HashSet /TreeSet verwenden um duplicates zu vermeiden
    private Collection<Buchung> buchungen = new TreeSet<Buchung>(new BuchungsComparator());
    
    private HashMap<Kurs,Integer> buchungszahlen = new HashMap<Kurs, Integer>(); 
   
    /**
     * Fügt eine neue Buchung hinzu. 
	 * Dabei wird die Anzahl der Buchungen für einen Kurs gezählt und in einer HashMap gespeichert.
     *  
     * @param student
     * @param kurs
     * @return  true: wenn Collection geändert wurde <br>
     *			false: wenn Collection nicht geändert wurde (z.B. wenn Objekt bereits in Collection)
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
     * Liefert die Gesamtanzahl an Buchungen für einen Kurs.
     * 
     * @param kurs
     * @return Anzahl an Buchungen für einen gegebenen Kurs
     */
    public int anzBuchungenKurs(Kurs kurs){
    	return 0;
    }
    
    /**
     * Liefert die Anzahl an Kursbuchungen für einen Student.
	 * 
     * @param student
     * @return Anzahl an Buchungen für einen gegebenen Student
     */
    public int anzBuchungenStudent(Student student){
    	return 0;
    }
    
    public Iterator<Buchung> getIterator(){
		return buchungen.iterator();
    	
    }
    
    
    /**
     * Liefert Set mit der Anzahl Buchungen pro Kurs.
     * 
     * @return Set<Entry<Kurs,Integer>>
     */
    public Set<Entry<Kurs,Integer>> getBuchungszaehlerEntrySet(){
    	return buchungszahlen.entrySet();
   	 
    }
       
}
