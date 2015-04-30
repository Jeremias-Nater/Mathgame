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
        valid = true;
        do{
        System.out.println("Melden Sie sich an:");
        System.out.println("1. Anmelden");
        System.out.println("2. Account Registieren");
        System.out.println("3. Benutzer auflisten");
        String selected = Reader.readString();
            switch (selected) {
                case "1":

                    break;
                case "2":
                    System.out.println("Geben Sie Ihren Nicknamen ein:");
                    
                    
                    break;
                case "3":
                    
                    valid = false;
                    break;
                default:
                    valid = false;
                    System.out.println("Ungültige Eingabe");
                    Tools.sleep(5000);
            }
        }
        while(valid = true);
        Player pl = new Player();
        return pl;
    }
}
