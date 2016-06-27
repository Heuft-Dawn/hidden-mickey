/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.control;

import byui.cit260.hiddenMickeys.model.Backpack;
import byui.cit260.hiddenMickeys.model.Game;
import hiddenmickeys.HiddenMickeys;

/**
 *
 * @author Hannah Mars
 */
public class BackpackControl {
    public double calcNewBalance(double price) {
        Game game = HiddenMickeys.getCurrentGame(); // retreive the game
        Backpack backpack = game.getBackpack();
        double curBalance = backpack.getMoneyBalance();
        if (price > curBalance || price < 0 || curBalance == 0) {
            return -1;
        }
        curBalance = curBalance - price;
        return curBalance;	

    }
}
