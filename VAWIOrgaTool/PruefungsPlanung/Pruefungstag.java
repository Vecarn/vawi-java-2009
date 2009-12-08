
        
package PruefungsPlanung;
import EingabeDatenVerwaltung.DatenObjekte.*;
import PruefungsPlanung.PruefungsPlanerAlgo1.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Datentraegerklasse Pruefungstag 
 * mit einer Liste an Kursen fuer Tag, nach KursID aufsteigend in einem TreeSet sortiert.
 * und den passenden Getter/Setter-Methoden.
 * 
 * @author  Silvia W�lfle
 * @version 1.0 on 07.12.2009
 */
public class Pruefungstag 
{
    // Attribute f�r den Priefungstag, Datum zus�tzlich?
    private short tagId;
    private Collection<Kurs> kurse = new TreeSet<Kurs>(new KursComparator());

    /**
     * Konstruktor Pruefungstag
     */
    public Pruefungstag (short tagID, Collection<Kurs> kurse)
    {
        this.tagId = tagId; 
        this.kurse = kurse; 
    }
   /**
     * Get-Methoden
     */    
    public short getTagId()
      {
      return tagId;
      }
     public short getKurse()
      {
      return kurse;
      }   
    /**
     * Methode, die ein neues Kurs-Objekt erstellt und dieses einem TreeSet hinzuf�gt.<br>
     * Der R�ckgabe-Wert liefert die Information ob das Objekt hinzugef�gt wurde.
     * 
     * @param id (int) - Die KursId des Kurses 
     * @param kurztitel (String) - Kurztitel des Kurses
     * @param titel (String) - Lange Bezeichung(Titel) des Kurses.
     * @return  true: wenn Collection ge�ndert wurde <br>
     *          false: wenn Collection nicht ge�ndert wurde (z.B. wenn Objekt bereits in Collection)
     */
    public boolean addNeuerKurs(int id, String kurztitel, String titel)
    {
        //new Kurs(hier alle Variablen)
        Kurs kurs = new Kurs(id, kurztitel, titel);
        
        if(kurse.add(kurs))
        {
            kurs.setKurztitel(kurztitel);
            kurs.setTitel(titel);
            return true;
        }   
        return false;       
    }
    
    /**
     * Methode, um ein bereits bestehendes Kurs-Objekt der Kursliste hinzuzuf�gen.<br>
     * 
     * @param kurs (Kurs) - Ein konkretes Kurs-Objekt.
     * @return  true: wenn Collection ge�ndert wurde <br>
     *          false: wenn Collection nicht ge�ndert wurde (z.B. wenn Objekt bereits in Collection)
     */
    public boolean addKurs(Kurs kurs)
    {
        if(kurse.add(kurs))
        {
            return true;
        }
        return false;
    } 
    
    /**
     * Kurse werden �ber eine ID eindeutig identifiziert.<br> 
     * Die Methode gibt einen Kurs anhand einer KursID zur�ck. 
     * 
     * @param kursId (int) - Eindeutige KursID eines Kurses.
     * @return Kurs: Kurs-Objekt
     */
    public Kurs getKurs(int kursId)
    {       
        Iterator<Kurs> kursiterator = kurse.iterator();
        
        while(kursiterator.hasNext())
        {
            Kurs kurs = kursiterator.next();
            if(kurs.getKursid() == kursId)
            {
                return kurs;
            }
        }
        return null;
    }
    
    /**
     * Liefert Iterator auf vorhandene Kurs-Collection.<br>
     * Kurse liegen nach der ID aufsteigend sortiert vor.
     * 
     * @return Iterator: Typisierter Iterator auf Collection mit Kurs-Objekten.
     */
     public Iterator<Kurs> getKursIterator()
     {
        return kurse.iterator();    
     }
    
    /**
     * Liefert die Anzahl der vorhandenen Kurs-Objekte zur�ck.
     *
     * @return int: Anzahl Kurse in der Kursliste.
     */
    public int getSize()
    {
        return kurse.size();
    }
 }
