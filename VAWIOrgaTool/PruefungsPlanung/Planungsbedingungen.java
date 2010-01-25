package PruefungsPlanung;

/**
 * Die Planungsbedingungen ist eine Datenklasse mit Attributen, 
 * (z.B. maximale Anzahl an Kurse pro Student und Tag). Die Planungsbedingungen werden ueber den Programmablauf gesetzt.
 * 
 * @author  Silvia Wölfle
 * @version 3.0 on 22.01.2010
 */
public class Planungsbedingungen 
{
       //Attribute für die Planungsbedingungen
       private int pruefungProTag;
       private int pruefungProStudentUndTag;
       /**
        * Konstruktor für Planungsbedingung
        * (der pruefungProTag bei der erstellung des Objekts verlangt und gleich setzt)
        * @param pruefungProTag   Maximale Anzahl der Kurse pro Tag (int), Prüfung ob Zahl negativ
        */
       public Planungsbedingungen (int pruefungProTag)
       {
           if(pruefungProTag <=0){
            System.out.println("Weniger als 0 Prüfungen am Tag sind nicht möglich!");
            return;
            }   
              this.pruefungProTag = pruefungProTag;
        }

        /**
       * Set-Methode pruefungProStudentUndTag (ueberschreibt Attribut pruefungProStudentUndTag)
       * @param pruefungProStudentUndTag  Maximale Anzahl der Kurse pro Student und Tag (int), Prüfung ob Zahl negativ
       */  
        public void setPruefungProStudentUndTag (int pruefungProStudentUndTag)
       {
            if(pruefungProStudentUndTag <=0){
            System.out.println("Student kann nicht weniger als 0 Prüfungen am Tag haben!");
            return;
            }
           this.pruefungProStudentUndTag = pruefungProStudentUndTag;  
        }

        /**
         * Get-Methode: Gibt Pruefung pro Tag als int zurück
         * @return   Pruefung pro Tag als int
         */
        public int getPruefungProTag ()
            {
             return pruefungProTag;
            }
        /**
         * Get-Methode: Gibt Pruefung pro Student und Tag als int zurück
         * @return   Pruefung pro Student und Tag als int
         */
        public int getPruefungProStudentUndTag ()
            {
             return pruefungProStudentUndTag;
            }
 }
