/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.BackpackControl;
import byui.cit260.hiddenMickeys.model.Backpack;
import byui.cit260.hiddenMickeys.model.Game;
import hiddenmickeys.HiddenMickeys;

/**
 *
 * @author Hannah Mars
 */
public class ExploreShopLocationView extends View {
    
    public ExploreShopLocationView(){
    super("\n"
            +"\n------------------------------"
            +"\nShop Menu"
            +"\n------------------------------"
            +"\n1 - Purchase Item 1"
            +"\n2 - Purchase Item 2"
            +"\n3 - Purchase Item 3"
            +"\nQ - Return to Game Menu"
            +"\n------------------------------"
            +"\n\n\nPlease enter your choice.");
    }

     @Override
     public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "Y": //Yes, buy a souvenir
                this.buySouvenir();
                break;
            case "Q": //go back to menu
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

   
    private void buySouvenir() {
        System.out.println("You bought a souvenir for $10. Enjoy!");
        //this will update the amount of money left in th e player's backpack
        this.updateMoney();
    }

    private void notBuySouvenir() {
        System.out.println("You did not buy a souvenir. Enjoy the rest of your time!");
    }

    private void updateMoney() {
        Game game = HiddenMickeys.getCurrentGame(); // retreive the game
        BackpackControl backpackControl = new BackpackControl();
        double newBalance = backpackControl.calcNewBalance(10);
        game.getBackpack().setMoneyBalance(newBalance);
    }
    
}
