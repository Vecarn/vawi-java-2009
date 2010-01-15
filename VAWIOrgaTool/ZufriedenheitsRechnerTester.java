import java.util.Iterator;

import AusgabeDatenVerwaltung.DatenObjekte.Pruefungstag;
import EingabeDatenVerwaltung.DatenObjekte.Buchung;
import EingabeDatenVerwaltung.DatenObjekte.Kurs;
import EingabeDatenVerwaltung.DatenObjekte.Student;


public class ZufriedenheitsRechnerTester {

	public void teste()throws Exception{
		
		Ablaufsteuerung steuerung = new Ablaufsteuerung();
		steuerung.leseDatenEin("studenten.txt", "buchungen.txt", "kurse.txt");
		steuerung.startePlanungslauf(3, 3);
		steuerung.werteZufriedenheitAus();
		
		Iterator<Student> si = steuerung.studentenliste.getStudentIterator();
    	System.out.println("=====================================");
    	System.out.println("NAME \t\tZEITMINIMIERER \tZUFRIEDEN ");
    	while(si.hasNext()){
    		Student student = si.next();
    		
    		System.out.println(student.getVorname()+""+student.getName()+"\t"+student.getZeitminimierer()+ "\t\t"+student.getZufrieden());
    		Iterator<Buchung> bi = steuerung.buchungsliste.getBuchungen(student).getIterator();
    		while(bi.hasNext()){
    			System.out.print(bi.next().getKurs().getKursid()+";");
    		}
    		System.out.print("\n");
    	}
    	
    	Iterator<Pruefungstag> pi = steuerung.pruefungsplan.getPruefungsplanIterator();
    	while(pi.hasNext()){
    		Pruefungstag pt = pi.next();
    		System.out.println("========TAG:"+pt.getTagId()+"======Kurse:======");
    		Iterator<Kurs> ki = pt.getTagesKursliste().getKursIterator();
    		while(ki.hasNext()){
    			Kurs kurs = ki.next();
    			System.out.println("("+kurs.getKursid()+") :"+kurs.getKurztitel());
    		}
    	}
	}
	
	
}
