
package AusgabeDatenVerwaltung.DatenObjekte;
import EingabeDatenVerwaltung.DatenObjekte.*;
import AusgabeDatenVerwaltung.DatenObjekte.*;

/**
 * Datenklasse Platzkarte mit den Eigenschaften einer Platzkarte pro Studenten 
 * pro Prüfungstag und Uni
 * und den passenden Getter/Setter-Methoden.
 * 
 * @author  Silvia Wölfle
 * @version 1.0 on 05.12.2009
 */
public class Platzkarte 
{
    // Attribute für Klasse Platzkarte, aus den Klassen Student und Kurs und Pruefungstag
    private Student studentDaten;
    private Pruefungstag tag;
    private Kurs kursDaten;

    /**
     * Konstruktor Platzkarte, verlangt Studenten-Attribute sowie den Tag
     * für die Erstellung eines Anwesenheits-Objektes
     * Unterscheidet sich von Klasse Anwesenheitsliste nur dadurch, dass Kurs-Attribute im Konstruktor
     */
    public Platzkarte(Student studentDaten, Pruefungstag tag, Kurs kursDaten)
    {
        this.studentDaten = studentDaten;
        this.tag = tag;   
        this.kursDaten = kursDaten;
    }
    
   /**
     * Getter/Setter-Methoden: hier nur Getter, da alles schon in Konstruktor
     */    
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