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
     public int getMickeysCollected() {
        Game game = HiddenMickeys.getCurrentGame(); // retrieve the game
        // retrieve the Mickeys collected
        int countMickeys = game.getBackpack().getMickeysCollected().length;
        return countMickeys;
    }
    
     public String[] getMickeysCollectedList() {
         Game game = HiddenMickeys.getCurrentGame();
         Mickey[] mickeysCollected = game.getBackpack().getMickeysCollected();
         String[] tmpArray = new String[mickeysCollected.length];
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
         
     

    public void updateMoney(double price)
            throws BackpackControlException {
        Game game = HiddenMickeys.getCurrentGame(); // retreive the game
        double newBalance = this.calcNewBalance(price);
        game.getBackpack().setMoneyBalance(newBalance);
    }
     
} 
