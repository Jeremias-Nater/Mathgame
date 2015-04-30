/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamathgame;

import java.util.Random;

/**
 *
 * @author muster
 */
public class Tools {
    public static void clearterminal() {
        int i = 0;
        while (i < 12) {
            i++;
            System.out.println("");
        }
    }
    public static int random(int min, int max) {
        Random generator = new Random();
        int randomnumber = generator.nextInt((max - min) + 1) + min;
        return randomnumber;
    }
    public static void sleep (int duration) {
        try {
            Thread.sleep(duration);
        }
        catch(Exception e) {
            System.out.println("Sleep Interrupted!");
            throw new RuntimeException("Exc while trying ...", e);
        }
    }
}
