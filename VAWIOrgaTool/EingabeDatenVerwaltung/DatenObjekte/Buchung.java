
package EingabeDatenVerwaltung.DatenObjekte;

/**
 * Datenträgerklasse Buchung
 * enthält Buchungs-Objekte 
 * mit den Eigenschaften einer Buchung (aus Student und Kurs und bereits erreichte Punkte)
 * und den passenden Getter/Setter-Methoden
 * 
 * @author  Silvia Wölfle
 * @version 1.0 on 04.12.2009
 */
public class Buchung
{
    // Attribute: Klassen Student, Kurs sowie bereichts erreichte Punkte
    public Student matrikelnr;
    public Kurs kursid;
    private short erreichtePunkte;

     /**
     * Konstruktor Buchung, verlangt einen Studenten und einen Kurs 
     * für die Erstellung eines Buchungsobjektes
     */
    public Buchung(Student student, Kurs kurs)
    {
        this.matrikelnr = student;
        this.kursid = kurs;
    }
    
    
    
/**
 * 
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm782d]
 */
    public EingabeDatenVerwaltung.DatenObjekte.Kurs kurs;
/**
 * 
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm7804]
 */
    public EingabeDatenVerwaltung.DatenObjekte.Student student;




}