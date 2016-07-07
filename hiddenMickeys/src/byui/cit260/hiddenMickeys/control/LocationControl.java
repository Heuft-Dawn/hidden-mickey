/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.control;

import byui.cit260.hiddenMickeys.exceptions.LocationControlException;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import byui.cit260.hiddenMickeys.model.Map;
import byui.cit260.hiddenMickeys.view.ErrorView;
import byui.cit260.hiddenMickeys.view.ExploreFoodLocationView;
import byui.cit260.hiddenMickeys.view.ExploreRestView;
import byui.cit260.hiddenMickeys.view.ExploreRideLocationView;
import byui.cit260.hiddenMickeys.view.ExploreShopLocationView;
import byui.cit260.hiddenMickeys.view.FastPassStationLocationView;
import hiddenmickeys.HiddenMickeys;
import java.util.Collections;

/**
Author: Susan Allen
 */
public class LocationControl {
    
   public static int calcFastPassTime(int time) throws LocationControlException {
    /**
     * This function calculates fast pass time by dividing the 
     * current wait time in half and rounding it down to a 
     * 5 minute interval
     */   
       
	//check for negatives
       if (time < 0) {
            throw new LocationControlException ("Wait time cannot be negative.");
            }
       //check for blank values
	if (time == 0) {
            throw new LocationControlException ("Value must be present");
            }
        //check for values less than 5
	if (time < 5) {
            throw new LocationControlException ("Wait time must be at least 5 minutes.");
            }
	
        //calculate what half the time would be
        double halfTime = (double)time /2;
        
        //round the halfTime value 
        int roundHalfTime = (int)Math.round(halfTime);

        //find how many minutes the value is above the 5 minute time interval below it   
        int adjustment = roundHalfTime % 5;
        
        //adjust the rounded half time down to the 5 minute interval
        int fastPassTime = roundHalfTime - adjustment; 

        return fastPassTime;	
        }
 
   
   // author - Dawn Heuft
   
   public int calcEnergyUsed (int timeUsed, int curEnergy) throws LocationControlException {
       if (timeUsed < 5 || timeUsed > 120) { // check range
          throw new LocationControlException ("Energy cannot be negative.");
       }
      if (curEnergy < 1 || curEnergy > 300) { // check range
          throw new LocationControlException ("Energy must be greater than 1, but less than 300.");
      }
      int energyUsed = timeUsed/5;
      int level = curEnergy - energyUsed;
      curEnergy = level;
      
      if (curEnergy < 10){ //check energy level
          ErrorView.display(this.getClass().getName(),
                  "Caution energy level is below 10, replenish soon");
          return energyUsed; 
      }    
      return energyUsed;
      }
   
    public int getLocationsVisited() {
        Game game = HiddenMickeys.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        int countLocations = 0;
        for( int row = 0; row < locations.length; row++){
        for( int column = 0; column < locations[row].length; column++){
            if (locations[row][column].isVisited()) {
                countLocations++;
            }
    }
    }
        return countLocations;
    }
       public static int[] getLocationCoordinates(int locationNum) {
        // Get the game and locations    
       Game game = HiddenMickeys.getCurrentGame();
       Map map = game.getMap(); // retreive the map from game
       Location[][] locations = map.getLocations(); // retreive the locations from map
       int myRow = 0;
       int myColumn = 0;
       
          //search array for entered location
        for (int row = 0; row < locations.length; row++){
        for( int column = 0; column < locations[row].length; column++) {
            if (locations[row][column].getLocationNo()==(locationNum)) {
            myRow = row + 1;
            myColumn = column + 1;
            }
        }
        }
        // create temporary two dimensional array
        int[] coordArray = new int[2];
        coordArray[0] = myRow;
        coordArray[1] = myColumn;
        return coordArray;
     
    }

    public static String lookupLocationName(int locationNum) {
    Game game = HiddenMickeys.getCurrentGame();
    Map map = game.getMap();
    Location[][] locations = map.getLocations();
    String locationName = new String();
    
       for (Location[] location : locations) {
        for (Location location1 : location) {
            if (location1.getLocationNo() == locationNum) {
                locationName = location1.getScene().getName();
                break;
            }
        }
       }
        return locationName;
    }
    
    public static Location getLocationByNumber(int locationNum){
    Game game = HiddenMickeys.getCurrentGame();
    Map map = game.getMap();
    Location[][] locations = map.getLocations();
    Location myLocation = new Location();
    
       for (Location[] location : locations) {
        for (Location location1 : location) {
            if (location1.getLocationNo() == locationNum) {
                myLocation = location1;
                break;
            }
        }
       }
        return myLocation;
        
    }
    
    

    
}




