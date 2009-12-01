import java.io.*;

/**
 * Die Klasse Datei soll in einfacherer Weise Strings als Zeilen ausgeben,
 * bzw einlesen k�nnen.
 * 
 * @author  Patrick Veith 
 * @version 1.0 on 3.11.2001
 */
public class Datei
{
    // Attribute der Klasse Datei
    // Name der Datei
    // - Der Name der Datei darf Pfadinformationen enthalten, die aber 
    // nicht mit den Windows �blichen Backslash angegeben werden d�rfen,
    // sondern mit dem normalen Slash. (bsp. C:/temp/datei.txt)
    private String dName;
    // Objekt einer Java-Klasse zum Schreiben von Zeichenketten
    private PrintWriter dAus;
    // Objekt einer Java-Klasse zum Lesen von Zeichenketten
    private BufferedReader dEin;
    /**
    * Enth�lt nach dem Aufruf einer Methode einen Fehlercode.
    * 0 bedeutet, dass kein Fehler aufgetreten ist und �ber die 
    * Methode errorMessage kann man eine Beschreibung eines 
    * Fehlercodes erfragen.
    */
    public int errorCode;
    // Enth�lt, wenn eine Eingabedatei ihr Ende erreicht true,
    // ansonsten enth�lt eof immer false.
    // Um dies sicherzustellen kann nicht von ausserhalb auf
    // dieses Attribut zugegriffen werden, sondern ein Zugriff
    // muss �ber die Methode eof erfolgen.
    private boolean eof;

    /**
     * Konstruktor fuer Objekte der Klasse Datei
     * Legt einen String mit dem Namen der zu bearbeitenden Datei an.
     * @param in_name (String): Dateiname der benutzt werden soll.
     */
    public Datei(String in_name)
    {   
        dName = new String(in_name);
        errorCode =0;
        eof=false;
    }

    /**
     * �berpr�ft, ob das Ende einer Eingabedatei erreicht wurde.
     *
     * @returns gibt true nur zur�ck, wenn das Ende einer Eingabedatei 
     *          erreicht wurde. Ansosnsten wird immer false zur�ckgegeben.
     */
    public boolean eof()
    {   
        return eof;
    }

    /**
     * �ffnet eine Ausgabedatei namens dName.
     * 
     * @return (int) - Fehlernummer, oder 0 f�r OK!
     */
    public int openOutFile()
    {
        eof=false;
        try {
            dAus = new PrintWriter(new BufferedWriter(new FileWriter(dName)));
            errorCode =0;
            return 0;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            errorCode =1;
            return 1;
        }
    }

    /**
     * Schreibt einen String als Zeile in eine Datei.
     * 
     * @param  in_str - (String)Zeichenkette die in die Datei geschrieben 
     *                  werden soll.
     * @return (int) - Fehlernummer oder 0 f�r OK!
     */
    public int writeLine(String in_str)
    {
        eof=false;
        try {
            dAus.write(in_str+"\n");
            errorCode =0;
            return 0;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            errorCode =2;
            return 2;
        }
    }

    /**
     * Schliesst eine Ausgabedatei.
     * 
     * @return int - Fehlernummer oder 0 f�r OK
     */
    public int closeOutFile()
    {
        try {
            dAus.close();
            errorCode =0;
            return 0;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            errorCode =3;
            return 3;
        }
    }

    /**
     * �ffnet eine Eingabedatei namens dName.
     * 
     * @return (int) - Fehlernummer, oder 0 f�r OK!
     */
    public int openInFile()
    {
        try {
            dEin = new BufferedReader(new FileReader(dName));
            errorCode =0;
            eof = false;
            return 0;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            errorCode =4;
            return 4;
        }
    }

    /**
     * Liest eine Zeile aus einer Eingabedatei.
     * 
     * @return (int) - Fehlernummer, oder 0 f�r OK!
     */
    public String readLine()
    {
        String zw_in = new String("");
        try {
            zw_in = dEin.readLine();
            if (zw_in == null){
                eof=true;
                return zw_in;
            }
            else{
                errorCode =0;
                return zw_in;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            errorCode =5;
            return "";
        }
    }

    /**
     * Schliesst eine Eingabedatei.
     * 
     * @return int - Fehlernummer oder 0 f�r OK
     */
    public int closeInFile()
    {
        try {
            dEin.close();
            errorCode =0;
            eof = false;
            return 0;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            errorCode =6;
            return 6;
        }
    }

    /**
     * L�scht eine Datei.
     * 
     * @return int - Fehlernummer oder 0 f�r OK
     */
    public int deleteFile()
    {
        try {
            File f = new File(dName);
            errorCode =0;
            if (f.isFile()){
                f.delete();
                return 0;  
            }
            else{
                errorCode=98;
                return 98;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            errorCode =7;
            return 7;
        }
    }
    
    /**
     * Gibt den aktuellen Zustand des Dateiobjektes zur�ck. "true" bedeutet es sind
     * keine Fehler aufgetreten, "false" bedeutet es sind Fehler aufgetreten, die 
     * �ber den Fehlercode in errorCode genauer zu identifizieren sind. 
     * 
     * @return boolean - Zustand des Dateiobjektes.
     */
    public boolean state()
    {
        if (errorCode == 0)
            return true;
        else
            return false;
    }    

    /**
     * Gibt einen Fehlerbeschreibung als Text aus.
     * 
     * @param  in_error - (int)Fehlernummer, die bei einem Methodenaufruf zur�ck
     *                    gegeben wurde
     * @return String - Klartextbeschreibung des Fehlers!
     */
    public String errorMessage(int in_error)
    {
        // Auswertung des �bergebenen int-Wertes
        switch (in_error){
            case 0: return "Ok!";
            case 1: return "(E) �ffnen des Ausgabefiles gescheitert.";
            case 2: return "(E) Schreiben einer Zeile gescheitert.";
            case 3: return "(E) Schliessen des Ausgabefiles gescheitert.";
            case 4: return "(E) �ffnen des Eingabefiles gescheitert.";
            case 5: return "(E) Lesen einer Zeile gescheitert.";
            case 6: return "(E) Schliessen des Eingabefiles gescheitert.";
            case 7: return "(E) Konnte Datei nicht l�schen.";
            case 8: return "(E) Konnte keine Datei w�hlen.";
            case 98: return "(W) Es k�nnen nur Dateien gel�scht werden.";
            default: return "(E) Nicht bekannter Fehler!";
        }
    }
}
