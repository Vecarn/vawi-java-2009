package AusgabeDatenVerwaltung.DatenObjekte;
import EingabeDatenVerwaltung.DatenVerwaltung.*;
import PruefungsPlanung.PruefungsPlanerAlgo1.*;


/**
 * Datentraegerklasse Pruefungstag 
 * mit einer Kursliste f�r einen Tag.
 * 
 * @author  Silvia W�lfle
 * @version 1.0 on 07.12.2009
 */
public class Pruefungstag 
{
    // Attribute f�r den Pruefungstag, ggf. Datum zus�tzlich
    private short tagId;
    private Kursliste tagesKursliste;
    private Studentenliste tagesStudentenliste;  
     
    /**
     * Konstruktor Pruefungstag
     */
    public Pruefungstag (short tagID)
    {
        this.tagId = tagId;   
    }
   /**
     * Setter und Getter-Methoden
     * @param!!
     */    
    //Setter
    public void setTagesKursliste(Kursliste tagesKursliste)
     {
         this.tagesKursliste = tagesKursliste;
     }
    public void setTagesStudentenliste(Studentenliste tagesStudentenliste)
     {
         this.tagesStudentenliste = tagesStudentenliste;
     }
    //Getter
    public short getTagId()
      {
      return tagId;
      }
     public Kursliste getTagesKursliste()
      {
      return tagesKursliste;
      }   
     public Studentenliste getTagesStudentenliste()
      {
      return tagesStudentenliste;
      }   
}
