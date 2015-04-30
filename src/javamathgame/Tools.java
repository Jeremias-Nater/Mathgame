package javamathgame;
import java.io.*;
import java.util.Random;
/**
 * Version: 1.0
 * Autor: Natter Jeremias | Monegat Alessio | Würzer Daniel 
 */
public class Tools
{
    public static void clearterminal()
    {
        int i = 0;
        while (i < 12)
        {
            i++;
            System.out.println("");
        }
    }
    
    public static int random(int min, int max)
    {
        Random generator = new Random();
        int randomnumber = generator.nextInt((max - min) + 1) + min;
        return randomnumber;
    }
        
    public static void writeFile(String eingabe)
    {
        try
        {
            FileWriter write = new FileWriter(System.getenv("APPDATA")); //Definieren des Writers
            write.write(eingabe); //Schreiben der Werte
            write.write(System.getProperty("line.separator")); //Zeilenumbruch nach schreiben der Werte
            write.close(); //Closes File
        }
        catch(Exception e)
        {
            System.out.println("Write to file unsuccessfull.");
            throw new RuntimeException("Exc while trying ...", e);
        }
    }
    
    public static void sleep (int duration)
    {
        try
        {
            Thread.sleep(duration);
        }
        catch(Exception e)
        {
            System.out.println("Sleep Interrupted!");
            throw new RuntimeException("Exc while trying ...", e);
        }
    }
}