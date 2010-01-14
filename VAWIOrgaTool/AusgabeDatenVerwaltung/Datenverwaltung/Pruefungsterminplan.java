
package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.*;

import AusgabeDatenVerwaltung.DatenObjekte.Pruefungstag;


/**
 * Verwaltungsklasse, die das Ergebnis des Planungsalgorithmus 
 * in Form von Pruefungstagen enth&auml;lt.
 * 
 * @author Martin
 * @version 0.8
 */
public class Pruefungsterminplan {

    public EingabeDatenVerwaltung.DatenVerwaltung.Buchungsliste buchungsliste;
    
    /**
     * Collection f�r die einzelnen Anwesenheiten
     */
    private Collection<Pruefungstag> pruefungsterminplan;
    

    /**
     * Konstruktor f�r den Pruefungsterminplan
     */
    public Pruefungsterminplan(){
    	pruefungsterminplan = new TreeSet<Pruefungstag>(new PruefungstagComparator());
    }
    
    
    /**
     * Methode, die einen Iterator f�r den Pr�fungsterminplan zur�ckliefert.
     * @return Iterator<Pruefungstag> - der Iterator mit dem Pruefungstag
     */
    public Iterator<Pruefungstag> getPruefungsplanIterator(){
		return pruefungsterminplan.iterator();	
    }
    
    /**
     * Methode zum Hinzuf�gen eines Pr�fungstages zum Pr�fungsterminplan
     * @param pruefungstag Der Pr�fungstag, der hinzugef�gt wird
     * @return true, wenn erfolgreich<br>false, wenn nicht erfolgreich
     */
    public boolean addPruefungstag(Pruefungstag pruefungstag){
	    
    	if(pruefungsterminplan.add(pruefungstag)){
			return true;
		}
	    
		
		return false;
    }
 }
