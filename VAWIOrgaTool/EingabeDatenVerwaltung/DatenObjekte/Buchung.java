
package EingabeDatenVerwaltung.DatenObjekte;
import  EingabeDatenVerwaltung.DatenObjekte.*;

/**
 * Datentr�gerklasse Buchung
 * enth�lt Buchungs-Objekte 
 * mit den Eigenschaften einer Buchung (aus Student und Kurs und bereits erreichte Punkte)
 * und den passenden Getter/Setter-Methoden
 * 
 * @author  Silvia W�lfle
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
     * f�r die Erstellung eines Buchungsobjektes
     * @param student Student in der Buchung (Student)
     * @param kurs Kurs in der Buchung (Kurs)
     */
    public Buchung(Student in_student, Kurs kurs)
    {
        this.student = student;
        this.kurs = kurs;
    }

    /**
     * Set-Methode student (eigentlich schon in Konstruktor fix)
     * @param student Student in der Buchung (Student)
     */  
    public void setStudent(Student in_student)
     {
         this.student = student;
     }
    /**
     * Set-Methode kurs (eigentlich schon in Konstruktor fix)
     * @param kurs Kurs in der Buchung (Kurs)
     */  
    public void setKurs(Kurs kurs)
     {
         this.kurs = kurs;
     }
   /**
     * Set-Methode erreichtePunkte (ueberschreibt Attribut erreichtePunkte)
     * @param erreichtePunkte bisher erriechte Punkte eines Studenten (int)
     */  
    public void setErreichtePunkte(int erreichtePunkte)
     {
         this.erreichtePunkte = erreichtePunkte;
     }

    /**
     * Get-Methode: Gibt Student in der Buchung als Student zur�ck
     * @return   Student der Buchung als Student
     */
    public Student getStudent()
      {
      return student;
      }
    /**
     * Get-Methode: Gibt Kurs in der Buchung als Kurs zur�ck
     * @return   Kurs der Buchung als Kurs
     */
    public Kurs getKurs()
      {
      return kurs;
      }
    /**
     * Get-Methode: Gibt bisher erreichte Punkte eines Studenten als int zur�ck
     * @return   ErreichtePunkte des Studenten als int
     */
    public int getErreichtePunkte()
      {
      return erreichtePunkte;
      }

}