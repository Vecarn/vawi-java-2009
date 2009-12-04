
package EingabeDatenVerwaltung.DatenObjekte;
import  EingabeDatenVerwaltung.DatenObjekte.*;

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
    private Student student;
    private Kurs kurs;
    private short erreichtePunkte;

     /**
     * Konstruktor Buchung, verlangt einen Studenten und einen Kurs 
     * für die Erstellung eines Buchungsobjektes
     */
    public Buchung(Student student, Kurs kurs)
    {
        this.student = student;
        this.kurs = kurs;
    }

   /**
     * Getter/Setter-Methoden
     */    
    // Setter
    public void setStudent(Student student)
     {
         this.student = student;
     }
    public void setKurs(Kurs kurs)
     {
         this.kurs = kurs;
     }
    public void setErreichtePunkte(short erreichtePunkte)
     {
         this.erreichtePunkte = erreichtePunkte;
     }

    // Getter
     public Student getStudent()
      {
      return student;
      }
     public Kurs getKurs()
      {
      return kurs;
      }
    public short getErreichtePunkte()
      {
      return erreichtePunkte;
      }

}