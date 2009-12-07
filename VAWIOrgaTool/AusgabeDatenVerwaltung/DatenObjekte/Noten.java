
package AusgabeDatenVerwaltung.DatenObjekte;
import EingabeDatenVerwaltung.DatenObjekte.*;

/**
 * Datenklasse Noten mit den Eigenschaften Student, Kurs und Buchung und den passenden Getter/Setter-Methoden,
 * für eine Liste über Studenten und deren Punkte pro Kurs
 * 
 * @author  Silvia Wölfle
 * @version 1.0 on 05.12.2009
 */
public class Noten 
{
 
    // Attribute für Klasse Noten, aus den Klassen Student und Kurs und Buchung
    private Kurs kursDaten;
    private Student studentDaten;
    private Buchung erreichtePunkte; 
    private short gesamtpunkte;

    /**
     * Konstruktor Note, verlangt Studenten-, Kurs- und Buchungs-Attribute 
     * für die Erstellung eines Notenobjektes
     */
    public Noten(Kurs kursDaten, Student studentDaten, Buchung erreichtePunkte)
    {
        this.kursDaten = kursDaten;
        this.studentDaten = studentDaten;
        this.erreichtePunkte = erreichtePunkte;               
    }
    
   /**
     * Getter/Setter-Methoden
     */    
    // Setter
    public void setGesamtpunkte(short gesamtpunkte)
     {
         this.gesamtpunkte = gesamtpunkte;
     }
    // Getter
    public Kurs getKurs()
      {
      return kursDaten;
      }
    public Student getStudent()
      {
      return studentDaten;
      }
    public Buchung getErreichtePunkte()
      {
      return erreichtePunkte;
      }
    public short getGesamtpunkte()
      {
      return gesamtpunkte;
      }
}