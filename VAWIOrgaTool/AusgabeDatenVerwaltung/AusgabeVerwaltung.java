
package AusgabeDatenVerwaltung;
import AusgabeDatenVerwaltung.Ausgabe.FlatFileSchreiber;
import AusgabeDatenVerwaltung.Datenverwaltung.*;
import EingabeDatenVerwaltung.DatenVerwaltung.Studentenliste;
import Hilfsklassen.Datei;

/**
 * Dies AusgabeVerwaltung ist eine 
 * Verwaltungsklasse, welche alle Ausgaben-Entit&auml;ten 
 * setzen und zur&uuml;ckgeben kann. Sie dient dazu, 
 * die Logik der Bef&uuml;llung der Datenklassen von der
 * Logik der eigentlichen Ausgabe der Daten zu trennen, 
 * mit dem Ziel redundante Logik f&uuml;r unterschiedliche
 * Ausgabeformen zu vermeiden..
 * 
 * @author Martin
 * @version 0.1
 */
public class AusgabeVerwaltung {

    private Pruefungsterminplan pruefungsterminplan;
    private Anwesenheitsliste anwesenheitsliste;
    private Notenliste notenliste;
    private Platzkartenliste platzkartenliste;    
    private FlatFileSchreiber fileschreiber;
    private Datei datei;
    private Studentenliste studentenliste;

    
    public void AusgabeVerwaltung(Studentenliste studentenliste){
    	
    	fileschreiber = new FlatFileSchreiber(this);
    	this.studentenliste = studentenliste;
    }
    
    /**
     * @return
     */
    public boolean generiereAnwesenheitsliste(){
    	
    	while(studentenliste.getStudentIterator().hasNext()){
    		
    		anwesenheitsliste.addAnwesenheit(
    				uni, tag, studentenliste.getStudentIterator().next());
    		
    		
    	}
    	
    	
    	return true;
    }
    
    /**
     * @return
     */
    public boolean generierePruefungsterminplan(){
    	return true;
    }
    
    /**
     * @return
     */
    public boolean generiereNotenliste() {
		
    	return true;
	}
    
    /**
     * @return
     */
    public boolean generierePlatzkartenliste() {
		return true;
	}

 }
