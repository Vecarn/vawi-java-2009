@Joern: Also wenn Du die im Programmauflauf setzt, muss ich die Werte noch gar nicht festlegen?
Gruss Silvia

package PruefungsPlanung;
import PruefungsPlanung.PruefungsPlanerAlgo1.*;


/**
 * Die Planungsbedingungen ist eine Datenklasse mit Attributen, 
 * die als Randbedingungen und Eigenschaften des Algorithmuses verwendet werden 
 * (z.B. Max Anzahl an Kurse pro Student und Tag). Die Planungsbedingungen werden ueber 
 * den Programmablauf gesetzt.
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm78e9]
 */
public class Planungsbedingungen 
{
       //Attribute für die Planungsbedingungen
       private int pruefungProTag;
       private int pruefungProStudentUndTag;
       /**
        * Konstruktor für Planungsbedingung
        */
       public Planungsbedingungen (int pruefungProStudentUndTag)
       {
           this.pruefungProStudentUndTag = pruefungProStudentUndTag;
        }
       /**
        * Setter und Getter-Methoden
        * @param!!
        */    
       //Setter
       public void setPruefungProStudentUndTag (int pruefungProStudentUndTag)
       {
           this.pruefungProStudentUndTag = pruefungProStudentUndTag;
        }
        public void pruefungProTag (int pruefungProTag)
        {
            this.pruefungProTag = pruefungProTag;
        }
        //Getter
        public int getPruefungProTag ()
            {
             return pruefungProTag;
            }
        public int getPruefungProStudentUndTag ()
            {
             return pruefungProStudentUndTag;
            }
 }

