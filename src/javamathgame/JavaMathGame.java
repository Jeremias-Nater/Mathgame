/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamathgame;

/**
 *
 * @author MIAS
 */


public class JavaMathGame {
    
    public static void main(String[] args){
        
        boolean quit = false;
        boolean win = false;
        boolean lost = false;
        while (!quit) {
            
            win = false;
            lost = false;
            
            Player.Auth();
            
            System.out.println("Wählen Sie den Spielmodus:");
            System.out.println("1.) Klassisch");
            System.out.println("2.) Survival");
            System.out.println("3.) Timerace");
            System.out.println("9.) Spiel verlassen");
            String selected = Reader.readString();
            switch (selected) {
                case "1":
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
                            System.out.println("YOU HAVE LOST YOU FUCKING WORTHLESS CUNT");
                        }
                    }
                    break;
                case "2":
                    SurvivalGame survival = new SurvivalGame();
                    survival.startgame();
                    while (lost == false) {
                        survival.mathstep();
                        if (survival.validate() == "lost") {
                            System.out.println("You lose? :-(");
                        }
                    }
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
