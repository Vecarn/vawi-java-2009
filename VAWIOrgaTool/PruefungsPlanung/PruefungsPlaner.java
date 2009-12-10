
package PruefungsPlanung;

import AusgabeDatenVerwaltung.Datenverwaltung.Pruefungsterminplan ;
import EingabeDatenVerwaltung.DatenVerwaltung.*;
/**
 * Der PruefungsPlaner ist ein Interface, welches von den Klassen, die die Pr&uuml;fungsplanungalgorithmen enthalten implementiert werden. Dieses Interface hat somit die Aufgabe unterschiedliche Planungsalgorithmen modular in die Ablaufsteuerung einzubinden und den Planungsalgorithmus zu kapseln. Er ben&ouml;tigt daf&uuml;r die EingabeDaten und den Pruefungsterminplan mit den Pruefungstagen.
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm7a42]
 */
public interface PruefungsPlaner {


    /**
     * Methode berechnet den Pruefungsplan und gibt diesen zurueck
     * @param Studentenliste aller Studenten, die eingeplant werden müssen
     * @param Buchungsliste mit allen Buchungen der Studenten
     * @param Kursliste mit allen buchbaren Kursen
     * @return Pruefungsterminplan mit allen geplanten Tagen
     */
    public Pruefungsterminplan berechnePruefungsTerminPlan(Studentenliste studenten, Buchungsliste buchungen,Kursliste kurse);

    /**
     * Methode gibt die aktuell gültigen Planungsbedingungen zurueck
     * @return aktuelle Planungsbedingungen
     */
    public Planungsbedingungen getPlanungsbedingungen();

    /**
     * Methode setzt neue Planungsbedingungen zur Pruefungsterminplan-Berechnung
     * @param bedingungen
     */
    public void setPlanungsbedingungen(Planungsbedingungen bedingungen);
}


