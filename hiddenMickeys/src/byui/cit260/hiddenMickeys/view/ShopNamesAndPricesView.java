
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import hiddenmickeys.HiddenMickeys;
import java.io.IOException;
import java.io.PrintWriter;

public class ShopNamesAndPricesView extends View{
    
    public ShopNamesAndPricesView(){
        super("Would you like to Save (S) the report or View (V) the report?");
}   

    @Override
    public boolean doAction(String choice) {
       choice = choice.toUpperCase();
       boolean returnToMenu = false;
       switch(choice){
           case "S":
               this.saveReport();
               break;
           case "V":
               this.viewReport();
               this.quitTheOption();
               break;   
           case "Q":
               break;
           default:
               ErrorView.display(this.getClass().getName(),"/nInvalid choice try again");
               returnToMenu = true;
               break;
       }
       return !returnToMenu;
   }

    private void saveReport() {
      //prompt for and get the name of the file to save the game in
      this.console.println("\n\nEnter the file path for where the report "
      + "is to be saved.");
      String filePath = this.getInput();
      
        try (PrintWriter out = new PrintWriter(filePath)) {
            //Write the report header
            out.println("\nSHOP AND RESTAURANT NAMES AND PRICES REPORT");
            out.printf("%n%-7s%-30s%1s%-11s","Loc#","Shop/Restaurant Name","", "Price");
            out.printf("%n%-7s%-30s%1s%-11s","-----","-----------------------------------", "-", "-------------");
            
            //pull the data
            Game game = HiddenMickeys.getCurrentGame();
            Location[][] locations = game.getMap().getLocations();
            
            //initialize needed variables
            int curLocationNum;
            String shopName;
            double shopPrice;
            
            
          //loop through all the locations to find the shops
          for (Location[] location : locations) {
                for (Location location1 : location) {
                    curLocationNum = location1.getLocationNo();
                   
                    //if the location is a shop, search for the item price
                    if (location1.getScene().getLocationType().equals("S") || location1.getScene().getLocationType().equals("F")) {
                        shopName = location1.getScene().getName();
                        shopPrice = location1.getScene().getItemPrice();
                    
                        out.printf("%n%-7s%-30s%1s%-11.2f", Integer.toString(curLocationNum), shopName, "$", shopPrice);
                    }
                }
          }
        
            out.println("\n\n ");
            //close the file
            try{
                if (out != null)
                 out.close();
                         
            } catch(Exception e) {
             ErrorView.display(this.getClass().getName(),"Error closing file");
             return;
             }
            this.console.println("\n\nThe Report has been saved.");
        }catch (IOException ex) {
            ErrorView.display(this.getClass().getName(),"I/0 Error: " + ex.getMessage());
        }
         
        
    
    }

        
    private void viewReport() {
        //report header
            this.console.println("\nSHOP AND RESTAURANT NAMES AND PRICES REPORT");
            this.console.printf("%n%-7s%-30s%1s%-11s","Loc#","Shop/Restaurant Name", "", "Price");
            this.console.println("\n-------------------------------------------------------------");
        //get the data
            Game game = HiddenMickeys.getCurrentGame();
            Location[][] locations = game.getMap().getLocations();
            
        //initialize needed variables
            int curLocationNum;
            String shopName;
            double shopPrice;
            
        //loop through the locations to find shop and restaurant locations
        for (Location[] location : locations) {
                for (Location location1 : location) {
                    curLocationNum = location1.getLocationNo();
                   
                    //if the location is a shop, search for the item price
                    if (location1.getScene().getLocationType().equals("S") || location1.getScene().getLocationType().equals("F")) {
                        shopName = location1.getScene().getName();
                        shopPrice = location1.getScene().getItemPrice();
                    
                        //print the shop name and price on the report
                        this.console.printf("%n%-7s%-30s%1s%-11.2f", Integer.toString(curLocationNum), shopName, "$", shopPrice);
                    }
                }
    }
    
            this.console.println("\n\n ");
      
    }
}

