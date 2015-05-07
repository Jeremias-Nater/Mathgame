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
        
    public static void writeFile(String savestring) //Writes String to file
    {
        try {
            String content = savestring;

            File file = new File("Accounts.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                    file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); //True -> Dont overwrite
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.newLine();
            bw.close();
            System.out.println("Spiel gespeichert, fahre fort...");
            
            Tools.sleep(3000);
        }
        catch(Exception e)
        {
            System.out.println("Write not successfull");
            throw new RuntimeException("Exc while trying ...", e);
        }
    }
    public static String findLine(String checkstring)// If String is found, Return Line, else Return=""
    {
        try {
            File file = new File("Accounts.txt");
            if (!file.exists()) {
                    file.createNewFile();
            }
            FileReader fr = new FileReader("Accounts.txt");
            BufferedReader br = new BufferedReader(fr);
            String zeile = "";
            String foundLine = "";
            
            while (zeile != null)
            {
                zeile = br.readLine();
                if (zeile != null) {
                    if(zeile.contains(checkstring))
                    {
                        foundLine = zeile;
                        return foundLine;
                    }
                }
            }
            br.close();
            return foundLine;
        }
        catch(Exception e)
        {
            System.out.println("Findline not successfull");
            throw new RuntimeException("Exc while trying ...", e);
        }
    }
    
    public static boolean removeline(String checkstring){
    try 
    {
        int toRemove;
        boolean success = false;
        File file = new File("Accounts.txt");
        if (!file.exists()) {
                file.createNewFile();
        }
        
        String zeile = "";
        int foundLine = 0;
        int i = 0;
        
        BufferedReader br = new BufferedReader(new FileReader("Accounts.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("Accounts.txt"));
        
        while (zeile != null)
        {
            zeile = br.readLine();
            if (zeile != null) 
            {
                i++;
                if(zeile.contains(checkstring)) {
                    foundLine = i;
                    success = true;
                    System.out.println(foundLine);
                    Reader.readString();
                    return success;
                }
            }
        }
        
        if (foundLine != 0) {
            for (i = 0; i < foundLine; i++) {
                bw.write(String.format("%s%n", br.readLine()));
            }
        }
        
        br.readLine();

        String l;
        while (null != (l = br.readLine())) {
            bw.write(String.format("%s%n", l));
        }
        
        br.close();
        bw.close();
        
        return success;
    }
    catch(Exception e) {
        System.out.println("Sleep Interrupted!");
        throw new RuntimeException("Exc while trying ...", e);
    }
}
    
    public static void sleep (int duration) {
        try {
            Thread.sleep(duration);
        }
        catch(Exception e) {
            System.out.println("Sleep Interrupted!");
            throw new RuntimeException("Exc while trying ...", e);
        }
    }
}