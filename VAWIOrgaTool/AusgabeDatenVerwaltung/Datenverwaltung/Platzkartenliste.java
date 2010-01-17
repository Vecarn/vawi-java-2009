
package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.*;

import AusgabeDatenVerwaltung.AusgabeVerwaltung;
import AusgabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenVerwaltung.Buchungsliste;
import EingabeDatenVerwaltung.DatenVerwaltung.Kursliste;
import Hilfsklassen.*;

/**
 * Die Klasse "Platzkartenliste" wird für die Erzeugung der Platzkarten
 * verwendet.
 * 
 * @author Martin
 * @version 0.1
 */
public class Platzkartenliste {

	private Buchungsliste buchungsliste;
	private Pruefungsterminplan pruefungsterminplan;
	private AusgabeVerwaltung ausgabeverwaltung;
	
	/**
	 * Konstruktor für die Platzkarten(liste)
	 */
	public Platzkartenliste(Buchungsliste buchungsliste,
			Pruefungsterminplan pruefungsterminplan,
			AusgabeVerwaltung ausgabeverwaltung){
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

		while (i_pplan.hasNext()) {

			Pruefungstag tmp_pt = (Pruefungstag) i_pplan.next();

			output_b = output_b + "\nVAWi Pruefung in Bamberg - Tag " + tmp_pt.getTagId()
			+ "\n\n";
			output_d = output_d + "\nVAWi Pruefung in Duisburg-Essen - Tag " + tmp_pt.getTagId()
			+ "\n\n";

			Iterator i_studenten = tmp_pt.getTagesStudentenliste()
					.getStudentIterator();

			while (i_studenten.hasNext()) {

	
				Student tmp_student = (Student) i_studenten.next();

				Kursliste tageskurse = null;
				Iterator i_buchungen = null;

				switch (tmp_student.getUni()) {

				case 'B':

					output_b = output_b + "Teilnehmer: " + tmp_student.getName() + ", "
							+ tmp_student.getVorname() + "\t";

					output_b = output_b + "\nHeutige Kurse:\n";
					tageskurse = tmp_pt.getTagesKursliste();

					i_buchungen = buchungsliste.getBuchungen(tmp_student)
							.getIterator();

					while (i_buchungen.hasNext()) {
						Buchung tmp_buchung = (Buchung) i_buchungen.next();

						if (tageskurse.getKurs(tmp_buchung.getKurs()
								.getKursid()) != null) {

							
							output_b = output_b
									+ tmp_buchung.getKurs().getKurztitel();

							
							
						}

					}
					output_b = output_b + "\n";

					break;

				case 'D':

					output_d = output_d + "Teilnehmer: " + tmp_student.getName() + ", "
							+ tmp_student.getVorname() + "\t";
					output_d = output_d + "\nHeutige Kurse:\n";
					tageskurse = tmp_pt.getTagesKursliste();

					i_buchungen = buchungsliste.getBuchungen(tmp_student)
							.getIterator();

					while (i_buchungen.hasNext()) {
						Buchung tmp_buchung = (Buchung) i_buchungen.next();

						if (tageskurse.getKurs(tmp_buchung.getKurs()
								.getKursid()) != null) {

							output_d = output_d
									+ tmp_buchung.getKurs().getKurztitel();

						}

					}
					output_d = output_d + "\n";

					break;

				}

			}

		}

		output = output_b + "\n\n\n" + output_d;
		return output;

	}

    
 }
