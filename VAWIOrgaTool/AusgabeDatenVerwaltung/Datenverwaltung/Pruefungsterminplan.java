
package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.*;

import AusgabeDatenVerwaltung.DatenObjekte.Pruefungstag;


/**
 * Verwaltungsklasse, die das Ergebnis des Planungsalgorithmus 
 * in Form von Pruefungstagen enth&auml;lt.
 * 
 * @author Martin
 * @version 0.1
 */
public class Pruefungsterminplan {

    public EingabeDatenVerwaltung.DatenVerwaltung.Buchungsliste buchungsliste;
    
    /**
     * Collection für die einzelnen Anwesenheiten
     */
    private Collection<Pruefungstag> pruefungsterminplan;
    

    /**
     * Konstruktor für den Pruefungsterminplan
     */
    public Pruefungsterminplan(){
    	pruefungsterminplan = new TreeSet<Pruefungstag>();
    }
    
    
    /**
     * Methode, die einen Iterator für den Prüfungsterminplan zurückliefert.
     * @return Iterator<Pruefungstag> - der Iterator mit dem Pruefungstag
     */
    public Iterator<Pruefungstag> getPruefungsplanIterator(){
		return pruefungsterminplan.iterator();	
    }
    
    /**
     * Methode zum Hinzufügen eines Prüfungstages zum Prüfungsterminplan
     * @param pruefungstag Der Prüfungstag, der hinzugefügt wird
     * @return true, wenn erfolgreich
     */
    public boolean addPruefungstag(Pruefungstag pruefungstag){
	    if(pruefungsterminplan.add(pruefungstag)){
			return true;
		}
	    
		
		return false;
    }
 }
