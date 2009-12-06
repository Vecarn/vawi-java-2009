package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.Comparator;

import EingabeDatenVerwaltung.DatenObjekte.Student;

/**
 * Die Klasse StudentenComparator implementiert {@link java.util.Comparator}.<br>
 * Der Comperator muss damit nicht von der zu vergleichenden Klasse implementiert werden.<br>
 * Anhand des Return-Codes von compare können die Objekte zum Beispiel in ein TreeSet eingeordnet werden.<br>
 * 
 * @author Markus Bode
 * @version 1.0 vom 6.12.2009
 */
public class StudentenComparator implements Comparator<Student> {
	
	/**
	 * Methode erwartet beide zu vergleichende Studenten-Objekte.
	 * Die Studenten werden nach Ihrer MatrikelNr geordnet.
	 * 
	 * @param arg0 (Student) - Zu vergleichendes Studenten-Objekt
	 * @param arg1 (Student) - Zu vergleichendes Studenten-Objekt
	 * @return	int <0: Der erste Parameter ist ungergeordnet <br>
	 *			     0: Die Objekte besitzen die gleiche MatrikelNr <br>
	 *			    >0: Der erste Parameter ist übergeordnet
	 */
	public int compare(Student arg0, Student arg1) {
				
		return arg0.getMatrikelnr()-arg1.getMatrikelnr();
	}

}
