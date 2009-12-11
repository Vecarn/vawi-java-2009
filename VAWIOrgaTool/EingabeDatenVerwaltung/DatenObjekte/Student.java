
package EingabeDatenVerwaltung.DatenObjekte;
import  EingabeDatenVerwaltung.DatenObjekte.*;

/**
 * Datenträgerklasse Student
 * Enthält Student-Objekte 
 * mit den Eigenschaften eines Studenten und den passenden Getter/Setter-Methoden
 * 
 * @author  Silvia Wölfle
 * @version 1.0 on 04.12.2009
 */
public class Student
{
    // Attribute der Klasse Student
    private int matrikelnr;
    private String name;
    private String vorname;
    // Kategorien einordnen lassen:
    // 'B' - Universität Bamberg
    // 'D' - Universität Duisburg-Essen
    private char uni;
    private String bundesland;
    // Studenten können angeben, ob sie möglichst viele Prüfungen an einem Tag machen möchten
    // true bedeutet, dass der Student Zeitminimierer ist
    // false bedeutet, dass der nicht Student Zeitminimierer ist, also Prüfungen besser verteilen will
    private boolean zeitminimierer;
    // Hier wird gesetzt, ob Student zufrieden, also ob zeitminimierung erfuellt
    // true bedeutet, dass Praeferenz Zeitminimierer erfuellt
    // false bedeutet, dass Praeferenz Zeitminimierer nicht erfuellt
    private boolean zufrieden;

    /**
     * Konstruktor für Objekte der Klasse Student mit Parameter 
     * (der name, vorname und matrikelnr bei der erstellung des Objekts verlangt und gleich setzt)
     * 
     * @param matrikelnr   ID des Studenten (int)
     */
    public Student(String name, String vorname, int matrikelnr)
    {
        this.matrikelnr=matrikelnr;
     }
   /**
     * Set-Methode vorname (ueberschreibt Attribut vorname)
     * @param vorname Vorname eines Studenten (String)
     */    
    public void setVorname(String vorname)
     {
         this.vorname = vorname;
     }
   /**
     * Set-Methode name (ueberschreibt Attribut name)
     * @param name Nachname eines Studenten (String)
     */    
    public void setName(String name)
     {
         this.name = name;
     }
   /**
     * Set-Methode uni (ueberschreibt Attribut uni)
     * @param uni Universitaet, an welcher ein Student eingeschrieben ist (char). Möglich sind die Buchstaben 'B' für Bamberg und 'D' für Duiesburg-Essen
     */    
    public void setUni(char uni)
     {
         this.uni = uni;
     }
   /**
     * Set-Methode bundesland (ueberschreibt Attribut bundesland)
     * @param bundesland Bundesland, in welchem der Student ansaessig ist, frei als Text (String)
     */    
    public void setBundesland(String bundesland)
     {
         this.bundesland = bundesland;
     }   
   /**
     * Set-Methode zeitminimierer (ueberschreibt Attribut zeitminimierer)
     * @param zeitminimierer Zeitminimierer (boolean). Wenn true, dann will Student möglichst alle Pruefungen an einem Tag schreiben
     */    
    public void setZeitminimierer(boolean zeitminimierer)
     {
         this.zeitminimierer = zeitminimierer;
     }        
   /**
     * Set-Methode zufrieden (ueberschreibt Attribut vorname)
     * @param zufrieden Zufrieden (boolean): Wahrheitswert fuer Check, ob Praeferenz (Zeitminimierer true false) erfuellt
     */    
    public void setZufrieden(boolean zufrieden)
     {
         this.zufrieden = zufrieden;
     }  
    /**
     * Get-Methode: Gibt Matrikelnummer eines Studenten als int zurück
     * @return   Matrikelnummer des Studenten als int
     */
     public int getMatrikelnr()
      {
      return matrikelnr;
      }
    /**
     * Get-Methode: Gibt Vorname eines Studenten als String zurück
     * @return  Vorname des Studenten als String
     */
     public String getVorname()
      {
      return vorname;
      }
    /**
     * Get-Methode: Gibt Nachname eines Studenten als String zurück
     * @return  Nachname des Studenten als String
     */
    public String getName()
      {
      return name;
      }
    /**
     * Get-Methode: Gibt Uni eines Studenten als char zurück
     * @return  Uni des Studenten als char
     */
    public char getUni()
      {
      return uni;
      }
    /**
     * Get-Methode: Gibt Bundesland eines Studenten als String zurück
     * @return  Bundesland des Studenten als String
     */
    public String getBundesland()
      {
      return bundesland;
      }   
    /**
     * Get-Methode: Gibt als boolean zurück, ob Student Zeitminimierer
     * @return  Zeitminimierer als boolean
     */
    public boolean getZeitminimierer()
    {
     return zeitminimierer;
     } 
    /**
     * Get-Methode: Gibt als boolean zurück, ob Student zufrieden, d.h. ob Praeferenz zeitminimierer erfuellt
     * @return  Zufrieden als boolean
     */
    public boolean getZufrieden()
    {
     return zufrieden;
     } 
}