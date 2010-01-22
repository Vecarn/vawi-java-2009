
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
 * @version 1.1
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

					output_b = output_b + "\nVAWi-Prüfung in Bamberg - Tag " 
					+ tmp_pt.getTagId()
					+ "\n\n";
					output_b = output_b + "Teilnehmer: " +
					tmp_student.getMatrikelnr() + " - " 
							+ tmp_student.getName() + ", "
							+ tmp_student.getVorname() + ": ";

					output_b = output_b + "\nHeutige Kurse:\n";
					
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
							output_b = output_b + "\n";
							}
						
						//wenn der aktuelle Kurs in der Tageskursliste vorkommt
						//dann Ausgabe
						if (tageskurse.getKurs(tmp_buchung.getKurs().getKursid()) != null) {

							
							output_b = output_b
									+ tmp_buchung.getKurs().getKurztitel() 
									+ " - "
									+ tmp_buchung.getKurs().getTitel();
							count++;	
						}	
					}
					output_b = output_b + "\n\n";
					break;

				case 'D':

					output_d = output_d + "\nVAWi-Prüfung in Duisburg-Essen - Tag "
					+ tmp_pt.getTagId()
					+ "\n\n";
					output_d = output_d + "Teilnehmer: "
					+ tmp_student.getMatrikelnr() + " - "
					+ tmp_student.getName() + ", "
							+ tmp_student.getVorname() + ": ";
					
					output_d = output_d + "\nHeutige Kurse:\n";
					
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
							output_d = output_d + "\n";
							}
						
						//wenn der aktuelle Kurs in der Tageskursliste vorkommt
						//dann Ausgabe
						if (tageskurse.getKurs(tmp_buchung.getKurs()
								.getKursid()) != null) {
							output_d = output_d
									+ tmp_buchung.getKurs().getKurztitel()
									+ " - "
									+ tmp_buchung.getKurs().getTitel();	
						count++;
						}
					}
					output_d = output_d + "\n\n";
					break;
				}
			}
		}

		//Gesamt-Output Stream zusammenstellen
		output = output_b + "\n\n" + ausgabeverwaltung.line + "\n\n" + output_d;
		
		return output;

	}

    
 }
