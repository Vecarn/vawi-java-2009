
package EingabeDatenVerwaltung.DatenObjekte;
import  EingabeDatenVerwaltung.DatenObjekte.*;

/**
 * Datentr�gerklasse Buchung
 * enth�lt Buchungs-Objekte 
 * mit den Eigenschaften einer Buchung (aus Student und Kurs und bereits erreichte Punkte)
 * und den passenden Getter/Setter-Methoden
 * 
 * @author  Silvia W�lfle
 * @version 3.0 on 22.01.2010
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
    public Buchung(Student student, Kurs kurs)
    {
       if(student==null){
            System.out.println("Student ist null!");
            return;
            }         
         this.student = student;
         
         if(kurs==null){
            System.out.println("Kurs ist null!");
            return;
            }      
         this.kurs = kurs;
    }


     /**
     * Set-Methode erreichtePunkte (ueberschreibt Attribut erreichtePunkte)
     * @param erreichtePunkte bisher erreichte Punkte eines Studenten (int), mit Vergleich maxPunkte und �berpr�fung
     */  
    public void setErreichtePunkte(int erreichtePunkte)
    {
            if (erreichtePunkte > this.kurs.getMaxPunkte()){
                System.out.println("Ung�ltiger Wert, erreichte Punkte k�nnen maximale Punkte nicht �bersteigen!");
                return;
            } else {
                this.erreichtePunkte = erreichtePunkte;
            }
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