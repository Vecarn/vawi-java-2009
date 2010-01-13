package EingabeDatenVerwaltung.DatenObjekte;


/**
 * Datentr�gerklasse Student
 * Enth�lt Student-Objekte 
 * mit den Eigenschaften eines Studenten und den passenden Getter/Setter-Methoden
 * 
 * @author  Silvia W�lfle
 * @version 2.0 on 08.01.2010
 */
public class Student
{
    // Attribute der Klasse Student
    private int matrikelnr;
    private String name;
    private String vorname;
    // Kategorien einordnen lassen:
    // 'B' - Universit�t Bamberg
    // 'D' - Universit�t Duisburg-Essen
    private char uni;
    private String bundesland;
    // Studenten k�nnen angeben, ob sie m�glichst viele Pr�fungen an einem Tag machen m�chten
    // true bedeutet, dass der Student Zeitminimierer ist
    // false bedeutet, dass der nicht Student Zeitminimierer ist, also Pr�fungen besser verteilen will
    private boolean zeitminimierer;
    // Hier wird gesetzt, ob Student zufrieden, also ob zeitminimierung erfuellt
    // true bedeutet, dass Praeferenz Zeitminimierer erfuellt
    // false bedeutet, dass Praeferenz Zeitminimierer nicht erfuellt
    private boolean zufrieden;

    /**
     * Konstruktor f�r Objekte der Klasse Student mit Parameter 
     * (der name, vorname und matrikelnr bei der erstellung des Objekts verlangt und gleich setzt)
     * 
     * @param matrikelnr   ID des Studenten (int)
     */
    public Student(String vorname, String name, int matrikelnr)
    {
        this.vorname=vorname;
        this.name=name;
        this.matrikelnr=matrikelnr;
     }

   /**
     * Set-Methode uni (ueberschreibt Attribut uni)
     * @param uni Universitaet, an welcher ein Student eingeschrieben ist (char). 
     * M�glich sind die Buchstaben 'B' f�r Bamberg und 'D' f�r Duisburg-Essen
     */    
    public void setUni(char uni)
     {
         switch(uni) 
         {
             case 'B':
                this.uni = uni;
                break;
             case 'D':
                this.uni = uni;
                break;
             default:
             System.out.println("Fehler! Nur B oder U m�glich"); 
         }
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
     * @param zeitminimierer Zeitminimierer (boolean). Wenn true, dann will Student m�glichst alle Pruefungen an einem Tag schreiben
     */    
    public void setZeitminimierer(boolean zeitminimierer)
     {
         if (zeitminimierer) 
         {
         this.zeitminimierer = zeitminimierer;
          } else {
            zeitminimierer = false;
           }
     }        
   /**
     * Set-Methode zufrieden (ueberschreibt Attribut vorname)
     * @param zufrieden Zufrieden (boolean): Wahrheitswert fuer Check, ob Praeferenz (Zeitminimierer true false) erfuellt
     */    
    public void setZufrieden(boolean zufrieden)
     {
         if (zufrieden == true) 
         {
         this.zufrieden = zufrieden;
          } else {
            zufrieden = false;
          }
     }  
     
    /**
     * Get-Methode: Gibt Matrikelnummer eines Studenten als int zur�ck
     * @return   Matrikelnummer des Studenten als int
     */
     public int getMatrikelnr()
      {
      return matrikelnr;
      }
    /**
     * Get-Methode: Gibt Vorname eines Studenten als String zur�ck
     * @return  Vorname des Studenten als String
     */
     public String getVorname()
      {
      return vorname;
      }
    /**
     * Get-Methode: Gibt Nachname eines Studenten als String zur�ck
     * @return  Nachname des Studenten als String
     */
    public String getName()
      {
      return name;
      }
    /**
     * Get-Methode: Gibt Uni eines Studenten als char zur�ck
     * @return  Uni des Studenten als char
     */
    public char getUni()
      {
      return uni;
      }
    /**
     * Erzeugt einen String, der die ausgeschriebe Uni des Studierenden enth�lt.
     * @return gibt einen String, der die ausgeschriebene Uni enth�lt, zur�ck.
     */
    public String formToString()
    {
        switch (uni){
        case 'B': return("Universit�t Bamberg");
        case 'D': return("Universit�t Duisburg-Essen");
        default:
            System.out.println("Die Uni eines Studentenobjektes ist inkonsistent!");
            return("Inkonsistent");
        }
    }
      
      
      
     /**
     * Get-Methode: Gibt Bundesland eines Studenten als String zur�ck
     * @return  Bundesland des Studenten als String
     */
    public String getBundesland()
      {
      return bundesland;
      }   
    /**
     * Get-Methode: Gibt als boolean zur�ck, ob Student Zeitminimierer
     * @return  Zeitminimierer als boolean
     */
    public boolean getZeitminimierer()
    {
     return zeitminimierer;
     } 
    /**
     * Get-Methode: Gibt als boolean zur�ck, ob Student zufrieden, d.h. ob Praeferenz zeitminimierer erfuellt
     * @return  Zufrieden als boolean
     */
    public boolean getZufrieden()
    {
     return zufrieden;
     } 
}