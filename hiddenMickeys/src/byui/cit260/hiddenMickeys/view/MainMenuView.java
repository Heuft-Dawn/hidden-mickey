/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.GameControl;
import hiddenmickeys.HiddenMickeys;
import java.util.Scanner;

/**
 *
 * @author Hannah Mars
 */
public class MainMenuView {
    private String menu;
    private String promptMessage;
    
public MainMenuView() {
    this.promptMessage = "\nPlease enter your choice: ";
    //this.displayMenu();
}

public void displayMainMenuView() { //display the start program view
    
    boolean done = false; //set flag to not done
    
    do { //prompt for and get selected menu option
        
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
        displayMenu();
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
            case "N": //create and start a new game
                this.startNewGame();
                this.quitTheOption();
                break;
            case "G": //get and start an existing game
                this.startExistingGame();
                this.quitTheOption();
                break;   
            case "H": //display help menu
                this.displayHelpMenu();
                break;
            case "S": //save current game
                this.saveGame();
                this.quitTheOption();
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

    private void startNewGame() {
        //create new game
        GameControl.createNewGame(HiddenMickeys.getPlayer());
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayGameMenu();
    }

    private void startExistingGame() {
       System.out.println("\n***startExistingGame()function called***");
    }

    private void displayHelpMenu() {
       //display help menu
       // GameControl.createNewGame(HiddenMickeys.getPlayer());
        
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayHelpMenu();
    }

    private void saveGame() {
       System.out.println("\n***saveGame()function called***");
    }

    private void displayMenu() {
       System.out.println("\n"
        +"\n---------------------------------------------------"
        +"\n|  Main Menu                                      |"
        +"\n---------------------------------------------------"
        +"\nN - Start new game                                 "
        +"\nG - Get and start saved game"
        +"\nH - Get help on how to play the game"
        +"\nS - Save Game"
        +"\nQ - Quit"
        +"\n---------------------------------------------------");
    }
    
    private void quitTheOption(){
        String quit; //Variable used to return to the help menu
        do {
                    quit = this.promptForQuit();
                    if (quit.toUpperCase().equals("Q")) { //user wants to quit
                    this.displayMenu(); 
                    
                    return; //exit the screen & return
                    }
            } while (!quit.equals("Q"));
    }
    
     private String promptForQuit() {
        Scanner keyboard = new Scanner(System.in); //get in file for keyboard
        String value = ""; //value to be returned
        boolean valid = false; //initialize to not valid
        
        while (!valid) { //loop while an invalid value is entered
            System.out.println("\nEnter Q to Return:");
            
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
}
    
