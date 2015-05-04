package javamathgame;
import java.io.*;
import java.util.Random;
/**
 * Version: 1.0
 * Autor: Nater Jeremias | Monegat Alessio | Würzer Daniel 
 */
public class Tools
{
    public static void clearterminal()
    {
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
    
    public static int random(int min, int max)
    {
        Random generator = new Random();
        int randomnumber = generator.nextInt((max - min) + 1) + min;
        return randomnumber;
    }
        
    public static void writeFile(String filename, String savestring)
    {
        try
        {
            FileWriter write = new FileWriter(System.getProperty("user.home") + "/Mathgame/" + filename); //Definieren des Writers
            write.write(savestring); //Schreiben der Werte
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