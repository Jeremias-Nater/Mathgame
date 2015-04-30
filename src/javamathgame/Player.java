package javamathgame;
/**
 * Version: 1.0
 * Autor: Natter Jeremias | Monegat Alessio | Würzer Daniel 
 */
public class Player
{
    private String nickname;
    //private int exp;
    //private int lvl;
    //private int cash;
    //private int highscore;
    
    public Player(String setNickname)
    {
         nickname = setNickname;
    }
    static boolean valid = false;
    
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
            switch (selected) {
                case "1":
                    System.out.println("Wählen Sie einen Nicknamen:");
                    nickname = Reader.readString();
                    valid = true;
                    break;
                case "2":
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
        return pl;
    }
}