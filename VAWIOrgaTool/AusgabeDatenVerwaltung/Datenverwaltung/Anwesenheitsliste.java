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

		Iterator i_pruefung = pruefungsterminplan.getPruefungsplanIterator();
		Anwesenheit tmp_a1 = null;
		
		while(i_pruefung.hasNext()){
			
			
			Pruefungstag tmp_pt = (Pruefungstag) i_pruefung.next();
			output = output + "Tag " + tmp_pt.getTagId();
			output = output + ausgabeverwaltung.line;
			
			Studentenliste tmp_sl = 
				(Studentenliste) tmp_pt.getTagesStudentenliste();
			
			Iterator i_studenten = null;
			i_studenten = tmp_sl.getStudentIterator();
				
			while(i_studenten.hasNext()){
			
				Student tmp_s = (Student) i_studenten.next();
				tmp_a1 = new Anwesenheit(tmp_s);
				
				Iterator i_buchungen = 
					buchungsliste.getBuchungen(tmp_s).getIterator();
				
				Kursliste tmp_kl = new Kursliste();
				
				while(i_buchungen.hasNext()){
					Buchung tmp_bu = (Buchung) i_buchungen.next();
					
					
						
					if(tmp_pt.getTagesKursliste().getKurs(tmp_bu.getKurs().getKursid()) 
							!= null){
						
						tmp_kl.addKurs(tmp_bu.getKurs());
						
					}
					
					
					
				}
			   tmp_a1.setKursliste(tmp_kl);
				
			
				anw_liste.add(tmp_a1);
			
				
				
				
			}
			
			
			Iterator i_anw = null; 
			i_anw = anw_liste.iterator();
			while(i_anw.hasNext()){
				
				Anwesenheit out_anw = (Anwesenheit) i_anw.next();
				
				if(out_anw.getStudent().getUni() == 'B'){
					
					output = output + out_anw.getStudent().getName() +
							 ", " + out_anw.getStudent().getVorname() + "\t";
					
					Iterator i_kurse = 
						out_anw.getStudentKursliste().getKursIterator();
					
					while(i_kurse.hasNext()){
						Kurs tmp_k2 = (Kurs) i_kurse.next();
						
						output = output + tmp_k2.getKurztitel() + "-";
						
					}
					
					output = output + "\n";
					
					
				}
				
				
			}
			
			
		}
		
		
		
		
		
		
		
		
		return output;
	}


}
