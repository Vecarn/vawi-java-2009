import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import EingabeDatenVerwaltung.DatenObjekte.Buchung;
import EingabeDatenVerwaltung.DatenObjekte.Kurs;
import EingabeDatenVerwaltung.DatenObjekte.Student;
import EingabeDatenVerwaltung.DatenVerwaltung.Kursliste;


public class SimulatorTestStub {

	public void testSimulator(){
		
		Kursliste kl = new Kursliste();
    	kl.addNeuerKurs(2, "GdP", "Grundlagen der Programmierung - JAVA",true, 90);
    	kl.addNeuerKurs(3, "eBiz", "eBusiness", false, 0);
    	kl.addNeuerKurs(4, "IDA", "Integrierte Daten und Anwendungssysteme", true, 90);
    	kl.addNeuerKurs(5, "Sim", "Simulation", true, 60);
    	kl.addNeuerKurs(6, "MSup", "Modellierung von Systemen und Prozessen", true, 90);
    	kl.addNeuerKurs(7, "RBKVS", "Rechner Betriebssysteme Kommunikations und Verteilte Systeme", true, 30);
    	kl.addNeuerKurs(9, "BWL", "Grundlagen der BWL", false, 0);
    	
    
    	
    	
    	
    	Simulator sim = new Simulator(kl, 4, 5, 10);
    	Iterator<Buchung> bi = sim.getBuchungsliste().getIterator();
    	Iterator<Student> si = sim.getStudentenliste().getStudentIterator();
     	Set<Entry<Kurs,Integer>>  ble = sim.getBuchungsliste().getBuchungszaehlerEntrySet();
     	System.out.println("\n============Simulationsüberblick============");
     	System.out.println("Anzahl generierte Studenten:"+sim.getStudentenliste().getSize()+"\nAnzahl Kurse:"+kl.getSize()+"\nAnzahl generierter Buchungen:"+sim.getBuchungsliste().getSize()+"\nSchnitt Buchungen/Student:"+(float)sim.getBuchungsliste().getSize()/sim.getStudentenliste().getSize());
     	System.out.println("\n============Buchungsdaten============");
     	System.out.println("KursID-Kurztitel=> Student(Matrikelnr,Nachname,Vorname) => erreichte Punktzahl");
     	while(bi.hasNext()){
    		Buchung buchung = bi.next();
    		System.out.println(buchung.getKurs().getKursid()+"-"+buchung.getKurs().getKurztitel()+"\t\t->"+buchung.getStudent().getMatrikelnr()+"-"+buchung.getStudent().getName()+"-"+buchung.getStudent().getVorname()+" -> "+buchung.getErreichtePunkte());
    	}
     	System.out.println("\n============Buchungszahlen============");
     	System.out.println("KursID-Kurztitel=> Anzahl Buchungen");
		for(Entry<Kurs,Integer> entry : ble){
     		System.out.println(entry.getKey().getKursid()+"-"+entry.getKey().getKurztitel()+"\t\t=> "+entry.getValue());
     	}
		System.out.println("\n============Studentendaten============");
		int count = 0;
		while(si.hasNext()){
			count++;
			Student student = si.next();
			System.out.println(student.getMatrikelnr()+";"+student.getName()+";"+student.getVorname()+";"+student.getUni()+";"+student.getBundesland()+";"+student.getZeitminimierer()+";Anzahl Kursbuchungen:"+sim.getBuchungsliste().anzBuchungenStudent(student));
		}
		
		System.out.println("\n---Anzahl Buchungen für Kurs: "+kl.getKurs(9).getKurztitel()+" -> "+sim.getBuchungsliste().anzBuchungenKurs(kl.getKurs(9)));
			
	}
	
	
}
