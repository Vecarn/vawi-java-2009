package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import EingabeDatenVerwaltung.DatenObjekte.*;


/**
 * Verwaltungsklasse f�r Buchungen. <br>
 * Die Buchungen werden nach KursID aufsteigend in einem TreeSet sortiert. <br>
 * Bei gleicher KursId aufsteigend nach MatrikelNr des betroffenen Studenten-Objektes.<br>
 * Die Klasse bietet entsprechende Methoden um Buchungs-Objekt hinzuzuf�gen und <br>
 * Informationen �ber den Buchungsbestand zu liefern.   
 *
 * @author Markus Bode
 * @version 1.1 vom 12.01.2010
 */
public class Buchungsliste {
	
	/**
	 * TreeSet Collection mit eigenem Comparator, welcher Buchungen anhand der IDs der Daten-Objekte Kurs, Student vergleicht.
	 */
    private Collection<Buchung> buchungen = new TreeSet<Buchung>(new BuchungsComparator());
    
    /**
     * Hashmap mit	"KEY" (Kurs) -->"Value" (Integer)
     * 				konkretes Kurs-Objekt --> Anzahl der Buchungen f�r diesen Kurs
     */
    private HashMap<Kurs,Integer> buchungszahlen = new HashMap<Kurs, Integer>(); 
   
    /**
     * F�gt eine neue Buchung zu einem TreeSet hinzu. <br> 
     * Doppelte Buchungen (identischer Kurs und Student) sind automatisch ausgeschlossen.<br>
     *  
	 * Dabei wird die Anzahl der Buchungen f�r einen Kurs gez�hlt und in einer HashMap gespeichert.
     *  
     * @param student (Student) - Ein konkretes Studenten-Objekt.
     * @param kurs (Kurs) - Ein konkretes Kurs-Objekt.
     * @param erreichtePunkte (int) - Die Anzahl der bereits erreichten Punkte des Studenten in diesem Kurs.
     * @return  true: wenn Collection ge�ndert wurde <br>
     *			false: wenn Collection nicht ge�ndert wurde (z.B. wenn Objekt bereits in Collection)
     */
    public boolean addBuchung(Student student, Kurs kurs, int erreichtePunkte){
		    	
    	Buchung buchung = new Buchung(student,kurs);
    	buchung.setErreichtePunkte(erreichtePunkte);
    	//nur wenn true geliefert wird, muss die Buchung gez�hlt werden
    	//wenn buchungen.add(buchung) false liefert, gibt es diese Buchung bereits
    	if(buchungen.add(buchung)){
    		
    		if(buchungszahlen.containsKey(kurs)){
    			//der Kurs trat bereits einmal auf -> der Value (anzahl Buchungen) zu dem Key(kurs) muss erh�ht werden
    			buchungszahlen.put(kurs, new Integer((buchungszahlen.get(kurs).intValue())+1));
    		}else{
    			//der Kurs trat noch nicht auf -> Value auf 1 setzen.
    			buchungszahlen.put(kurs, new Integer(1));
    		}
    		
    		return true;
    	}
    	
    	return false;
    			    	
    }
    
    /**
     * Liefert die Gesamtanzahl an Buchungen f�r einen Kurs.
     * 
     * @param kurs (Kurs) - Ein konkretes Kurs-Objekt.
     * @return int: Anzahl an Buchungen f�r einen gegebenen Kurs
     */
    public int anzBuchungenKurs(Kurs kurs){
    	if(buchungszahlen.get(kurs)==null){
    		//wenn get(kurs) null liefert, ist Key(kurs) nich vorhanden -> 
    		// es gibt also keine Buchungen zu dem Kurs -> return 0
    		return 0;
    	}
    	//return Anzahl Buchungen
    	return buchungszahlen.get(kurs).intValue();
    }
    
    /**
     * Liefert die Anzahl an Kursbuchungen f�r einen Student.
	 * 
     * @param student (Student) - Ein konkretes Student-Objekt.
     * @return int: Anzahl an Buchungen f�r einen gegebenen Student
     */
    public int anzBuchungenStudent(Student student){
    	int anzBuchungen = 0;
    	Iterator<Buchung> bi = getIterator();
    	//gehe �ber alle Buchungsobjekte
    	while(bi.hasNext()){
    		//wenn der �bergebene Student auch in dem Buchungsobjekt referenziert ist erh�he anzBuchungen
    		if(bi.next().getStudent()==student){
    			anzBuchungen++;
    		}
    	}
    	
    	return anzBuchungen;
    }
    
    /**
     * Liefert einen Iterator �ber Elemente die durch die Verwaltungsklasse verwaltet werden.<br>
     * Die einzelnen Buchungen sind nach der Kurs-ID aufsteigend sortiert.<br>
     * Bei gleicher KursId sind die Buchungen nach der MatrikelNr des Studenten aufsteigend sortiert.
     * 
     * @return Iterator: �ber alle Buchungs-Objekte.
     */
    public Iterator<Buchung> getIterator(){
		return buchungen.iterator();
    	
    }
    
