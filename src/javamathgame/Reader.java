/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamathgame;

import java.io.*;

/**
 *
 * @author muster
 */
public class Reader {
    
    public static int readInt (){
        String input;
        int output;
        try{
        
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            input = r.readLine();
            output = Integer.parseInt(input);

            return output;
        }
        catch(Exception e) {
            System.out.println("Einlesefehler");
            throw new RuntimeException("Exc while trying ...", e);
        }
    }
    
    public static String readString (){
        try {
        
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            String output = r.readLine();

            return output;
        }
        catch(Exception e) {
            System.out.println("Einlesefehler");
            throw new RuntimeException("Exc while trying ...", e);
        }
    }
    
    public static double readDouble (){
        try {
            String input;
            double output;

            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            input = r.readLine();
            output = Double.valueOf(input);

            return output;
        }
        catch(Exception e) {
            System.out.println("Einlesefehler");
            throw new RuntimeException("Exc while trying ...", e);
        }
    }
}
