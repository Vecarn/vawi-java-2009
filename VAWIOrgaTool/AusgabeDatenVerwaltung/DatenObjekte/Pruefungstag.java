@nach Package Pruefungsplanung verschoben, ist das gut? Oder doch hier lassen?

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
    // Attribute f�r den Priefungstag, Datum zus�tzlich?
    private short tagId;
    private Kursliste tagesKursliste;

    /**
     * Konstruktor Pruefungstag
     */
    public Pruefungstag (short tagID, Kursliste tagesKursliste)
    {
        this.tagId = tagId; 
        this.tagesKursliste = tagesKursliste; 
    }
   /**
     * Setter und Getter-Methoden
     */    
    //Setter
    public void setTagesKursliste(Kursliste tagesKursliste)
     {
         this.tagesKursliste = tagesKursliste;
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
 }
