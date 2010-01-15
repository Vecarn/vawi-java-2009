package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.Comparator;

import AusgabeDatenVerwaltung.DatenObjekte.Pruefungstag;

public class PruefungstagComparator implements Comparator<Pruefungstag> {

	public int compare(Pruefungstag arg0, Pruefungstag arg1) {
		return arg0.getTagId() - arg1.getTagId();
	}

}
