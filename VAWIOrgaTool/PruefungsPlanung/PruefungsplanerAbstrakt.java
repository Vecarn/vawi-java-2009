
package PruefungsPlanung;

import EingabeDatenVerwaltung.DatenVerwaltung.Studentenliste;
import EingabeDatenVerwaltung.DatenVerwaltung.Buchungsliste;
import EingabeDatenVerwaltung.DatenVerwaltung.Kursliste;
import AusgabeDatenVerwaltung.Datenverwaltung.Pruefungsterminplan;
/**
 * Der PruefungsplanerAbstrakt ist eine Abstrakte Klasse, die das Interface Pruefungsplaner implementiert. Alle Methoden die den Algorithmus direkt betreffen bleiben abstrakt. Lediglich die Methoden, die die Planungsbedingungen als Randbedingungen f&uuml;r den Algorithmus setzen, sind implementiert.
 * 
 * @poseidon-object-id [Im3057c7d4m124e9a3360amm7463]
 */
public abstract class PruefungsplanerAbstrakt implements PruefungsPlaner {
 /**
 *
 * Alle Studenten für die geplant wird
 * @poseidon-object-id [I2d0758e8m124d537380cmm7789]
 */
    private Studentenliste studentenliste;
/**
 *
 * Planungsbedingungen als Randbedingungen
 * @poseidon-object-id [I2d0758e8m124d537380cmm78a4]
 */
    private Planungsbedingungen planungsbedingungen;
/**
 *
 * Buchungsliste mit allen Buchungen
 * @poseidon-object-id [I2d0758e8m124d537380cmm77b2]
 */
    private Buchungsliste buchungsliste;
/**
 *
 * Kursliste mit allen verfügbaren Kursen
 * @poseidon-object-id [I2d0758e8m124d537380cmm77db]
 */
    private Kursliste kursliste;

   public void setBuchungsliste(Buchungsliste buchungsliste) {
        this.buchungsliste = buchungsliste;
    }

    public Kursliste getKursliste() {
        return kursliste;
    }

    public void setKursliste(Kursliste kursliste) {
        this.kursliste = kursliste;
    }

    public Studentenliste getStudentenliste() {
        return studentenliste;
    }

    public void setStudentenliste(Studentenliste studentenliste) {
        this.studentenliste = studentenliste;
    }

    public Buchungsliste getBuchungsliste() {
        return buchungsliste;
    }

    public abstract Pruefungsterminplan berechnePruefungsTerminPlan(Planungsbedingungen bedingung);
 }
