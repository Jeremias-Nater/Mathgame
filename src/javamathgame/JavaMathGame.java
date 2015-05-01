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
                        if (game1.validate() == "won") {    //Won Classicgame
                            win = true;
                            System.out.println("Sie haben gewonnen!!");
                            
                            // Calculate Gained EXP
                            int gainedExp = 10;
                            int difficultyMultiplyer = 1;
                            switch (game1.difficulty) {
                                case "easy":
                                    difficultyMultiplyer = 1;
                                    break;
                                case "normal":
                                    difficultyMultiplyer = 2;
                                    break;
                                case "hard":
                                    difficultyMultiplyer = 4;
                                    break;
                                case "impossible":
                                    difficultyMultiplyer = 8;
                                    break;
                                default:
                                    System.out.println("Invalid Difficuly!");
                            }
                            gainedExp = 20 * difficultyMultiplyer;
                            System.out.println("Sie haben " + gainedExp + "EXP Erhalten");
                            player1.setExp(player1.getExp() + gainedExp);
                            System.out.println("Aktuelles LVL: " + player1.getLevel());
                            Tools.sleep(4000);
                            // End of EXP Calc
                            
                            //Save Game
                            player1.saveGame();
                            
                            Tools.clearterminal();
                            win = true;
                        }
                        if (game1.validate() == "lost") { // Lost of ClassicGame
                            System.out.println("You lose? :-(");
                            lost = true;
                            Tools.clearterminal();
                        }
                    }
                    break;
                case "2":
                    Tools.clearterminal();
                    System.out.println("Sie haben den Spielmodus Survival gewählt.");
                    SurvivalGame survivalGame1 = new SurvivalGame();
                    survivalGame1.startgame();
                    while (lost == false) {
                        survivalGame1.mathstep();
                        if (survivalGame1.validate() == "lost") {   // End of SurvivalGame
                            System.out.println("You lose.");
                            // Calculate Gained EXP
                            int gainedExp = survivalGame1.getMaxNumber() / 10;
                            System.out.println("Sie haben " + gainedExp + "EXP Erhalten");
                            player1.setExp(player1.getExp() + gainedExp);
                            System.out.println("Aktuelles LVL: " + player1.getLevel());
                            // End of EXP Calc
                            
                            //Save Game
                            player1.saveGame();
                            Tools.sleep(4000);
                            
                            Tools.clearterminal();
                            lost = true;
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