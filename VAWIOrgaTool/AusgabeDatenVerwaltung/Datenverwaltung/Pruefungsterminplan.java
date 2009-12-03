
package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.Collection;
import AusgabeDatenVerwaltung.DatenObjekte.Anwesenheit;

/**
 * Verwaltungsklasse, die das Ergebnis des Planungsalgorithmus 
 * in Form von Pruefungstagen enth&auml;lt.
 * 
 * @author Martin
 */
public class Pruefungsterminplan {

    public EingabeDatenVerwaltung.DatenVerwaltung.Buchungsliste buchungsliste;
    
    /**
     * Collection für die einzelnen Anwesenheiten
     */
    private Collection<Anwesenheit> anwesenheiten;
    

    public java.util.Collection pruefungstag = new java.util.TreeSet();
 }
