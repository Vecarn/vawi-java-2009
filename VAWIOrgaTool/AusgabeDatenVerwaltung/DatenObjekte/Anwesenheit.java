
package AusgabeDatenVerwaltung.DatenObjekte;
import EingabeDatenVerwaltung.DatenObjekte.*;
import Hilfsklassen.Universitaet.*;
import PruefungsPlanung.PruefungsPlanerAlgo1.*;
import PruefungsPlanung.Pruefungstag.*;

/**
 * Datentraegerklasse Anwesenheit mit den Eigenschaften Studentenliste und Tag und Uni
 * und den passenden Getter/Setter-Methoden.
 * 
 * @author  Silvia Wölfle
 * @version 1.0 on 07.12.2009
 */

public class Anwesenheit 
{
    // Attribute für Klasse Anwesenheit, Liste wird aus der Studentenliste verwendet
    // Statt Uni aus Klasse - Attribut von Student verwenden?
    private short tagId;
    private Universitaet uniTag;
    private Studentenliste tagesStudentenliste;

    /**
     * Konstruktor Anwesenheit, verlangt Tag und Uni
     * für die Erstellung eines Anwesenheits-Objektes
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

    // Getter  (bei Student: Attribut Uni)
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
 }
