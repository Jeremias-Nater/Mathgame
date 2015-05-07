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
            fw.close();
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
                        br.close();
                        fr.close();
                        return foundLine;
                    }
                }
            }
            fr.close();
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
            File inputFile = new File("Accounts.txt");
            File tempFile = new File("Accounts_temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if(trimmedLine.contains(checkstring)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close(); 
            reader.close();
            
            boolean successful = false;
            if (inputFile.delete()) {
                successful = tempFile.renameTo(inputFile);
            } else {
                System.out.println("File could not be deleted!");
                Tools.sleep(3000);
            }
            
            return successful;
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