
package EingabeDatenVerwaltung.DatenObjekte;

/**
 * Datenträgerklasse Kurs 
 * enthält die Kurs-Objekte
 * mit den Eigenschaften eines Kurses und den passenden Getter/Setter-Methoden
 * 
 * @author  Silvia Wölfle
 * @version 1.0 on 04.12.2009
 */
public class Kurs
{
    // Attribute der Klasse Kurs
    // kursId steht für die Kursnummer
    private int kursid;
    // titel steht für den Kursnamen
    private String titel;
    // kurzTitel steht für den Kurskurznamen
    private String kurztitel;
    // Kurse können Teilleistungen beinhalten
    // true bedeutet, dass der Kurs Teilleistungen vorsieht
    // false bedeutet, dass der Kurs keine Teilleistungen vorsieht
    private boolean hatTeilleistungen;
    // in maxPunkte werden maximal erreichbare Punkte in Teilleistungen abgebildet
    // bedingt, dass hatTeilleistungen true ist
    private short maxPunkte;

    /**
     * Konstruktor für Objekte der Kurs ohne Parameter
     */
    public Kurs()
    {
        // initialise instance variables
        titel="";
        kurztitel="";
        hatTeilleistungen=true;
    }

    /**
     * Konstruktor für Objekte der Klasse Kurs mit Parameter 
     * (der titel und kursid bei der erstellung des Objekts verlangt und gleich setzt
     * 
     * @param in_kursid             ID des Kurses (int)
     * @param in_titel              Titel des Kurses (String)
     */
    public Kurs(int in_kursid, String in_titel)
    {
        this.kursid=kursid;
        this.titel="";
     }
   /**
     * Getter/Setter-Methoden
     */    
     
}