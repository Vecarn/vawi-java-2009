package PruefungsPlanung;

import AusgabeDatenVerwaltung.Datenverwaltung.Pruefungsterminplan;
import EingabeDatenVerwaltung.DatenVerwaltung.*;

/**
 * PruefungsPlanerAlgo1 ist eine Logik-Klasse, die das Interface Pruefungsplaner implementiert und den PruefungsplanerAbstrakt spezialisiert.. Sie ist zust&auml;ndig f&uuml;r die Pr&uuml;fungsplanung und enth&auml;lt den Algorithmus zur Planung.
 * @author Joern Hauser
 */
public class PruefungsPlanerAlgo1 extends PruefungsplanerAbstrakt implements PruefungsPlaner {

    /**
     * Alle Studenten fuer die geplant wird
     */
    private Studentenliste studentenliste;
    /**
     * Planungsbedingungen als Randbedingungen
     */
    private Planungsbedingungen planungsbedingungen;
    /**
     * Buchungsliste mit allen Buchungen
     */
    private Buchungsliste buchungsliste;
    /**
     * Berechneter Pruefungsterminplan
     */
    private Pruefungsterminplan pruefungsterminplan;

    /**
     * Konstruktor, der die Planungsbedingungen entgegen nimmt
     * @param bedingungen
     */
    public PruefungsPlanerAlgo1(Planungsbedingungen bedingungen) {
        super(bedingungen);
    }

    public Pruefungsterminplan berechnePruefungsTerminPlan(Studentenliste studenten, Buchungsliste buchungen, Kursliste kurse) {
        return null;
    }

    ;
}
