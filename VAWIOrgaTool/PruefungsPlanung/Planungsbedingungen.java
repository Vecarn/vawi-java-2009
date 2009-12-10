@Silvia: Hallo Silvia, kannst du bitte meine Konstanten weg und die PruefungenProTag und PruefungenProStudentUndTag als ganz normale int-Attribute mit getter und setter machen.
Danke! Dann kann ich die nämlich in meinem Programmablauf setzen.
Gruß Jörn

package PruefungsPlanung;



/**
 * Die Planungsbedingungen ist eine Datenklasse mit Attributen, die als Randbedingungen und Eigenschaften des Algorithmuses verwendet werden (z.B. Max Anzahl an Kurse pro Student und Tag). Die Planungsbedingungen werden dabei &uuml;ber eine Implementierung des Datenlesers eingelesen.
 * 
 * @poseidon-object-id [I2d0758e8m124d537380cmm78e9]
 */
public class Planungsbedingungen 
{
       
        /**
         * Maximale Anzahl an Pruefungen, die pro Tag geschrieben werden
         */
        public static final int PruefungProTag = 8;
        /**
        *  Maximale Anzahl an Pruefungen, die ein Student pro Tag schreiben darf
        */
        public static final int PruefungProStudentUndTag =3;
        
        /**
         * 
         * 
         * @poseidon-object-id [I2d0758e8m124d537380cmm7856]
         */
 }
