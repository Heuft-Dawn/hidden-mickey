/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.LocationControl;
import byui.cit260.hiddenMickeys.control.MapControl;
import byui.cit260.hiddenMickeys.exceptions.MapControlException;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import byui.cit260.hiddenMickeys.model.Map;
import hiddenmickeys.HiddenMickeys;

/**
 *
 * @author Dawn
 */
public class ProceedView extends View {
    private int locationNum;
    
    public ProceedView(int locationNum){
        super("Continue? (Y/N)");
        this.locationNum = locationNum;
    }

       
    @Override
       public boolean doAction(String choice){
       choice = choice.toUpperCase();
       boolean returnToMenu = false;
       switch(choice){
           case "Y":
               this.movePlayer();
               break;
           case "N":
               break;   
           case "Q":
               break;
           default:
               System.out.println("/nInvalid choice try again");
               returnToMenu = true;
               break;
       }
       return !returnToMenu;
   } {
    
}

    private void movePlayer() {
        Game game = HiddenMickeys.getCurrentGame(); // retreive the game
        int curRow = game.getCurrentRow();
        int curColumn = game.getCurrentColumn();
        
         // create array to hold location coordinates
        int[] coordArray = new int[2];
        
        int newRow = 0;
        int newColumn = 0;
        // get location coordinates
        LocationControl lc = new LocationControl();
        coordArray = lc.getLocationCoordinates(this.locationNum);
        
        newRow = coordArray[0];
        newColumn = coordArray[1];
        
        //move player
        
        game.setCurrentRow(newRow);
        game.setCurrentColumn(newColumn);
        game.setCurrentLocationNo(this.locationNum);
        System.out.println("Player will now move to " + Integer.toString(this.locationNum) + ".");
        
        //update time left in game
        MapControl mc = new MapControl();
        int moveTime = 0;
        try {
        moveTime = mc.calcMoveTime(curRow, curColumn, newRow, newColumn);
        int curTimeRemain = game.getTimeRemaining();
        game.setTimeRemaining(curTimeRemain - moveTime);
        curTimeRemain = game.getTimeRemaining();
        System.out.println ("You have " + Integer.toString(curTimeRemain) + " minutes left before your time expires.");
         } catch (MapControlException me) {
            System.out.println(me.getMessage());
         }
       // explore the location based on the location type 
       this.exploreLocationType();
    
    }
    
    
    public void exploreLocationType() {
    LocationControl lc = new LocationControl();    
        // determine whether location is food, ride or shop
    Location myloc = lc.getLocationByNumber(this.locationNum);
    String locationType = myloc.getScene().getLocationType();
    
    switch (locationType) {
            case "R": //Ride
                int waitTime = myloc.getScene().getWaitTime();
                int fastPassTime = lc.calcFastPassTime(waitTime);
                ExploreRideLocationView rideView = new ExploreRideLocationView(waitTime, fastPassTime);
                rideView.display();
                break;
            case "T": //Rest View
                ExploreRestView restView = new ExploreRestView();
                restView.display();
                break;  
            case "S": //Shop View
                ExploreShopLocationView shopView = new ExploreShopLocationView(myloc.getScene());
                shopView.display();
                break;
            case "P": //Fast Pass View
                FastPassStationLocationView fastPassView = new FastPassStationLocationView();
                fastPassView.display();
                break;
            case "F": //Food View
                ExploreFoodLocationView foodView = new ExploreFoodLocationView();
                foodView.display();
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
    }

   }
