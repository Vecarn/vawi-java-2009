
import AusgabeDatenVerwaltung.Ausgabe.FlatFileSchreiber;
import AusgabeDatenVerwaltung.AusgabeVerwaltung;
import AusgabeDatenVerwaltung.Datenverwaltung.Pruefungsterminplan;
import EingabeDatenVerwaltung.Eingabe.FlatFileLeser;
import PruefungsPlanung.PruefungsPlaner;
import PruefungsPlanung.Planungsbedingungen;
import PruefungsPlanung.PruefungsPlanerAlgo1;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * VAWIOrgaTool enth&auml;lt nur die Main-Klasse und eine Instanz der Ablaufsteuerung.
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm7638]
 * @author J�rn Hauser
 */
public class VAWIOrgaTool {

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

    /**
     * Einsprungsmethode -- Programmstart und Ablaufsteuerung
     * @param args
     *
     * @author: Joern Hauser
     */
    public static void main(String[] args){

        VAWIOrgaTool orga = new VAWIOrgaTool();
        try {
            //Dateien einlesen
            FlatFileLeser leser = new FlatFileLeser("Studenten.txt", "Buchungen.txt", "Kurse.txt");
            //Planungsbedingungsklasse erschaffen
            Planungsbedingungen bedingungen = new Planungsbedingungen();
            //Konkreten Pruefungsplaner erschaffen und Planungsbedingungen uebergeben
            PruefungsPlaner planer = new PruefungsPlanerAlgo1(bedingungen);
            //Pruefungsterminplan berechnen lassen
            Pruefungsterminplan pruefungsplan = planer.berechnePruefungsTerminPlan(leser.getStudentenliste(),leser.getBuchungsliste(),leser.getKursliste());
            //Dateien ausgeben
            AusgabeVerwaltung ausgabeVerwalter = new AusgabeVerwaltung();

        } catch (IOException ex) {
            Logger.getLogger(VAWIOrgaTool.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 }
