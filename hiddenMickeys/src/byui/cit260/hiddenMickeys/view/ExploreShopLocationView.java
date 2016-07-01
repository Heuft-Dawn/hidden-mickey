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
            +"\nY - Yes, buy a souvenir"
            +"\nN - No, do not buy a souvenir"
            +"\nQ - Return to Game Menu"
            +"\n------------------------------"
            +"\n\n\nThis location sells souvenirs for $10.  Would you like to purchase something?");
    }

     @Override
     public boolean doAction(String choice) {
     choice = choice.toUpperCase();
        switch (choice) {
            case "Q": //Yes, buy a souvenir
                
                break;
            
            default:
            int choiceNum = 0;    
            try {
                choiceNum = Integer.parseInt(choice);
                switch (choiceNum){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("\n***You must enter a valid number or option.");
                        break;
                }
            } catch (NumberFormatException nf) {
                
            }
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
