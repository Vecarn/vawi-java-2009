package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.Comparator;

import EingabeDatenVerwaltung.DatenObjekte.Student;
/**
 * Die Klasse StudentenComparator implementiert {@link java.util.Comparator}.
 * Der Comperator muss damit nicht von der zu vergleichenden Klasse implementiert werden.
 * 
 * @author Markus Bode
 *
 */
public class StudentenComparator implements Comparator<Student> {
	/**
	 * Methode erwartet beide zu vergleichende Studenten-Objekte.
	 * Die Studenten werden nach ID geordnet.
	 * 
	 * 
	 * @return	negativer R�ckgabewert: Der erste Parameter ist ungergeordnet
	 *			0 als R�ckgabewert: Beide Parameter werden gleich eingeordnet
	 *			positiver R�ckgabewert: Der erste Parameter ist �bergeordnet
	 * @Override 
	 */
	
	public int compare(Student arg0, Student arg1) {
		//System.out.println("compare:"+arg0.getMatrikelnr()+" und: "+arg1.getMatrikelnr());
		
		return arg0.getMatrikelnr()-arg1.getMatrikelnr();
		//return -1;
	}

}
