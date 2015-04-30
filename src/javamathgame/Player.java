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
    private String name;
    private int exp;
    private int lvl;
    private int cash;
    private int highscore;
    
    public Player(String inputname) {
        name = inputname;
    }
}
