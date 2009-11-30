
package PruefungsPlanung;

/**
 * PruefungsPlanerAlgo1 ist eine Logik-Klasse, die das Interface Pruefungsplaner implementiert und den PruefungsplanerAbstrakt spezialisiert.. Sie ist zust&auml;ndig f&uuml;r die Pr&uuml;fungsplanung und enth&auml;lt den Algorithmus zur Planung.
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm79f1]
 */
public class PruefungsPlanerAlgo1 extends PruefungsPlanung.PruefungsplanerAbstrakt implements PruefungsPlanung.PruefungsPlaner {
/**
 * 
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm7789]
 */
    public EingabeDatenVerwaltung.DatenVerwaltung.Studentenliste studentenliste;
/**
 * 
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm78a4]
 */
    public PruefungsPlanung.Planungsbedingungen planungsbedingungen;
/**
 * 
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm77b2]
 */
    public EingabeDatenVerwaltung.DatenVerwaltung.Buchungsliste buchungsliste;
/**
 * 
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm77db]
 */
    public EingabeDatenVerwaltung.DatenVerwaltung.Kursliste kursliste;
/**
 * 
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm79d5]
 */
    public AusgabeDatenVerwaltung.Datenverwaltung.Pruefungsterminplan pruefungsterminplan;
 }
