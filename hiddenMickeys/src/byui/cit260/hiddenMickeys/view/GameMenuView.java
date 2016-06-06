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

    public void displayGameMenu() {
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
     private String getGameMenuOption() {
        Scanner keyboard = new Scanner(System.in); //get in file for keyboard
        String value = ""; //value to be returned
        boolean valid = false; //initialize to not valid
        displayGameMenu();
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
            case "M": //view map or move
                this.mapAndMove();
                this.quitTheOption();
                break;
            case "E": //explore/enter current location
                this.exploreLocation();
                this.quitTheOption();
                break;   
            case "B": //view Backpack
                this.viewBackpack();
                this.quitTheOption();
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
        System.out.println("\n***exploreLocation()function called***");
    }

    private void viewBackpack() {
        System.out.println("\n***viewBackpack()function called***");
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
        System.out.println("\n***displayHelpMenu()function called***");
    }

    private void quitTheOption() {
        System.out.println("\n***quitTheOption()function called***");
    }
}