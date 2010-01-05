
package EingabeDatenVerwaltung.DatenObjekte;
import  EingabeDatenVerwaltung.DatenObjekte.*;

/**
 * Datentr�gerklasse Buchung
 * enth�lt Buchungs-Objekte 
 * mit den Eigenschaften einer Buchung (aus Student und Kurs und bereits erreichte Punkte)
 * und den passenden Getter/Setter-Methoden
 * 
 * @author  Silvia W�lfle
 * @version 2.0 on 08.01.2010
 */
public class Buchung
{
    // Attribute: Klassen Student, Kurs sowie bereichts erreichte Punkte
    private Student student;
    private Kurs kurs;
    private int erreichtePunkte;
    private Kurs maxPunkte;

     /**
     * Konstruktor Buchung, verlangt einen Studenten und einen Kurs 
     * f�r die Erstellung eines Buchungsobjektes
     * @param student Student in der Buchung (Student)
     * @param kurs Kurs in der Buchung (Kurs)
     */
    public Buchung(Student student, Kurs kurs)
    {
        this.student = student;
        this.kurs = kurs;
    }

    /**
     * Set-Methode student (eigentlich schon in Konstruktor fix)
     * @param student Student in der Buchung (Student)
     */  
    public void setStudent(Student student)
     {
         if(student==null){
            System.out.println("Student ist null!");
            return;
            }         
         this.student = student;
     }
    /**
     * Set-Methode kurs (eigentlich schon in Konstruktor fix)
     * @param kurs Kurs in der Buchung (Kurs)
     */  
    public void setKurs(Kurs kurs)
     {
         if(kurs==null){
            System.out.println("Kurs ist null!");
            return;
            } else if(kurs instanceof Kurs)       
         this.kurs = kurs;
        
     }
    
     /**
      * Set-Methode maxPunkte (ueberschreibt Attribut maxPunkte aus Klasse Kurs)
      * ben�tigt fuer Ueberpruefung der erreichten Punkte
      */
     public void setMaxPunkte (Kurs maxPunkte)
     {
         this.maxPunkte = maxPunkte;
        }
     
     /**
     * Set-Methode erreichtePunkte (ueberschreibt Attribut erreichtePunkte)
     * @param erreichtePunkte bisher erreichte Punkte eines Studenten (int), mit Vergleich maxPunkte
     */  
    public void setErreichtePunkte(int erreichtePunkte)
    {
            if (erreichtePunkte >= maxPunkte){
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