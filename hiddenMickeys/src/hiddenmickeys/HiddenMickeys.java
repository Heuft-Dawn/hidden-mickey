
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
import byui.cit260.hiddenMickeys.model.Character;
import byui.cit260.hiddenMickeys.model.Backpack;
import byui.cit260.hiddenMickeys.model.Map;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.FastPassStation;
import byui.cit260.hiddenMickeys.model.Kiosk;
import byui.cit260.hiddenMickeys.model.Location;
import byui.cit260.hiddenMickeys.model.Ride;
import byui.cit260.hiddenMickeys.model.Scene;
import byui.cit260.hiddenMickeys.model.Shop;

import byui.cit260.hiddenMickeys.view.StartProgramView;

public class HiddenMickeys {
    
    private static Game currentGame = null;
    private static Player player = null;

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create the start program view and display the start program view
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();
        
        
        
        Player playerOne = new Player();
        
        playerOne.setPlayerName("Amy");
        playerOne.setBestTime(150);
        playerOne.setDateLastPlayed("05/10/16");
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
        
        
        Character characterOne = new Character();
        characterOne.setName("Cindi");
        characterOne.setHeight(65);
        characterOne.setAge(21);
        characterOne.setGender("F");
        
        String characterInfo = characterOne.toString();
        System.out.println(characterInfo);
        
        
        Backpack playerBackpack = new Backpack();
        playerBackpack.setEmergencyWaterUsed(false);
        playerBackpack.setEmergencySnackUsed(false);
        playerBackpack.setNumberFastPasses(3);
        playerBackpack.setMoneyBalance(50);
        
        String backpackInfo = playerBackpack.toString();
        System.out.println(backpackInfo);
        
        
        Map playerMap = new Map();
        playerMap.setRowCount(1);
        playerMap.setColumnCount(1);
        
        String mapInfo = playerMap.toString();
        System.out.println(mapInfo);
        
        
        Game myGame = new Game();
        myGame.setCurrentColumn(1);
        myGame.setCurrentRow(4);
        myGame.setEnergyLevel(90);
        myGame.setMickeysCollected(4);
        myGame.setTimeExpired(160);
        myGame.setTimeRemaining(600-myGame.getTimeExpired());
        
        String gameInfo = myGame.toString();
        System.out.println(gameInfo);
        
        FastPassStation station1 = new FastPassStation();
        station1.setLastVisitedTime(100);
        station1.setNextAvailableTime((station1.getLastVisitedTime()+45));
        
        String fastPassStationInfo = station1.toString();
        System.out.println(fastPassStationInfo);
        
        Shop shop1 = new Shop();
        shop1.setCost(2.25);
        shop1.setMickeyAvailable(true);
        shop1.setProductName("Blue Mickey Key Chain");
        
        String shopInfo = shop1.toString();
        System.out.println(shopInfo);
        
        Location playerLocation = new Location ();
        
        playerLocation.setName("Thunder Mountain");
        playerLocation.setRow(2);
        playerLocation.setColumn(4);
        playerLocation.setLand("Adventure Land");
        playerLocation.setReturnAllowed(true);
        playerLocation.setVisited(false);
        
        String locationInfo = playerLocation.toString();
        System.out.println(locationInfo);
        
        Ride ride1 = new Ride ();
        ride1.setWaitTime(100);
        ride1.setDescription("Space Mountain");
        ride1.setEnergyUsed(30);
        ride1.setFastPassEligible(true);
        ride1.setMickeyAvailable(true);
        
        String rideInfo = ride1.toString();
        System.out.println(rideInfo);
        
        Kiosk kiosk1 = new Kiosk ();
        kiosk1.setCost(2);
        kiosk1.setEnergyBoostIncrease(50);
        kiosk1.setFoodItem("popcorn");
        
        String kioskInfo = kiosk1.toString();
        System.out.println(kiosk1);
        
        Scene scene1 = new Scene ();
        scene1.setDescription("Main Street");
        scene1.setMickeyLocation("Fantasy Land");
        
        String sceneInfo = scene1.toString();
        System.out.println(scene1);
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        HiddenMickeys.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }
    

    public static void setPlayer(Player player) {
        HiddenMickeys.player = player;
    }
    
}

