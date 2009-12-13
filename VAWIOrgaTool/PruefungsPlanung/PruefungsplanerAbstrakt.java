
package PruefungsPlanung;

import EingabeDatenVerwaltung.DatenVerwaltung.Studentenliste;
import EingabeDatenVerwaltung.DatenVerwaltung.Buchungsliste;
import EingabeDatenVerwaltung.DatenVerwaltung.Kursliste;
import AusgabeDatenVerwaltung.Datenverwaltung.Pruefungsterminplan;
/**
 * Der PruefungsplanerAbstrakt ist eine Abstrakte Klasse, die das Interface Pruefungsplaner implementiert. Alle Methoden die den Algorithmus direkt betreffen bleiben abstrakt. Lediglich die Methoden, die die Planungsbedingungen als Randbedingungen f&uuml;r den Algorithmus setzen, sind implementiert.
 * @author Joern Hauser
 */
public abstract class PruefungsplanerAbstrakt implements PruefungsPlaner {


    /**
     * Konstruktor mit Planungsbedingungen
     * @param planungsbedingungen
     */
    public PruefungsplanerAbstrakt(Planungsbedingungen planungsbedingungen){
        ;
    }

        /**
     * Methode gibt die aktuell gültigen Planungsbedingungen zurueck
     * @return Planungsbedingungen
     */
    public Planungsbedingungen getPlanungsbedingungen(){
        return null;
    };

    /**
     * Methode setzt neue Planungsbedingungen zur Pruefungsterminplan-Berechnung
     * @param bedingungen als Randbedingungen zur Planung
     */
    public void setPlanungsbedingungen(Planungsbedingungen bedingungen){
        
    };

    public abstract Pruefungsterminplan berechnePruefungsTerminPlan(Studentenliste studenten, Buchungsliste buchungen,Kursliste kurse);
 }
