/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamathgame;

/**
 *
 * @author muster
 */
public class Player {
    String nickname;
    //private int exp;
    //private int lvl;
    //private int cash;
    //private int highscore;
    
    static boolean valid = false;
    
    static Object Auth() {
        valid = false;
        while (valid == false) {
            System.out.println("Melden Sie sich an:");
            System.out.println("1. Anmelden");
            System.out.println("2. Account Registieren");
            System.out.println("3. Benutzer auflisten");
            String selected = Reader.readString();
            switch (selected) {
                case "1":
                    
                    valid = true;
                    break;
                case "2":
                    System.out.println("Geben Sie Ihren Nicknamen ein:");
                    
                    valid = true;
                    break;
                case "3":
                    
                    break;
                default:
                    System.out.println("Ungültige Eingabe");
                    Tools.sleep(5000);
            }
        }
        Player pl = new Player();
        return pl;
    }
}
