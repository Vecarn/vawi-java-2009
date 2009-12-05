package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.Comparator;
import EingabeDatenVerwaltung.DatenObjekte.Buchung;

/**
 * Die Klasse BuchungsComparator implementiert {@link java.util.Comparator} zum vergleich von Buchungs-Objekten.<br>
 * Anhand des Return-Codes von <code>compare</code> können die zu vergleichenden Buchungs-Objekte in eine Collection 
 * gespeichert werden. <br> Bei Return-Code 0 liegen aus Sicht der Anwendung identische Buchungs-Objekte vor. 
 * Bei -1 ist die KursId des ersten Objektes <= der KursId des zweiten Objektes. Bei 1 entsprechend umgekehrt.
 * 
 * @author Markus Bode
 * @version 1.0 vom 05.12.2009
 */
public class BuchungsComparator implements Comparator<Buchung> {
	
	@Override
	/**
	 * Methode vergleicht zwei Buchungs-Objekte anhand der KursId und der Matrikel-Nummer des Studenten.
	 * 
	 * @parm arg0 (Buchung): Zu vergleichendes Buchungs-Objekt. 
	 * @parm arg1 (Buchung): Zu vergleichendes Buchungs-Objekt.
	 * @return int - 0: Buchungsobjekte identisch (KursId und Matrikel-Nummer gleich)
	 * 				-1: KursId arg0 <= KursId arg1
	 * 				 1: KursId arg0 > KursId arg1
	 */
	public int compare(Buchung arg0, Buchung arg1) {

		int k0 = arg0.getKurs().getKursid();
		int s0 = arg0.getStudent().getMatrikelnr();
				
		int k1 = arg1.getKurs().getKursid();
		int s1 = arg1.getStudent().getMatrikelnr();
				
		if((k0==k1)&&(s0==s1)){
			return 0;
		}else{
			if(k0==k1){
				if(s0<s1){
					return -1;
				}else if(s0>s1){
					return 1;
				}
			}else if(k0<k1){
				return -1;
			}else if(k0>k1){
				return 1;
			}
		}

		return 0;
	}
}