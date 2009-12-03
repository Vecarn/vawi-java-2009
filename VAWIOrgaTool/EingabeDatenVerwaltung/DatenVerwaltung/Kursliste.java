package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import EingabeDatenVerwaltung.DatenObjekte.Kurs;

/**
 * Verwaltungsklasse für Kurse
 * @author Markus Bode
 *
 * @poseidon-object-id [I2d0758e8m124d537380cmm7b6d]
 */
public class Kursliste {

    private Collection<Kurs> kurse = new ArrayList<Kurs>();
    /**
     * 
     * @param id
     * @param kurzname
     * @param langname
     * @param teilleistungen
     * @param maxPunkte
     * @return	true: wenn Collection geändert wurde <br>
     *			false: wenn Collection nicht geändert wurde (z.B. wenn Objekt bereits in Collection)
     */
    public boolean addKurs(int id, String kurzname, String langname, boolean teilleistungen, int maxPunkte){
    	//new Kurs(hier alle Variablen)
    	    	
    	return kurse.add(new Kurs(id));
	  
    }
    
    public Kurs getKurs(int id){
    	
    	Iterator<Kurs> kursiterator = kurse.iterator();
    		
    	while(kursiterator.hasNext()){
    		Kurs kurs = kursiterator.next();
    		if(kurs.getId() == id){
    			return kurs;
    		}
    	}
    		
    	return null;
    }
    
    /**
     * Liefert einen Iterator auf die vorhandene Kurs-Collection.
     * 
     * @return Iterator<Student> : Iterator auf Collection mit Kurs-Objekten.
     */
    
    public Iterator<Kurs> getKursIterator(){
		return kurse.iterator();	
    }
      
 }
