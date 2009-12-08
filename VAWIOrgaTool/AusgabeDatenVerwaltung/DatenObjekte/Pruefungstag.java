@nach Package Pruefungsplanung verschoben, ist das gut? Oder doch hier lassen?

package AusgabeDatenVerwaltung.DatenObjekte;
import EingabeDatenVerwaltung.DatenVerwaltung.*;
import PruefungsPlanung.PruefungsPlanerAlgo1.*;


/**
 * Datentraegerklasse Pruefungstag 
 * mit einer Kursliste für einen Tag.
 * 
 * @author  Silvia Wölfle
 * @version 1.0 on 07.12.2009
 */
public class Pruefungstag 
{
    // Attribute für den Priefungstag, Datum zusätzlich?
    private short tagId;
    public Kursliste tagesKursliste;

    /**
     * Konstruktor Pruefungstag
     */
    public Pruefungstag (short tagID, Kursliste tagesKursliste)
    {
        this.tagId = tagId; 
        this.tagesKursliste = tagesKursliste; 
    }
   /**
     * Get-Methoden
     */    
    public short getTagId()
      {
      return tagId;
      }
     public Kursliste getTagesKursliste()
      {
      return tagesKursliste;
      }   
 }
