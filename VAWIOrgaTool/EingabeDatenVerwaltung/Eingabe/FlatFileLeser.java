package EingabeDatenVerwaltung.Eingabe;

import java.io.IOException;
import java.util.StringTokenizer;

import Hilfsklassen.Datei;
import Hilfsklassen.Uni;
import EingabeDatenVerwaltung.DatenVerwaltung.*;

/**
 * Die Klasse FlatFileLeser liest die Eingabedaten aus einfachen CSV-Dateien 
 * und �bergibt die einzelnen Datens�tze an die entsprechenden Verwaltungsklassen zur Objekterstellung. 
 * 
 * @author Markus Bode
 * @version 1.0 vom 23.12.2009
 */
public class FlatFileLeser {
	
	/**
	 * Datei-Objekte f�r jeweilige Eingabedatei.
	 */
	private Datei studentendatei;
	private Datei buchungsdatei;
	private Datei kursdatei;
	/**
	 * Verwaltungs-Objekte f�r jeweiligen Daten-Typ.
	 */
	private Studentenliste studentenliste;
	private Buchungsliste buchungsliste;
	private Kursliste kursliste;
	
	/**
	 * Trennzeichen welches in den Eingabedateien genutzt wird um einzelne Attribute eines Datensatzes zu trennen
	 */
	private static String TRENNZEICHEN = ";"; 
	/**
	 * Konstruktor f�r Objekte der Klasse FlatFileLeser, welcher einen Dateinamen zu einer Kursdatei erwartet. <br>
	 * Kann z.B.: f�r den Simulationsprozess verwendet werden. (Nur eine Kursdatei, restl. Daten werden generiert)<br>
	 * F�r Planungsprozess ungeeignet, da nur eine Kursliste mit Kurs-Objekten erstellt wird. Die anderen Listen sind null.
	 * 
	 * @param kursdateiname (String): Dateiname der Kursdatei.
	 * @throws IOException : Wenn ein Problem beim �ffnen der Datei auftritt, wird eine IOException geworfen. 
	 */
	public FlatFileLeser(String kursdateiname) throws IOException {
		//neues Dateiobjekt f�r Kursdatei
		this.kursdatei = new Datei(kursdateiname);
		this.studentendatei = null;
		this.buchungsdatei = null;
		//neues Objekt kursliste erstellen
		this.kursliste = new Kursliste();
		//Daten einlesen 
		erstelleKursliste();
		
		
	}

	/**
	 * 
	 * Konstruktor f�r Objekte der Klasse FlatFileLeser welcher 3 Dateinamen erwartet. <br>
	 * Kann f�r den normalen Planungsprozess verwendet werden. <br> 
	 * Es werden 3 Verwaltungslisten aus den entsprechenden Dateien erstellt.
	 * 
	 * @param studentendateiname (String): Dateiname der Studentendatei.
	 * @param buchungsdateiname (String): Dateiname der Buchungsdatei.
	 * @param kursdateiname (String): Dateiname der Kursdatei.
	 * @throws IOException : Wenn ein Problem beim �ffnen der Datei auftritt, wird eine IOException ausgel�st.
	 * 
	 */
	public FlatFileLeser(String studentendateiname,
			String buchungsdateiname, String kursdateiname) throws IOException {
		//Dateiobjeke erstellen f�r einzelne Listen
		this.studentendatei = new Datei(studentendateiname);
		this.buchungsdatei = new Datei(buchungsdateiname);
		this.kursdatei = new Datei(kursdateiname);
		//Verwaltungsobjekte erstellen
		this.kursliste = new Kursliste();
		this.studentenliste = new Studentenliste();
		this.buchungsliste = new Buchungsliste();
		//Daten einlesen
		erstelleKursliste();
		erstelleStudentenliste();
		erstelleBuchungsliste();
		
	}
	
