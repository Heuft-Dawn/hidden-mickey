/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.control;

import byui.cit260.hiddenMickeys.model.Player;
import hiddenmickeys.HiddenMickeys;

/**
 *
 * @author Dawn
 */
public class GameControl {

    public static Player createPlayer(String playerName) {
        if (playerName == null) {
            return null;
        }
        Player player = new Player();
        player.setPlayerName(playerName);
        
        HiddenMickeys.setPlayer(player); //save the player
        return player;
    }

    public static void createNewGame(Player player) {
        System.out.println("\n***New game created");
    }
    
}


