/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.control;

import byui.cit260.hiddenMickeys.exceptions.GameControlException;
import byui.cit260.hiddenMickeys.model.Backpack;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Map;
import byui.cit260.hiddenMickeys.model.Player;
import hiddenmickeys.HiddenMickeys;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
        
        //set player at main gate
        game.setCurrentRow(1);
        game.setCurrentColumn(4);
        game.setCurrentLocationNo(16);
        game.setTimeRemaining(600);
        //initializes to the beginning time remaining (user can immedicately get a fast pass)
        game.setFastPassReturnTime(600);
        //set this interval for optimal
        game.setFastPassReturnInterval(90);
        game.setEnergyLevel(100);
        game.setGameOver(false);
        
                
        //Create Character and save in game

        //create Backpack and save in game
        Backpack backpack = new Backpack();
        game.setBackpack(backpack);
        
        //create Map and save in game
        Map map = MapControl.createMap(); //create and initialize new map
        game.setMap(map);//save map in game
        
        MapControl.initStartingPosition(map);
        
    }

    public static void saveGame(Game currentGame, String filePath) 
        throws GameControlException {
        
        try(FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(currentGame); //write teh game object out to file
        }
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
    }

    public static void getSavedGame(String filePath) 
                        throws GameControlException {
        Game game = null;
        try( FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject();//read the game object from file
        }
        catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
        //close the output file
        HiddenMickeys.setCurrentGame(game);//save in Hidden Mickeys
        }
    
    

    public void updateGameValues(int curRow, int curCol, int curLocation)
            throws GameControlException {
        Game game = HiddenMickeys.getCurrentGame();
        int numLocations = game.getMap().getColumnCount() * game.getMap().getRowCount();
        
        if( curRow < 1 || curCol < 1 ){
        throw new GameControlException("Number of rows or columns can not be blank or equal to zero"); 
        }
        if ( curLocation < 1 ){
            throw new GameControlException("Location Number can not be blank or equal to zero"); //null or zero location number
        }
        
        if( curLocation > numLocations){
        //the location number is too high
        throw new GameControlException("Number of columns entered is too high."); //location number is too high
        }
        
        game.setCurrentRow(curRow);
        game.setCurrentColumn(curCol);
        game.setCurrentLocationNo(curLocation);
        
    }
    
    public static int updateEnergyLevels(int minutes)
            throws GameControlException {
        Game game = HiddenMickeys.getCurrentGame();
        int curEnergyLevel = game.getEnergyLevel();
        int energyDecrease = calcEnergyUsed(minutes);
        if (energyDecrease>curEnergyLevel){
            throw new GameControlException("Sorry - You are out of Energy."); //null or zero location number
        }else{
            curEnergyLevel = curEnergyLevel - energyDecrease;
            game.setEnergyLevel(curEnergyLevel);
        }
            return game.getEnergyLevel();
}
    
     public static int calcEnergyUsed (int timeUsed) 
            throws GameControlException {
      if(timeUsed<1){
           throw new GameControlException("Cannot calculate energy used on time less than 1"); 
      }else{
         
      int energyUsed = timeUsed/5;
      
      return energyUsed;
      }
      }
    
    public static int updateTimeRemaining(int minutes)
            throws GameControlException {
        Game game = HiddenMickeys.getCurrentGame();
        int curTime = game.getTimeRemaining();
        int energyDecrease;
        if (minutes>curTime){
            throw new GameControlException("\nSorry, you do not have enough time to ride this ride!"); //null or zero location number
        }else{
            curTime = curTime - minutes;
            game.setTimeRemaining(curTime);
            
        }
       return game.getTimeRemaining();
    }
    
    
}


