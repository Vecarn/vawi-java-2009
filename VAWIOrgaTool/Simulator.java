import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import EingabeDatenVerwaltung.DatenObjekte.Kurs;
import EingabeDatenVerwaltung.DatenObjekte.Student;
import EingabeDatenVerwaltung.DatenVerwaltung.*;
import Hilfsklassen.Uni;

/**
 * Der Simulator ist eine Logikklasse, die fiktive Kursbuchungen fuer jeden Studenten angelegt. <br>
 * Sie verwendet eine gegebene Kursliste als Eingabe.<br> Weiterhin ist es m�glich eigene Simulationsparameter anzugeben. 
 * Mit zufallsgenerierten Studenten wird eine zuf�llige Buchungsliste erstellt.
 * 
 * 
 * @author Markus Bode
 * @version 1.0 vom 23.12.2009
 */
public class Simulator {
	
	// Verwaltungslisten
	private Kursliste kursliste;
	private Buchungsliste generierteBuchungsliste;
	private Studentenliste  generierteStudentenliste;
	
	// Simulationsparameter
	private int minBuchungen;
	private int maxBuchungen;
	private int anzahlStudenten;
	
	// Daten die zuf�llig zu Studentenobjekten kombiniert werden
	private String [] vornamen = new String[]{"Elias","Julian","Marcel","Thomas","Luca","Stefan","Michael","Felix",
            "Luca","Stefan","Michael","Felix","Jessica","Katharina","Frauke",
            "Petra","Manuela","Sophie","Marta","Lisa","Franz","Fritz"};
	private String [] nachnamen = new String[]{"Mueller","Schmidt","Klein","Muster","Mayer","Bode","Hauser","Munkelt","Woelfle",
            "Schoenherr","Nett","Gosler","Sell","Rausch","Freitag","Buchmann","Junge",
            "Merkel","Schroeder","Schaeuble","Gutenberg","Pesser","Hugendubel","Oesterle"};
	private char[] uni = new char[]{Uni.Bamberg,Uni.Duisburg};
	private String [] bundeslaender = new String[]{"Baden-W�rttemberg","Bayern","Berlin","Brandenburg","Bremen","Hamburg",
			"Mecklemburg-Vorpommern","Niedersachsen","Sachsen","Sachsen-Anhalt","Nordreihn-Westfalen","Reihnland-Pfalz","Saarland",
			"Schleswig-Holstein","Th�ringen","Hessen"};
	
	/**
	 * Konstruktor f�r den Simulator, der lediglich eine Kursliste erwartet.<br>
	 * Es findet eine Pr�fung der Kursliste statt. Die Simulation wird nur gestartet,<br>
	 * wenn diese mindestens einen Kurs beinhaltet.<br>
	 * Die Simulation wird mit Standardparametern durchgef�hrt:<br>
	 * min. Buchungen pro Student = 1<br>
	 * max. Buchungen pro Student = 6<br>
	 * Anzahl Studenten = 100<br> 
	 * Au�erdem wird die Generierung der Daten angesto�en.
	 * 
	 * @param kursliste (Kursliste) - eine Kursliste mit Kurs-Objekten aus der gegebenen Kursdatei.
	 */
	public Simulator(Kursliste kursliste){
		
		//Pr�fung auf korrekte Kursliste
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
		//setze Instanzvariablen
		this.kursliste=kursliste;
		generierteStudentenliste=new Studentenliste();
		generierteBuchungsliste=new Buchungsliste();
		//setze Standardparameter
		this.minBuchungen=1;
		this.maxBuchungen=6;
		this.anzahlStudenten=100;
		//starte Generierung der Daten
		generiereBuchungsDaten();
		
	}
	
