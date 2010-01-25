package PruefungsPlanung;

/**
 * Die Planungsbedingungen ist eine Datenklasse mit Attributen, 
 * (z.B. maximale Anzahl an Kurse pro Student und Tag). Die Planungsbedingungen werden ueber den Programmablauf gesetzt.
 * 
 * @author  Silvia W�lfle
 * @version 3.0 on 22.01.2010
 */
public class Planungsbedingungen 
{
       //Attribute f�r die Planungsbedingungen
       private int pruefungProTag;
       private int pruefungProStudentUndTag;
       /**
        * Konstruktor f�r Planungsbedingung
        * (der pruefungProTag bei der erstellung des Objekts verlangt und gleich setzt)
        * @param pruefungProTag   Maximale Anzahl der Kurse pro Tag (int), Pr�fung ob Zahl negativ
        */
       public Planungsbedingungen (int pruefungProTag)
       {
           if(pruefungProTag <=0){
            System.out.println("Weniger als 0 Pr�fungen am Tag sind nicht m�glich!");
            return;
            }   
              this.pruefungProTag = pruefungProTag;
        }

        /**
       * Set-Methode pruefungProStudentUndTag (ueberschreibt Attribut pruefungProStudentUndTag)
       * @param pruefungProStudentUndTag  Maximale Anzahl der Kurse pro Student und Tag (int), Pr�fung ob Zahl negativ
       */  
        public void setPruefungProStudentUndTag (int pruefungProStudentUndTag)
       {
            if(pruefungProStudentUndTag <=0){
            System.out.println("Student kann nicht weniger als 0 Pr�fungen am Tag haben!");
            return;
            }
           this.pruefungProStudentUndTag = pruefungProStudentUndTag;  
        }

        /**
         * Get-Methode: Gibt Pruefung pro Tag als int zur�ck
         * @return   Pruefung pro Tag als int
         */
        public int getPruefungProTag ()
            {
             return pruefungProTag;
            }
        /**
         * Get-Methode: Gibt Pruefung pro Student und Tag als int zur�ck
         * @return   Pruefung pro Student und Tag als int
         */
        public int getPruefungProStudentUndTag ()
            {
             return pruefungProStudentUndTag;
            }
 }
