package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import EingabeDatenVerwaltung.DatenObjekte.Kurs;

/**
 * Verwaltungsklasse f�r Kurse
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
     * @return	true: wenn Collection ge�ndert wurde <br>
     *			false: wenn Collection nicht ge�ndert wurde (z.B. wenn Objekt bereits in Collection)
     */
    public boolean addKurs(int id, String kurztitel, String langname, boolean teilleistungen, short maxPunkte){
    	//new Kurs(hier alle Variablen)
    	Kurs kurs = new Kurs(id, langname);
    	
    	if(kurse.add(kurs)){
    		kurs.setKurztitel(kurztitel);
    		kurs.setHatTeilleistungen(teilleistungen);
    		kurs.setMaxPunkte(maxPunkte);
    	    return true;
    	}
    	
    	return false;    	
	  
    }
    
    public Kurs getKurs(int kursId){
    	
    	Iterator<Kurs> kursiterator = kurse.iterator();
    		
    	while(kursiterator.hasNext()){
    		Kurs kurs = kursiterator.next();
    		if(kurs.getKursid() == kursId){
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
