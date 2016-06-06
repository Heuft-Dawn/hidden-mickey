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
class GameMenuView {
    private String promptMessage;
    
    public GameMenuView() {
    this.promptMessage = "\nPlease enter your choice: ";
    //this.displayMenu();
}

    public void displayGameMenu() {
        boolean done = false; //set flag to not done
    
        do { //prompt for and get selected menu option
            displayMenu();
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q"))  //user wants to quit
                return; //exit the game

            //this will do the requested action and display the next view
            done = this.doAction(menuOption);
            
        } while(!done);
    }
    
        private String getMenuOption() {
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
        
        switch (choice) {
            case "M": //Go to Map and move view
                this.displayMapView();
                break;
            case "E": //Explore current location
                this.exploreCurrentLocation();
                break;   
            case "B": //view backpack
                this.displayBackpackView();
                break;
            case "T": //view Time Spent/Time Remaining
                 this.displayTimeStats();
                break;
            case "L": //view energy level
                 this.viewEnergyLevel();
                 break;
            case "C": //View Mickey Heads collected
                this.displayMickeyHeads();
                break;
            case "R": //Rest
                this.rest();
                break;   
            case "S": //Save Game
                this.saveGame();
                break;
            case "H": //Help menu
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
    
    private void displayMenu() {
       System.out.println("/n"
            +   "\n-------------------------------------------------------"
            +"\nGame Menu"
            +"\n-------------------------------------------------------"
            +"\nM - View Map or Move  (to move to new location)"
            +"\nE - Explore/enter the current location"
            +"\nB-  View backpack"
            +"\nT - View Time spent/Time remaining"
            +"\nL - View Energy Level"
            +"\nC - View Mickey Heads collected"
            +"\nR - Rest for 15 minutes (charges Energy level +20%)"
            +"\nS - Save game"
            +"\nH - Help"
            +"\nQ - Quit"
            +"\n-------------------------------------------------------");
    }
   
    private void quitTheOption(){
       //change the prompt message temporarily
                this.promptMessage = "Enter Q to Return";
                String option = this.getMenuOption();
                //reset the prompt message
                this.promptMessage = "\nPlease enter your choice: ";
                //it doesn't matter what the user enters-- go back to the help menu
                this.doAction(option);
    }

    private void displayMapView() {
        System.out.println("displayMapView function called");
    }

    private void exploreCurrentLocation() {
        System.out.println("exploreCurrentLocation function called");
        
    }

    private void displayBackpackView() {
        System.out.println("displayBackpackView function called");
    }

    private void displayTimeStats() {
       System.out.println("displayTimeStats function called");
    }

    private void viewEnergyLevel() {
       System.out.println("viewEnergyLevel function called");
    }

    private void displayMickeyHeads() {
       System.out.println("displayMickeyHeads function called");
    }

    private void rest() {
       System.out.println("rest function called");
    }

    private void saveGame() {
       System.out.println("saveGame function called");
    }

    private void displayHelpMenu() {
       
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayHelpMenu();
    }
}