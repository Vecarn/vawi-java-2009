import AusgabeDatenVerwaltung.Ausgabe.FlatFileSchreiber;
import AusgabeDatenVerwaltung.AusgabeVerwaltung;
import AusgabeDatenVerwaltung.Datenverwaltung.Pruefungsterminplan;
import EingabeDatenVerwaltung.Eingabe.FlatFileLeser;
import PruefungsPlanung.PruefungsPlaner;
import PruefungsPlanung.Planungsbedingungen;
import PruefungsPlanung.PruefungsPlanerAlgo1;

/**
 *
 * @author Joern Hauser
 */
public class Ablaufsteuerung {
/**
 *
 *
 * @poseidon-object-id [I2d0758e8m124d537380cmm74bb]
 */
    public PruefungsPlaner pruefungsPlaner;
/**
 *
 *
 * @poseidon-object-id [I2d0758e8m124d537380cmm7200]
 */
    public Simulator simulator;
/**
 *
 *
 * @poseidon-object-id [Im3057c7d4m124e9a3360amm7578]
 */
    public FlatFileSchreiber flatFileSchreiber;
/**
 *
 *
 * @poseidon-object-id [I2d0758e8m124d537380cmm7492]
 */
    public FlatFileLeser flatFileLeser;
/**
 *
 *
 * @poseidon-object-id [Im3057c7d4m124e9a3360amm74b9]
 */
    public ZufriedenheitsMesser zufriedenheitsMesser;

}
