
package AusgabeDatenVerwaltung.DatenObjekte;
import  EingabeDatenVerwaltung.DatenObjekte.*;

/**
 * Datenklasse Note mit den Eigenschaften einer Sammlung an Noten jedes Studenten 
 * und den passenden Getter/Setter-Methoden.
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm72e8]
 */
public class Noten 
{
 
    // Attribute f�r Klasse Noten, aus den Klassen Student und Kurs und der Pruefungsverwaltung
    private Kurs kurs;
    private Student student;
    private Buchung buchung; 

    /**
     * Konstruktor Note, verlangt Studenten-, Kurs- und Buchungs-Attribute 
     * f�r die Erstellung eines Notenobjektes
     */
    public Note(Student student, Kurs kurs, Buchung buchung);
    {
        this.kurs = kurs;
        this.student = student;
        this.buchung = buchung;
    }
}