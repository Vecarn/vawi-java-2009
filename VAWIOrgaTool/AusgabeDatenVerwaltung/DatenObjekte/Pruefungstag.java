package AusgabeDatenVerwaltung.DatenObjekte;
import EingabeDatenVerwaltung.DatenVerwaltung.*;
import PruefungsPlanung.PruefungsPlanerAlgo1.*;


/**
 * Datentraegerklasse Pruefungstag mit den Eigenschaften Kursliste, Studentenliste und Tag
 * Studentenliste hier auch enthalten, damit diese für die Ausgabe nicht nochmal muehsam zusammengesetzt werden muss
 * Wird ueber Pruefunsplanung fuer Tage 1,2,... gefuellt
 * 
 * @author  Silvia Wölfle
 * @version 2.0 on 11.12.2009
 */
public class Pruefungstag 
{
    // Attribute für den Pruefungstag, ggf. Datum zusätzlich
    private int tagId;
    private Kursliste tagesKursliste;
    private Studentenliste tagesStudentenliste;  
     
    /**
     * Konstruktor Pruefungstag verlangt Tag für die Erstellung eines Anwesenheits-Objektes
     * 
     * @param tagId   ID des Tages (int)
     */
    public Pruefungstag (int tagId)
    {
        this.tagId = tagId;   
    }
   /**
     * Set-Methode tagesKursliste (ueberschreibt Attribut tagesKursliste)
     * @param tagesKursliste Kursliste für einen Pruefungstag (Kursliste)
     */  
    public void setTagesKursliste(Kursliste tagesKursliste)
     {
         this.tagesKursliste = tagesKursliste;
     }
   /**
     * Set-Methode tagesStudentenliste (ueberschreibt Attribut tagesStudentenliste)
     * @param tagesStudentenliste Studentenliste für einen Pruefungstag (Studentenliste)
     */  
    public void setTagesStudentenliste(Studentenliste tagesStudentenliste)
     {
         this.tagesStudentenliste = tagesStudentenliste;
     }

     /**
     * Get-Methode: Gibt ID eines Tages als int zurück
     * @return   tagId des Pruefungstages als int
     */
     public int getTagId()
      {
      return tagId;
      }
     /**
     * Get-Methode: Gibt Kursliste für einen Pruefungstag als Kursliste zurück
     * @return   tagesKursliste des Pruefungstages als Kursliste
     */
     public Kursliste getTagesKursliste()
      {
      return tagesKursliste;
      }   
     /**
     * Get-Methode: Gibt Studentenliste für einen Pruefungstag als Studentenliste zurück
     * @return   tagesStudentenliste des Pruefungstages als Studentenliste
     */
     public Studentenliste getTagesStudentenliste()
      {
      return tagesStudentenliste;
      }   
}
