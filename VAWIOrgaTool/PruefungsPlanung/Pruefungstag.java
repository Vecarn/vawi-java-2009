
        
package PruefungsPlanung;
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
    private Kursliste tagesKursliste;

    /**
     * Konstruktor Pruefungstag, Kursliste besser in Konstruktor oder besser als Setter?
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
