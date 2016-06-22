/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.control;

import byui.cit260.hiddenMickeys.model.Backpack;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Map;
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
       
        Game game = new Game();//create new game
        HiddenMickeys.setCurrentGame(game);//save in HiddenMickeys
        
        game.setPlayer(player);//save player in game
        
        //Create Character and save in game

        //create Backpack and save in game
        Backpack backpack = new Backpack();
        game.setBackpack(backpack);
        
        //create Map and save in game
        Map map = MapControl.createMap(); //create and initialize new map
        game.setMap(map);//save map in game
        
        MapControl.initStartingPosition(map);
        
    }
    
}


