
package AusgabeDatenVerwaltung.DatenObjekte;
import EingabeDatenVerwaltung.DatenObjekte.*;
import AusgabeDatenVerwaltung.Ausgabe.*;
/**
 * Datenklasse Anwesenheit mit den Eigenschaften der Anwesenheit eines einzelnen Studenten 
 * pro Pr�fungstag und Uni
 * und den passenden Getter/Setter-Methoden.
 * 
 * @author  Silvia W�lfle
 * @version 1.0 on 05.12.2009
 */

public class Anwesenheit 
{
    // Attribute f�r Klasse Anwesenheit, aus den Klassen Student und Kurs und dem Pruefungstag
    private Buchung buchung;
    private Student student;
    private int tag;
    private List<Buchung> liste1 = new ArrayList<Buchung>();
    private Vector buchungen;
    
    /**
     * Konstruktor Anwesenheit, verlangt Buchungs-Attribute sowie den Tag
     * f�r die Erstellung eines Anwesenheits-Objektes
     */
    public Anwesenheit(Buchung buchung, int tag)
    {
        this.buchung = buchung;
        this.tag = tag;   
    }

   /**
     * Methoden
     */ 
    
    // 1-3 Buchungen pro Student
    liste1.add(buchung1);
    public void addBuchung(Buchung buchungen)
    {
      buchungen.add(buchungen);
    }

    // Getter  (bei Student: Attribut Uni)
    public Buchung getBuchung()
      {
      return buchung;
      }
     public int tag()
      {
      return tag;
      }
     public Student student()
      {
      return student;
      }
      public getBuchungenAnzahl()
 }
