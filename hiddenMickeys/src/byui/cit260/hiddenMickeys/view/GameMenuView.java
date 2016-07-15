/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.MapControl;
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
    super("---------------------------------------------------"
            +"\n|  Game Menu                                      |"
            +"\n---------------------------------------------------"
            +"\nM - View Map or Move  (to move to new location)"
            +"\nB-  View backpack"
            +"\nT - View Time remaining and Energy Level"
            +"\nV - View Report of Locations Visited"
            +"\nS - View Report of Shops and Resteraunts and their prices"
            +"\nH - Help"
            +"\nQ - Quit"
            +"\n---------------------------------------------------"
            +"\n\n\nWhat would you like to do?");
}

    @Override
     public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        Game game = HiddenMickeys.getCurrentGame();
        
        switch (choice) {
            case "M": //view map or move
                this.mapAndMove();
                if(game.isGameOver()) return true;
                break;
            case "B": //view Backpack
                this.viewBackpack();
                if(game.isGameOver()) return true;
                break;
            case "T": //view time spent/remaining
                this.viewTime();
                this.quitTheOption();
                break;
            case "V":
                this.locationVisitedReport();
                break;
            case "S":
                this.shopReport();
                break;
            case "H": //save current game
                this.showHelpMenu();
                break;
            case "Q":
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

    private void mapAndMove() {
        //display the map/grid
        displayMap();
        
        //display the locations
        displayLocations(4,30);
        
        //print the map key 
        String mapKey = "-----------------------------------------------------------------------------------------------"
                        +"\n|     Key: >>-Ride  ^^-Rest  $$-Shop  **-FastPass  ++-Food  ==-Visited  ##-CurrentLocation    |"
                        + "\n-----------------------------------------------------------------------------------------------";
        this.console.println(mapKey);
                            
        LocationControl locationControl = new LocationControl();
        
        this.console.println("You have visited " + Integer.toString(locationControl.getLocationsVisited()) + " location(s).");
        //pull up the map and move menu
        MapAndMoveView moveMenu = new MapAndMoveView();
        moveMenu.display();
        
    }

    private void exploreLocation() {
     //get the game to find the current location number
     Game game = HiddenMickeys.getCurrentGame();
     
     ProceedView pv = new ProceedView(game.getCurrentLocationNo());//get the location control
     
     //the below function will check the location type and go to the appropriate menu
     pv.exploreLocationType();
    }
    
    private String getLocationType() {
       //we can use this function for testing  R=Ride, S=Shop, F=Food
       //when testing your code, change the return value to your menu type 
       return "S";
    }
        
    private void viewBackpack() {
       BackpackView backpack = new BackpackView();
       backpack.display();
           }

    private void viewTime() {
        this.displayCurrentTimeAndEnergy();
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
          this.console.print("  |");
          for( Land land : Land.values()){
            tmpString = " " + land + "     ";
            divLine = divLine + "------------------";
            tmpString = tmpString.substring(0,15);//column = 0; column < Land.values().length; column++){
            this.console.print(tmpString + " |"); // print col numbers to side of map
          }
          this.console.println();
          for( int row = 0; row < locations.length; row++){
            for( int column = 0; column < locations[row].length; column++){
              typeSymbol = locations[row][column].getScene().getMapSymbol();  
              
              if(locations[row][column].getLocationNo() == game.getCurrentLocationNo() ){
                typeSymbol = "#"; // can be stars or whatever these are indicators showing visited
                
              }
              else if(locations[row][column].isVisited()){
                 typeSymbol = "="; // can be stars or whatever these are indicators showing visited
                 }
              leftIndicator = typeSymbol+ typeSymbol + "   ";
              rightIndicator = "    " + typeSymbol + typeSymbol;
              this.console.print("| | |"); // start map with a |
              if(locations[row][column].getLocationNo()>= 10){
              rightIndicator = rightIndicator.substring(rightIndicator.length()-5);}
              if(locations[row][column].getScene() == null)
                this.console.print(leftIndicator + "??" + rightIndicator);
              else
                this.console.print(leftIndicator + locations[row][column].getLocationNo() + rightIndicator);
            }
            this.console.println("| | |");
            this.console.println(divLine);
          }
        }catch (Exception e) {
          ErrorView.display(this.getClass().getName(),e.getMessage());
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
            ErrorView.display(this.getClass().getName(),me.getMessage());
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
             this.console.println(tmpString);
        }


    }

    private void locationVisitedReport() {
         LocationVisitedReportView reportMenu = new LocationVisitedReportView();
        reportMenu.display();
    }

    private void shopReport() {
        ShopNamesAndPricesView shopReport = new ShopNamesAndPricesView();
        shopReport.display();
    }

    
}

   

        
