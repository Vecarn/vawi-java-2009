import EingabeDatenVerwaltung.DatenVerwaltung.*;

/**
 * Der Simulatorist eine Logikklasse, die fiktive Kursbelegungen fuer jeden Studenten anleget. <br>
 * Sie verwendet einge gegebene Kursliste als Eingabe. <br>
 * Mit zufallsgenerierten Studenten wird eine zuf�llige Buchungsliste erstellt.
 * 
 * 
 * @author Markus Bode
 * @version 1.0 vom 8.12.2009
 */
public class Simulator {

	private Kursliste kursliste;
	private Buchungsliste generierteBuchungsliste;
	private Studentenliste  generierteStudentenliste;
	
	/**
	 * Konstruktor f�r den Simulator, der lediglich eine Kursliste erwartet.<br>
	 * Au�derdem wird die Generierung der Daten angesto�en.
	 * 
	 * @param kursliste (Kursliste) - eine Kursliste mit Kurs-Objekten aus der gegebenen Kursdatei.
	 */
	public Simulator(Kursliste kursliste){
		
		this.kursliste=kursliste;
		generiereDaten();
		
	}
	
	private void generiereDaten(){
		kursliste.getKursIterator();
	}
	
	/**
	 * Liefert die Buchungsliste zur�ck, in der die Buchungs-Objekte verwaltet werden, 
	 * die mittels der gegebenen Kursliste und den generierten Studenten-Objekten erstellt wurden.
	 * 
	 * @return buchungsliste (Buchungsliste) - Buchungsliste mit generieten Buchungs-Objekten.
	 */
	public Buchungsliste getBuchungsliste(){
		return generierteBuchungsliste;
	}
	
	/**
	 * Liefert die Studentenliste zur�ck, in der die Studenten-Objekte verwaltet werden, 
	 * die zuf�llig generiert wurden.
	 * 
	 * @return studentenliste (Studentenliste) - Studentenliste mit generierten Studenten-Objekten.
	 */
	public Studentenliste getStudentenliste(){
		return generierteStudentenliste;
	}
	

}
