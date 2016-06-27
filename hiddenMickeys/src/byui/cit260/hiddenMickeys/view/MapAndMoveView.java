/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import byui.cit260.hiddenMickeys.model.Map;
import hiddenmickeys.HiddenMickeys;

/**
 *
 * @author Hannah Mars
 */
public class MapAndMoveView extends View{
    
    public MapAndMoveView() {
        super("\n\nUsing the map above, enter the location # to move to\nor"
              +"\nQ = exit map, W= view ride wait times.");
    }
    
    /*
    Ladies, I don't know how many locations we will have, or what their names 
    will be so for right now, I am just doing it like this. I know this will cause
    a little more work later, but this is what we have to roll with right now.
    */
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "1": //move to location 1
                this.locationOne();
                break;
            case "2": //move to location 2
                this.locationTwo();
                break;   
            case "3": //move to location 3
                this.locationThree();
                break;
            case "4": //move to location 4
                this.locationFour();
                break;
            case "5": //move to location 5
                this.locationFive();
                break;
            case "6": //move to location 6
                this.locationSix();
                break;
            case "7": //move to location 7
                this.locationSeven();
                break;
            case "8": //move to locatoin 8
                this.locationEight();
                break;
            case "W"://show wait times on rides
                this.displaySortedWaitTimes();
                break;
            case "Q":
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

    private void locationOne() {
        System.out.println("locationOne() function called");
    }

    private void locationTwo() {
        System.out.println("locationTwo() function called");
    }

    private void locationThree() {
        System.out.println("locationThree() function called");    
    }

    private void locationFour() {
        System.out.println("locationFour() function called");
    }

    private void locationFive() {
        System.out.println("locationFive() function called");
    }

    private void locationSix() {
        System.out.println("locationSix() function called");
    }

    private void locationSeven() {
        System.out.println("locationSeven() function called");
    }

    private void locationEight() {
        System.out.println("locationEight() function called");
    }

 
     public void displaySortedWaitTimes(){
       // Get the game and locations    
        Game game = HiddenMickeys.getCurrentGame();
         Map map = game.getMap(); // retreive the map from game
         Location[][] locations = map.getLocations(); // retreive the locations from map 
         
        //get number of locations 
        int noLocations = map.getColumnCount()* map.getRowCount(); 
         
         //create a 2-d dimensional array with all the locations & wait times
        int[][] tmpLocations = new int[noLocations+1][2];
        int i=0;
         for( int row = 0; row < locations.length; row++){
                for( int column = 0; column < locations[row].length; column++){
                    if(locations[row][column].getScene().getLocationType().equals("R")){
                    tmpLocations[i][0]= (locations[row][column].getLocationNo());
                    tmpLocations[i][1]= (locations[row][column].getScene().getWaitTime())  ;     
                    i++;
                    }
                }
        }
         
         //sort the array by 2nd column
        java.util.Arrays.sort(tmpLocations, 
            new java.util.Comparator<int[]>(){
                public int compare(int[]a,int[]b){
                    return a[1]-b[1];
                }
        }); 
         
        //display the results
          System.out.println("Ride Wait Times");
          System.out.println("-----------------------");
          for (int s=0;s<tmpLocations.length;s++){
            if(tmpLocations[s][0]> 0){  
            System.out.println("Location #" + Integer.toString(tmpLocations[s][0]) + ": " + Integer.toString(tmpLocations[s][1]) + " min");
            }
          }
          
        
}  
         
     
    
     
}