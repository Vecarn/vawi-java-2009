package EingabeDatenVerwaltung.Eingabe;

import Hilfsklassen.Datei;
import EingabeDatenVerwaltung.DatenVerwaltung.*;

/**
 * Der FlatFileLeser ist eine Realisierung des Datenleser, der die EingabeDaten
 * mit Hilfe der Hilfsklasse Datei aus FlatFiles liest.
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
	 * Konstruktor für Objekte der Klasse FlatFileLeser welcher einen Dateinamen zu einer Kursdatei erwartet. <br>
	 * Kann für den Simulationsprozess verwendet werden. <br>
	 * (nur eine Kursdatei, restl. Daten werden generiert)
	 * 
	 * @param kursdateiname (String): Dateiname der Kursdatei.
	 */
	public FlatFileLeser(String kursdateiname) {
		
		this.kursdatei = new Datei(kursdateiname);
		this.studentendatei = null;
		this.buchungsdatei = null;
		erstelleKursliste();
	}

	/**
	 * 
	 * Konstruktor für Objekte der Klasse FlatFileLeser welcher 3 Dateinamen erwartet. <br>
	 * Kann für den normalen Planungsprozess verwendet werden, 
	 * wenn 3 Verwaltungslisten aus den entsprechenden Dateien erstellt werden sollen.
	 * 
	 * @param studentendateiname (String): Dateiname der Studentendatei.
	 * @param buchungsdateiname (String): Dateiname der Buchungsdatei.
	 * @param kursdateiname (String): Dateiname der Kursdatei.
	 * @poseidon-object-id [I2d0758e8m124d537380cmm76d2]
	 * 
	 */
	public FlatFileLeser(String studentendateiname,
			String buchungsdateiname, String kursdateiname) {
		
		this.studentendatei = new Datei(studentendateiname);
		this.buchungsdatei = new Datei(buchungsdateiname);
		this.kursdatei = new Datei(kursdateiname);
		
		erstelleStudentenliste();
		erstelleBuchungsliste();
		erstelleKursliste();

	}
	
	private void erstelleKursliste() {
		// TODO Auto-generated method stub
		
	}

	private void erstelleBuchungsliste() {
		// TODO Auto-generated method stub
		
	}

	private void erstelleStudentenliste() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return studentenliste (Studentenliste)
	 */
	public Studentenliste getStudentenliste() {
		return studentenliste;
	}

	/**
	 * @return buchungsliste (Buchungsliste)
	 */
	public Buchungsliste getBuchungsliste() {
		return buchungsliste;
	}

	/**
	 * @return kursliste (Kursliste)
	 */
	public Kursliste getKursliste() {
		return kursliste;
	}
	
	
}
