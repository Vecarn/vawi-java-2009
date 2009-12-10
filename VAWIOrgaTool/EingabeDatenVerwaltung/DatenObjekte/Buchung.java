
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
    private int erreichtePunkte;

     /**
     * Konstruktor Buchung, verlangt einen Studenten und einen Kurs 
     * für die Erstellung eines Buchungsobjektes
     */
    public Buchung(Student in_student, Kurs in_kurs)
    {
        student = in_student;
        kurs = in_kurs;
    }

   /**
     * Getter/Setter-Methoden
     */    
    // Setter
    public void setStudent(Student in_student)
     {
         student = in_student;
     }
    public void setKurs(Kurs in_kurs)
     {
         kurs = in_kurs;
     }
    public void setErreichtePunkte(int in_erreichtePunkte)
     {
         erreichtePunkte =in_erreichtePunkte;
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
    public int getErreichtePunkte()
      {
      return erreichtePunkte;
      }

}