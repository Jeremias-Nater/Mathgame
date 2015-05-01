package javamathgame;
/**
 * Version: 1.0
 * Autor: Nater Jeremias | Monegat Alessio | Würzer Daniel 
 */
public class Player
{
    private String nickname;
    static boolean valid = false;
    private int exp;
    //private int cash;
    //private int highscore;
    
    // GETSET for use of Private variables
    public String getNickname() 
    {
        return this.nickname;
    }
    public int getExp() 
    {
        return this.exp;
    }
    public int getLevel() // Level is Calculated of Exp
    {
        int lvl = 1;
        int lvlUpExp = 100;
        int currentExp = this.exp;
        while (this.exp > lvlUpExp) {
            lvl++;
            currentExp = currentExp - lvlUpExp;
            lvlUpExp = (int) Math.round(lvlUpExp * 1.2);
        }
        return lvl;
    }
    // End of GETSET
    
    public void Auth() //Login Function, Creates Player, Reads / Writes Files
    {
        valid = false;
        String nickname = "";
        while (valid == false)
        {
            System.out.println("Melden Sie sich an:");
            System.out.println("1. Anmelden");
            System.out.println("2. Account Registieren");
            System.out.println("3. Benutzer auflisten");
            String selected = Reader.readString();
            Tools.clearterminal();
            switch (selected) {
                case "1":
                    System.out.println("Sie haben Anmelden gewählt.");
                    System.out.println("");
                    System.out.println("Wählen Sie einen Nicknamen:");
                    nickname = Reader.readString();
                    valid = true;
                    break;
                case "2":
                    System.out.println("Sie haben Account Registrieren gewählt.");
                    System.out.println("");
                    System.out.println("Geben Sie Ihren Nicknamen ein:");
                    nickname = Reader.readString();
                    valid = true;
                    break;
                case "3":
                    
                    break;
                default:
                    System.out.println("Ungültige Eingabe");
                    Tools.sleep(5000);
            }
        }
        this.nickname = nickname;
        Tools.clearterminal();
        System.out.println("Herzlich Willkommen " + this.nickname);
        System.out.println("");
        
    }
    
    static boolean saveGame()  // Not used Yet, will Write Files
    {
        boolean success = false;
        // Save Game here and set success Variable
        if (success) {
            System.out.println("Spiel erfolgreich gespeichert");
        } else {
            System.out.println("Spiel konnte nicht gespeichert werden, versuchen Sie es erneut");
        }
        return success;
    }
}