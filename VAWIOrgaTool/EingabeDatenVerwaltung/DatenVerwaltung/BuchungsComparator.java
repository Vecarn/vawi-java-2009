package EingabeDatenVerwaltung.DatenVerwaltung;

import java.util.Comparator;

import EingabeDatenVerwaltung.DatenObjekte.Buchung;

public class BuchungsComparator implements Comparator<Buchung> {

	@Override
	public int compare(Buchung arg0, Buchung arg1) {
		int k0 = arg0.getKurs().getKursid();
		int k1 = arg1.getKurs().getKursid();
		
		int s0 = arg0.getStudent().getMatrikelnr();
		int s1 = arg1.getStudent().getMatrikelnr();
		
		if((k0==k1)&&(s0==s1)){
			System.out.println("identisch");
			System.out.println("k0: "+k0+" s0: "+s0+" - k1: "+k1+" s1:"+s1);
			return 0;
		}else{
			//
			if(k0<=k1){
				return -1;
			}else if(k0>k1){
				return  1;
			}
		}
		
		System.out.println("k0: "+k0+" s0: "+s0+" - k1: "+k1+" s1:"+s1);
		return 0;
		
	}

}
