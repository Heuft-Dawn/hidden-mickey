/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.MapControl;
import byui.cit260.hiddenMickeys.control.BackpackControl;
import byui.cit260.hiddenMickeys.control.LocationControl;
import byui.cit260.hiddenMickeys.exceptions.MapControlException;
import byui.cit260.hiddenMickeys.model.*;
import hiddenmickeys.HiddenMickeys;
/**
 *
 * @author Hannah Mars
 */
public class GameMenuView extends View {
    
public GameMenuView(){
    super("\n"
            +"\n---------------------------------------------------"
            +"\n|  Game Menu                                      |"
            +"\n---------------------------------------------------"
            +"\nM - View Map or Move  (to move to new location)"
            +"\nE - Explore/enter the current location"
            +"\nB-  View backpack"
            +"\nT - View Time spent/Time remaining"
            +"\nL - View Energy Level"
            +"\nR - Rest for 15 minutes"
            +"\nS - Save game"
            +"\nH - Help"
            +"\nQ - Quit"
            +"\n---------------------------------------------------"
            +"\n\n\nWhat would you like to do?");
}

    @Override
     public boolean doAction(String choice) {
        choice = choice.toUpperCase();
       // System.out.println("The choice you entered is " + choice);
        switch (choice) {
            case "M": //view map or move
                this.mapAndMove();
                break;
            case "E": //explore/enter current location
                this.exploreLocation();
                break;   
            case "B": //view Backpack
                this.viewBackpack();
                break;
            case "T": //view time spent/remaining
                this.viewTime();
                this.quitTheOption();
                break;
            case "L": //view energy level
                this.energyLevel();
                this.quitTheOption();
                break;
            case "R": //rest for 15 minutes (charges energy level +20)
                this.restAndRecharge();
                this.quitTheOption();
                break;
            case "S": //save current game
                this.saveGame();
                this.quitTheOption();
                break;
            case "H": //save current game
                this.showHelpMenu();
                break;
            case "Q":
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

    private void mapAndMove() {
        displayMap();
        
        displayLocations(4,30);
        LocationControl locationControl = new LocationControl();
        System.out.println("\nYou have visited " + Integer.toString(locationControl.getLocationsVisited()) + " locations.");
        //pull up the map and move menu
        MapAndMoveView moveMenu = new MapAndMoveView();
        moveMenu.display();
        
    }

    private void exploreLocation() {
     //get the game to find the current location number
     Game game = HiddenMickeys.getCurrentGame();
     
     ProceedView pv = new ProceedView();//get the location control
     
     //the below function will check the location type and go to the appropriate menu
     pv.exploreLocationType(game.getCurrentLocationNo());
    }
    
    private String getLocationType() {
       //we can use this function for testing  R=Ride, S=Shop, F=Food
       //when testing your code, change the return value to your menu type 
       return "S";
    }
        
    private void viewBackpack() {
       BackpackView backpack = new BackpackView();
       backpack.display();
        System.out.println("\n***viewBackpack()function called***");
    }

    private void viewTime() {
        System.out.println("\n***viewTime()function called***");
    }

    private void energyLevel() {
        System.out.println("\n***energyLevel()function called***");
    }

    private void restAndRecharge() {
        RestAndRechargeView restMenu = new RestAndRechargeView();
        restMenu.display();
    }

    private void saveGame() {
        System.out.println("\n***saveGame()function called***");
    }

    private void showHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

   
 public void displayMap() {
        String leftIndicator;
        String rightIndicator;
        //tmpString used to build equal column widths
        String tmpString ;
        String divLine = new String();
        String typeSymbol;
        int locationNo = 0;
        
        
        Game game = HiddenMickeys.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        try {
          System.out.print("  |");
          for( Land land : Land.values()){
            tmpString = " " + land + "     ";
            divLine = divLine + "------------------";
            tmpString = tmpString.substring(0,15);//column = 0; column < Land.values().length; column++){
            System.out.print(tmpString + " |"); // print col numbers to side of map
          }
          System.out.println();
          for( int row = 0; row < locations.length; row++){
            for( int column = 0; column < locations[row].length; column++){
              typeSymbol = locations[row][column].getScene().getMapSymbol();  
              
              if(locations[row][column].getLocationNo() == game.getCurrentLocationNo() ){
                typeSymbol = "#"; // can be stars or whatever these are indicators showing visited
                
              }
              else if(locations[row][column].isVisited()){
                 typeSymbol = "^"; // can be stars or whatever these are indicators showing visited
                 }
              leftIndicator = typeSymbol+ typeSymbol + "   ";
              rightIndicator = "    " + typeSymbol + typeSymbol;
              System.out.print("| | |"); // start map with a |
              if(locations[row][column].getLocationNo()>= 10){
              rightIndicator = rightIndicator.substring(rightIndicator.length()-5);}
              if(locations[row][column].getScene() == null)
                System.out.print(leftIndicator + "??" + rightIndicator);
              else
                System.out.print(leftIndicator + locations[row][column].getLocationNo() + rightIndicator);
            }
            System.out.println("| | |");
            System.out.println(divLine);
          }
        }catch (Exception e) {
          System.out.println("Error");
        }
       
}
    public void displayLocations(int numColumns, int colWidth) {
       
        // Get the game and locations    
        Game game = HiddenMickeys.getCurrentGame();
         Map map = game.getMap(); // retreive the map from game
         Location[][] locations = map.getLocations(); // retreive the locations from map     

        //get the number of locations in the map
        int noLocations = map.getColumnCount()* map.getRowCount();
        String tmpString; 
        String tmpName;
        
        //create a 1 dimensional array with all the location
        String[] tmpLocations = MapControl.getLocationList(map.getLocations(), noLocations);
        int numRows = 0;
        //run function that calculatesthe number of rows there needs to be per display column
        try {
         numRows = MapControl.calcRowsPerColumn(noLocations, numColumns);
         } catch (MapControlException me) {
            System.out.println(me.getMessage());
        }
        
        //Create an array with the correct number of rows and columns
        String[][] displayArray = new String[numColumns][numRows];

        //populate the display Array with the locations
         int i=0;
         for(int y = 0; y < numColumns; y++){
             for(int x = 0 ; x < numRows ; x++){
                 if (i < tmpLocations.length){
                 displayArray[y][x] = tmpLocations[i];}
                 i++;
             }
         }

         //Display the new array
        for(int y = 0; y < numRows; y++){
            tmpString = "";
            //one row at a time,display the location number and name for each column
             for(int x = 0 ; x < numColumns ; x++){
                if (displayArray[x][y] == null) {
                    tmpString += ""; }
                else{
                    tmpName = Integer.toString((numRows*x) + (y+1));
                    tmpName += " - " + displayArray[x][y] + "                              ";
                    tmpString += tmpName.substring(0,colWidth);
                }
                 }
             System.out.println(tmpString);
        }


    }

    
}

   

        
