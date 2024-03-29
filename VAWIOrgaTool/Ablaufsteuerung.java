
import AusgabeDatenVerwaltung.AusgabeVerwaltung;
import AusgabeDatenVerwaltung.Datenverwaltung.Pruefungsterminplan;
import EingabeDatenVerwaltung.DatenVerwaltung.Buchungsliste;
import EingabeDatenVerwaltung.DatenVerwaltung.Kursliste;
import EingabeDatenVerwaltung.DatenVerwaltung.Studentenliste;
import EingabeDatenVerwaltung.Eingabe.FlatFileLeser;
import PruefungsPlanung.Planungsbedingungen;
import PruefungsPlanung.PruefungsPlaner;
import PruefungsPlanung.PruefungsPlanerAlgo1;

/**
 * Die Klasse Ablaufsteuerung stellt Methoden bereit um den Programmablauf durch ein UI zu steuern.
 * Innerhalb der Methoden wird zusaetzlich auf Plausibilitaet der Aktion geprueft, d.h. ob der Ablauf wie gewuenscht erfolgen kann
 * und vorher notwendigen Schritte durchgefuehrt wurden.
 *
 * @author Joern Hauser
 * @version 1.7
 */
public class Ablaufsteuerung {

    private Pruefungsterminplan pruefungsplan;  
    private Buchungsliste buchungsliste;
    private Studentenliste studentenliste;
    private Kursliste kursliste;

    /**
     * Methode kuemmert sich um das korrekte Einlesen der Dateien
     * @throws Exception
     */
    public void leseDatenEin(String studentenFile, String buchungsFile, String kursFile, int einleseModus) throws Exception {
    	System.out.println("Daten werden eingelesen...");
        //Dateien einlesen
    	if(einleseModus==1){
    		FlatFileLeser flatFileLeser = new FlatFileLeser(studentenFile, buchungsFile, kursFile);
    		buchungsliste = flatFileLeser.getBuchungsliste();
    		studentenliste = flatFileLeser.getStudentenliste();
    		kursliste = flatFileLeser.getKursliste();
    	}else{
    		FlatFileLeser flatFileLeser = new FlatFileLeser(kursFile);
    		kursliste = flatFileLeser.getKursliste();
    	}
    	
    }

    /**
     * Methode startet den Planungslauf, wenn alle notwendigen Inputdaten vorhanden sind
     * @param pruefungenProTag als Randbedingungen aus dem UI mitgegeben
     * @param pruefungenProStudentUndTag als Randbedingung aus dem UI mitgeben
     * @throws Exception
     */
    public void startePlanungslauf(int pruefungenProTag, int pruefungenProStudentUndTag) throws Exception {
        //Wenn alle Daten f�r Planung vorhanden
    	if(studentenliste!=null && buchungsliste !=null && kursliste !=null){ 
        	System.out.println("Planungslauf wird gestartet...");
        	//Planungsbedingungsklasse erschaffen
        	Planungsbedingungen bedingungen = new Planungsbedingungen(pruefungenProTag);
        	bedingungen.setPruefungProStudentUndTag(pruefungenProStudentUndTag);
        	//Konkreten Pruefungsplaner erschaffen und Planungsbedingungen uebergeben
        	PruefungsPlaner planer = new PruefungsPlanerAlgo1(bedingungen);
        	//Pruefungsterminplan berechnen lassen
        	pruefungsplan = planer.berechnePruefungsTerminPlan(studentenliste,buchungsliste,kursliste);
        } else {
        	System.out.println("Achtung: Es sind keine Daten zur Planung vorhanden. Bitte erst Daten einlesen!");
        }
    }

    /**
     * Methode kuemmert sich um die Ausgabe der Daten, wenn ein Planungslauf durchgefuehrt wurde
     * @throws Exception
     */
    public void gebeDatenAus() throws Exception {
    	//Wenn alle f�r die Ausgabe notwendigen Daten vorhanden
    	if(studentenliste != null && buchungsliste !=null && kursliste !=null && pruefungsplan != null){
    		System.out.println("Daten werden ausgegeben...");
	        //AusgabeVerwaltung erschaffen und Listen generieren
    		AusgabeVerwaltung ausgabeVerwalter = new AusgabeVerwaltung(studentenliste, pruefungsplan, kursliste, buchungsliste);
	        ausgabeVerwalter.generiereAnwesenheitsliste();
	        ausgabeVerwalter.generiereNotenliste();
	        ausgabeVerwalter.generiereTerminplan();
	        ausgabeVerwalter.generierePlatzkartenliste();
    	} else {
    		System.out.println("Achtung: Es sind keine Daten zur Ausgabe vorhanden. Bitte erst die Planung starten!");
    	}
    }

    /**
     * Methode kuemmert sich um die Auswertung der Zufriedenheit
     * @throws Exception
     */
    public void werteZufriedenheitAus() throws Exception {
    	//Wenn alle f�r die Auswertung der Zufriedenheit notwendigen Daten vorhanden
    	if(pruefungsplan!=null && studentenliste !=null && buchungsliste != null){
    		System.out.println("Zufriedenheit wird ausgegeben...");
    		//Zufriedenheitsmesser erschaffen und Zufriedenheit errechnen
    		ZufriedenheitsMesser zufriedenheitsMesser = new ZufriedenheitsMesser(pruefungsplan, studentenliste,buchungsliste);
    		zufriedenheitsMesser.errechneZufriedenheit();
    	} else {
    		System.out.println("Achtung: Es sind keine Daten zur Auswertung vorhanden. Bitte erst Daten einlesen oder Pr�fungsplan erstellen!");
    	}
    }

    /**
     * Methode kuemmert sich um die Erstellung von fiktiven Studentenliste zur Simulation
     * @throws Exception
     */
    public void erstelleFiktiveStudentenListe(int minBuchungen,int maxBuchungen,int anzahlStudenten) throws Exception {
    	//Wenn Kursliste vorhanden
    	if(kursliste !=null){
    		System.out.println("Fiktive Studenten und Buchungen werden erstellt...");
    		//Neuen Simulator erschaffen und Studenten und Buchungslisten generieren
    		Simulator simulator = new Simulator(kursliste,minBuchungen,maxBuchungen,anzahlStudenten);
            studentenliste = simulator.getStudentenliste();
            buchungsliste = simulator.getBuchungsliste();
    	} else {
    		System.out.println("Achtung: Es fehlen Kurse zur Erstellung der Buchungen. Bitte erst Daten einlesen!");
    	} 
    }

    /**
     * Methode kuemmert sich um das Beenden des Programms
     * @throws Exception
     */
    public void beendeProgramm() throws Exception {
    	System.out.println("Programm wird beendet...");
    	//Korrektes Beenden mit Return-Wert 0
        System.exit(0);
    }
}
