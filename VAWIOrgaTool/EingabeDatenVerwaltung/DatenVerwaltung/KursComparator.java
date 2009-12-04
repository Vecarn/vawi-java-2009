package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.Comparator;

import EingabeDatenVerwaltung.DatenObjekte.Kurs;

public class KursComparator implements Comparator<Kurs> {

	@Override
	public int compare(Kurs arg0, Kurs arg1) {
		
		return arg0.getKursid()-arg1.getKursid();
	}

}
