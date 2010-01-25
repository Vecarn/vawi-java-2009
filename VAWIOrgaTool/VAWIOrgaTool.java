import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;


/**
 * VAWIOrgaTool enthaelt die Main-Methode und Methoden eines rudimentaeren UI zur Steuerung des Programms durch einen Benutzer
 *
 * @author Joern Hauser
 * @version	1.9
 */
public class VAWIOrgaTool {
	
	private String pfad;
	private Ablaufsteuerung steuerung = new Ablaufsteuerung();
	
	private static String studentenDatei = "studenten.txt";
	private static String kursDatei = "kurse.txt";
	private static String buchungsDatei = "buchungen.txt";
	
	private static int pruefungenProTag=3;
	private static int pruefungenProStudentUndTag=3;
	
	private static int anzSimStudenten=50;
	private static int minSimBuchungen=0;
	private static int maxSimBuchungen=10;
	
	private static int einleseModus=1;
	
	VAWIOrgaTool(String args[]) throws Exception{
		System.out.println("VAWIOrgaTool 1 der Gruppe 5");
		System.out.println("---------------------------");
		//Neues File-Objekt wird erzeugt um den relativen Pfad zum Root-Verzeichnis zu erhalten
		File f = new File("");
		pfad = f.getAbsolutePath() + "\\";
		//Initialisierungsmethode aufrufen
		init(args);
		//Benutzeroberfläche anzeigen
		setMenu();
	}
	
	/**
	 * Methode liest die übergenen Parameter und setzt die entsprechenden Attribute
	 * @param args
	 */
	private void init(String args[]){
		
		studentenDatei=pfad+studentenDatei;
		kursDatei=pfad+kursDatei;
		buchungsDatei=pfad+buchungsDatei;

		if(args.length  != 3){
			System.out.println("Achtung!!!");
			System.out.println("Es wurden keine oder nicht genügend Parameter beim Programmstart angegeben!");
			System.out.println("Der Aufruf per Parameter lautet z.B. -studenten=studenten.txt -kurse=kurse.txt -buchungen=buchungen.txt");
			System.out.println("Wichtig: Die Dateien müssen sich im Wurzelverzeichnis des VAWIOrgaTools befinden!");	
		} 	
		//Loop über alle Aufrufparameter.
		for (int i = 0; i < args.length; i++) {
			//Überprüfen mit regulärem Ausdruck nach Suchmustern, falls nicht gefunden bleibt der Default Wert
			//Parameter: -studenten
			if (Pattern.matches("-studenten=.*", args[i])) {
				studentenDatei = pfad+args[i].substring(11, args[i].length());
			}
			// Parameter: -kurse
			if (Pattern.matches("-kurse=.*", args[i])) {
					kursDatei = pfad+args[i].substring(7, args[i].length());
			}
			// Parameter: -buchungen
			if (Pattern.matches("-buchungen=.*", args[i])) {
				buchungsDatei = pfad+args[i].substring(11, args[i].length());
			}
		}
		System.out.println();
		System.out.println("Initialisierungsparameter:");
		System.out.println("--------------------------");
		System.out.println("Studentendatei: " + studentenDatei);
		System.out.println("Kursdatei: " + kursDatei);
		System.out.println("Buchungsdatei: " + buchungsDatei);
		System.out.println("Prüfung pro Stundent und Tag: " +pruefungenProStudentUndTag);
		System.out.println("Maximal geplante Prüfungen pro Tag: " +pruefungenProTag);
	}

	
    /**
     * Methode baut das Menue zur Benutzerfuehrung auf
     * @throws Exception 
     */
    private void setMenu() throws Exception {
    	System.out.println();
    	System.out.println("Auswahl-Menü");
    	System.out.println("-----------------------------");
    	System.out.println("(1) Daten einlesen");
    	System.out.println("(2) Fiktive Studenten/Buchungen erstellen");
    	System.out.println("(3) Planungsparameter einstellen");
    	System.out.println("(4) Prüfungstermine planen");
    	System.out.println("(5) Zufriedenheit errechnen");
    	System.out.println("(6) Daten ausgeben");
    	System.out.println("(0) Programm beenden");
    	System.out.println();
    	System.out.println("Eingabe:");
    	
    	String eingabe = getEingabe();
    	werteEingabeAus(eingabe);

    }
    /**
     * Methode führt Benutzer durch die Eingabe-Prozedur der Planungsparameter
     */
    private void setBedingungen(){
    	String eingabe="";
    	try {
	    	System.out.println("Bitte maximale Prüfungen eines Studenten pro Tag angeben: ");
	    	eingabe = getEingabe();
	    	pruefungenProStudentUndTag = Integer.parseInt(eingabe);
	    	System.out.println("Prüfungen pro Student und Tag auf " + pruefungenProStudentUndTag + " gesetzt.");
	    	
	    	System.out.println("Bitte maximale Prüfungen, die an einem Tag statt finden können angeben: ");
	    	eingabe = getEingabe();
	    	pruefungenProTag = Integer.parseInt(eingabe);
	    	System.out.println("Prüfungen pro Tag auf " + pruefungenProTag + " gesetzt.");
    	}catch(java.lang.NumberFormatException e){
    		System.out.println("Fehler: Eingabe muss nummerische sein (Eingabe:" + eingabe +")");
    	}
    }
    /**
     * Methode führt Benutzer durch die Eingabe-Prozedur des Simulators
     */
    private void setSimulator(){
    	String eingabe="";
    	try {
	    	System.out.println("Bitte Anzahl der fiktiven Studenten eingeben: ");
	    	eingabe = getEingabe();
	    	anzSimStudenten = Integer.parseInt(eingabe);
	    	System.out.println("Anzahl fiktiver Studenten auf " + anzSimStudenten + " gesetzt.");
	    	
	    	System.out.println("Bitte minimale Anzahl an Buchungen eines fiktiven Studenten eingeben: ");
	    	eingabe = getEingabe();
	    	minSimBuchungen = Integer.parseInt(eingabe);
	    	System.out.println("Minimale Anzahl an Buchungen auf " + minSimBuchungen + " gesetzt.");
	    	
	    	System.out.println("Bitte maximal Anzahl an Buchungen eines fiktiven Studenten eingeben: ");
	    	eingabe = getEingabe();
	    	maxSimBuchungen = Integer.parseInt(eingabe);
	    	System.out.println("Maximale Anzahl an Buchungen auf " + maxSimBuchungen + " gesetzt.");
	    	
    	}catch(java.lang.NumberFormatException e){
    		System.out.println("Fehler: Eingabe muss nummerische sein (Eingabe:" + eingabe +")");
    	}
    }
    
