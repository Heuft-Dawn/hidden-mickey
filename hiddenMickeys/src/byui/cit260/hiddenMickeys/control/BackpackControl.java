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

    public int updateEnergy()
        throws BackpackControlException {
        Game game = HiddenMickeys.getCurrentGame(); // retreive the game
        Backpack backpack = game.getBackpack();
        int curEnergy = game.getEnergyLevel();//energy.getEnergyLevel();
        if (backpack.isEmergencyWaterUsed()) {
            throw new BackpackControlException("You have already used your emergency water. "
                    + "\nFind a food or rest location to recharge \nyour energy if need be.");
        }
        curEnergy = curEnergy + 10;
        game.setEnergyLevel(curEnergy);
        curEnergy = game.getEnergyLevel();
        return curEnergy;
    }
    
    public int updateSnackEnergy()
        throws BackpackControlException {
        Game game = HiddenMickeys.getCurrentGame(); // retreive the game
        Backpack backpack = game.getBackpack();
        int curEnergy = game.getEnergyLevel();//energy.getEnergyLevel();
        if (backpack.isEmergencySnackUsed()) {
            throw new BackpackControlException("You have already used your emergency snack. "
                    + "\nFind a food or rest location to recharge \nyour energy if need be.");
        }
        curEnergy = curEnergy + 10;
        game.setEnergyLevel(curEnergy);
        curEnergy = game.getEnergyLevel();
        return curEnergy;
    }
         
     

    
     
} 