	/**
	 * Erstellt die Kursliste aus der Eingabedatei.
	 * 
	 */
	private void erstelleKursliste() throws IOException {
		
		System.out.println("=========Kursdaten=======================");
		
		//�ffne Datei und Pr�fe ob Fehler dabei auftritt, wenn dann wird eine Exception geworfen
		if(kursdatei.openInFile()!=0){
			throw new IOException("Fehler: Beim �ffnen der Eingabedatei - Kursliste.");
		}
        
		int anzahlZeilen = 0;
		
        while (!kursdatei.eof()){
            // Lese eine Zeile der Eingabedatei
            String kurs = kursdatei.readLine();
            // Pr�fe ob Fehler beim Lesen einer Zeile auftrat
            if (!kursdatei.state()){
            // werfe neue Exception, Fehler beim Lesen
                throw new IOException("Fehler: Beim lesen der Eingabdeatei - Kursliste.");
            }
            
            // Abfage, ob das Ende der Datei erreicht wurde
            if (!kursdatei.eof()){
            	
            	//trennt eingelesene Zeile bei TRENNZEICHEN und speichert in tokens
            	StringTokenizer st = new StringTokenizer(kurs,TRENNZEICHEN, true);
        		
            	//versuche Daten zu verarbeiten, wenn Exception auftritt ist Datensatz felerhaft (z.B. falsche L�nge)
            	//der Satz wird dann �bersprungen
            	try {
	            	
            		String[] daten = new String[9]; 
	        		int i = 0;
	        		//speichere Tokens in Array von Strings 
	        		while(st.hasMoreTokens()){
	        			daten[i]=st.nextToken();
	        			i++;
	        		}
	        		//speichere Daten aus Array in entsprechenden Variablen, ohne leerzeichen
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
					//f�ge der Kursliste einen neuen Kurs hinzu
					kursliste.addNeuerKurs(kursid, kurztitel, titel, teilleistungen, maxPunkte);
					
				} catch (Exception e) {
					//Exception aufgetreten -> Zeilennr ausgeben, Satz wird �bersprungen
					System.out.println("Zeile "+(anzahlZeilen+1)+": Kursdatensatz fehlerhaft -> �berspringen.");
				} 
            	
                anzahlZeilen++;                  
            }            
        }
                
        // Pr�fe ob Fehler beim schlie�en auftrat
        if (kursdatei.closeInFile()!=0){
            // werfe neue Exception, Fehler beim Schlie�en
            throw new IOException("Fehler: Beim schliessen der Eingabedatei - Kursliste.");
        }
        
        System.out.println("Anzahl Zeilen in der Kursdatei: "+anzahlZeilen+"\nAnzahl eindeutige, korrekte Kursdatens�tze: "+kursliste.getSize());
	}
	
	/**
	 * Erstellt die Buchungsliste aus der Eingabedatei.
	 * 
	 */
	private void erstelleBuchungsliste() throws IOException {
		
		System.out.println("=========Buchungsdaten===================");
		//erst Studentenliste und Kursliste erstellen
		//beim erstellen neuer Buchung: buchung.setStudent(studentenliste.getStudent(id))
		//   							buchung.setKurs(kursliste.getKurs(id))
		int anzahlZeilen = 0;
		//versuche File zu �ffnen, wenn Fehlschlag: neue Exception
		if(buchungsdatei.openInFile()!=0){
			throw new IOException("Fehler: Beim �ffen der Eingabedatei - Buchungsliste.");
		}
        
        while(!buchungsdatei.eof()){
        	//lese eine Zeile	
        	String buchung = buchungsdatei.readLine();
        	//pr�fe ob Fehler aufgetreten ist: wenn Fehler auftrat wird Exception erzeugt
        	if(!buchungsdatei.state()){
        		throw new IOException("Fehler: Beim lesen der Eingabdeatei - Buchungsliste.");
        	}
        	//Abfrage ob das Ende erreicht wurde
			if (!buchungsdatei.eof()) {
				//trennt eingelesene Zeile bei TRENNZEICHEN und speichert in tokens
				StringTokenizer st = new StringTokenizer(buchung, TRENNZEICHEN,true);
				
				//versuche Daten zu verarbeiten, wenn Exception auftritt ist Datensatz felerhaft (z.B. falsche L�nge)
            	//der Satz wird dann �bersprungen
				try {

					String[] daten = new String[5];
					int i = 0;
					//speichere Tokens in Array von Strings
					while (st.hasMoreTokens()) {
						daten[i] = st.nextToken();
						i++;
					}
					//speichere Daten aus Array in entsprechenden Variablen, ohne leerzeichen
					int matrikelnr = new Integer(daten[0].replaceAll(" ", "")).intValue();
					int kursid = new Integer(daten[2].replaceAll(" ", "")).intValue();
					int erreichtePunkte = new Integer(daten[4].replaceAll(" ","")).intValue();
					//pr�fe ob Studenten/Kursobjekt mit gelesener matrikelnr/kursid in den Verwaltungslisten vorhanden
					//das Buchungsobjekt wird dann gleich mit deren Referenzen gespeichert
					if ((studentenliste.getStudent(matrikelnr) != null)
							&& (kursliste.getKurs(kursid) != null)) {
						buchungsliste.addBuchung(studentenliste.getStudent(matrikelnr), kursliste.getKurs(kursid), erreichtePunkte);
					} else {
						//Die oder eine der gelesenen Nr. ist unbekannt -> Buchung nicht hinzugef�gt
						System.out.println("Zeile "+(anzahlZeilen+1)+": Student (Nr:"+matrikelnr+") oder Kurs (Nr:"+kursid+") der Buchung nicht in Kurs-/Studentenliste -> Buchung nicht aufgenommen!");
					}
					
				} catch(Exception e){
					//Exception aufgetreten -> Zeilennr ausgeben, Satz wird �bersprungen
					System.out.println("Zeile "+(anzahlZeilen+1)+": Buchungssatz fehlerhaft -> �berspringen.");
				}  
				
				anzahlZeilen++;
			}	
        }
        // Pr�fe ob Fehler beim schlie�en auftrat
        if(buchungsdatei.closeInFile()!=0){
        	 // werfe neue Exception, Fehler beim Schlie�en
        	throw new IOException("Fehler: Beim schliessen der Eingabedatei - Buchungsliste.");
        }
        
        System.out.println("Anzahl Zeilen in der Buchungsdatei: "+anzahlZeilen+"\nAnzahl eindeutige, korrekte Buchungsdatens�tze: "+buchungsliste.getSize());
	}
	