    /**
     * Methode führt den Benutzer durch die Eingabe-Prozedur für das Einlesen der Eingabedaten
     */
    private void setFlatFileLeser(){
    	String eingabe="";
    	try {
	    	System.out.println("Bitte wählen Sie welche Daten Sie einlesen wollen:");
	    	System.out.println("(1) Alle Listen (Kursliste,Studentenliste,Buchungsliste).");
	    	System.out.println("(2) Nur die Kursliste - ich möchte die restlichen Daten generieren.");
	    	eingabe = getEingabe();
	    	einleseModus = Integer.parseInt(eingabe);
	    	System.out.println("Auswahl gesetzt.");
	    	
    	}catch(java.lang.NumberFormatException e){
    		System.out.println("Fehler: Eingabe muss nummerische sein (Eingabe:" + eingabe +")");
    	}
    	
    }
    /**
     * Hilfsmethode um von der Kommandozeile Eingaben entgegenzunehmen
     * @return String 
     */
    private String getEingabe(){
    	
    	//Neuen InputReader der Stdin
    	InputStreamReader isr = new InputStreamReader(System.in);
    	BufferedReader br = new BufferedReader(isr);
    	String eingabe;
    	try{
    		//Einlesen einer Zeile
    		eingabe = br.readLine();
    		//Rückgabe der Zeile
    		return eingabe;
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * Methode wertet Benutzereingaben aus und ruft die passende Methode der Ablaufsteuerung auf
     * @param eingabe der STDIO
     * @throws Exception 
     */
    private void werteEingabeAus(String eingabe) throws Exception {
		//Erstes Zeichen der Eingabe einlesen
    	char i = eingabe.charAt(0);
		//Auswahl welches Zeichen eingegeben wurde
    	switch (i) {
		case '0':
			//Programmende
			steuerung.beendeProgramm();
			break;
		case '1':
			//Dateien einlesen
			setFlatFileLeser();
			steuerung.leseDatenEin(studentenDatei, buchungsDatei, kursDatei,einleseModus);
			System.out.println("---> Daten einlesen beendet!");
			setMenu();
			break;
		case '2':
			//Simulation
			setSimulator();
			steuerung.erstelleFiktiveStudentenListe(minSimBuchungen,maxSimBuchungen,anzSimStudenten);
			System.out.println("---> Fiktive Studentenlisten erstellt!");
			setMenu();
			break;
		case '3':
			//Planungsparameter setzen
			setBedingungen();
			System.out.println("---> Planungsparameter gesetzt!");
			setMenu();
			break;
		case '4':
			//Planungslauf starten
			steuerung.startePlanungslauf(pruefungenProTag, pruefungenProStudentUndTag);
			System.out.println("---> Planung beendet!");
			setMenu();
			break;
		case '5':
			//Zufriedenheit auswerten
			steuerung.werteZufriedenheitAus();
			System.out.println("---> Zufriedenheit ausgewertet!");
			setMenu();
			break;
		case '6':
			//Daten ausgeben
			steuerung.gebeDatenAus();
			System.out.println("---> Daten ausgegeben!");
			setMenu();
			break;
		default:
			//Wenn nichts zutreffendes eingegeben wurde, dann Fehlermeldung
			System.out.println("Falsche Eingabe!!!");
			//Menü wieder aufbauen
			setMenu();
		}


    }

    /**
     * Einsprungsmethode -- Programmstart und Ablaufsteuerung
     * @param args
     * @throws Exception 
     *
     */
    public static void main(String[] args) throws Exception {
    	VAWIOrgaTool tool = new VAWIOrgaTool(args);
    }
}
