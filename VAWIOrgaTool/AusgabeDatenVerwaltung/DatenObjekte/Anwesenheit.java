@uni eher als Attribut aus Student holen...
@array o.�. f�r 1-3 Kurse pro Student fehlt noch... Versuche unten sind wohl nicht gut :-/
@oder geht Studentenliste plus (spezifische) Kursliste jeweils??

package AusgabeDatenVerwaltung.DatenObjekte;
import java.util.Arrays
import EingabeDatenVerwaltung.DatenObjekte.*;
import Hilfsklassen.Universitaet.*;
import PruefungsPlanung.PruefungsPlanerAlgo1.*;
import PruefungsPlanung.Pruefungstag.*;

/**
 * Datentraegerklasse Anwesenheit mit den Eigenschaften Studentenliste und Tag und Uni
 * und den passenden Getter/Setter-Methoden.
 * 
 * @author  Silvia W�lfle
 * @version 1.0 on 07.12.2009
 */

public class Anwesenheit 
{
    // Attribute f�r Klasse Anwesenheit, Liste wird aus der Studentenliste verwendet
    // Statt Uni aus Klasse - Attribut von Student verwenden?
    private short tagId;
    private Universitaet uniTag;
    private Kurs kurs;
    private Studentenliste tagesStudentenliste;
    // Array f�r Kurse pro Student?
    private Kurs kursStudent[];

    /**
     * Konstruktor Anwesenheit, verlangt Tag und Uni
     * f�r die Erstellung eines Anwesenheits-Objektes
     */
    public Anwesenheit (short tagID, Universitaet uniTag)
    {
        this.tagId = tagId; 
        this.uniTag = uniTag; 
    }
   /**
     * Methoden
     */ 
    
    // Setter
    public void setStudentenliste(Studentenliste tagesStudentenliste)
        {
            this.tagesStudentenliste = tagesStudentenliste;
        }
    public void setKurs (Kurs kurs)
        {
            this.kurs = kurs;
        }
     // Getter  
     public int tag()
      {
      return tag;
      }
     public Universitaet uniTag()
      {
      return uniTag;
      }
     public Studentenliste tagesStudentenliste()
      {
      return tagesStudentenliste;
      }
     public Kurs kurs()
      {
      return kurs;
      }
      // Array f�r mehrere Kurse, es sollen die Kurskurztitel aus Kurs verwendet werden
      // Erzeugung eines Arrays
      kursStudent = new Kurs [3];
      kursStudent[1] = Kurs kurztitel;
      kursStudent[2] = Kurs kurztitel;
      kursStudent[3] = Kurs kurztitel;  
      // oder kursStudent [1] = new Kurs (); ??
 }
