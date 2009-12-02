package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;
import EingabeDatenVerwaltung.DatenObjekte.Kurs;

/**
 * Verwaltungsklasse für Kurse
 * @author Markus Bode
 *
 * @poseidon-object-id [I2d0758e8m124d537380cmm7b6d]
 */
public class Kursliste {
/**
 * 
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm7a6a]
 * @poseidon-type EingabeDatenVerwaltung.DatenObjekte.Kurs
 */
    private Collection<Kurs> kurse = new TreeSet<Kurs>();
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
    	if(kurse.add(new Kurs())){
    		return true;
    	}
    	
    	return false;
	  
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
      
 }
