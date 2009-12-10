
package PruefungsPlanung;

import EingabeDatenVerwaltung.DatenVerwaltung.Studentenliste;
import EingabeDatenVerwaltung.DatenVerwaltung.Buchungsliste;
import EingabeDatenVerwaltung.DatenVerwaltung.Kursliste;
import AusgabeDatenVerwaltung.Datenverwaltung.Pruefungsterminplan;
/**
 * Der PruefungsplanerAbstrakt ist eine Abstrakte Klasse, die das Interface Pruefungsplaner implementiert. Alle Methoden die den Algorithmus direkt betreffen bleiben abstrakt. Lediglich die Methoden, die die Planungsbedingungen als Randbedingungen f&uuml;r den Algorithmus setzen, sind implementiert.
 * @author Joern Hauser
 * @poseidon-object-id [Im3057c7d4m124e9a3360amm7463]
 */
public abstract class PruefungsplanerAbstrakt implements PruefungsPlaner {


    /**
     * Konstruktor der alle fuer den Algorithmus benoetigten Listen bekommt
     * @param studenten
     * @param buchungen
     * @param kurse
     */
    public PruefungsplanerAbstrakt(Planungsbedingungen planungsbedingungen){
        ;
    }

        /**
     * Methode gibt die aktuell gültigen Planungsbedingungen zurueck
     * @return aktuelle Planungsbedingungen
     */
    public Planungsbedingungen getPlanungsbedingungen(){
        return null;
    };

    /**
     * Methode setzt neue Planungsbedingungen zur Pruefungsterminplan-Berechnung
     * @param bedingungen
     */
    public void setPlanungsbedingungen(Planungsbedingungen bedingungen){
        
    };

    public abstract Pruefungsterminplan berechnePruefungsTerminPlan(Studentenliste studenten, Buchungsliste buchungen,Kursliste kurse);
 }
