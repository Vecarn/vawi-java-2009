import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;


/**
 * VAWIOrgaTool enthaelt die Main-Methode und Methoden eines rudimentaeren UI zur Steuerung des Programms durch einen Benutzer
 *
 * @author Joern Hauser
 */
public class VAWIOrgaTool {
	
	private String pfad;
	private Ablaufsteuerung steuerung = new Ablaufsteuerung();
	
	private static final String studentenDatei = "studenten.txt";
	private static final String kursDatei = "kurse.txt";
	private static final String buchungsDatei = "buchungen.txt";
	
	private static final int pruefungenProTag=3;
	private static final int pruefungenProStudentUndTag=3;
	
	VAWIOrgaTool(){
		File f = new File("");
		pfad = f.getAbsolutePath() + "\\";
		setMenu();
	}
	

    /**
     * Methode baut das Menue zur Benutzerfuehrung auf
     */
    public void setMenu() {
    	System.out.println();
    	System.out.println("VAWIOrgaTool 1.0 der Gruppe 5");
    	System.out.println("-----------------------------");
    	System.out.println("Auswahl:");
    	System.out.println("(1) Daten einlesen");
    	System.out.println("(2) Fiktive Studenten erstellen");
    	System.out.println("(3) Prüfungstermine planen");
    	System.out.println("(4) Zufriedenheit errechnen");
    	System.out.println("(5) Daten ausgeben");
    	System.out.println("(0) Programm beenden");
    	System.out.println();
    	System.out.println("Eingabe:");
    	
    	
    	InputStreamReader isr = new InputStreamReader(System.in);
    	BufferedReader br = new BufferedReader(isr);
    	String input;
    	char eingabe;
    	try{
    		input = br.readLine();
    		eingabe = input.charAt(0);
    		werteEingabeAus(eingabe);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
     * Methode wertet Benutzereingaben aus und ruft die passende Methode der Ablaufsteuerung auf
     * @param eingabe der STDIO
     * @throws Exception 
     */
    public void werteEingabeAus(char eingabe) throws Exception {
    	
			switch (eingabe) {
			case '0':
				System.out.println("Beende Programm!");
				steuerung.beendeProgramm();
				break;
			case '1':
				steuerung.leseDatenEin(pfad + studentenDatei, pfad + buchungsDatei, pfad + kursDatei);
				System.out.println("---> Daten einlesen beendet!");
				setMenu();
				break;
			case '2':
				steuerung.erstelleFiktiveStudentenListe();
				System.out.println("---> Fiktive Studentenlisten erstellt!");
				setMenu();
				break;
			case '3':
				steuerung.startePlanungslauf(pruefungenProTag, pruefungenProStudentUndTag);
				System.out.println("---> Planung beendet!");
				setMenu();
				break;
			case '4':
				steuerung.werteZufriedenheitAus();
				System.out.println("---> Zufriedenheit ausgewertet!");
				setMenu();
				break;
			case '5':
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
    	VAWIOrgaTool tool = new VAWIOrgaTool();
    }
}
