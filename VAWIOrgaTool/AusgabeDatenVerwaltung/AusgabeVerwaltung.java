
package AusgabeDatenVerwaltung;
import AusgabeDatenVerwaltung.Datenverwaltung.*;

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
 */
public class AusgabeVerwaltung {

    private Pruefungsterminplan pruefungsterminplan;

    private Anwesenheitsliste anwesenheitsliste;

    private Notenliste notenliste;

    private Platzkartenliste platzkartenliste;

	/**
	 * @return the pruefungsterminplan
	 */
	public Pruefungsterminplan getPruefungsterminplan() {
		return pruefungsterminplan;
	}

	/**
	 * @return the anwesenheitsliste
	 */
	public Anwesenheitsliste getAnwesenheitsliste() {
		return anwesenheitsliste;
	}

	/**
	 * @return the notenliste
	 */
	public Notenliste getNotenliste() {
		return notenliste;
	}

	/**
	 * @return the platzkartenliste
	 */
	public Platzkartenliste getPlatzkartenliste() {
		return platzkartenliste;
	}


 }
