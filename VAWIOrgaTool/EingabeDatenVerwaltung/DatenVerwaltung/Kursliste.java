package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import EingabeDatenVerwaltung.DatenObjekte.Kurs;

/**
 * Verwaltungsklasse für Kurse
 * 
 * @author Markus Bode
 */
public class Kursliste {

    private Collection<Kurs> kurse = new TreeSet<Kurs>(new KursComparator());
    
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
    
    /**
     * Kurse werden über eine ID eindeutig identifiziert. 
     * Die Methode gibt einen Kurs anhand einer KursID zurück. 
     * 
     * @param kursId(int)
     * @return Kurs: Kurs-Objekt
     */
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
     * Die Kurse liegen nach der ID aufsteigend sortiert vor.
     * @return <tt>Iterator</tt> : Typisierter Iterator auf Collection mit Kurs-Objekten.
     */
    
    public Iterator<Kurs> getKursIterator(){
		return kurse.iterator();	
    }
    /**
     * Liefert die Anzahl der vorhandenen Kurs-Objekte zurück.
     * @return int: Anzahl Kurse
     */
    public int getSize(){
    	return kurse.size();
    }
      
 }
