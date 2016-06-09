/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import java.util.Scanner;

/**
 *
 * @author Hannah Mars
 */
public class GameMenuView {
    private String promptMessage;
    
public GameMenuView(){
    this.promptMessage = "\nWhat would you like to do?";
}

    public void displayGameMenuView() {
         boolean done = false; //set flag to not done
    
    do { //prompt for and get selected menu option
        displayMenu();
        String gameMenuOption = this.getGameMenuOption();
        if (gameMenuOption.toUpperCase().equals("Q"))  //user wants to quit
            return; //exit the game
        
        //this will do the requested action and display the next view
        done = this.doAction(gameMenuOption);
            
        } while(!done);
    }
    
     private String getGameMenuOption() {
        Scanner keyboard = new Scanner(System.in); //get in file for keyboard
        String value = ""; //value to be returned
        boolean valid = false; //initialize to not valid
        while (!valid) { //loop while an invalid value is entered
            
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine(); //get next line typed on keyboard
            value = value.trim(); //trim off leading and trailing blanks
            
            if (value.length() < 1) { //value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }
            break; //end the loop
        }
        return value; //return the value entered
    }

    private boolean doAction(String choice) {
        choice = choice.toUpperCase();
        System.out.println("The choice you entered is " + choice);
        switch (choice) {
            case "M": //view map or move
                this.mapAndMove();
                this.quitTheOption();
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
                this.displayHelpMenu();
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
        System.out.println("\n***mapAndMove()function called***");
    }

    private void exploreLocation() {
     String locationType;   
        //get the type of location that the user is currently on
        locationType = this.getLocationType();
        //R=Ride, S=Shop, F=Food
        switch (locationType) {
            case "R":
                //open the menu for a ride location 
                ExploreRideLocationView exploreRideView = new ExploreRideLocationView();
                exploreRideView.displayExploreRideLocationView();
                break;
            case "S":
                //open menu for a shop location
                ExploreShopLocationView exploreShopView = new ExploreShopLocationView();
                exploreShopView.displayExploreShopLocationView();
                break;
            case "F":
                //open menu for a food location
                break;
            default:
                System.out.println("Invalid Location Type");
                break;
         }

    }
    
    private String getLocationType() {
       //we can use this function for testing  R=Ride, S=Shop, F=Food
       //when testing your code, change the return value to your menu type 
       return "S";
    }
        
    private void viewBackpack() {
       BackpackView backpack = new BackpackView();
       backpack.displayBackpackView();
    }

    private void viewTime() {
        System.out.println("\n***viewTime()function called***");
    }

    private void energyLevel() {
        System.out.println("\n***energyLevel()function called***");
    }

    private void restAndRecharge() {
        System.out.println("\n***restAndRecharge()function called***");
    }

    private void saveGame() {
        System.out.println("\n***saveGame()function called***");
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayHelpMenu();
    }

    private void quitTheOption() {
         //change the prompt message temporarily
                this.promptMessage = "Enter Q to Return";
                String option = this.getGameMenuOption();
                //reset the prompt message
                this.promptMessage = "\nPlease enter your choice: ";
                //it doesn't matter what the user enters-- go back to the help menu
                this.doAction(option);
    }

     private void displayMenu(){
         System.out.println("\n"
            +"\n---------------------------------------------------"
            +"\n|  Game Menu                                      |"
            +"\n---------------------------------------------------"
            +"\nM - View Map or Move  (to move to new location)"
            +"\nE - Explore/enter the current location"
            +"\nB-  View backpack"
            +"\nT - View Time spent/Time remaining"
            +"\nL - View Energy Level"
            +"\nR - Rest for 15 minutes (charges Energy level +20%)"
            +"\nS - Save game"
            +"\nH - Help"
            +"\nQ - Quit"
            +"\n---------------------------------------------------");
     }
}

   

        