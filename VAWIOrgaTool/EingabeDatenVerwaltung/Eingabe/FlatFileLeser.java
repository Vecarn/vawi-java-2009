package EingabeDatenVerwaltung.Eingabe;

import java.io.IOException;
import Hilfsklassen.Datei;
import EingabeDatenVerwaltung.DatenVerwaltung.*;

/**
 * Objekte der Klasse FlatFileLeser lesen die Eingabedaten aus einfachen CSV-Dateien 
 * und übergeben diese an die entsprechenden Verwaltungsklassen zur Objekterstellung. 
 * 
 * @author Markus Bode
 */
public class FlatFileLeser {
	
	/**
	 * Datei-Objekte für jeweilige Eingabedatei.
	 */
	private Datei studentendatei;
	private Datei buchungsdatei;
	private Datei kursdatei;
	/**
	 * Verwaltungs-Objekte für jeweiligen Daten-Typ.
	 */
	private Studentenliste studentenliste;
	private Buchungsliste buchungsliste;
	private Kursliste kursliste;

	/**
	 * Konstruktor für Objekte der Klasse FlatFileLeser, welcher einen Dateinamen zu einer Kursdatei erwartet. <br>
	 * Kann z.B.: für den Simulationsprozess verwendet werden. (Nur eine Kursdatei, restl. Daten werden generiert)<br>
	 * Für Planungsprozess ungeeignet, da nur eine Kursliste mit Kurs-Objekten erstellt wird. Die anderen Listen sind null.
	 * 
	 * @param kursdateiname (String): Dateiname der Kursdatei.
	 * @throws IOException : Wenn ein Problem beim Öffnen der Datei auftritt, wird eine IOException geworfen. 
	 */
	public FlatFileLeser(String kursdateiname) throws IOException {
		
		this.kursdatei = new Datei(kursdateiname);
		this.studentendatei = null;
		this.buchungsdatei = null;
		
		if(!erstelleKursliste()){
			throw new IOException();
		}
		
	}

	/**
	 * 
	 * Konstruktor für Objekte der Klasse FlatFileLeser welcher 3 Dateinamen erwartet. <br>
	 * Kann für den normalen Planungsprozess verwendet werden. <br> 
	 * Es werden 3 Verwaltungslisten aus den entsprechenden Dateien erstellt.
	 * 
	 * @param studentendateiname (String): Dateiname der Studentendatei.
	 * @param buchungsdateiname (String): Dateiname der Buchungsdatei.
	 * @param kursdateiname (String): Dateiname der Kursdatei.
	 * @throws IOException : Wenn ein Problem beim Öffnen der Datei auftritt, wird eine IOException ausgelöst.
	 * 
	 */
	public FlatFileLeser(String studentendateiname,
			String buchungsdateiname, String kursdateiname) throws IOException {
		
		this.studentendatei = new Datei(studentendateiname);
		this.buchungsdatei = new Datei(buchungsdateiname);
		this.kursdatei = new Datei(kursdateiname);
		
		if(!erstelleStudentenliste()&&!erstelleKursliste()&&!erstelleBuchungsliste()){
			throw new IOException();
		}
		
	}
	
	/**
	 * Erstellt die Kursliste aus der Eingabedatei.
	 * 
	 * @return boolean - true: Wenn Erstellung funktioniert.<br>
	 *                 - false: Wenn Erstellung fehlschlägt.
	 */
	private boolean erstelleKursliste() {
		
		kursdatei.openInFile();
        // Abfrage, ob das öffen funktioniert hat
        if (kursdatei.state())
        {
            // Ausgabe des Fehlers im Terminalfenster
            System.out.println("Fehler: Beim öffen der Eingabedatei.");
            // Abbrechen der Methode
            return true;
        }
        
        return false;
		
	}
	
	/**
	 * Erstellt die Buchungsliste aus der Eingabedatei.
	 * 
	 * @return boolean - true: Wenn Erstellung funktioniert.<br>
	 *                 - false: Wenn Erstellung fehlschlägt.
	 */
	private boolean erstelleBuchungsliste() {
		
		//erst Studentenliste und Kursliste erstellen
		//beim erstellen neuer Buchung: buchung.setStudent(studentenliste.getStudent(id))
		//   							buchung.setKurs(kursliste.getKurs(id))
		
		buchungsdatei.openInFile();
        // Abfrage, ob das öffen funktioniert hat
        if (!buchungsdatei.state())
        {
            // Ausgabe des Fehlers im Terminalfenster
            System.out.println("Fehler: Beim öffen der Eingabedatei.");
            // Abbrechen der Methode
            return false;
        }
        
        return true;
		
	}
	
	/**
	 * Erstellt die Studentenliste aus der Eingabedatei.
	 * 
	 * @return boolean - true: Wenn Erstellung funktioniert.<br>
	 *                 - false: Wenn Erstellung fehlschlägt.
	 */
	private boolean erstelleStudentenliste() {
		studentendatei.openInFile();
        // Abfrage, ob das öffen funktioniert hat
        if (!studentendatei.state())
        {
            // Ausgabe des Fehlers im Terminalfenster
            System.out.println("Fehler: Beim öffen der Eingabedatei.");
            // Abbrechen der Methode
            return false;
        }
        
        return true;
		
	}

	/**
	 * Liefert die Studentenliste zurück, in der die Studenten-Objekte verwaltet werden, 
	 * die aus der übergebenen Datei erstellt wurden.
	 * 
	 * @return studentenliste (Studentenliste)
	 */
	public Studentenliste getStudentenliste() {
		return studentenliste;
	}

	/**
	 * Liefert die Buchungsliste zurück, in der die Buchungs-Objekte verwaltet werden, 
	 * die aus der übergebenen Datei erstellt wurden.
	 * 
	 * @return buchungsliste (Buchungsliste)
	 */
	public Buchungsliste getBuchungsliste() {
		return buchungsliste;
	}

	/**
	 * Liefert die Kursliste zurück, in der die Kurs-Objekte verwaltet werden, 
	 * die aus der übergebenen Datei erstellt wurden.
	 * 
	 * @return kursliste (Kursliste)
	 */
	public Kursliste getKursliste() {
		return kursliste;
	}
	
	
}
