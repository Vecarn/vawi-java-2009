
package AusgabeDatenVerwaltung.Ausgabe;
import java.io.*;

import AusgabeDatenVerwaltung.*;
import Hilfsklassen.*;

/**
 * Realisierung des Datenschreibers, der FlatFiles ausgibt.
 * 
 * @author Martin
 * @version 0.2
 */
public class FlatFileSchreiber {


	private Datei datei;
    private AusgabeVerwaltung ausgabeVerwaltung;
	
    
    /**
     * Konstruktor f�r den FlatFileSchreiber.
     * @param ausgabeVerwaltung Ein Parameter mit einer Referenz
     * auf die AusgabeVerwaltung
     */
    public FlatFileSchreiber(AusgabeVerwaltung ausgabeVerwaltung) {
		datei = new Datei("output.txt");
		this.ausgabeVerwaltung = ausgabeVerwaltung;
    }
    
    
    
    /**
     * Methode f�r das �ffnen eines neuen Files
     */
    public void openFile(){
    	datei.openOutFile();
    }
    
    /**
     * Methode f�r das Schlie�en des Files
     */
    public void closeFile(){
    	datei.closeOutFile();
    }
    
    
    /**
     * @param output Der Parameter enth�lt den aufbereiteten String
     */
    public void writer(String output)
    {
    	datei.writeLine(output);
    }

}