	/**
	 * Konstruktor f�r den Simulator, in dem neben der Kursliste besondere Simulationsparameter mitgegeben werden m�ssen.<br>
	 * Es findet eine Pr�fung der �bergebenen Parameter statt. Die Simulation wird nur gestartet,<br>
	 * wenn die Kursliste mindestens einen Kurs beinhaltet und f�r minBuchungen, maxBuchungen und anzahlStudenten sinnvolle Variablen �bergeben wurden.<br>
	 * 
	 * @param kursliste (Kursliste) - eine Kursliste mit Kurs-Objekten aus der gegebenen Kursdatei.
	 * @param minBuchungen (int) - Mindestanzahl an Buchungsobjekten pro Student (zuf�llige Auswahl an Kursen) (Pr�fung: 0 <= minBuchungen <= maxBuchungen)
	 * @param maxBuchungen (int) - Maximalanzahl an Buchungsobjekten pro Student (zuf�llige Auswahl an Kursen) (Pr�fung: maxBuchungen > 0)
	 * @param anzahlStudenten (int) - Anzahl zu generierender Studentenobjekte. (Pr�fung: anzahlStudenten > 0)
	 */
	public Simulator(Kursliste kursliste, int minBuchungen, int maxBuchungen, int anzahlStudenten){
		
		//pr�fe ob korrekte Kursliste vorliegt mit > 0 Kursobjekten
		//sonst k�nnen auch keine sinnvollen Buchungsobjekte erstellt werden
		if(kursliste==null){
			System.out.println("Kursliste ist null! Keine Erstelltung der fiktiven Daten. Bitte erst Daten (Kursliste) einlesen.");
			generierteBuchungsliste=null;
			generierteStudentenliste=null;
			return;
		}else if(kursliste.getSize()==0){
			System.out.println("Kursliste ist leer! Keine Erstelltung der fiktiven Daten. Bitte erst Daten (Kursliste) einlesen.");
			generierteBuchungsliste=null;
			generierteStudentenliste=null;
			return;
		}
		
		//setze Instanzvariablen
		this.kursliste=kursliste;
		generierteStudentenliste=new Studentenliste();
		generierteBuchungsliste=new Buchungsliste();
		
		//pr�fe Plausibilit�t der �bergebenen Parameter
		//wenn ok werden die Instanzvariablen gesetzt
		if((minBuchungen<0)||(minBuchungen>maxBuchungen)){
			System.out.println("Variable minBuchungen ung�ltig! -> keine Simulation");
			return;
		}else{
			this.minBuchungen=minBuchungen;
		}
		
		if(maxBuchungen<=0){
			System.out.println("Variable maxBuchungen ung�ltig! -> keine Simulation");
			return;
		}else{
			this.maxBuchungen=maxBuchungen;
		}
		
		if(anzahlStudenten<=0){
			System.out.println("Variable anzahlStudenten ung�ltig! -> keine Simulation");
			return;
		}else{
			this.anzahlStudenten=anzahlStudenten;
		}
		
		//starte die Generierung der Daten
		generiereBuchungsDaten();
		
	}
	
	/**
	 * Generiert BuchungsDaten
	 */
	private void generiereBuchungsDaten(){
		
		//zuerst Studentenobjekte erstellen
		generiereStudenten();
		
		//hole Iteratoren �ber die generierten Studenten und die gegebenen Kursobjekte
		Iterator<Student> si = generierteStudentenliste.getStudentIterator();
		Iterator<Kurs> ki = kursliste.getKursIterator();
		
		//Alle Kursids in die ArrayList speichern
		ArrayList<Integer> kursids = new ArrayList<Integer>();
		while(ki.hasNext()){
			kursids.add(new Integer(ki.next().getKursid()));
		}
		
		//gehe �ber alle Studenten
		while(si.hasNext()){
		
			Student student = si.next();
			
			//anzahl Schleifendurchl�ufe: zwische min und maxBuchungen
			//--> f�r den Studenten werden Buchungen zwischen min und maxBuchungen hinzugef�gt
			for(int i=0;i<zufallsAnzahlBuchungen();i++){
				
				boolean buchungHinzugefuegt = false;
				
				//durchlauf bis buchungHinzugefuegt == true
				//es wird solange versucht eine Buchung hinzuzuf�gen, bis sich die Buchungscollection ge�ndert hat,
				//also auch wirklich ein neues Buchungsobjekt (gegebener Student hat ausgew�hlten Kurs noch nicht gebucht)
				//hinzugef�gt wurde
				while(!buchungHinzugefuegt){
					//hole das Kursobjekt aus der Kursliste zu der zuf�llig aus der ArrayListe kursids ausgew�hlten Kursid 
					Kurs kurs = kursliste.getKurs(kursids.get(zufallsZahl(0,kursids.size()-1)).intValue());
					int erreichtePunkte = 0;
					
					//wenn der Kurs Teilleistungen hatte, generiere die Punktzahl dir der Student erreicht hat
					if(kurs.getHatTeilleistungen()){
						erreichtePunkte = zufallsZahl(0, kurs.getMaxPunkte());
					}
					
					//f�ge Buchung hinzu, wenn true -> collection hat sich ge�ndert > neue Buchung ist hinzugekommen
					if(generierteBuchungsliste.addBuchung(student,kurs,erreichtePunkte)){
						buchungHinzugefuegt = true;
					}
				}
			}
		}
		//Statistik...
		System.out.println("Es wurden "+generierteStudentenliste.getSize()+" Studenten generiert.");
		System.out.println("Jeder Student hat zwischen "+minBuchungen+" und "+maxBuchungen+" Buchungen.");
		System.out.println("Insgesammt wurden "+generierteBuchungsliste.getSize()+" Buchungen zu den "+kursliste.getSize()+" gegebenen Kursen erstellt.\n"+
				"Das sind im Durchschnitt: "+new DecimalFormat("0.00").format((double)generierteBuchungsliste.getSize()/generierteStudentenliste.getSize())+" Buchungen pro Student.");
		
	}
	
