import java.util.Iterator;

import AusgabeDatenVerwaltung.DatenObjekte.Pruefungstag;
import AusgabeDatenVerwaltung.Datenverwaltung.Pruefungsterminplan;
import EingabeDatenVerwaltung.DatenObjekte.Buchung;
import EingabeDatenVerwaltung.DatenObjekte.Kurs;
import EingabeDatenVerwaltung.DatenObjekte.Student;
import EingabeDatenVerwaltung.DatenVerwaltung.Buchungsliste;
import EingabeDatenVerwaltung.DatenVerwaltung.Studentenliste;



/**
 * Der ZufriedenheitsMesser ist f&uuml;r die Zufriedenheitsmessung der einzelnen Studenten mit der Planung zust&auml;ndig. <br>
 * Dazu verwendet er den Pruefungsterminplan und die Attribute Zufriedenheit und Zeitminimierer der Studenten der Studentenliste.
 * 
 * @author Markus Bode
 * @version 1.0 vom 6.12.2009
 */
public class ZufriedenheitsMesser {

	private Pruefungsterminplan pruefungsterminplan;
	
	private Studentenliste studentenliste;
	
	private Buchungsliste buchungsliste;

	/**
	 * Der Konstruktor erwartet einen Pruefungsterminplan und eine Studentenliste. <br>
	 * Die Studentenliste enthaelt die gegen den Terminplan zu ueberpruefenden Studenten-Objekte. 
	 * 
	 * @param prfgtpl (Pruefungsterminplan): Von der PruefungsPlanung erstellter PruefungsTerminplan.
	 * @param stdl (Studentenliste): Die Verwaltungsliste mit den Studenten-Objekten.
	 */
	public ZufriedenheitsMesser(Pruefungsterminplan prfgtpl,Studentenliste stdl,Buchungsliste bl){
		
		this.pruefungsterminplan=prfgtpl;
		this.studentenliste=stdl;
		this.buchungsliste=bl;
	}
	
	/**
	 * Methode prueft alle Studenten-Objekte in der (im Konstruktor gesetzten) Studentenliste<br>
	 * auf Ihre Zufriedenheit  mit dem erstellten Pruefungsterminplan.<br>
	 * Au�schlaggebend ist das Attribut <tt>zeitminimierer</tt>. <br>
	 * Die Zufriedenheit wird dann bei dem Studenten als <tt>boolean</tt> gespeichert.<br>
	 * Wenn Student zeitminimierer ist und er maximal einen Pr�fungstag hat: <tt>zufriedenheit==true</tt><br>
	 * Wenn Student kein zeitminimierer ist und er nicht mehr wie 1 Pr�fung pro Tag hat: <tt>zufriedenheit==true</tt><br>
	 * Bei allen anderen: <tt>zufriedenheit==false</tt>
	 * 
	 * @return Studentenliste: Liste mit Studentenobjekten die gepr�ft wurden
	 * 
	 */
	public Studentenliste errechneZufriedenheit(){
		
		if(pruefungsterminplan==null||studentenliste==null){
			System.out.println("Pr�fungsterminplan oder Studentenliste ist noch null! -> keine Errechnung");
			return null;
		}
		
		Iterator<Student> si = studentenliste.getStudentIterator();
				
		System.out.println("-"+studentenliste.getSize()+"-");
		//alles an einem Tag -> zufrieden
		while(si.hasNext()){
			Student student = si.next();
			int anzahlPruefungstage = 0;
			//zaehle Pr�fungen f�r Student am Tag -> merke max Pruefungen / Tag
			int maxPruefungenProTag = 0;
			
			Iterator<Pruefungstag> pi = pruefungsterminplan.getPruefungsplanIterator();
						
			while(pi.hasNext()){
				Pruefungstag pruefungstag = pi.next();
				Studentenliste sl = pruefungstag.getTagesStudentenliste();
								
				//wenn der Student in der Studentenliste des Tages ist, muss der Tag in die Betrachtung mit einflie�en
				//anzahl Tage erh�ht sich und es muss gepr�ft werden wieviele Kurse der Student schreibt
				if(sl.containsStudent(student)){
						
						anzahlPruefungstage++;
						//Anzahl Kurse die der Student an diesem Tag schreibt
						int kurse = 0;
						
						//alle Buchungen des aktuellen Studenten
						Iterator<Buchung> bi = buchungsliste.getBuchungen(student).getIterator();
						
						while(bi.hasNext()){
							Kurs k = bi.next().getKurs();
							
							//pr�fe ob der Kurs des aktuellen Buchungsobjektes in der Tageskursliste enthalten ist
							//wenn ja, dann muss der Z�hle f�r die Kurse die der Student an diesem Tag schreibt erh�ht werden
							if(pruefungstag.getTagesKursliste().containsKurs(k)){
								kurse++;
							}
						}
						
						//pr�fe ob die Anzahl der von diesem Student zu schreibenden Kurse an diesem Tag
						//gr��er ist wie die Anzahl der Kurse die er an den letzten gepr�ften Tagen schreiben musste
						//--> die maximale Anzahl an zu schreibenden Pr�fungen / Tag wird gespeichert
						if(kurse>maxPruefungenProTag){
							maxPruefungenProTag=kurse;
						}
				
				}
			}
			
			if(student.getZeitminimierer()&&(anzahlPruefungstage==1)){
				student.setZufrieden(true);
			}else if(!student.getZeitminimierer()&&(maxPruefungenProTag==1)){
				student.setZufrieden(true);
			}else{
				student.setZufrieden(false);
			}
		
		}
	
	return studentenliste;
	
	}

}
