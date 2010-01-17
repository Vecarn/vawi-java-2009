
package AusgabeDatenVerwaltung.Ausgabe;
import java.io.*;

import AusgabeDatenVerwaltung.*;
import Hilfsklassen.*;

/**
 * Realisierung des Datenschreibers, der FlatFiles ausgibt.
 * 
 * @author Martin
 * @version 1.0
 */
public class FlatFileSchreiber {


	private Datei datei;
    private AusgabeVerwaltung ausgabeVerwaltung;
	
    
    /**
     * Konstruktor für den FlatFileSchreiber.
     * @param ausgabeVerwaltung Ein Parameter mit einer Referenz
     * auf die AusgabeVerwaltung
     */
    public FlatFileSchreiber(AusgabeVerwaltung ausgabeVerwaltung) {
		
		this.ausgabeVerwaltung = ausgabeVerwaltung;
    }
    
    public void setFile(String name){
    	datei = new Datei(name);
    }
    
    /**
     * Methode für das Öffnen eines neuen Files
     */
    public void openFile(){
    	datei.openOutFile();
    }
    
    /**
     * Methode für das Schließen des Files
     */
    public void closeFile(){
    	datei.closeOutFile();
    }
    
    
    /**
     * @param output Der Parameter enthält den aufbereiteten String
     */
    public void writer(String output)
    {
    	datei.writeLine(output);
    }

}
