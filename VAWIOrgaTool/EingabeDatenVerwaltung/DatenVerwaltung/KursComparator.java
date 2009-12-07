package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.Comparator;

import EingabeDatenVerwaltung.DatenObjekte.Kurs;

/**
 * Die Klasse KursComparator implementiert {@link java.util.Comparator} zum vergleich von Kurs-Objekten.<br>
 * Anhand des Return-Codes von <code>compare</code> können die zu vergleichenden Kurs-Objekte in eine Collection 
 * gespeichert werden. <br> Bei Return-Code 0 liegen aus Sicht der Anwendung identische Kurs-Objekte vor. 
 * Bei RC<0 ist die KursId des ersten Objektes < der KursId des zweiten Objektes. Bei RC>0 entsprechend umgekehrt. <br>
 *
 * @author Markus Bode
 * @version 1.0 vom 05.12.2009
 */
public class KursComparator implements Comparator<Kurs> {

	/**
	 * Methode vergleicht zwei Kurs-Objekte anhand der KursId.
	 * 
	 * @param arg0 (Kurs): Zu vergleichendes Kurs-Objekt. 
	 * @param arg1 (Kurs): Zu vergleichendes Kurs-Objekt.
	 * @return int - 0: Kurs-Objekte identisch (gleiche KursId)<br>
	 * 				<0: KursId arg0 < KursId arg1<br>
	 * 				>0: KursId arg0 > KursId arg1
	 */
	public int compare(Kurs arg0, Kurs arg1) {
		
		return arg0.getKursid()-arg1.getKursid();
	
	}

}
