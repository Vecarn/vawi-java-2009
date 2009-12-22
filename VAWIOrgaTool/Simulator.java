import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import EingabeDatenVerwaltung.DatenObjekte.Kurs;
import EingabeDatenVerwaltung.DatenObjekte.Student;
import EingabeDatenVerwaltung.DatenVerwaltung.*;
import Hilfsklassen.Uni;

/**
 * Der Simulator ist eine Logikklasse, die fiktive Kursbuchungen fuer jeden Studenten angelegt. <br>
 * Sie verwendet eine gegebene Kursliste als Eingabe.<br> Weiterhin ist es möglich eigene Simulationsparameter anzugeben. 
 * Mit zufallsgenerierten Studenten wird eine zufällige Buchungsliste erstellt.
 * 
 * 
 * @author Markus Bode
 * @version 1.0 vom 8.12.2009
 */
public class Simulator {
	// Objekt Listen
	private Kursliste kursliste;
	private Buchungsliste generierteBuchungsliste;
	private Studentenliste  generierteStudentenliste;
	// Simulationsparameter
	private int minBuchungen;
	private int maxBuchungen;
	private int anzahlStudenten;
	//DummyDaten
	private String [] vornamen = new String[]{"Elias","Julian","Marcel","Thomas","Luca","Stefan","Michael","Felix",
            "Luca","Stefan","Michael","Felix","Jessica","Katharina","Frauke",
            "Petra","Manuela","Sophie","Marta","Lisa"};
	private String [] nachnamen = new String[]{"Mueller","Schmidt","Klein","Muster","Mayer","Bode","Hauser","Munkelt","Woelfle",
            "Schoenherr","Nett","Gosler","Sell","Rausch","Freitag","Buchmann","Junge",
            "Merkel","Schroeder","Schaeuble","Gutenberg"};
	private char[] uni = new char[]{Uni.Bamberg,Uni.Duisburg};
	private String [] bundeslaender = new String[]{"Baden-Württemberg","Bayern","Berlin","Brandenburg","Bremen","Hamburg",
			"Mecklemburg-Vorpommern","Niedersachsen","Sachsen","Sachsen-Anhalt","Nordreihn-Westfalen","Reihnland-Pfalz","Saarland",
			"Schleswig-Holstein","Thüringen","Hessen"};
	
	/**
	 * Konstruktor für den Simulator, der lediglich eine Kursliste erwartet.<br>
	 * Es findet eine Prüfung der Kursliste statt. Die Simulation wird nur gestartet,<br>
	 * wenn diese mindestens einen Kurs beinhaltet.<br>
	 * Die Simulation wird mit Standardparametern durchgeführt:<br>
	 * min. Buchungen pro Student = 1<br>
	 * max. Buchungen pro Student = 6<br>
	 * Anzahl Studenten = 100<br> 
	 * Außerdem wird die Generierung der Daten angestoßen.
	 * 
	 * @param kursliste (Kursliste) - eine Kursliste mit Kurs-Objekten aus der gegebenen Kursdatei.
	 */
	public Simulator(Kursliste kursliste){
		
		if(kursliste==null){
			System.out.println("Kursliste ist null! -> keine Simulation");
			generierteBuchungsliste=null;
			generierteStudentenliste=null;
			return;
		}else if(kursliste.getSize()==0){
			System.out.println("Kursliste ist leer! -> keine Simulation");
			generierteBuchungsliste=null;
			generierteStudentenliste=null;
			return;
		}
		
		this.kursliste=kursliste;
		generierteStudentenliste=new Studentenliste();
		generierteBuchungsliste=new Buchungsliste();
		
		this.minBuchungen=1;
		this.maxBuchungen=6;
		this.anzahlStudenten=100;
		generiereBuchungsDaten();
		
	}
	
