package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.LocationControl;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import hiddenmickeys.HiddenMickeys;

public class ExploreRestView extends View {
     public ExploreRestView(){
        super("Would you like to stop and rest at this location? (Y/N)");
    }
    
    @Override
     public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "Y": 
                    return this.rest();
                
            case "N": 
                    LocationControl.markCurrentLocationVisited();
                break;
            case "Q":
                    LocationControl.markCurrentLocationVisited();
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n***Invalid selection. Try again.");
                return false;
                
        }
        return true;
}

    private boolean rest() {
        Game game = HiddenMickeys.getCurrentGame();
        int locationNum = game.getCurrentLocationNo();
        Location myLocation = LocationControl.getLocationByNumber(locationNum);
        //mark location as visited
        myLocation.setVisited(true);
        //display description of place
        this.console.println(myLocation.getScene().getDescription());
        
        //charge 20 min to the time
        int curTime = game.getTimeRemaining();
        game.setTimeRemaining(curTime - 20);
        if(game.isGameOver()) return true;
        //increase energy by 15
        int curEnergy = game.getEnergyLevel();
        game.setEnergyLevel(curEnergy + 10);
        //Notify user of new values
        this.console.println("\nAfter resting for 20 minutes, your energy has increased by 10%.");
        this.displayCurrentTimeAndEnergy();
        //quit the option? or ??go to Mickey search view??
        this.quitTheOption();
        
        return true;
    }
    
    }

    
