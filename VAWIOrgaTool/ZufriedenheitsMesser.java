import java.text.DecimalFormat;
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
	 * @param bl (Buchungsliste): Die Verwaltungsliste mit den Buchungs-Objekten.
	 */
	public ZufriedenheitsMesser(Pruefungsterminplan prfgtpl,Studentenliste stdl,Buchungsliste bl){
		//setze Instanzvariablen
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
		
		//gib null zur�ck wenn Methode aufgerufen wird ohne g�ltige Verwaltungslisten 
		if(pruefungsterminplan==null||studentenliste==null||buchungsliste==null){
			System.out.println("Pr�fungsterminplan, Studentenliste oder Buchungsliste ist noch null! -> keine Errechnung");
			return null;
		}
		//hole Iterator �ber alle Studenten
		Iterator<Student> si = studentenliste.getStudentIterator();
		System.out.println("****** Start Zufriedenheitsberechnung.*********");
		System.out.println("----------------------------------------------------");
		System.out.println("Name, Vorname\t\tisZeitminimierer|isZufrieden\nMatrikelNr");
		System.out.println("----------------------------------------------------");
		
		//Anzahl der zufriedenen Studenten
		int anzahlZufrieden = 0;
		
		//Pr�fe jeden einzelnen Studenten
		while(si.hasNext()){
			Student student = si.next();
			//Anzahl der Pr�fungstage an denen der Student erscheinen muss
			int anzahlPruefungstage = 0;
			
			//maximale Anzahl an Pr�fungen pro Tag die der Student an den Pr�fungstagen schreiben muss 
			int maxPruefungenProTag = 0;
			
			//Iterator �ber alle Pr�fungstage
			Iterator<Pruefungstag> pi = pruefungsterminplan.getPruefungsplanIterator();
			
			//pr�fe jeden Pr�fungstag
			while(pi.hasNext()){
				Pruefungstag pruefungstag = pi.next();
				//Studentenliste mit Studenten die an diesem Tag Pr�fung schreiben m�ssen
				Studentenliste sl = pruefungstag.getTagesStudentenliste();
								
				//wenn der Student in der Studentenliste des Tages ist, muss der Tag in die Betrachtung mit einflie�en
				//die anzahlPruefungstage erh�ht sich und es muss gepr�ft werden wieviele Kurse der Student an diesem Tag schreibt
				if(sl.containsStudent(student)){
						
						anzahlPruefungstage++;
						
						//Anzahl Kurse die der Student an diesem Tag schreibt
						int kurse = 0;
						
						//alle Buchungen des aktuellen Studenten
						Iterator<Buchung> bi = buchungsliste.getBuchungen(student).getIterator();
						
						//pr�fe alle Buchungen des Studenten
						while(bi.hasNext()){
							
							Kurs k = bi.next().getKurs();
							
							//pr�fe ob der Kurs des aktuellen Buchungsobjektes in der Tageskursliste enthalten ist
							//wenn ja, dann muss der Z�hler f�r die Kurse die der Student an diesem Tag schreibt erh�ht werden
							//(Student muss an diesem Tag zu dieser Pr�fung erscheinen)
							if(pruefungstag.getTagesKursliste().containsKurs(k)){
								kurse++;
							}
						}
						
						//pr�fe ob die Anzahl der von diesem Student zu schreibenden Kurse an diesem Tag
						//gr��er ist wie die Anzahl der Kurse die er an den letzten gepr�ften Tagen schreiben musste
						//--> die maximale Anzahl an zu schreibenden Pr�fungen pro Tag aller Pr�fungstage wird gespeichert
						if(kurse>maxPruefungenProTag){
							maxPruefungenProTag=kurse;
						}
				
				}
			}
			
			if(student.getZeitminimierer()&&(anzahlPruefungstage==1)){
				// der Zeitminimierer-Student hat nur an einem Pr�fungstag zu erscheinen -> er ist zufrieden
				anzahlZufrieden++;
				//setze Zufrieden
				student.setZufrieden(true);
			}else if(!student.getZeitminimierer()&&(maxPruefungenProTag==1)){
			   // der nicht Zeitminimierer-Student schreibt maximal eine Pr�fung pro Tag im ganzen Pr�fungsterminplan -> er ist zufrieden
				anzahlZufrieden++;
				student.setZufrieden(true);
			}else{
				// mit allen anderen Konstellationen sind die Studenten unzufrieden
				// ..>  zeitminimierer==true && anzahlPruefungstage > 1
				//		zeitminimierer==false && maxPruefungenProTag > 1
				student.setZufrieden(false);
			}
			System.out.println(student.getName()+", "+student.getVorname());
			System.out.println(student.getMatrikelnr()+"\t\t\t"+student.getZeitminimierer()+"\t\t "+student.getZufrieden());
			System.out.println("--------------------------------------------------");
			
		}
	
	System.out.println("Anzahl Studenten: "+studentenliste.getSize()+" Anzahl zufriedene Studenten: "+anzahlZufrieden+ " => "+new DecimalFormat("0.00").format(((double)anzahlZufrieden*100)/studentenliste.getSize())+"%");
		
	return studentenliste;
	}

}
