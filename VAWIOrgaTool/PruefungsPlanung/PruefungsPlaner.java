
package PruefungsPlanung;

import AusgabeDatenVerwaltung.Datenverwaltung.Pruefungsterminplan ;
/**
 * Der PruefungsPlaner ist ein Interface, welches von den Klassen, die die Pr&uuml;fungsplanungalgorithmen enthalten implementiert werden. Dieses Interface hat somit die Aufgabe unterschiedliche Planungsalgorithmen modular in die Ablaufsteuerung einzubinden und den Planungsalgorithmus zu kapseln. Er ben&ouml;tigt daf&uuml;r die EingabeDaten und den Pruefungsterminplan mit den Pruefungstagen.
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm7a42]
 */
public interface PruefungsPlaner {


    /**
     * Methode berechnet den Pruefungsplan und gibt diesen zurück
     * @param bedingungen für die Berechnung durch den Algorithmus
     * @return Pruefungsterminplan mit allen geplanten Tagen
     */
    public Pruefungsterminplan berechnePruefungsTerminPlan(Planungsbedingungen bedingung);
    
}


