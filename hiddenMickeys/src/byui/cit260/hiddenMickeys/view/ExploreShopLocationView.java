/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.BackpackControl;
import byui.cit260.hiddenMickeys.control.LocationControl;
import byui.cit260.hiddenMickeys.model.Backpack;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import byui.cit260.hiddenMickeys.model.Scene;
import hiddenmickeys.HiddenMickeys;
import java.text.DecimalFormat;

/**
 *
 * @author Hannah Mars
 */
public class ExploreShopLocationView extends View {
    
    public ExploreShopLocationView(Scene scene){
    
    super("\n"
            +"\n------------------------------"
            +"\nShop Menu"
            +"\n------------------------------"
            +"\n1 - Purchase " + scene.getItemName()[0]
            +"\n2 - Purchase " + scene.getItemName()[1]
            +"\n3 - Purchase " + scene.getItemName()[2]
            +"\n    All items are $" + Double.toString(scene.getItemPrice())
            +"\nQ - Return to Game Menu"
            +"\n------------------------------"
            +"\n\n\nPlease enter your choice.");
    }

     @Override
     public boolean doAction(String choice) {
     choice = choice.toUpperCase();
        switch (choice) {
            case "Q": //go back to menu
                break;
            default:
            int choiceNum = 0;    
            try {
                choiceNum = Integer.parseInt(choice);
                switch (choiceNum){
                    case 1: //if the item is 1
                    case 2: //or 2
                    case 3: //or 3
                        this.buyItem();
                        break;
                    default:
                        System.out.println("\n***You must enter a valid number or option.");
                        break;
                }
            } catch (NumberFormatException nf) {
                
            }
                break;
        }
        return true;
        }

   
    private void buyItem() {
        Game game = HiddenMickeys.getCurrentGame();
        int locationNum = game.getCurrentLocationNo();
        
        LocationControl lc = new LocationControl();
        Location myLocation = lc.getLocationByNumber(locationNum);
        
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        
        double price = myLocation.getScene().getItemPrice();
        System.out.println("You bought a souvenir for $"+  df.format(price) + " Enjoy!");
        //this will update the amount of money left in th e player's backpack
        BackpackControl bc = new BackpackControl();
        bc.updateMoney(price);
        
        System.out.println("Your purchase is complete.  You may look around the shop.");
        System.out.println(myLocation.getScene().getDescription());
        
        //update the location as visited
        myLocation.setVisited(true);
        
        MickeyLocationEndView endView = new MickeyLocationEndView();
        endView.display();
        
    }

   
    
    
}
