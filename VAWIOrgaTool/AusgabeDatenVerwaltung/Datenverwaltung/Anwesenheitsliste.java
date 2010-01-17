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

	private Collection<Anwesenheit> anw_liste = new TreeSet<Anwesenheit>(new AnwesenheitComparator());
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

		String output = new String();
		
		
		
		
		
		
		
		
		return output;
	}


}
