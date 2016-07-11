/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.control;

import byui.cit260.hiddenMickeys.exceptions.BackpackControlException;
import byui.cit260.hiddenMickeys.model.Backpack;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import byui.cit260.hiddenMickeys.model.Map;
import byui.cit260.hiddenMickeys.model.Mickey;
import hiddenmickeys.HiddenMickeys;
import java.util.ArrayList;

/**
 *
 * @author Hannah Mars
 */


public class BackpackControl {
    public double calcNewBalance(double price)
        throws BackpackControlException {
        Game game = HiddenMickeys.getCurrentGame(); // retreive the game
        Backpack backpack = game.getBackpack();
        double curBalance = backpack.getMoneyBalance();
        if (price > curBalance || price < 0 || curBalance == 0) {
            throw new BackpackControlException("You cannot buy something that costs more money than you have.");
        }
        curBalance = curBalance - price;
        return curBalance;	

    }    
    
    public void updateMoney(double price)
            throws BackpackControlException {
        Game game = HiddenMickeys.getCurrentGame(); // retreive the game
        double newBalance = this.calcNewBalance(price);
        game.getBackpack().setMoneyBalance(newBalance);
    }
    
     public String[] getMickeysCollectedList() {
         Game game = HiddenMickeys.getCurrentGame();
         ArrayList<Mickey> mickeysCollected = game.getBackpack().getMickeysCollected();
         String[] tmpArray = new String[mickeysCollected.size()];
         LocationControl lc = new LocationControl();
         String locationName = new String();
         int i=0;
         for(Mickey mickey : mickeysCollected) {
             locationName = lc.lookupLocationName(mickey.getLocationNum());
             tmpArray[i] = locationName;
             i++;
         }
         return tmpArray;
         }

    public double updateEnergy()
        throws BackpackControlException {
        Game game = HiddenMickeys.getCurrentGame(); // retreive the game
        Game energy = new Game();
        Backpack backpack = game.getBackpack();
        Backpack emergencyWater = new Backpack();
        int curEnergy = game.getEnergyLevel();//energy.getEnergyLevel();
        if (emergencyWater.emergencyWaterUsed == true) {
            throw new BackpackControlException("You have already used your emergncy water. "
                    + "Find a food or rest location to recharge your energy if need be.");
        }
        curEnergy = curEnergy + 10;
        return curEnergy;
    }
    
    public double updateSnackEnergy()
        throws BackpackControlException {
        Game game = HiddenMickeys.getCurrentGame(); // retreive the game
        Game energy = new Game();
        Backpack backpack = game.getBackpack();
        Backpack emergencySnack = new Backpack();
        int curEnergy = game.getEnergyLevel();//energy.getEnergyLevel();
        if (emergencySnack.emergencySnackUsed == true) {
            throw new BackpackControlException("You have already used your emergncy snack. "
                    + "Find a food or rest location to recharge your energy if need be.");
        }
        curEnergy = curEnergy + 10;
        return curEnergy;
    }
         
     

    
     
} 
