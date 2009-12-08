
package PruefungsPlanung;

import AusgabeDatenVerwaltung.Datenverwaltung.Pruefungsterminplan;
import EingabeDatenVerwaltung.DatenVerwaltung.*;


/**
 * PruefungsPlanerAlgo1 ist eine Logik-Klasse, die das Interface Pruefungsplaner implementiert und den PruefungsplanerAbstrakt spezialisiert.. Sie ist zust&auml;ndig f&uuml;r die Pr&uuml;fungsplanung und enth&auml;lt den Algorithmus zur Planung.
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm79f1]
 */
public class PruefungsPlanerAlgo1 extends PruefungsplanerAbstrakt implements PruefungsPlaner  {

/**
 *
 * Berechneter Pruefungsterminplan
 * @poseidon-object-id [I2d0758e8m124d537380cmm79d5]
 */
    private Pruefungsterminplan pruefungsterminplan;

    /**
     * Konstruktor, der die Planungsbedingungen entgegen nimmt
     * @param bedingungen
     */
    public PruefungsPlanerAlgo1(Planungsbedingungen bedingungen){
        super(bedingungen);
    }
    
    public Pruefungsterminplan berechnePruefungsTerminPlan(Studentenliste studenten, Buchungsliste buchungen,Kursliste kurse){
        return null;
    };
 }
