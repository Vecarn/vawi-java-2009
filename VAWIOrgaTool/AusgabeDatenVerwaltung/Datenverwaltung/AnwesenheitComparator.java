package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.Comparator;

import AusgabeDatenVerwaltung.DatenObjekte.Anwesenheit;
import EingabeDatenVerwaltung.DatenObjekte.Student;

/**
 * Die Klasse StudentenComparator implementiert {@link java.util.Comparator}.<br>
 * Der Comperator muss damit nicht von der zu vergleichenden Klasse implementiert werden.<br>
 * Anhand des Return-Codes von compare können die Objekte zum Beispiel in ein TreeSet eingeordnet werden.<br>
 * 
 * @author Markus Bode
 * @version 1.0 vom 6.12.2009
 */
public class AnwesenheitComparator implements Comparator<Anwesenheit> {
	
	/**
	 * 
	 */
	public int compare(Anwesenheit arg0, Anwesenheit arg1) {
				
		return arg0.getStudent().getMatrikelnr()-arg1.getStudent().getMatrikelnr();
	}

}
