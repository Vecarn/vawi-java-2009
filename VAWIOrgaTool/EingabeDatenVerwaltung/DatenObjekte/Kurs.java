
package EingabeDatenVerwaltung.DatenObjekte;
import  EingabeDatenVerwaltung.DatenObjekte.*;

/**
 * Datenträgerklasse Kurs 
 * enthält die Kurs-Objekte
 * mit den Eigenschaften eines Kurses und den passenden Getter/Setter-Methoden
 * 
 * @author  Silvia Wölfle
 * @version 1.0 on 04.12.2009
 */
public class Kurs
{
    // Attribute der Klasse Kurs
    private int kursid;
    private String titel;
    private String kurztitel;
    // Kurse können Teilleistungen beinhalten
    // true bedeutet, dass der Kurs Teilleistungen vorsieht
    // false bedeutet, dass der Kurs keine Teilleistungen vorsieht
    private boolean hatTeilleistungen;
    // in maxPunkte werden maximal erreichbare Punkte in Teilleistungen abgebildet
    // bedingt, dass hatTeilleistungen true ist
    private int maxPunkte;

    /**
     * Konstruktor für Objekte der Klasse Kurs mit Parameter 
     * (der titel und kursid bei der erstellung des Objekts verlangt und gleich setzt
     * 
     * @param kursid             ID des Kurses (int)
     * @param titel              Titel des Kurses (String)
     */
    public Kurs(int kursid, String titel)
    {
        this.kursid=kursid;
        this.titel=titel;
     }
   /**
     * Getter/Setter-Methoden
     */    
    // Setter
    public void setTitel(String titel)
     {
         this.titel = titel;
     }
    public void setKurztitel(String kurztitel)
     {
         this.kurztitel = kurztitel;
     }
    public void setHatTeilleistungen(boolean hatTeilleistungen)
     {
         this.hatTeilleistungen = hatTeilleistungen;
     }
    public void setMaxPunkte(int maxPunkte)
     {
         this.maxPunkte = maxPunkte;
     }   
        
    // Getter 
    public int getKursid()
      {
      return kursid;
      }
    public String getTitel()
      {
      return titel;
      }
     public String getKurztitel()
      {
      return kurztitel;
      }
    public boolean getHatTeilleistungen()
      {
      return hatTeilleistungen;
      }
    public int getMaxPunkte()
      {
      return maxPunkte;
      }   
     
}