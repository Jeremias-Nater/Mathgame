package javamathgame;
/**
 * Version: 1.0
 * Autor: Nater Jeremias | Monegat Alessio | Würzer Daniel 
 */
public class SurvivalGame extends Game // All general Game Methods are in Class Game
{
    int maxTargetNumber;
    
    public SurvivalGame()
    {
        playNumber = 1;
        maxNumber = 1000;
        stepCount = 0;
        maxSteps = 10;
        difficulty = "normal";
        valid = false;
        maxTargetNumber = 300;
    }
    // GETSET for use of Private variables
    public int getMaxNumber()
    {
        return this.maxTargetNumber;
    }
    // End of GETSET
    
    public void startgame()
    {
        playNumber = 1;
        stepCount = 0;
        maxSteps = 10;
        Reader r = new Reader();
        valid = false;
        targetNumber = Tools.random((maxTargetNumber / 2), maxTargetNumber);
        statusoutput();
        Tools.sleep(2000);
        System.out.println("");
    }
    
    public String validate()    // Function to See if Player has lost or Won
    {
        String valid = "default";
        if (playNumber == targetNumber)
        {
           maxSteps = maxSteps + 5;
           maxTargetNumber = maxTargetNumber * 2;
           targetNumber = Tools.random(0, maxTargetNumber);
           Tools.clearterminal();
           System.out.println("Sie haben die Ziel-Zahl erreicht.");
           System.out.println("Sie haben 5 Schritte erhalten um die nächste Ziel-Zahl zu erreichen.");
           System.out.println("Die schwierigkeit wurde erhöht. Maximal generierte Zahl: " + maxTargetNumber);
           System.out.println("");
           Tools.sleep(1500);
           statusoutput();
           Tools.sleep(2000);
        }
        
        if (stepCount > maxSteps)
        {
            valid = "lost";
        }
        return valid;
    }
}