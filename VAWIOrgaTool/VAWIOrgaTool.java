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
 */
public class VAWIOrgaTool {
	
	private String pfad;
	private Ablaufsteuerung steuerung = new Ablaufsteuerung();
	
	private static String studentenDatei = "studenten.txt";
	private static String kursDatei = "kurse.txt";
	private static String buchungsDatei = "buchungen.txt";
	
	private static int pruefungenProTag=3;
	private static int pruefungenProStudentUndTag=3;
	
	VAWIOrgaTool(String args[]) throws Exception{
		System.out.println("VAWIOrgaTool 1 der Gruppe 5");
		System.out.println("---------------------------");
		File f = new File("");
		pfad = f.getAbsolutePath() + "\\";
		init(args);
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
		for (int i = 0; i < args.length; i++) {
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
	    	System.out.println("Prüfungen pro Tag auf " + pruefungenProStudentUndTag + " gesetzt.");
    	}catch(java.lang.NumberFormatException e){
    		System.out.println("Fehler: Eingabe muss nummerische sein (Eingabe:" + eingabe +")");
    	}
    }

    private String getEingabe(){
    	
    	InputStreamReader isr = new InputStreamReader(System.in);
    	BufferedReader br = new BufferedReader(isr);
    	String eingabe;
    	try{
    		eingabe = br.readLine();
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
    		char i = eingabe.charAt(0);
			switch (i) {
			case '0':
				steuerung.beendeProgramm();
				break;
			case '1':
				steuerung.leseDatenEin(studentenDatei, buchungsDatei, kursDatei);
				System.out.println("---> Daten einlesen beendet!");
				setMenu();
				break;
			case '2':
				steuerung.erstelleFiktiveStudentenListe();
				System.out.println("---> Fiktive Studentenlisten erstellt!");
				setMenu();
				break;
			case '3':
				setBedingungen();
				System.out.println("---> Planungsparameter gesetzt!");
				setMenu();
				break;
			case '4':
				steuerung.startePlanungslauf(pruefungenProTag, pruefungenProStudentUndTag);
				System.out.println("---> Planung beendet!");
				setMenu();
				break;
			case '5':
				steuerung.werteZufriedenheitAus();
				System.out.println("---> Zufriedenheit ausgewertet!");
				setMenu();
				break;
			case '6':
				steuerung.gebeDatenAus();
				System.out.println("---> Daten ausgegeben!");
				setMenu();
				break;
			default:
				System.out.println("Falsche Eingabe!!!");
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
