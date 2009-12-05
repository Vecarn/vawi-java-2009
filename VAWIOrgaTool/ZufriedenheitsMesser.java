import java.util.Iterator;

import AusgabeDatenVerwaltung.Datenverwaltung.Pruefungsterminplan;
import EingabeDatenVerwaltung.DatenObjekte.Student;
import EingabeDatenVerwaltung.DatenVerwaltung.Studentenliste;



/**
 * Der ZufriedenheitsMesser ist f&uuml;r die Zufriedenheitsmessung der einzelnen Studenten mit der Planung zust&auml;ndig. 
 * Dazu verwendet er den Pruefungsterminplan und die Attribute Zufriedenheit und Zeitminimierer der Studenten der Studentenliste.
 * 
 * @author Markus Bode
 */
public class ZufriedenheitsMesser {

	private Pruefungsterminplan pruefungsterminplan;
	
	private Studentenliste studentenliste;

	/**
	 * Der Konstruktor erwartet einen Pruefungsterminplan und eine Studentenliste. <br>
	 * Die Studentenliste enthaelt die gegen den Terminplan zu ueberpruefenden Studenten-Objekte. 
	 * 
	 * @param prfgtpl (Pruefungsterminplan): Von der PruefungsPlanung erstellter PruefungsTerminplan.
	 * @param stdl (Studentenliste): Die Verwaltungsliste mit den Studenten-Objekten.
	 */
	public ZufriedenheitsMesser(Pruefungsterminplan prfgtpl,Studentenliste stdl){
		this.pruefungsterminplan=prfgtpl;
		this.studentenliste=stdl;
	}
	
	/**
	 * Methode prueft alle Studenten-Objekte in der (im Konstruktor gesetzten) Studentenliste<br>
	 * auf Ihre Zufriedenheit  mit dem erstellten Pruefungsterminplan.<br>
	 * Außschlaggebend ist das Attribut <tt>zeitminimierer</tt>. <br>
	 * Die Zufriedenheit wird dann bei dem Studenten als <tt>boolean</tt> gespeichert.<br>
	 * Wenn Student zeitminimierer ist und er maximal einen Prüfungstag hat: <tt>zufriedenheit==true</tt><br>
	 * Wenn Student kein zeitminimierer ist und er nicht mehr wie 1 Prüfung pro Tag hat: <tt>zufriedenheit==true</tt><br>
	 * Bei allen anderen: <tt>zufriedenheit==false</tt>
	 */
	public void errechneZufriedenheit(){
	
		Iterator<Student> si = studentenliste.getStudentIterator();
		//alles an einem Tag -> zufrieden
		while(si.hasNext()){
			Student student = si.next();
			int anzahlPruefungstage = 0;
			//zaehle Prüfungen für Student am Tag -> merke max Pruefungen / Tag
			int maxPruefungenProTag = 0;
			//
			//pruefungsterminplan.getIterator()
			//
			if(student.getZeitminimierer()&&(anzahlPruefungstage==1)){
				//student.setZufriedenheit(true);
			}else if(!student.getZeitminimierer()&&(maxPruefungenProTag==1)){
				//student.setZufriedenheit(true);
			}else{
				//student.setZufriedenheit(false);
			}
		
		}
	
	}

}
