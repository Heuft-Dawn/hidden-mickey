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
import java.util.ArrayList;

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
               ErrorView.display(this.getClass().getName(),"/nInvalid choice try again");
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
            //Write the report header
            out.println("\nLOCATIONS VISITED REPORT");
            out.printf("%n%-5s%-35s%-15s","Loc#","Location Name","Mickey Found?");
            out.printf("%n%-5s%-35s%-15s","-----","-----------------------------------","-------------");
            
            //pull the data
            Game game = HiddenMickeys.getCurrentGame();
            Location[][] locations = game.getMap().getLocations();
            ArrayList<Mickey> mickeys = game.getBackpack().getMickeysCollected();
            //initialize needed variables 
            boolean mickeyFound;
            String mickeyFoundDisplay;
            int curLocationNum;
            
          //loop through all the locations
          for (Location[] location : locations) {
                for (Location location1 : location) {
                    curLocationNum = location1.getLocationNo();
                    //this.console.println(Integer.toString(curLocationNum));
                    mickeyFound = false;
                    mickeyFoundDisplay = "N";
                    //if the location has been visited, search the Mickeys collected to check for a match
                    if (location1.isVisited()) {
                        for (Mickey mickey: mickeys){
                            //this.console.println(Integer.toString(mickey.getLocationNum()));
                            //if there is a matching mickey location, set mickeyfound to true
                            if (mickey.getLocationNum() == curLocationNum){
                                mickeyFound=true;
                            }
                        } if(mickeyFound){mickeyFoundDisplay = "Y";}
                        //display the location in the report with the correct Mickey status
                        out.printf("%n%-5s%-35s%-15s", Integer.toString(curLocationNum), location1.getScene().getName(), mickeyFoundDisplay);
                    }
                }
          }
            out.println("\n\n ");
            //close the file
            try{
                if (out != null)
                 out.close();
                         
            } catch(Exception e) {
             ErrorView.display(this.getClass().getName(),"Error closing file");
             return;
             }
            this.console.println("\n\nThe Report has been saved.");
        }catch (IOException ex) {
            ErrorView.display(this.getClass().getName(),"I/0 Error: " + ex.getMessage());
        }
         
        
    
    }

    private void viewReport() {
        //report header
            this.console.println("\nLOCATIONS VISITED REPORT");
            this.console.printf("%n%-5s%-35s%-15s","Loc#","Location Name","Mickey Found?");
            this.console.println("\n-------------------------------------------------------------");
        //get the data
            Game game = HiddenMickeys.getCurrentGame();
            Location[][] locations = game.getMap().getLocations();
            ArrayList<Mickey> mickeys = game.getBackpack().getMickeysCollected();
        //initialize needed variables
            boolean mickeyFound;
            String mickeyFoundDisplay;
            int curLocationNum;
        //loop through the locations to find visited ones
        for (Location[] location : locations) {
                for (Location location1 : location) {
                    curLocationNum = location1.getLocationNo();
                    //this.console.println(Integer.toString(curLocationNum));
                    mickeyFound = false;
                    mickeyFoundDisplay = "N";
                    //if the location has been visited, check to see if a mickey was found there
                    if (location1.isVisited()) {
                        //search the mickey array
                        for (Mickey mickey: mickeys){
                            //this.console.println(Integer.toString(mickey.getLocationNum()));
                            if (mickey.getLocationNum() == curLocationNum){
                                mickeyFound=true;
                            }
                        }   //set the mickeyFoundDisplay value for the report
                        if(mickeyFound){mickeyFoundDisplay = "Y";}
                        //print the visited location on the report
                        this.console.printf("%n%-5s%-35s%-15s", Integer.toString(curLocationNum), location1.getScene().getName(), mickeyFoundDisplay);
                    }
                }
        }
            this.console.println("\n\n ");
      
    }
    }
    

