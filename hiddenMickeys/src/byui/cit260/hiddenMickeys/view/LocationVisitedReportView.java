/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import byui.cit260.hiddenMickeys.model.Mickey;
import hiddenmickeys.HiddenMickeys;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Administrator
 */
public class LocationVisitedReportView extends View {
    
    //constructor function
    public LocationVisitedReportView(){
        super("Would you like to (S) Save the report or (V) View the report?");
}   

    @Override
    public boolean doAction(String choice) {
       choice = choice.toUpperCase();
       boolean returnToMenu = false;
       switch(choice){
           case "S":
               this.saveReport();
               break;
           case "V":
               this.viewReport();
               this.quitTheOption();
               break;   
           case "Q":
               break;
           default:
               System.out.println("/nInvalid choice try again");
               returnToMenu = true;
               break;
       }
       return !returnToMenu;
   }

    private void saveReport() {
      //prompt for and get the name of the file to save the game in
      this.console.println("\n\nEnter the file path for where the report "
      + "is to be saved.");
      String filePath = this.getInput();
      
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.println("\nLOCATIONS VISITED REPORT");
            out.printf("%n%-5s%-35s%-15s","Loc#","Location Name","Mickey Found?");
            out.printf("%n%-5s%-35s%-15s","-----","-----------------------------------","-------------");
            Game game = HiddenMickeys.getCurrentGame();
            Location[][] locations = game.getMap().getLocations();
            Mickey[] mickeys = game.getBackpack().getMickeysCollected();
            boolean mickeyFound;
            String mickeyFoundDisplay;
            int curLocationNum;
            for (int row = 0; row < locations.length; row++){
                for( int column = 0; column < locations[row].length; column++){ 
                    curLocationNum = locations[row][column].getLocationNo();
                    //this.console.println(Integer.toString(curLocationNum));
                    mickeyFound = false;
                    mickeyFoundDisplay = "N";
                    if(locations[row][column].isVisited()){
                                           
                           for (Mickey mickey: mickeys){
                           //this.console.println(Integer.toString(mickey.getLocationNum()));
                           if (mickey.getLocationNum() == curLocationNum){
                               mickeyFound=true;
                            }
                           }
                    if(mickeyFound){mickeyFoundDisplay = "Y";}       
                    out.printf("%n%-5s%-35s%-15s",Integer.toString(curLocationNum),locations[row][column].getScene().getName(), mickeyFoundDisplay);
                    
                    }
                 }
            }
            out.println("\n\n ");
            try{
                if (out != null)
                 out.close();
                         
            } catch(Exception e) {
             System.out.println("Error closing file");
             return;
             }
            this.console.println("\n\nThe Report has been saved.");
        }catch (IOException ex) {
            this.console.println("I/0 Error: " + ex.getMessage());
        }
         
        
    
    }

    private void viewReport() {
            this.console.println("\nLOCATIONS VISITED REPORT");
            this.console.printf("%n%-5s%-35s%-15s","Loc#","Location Name","Mickey Found?");
            this.console.println("\n-------------------------------------------------------------");
            Game game = HiddenMickeys.getCurrentGame();
            Location[][] locations = game.getMap().getLocations();
            Mickey[] mickeys = game.getBackpack().getMickeysCollected();
            boolean mickeyFound;
            String mickeyFoundDisplay;
            int curLocationNum;
            for (int row = 0; row < locations.length; row++){
                for( int column = 0; column < locations[row].length; column++){ 
                    curLocationNum = locations[row][column].getLocationNo();
                    //this.console.println(Integer.toString(curLocationNum));
                    mickeyFound = false;
                    mickeyFoundDisplay = "N";
                    if(locations[row][column].isVisited()){
                                           
                           for (Mickey mickey: mickeys){
                           //this.console.println(Integer.toString(mickey.getLocationNum()));
                           if (mickey.getLocationNum() == curLocationNum){
                               mickeyFound=true;
                            }
                           }
                    if(mickeyFound){mickeyFoundDisplay = "Y";}       
                    this.console.printf("%n%-5s%-35s%-15s",Integer.toString(curLocationNum),locations[row][column].getScene().getName(), mickeyFoundDisplay);
                    
                    }
                 }
            }
            this.console.println("\n\n ");
      
    }
    }
    