	/**
	 * Generiert Studenten mit zuf�lligen Daten und f�gt Sie der Studentenliste hinzu
	 */
	private void generiereStudenten(){
		
		//�bergebener Parameter steuert wieoft die Schleife durchlaufen wird > 
		// > wieoft die Generierung eines Studenten stattfindet
		for(int i=0;i<anzahlStudenten;i++){
			
		    boolean zeitminimierer;
		    //setze zeitminimierer abh�ngig von der erzeugten Zufallszahl    
		    if(zufallsZahl(0,1)==1){
		       zeitminimierer=true;
		    }else{
		       zeitminimierer=false;
		    }
		    
		    boolean studentHinzugefuegt = false;
		    
		    // Falls zuf�llig die selbe MatrikelNummer generiert werden w�rde, �ndert sich die Collection nicht.
		    // Versuche solange einen Student hinzuzuf�gen, bis sich die Collection ver�ndert.
		    // Dadurch wird sichergestellt, dass auch die gew�nschte Anzahl an Studenten generiert wird.
		    while(!studentHinzugefuegt){
		    	
		    	//generiere Studenten mit zuf�llig aus den Arrays ausgew�hlten Daten (Strings, char)
		    	//Auswahl findet per Zufallszahl statt
		    	//wenn true zur�ckgeliefert wurde, war Student mit der zuf�lligen Matrikelnr noch nicht vorhanden 
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
		//neues Randomobjekt
		Random rand = new Random();
		return (rand.nextInt(maxBuchungen-minBuchungen+1))+minBuchungen;
	}
	
	/**
	 * Liefert eine Zufallszahl
	 * 
	 * @param x (int) - untere Grenze f�r Zufallszahl
	 * @param y (int) - obere Grenze f�r Zufallszahl
	 * @return int - Zufallszahl zwischen x und y
	 */
	private int zufallsZahl(int x, int y){
		//neues Randomobjekt
		Random rand = new Random();
		return (rand.nextInt(y-x+1))+x;
	}
	
	/**
	 * Liefert die Buchungsliste zur�ck, in der die Buchungs-Objekte verwaltet werden, 
	 * die mittels der gegebenen Kursliste und den generierten Studenten-Objekten erstellt wurden.
	 * 
	 * @return buchungsliste (Buchungsliste) - Buchungsliste mit generieten Buchungs-Objekten.
	 */
	public Buchungsliste getBuchungsliste(){
		return generierteBuchungsliste;
	}
	
	/**
	 * Liefert die Studentenliste zur�ck, in der die Studenten-Objekte verwaltet werden, 
	 * die zuf�llig generiert wurden.
	 * 
	 * @return studentenliste (Studentenliste) - Studentenliste mit generierten Studenten-Objekten.
	 */
	public Studentenliste getStudentenliste(){
		return generierteStudentenliste;
	}
	

}
