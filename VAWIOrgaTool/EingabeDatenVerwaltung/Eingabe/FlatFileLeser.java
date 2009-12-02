package EingabeDatenVerwaltung.Eingabe;

import java.io.IOException;
import Hilfsklassen.Datei;
import EingabeDatenVerwaltung.DatenVerwaltung.*;

/**
 * Objekte der Klasse FlatFileLeser lesen die Eingabedaten aus einfachen CSV Dateien
 * 
 * @author Markus Bode
 */
public class FlatFileLeser {
	/**
	 * 
	 * 
	 * 
	 */
	private Datei studentendatei;
	private Datei buchungsdatei;
	private Datei kursdatei;
	
	private Studentenliste studentenliste;
	private Buchungsliste buchungsliste;
	private Kursliste kursliste;

	/**
	 * Konstruktor f�r Objekte der Klasse FlatFileLeser welcher einen Dateinamen zu einer Kursdatei erwartet. <br>
	 * Kann f�r den Simulationsprozess verwendet werden. <br>
	 * (nur eine Kursdatei, restl. Daten werden generiert)
	 * 
	 * @param kursdateiname (String): Dateiname der Kursdatei.
	 * @throws IOException : Wenn ein Problem beim �ffnen der Datei auftritt, wird eine IOException ausgel�st. 
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
	 * Konstruktor f�r Objekte der Klasse FlatFileLeser welcher 3 Dateinamen erwartet. <br>
	 * Kann f�r den normalen Planungsprozess verwendet werden, 
	 * wenn 3 Verwaltungslisten aus den entsprechenden Dateien erstellt werden sollen.
	 * 
	 * @param studentendateiname (String): Dateiname der Studentendatei.
	 * @param buchungsdateiname (String): Dateiname der Buchungsdatei.
	 * @param kursdateiname (String): Dateiname der Kursdatei.
	 * @throws IOException : Wenn ein Problem beim �ffnen der Datei auftritt, wird eine IOException ausgel�st.
	 * @poseidon-object-id [I2d0758e8m124d537380cmm76d2]
	 * 
	 */
	public FlatFileLeser(String studentendateiname,
			String buchungsdateiname, String kursdateiname) throws IOException {
		
		this.studentendatei = new Datei(studentendateiname);
		this.buchungsdatei = new Datei(buchungsdateiname);
		this.kursdatei = new Datei(kursdateiname);
		
		if(!erstelleStudentenliste()||!erstelleKursliste()||!erstelleBuchungsliste()){
			throw new IOException();
		}
		
	}
	
	private boolean erstelleKursliste() {
		
		kursdatei.openInFile();
        // Abfrage, ob das �ffen funktioniert hat
        if (!kursdatei.state())
        {
            // Ausgabe des Fehlers im Terminalfenster
            System.out.println("Fehler: Beim �ffen der Eingabedatei.");
            // Abbrechen der Methode
            return false;
        }
        
        return true;
		
	}

	private boolean erstelleBuchungsliste() {
		
		//erst Studentenliste und Kursliste erstellen
		//beim erstellen neuer Buchung: buchung.setStudent(studentenliste.getStudent(id))
		//   							buchung.setKurs(kursliste.getKurs(id))
		
		buchungsdatei.openInFile();
        // Abfrage, ob das �ffen funktioniert hat
        if (!buchungsdatei.state())
        {
            // Ausgabe des Fehlers im Terminalfenster
            System.out.println("Fehler: Beim �ffen der Eingabedatei.");
            // Abbrechen der Methode
            return false;
        }
        
        return true;
		
	}

	private boolean erstelleStudentenliste() {
		studentendatei.openInFile();
        // Abfrage, ob das �ffen funktioniert hat
        if (!studentendatei.state())
        {
            // Ausgabe des Fehlers im Terminalfenster
            System.out.println("Fehler: Beim �ffen der Eingabedatei.");
            // Abbrechen der Methode
            return false;
        }
        
        return true;
		
	}

	/**
	 * Liefert die Studentenliste zur�ck, in der die Studenten-Objekte verwaltet werden, 
	 * die aus der �bergebenen Datei erstellt wurden.
	 * 
	 * @return studentenliste (Studentenliste)
	 */
	public Studentenliste getStudentenliste() {
		return studentenliste;
	}

	/**
	 * Liefert die Buchungsliste zur�ck, in der die Buchungs-Objekte verwaltet werden, 
	 * die aus der �bergebenen Datei erstellt wurden.
	 * 
	 * @return buchungsliste (Buchungsliste)
	 */
	public Buchungsliste getBuchungsliste() {
		return buchungsliste;
	}

	/**
	 * Liefert die Kursliste zur�ck, in der die Kurs-Objekte verwaltet werden, 
	 * die aus der �bergebenen Datei erstellt wurden.
	 * 
	 * @return kursliste (Kursliste)
	 */
	public Kursliste getKursliste() {
		return kursliste;
	}
	
	
}
