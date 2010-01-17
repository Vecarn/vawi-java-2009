package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import AusgabeDatenVerwaltung.AusgabeVerwaltung;
import AusgabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenVerwaltung.*;
import Hilfsklassen.*;

/**
 * Verwaltungsklasse f&uuml;r die Anwesenheiten und gleichzeitig
 * Entit&auml;tstyp f&uuml;r eine Anwesenheitsliste.
 * 
 * @author Martin
 * @version 0.5
 */
public class Anwesenheitsliste {

	//private Collection<Anwesenheit> anw_liste = new TreeSet<Anwesenheit>(new AnwesenheitComparator());
	private Buchungsliste buchungsliste;
	private Pruefungsterminplan pruefungsterminplan;
	private AusgabeVerwaltung ausgabeverwaltung;

	/**
	 * Konstruktor für die Anwesenheitsliste. Erzeugt ein neues TreeSet für die
	 * Liste der Anwesenheiten und gibt an die lokale Variable buchungsliste den
	 * Verweis auf die allgemeine Buchungsliste zurück.
	 * 
	 * @param buchungsliste
	 *            Die Buchungsliste, die im System geführt wird.
	 */
	public Anwesenheitsliste(Buchungsliste buchungsliste,
			Pruefungsterminplan pruefungsterminplan, 
			AusgabeVerwaltung ausgabeverwaltung) {

		this.buchungsliste = buchungsliste;
		this.pruefungsterminplan = pruefungsterminplan;
		this.ausgabeverwaltung = ausgabeverwaltung;
		
	}


	/**
	 * Methode zum Erzeugen der Liste
	 * 
	 * @return
	 */
	public String generiereListe() {

		String output_b = new String();
		String output_d = new String();
		String output = new String();
		
		Iterator i_pplan = pruefungsterminplan.getPruefungsplanIterator();
		
		while(i_pplan.hasNext()){
			
			Pruefungstag tmp_pt = (Pruefungstag) i_pplan.next();
			
			output_b = 
				output_b + "\nBamberg - Tag " + tmp_pt.getTagId() + "\n\n";
			output_d =
				output_d + "\nDuisburg-Essen - Tag " + tmp_pt.getTagId() + "\n\n";
			
			Iterator i_studenten = 
				tmp_pt.getTagesStudentenliste().getStudentIterator();
			
			Iterator i_tageskurse =
				tmp_pt.getTagesKursliste().getKursIterator();
			
			String tageskurse = null;
			tageskurse = new String();
			
			while(i_tageskurse.hasNext()){
				Kurs tmp_kurs = (Kurs) i_tageskurse.next();
				tageskurse = tageskurse + tmp_kurs.getKurztitel() + "|";
				
			}
			
			
			while(i_studenten.hasNext()){
				
				
				Student tmp_student = (Student) i_studenten.next();
				
				switch(tmp_student.getUni()){
				
				case 'B':
					
					output_b = output_b + tmp_student.getName() + ", " +
							tmp_student.getVorname() + "\t";
					
					output_b = output_b + tageskurse + "\n";
					
					
					
					break;
				case 'D':
					output_d = output_d + tmp_student.getName() + ", " +
					tmp_student.getVorname() + "\t";
					
					output_d = output_d + tageskurse + "\n";
					break;
				default:
					break;
				}
				
			}
			
			
		}
		
		
		
		
		
		output = output_b + "\n\n\n" + output_d;
		
		
		return output;
	}


}
