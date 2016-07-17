
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.LocationControl;
import byui.cit260.hiddenMickeys.control.MapControl;
import byui.cit260.hiddenMickeys.exceptions.MapControlException;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import byui.cit260.hiddenMickeys.model.Map;
import hiddenmickeys.HiddenMickeys;


public class MapAndMoveView extends View{
    
    public MapAndMoveView() {
        super("Using the map above\nEnter the location # to move to or"
              +"\nQ = Exit map\nW= view ride wait times.\n"
             );
    }
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        boolean returnToMenu = false;
        switch (choice) {
            case "W"://show wait times on rides
                this.displaySortedWaitTimes();
                this.quitTheOption();
                break;
            case "Q":
                break;
            default:
                int number = 0;
                try {
                number = Integer.parseInt(choice);
                } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(),
                        "\n***You must enter a valid number or option.");
                }
                if (number < 36 && number > 0) {
                this.goToLocation(number);
                break;
                } else {
                    ErrorView.display(this.getClass().getName(),
                            "Number entered is not a valid location.");  
                    returnToMenu = true;
                }
        }
        return !returnToMenu;
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
        String locationName;
          this.console.println("Ride Wait Times");
          this.console.println("-----------------------");
          for (int s=0;s<tmpLocations.length;s++){
            if(tmpLocations[s][0]> 0){
            locationName = LocationControl.lookupLocationName(tmpLocations[s][0]);
            this.console.println("Location #" + Integer.toString(tmpLocations[s][0]) + "(" + 
                    locationName + "): " + Integer.toString(tmpLocations[s][1]) + " min");
            }
          }
          
        
}  

    private void goToLocation(int number) {
        
         int[] coordArray = new int[2];//initialize array to store coordinates
         
         //get coordinates for new location
         //LocationControl lc = new LocationControl();//create location control object
         coordArray = LocationControl.getLocationCoordinates(number);//pass location num to function
         int newRow = coordArray[0];
         int newCol = coordArray[1];
         
         //get coordinates for current location
         Game game = HiddenMickeys.getCurrentGame();
         int curRow = game.getCurrentRow();//retrieve the current row location
         int curCol = game.getCurrentColumn();//retrieve the current column location
        
         //get the location name to display
         Location locationInfo = LocationControl.getLocationByNumber(number);
         String locationName = locationInfo.getScene().getName();
         
        MapControl mpcontrol = new MapControl();//create map control object
        try{
        int moveTime = mpcontrol.calcMoveTime(curRow, curCol, newRow, newCol);
         this.console.println("\nIt will take " + Integer.toString(moveTime) + " minutes to "
         + "get to " + locationName);
        } catch (MapControlException me) {
            this.console.println(me.getMessage());
        }
       //load proceed view
       ProceedView proceed = new ProceedView(number);
       proceed.display();
       
        
       
    }
         
     
    
     
}