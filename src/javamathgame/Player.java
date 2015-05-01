package javamathgame;
/**
 * Version: 1.0
 * Autor: Nater Jeremias | Monegat Alessio | Würzer Daniel 
 */
public class Player
{
    private String nickname;
    static boolean valid = false;
    //private int exp;
    //private int lvl;
    //private int cash;
    //private int highscore;
    
    public Player(String setNickname)
    {
         nickname = setNickname;
    }
    
    static Object Auth()
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
        
        Player pl = new Player(nickname);
        Tools.clearterminal();
        System.out.println("Herzlich Willkommen " + pl.nickname);
        System.out.println("");
        return pl;
    }
}