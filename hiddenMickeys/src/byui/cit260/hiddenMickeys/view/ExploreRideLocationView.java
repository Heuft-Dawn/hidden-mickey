/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.LocationControl;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import hiddenmickeys.HiddenMickeys;


/**
 *
 * @author Administrator
 */
public class ExploreRideLocationView extends View {
    
    public ExploreRideLocationView(){
        super("\n"
            +"\n------------------------------"
            +"\nRide Menu"
            +"\n------------------------------"
            +"\nP - Use Fast Pass"
            +"\nY - Continue "
            +"\nQ - Return to Game Menu"
            +"\n------------------------------"
            +"\n\n\nThe current Ride wait time is _____.  What would you like to do?");
}

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "P": //Use FastPass
                this.useFastPass();
                
                break;
            case "Y": //Continue and explore
                this.exploreRide();
                break;   
            case "N": //go back to menu
                break;
            case "Q": //go back to menu
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return true;
    }

  

    private void useFastPass() {
        System.out.println("\nYou used a Fast Pass.\n");
        
        //loading current game, location and get location number
        Game game = HiddenMickeys.getCurrentGame();
        int locationNum = game.getCurrentLocationNo();
        LocationControl lc = new LocationControl();
        Location mylocation = lc.getLocationByNumber(locationNum);
        
        //print a description of the ride
        String description = mylocation.getScene().getDescription();
        System.out.println(description);
        
        //Go to the end of ride menu that allows Mickey Searching
        MickeyLocationEndView  locationEndMenu = new MickeyLocationEndView();
        locationEndMenu.display();
    }

    private void exploreRide() {
        //this will update the player's amount of time spent
        this.updateTime();
        //this will display a description for the user - telling them what they experienced during the ride
        this.getRideDescription();
        //This calls a menu that gives the player a chance to search for Mickeys or exit.
        MickeyLocationEndView  locationEndMenu = new MickeyLocationEndView();
        locationEndMenu.display();
                
 
    }

    private void getRideDescription() {
       System.out.println("Here is a description of the ride you just went on.  You saw"
                    +"\nTHIS and THIS and THIS and it was a blast.");
    }

    private void updateTime() {
       System.out.println("\n***updateTime()function called***");
    }
}