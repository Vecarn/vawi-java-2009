
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
 * Die Klasse Ablaufsteuerung stellt Methoden bereit um den Programmablauf durch ein UI zu steuern.
 * Innerhalb der Methoden wird zusaetzlich auf Plausibilitaet der Aktion geprueft, d.h. ob der Ablauf wie gewuenscht erfolgen kann
 * und vorher notwendigen Schritte durchgefuehrt wurden.
 *
 * @author Joern Hauser
 */
public class Ablaufsteuerung {

    private PruefungsPlaner pruefungsPlaner;
    private Simulator simulator;
    private FlatFileLeser flatFileLeser;
    private ZufriedenheitsMesser zufriedenheitsMesser;
    private AusgabeVerwaltung ausgabeVerwalter;
    private Pruefungsterminplan pruefungsplan;

    /**
     * Methode kuemmert sich um das korrekte Einlesen der Dateien
     * @throws Exception
     */
    public void leseDatenEin(String studentenFile, String buchungsFile, String kursFile) throws Exception {
        //Dateien einlesen
        flatFileLeser = new FlatFileLeser("Studenten.txt", "Buchungen.txt", "Kurse.txt");
    }

    /**
     * Methode startet den Planungslauf, wenn alle notwendigen Inputdaten vorhanden sind
     * @param pruefungenProTag als Randbedingungen aus dem UI mitgegeben
     * @param PruefungenProStudentUndTag als Randbedingung aus dem UI mitgeben
     * @throws Exception
     */
    public void startePlanungslauf(String pruefungenProTag, String PruefungenProStudentUndTag) throws Exception {
        //@TO-DO: Check ob flatFileLeser != null         
        //Planungsbedingungsklasse erschaffen
        //Planungsbedingungen bedingungen = new Planungsbedingungen();
        //Konkreten Pruefungsplaner erschaffen und Planungsbedingungen uebergeben
        //PruefungsPlaner planer = new PruefungsPlanerAlgo1(bedingungen);
        //Pruefungsterminplan berechnen lassen
        //pruefungsplan = planer.berechnePruefungsTerminPlan(flatFileLeser.getStudentenliste(), flatFileLeser.getBuchungsliste(), flatFileLeser.getKursliste());
    }

    /**
     * Methode kuemmert sich um die Ausgabe der Daten, wenn ein Planungslauf durchgefuehrt wurde
     * @throws Exception
     */
    public void gebeDatenAus() throws Exception {
        //Dateien ausgeben
        //ausgabeVerwalter = new AusgabeVerwaltung(flatFileLeser.getStudentenliste(), pruefungsplan, flatFileLeser.getKursliste(), flatFileLeser.getBuchungsliste());
        //ausgabeVerwalter.generiereAnwesenheitsliste();
        //ausgabeVerwalter.generiereNotenliste();
        //ausgabeVerwalter.generierePlatzkartenliste();
    }

    /**
     * Methode kuemmert sich um die Auswertung der Zufriedenheit
     * @throws Exception
     */
    public void werteZufriedenheitAus() throws Exception {
        //zufriedenheitsMesser = new ZufriedenheitsMesser(pruefungsplan, flatFileLeser.getStudentenliste());
        //zufriedenheitsMesser.errechneZufriedenheit();
    }

    /**
     * Methode kuemmert sich um die Erstellung von fiktiven Studentenliste zur Simulation
     * @throws Exception
     */
    public void erstelleFiktiveStudentenListe() throws Exception {
        //simulator = new Simulator(flatFileLeser.getKursliste());
    }

    /**
     * Methode kuemmert sich um das Beenden des Programms
     * @throws Exception
     */
    public void beendeProgramm() throws Exception {
        System.exit(0);
    }
}
