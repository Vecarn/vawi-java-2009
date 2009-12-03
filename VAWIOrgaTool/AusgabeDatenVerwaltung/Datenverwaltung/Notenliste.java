
package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.Collection;
import AusgabeDatenVerwaltung.DatenObjekte.Noten;

/**
 * Verwaltungsklasse f&uuml;r die Noten eines 
 * Studenten und gleichzeitig Entit&auml;tstyp f&uuml;r eine Notenliste.
 * 
 * @author Martin
 */
public class Notenliste {

    public java.util.Collection noten = new java.util.TreeSet();
    
    private Collection<Noten> notenliste;
 }
