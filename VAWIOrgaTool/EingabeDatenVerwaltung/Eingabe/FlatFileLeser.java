package EingabeDatenVerwaltung.Eingabe;

import java.io.IOException;
import java.util.StringTokenizer;

import Hilfsklassen.Datei;
import Hilfsklassen.Uni;
import EingabeDatenVerwaltung.DatenVerwaltung.*;

/**
 * Die Klasse FlatFileLeser liest die Eingabedaten aus einfachen CSV-Dateien 
 * und übergibt die einzelnen Datensätze an die entsprechenden Verwaltungsklassen zur Objekterstellung. 
 * 
 * @author Markus Bode
 * @version 1.0 vom 23.12.2009
 * @TODO FEHLERHANDLING! (skip Satz wenn unvollständig)
 */
public class FlatFileLeser {
	
	/**
	 * Datei-Objekte für jeweilige Eingabedatei.
	 */
	private Datei studentendatei;
	private Datei buchungsdatei;
	private Datei kursdatei;
	/**
	 * Verwaltungs-Objekte für jeweiligen Daten-Typ.
	 */
	private Studentenliste studentenliste;
	private Buchungsliste buchungsliste;
	private Kursliste kursliste;

	private static String TRENNZEICHEN = ","; 
	/**
	 * Konstruktor für Objekte der Klasse FlatFileLeser, welcher einen Dateinamen zu einer Kursdatei erwartet. <br>
	 * Kann z.B.: für den Simulationsprozess verwendet werden. (Nur eine Kursdatei, restl. Daten werden generiert)<br>
	 * Für Planungsprozess ungeeignet, da nur eine Kursliste mit Kurs-Objekten erstellt wird. Die anderen Listen sind null.
	 * 
	 * @param kursdateiname (String): Dateiname der Kursdatei.
	 * @throws IOException : Wenn ein Problem beim Öffnen der Datei auftritt, wird eine IOException geworfen. 
	 */
	public FlatFileLeser(String kursdateiname) throws IOException {
		
		this.kursdatei = new Datei(kursdateiname);
		this.studentendatei = null;
		this.buchungsdatei = null;
		
		this.kursliste = new Kursliste();
		
		erstelleKursliste();
		
		
	}

	/**
	 * 
	 * Konstruktor für Objekte der Klasse FlatFileLeser welcher 3 Dateinamen erwartet. <br>
	 * Kann für den normalen Planungsprozess verwendet werden. <br> 
	 * Es werden 3 Verwaltungslisten aus den entsprechenden Dateien erstellt.
	 * 
	 * @param studentendateiname (String): Dateiname der Studentendatei.
	 * @param buchungsdateiname (String): Dateiname der Buchungsdatei.
	 * @param kursdateiname (String): Dateiname der Kursdatei.
	 * @throws IOException : Wenn ein Problem beim Öffnen der Datei auftritt, wird eine IOException ausgelöst.
	 * 
	 */
	public FlatFileLeser(String studentendateiname,
			String buchungsdateiname, String kursdateiname) throws IOException {
		
		this.studentendatei = new Datei(studentendateiname);
		this.buchungsdatei = new Datei(buchungsdateiname);
		this.kursdatei = new Datei(kursdateiname);
		
		this.kursliste = new Kursliste();
		this.studentenliste = new Studentenliste();
		this.buchungsliste = new Buchungsliste();
		
		erstelleKursliste();
		erstelleStudentenliste();
		erstelleBuchungsliste();
		
	}
	
	/**
	 * Erstellt die Kursliste aus der Eingabedatei.
	 * 
	 */
	private void erstelleKursliste() throws IOException {
		
		//Öffne Datei und Prüfe ob Fehler dabei auftritt
		if(kursdatei.openInFile()!=0){
			throw new IOException("Fehler: Beim öffnen der Eingabedatei - Kursliste.");
		}
        
		int anzahlZeilen = 0;
		
        while (!kursdatei.eof()){
            // Lese eine Zeile der Eingabedatei
            String kurs = kursdatei.readLine();
            // Prüfe ob Fehler beim Lesen einer Zeile auftrat
            if (!kursdatei.state()){
                // werfe neue Exception, Fehler beim Lesen
                throw new IOException("Fehler: Beim lesen der Eingabdeatei - Kursliste.");
            }
            
            // Abfage, ob das Ende der Datei erreicht wurde
            if (!kursdatei.eof()){
            	StringTokenizer st = new StringTokenizer(kurs,TRENNZEICHEN, true);
        		String[] daten = new String[9]; 
        		int i = 0;
        		while(st.hasMoreTokens()){
        			daten[i]=st.nextToken();
        			i++;
        		}
        		
        		int kursid = new Integer(daten[0].replaceAll(" ", "")).intValue();
        		String kurztitel = daten[2].replaceAll(" ", "");
        		String titel = daten[4];
        		boolean teilleistungen;
        		if(daten[6].replaceAll(" ", "").equalsIgnoreCase("ja")){
        			teilleistungen = true;
        		}else{
        			teilleistungen = false;
        		}
        		int maxPunkte = new Integer(daten[8].replaceAll(" ", "")).intValue();
        		 
        		kursliste.addNeuerKurs(kursid, kurztitel, titel, teilleistungen, maxPunkte);
        		
                anzahlZeilen++;                  
            }            
        }
        
        
        // Prüfe ob Fehler beim schließen auftrat
        if (kursdatei.closeInFile()!=0){
            // werfe neue Exception, Fehler beim Schließen
            throw new IOException("Fehler: Beim schliessen der Eingabedatei - Kursliste.");
        }
        
        System.out.println("==Anzahl Zeilen in Datei: "+anzahlZeilen+" Anzahl eindeutige Kurse: "+kursliste.getSize());
	}
	
