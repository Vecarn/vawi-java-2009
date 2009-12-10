package EingabeDatenVerwaltung.Eingabe;

import java.io.IOException;
import Hilfsklassen.Datei;
import EingabeDatenVerwaltung.DatenVerwaltung.*;

/**
 * Die Klasse FlatFileLeser liest die Eingabedaten aus einfachen CSV-Dateien 
 * und �bergibt die einzelnen Datens�tze an die entsprechenden Verwaltungsklassen zur Objekterstellung. 
 * 
 * @author Markus Bode
 * @version 1.0 vom 6.12.2009
 */
public class FlatFileLeser {
	
	/**
	 * Datei-Objekte f�r jeweilige Eingabedatei.
	 */
	private Datei studentendatei;
	private Datei buchungsdatei;
	private Datei kursdatei;
	/**
	 * Verwaltungs-Objekte f�r jeweiligen Daten-Typ.
	 */
	private Studentenliste studentenliste;
	private Buchungsliste buchungsliste;
	private Kursliste kursliste;

	/**
	 * Konstruktor f�r Objekte der Klasse FlatFileLeser, welcher einen Dateinamen zu einer Kursdatei erwartet. <br>
	 * Kann z.B.: f�r den Simulationsprozess verwendet werden. (Nur eine Kursdatei, restl. Daten werden generiert)<br>
	 * F�r Planungsprozess ungeeignet, da nur eine Kursliste mit Kurs-Objekten erstellt wird. Die anderen Listen sind null.
	 * 
	 * @param kursdateiname (String): Dateiname der Kursdatei.
	 * @throws IOException : Wenn ein Problem beim �ffnen der Datei auftritt, wird eine IOException geworfen. 
	 */
	public FlatFileLeser(String kursdateiname) throws IOException {
		
		this.kursdatei = new Datei(kursdateiname);
		this.studentendatei = null;
		this.buchungsdatei = null;
		
		erstelleKursliste();
		
		
	}

	/**
	 * 
	 * Konstruktor f�r Objekte der Klasse FlatFileLeser welcher 3 Dateinamen erwartet. <br>
	 * Kann f�r den normalen Planungsprozess verwendet werden. <br> 
	 * Es werden 3 Verwaltungslisten aus den entsprechenden Dateien erstellt.
	 * 
	 * @param studentendateiname (String): Dateiname der Studentendatei.
	 * @param buchungsdateiname (String): Dateiname der Buchungsdatei.
	 * @param kursdateiname (String): Dateiname der Kursdatei.
	 * @throws IOException : Wenn ein Problem beim �ffnen der Datei auftritt, wird eine IOException ausgel�st.
	 * 
	 */
	public FlatFileLeser(String studentendateiname,
			String buchungsdateiname, String kursdateiname) throws IOException {
		
		this.studentendatei = new Datei(studentendateiname);
		this.buchungsdatei = new Datei(buchungsdateiname);
		this.kursdatei = new Datei(kursdateiname);
		
		erstelleKursliste();
		erstelleBuchungsliste();
		erstelleStudentenliste();
		
	}
	
	/**
	 * Erstellt die Kursliste aus der Eingabedatei.
	 * 
	 */
	private void erstelleKursliste() throws IOException {
		
		kursdatei.openInFile();
        // Abfrage, ob das �ffen funktioniert hat
        if (kursdatei.state()){
        	        
        }else{
        	throw new IOException("Fehler: Beim �ffen der Eingabedatei - Kursliste.");   
        }
		
	}
	
	/**
	 * Erstellt die Buchungsliste aus der Eingabedatei.
	 * 
	 */
	private void erstelleBuchungsliste() throws IOException {
		
		//erst Studentenliste und Kursliste erstellen
		//beim erstellen neuer Buchung: buchung.setStudent(studentenliste.getStudent(id))
		//   							buchung.setKurs(kursliste.getKurs(id))
		
		buchungsdatei.openInFile();
        // Abfrage, ob das �ffen funktioniert hat
        if (buchungsdatei.state()){
            //logik
        }else{
        	throw new IOException("Fehler: Beim �ffen der Eingabedatei - Buchungsliste.");
        }
		
	}
	
	/**
	 * Erstellt die Studentenliste aus der Eingabedatei.
	 * 
	 */
	private void erstelleStudentenliste() throws IOException {
		studentendatei.openInFile();
        // Abfrage, ob das �ffen funktioniert hat
        if (studentendatei.state()){
        	//logik
        }else{
          	throw new IOException("Fehler: Beim �ffen der Eingabedatei - Studentenliste.");          
        }
		
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
