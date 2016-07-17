package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.LocationControl;
import byui.cit260.hiddenMickeys.model.Backpack;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import byui.cit260.hiddenMickeys.model.Mickey;
import byui.cit260.hiddenMickeys.model.Scene;
import hiddenmickeys.HiddenMickeys;
import java.util.ArrayList;

public class MickeyLocationEndView extends View{
   private String promptMessage; 
   private Scene myScene;
    //Constructor function
    public MickeyLocationEndView(Scene myScene){//constructor Function
        super("------------------------------"
            +"\nRide Exit Menu"
            +"\n------------------------------"
            +"\nS - Search for Hidden Mickey"
            +"\nQ - Exit Ride/ Stop Exploring"
            +"\n------------------------------"
            +"\n \n"
            +"\n Enter your choice");
        this.myScene = myScene;
}

   @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        boolean returnToMenu = false;
    
        switch (choice) {
            case "S": //Search for Mickey
            
                this.displayMickeySearch();
                break;
            case "Q": //go back to menu
                break;
            default:
                ErrorView.display(this.getClass().getName(),
                        "\n***Invalid selection. Try again.");
                returnToMenu = true;
                break;
                        }
        return !returnToMenu;
    }
    
    
     

    private void displayMickeySearch() {
        //get the data
        Game game = HiddenMickeys.getCurrentGame();
        int locationNum = game.getCurrentLocationNo();
        Location location = LocationControl.getLocationByNumber(locationNum);
        boolean mickeyFound = false;
        Backpack backpack = game.getBackpack();
        ArrayList<Mickey> mickeys = backpack.getMickeysCollected();
        
        for (Mickey mickey: mickeys){
                           
                        //if there is a matching mickey location, set mickeyfound to true
                        if(mickey.getLocationNum()==locationNum){
                           
                            mickeyFound = true;
                          
                        }
            }
        //check to see if the location scene has a mickey or if one has already been found
        if(location.getScene().isMickeyPresent() && !mickeyFound){
                
        //create mickey object to pass into mickey array
        Mickey mickey1 = new Mickey();
        mickey1.setLocationNum(game.getCurrentLocationNo());
        //get the array list from the game
        ArrayList<Mickey> mickeysCollected = game.getBackpack().getMickeysCollected();
        //add the mickey to the array
        mickeysCollected.add(mickey1);
        //pass the array back to the game
        game.getBackpack().setMickeysCollected(mickeysCollected);
        //go to the Mickey search menu
        MickeySearchMenuView  mickeySearchMenu = new MickeySearchMenuView(this.myScene, mickeysCollected);
        mickeySearchMenu.display();}
        else {
            this.console.println("There are no Hidden Mickeys here.");
        }
        
       
    }
}