	/**
	 * Erstellt die Buchungsliste aus der Eingabedatei.
	 * 
	 */
	private void erstelleBuchungsliste() throws IOException {
		
		//erst Studentenliste und Kursliste erstellen
		//beim erstellen neuer Buchung: buchung.setStudent(studentenliste.getStudent(id))
		//   							buchung.setKurs(kursliste.getKurs(id))
		int anzahlZeilen = 0;
		
		if(buchungsdatei.openInFile()!=0){
			throw new IOException("Fehler: Beim öffen der Eingabedatei - Buchungsliste.");
		}
        
        while(!buchungsdatei.eof()){
        		
        	String buchung = buchungsdatei.readLine();
        	
        	if(!buchungsdatei.state()){
        		throw new IOException("Fehler: Beim lesen der Eingabdeatei - Buchungsliste.");
        	}
        	
        	if(!buchungsdatei.eof()){
        		
        		StringTokenizer st = new StringTokenizer(buchung, TRENNZEICHEN, true);
        		String[] daten = new String[5]; 
        		int i = 0;
        		while(st.hasMoreTokens()){
        			daten[i]=st.nextToken();
        			i++;
        		}
        		
        		int matrikelnr = new Integer(daten[0].replaceAll(" ", "")).intValue();
        		int kursid = new Integer(daten[2].replaceAll(" ", "")).intValue();
        		int erreichtePunkte = new Integer(daten[4].replaceAll(" ", "")).intValue();
        		
        		if((studentenliste.getStudent(matrikelnr)!=null)&&(kursliste.getKurs(kursid)!=null)){
        			buchungsliste.addBuchung(studentenliste.getStudent(matrikelnr), kursliste.getKurs(kursid), erreichtePunkte);
        		}else{
        			System.out.println("-"+matrikelnr+"-"+kursid);
        		}
        		anzahlZeilen++;	
        	}        		
        }
        
        if(buchungsdatei.closeInFile()!=0){
        	throw new IOException("Fehler: Beim schliessen der Eingabedatei - Buchungsliste.");
        }
        
        System.out.println("==Anzahl Zeilen in Datei: "+anzahlZeilen+" Anzahl eindeutige Buchungen: "+buchungsliste.getSize());
	}
	
	/**
	 * Erstellt die Studentenliste aus der Eingabedatei.
	 * 
	 */
	private void erstelleStudentenliste() throws IOException {
		//erst Studentenliste und Kursliste erstellen
		//beim erstellen neuer Buchung: buchung.setStudent(studentenliste.getStudent(id))
		//   							buchung.setKurs(kursliste.getKurs(id))
		int anzahlZeilen = 0;
		
		if(studentendatei.openInFile()!=0){
			throw new IOException("Fehler: Beim öffen der Eingabedatei - Studentenliste.");
		}
        
        while(!studentendatei.eof()){
        		
        	String student = studentendatei.readLine();
        	
        	if(!studentendatei.state()){
        		throw new IOException("Fehler: Beim lesen der Eingabdeatei - Studentenliste.");
        	}
        	
        	if(!studentendatei.eof()){
        		
        		
        		StringTokenizer st = new StringTokenizer(student, TRENNZEICHEN, true);
        		String[] daten = new String[11]; 
        		int i = 0;
        		while(st.hasMoreTokens()){
        			daten[i]=st.nextToken();
        			i++;
        		}
        		
        		int matrikelNummer = new Integer(daten[0].replaceAll(" ", "")).intValue();
        		String name = daten[2].replaceAll(" ", "");
        		String vorname = daten[4].replaceAll(" ", "");
        		char uni;
        		if(daten[6].replaceAll(" ", "").charAt(0)=='D'){
        			uni = Uni.Duisburg;
        		}else{
        			uni = Uni.Bamberg;
        		}
        		String bundesland = daten[8].replaceAll(" ", "");
        		boolean zeitminimierer;
        		if(daten[10].replaceAll(" ", "").equalsIgnoreCase("ja")){
        			zeitminimierer = true;
        		}else{
        			zeitminimierer = false;
        		}
        		
        		studentenliste.addNeuerStudent(matrikelNummer, name, vorname, uni, bundesland, zeitminimierer);
        		
        		anzahlZeilen++;
        		
        	}        		
        }
        
        if(studentendatei.closeInFile()!=0){
        	throw new IOException("Fehler: Beim schliessen der Eingabedatei - Studentenliste.");
        }
        
        System.out.println("==Anzahl Zeilen in Datei: "+anzahlZeilen+" Anzahl eindeutige Studenten: "+studentenliste.getSize());
		
	}

	/**
	 * Liefert die Studentenliste zurück, in der die Studenten-Objekte verwaltet werden, 
	 * die aus der übergebenen Datei erstellt wurden.
	 * 
	 * @return studentenliste (Studentenliste)
	 */
	public Studentenliste getStudentenliste() {
		return studentenliste;
	}

	/**
	 * Liefert die Buchungsliste zurück, in der die Buchungs-Objekte verwaltet werden, 
	 * die aus der übergebenen Datei erstellt wurden.
	 * 
	 * @return buchungsliste (Buchungsliste)
	 */
	public Buchungsliste getBuchungsliste() {
		return buchungsliste;
	}

	/**
	 * Liefert die Kursliste zurück, in der die Kurs-Objekte verwaltet werden, 
	 * die aus der übergebenen Datei erstellt wurden.
	 * 
	 * @return kursliste (Kursliste)
	 */
	public Kursliste getKursliste() {
		return kursliste;
	}
	
	
}
