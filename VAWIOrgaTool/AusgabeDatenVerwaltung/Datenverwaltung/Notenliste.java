
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
 * @version 1.0
 */
public class Notenliste {


    private Buchungsliste buchungsliste;
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
			
		String output = new String();
    	Iterator i1 = buchungsliste.getIterator();
    	int kursid = 0;
    	output = ausgabeverwaltung.generiereHeader(1);
    	    	
    	while(i1.hasNext()){
    		Buchung b = (Buchung) i1.next();
    		if(kursid != b.getKurs().getKursid()){
    			 
    			output = output + "\n\nKurs " 
    					+ b.getKurs().getKursid() +
    					" - " + b.getKurs().getKurztitel() + "\n";
    			output = output + "-----------------------------------\n";
    		}
    		
    		output = output + b.getStudent().getName() + ", "
    					+ b.getStudent().getVorname();
    		
    		if(b.getKurs().getHatTeilleistungen() == true){
    			output = output + ": " + b.getErreichtePunkte();
    		}
    		
    		output = output + "\n";
    		
    		
    		kursid =  b.getKurs().getKursid();
    	}
    	
    	return output;
	}

    
 }
