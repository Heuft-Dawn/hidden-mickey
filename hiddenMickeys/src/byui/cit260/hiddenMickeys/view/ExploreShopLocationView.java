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
    
    super("------------------------------"
            +"\nShop Menu"
            +"\n------------------------------"
            +"\n1 - Purchase " + scene.getItemName()[0]
            +"\n2 - Purchase " + scene.getItemName()[1]
            +"\n3 - Purchase " + scene.getItemName()[2]
            +"\n------------------------------"
            +"\n    All items are $" + Double.toString(scene.getItemPrice()) + "0"
            +"\n------------------------------"
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
                        //pass the position of the item in the array
                        this.buyItem(choiceNum-1);
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

   
    private void buyItem(int arrayPosition) {
        Game game = HiddenMickeys.getCurrentGame();
        int locationNum = game.getCurrentLocationNo();
        
        //get the location object to extract data from
        LocationControl lc = new LocationControl();
        Location myLocation = lc.getLocationByNumber(locationNum);
        
        //get the item price to update remaining balance and to display on screen
        double price = myLocation.getScene().getItemPrice();
        
        //this will update the amount of money left in th e player's backpack
        BackpackControl bc = new BackpackControl();
        bc.updateMoney(price);
        
        //use decimal format object to format money
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        
        //get the remaining balance from the backpack
        double remaining = game.getBackpack().getMoneyBalance();
        
        //get the item name from the position in the array
        String item = myLocation.getScene().getItemName()[arrayPosition];
        System.out.println("You bought "+ item + " for $"+  df.format(price) + ", and have $" + df.format(remaining) + " remaining.");
        System.out.println("Now you may look around the shop.");
        System.out.println(myLocation.getScene().getDescription());
        
        //update the location as visited
        myLocation.setVisited(true);
        
        //Decide whether to search for a Mickey
        MickeyLocationEndView endView = new MickeyLocationEndView();
        endView.display();
        
    }

   
    
    
}
