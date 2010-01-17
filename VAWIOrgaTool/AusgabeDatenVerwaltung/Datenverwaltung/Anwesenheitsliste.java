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

	private Collection<Anwesenheit> anw_liste_bamberg;
	private Collection<Anwesenheit> anw_liste_duisburg;
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

	// /**
	// * Fügt eine Anwesenheit zur Liste hinzu
	// *
	// * @param student Der Student, dessen Anwesenheit hinzugefügt wird.
	// * @return boolean flag true oder false
	// */
	// private boolean addAnwesenheit(Student student){
	//		
	// Anwesenheit a1 = new Anwesenheit(student);
	//		
	// anw_liste.add(a1);
	//		
	// return false;
	//		
	//		
	//		
	// }

	// /** Elementanzahl ausgeben
	// * @return integer mit der Anzahl
	// */
	// public int getCount(){
	// return anw_liste.size();
	// }

	/**
	 * Methode zum Erzeugen der Liste
	 * 
	 * @return
	 */
	public String generiereListe() {

		String output = new String();

		Iterator i1 = null;
		Pruefungstag p1 = null;
		Studentenliste sl1 = null;
		Iterator i2 = null;
		Iterator i_bam = null;
		Iterator i_dui = null;

		i1 = pruefungsterminplan.getPruefungsplanIterator();

		while (i1.hasNext()) {
			anw_liste_bamberg = new TreeSet<Anwesenheit>();
			

			p1 = (Pruefungstag) i1.next();

			// Kursliste k1 = p1.getTagesKursliste();

			sl1 = p1.getTagesStudentenliste();

			i2 = sl1.getStudentIterator();

			while (i2.hasNext()) {
				Student s1 = (Student) i2.next();
				Anwesenheit a1 = null;

				if (s1.getUni() == 'B') {
					a1 = new Anwesenheit(s1);
					a1.setKursliste(p1.getTagesKursliste());
					try {
						anw_liste_bamberg.add(a1);
					} catch (Exception e1) {

						// e1.printStackTrace();
					}
				}

			}

			i_bam = getIteratorBamberg();

			output = output + ausgabeverwaltung.line;
			output = output + "Tag " + p1.getTagId() + " - Bamberg\n";
			output = output + ausgabeverwaltung.line;
			while (i_bam.hasNext()) {

				Anwesenheit a_tmp = (Anwesenheit) i_bam.next();

				output = output + a_tmp.getStudent().getName() + ", "
						+ a_tmp.getStudent().getVorname();

				Iterator i_kurs = a_tmp.getStudentKursliste().getKursIterator();
				output = output + ": (";
				while (i_kurs.hasNext()) {

					Kurs k_tmp = (Kurs) i_kurs.next();

					output = output + ", " + k_tmp.getKurztitel();

				}

				output = output + ")\n";

			}
			
		}

		
		output = output + ausgabeverwaltung.line;
		output = output + "\n\n";
		
			i1 = pruefungsterminplan.getPruefungsplanIterator();

			while (i1.hasNext()) {
				
				anw_liste_duisburg = new TreeSet<Anwesenheit>();

				p1 = (Pruefungstag) i1.next();

				// Kursliste k1 = p1.getTagesKursliste();

				sl1 = p1.getTagesStudentenliste();

				i2 = sl1.getStudentIterator();

				while (i2.hasNext()) {
					Student s1 = (Student) i2.next();
					Anwesenheit a1 = null;

					if (s1.getUni() == 'D') {
						a1 = new Anwesenheit(s1);
						a1.setKursliste(p1.getTagesKursliste());
						try {
							anw_liste_duisburg.add(a1);
						} catch (Exception e) {

							// e.printStackTrace();
						}

					}

				}

				i_dui = getIteratorDuisburg();

				output = output + ausgabeverwaltung.line;
				output = output + "Tag " + p1.getTagId() + " - Duisburg\n";
				output = output + ausgabeverwaltung.line;
				while (i_dui.hasNext()) {

					Anwesenheit a_tmp = (Anwesenheit) i_dui.next();

					output = output + a_tmp.getStudent().getName() + ", "
							+ a_tmp.getStudent().getVorname();

					Iterator i_kurs = a_tmp.getStudentKursliste()
							.getKursIterator();
					output = output + ": (";
					while (i_kurs.hasNext()) {

						Kurs k_tmp = (Kurs) i_kurs.next();

						output = output + ", " + k_tmp.getKurztitel();

					}

					output = output + ")\n";

				}

		
			}

		

		return output;
	}

	private Iterator<Anwesenheit> getIteratorBamberg() {
		return anw_liste_bamberg.iterator();

	}

	private Iterator<Anwesenheit> getIteratorDuisburg() {
		return anw_liste_duisburg.iterator();

	}
}
