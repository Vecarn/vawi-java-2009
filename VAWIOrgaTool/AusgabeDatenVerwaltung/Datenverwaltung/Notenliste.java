
package AusgabeDatenVerwaltung.Datenverwaltung;

import java.util.*;

import AusgabeDatenVerwaltung.AusgabeVerwaltung;
import EingabeDatenVerwaltung.DatenObjekte.*;
import EingabeDatenVerwaltung.DatenVerwaltung.*;

/**
 * Verwaltungsklasse f&uuml;r die Noten eines 
 * Studenten und gleichzeitig Entit&auml;tstyp f&uuml;r eine Notenliste.
 * 
 * @author Martin
 * @version 1.2
 */
public class Notenliste {

	/**
	 * Die Buchungsliste
	 */
    private Buchungsliste buchungsliste;
    /**
     * Die Ausgabeverwaltung
     */
    private AusgabeVerwaltung ausgabeverwaltung;
    

    /**
     * Der Konstruktor für die Notenliste. Erzeugt Objekte für die Notenliste
     * und die Buchungliste
     * @param buchungsliste Die Buchungsliste der allgemeinen Verwaltung wird
     * an das Objekt übergeben.
     * @param ausgabeverwaltung Die Instanz der Ausgabeverwaltung muss 
     * hier auch noch übergeben werden. Diese würd für das Erzeugen den
     * Listenheader benötigt.
     * 
     */
    public Notenliste(Buchungsliste buchungsliste,
    		AusgabeVerwaltung ausgabeverwaltung){
    	 this.buchungsliste = buchungsliste;
    	 this.ausgabeverwaltung = ausgabeverwaltung;
    }
    
	

	
	/**
	 * Methode um die Daten der Listen aufzubereiten
	 * @return String mit der aufbereiteten Liste
	 */
	public String erzeugeListe(){
		
		//output String für die Erzeugung der Liste
		String output = new String();
		//der Iterator der Buchungsliste
    	Iterator i1 = buchungsliste.getIterator();
    	//integer Wert der den aktuellen Kurs speichert
    	int kursid = 0;
    	
    	
    	//zum Output wird zuerst der Header hinzugefügt
    	output = ausgabeverwaltung.generiereHeader(1);

    	//so lange der Iterator noch Elemente hat wird geloopt
    	while(i1.hasNext()){
    		
    		//Buchung holen
    		Buchung b = (Buchung) i1.next();
    		
    		//wenn die aktuelle Kursid ungleich der gespeicherten
    		//dann Kurszeile ausgeben
    		if(kursid != b.getKurs().getKursid()){
    			 
    			output = output + "\n\nKurs " 
    					+ b.getKurs().getKursid() +
    					" - " + b.getKurs().getKurztitel() + "\n";
    			output = output + ausgabeverwaltung.line;
    		}
    		
    		//ansonsten hier weiter mit der Studentenzeile
    		output = output + b.getStudent().getMatrikelnr() + " - " + 
    						b.getStudent().getName() + ", "
    					+ b.getStudent().getVorname();
    		
    		//wenn der Kurs eine Teilleistung hat dann
    		//das Ergebnis der TL in den Stream schreiben
    		if(b.getKurs().getHatTeilleistungen() == true){
    			output = output + ": " + b.getErreichtePunkte();
    		}
    		
    		
    		output = output + "\n";
    		
    		//die Kursid am Ende auf den aktuellen Kurs der Buchung setzen
    		kursid =  b.getKurs().getKursid();
    	}
    	
    	
    	return output;
	}

    
 }
