/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.BackpackControl;
import byui.cit260.hiddenMickeys.control.LocationControl;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import byui.cit260.hiddenMickeys.model.Scene;
import hiddenmickeys.HiddenMickeys;
import java.text.DecimalFormat;


/**
 *
 * @author Dawn
 */
public class ExploreFoodLocationView extends View {    
    private Scene myScene;
    public ExploreFoodLocationView(Scene scene){
        super("------------------------------"
            +"\n" + scene.getName() +" Food Menu"
            +"\n" + scene.getDescription()
            +"\n------------------------------"
            +"\n1 - Purchase Item 1 " + scene.getItemName()[0]
            +"\n2 - Purchase Item 2 " + scene.getItemName()[1] 
            +"\n3 - Purchase Item 3 " + scene.getItemName()[2]
            +"\n------------------------------"
            +"\n    All items are $" + Double.toString(scene.getItemPrice()) + "0"
            +"\n------------------------------"
            +"\nQ - Return to Game Menu"
            +"\n------------------------------"
            +"\n\n You may choose one item. Please enter your choice.");
        this.myScene = scene;
}

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        boolean returnToMenu = false;
        switch (choice) {
            case "Q": //go back to menu
                break;
            default:
            int choiceNum = 0;    
            try {
                choiceNum = Integer.parseInt(choice);
                switch (choiceNum){
                    case 1: //for item 1
                    case 2: //for item 2
                    case 3: //for item 3
                        //Buy item and pass the position in the array
                        this.buyFood(choiceNum-1);
                        break;
                    default:
                        System.out.println("\nYou must enter a valid option.");
                        returnToMenu = true;
                        break;
                        
                }
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number or Q");
                //prompt the user to try again
                return false;
            }
           break;     
        }
        return !returnToMenu;
        }

       
            

    private void exploreFood() {
        //this will display a description for the user - telling them 
        //about the food location and what is available
        this.getFoodDescription();
        //This calls a menu that gives the player a chance to search for Mickeys or exit.
                
        MickeyLocationEndView  locationEndMenu = new MickeyLocationEndView(this.myScene);
        locationEndMenu.display();
                
 
    }

    private void getFoodDescription() {
       System.out.println("This kiosk sells popcorn in souvenir containers."
                +"\nYou purchased a Star Wars souvenir container and ate"
                + "\nseveral handfuls of popcorn.  It was delicious.");
    }

    private void updateEnergy() {
       System.out.println("\n***updateEnergy()function called***");
    }

    private void buyFood(int arrayPosition) {
        //System.out.println("\n***buyFood()function called***");
        Game game = HiddenMickeys.getCurrentGame();
        int locationNum = game.getCurrentLocationNo();
        
        //get the location information
        LocationControl lc = new LocationControl();
        Location myLocation = lc.getLocationByNumber(locationNum);
        
        //get item price and update balance
        double price = myLocation.getScene().getItemPrice();
        
        //update backpack
         BackpackControl bc = new BackpackControl();
        try {
        bc.updateMoney(price);  
        } catch (Throwable backpackc) {
            System.out.println(backpackc.getMessage());
        }
        //use decimal format object to format money
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        
        //get the remaining balance from the backpack
        double remaining = game.getBackpack().getMoneyBalance();
        
        //get the item name from the position in the array
        String item = myLocation.getScene().getItemName()[arrayPosition];
        System.out.println("\nYou bought "+ item + " for $"+  df.format(price) + ", and have $" + df.format(remaining) + " remaining.");     
        //update the location as visited
        myLocation.setVisited(true);
        
    }
} 