	/**
	 * Erstellt die Studentenliste aus der Eingabedatei.
	 * 
	 */
	private void erstelleStudentenliste() throws IOException {
		
		System.out.println("=========Studentendaten==================");
		
		//erst Studentenliste und Kursliste erstellen
		//beim erstellen neuer Buchung: buchung.setStudent(studentenliste.getStudent(id))
		//   							buchung.setKurs(kursliste.getKurs(id))
		int anzahlZeilen = 0;
		//versuche File zu �ffnen, wenn Fehlschlag: neue Exception
		if(studentendatei.openInFile()!=0){
			throw new IOException("Fehler: Beim �ffen der Eingabedatei - Studentenliste.");
		}
        
        while(!studentendatei.eof()){
        	//Lese eine Zeile	
        	String student = studentendatei.readLine();
        	//pr�fe ob Fehler aufgetreten ist: wenn Fehler auftrat wird Exception erzeugt
        	if(!studentendatei.state()){
        		throw new IOException("Fehler: Beim lesen der Eingabdeatei - Studentenliste.");
        	}
        	//pr�fe ob jetzt Ende erreicht
			if (!studentendatei.eof()) {
				//trennt eingelesene Zeile bei TRENNZEICHEN und speichert in tokens
				StringTokenizer st = new StringTokenizer(student, TRENNZEICHEN,true);
				
				//versuche Daten zu verarbeiten, wenn Exception auftritt ist Datensatz felerhaft (z.B. falsche L�nge)
            	//der Satz wird dann �bersprungen
				try {

					String[] daten = new String[11];
					int i = 0;
					//speichere Tokens in Array von Strings
					while (st.hasMoreTokens()) {
						daten[i] = st.nextToken();
						i++;
					}
					//speichere Daten aus Array in entsprechenden Variablen, ohne leerzeichen
					int matrikelNummer = new Integer(daten[0].replaceAll(" ","")).intValue();
					String name = daten[2].replaceAll(" ", "");
					String vorname = daten[4].replaceAll(" ", "");
					char uni;
					if (daten[6].replaceAll(" ", "").charAt(0) == 'D') {
						uni = Uni.Duisburg;
					} else {
						uni = Uni.Bamberg;
					}
					String bundesland = daten[8].replaceAll(" ", "");
					boolean zeitminimierer;
					if (daten[10].replaceAll(" ", "").equalsIgnoreCase("ja")) {
						zeitminimierer = true;
					} else {
						zeitminimierer = false;
					}
					//f�ge der Studentenliste einen neuen Student hinzu
					studentenliste.addNeuerStudent(matrikelNummer, name,vorname, uni, bundesland, zeitminimierer);
				
				} catch (Exception e) {
					//Exception aufgetreten -> Zeilennr ausgeben, Satz wird �bersprungen
					System.out.println("Zeile "+(anzahlZeilen+1)+": Studentendatensatz hat falsche L�nge -> �berspringen.");
				}

				anzahlZeilen++;

			}    		
        }
        // Pr�fe ob Fehler beim schlie�en auftrat
        if(studentendatei.closeInFile()!=0){
        	 // werfe neue Exception, Fehler beim Schlie�en
        	throw new IOException("Fehler: Beim schliessen der Eingabedatei - Studentenliste.");
        }
        
        System.out.println("Anzahl Zeilen in der Studentendatei: "+anzahlZeilen+"\nAnzahl eindeutige, korrekte Studentendatens�tze: "+studentenliste.getSize());
		
	}

	/**
	 * Liefert die Studentenliste zur�ck, in der die Studenten-Objekte verwaltet werden, 
	 * die aus der �bergebenen Datei erstellt wurden.
	 * 
	 * @return studentenliste (Studentenliste)
	 */
	public Studentenliste getStudentenliste() {
		return studentenliste;
	}

	/**
	 * Liefert die Buchungsliste zur�ck, in der die Buchungs-Objekte verwaltet werden, 
	 * die aus der �bergebenen Datei erstellt wurden.
	 * 
	 * @return buchungsliste (Buchungsliste)
	 */
	public Buchungsliste getBuchungsliste() {
		return buchungsliste;
	}

	/**
	 * Liefert die Kursliste zur�ck, in der die Kurs-Objekte verwaltet werden, 
	 * die aus der �bergebenen Datei erstellt wurden.
	 * 
	 * @return kursliste (Kursliste)
	 */
	public Kursliste getKursliste() {
		return kursliste;
	}
	
	
}
