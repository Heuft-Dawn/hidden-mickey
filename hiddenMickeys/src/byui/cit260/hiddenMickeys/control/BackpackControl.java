/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.control;

/**
 *
 * @author Hannah Mars
 */
public class BackpackControl {
    public double calcNewBalance(double price, double curBalance) {
        if (price > curBalance || price < 0 || curBalance == 0) {
            return -1;
        }
        curBalance = 50;
        curBalance = curBalance - price;
        return curBalance;	

    }
}
