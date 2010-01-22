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
 * @version 1.1
 */
public class Anwesenheitsliste {

	// private Collection<Anwesenheit> anw_liste = new TreeSet<Anwesenheit>(new
	// AnwesenheitComparator());
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
	 * @return output-String, der die Ausgabedaten formatiert enthält
	 */
	public String generiereListe() {
		
		//String Variablen, die zum Aufbau der Ausgabestreams
		//benötigt werden
		String output_b = new String();
		String output_d = new String();
		String output = new String();
		//int Variable als Counter für die Kurse eines Studenten
		int count;

		
		Iterator i_pplan = pruefungsterminplan.getPruefungsplanIterator();

		//loop über die Prüfungstage
		while (i_pplan.hasNext()) {

			Pruefungstag tmp_pt = (Pruefungstag) i_pplan.next();

			//zu Beginn eines jeden Prüfungstages werden die entsprechenden
			//Tages-Header in die jeweiligen Output-Strings geschrieben
			output_b = output_b + "\nUniversität Bamberg - Tag " 
						+ tmp_pt.getTagId()
						+ "\n\n";
			output_d = output_d + "\nUniversität Duisburg-Essen - Tag "
						+ tmp_pt.getTagId()
						+ "\n\n";

			
			Iterator i_studenten = tmp_pt.getTagesStudentenliste().getStudentIterator();

			//loop über die Studenten am Prüfungstag
			while (i_studenten.hasNext()) {

				Student tmp_student = (Student) i_studenten.next();

				Kursliste tageskurse = null;
				Iterator i_buchungen = null;

				//switch um die Studenten zur richtigen Ausgabe
				//hinzuzufügen, getrennt nach Universität
				switch (tmp_student.getUni()) {

				case 'B':

					output_b = output_b + tmp_student.getMatrikelnr() + " - " 
					+ tmp_student.getName() + ", "
							+ tmp_student.getVorname() + ": ";

					tageskurse = tmp_pt.getTagesKursliste();

					i_buchungen = buchungsliste.getBuchungen(tmp_student).getIterator();

					//counter auf null
					count = 0; 
					
					//loop über die Buchungen des Studenten
					while (i_buchungen.hasNext()) {
												
						Buchung tmp_buchung = (Buchung) i_buchungen.next();
						
						//wenn es der erste Kurs eines Studenten ist und der
						//aktuelle Kurs in der Tageskursliste vorkommt, dann
						//ein Komma als Trennzeichen ausgeben
						if(count != 0 &&
								tageskurse.getKurs(tmp_buchung.getKurs().getKursid()) != null){
							output_b = output_b + ", ";
							}
						
						//wenn der aktuelle Kurs in der Tageskursliste vorkommt
						//dann Ausgabe
						if (tageskurse.getKurs(tmp_buchung.getKurs().getKursid()) != null) {

							
							output_b = output_b
									+ tmp_buchung.getKurs().getKurztitel(); 
							count++;	
						}	
					}
					output_b = output_b + "\n";
					break;

				case 'D':

					output_d = output_d + tmp_student.getMatrikelnr() + " - " + 
								tmp_student.getName() + ", "
							+ tmp_student.getVorname() + ": ";

					tageskurse = tmp_pt.getTagesKursliste();

					i_buchungen = buchungsliste.getBuchungen(tmp_student)
							.getIterator();

					//counter auf null
					count = 0; 
					
					//loop über die Buchungen des Studenten
					while (i_buchungen.hasNext()) {
						Buchung tmp_buchung = (Buchung) i_buchungen.next();

						//wenn es der erste Kurs eines Studenten ist und der
						//aktuelle Kurs in der Tageskursliste vorkommt, dann
						//ein Komma als Trennzeichen 
						if(count != 0 &&
								tageskurse.getKurs(tmp_buchung.getKurs().getKursid()) != null){
							output_d = output_d + ", ";
							}
						
						//wenn der aktuelle Kurs in der Tageskursliste vorkommt
						//dann Ausgabe
						if (tageskurse.getKurs(tmp_buchung.getKurs()
								.getKursid()) != null) {
							output_d = output_d
									+ tmp_buchung.getKurs().getKurztitel();	
						count++;
						}
					}
					output_d = output_d + "\n";
					break;
				}
			}
		}

		//Gesamt-Output Stream zusammenstellen
		output = output_b + "\n\n\n" + output_d;
		
		return output;
	}
}
