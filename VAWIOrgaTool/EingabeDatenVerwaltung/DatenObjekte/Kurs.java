
package EingabeDatenVerwaltung.DatenObjekte;


/**
 * Datenträgerklasse Kurs 
 * Enthält die Kurs-Objekte
 * mit den Eigenschaften eines Kurses und den passenden Getter/Setter-Methoden
 * 
 * @author  Silvia Wölfle
 * @version 3.0 on 22.01.2010
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
     * (der titel, kurztitel und kursid bei der erstellung des Objekts verlangt und gleich setzt
     * 
     * @param kursid             ID des Kurses (int)
     * @param titel              Titel des Kurses (String)
     * @param kurztitel          Kurztitel des Kurses (String)
     */
    public Kurs(int kursid, String titel, String kurztitel)
    {
        this.kursid=kursid;
        this.titel=titel;
        this.kurztitel=kurztitel;
     }
   /**
     * Set-Methode hatTeilleistungen (ueberschreibt Attribut hatTeilleistungen)
     * @param hatTeilleistungen Teilleistungen eines Kurses vorhanden (boolean)
     * @param Überprüfung (true wenn true, false wenn false) macht keinen Sinn...
     */
    public void setHatTeilleistungen(boolean hatTeilleistungen)
     {
        this.hatTeilleistungen = hatTeilleistungen;
     }
   /**
     * Set-Methode setMaxPunkte (ueberschreibt Attribut setMaxPunkte)
     * @param maxPunkte maximale Punktzahl eines Kurses (int)
     * @param prüft und setzt Punktzahl wenn nicht kleiner 0
     */
    public void setMaxPunkte(int maxPunkte)
     {
         if (maxPunkte < 0){
            System.out.println("Weniger als 0 Punkte nicht möglich!");
            return;
            }   
               this.maxPunkte = maxPunkte;
     }   
        
    /**
     * Get-Methode: Gibt Kursid eines Kurses als int zurück
     * @return   Kursid des Kurses als int
     */
    public int getKursid()
      {
      return kursid;
      }
    /**
     * Get-Methode: Gibt Titel eines Kurses als String zurück
     * @return  Titel des Kurses als String
     */
     public String getTitel()
      {
      return titel;
      }
    /**
     * Get-Methode: Gibt Kurztitel eines Kurses als String zurück
     * @return  Kurztitel des Kurses als String
     */
    public String getKurztitel()
      {
      return kurztitel;
      }
    /**
     * Get-Methode: Gibt als boolean zurück, ob Kurs Teilleistungen enthaelt
     * @return  hatTeilleistungen als boolean
     */
    public boolean getHatTeilleistungen()
      {
      return hatTeilleistungen;
      }
   /**
     * Get-Methode: Gibt maximale Punktzahl eines Kurses als int zurück
     * @return  maximale Punktzahl als int
     */
    public int getMaxPunkte()
      {
      return maxPunkte;
      }   
     
}