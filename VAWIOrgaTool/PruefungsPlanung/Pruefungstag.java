package PruefungsPlanung;
import EingabeDatenVerwaltung.DatenObjekte.*;
import PruefungsPlanung.PruefungsPlanerAlgo1.*;

/**
 * Datentraegerklasse Pruefungstag 
 * mit einer Liste an Kursen f&uuml;r Tag 
 * und den passenden Getter/Setter-Methoden.
 * 
 * @author  Silvia Wölfle
 * @version 1.0 on 07.12.2009
 */
public class Pruefungstag 
{
    // Attribute der Klasse Pruefungstag, mit Datum?
    private short tagId;
    private Kurs kursDaten;

    /**
     * Konstruktor Pruefungstag, verlangt Algorithmus Verteilung Kurse auf Tage
     * und Kurs-Attribute 
     */
    public Pruefungstag (short tagID, Kurs kursDaten)
    {
        this.tagId = tagId;   
        this.kursDaten = kursDaten;
    }
    
   /**
     * Getter-Methoden
     */    
    // Getter
    public short getTagId()
      {
      return tagId;
      }
    public Kurs getKurs()
      {
      return kursDaten;
      }
 }
