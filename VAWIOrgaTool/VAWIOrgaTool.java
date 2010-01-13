
/**
 * VAWIOrgaTool enthaelt die Main-Methode und Methoden eines rudimentaeren UI zur Steuerung des Programms durch einen Benutzer
 *
 * @author Joern Hauser
 */
public class VAWIOrgaTool {

    /**
     * Methode baut das Menue zur Benutzerfuehrung auf
     */
    public void setMenu() {
    }

    /**
     * Methode wertet Benutzereingaben aus und ruft die passende Methode der Ablaufsteuerung auf
     * @param eingabe der STDIO
     */
    public void werteEingabeAus(String eingabe) {
    }

    /**
     * Einsprungsmethode -- Programmstart und Ablaufsteuerung
     * @param args
     * @throws Exception 
     *
     */
    public static void main(String[] args) throws Exception {
    	String pfad = "C:/Users/Dahausa/workspace/VAWIOrgaTool/";
    	Ablaufsteuerung steuerung = new Ablaufsteuerung();
    	steuerung.leseDatenEin(pfad + "studenten.txt", pfad + "buchungen.txt", pfad + "kurse.txt");
    	steuerung.startePlanungslauf(3, 3);
    }
}
