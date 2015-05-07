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
    public void setExp(int setExp) 
    {
        this.exp = setExp;
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
    
    public void auth() //Login Function, Creates Player, Reads / Writes Files
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
                    System.out.println("");
                    if (this.loadGame(nickname)) {
                        System.out.println("Spiel erfolgreich geladen");
                        System.out.println("Nickname: " + this.nickname);
                        System.out.println("Level: " + this.getLevel());
                        System.out.println("EXP: " + this.exp);
                        Tools.sleep(3000);
                        valid = true;
                    } else {
                        System.out.println("Speicherstand nicht gefunden, bitte Registriere dich.");
                        Tools.sleep(3000);
                        
                    }
                    System.out.println("");
                    break;
                case "2":
                    System.out.println("Sie haben Account Registrieren gewählt.");
                    System.out.println("");
                    System.out.println("Geben Sie Ihren Nicknamen ein:");
                    nickname = Reader.readString();
                    System.out.println("");
                    if (this.registerAccount(nickname)) {
                        System.out.println("Account registriert");
                        valid = true;
                    } 
                    else
                    {
                        System.out.println("Acount Existiert bereits");
                    }
                    Tools.sleep(3000);
                    
                    
                    break;
                case "3":
                    
                    break;
                default:
                    System.out.println("Ungültige Eingabe");
                    Tools.sleep(3000);
            }
        }
        this.nickname = nickname;
        Tools.clearterminal();
        System.out.println("Herzlich Willkommen " + this.nickname);
        System.out.println("");
        
    }
    
    public boolean saveGame() // not working yet because it needs to replace existing Line
    {   
        boolean success;
        if (Tools.findLine(this.nickname) != "") {
            Tools.removeline(nickname);
            Tools.writeFile(this.nickname+";"+this.exp+";");
            success = true;
        } else {
            System.out.println("Der Benutzer existiert noch nicht.");
            this.registerAccount(nickname);
            System.out.println("der Benutzer " + nickname + " wurde Registriert.");
            success = false;
        }
        return success;
    }
    public boolean loadGame(String inputnickname) {
        boolean success = false;
        String loadGame;
        loadGame =Tools.findLine(inputnickname);
        if (loadGame != "") {
            String[] GameArray = loadGame.split(";");
            this.nickname = GameArray[0];
            this.exp = Integer.parseInt(GameArray[1]);
            success = true;
        }
        else
        {   
            System.out.println(loadGame);
            Reader.readString();
        }
        
        return success;
    }
    public boolean registerAccount(String inputnickname)  // Registers Account with 0 exp, lvl is calculated by getlvl
    {   
        boolean success;
        if (Tools.findLine(inputnickname) == "") {
            
            Tools.writeFile(inputnickname+";0");
            success = true;
        }
        else
        {
            success = false;
        }
        return success;
    }
}