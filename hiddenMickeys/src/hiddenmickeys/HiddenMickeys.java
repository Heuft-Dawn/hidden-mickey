/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiddenmickeys;

/**
 *
 * @author Hannah Mars
 */

import byui.cit260.hiddenMickeys.model.Player;

public class HiddenMickeys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setPlayerName("Amy");
        playerOne.setBestTime(150);
        playerOne.setDateLastPlayed("05/10/16");
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }
    
}
