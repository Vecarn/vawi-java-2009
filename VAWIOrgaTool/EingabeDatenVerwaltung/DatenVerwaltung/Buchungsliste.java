package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.Iterator;

import EingabeDatenVerwaltung.DatenObjekte.*;


/**
 * Verwaltungsklasse für Buchungen
 * @author Markus Bode
 * @poseidon-object-id [I2d0758e8m124d537380cmm7b86]
 */
public class Buchungsliste {
/**
 * 
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm7a95]
 * @poseidon-type EingabeDatenVerwaltung.DatenObjekte.Buchung
 */
    private java.util.Collection<Buchung> buchungen = new java.util.TreeSet<Buchung>();
    /**
     * 
     * @param student
     * @param kurs
     * @return  true: wenn Collection geändert wurde <br>
     *			false: wenn Collection nicht geändert wurde (z.B. wenn Objekt bereits in Collection)
     */
    public boolean addBuchung(Student student, Kurs kurs){
		//new Buchung(Student student, Kurs kurs)
    	if(buchungen.add(new Buchung())){
    		return true;
    	}
    	
    	return false;
		    	
    }
    /**
     * 
     * @param kurs
     * @return Anzahl an Buchungen für einen gegebenen Kurs
     */
    public int anzBuchungenKurs(Kurs kurs){
    	return 0;
    }
    
    /**
     * 
     * @param student
     * @return Anzahl an Buchungen für einen gegebenen Student
     */
    public int anzBuchungenStudent(Student student){
    	return 0;
    }
       
}
