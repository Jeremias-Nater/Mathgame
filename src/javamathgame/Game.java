/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamathgame;

import java.util.Random;

/**
 *
 * 
 * @author muster
 */
public class Game {
    protected int playNumber;
    protected int stepCount;
    protected int maxNumber;
    protected int maxSteps;
    protected int targetNumber;
    protected String difficulty;
    protected String input;
    protected boolean valid;
    
    
    
    public void statusoutput() { //Is used Repeatedly to show actual numbers
        System.out.println("Ihre Nummer:" + playNumber);
        System.out.println("Ihre Zielnummer: " + targetNumber);
        System.out.println("Verfügbare Schritte: " + (maxSteps - stepCount));
    }
    
    
    public void mathstep () {
        stepCount++;
        valid = false;
            while (valid == false) {
            System.out.println("");
            System.out.println("Was wollen Sie tun?");
            System.out.println("1: Addieren");
            System.out.println("2: Subtrahieren");
            System.out.println("3: Multiplizieren");
            System.out.println("4: Dividieren");
            System.out.println("5: Potenzieren");
            input = Reader.readString();
            switch (input) {
                case "1":
                    valid = true;
                    System.out.println("Sie haben Addieren Gewählt");
                    break;
                case "2":
                    valid = true;
                    System.out.println("Sie haben Subtrahieren Gewählt");
                    break;
                case "3":
                    valid = true;
                    System.out.println("Sie haben Multiplizieren Gewählt");
                    break;
                case "4":
                    valid = true;
                    System.out.println("Sie haben Dividieren Gewählt");
                    break;
                case "5":
                    valid = true;
                    System.out.println("Sie haben Potenzieren Gewählt");
                    break;
                default:
                    valid = false;
                    Tools.clearterminal();
                    System.out.println("Fehlerhafte Eingabe:");
                    System.out.println(input);
                    Tools.sleep(2000);
                    Tools.clearterminal();
            }
        }
        calculate(input);
    }
    private void calculate(String operator) {
        int calcNumber = 0;
        int newPlayNumber;
        Tools.clearterminal();
        System.out.println("Ihre Nummer: " + playNumber);
        System.out.println("Ihre Ziel-Nummer: " + targetNumber);
        switch (operator) {
            case "1":
                valid = false;
                while (valid == false) {
                    System.out.println("Welche Zahl wollen Sie zu "+ playNumber +" Addieren?");
                    calcNumber = Reader.readInt();
                    if (calcNumber < 10 && calcNumber > 0) {
                        valid = true;
                    } else {
                        Tools.clearterminal();
                        System.out.println("Wählen Sie eine Zahl zwischen 1 und 9!");
                        Tools.sleep(2000);
                        Tools.clearterminal();
                    }
                }
                newPlayNumber = playNumber + calcNumber;
                Tools.clearterminal();
                System.out.println(playNumber + " + " + calcNumber + " = " + newPlayNumber);
                playNumber = newPlayNumber;
                break;
            case "2":
                valid = false;
                while (valid == false) {
                    System.out.println("Welche Zahl wollen Sie von "+ playNumber +" Subtrahieren?");
                    calcNumber = Reader.readInt();
                    if (calcNumber < 10 && calcNumber > 0) {
                        valid = true;
                    } else {
                        Tools.clearterminal();
                        System.out.println("Wählen Sie eine Zahl zwischen 1 und 9!");
                        Tools.sleep(2000);
                        Tools.clearterminal();
                    }
                }
                
                newPlayNumber = playNumber - calcNumber;
                Tools.clearterminal();
                System.out.println(playNumber + " - " + calcNumber + " = " + newPlayNumber);
                playNumber = newPlayNumber;
                break;
            case "3":
                valid = false;
                while (valid == false) {
                    System.out.println("Mit welcher Zahl wollen Sie "+ playNumber +" Multiplizieren?");
                    calcNumber = Reader.readInt();
                    if (calcNumber < 10 && calcNumber > 0) {
                        valid = true;
                    } else {
                        Tools.clearterminal();
                        System.out.println("Wählen Sie eine Zahl zwischen 1 und 9!");
                        Tools.sleep(2000);
                        Tools.clearterminal();
                    }
                }
                
                newPlayNumber = playNumber * calcNumber;
                Tools.clearterminal();
                System.out.println(playNumber + " * " + calcNumber + " = " + newPlayNumber);
                playNumber = newPlayNumber;
                break;
            case "4":
                valid = false;
                while (valid == false) {
                    System.out.println("Durch welche Zahl wollen Sie "+ playNumber +" Dividieren?");
                    calcNumber = Reader.readInt();
                    if (calcNumber < 10 && calcNumber > 0) {
                        valid = true;
                    } else {
                        Tools.clearterminal();
                        System.out.println("Wählen Sie eine Zahl zwischen 1 und 9!");
                        Tools.sleep(2000);
                        Tools.clearterminal();
                    }
                }
                
                newPlayNumber = playNumber / calcNumber;
                Tools.clearterminal();
                System.out.println(playNumber + " / " + calcNumber + " = " + newPlayNumber);
                playNumber = newPlayNumber;
                break;
             case "5":
                valid = false;
                while (valid == false) {
                     System.out.println("Mit welcher Zahl wollen Sie "+ playNumber +" Potenzieren?");
                    calcNumber = Reader.readInt();
                    if (calcNumber < 10 && calcNumber > 0) {
                        valid = true;
                    } else {
                        Tools.clearterminal();
                        System.out.println("Wählen Sie eine Zahl zwischen 1 und 9!");
                        Tools.sleep(2000);
                        Tools.clearterminal();
                    }
                }
                int potNumber = 1;
                newPlayNumber = playNumber;
                 while (potNumber < calcNumber) {
                     newPlayNumber = playNumber * newPlayNumber;
                     potNumber++;
                 }
                Tools.clearterminal();
                System.out.println(playNumber + " ^ " + calcNumber + " = " + newPlayNumber);
                playNumber = newPlayNumber;
                break;
            default:
                System.out.println("Übergabefehler von mathstep() zu calculate(). Die Übergebene Variable wurde nicht korrekt Validiert.");
        }
        statusoutput();
        System.out.println("");
    }
    
}
