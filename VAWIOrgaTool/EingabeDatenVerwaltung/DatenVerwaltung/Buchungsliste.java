package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import EingabeDatenVerwaltung.DatenObjekte.*;


/**
 * Verwaltungsklasse f�r Buchungen
 * 
@author Markus Bode
 */
public class Buchungsliste {

    private Collection<Buchung> buchungen = new ArrayList<Buchung>();
    
    private HashMap<Kurs,Long> buchungszahlen = new HashMap<Kurs, Long>(); 
   
    /**
     * F�gt eine neue Buchung hinzu. 
	 * Dabei wird die Anzahl der Buchungen f�r einen Kurs gez�hlt und in einer HashMap gespeichert.
     *  
     * @param student
     * @param kurs
     * @return  true: wenn Collection ge�ndert wurde <br>
     *			false: wenn Collection nicht ge�ndert wurde (z.B. wenn Objekt bereits in Collection)
     */
    public boolean addBuchung(Student student, Kurs kurs){
		    	
    	if(buchungszahlen.containsKey(kurs)){
    		buchungszahlen.put(kurs, new Long((buchungszahlen.get(kurs).longValue())+1));
    	}else{
    		buchungszahlen.put(kurs, new Long(1));
    	}
    
    	return buchungen.add(new Buchung(kurs,student));
		    	
    }
    
    /**
     * Liefert die Gesamtanzahl an Buchungen f�r einen Kurs.
     * 
     * @param kurs
     * @return Anzahl an Buchungen f�r einen gegebenen Kurs
     */
    public long anzBuchungenKurs(Kurs kurs){
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
    
    public Iterator<Buchung> getIterator(){
		return buchungen.iterator();
    	
    }
    
    
    /**
     * Liefert Set mit der Anzahl Buchungen pro Kurs.
     * 
     * @return Set<Entry<Kurs,Long>>
     */
    public Set<Entry<Kurs,Long>> getBuchungszaehlerEntrySet(){
    	return buchungszahlen.entrySet();
   	 
    }
       
}