	/**
	 * Konstruktor für den Simulator, in dem neben der Kursliste besondere Simulationsparameter mitgegeben werden müssen.<br>
	 * Es findet eine Prüfung der übergebenen Parameter statt. Die Simulation wird nur gestartet,<br>
	 * wenn die Kursliste mindestens einen Kurs beinhaltet und für minBuchungen, maxBuchungen und anzahlStudenten sinnvolle Variablen übergeben wurden.<br>
	 * 
	 * @param kursliste (Kursliste) - eine Kursliste mit Kurs-Objekten aus der gegebenen Kursdatei.
	 * @param minBuchungen (int) - Mindestanzahl an Buchungsobjekten pro Student (zufällige Auswahl an Kursen) (Prüfung: 0 <= minBuchungen <= maxBuchungen)
	 * @param maxBuchungen (int) - Maximalanzahl an Buchungsobjekten pro Student (zufällige Auswahl an Kursen) (Prüfung: maxBuchungen > 0)
	 * @param anzahlStudenten (int) - Anzahl zu generierender Studentenobjekte. (Prüfung: anzahlStudenten > 0)
	 */
	public Simulator(Kursliste kursliste, int minBuchungen, int maxBuchungen, int anzahlStudenten){
		
		if(kursliste==null){
			System.out.println("Kursliste ist null! -> keine Simulation");
			generierteBuchungsliste=null;
			generierteStudentenliste=null;
			return;
		}else if(kursliste.getSize()==0){
			System.out.println("Kursliste ist leer! -> keine Simulation");
			generierteBuchungsliste=null;
			generierteStudentenliste=null;
			return;
		}
		
		this.kursliste=kursliste;
		generierteStudentenliste=new Studentenliste();
		generierteBuchungsliste=new Buchungsliste();
		
		if((minBuchungen<0)||(minBuchungen>maxBuchungen)){
			System.out.println("Variable minBuchungen ungültig! -> keine Simulation");
			return;
		}else{
			this.minBuchungen=minBuchungen;
		}
		
		if(maxBuchungen<=0){
			System.out.println("Variable maxBuchungen ungültig! -> keine Simulation");
			return;
		}else{
			this.maxBuchungen=maxBuchungen;
		}
		
		if(anzahlStudenten<=0){
			System.out.println("Variable anzahlStudenten ungültig! -> keine Simulation");
			return;
		}else{
			this.anzahlStudenten=anzahlStudenten;
		}
		
		generiereBuchungsDaten();
		
	}
	
	/**
	 * Generiert BuchungsDaten
	 */
	private void generiereBuchungsDaten(){
		
		generiereStudenten();
		
		Iterator<Student> si = generierteStudentenliste.getStudentIterator();
		Iterator<Kurs> ki = kursliste.getKursIterator();
		
		ArrayList<Integer> kursids = new ArrayList<Integer>();
		while(ki.hasNext()){
			kursids.add(new Integer(ki.next().getKursid()));
		}
		
		while(si.hasNext()){
		
			Student student = si.next();
			
			for(int i=0;i<zufallsAnzahlBuchungen();i++){
				
				boolean buchungHinzugefuegt = false;
				
				while(!buchungHinzugefuegt){
					
					Kurs kurs = kursliste.getKurs(kursids.get(zufallsZahl(0,kursids.size()-1)).intValue());
					int erreichtePunkte = 0;
					
					if(kurs.getHatTeilleistungen()){
						erreichtePunkte = zufallsZahl(0, kurs.getMaxPunkte());
					}
					
					if(generierteBuchungsliste.addBuchung(student,kurs,erreichtePunkte)){
						buchungHinzugefuegt = true;
					}
				}
				
			}
			
		}			
	}
	
	/**
	 * Generiert Studenten mit zufälligen Daten und fügt Sie der Studentenliste hinzu
	 */
	private void generiereStudenten(){
		
		for(int i=0;i<anzahlStudenten;i++){
			
		    boolean zeitminimierer;
		        
		    if(zufallsZahl(0,1)==1){
		       zeitminimierer=true;
		    }else{
		       zeitminimierer=false;
		    }
		    
		    boolean studentHinzugefuegt = false;
		    
		    while(!studentHinzugefuegt){
		    		
		    	if(generierteStudentenliste.addNeuerStudent(zufallsZahl(100000, 999999), nachnamen[zufallsZahl(0,(nachnamen.length-1))], 
		        		 vornamen[zufallsZahl(0,(vornamen.length-1))], uni[zufallsZahl(0,1)],
		        		 bundeslaender[zufallsZahl(0,(bundeslaender.length-1))],zeitminimierer)){
		    		studentHinzugefuegt=true;
		    	}
		    
		    }
		   		     					
		}
	
	}
	
	/**
	 * Liefert eine Zufallszahl
	 * 
	 * @return int - Zufallszahl zwischen minBuchungen und maxBuchungen
	 */
	private int zufallsAnzahlBuchungen(){
		Random rand = new Random();
		return (rand.nextInt(maxBuchungen-minBuchungen+1))+minBuchungen;
	}
	
	/**
	 * Liefert eine Zufallszahl
	 * 
	 * @param x
	 * @param y
	 * @return int - Zufallszahl zwischen x und y
	 */
	private int zufallsZahl(int x, int y){
		Random rand = new Random();
		return (rand.nextInt(y-x+1))+x;
	}
	
	/**
	 * Liefert die Buchungsliste zurück, in der die Buchungs-Objekte verwaltet werden, 
	 * die mittels der gegebenen Kursliste und den generierten Studenten-Objekten erstellt wurden.
	 * 
	 * @return buchungsliste (Buchungsliste) - Buchungsliste mit generieten Buchungs-Objekten.
	 */
	public Buchungsliste getBuchungsliste(){
		return generierteBuchungsliste;
	}
	
	/**
	 * Liefert die Studentenliste zurück, in der die Studenten-Objekte verwaltet werden, 
	 * die zufällig generiert wurden.
	 * 
	 * @return studentenliste (Studentenliste) - Studentenliste mit generierten Studenten-Objekten.
	 */
	public Studentenliste getStudentenliste(){
		return generierteStudentenliste;
	}
	

}
