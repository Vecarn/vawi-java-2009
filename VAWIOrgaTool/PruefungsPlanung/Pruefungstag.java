
        
package PruefungsPlanung;
import EingabeDatenVerwaltung.DatenVerwaltung.*;
import PruefungsPlanung.PruefungsPlanerAlgo1.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Datentraegerklasse Pruefungstag 
 * mit einer Liste an Kursen fuer Tag, nach KursID aufsteigend in einem TreeSet sortiert.
 * und den passenden Getter/Setter-Methoden.
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
