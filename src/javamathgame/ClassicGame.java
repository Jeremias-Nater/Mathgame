package javamathgame;
/**
 * Version: 1.0
 * Autor: Nater Jeremias | Monegat Alessio | Würzer Daniel 
 */
public class ClassicGame extends Game // All general Game Methods are in Class Game
{
    public ClassicGame()
    {
        playNumber = 1;
        maxNumber = 1000;
        stepCount = 0;
        maxSteps = 50;
        difficulty = "normal";
        valid = false;   
    }
    
    public String validate()    // Function to See if Player has lost or Won
    {
        String valid = "default";
        if (playNumber == targetNumber)
        {
            valid = "won";
        }
        
        if (stepCount > maxSteps)
        {
            valid = "lost";
        }
        return valid;
    }
    
    public void startgame()     // Game Setup
    {
        playNumber = 1;
        stepCount = 0;
        Reader r = new Reader();
        valid = false;
        while (valid == false)
        {
            System.out.println("Wählen Sie den Schwierigkeitsgrad:");
            System.out.println("1: Easy");
            System.out.println("2: Normal");
            System.out.println("3: Hard");
            System.out.println("4: Impossible");
            input = r.readString();
            switch (input)
            {
                case "1":
                    difficulty = "easy";
                    Tools.clearterminal();
                    System.out.println("Sie haben Easy gewählt");
                    targetNumber = Tools.random(0, 300);
                    maxSteps = 20;
                    valid = true;
                    break;
                case "2":
                    difficulty = "normal";
                    Tools.clearterminal();
                    System.out.println("Sie haben Normal gewählt");
                    targetNumber = Tools.random(300, 1000);
                     maxSteps = 15;
                    valid = true;
                    break;
                case "3":
                    difficulty = "hard";
                    Tools.clearterminal();
                    System.out.println("Sie haben Hard gewählt");
                    targetNumber = Tools.random(1000, 3000);
                    maxSteps = 10;
                    valid = true;
                    break;
                case "4":
                    difficulty = "impossible";
                    Tools.clearterminal();
                    System.out.println("Sie haben Impossible gewählt");
                    targetNumber = Tools.random(3000, 10000);
                    maxSteps = 10;
                    valid = true;
                    break;
                default:
                    Tools.clearterminal();
                    System.out.println("Ungültige Eingabe:");
                    System.out.println(input);
                    Tools.sleep(2000);
                    Tools.clearterminal();
                    valid = false;
            }
        }
        statusoutput();
        Tools.sleep(2000);
        System.out.println("");
    }   
}