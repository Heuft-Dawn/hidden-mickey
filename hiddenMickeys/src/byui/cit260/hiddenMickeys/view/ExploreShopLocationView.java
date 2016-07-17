
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.BackpackControl;
import byui.cit260.hiddenMickeys.control.LocationControl;
import byui.cit260.hiddenMickeys.model.Backpack;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import byui.cit260.hiddenMickeys.model.Scene;
import hiddenmickeys.HiddenMickeys;
import java.text.DecimalFormat;


public class ExploreShopLocationView extends View {
    
    public ExploreShopLocationView(Scene scene){
    
    super("------------------------------"
            +"\n" + scene.getName() +" Menu"
            +"\n" + scene.getDescription()
            +"\n------------------------------"
            +"\n1 - Purchase " + scene.getItemName()[0]
            +"\n2 - Purchase " + scene.getItemName()[1]
            +"\n3 - Purchase " + scene.getItemName()[2]
            +"\n------------------------------"
            +"\n    All items are $" + Double.toString(scene.getItemPrice()) + "0"
            +"\n------------------------------"
            +"\nQ - Return to Game Menu"
            + "\nM - Return to Map"
            +"\n------------------------------"
            +"\n\nYou must purchase souvenir in order to search for a Mickey\n\nPlease enter your choice.");
    }

     @Override
     public boolean doAction(String choice) {
     choice = choice.toUpperCase();
     boolean returnToMenu = false;
        switch (choice) {
            case "Q": //go back to menu
                break;
            case "M":
                GameMenuView gmv = new GameMenuView();
                gmv.mapAndMove();
                break;
            default:
            int choiceNum = 0;    
            try {
                choiceNum = Integer.parseInt(choice);
                switch (choiceNum){
                    case 1: //if the item is 1
                    case 2: //or 2
                    case 3: //or 3
                        //Buy the item and pass the position of the item in the array
                        this.buyItem(choiceNum-1);
                        break;
                    default:
                        ErrorView.display(this.getClass().getName(),
                                "\nYou must enter a valid item number.");
                        returnToMenu = true;
                        return !returnToMenu;
                        
                        
                }
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(),"\nYou must enter a valid number or Q");
                //prompt the user to try again
                return false;
            }
           break;     
        }
        return !returnToMenu;
        }

   
    private void buyItem(int arrayPosition) {
        Game game = HiddenMickeys.getCurrentGame();
        int locationNum = game.getCurrentLocationNo();
        
        //get the location object to extract data from
        //LocationControl lc = new LocationControl();
        Location myLocation = LocationControl.getLocationByNumber(locationNum);
        
        //get the item price to update remaining balance and to display on screen
        double price = myLocation.getScene().getItemPrice();
        
        //this will update the amount of money left in th e player's backpack
        
        BackpackControl bc = new BackpackControl();
        try {
        bc.updateMoney(price);
        } catch (Throwable backpackc) {
            ErrorView.display(this.getClass().getName(),backpackc.getMessage());
        }
        //use decimal format object to format money
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        
        //get the remaining balance from the backpack
        double remaining = game.getBackpack().getMoneyBalance();
        
        //get the item name from the position in the array
        String item = myLocation.getScene().getItemName()[arrayPosition];
        this.console.println("\nYou bought "+ item + " for $"+  df.format(price) + ", and have $" + df.format(remaining) + " remaining."
                            + "\nNow you may look around the shop."
                            + "\nDescription:" + myLocation.getScene().getDescription());
        
        //update the location as visited
        myLocation.setVisited(true);
        
        //Decide whether to search for a Mickey
        MickeyLocationEndView endView = new MickeyLocationEndView(myLocation.getScene());
        endView.display();
        
     

    }
    
    
}
