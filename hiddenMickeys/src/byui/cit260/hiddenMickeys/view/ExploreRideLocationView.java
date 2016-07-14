/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.GameControl;
import byui.cit260.hiddenMickeys.control.LocationControl;
import byui.cit260.hiddenMickeys.exceptions.GameControlException;
import byui.cit260.hiddenMickeys.model.Backpack;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import hiddenmickeys.HiddenMickeys;


/**
 *
 * @author Administrator
 */
public class ExploreRideLocationView extends View {
    private int waitTime;
    private int fastPassTime;

    public ExploreRideLocationView(int waitTime, int fastPassTime){
        
        super("------------------------------"
            +"\nRide Menu"
            +"\n------------------------------"
            +"\nP - Use Fast Pass"
            +"\nY - Continue "
            +"\nQ - Return to Game Menu"
            +"\n------------------------------"
            +"\n\n\nThe current Ride wait time is " + Integer.toString(waitTime) + ".  "
        + "A Fast Pass would make the wait time " + Integer.toString(fastPassTime) + " minutes.\nWhat would you like to do?");
        this.waitTime = waitTime;
        this.fastPassTime = fastPassTime;
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        boolean returnToMenu = false;
        switch (choice) {
            case "P": //Use FastPass
                returnToMenu = this.useFastPass();
                break;
            case "Y": //Continue and explore
                this.exploreRide();
                break;   
            case "N": //go back to menu
                break;
            case "Q": //go back to menu
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n***Invalid selection. Try again.");
                returnToMenu = true;
                break;
        }
        return !returnToMenu;
    }

  

    private boolean useFastPass() {
       
       Game game = HiddenMickeys.getCurrentGame();
       Backpack backpack = game.getBackpack();
       int numFastPasses = backpack.getNumberFastPasses();
       if(numFastPasses > 0){
       
        try{
            //loading current game, location and get location number
        
        int locationNum = game.getCurrentLocationNo();
        //LocationControl lc = new LocationControl();
        Location mylocation = LocationControl.getLocationByNumber(locationNum);
        //GameControl gc = new GameControl();
        //print a description of the ride
        String description = mylocation.getScene().getDescription();
        this.console.println(description);
            //update wait time
            int waitTime = mylocation.getScene().getWaitTime();
            int fastPassTime = this.fastPassTime;
            int energyLevel;
            int timeRemaining;
            energyLevel = GameControl.updateEnergyLevels(fastPassTime);
            timeRemaining = GameControl.updateTimeRemaining(fastPassTime);
            if(!game.isGameOver()){
            this.displayCurrentTimeAndEnergy();
            mylocation.setVisited(true);
            numFastPasses--;
            backpack.setNumberFastPasses(numFastPasses);
            //Go to the end of ride menu that allows Mickey Searching
            MickeyLocationEndView  locationEndMenu = new MickeyLocationEndView(mylocation.getScene());
            locationEndMenu.display();}
        }catch (GameControlException ge) {
            this.console.println(ge.getMessage());
        }
        return false;
       } else {
           ErrorView.display(this.getClass().getName(),"You do not have any Fast Passes");
           return true;
       }
           
    }

    private void exploreRide() {
        try{
            //loading current game, location and get location number
        Game game = HiddenMickeys.getCurrentGame();
        int locationNum = game.getCurrentLocationNo();
        //LocationControl lc = new LocationControl();
        Location mylocation = LocationControl.getLocationByNumber(locationNum);
        //GameControl gc = new GameControl();
        //print a description of the ride
        String description = mylocation.getScene().getDescription();
        this.console.println(description);
            //update wait time
            int waitTime = mylocation.getScene().getWaitTime();
            int energyLevel;
            int timeRemaining;
            energyLevel = GameControl.updateEnergyLevels(waitTime);
            timeRemaining = GameControl.updateTimeRemaining(waitTime);
            if(!game.isGameOver()){
            this.displayCurrentTimeAndEnergy();
            mylocation.setVisited(true);
            //Go to the end of ride menu that allows Mickey Searching
            MickeyLocationEndView  locationEndMenu = new MickeyLocationEndView(mylocation.getScene());
            locationEndMenu.display();}
        }catch (GameControlException ge) {
            ErrorView.display(this.getClass().getName(),ge.getMessage());
        }
    }

   
}