    /**
     * Liefert die Anzahl der existierenden Buchungs-Objekte.
     * 
     * @return int: Anzahl Buchungen in der Buchungsliste.
     */
    public int getSize(){
    	return buchungen.size();
    }
    
    /**
     * Liefert das Buchungs-Objekt zur Buchung eines Kurses von einem Studenten anhand deren IDs. 
     * 
     * @param kursid (int) - Die KursId des an der Buchung  beteiligten Kurses.
     * @param matrikelnr (int) - Die MatrikelNr. des Studenten.
     * @return Buchung: wenn Buchungs-Objekt zu �bergebenen Daten vorhanden.<br>
     *         null: wenn kein Buchungs-Objekt zu �bergebenen Daten vorhanden.
     */
    public Buchung getBuchung(int kursid, int matrikelnr){
	   	Iterator<Buchung> bi = getIterator();
    	
	   	Buchung buchung = null;
	   	//gehe �ber alle Buchungen
    	while(bi.hasNext()){
    		//setze das n�chste Buchungsobjekt auf buchung
	   		buchung = bi.next();
	   		//wenn die �bergebenen IDs den IDs der Kurs und Studentenobjekte des aktuellen Buchungsobjeks entsprechen
	   		//wird buchung zur�ckgegeben, sonst bleibt buchung = null
	   		if((buchung.getKurs().getKursid()==kursid)&&(buchung.getStudent().getMatrikelnr()==matrikelnr)){
	   			return buchung;
	   		}else{
	   			buchung = null;
	   		}
	   	}
	   	
    	return buchung;
    }
    
    /**
     * Methode f�gt der Collection buchung ein bereits bestehendes Buchungsobjekt hinzu. 
     * Die Methode wird ben�tigt um die Klasse Buchungsliste wiederverwenden zu k�nnen <br>
     * um z.B. eine Untermenge der Buchungsobjekte in einer weiteren Buchungsliste zu speichern.
     * 
     * @param buchung (Buchung) - Ein bereits existierendes Buchungsobjekt.
     * @return  true: wenn Collection ge�ndert wurde <br>
     *			false: wenn Collection nicht ge�ndert wurde (z.B. wenn Objekt bereits in Collection)
     */
    public boolean addBuchung(Buchung buchung){
    	return(buchungen.add(buchung));
    }
    
    /**
     * Die Methode liefert eine Collection vom Typ Buchungsliste mit <br>
     * allen Buchungsobjekten f�r das �bergebene Studentenobjekt.
     * 
     * @param student (Student) - Ein Studentenobjekt.
     * @return Buchungsliste: Collection mit Buchungen des �bergebenen Studenten.
     */
    public Buchungsliste getBuchungen(Student student){
    	//erzeuge neue Buchungsliste
    	Buchungsliste buchungsliste = new Buchungsliste();
    	
    	Iterator<Buchung> bi = getIterator();
    	//gehe �ber alle Buchungen
	   	while(bi.hasNext()){
	   		
	   		Buchung buchung = bi.next();
	   		//wenn die aktuelle Buchung zu dem �bergebenen Studenten geh�rt, wird das Buchungsobjekt der neuen Buchungsliste hinzugef�gt
	   		if(buchung.getStudent().getMatrikelnr()==student.getMatrikelnr()){
	   			buchungsliste.addBuchung(buchung);
	   		}
	   		
	   	} 
    	
		return buchungsliste;
    }
    
    /**
     * Die Methode liefert eine Collection vom Typ Buchungsliste mit <br>
     * allen Buchungsobjekten f�r das �bergeben Kursobjekt.
     * 
     * @param kurs (Kurs) - Ein Kursobjekt.
     * @return Buchungsliste: Collection mit allen Buchungen f�r das �bergebene Kursobjekt
     */
    public Buchungsliste getBuchungen(Kurs kurs){
    	//die Studenten id von arg0 ist kleiner > -1
    	Buchungsliste buchungsliste = new Buchungsliste();
    	
    	Iterator<Buchung> bi = getIterator();
    	//die Studenten id von arg0 ist kleiner > -1
	   	while(bi.hasNext()){
	   		
	   		Buchung buchung = bi.next();
	   	    //wenn die aktuelle Buchung zu dem �bergebenen Kurs geh�rt, wird das Buchungsobjekt der neuen Buchungsliste hinzugef�gt
	   		if(buchung.getKurs().getKursid()==kurs.getKursid()){
	   			buchungsliste.addBuchung(buchung);
	   		}
	   		
	   	} 
    	
		return buchungsliste;
    }
    
}
