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
        
    public static void writeFile(String savestring)
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
    public static boolean readFile(String checkstring)
    {
        try{
        FileReader fr = new FileReader("Accounts.txt");
        BufferedReader br = new BufferedReader(fr);
        String zeile = "";
        boolean test = true;
        do
        {
          zeile = br.readLine();
          System.out.println(zeile);
          if(checkstring == br.readLine())
          {
              test = false;
          }
        }
        while (zeile != null);

        br.close();
        if(this.test == false)
        {
            return false;
        }
        }
        
        catch(Exception e)
                {
                    System.out.println("Write not successfull");
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