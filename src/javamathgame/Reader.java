package javamathgame;
import java.io.*;
/**
 * Version: 1.0
 * Autor: Natter Jeremias | Monegat Alessio | Würzer Daniel 
 */
public class Reader
{
    public static int readInt()
    {
        String input;
        int output;
        try
        {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            input = r.readLine();
            output = Integer.parseInt(input);

            return output;
        }
        catch(Exception e)
        {
            System.out.println("Einlesefehler");
            throw new RuntimeException("Exc while trying ...", e);
        }
    }
    
    public static String readString()
    {
        try
        {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            String output = r.readLine();

            return output;
        }
        catch(Exception e)
        {
            System.out.println("Einlesefehler");
            throw new RuntimeException("Exc while trying ...", e);
        }
    }
    
    public static double readDouble()
    {
        try
        {
            String input;
            double output;

            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            input = r.readLine();
            output = Double.valueOf(input);

            return output;
        }
        catch(Exception e)
        {
            System.out.println("Einlesefehler");
            throw new RuntimeException("Exc while trying ...", e);
        }
    }
}