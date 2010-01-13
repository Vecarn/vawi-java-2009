package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import EingabeDatenVerwaltung.DatenObjekte.Kurs;

/**
 * Verwaltungsklasse f�r Kurse.<br>
 * Die Buchungen werden nach KursID aufsteigend in einem TreeSet sortiert. <br>
 * Die Klasse bietet entsprechende Methoden um Kurs-Objekte hinzuzuf�gen und <br>
 * Informationen �ber den Bestand an Kurs-Objekten zu liefern.
 *  
 * @author Markus Bode
 * @version 1.0 vom 06.12.2009
 */
public class Kursliste {

    private Collection<Kurs> kurse = new TreeSet<Kurs>(new KursComparator());
    
    /**
     * Die Methode erstellt ein neues Kurs-Objekt und f�gt dieses einem TreeSet hinzu.<br>
     * Der R�ckgabe-Wert liefert die Information ob das Objekt hinzugef�gt wurde.
     * 
     * @param id (int) - Die KursId des Kurses 
     * @param kurztitel (String) - Kurztitel des Kurses
     * @param titel (String) - Lange Bezeichung(Titel) des Kurses.
     * @param teilleistungen (boolean) - Gibt an ob im Kurs Teilleistungen zu erreichen waren. 
     * @param maxPunkte (short) - Gibt die in den Teilleistungen maximal erreichbaren Punkte an.
     * @return	true: wenn Collection ge�ndert wurde <br>
     *			false: wenn Collection nicht ge�ndert wurde (z.B. wenn Objekt bereits in Collection)
     */
    public boolean addNeuerKurs(int id, String kurztitel, String titel, boolean teilleistungen, int maxPunkte){
    	
    	Kurs kurs = new Kurs(id,titel,kurztitel);
    	
    	if(kurse.add(kurs)){
    		kurs.setHatTeilleistungen(teilleistungen);
    		kurs.setMaxPunkte(maxPunkte);
    	    return true;
    	}
    	
    	return false;    	
	  
    }
    
    /**
     * Methode kann genutzt werden um ein bereits bestehendes Kurs-Objekt der Kursliste hinzuzuf�gen.<br>
     * Dies ist sinnvoll, wenn eine weitere Kursliste ben�tigt wird, um zum Beispiel eine Untermenge der vorhandenen Kursen separat zwischenzuspeichern.<br>
     * (z.B.: Menge an Kursen die an einem Pr�fungstag gepr�ft werden)<br> 
     * 
     * @param kurs (Kurs) - Ein konkretes Kurs-Objekt.
     * @return	true: wenn Collection ge�ndert wurde <br>
     *			false: wenn Collection nicht ge�ndert wurde (z.B. wenn Objekt bereits in Collection)
     */
    public boolean addKurs(Kurs kurs){
    	if(kurse.add(kurs)){
    		return true;
    	}
    	
    	return false;
    }
    /**
     * Kurse werden �ber eine ID eindeutig identifiziert.<br> 
     * Die Methode gibt einen Kurs anhand einer KursID zur�ck. 
     * 
     * @param kursId (int) - Eindeutige KursID eines Kurses.
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
     * Liefert einen Iterator auf die vorhandene Kurs-Collection.<br>
     * Die Kurse liegen nach der ID aufsteigend sortiert vor.
     * 
     * @return Iterator: Typisierter Iterator auf Collection mit Kurs-Objekten.
     */
    
    public Iterator<Kurs> getKursIterator(){
		return kurse.iterator();	
    }
    
    /**
     * Liefert die Anzahl der vorhandenen Kurs-Objekte zur�ck.
     *
     * @return int: Anzahl Kurse in der Kursliste.
     */
    public int getSize(){
    	return kurse.size();
    }
    
    public void removeKurs(Kurs kurs){
		Iterator<Kurs> itKurse = kurse.iterator();
		while(itKurse.hasNext()){
			if(itKurse.next().equals(kurs)){
				itKurse.remove();
			}
		}
    }
      
 }
