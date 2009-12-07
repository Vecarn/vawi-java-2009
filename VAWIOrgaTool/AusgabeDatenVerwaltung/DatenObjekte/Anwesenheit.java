
package AusgabeDatenVerwaltung.DatenObjekte;
import EingabeDatenVerwaltung.DatenObjekte.*;
import AusgabeDatenVerwaltung.Ausgabe.*;
/**
 * Datenklasse Anwesenheit mit den Eigenschaften der Anwesenheit eines einzelnen Studenten 
 * pro Prüfungstag und Uni
 * und den passenden Getter/Setter-Methoden.
 * 
 * @author  Silvia Wölfle
 * @version 1.0 on 05.12.2009
 */

public class Anwesenheit 
{
    // Attribute für Klasse Anwesenheit, aus den Klassen Student und Kurs und dem Pruefungstag
    private Student studentDaten;
    private Pruefungstag tag;
    private Kurs kursDaten;
    private List<Buchung> liste1 = new ArrayList<Buchung>();
    
    /**
     * Konstruktor Anwesenheit, verlangt Studenten-Attribute sowie den Tag
     * für die Erstellung eines Anwesenheits-Objektes
     */
    public Anwesenheit(Student studentDaten, Pruefungstag tag)
    {
        this.studentDaten = studentDaten;
        this.tag = tag;   
        liste1.add(buchung1);
    }
    
   /**
     * Getter/Setter-Methoden
     */    
    // Setter
    public void setKursDaten(Kurs kursDaten)
     {
         this.kursDaten = kursDaten;
     }
    // Getter
    public Student getStudent()
      {
      return studentDaten;
      }
    public Kurs getKurs()
      {
      return kursDaten;
      }
    public Pruefungstag getTag()
      {
      return tag;
      }
    public Pruefungstag tag()
      {
      return tag;
      }

 }
