package javamathgame;
/**
 * Version: 1.0
 * Autor: Nater Jeremias | Monegat Alessio | Würzer Daniel 
 */
public class JavaMathGame
{
    public static void main(String[] args)
    {        
        boolean quit = false;
        boolean win = false;
        boolean lost = false;
        Player player1 = new Player();
        player1.Auth(); // Login of Player
        while (!quit)
        {
            win = false;
            lost = false;
            
            System.out.println("Was wollen Sie tun?:");
            System.out.println("1.) Klassischen Spielmodus Sielen");
            System.out.println("2.) Survival Spielmodus Sielen");
            System.out.println("3.) Timerace Spielmodus Sielen");
            System.out.println("");
            System.out.println("8.) Profil ansehen");
            System.out.println("9.) Spiel verlassen");
            String selected = Reader.readString();
            switch (selected)
            {
                case "1":
                    Tools.clearterminal();
                    System.out.println("Sie haben den Spielmodus Classic gewählt.");
                    ClassicGame game1 = new ClassicGame();
                    game1.startgame();
                    while (win == false && lost == false) {
                        game1.mathstep();
                        if (game1.validate() == "won") {
                            win = true;
                            System.out.println("Sie haben gewonnen!!");
                            Tools.clearterminal();
                        }
                        if (game1.validate() == "lost") {
                            System.out.println("You lose? :-(");
                        }
                    }
                    break;
                case "2":
                    Tools.clearterminal();
                    System.out.println("Sie haben den Spielmodus Survival gewählt.");
                    SurvivalGame survival = new SurvivalGame();
                    survival.startgame();
                    while (lost == false) {
                        survival.mathstep();
                        if (survival.validate() == "lost") {
                            System.out.println("You lose? :-(");
                        }
                    }
                    break;
                case "8":
                    Tools.clearterminal();
                    System.out.println("Ihr Profil:");
                    System.out.println("");
                    System.out.println("Nickname:" + player1.getNickname());
                    System.out.println("Level: " + player1.getLevel());
                    System.out.println("");
                    System.out.println("Eingabe um fortzufahren");
                    Reader.readString();
                    Tools.clearterminal();
                    break;
                case "9":
                    System.out.println("Spiel geschlossen");
                    quit = true;
                    break;
                default:
                    System.out.println("Ungültige Eingabe:");
                    System.out.println(selected);
            }
        }                                 
    }
}