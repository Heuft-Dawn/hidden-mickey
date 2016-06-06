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
public class HelpMenuView {
private String promptMessage;
    
public HelpMenuView() {//Constructor Function
    this.promptMessage = "\nWhat would you like help with? ";
    
}
    

public void displayHelpMenu() {
    
    boolean done = false; //set flag to not done
    
    do { //prompt for and get selected menu option
        this.displayMenu();
        String helpMenuOption = this.getHelpMenuOption();
        if (helpMenuOption.toUpperCase().equals("Q")) { //user wants to quit
            System.out.println("\n------------------------"
                               +"\nExiting Help Menu"
                               +"\n------------------------");
            return; //exit the game
        }
        //this will do the requested action and display the next view
        done = this.doAction(helpMenuOption);
            
        } while(!done);
    }       

    private String getHelpMenuOption() {
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
            case "G": //goal/objective of the game
                this.displayGameGoal();
                break;
            case "M": //how to move
                this.displayHowMove();
                break;   
            case "E": //check energy level
                this.displayHowCheckEnergy();
                break;
            case "T": //check time remaining
                this.displayHowCheckTime();
                break;
            case "R": //recharge energy
                this.displayHowRechargeEnergy();
                break;
            case "S": //search for Mickey Heads
                this.displayHowSearch();
                break;
            case "Q": //exit this portion
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

    private void displayGameGoal() {
    
        System.out.println("\n"
            +"\n   The objective of the game is to find 10 Hidden Mickeys.  You must do this before "
            +"\nyou run out of time and energy."
            +"\n"
            +"\n  Mickey Heads are located within rides and shopping locations.  While exploring "
            +"\nthese locations, you will be given opportunities to search for the Mickey Heads. "
            +"\nThere will be 1 or 0 Mickey heads at each location. Once you have found 10, the game"
            +"\nends."
            +"\n"
            +"\n   You begin the game with 600 minutes and 100% energy.  The game ends when the   "
            +"\nminutes remaining is 0, or the energy percent reaches 0%.  "
            +"\n"                
            +"\n   When you move to a new location in the game, the time it will to move will be given"
            +"\nto you.  If you decide to move, the minutes will be deducted from your time remaining.  "
            +"\nWhen you choose to go on a ride, the line wait-time will also be deducted from your "
            +"\ntime remaining."
            +"\n  "
            +"\n   Throughout the game your energy level will decrease 1% for every 5 minutes in the "
            +"\npark. You may recharge the energy by eating a snack at a snack location, by resting, "
            +"\nor by using emergency food contained in your backpack.  "
            +"\n  ");
            
        this.quitTheOption();
            
    }
    
   

    private void displayHowMove() {
    String quit; //Variable used to return to the help menu
       System.out.println("\n"
        +"\n   To move to a new location in the game, enter an 'M' from the Game Menu. A map will"
        +"\nthen be displayed.  Enter the location number of the location that you wish to move to"
        +"\nand the program will tell you how much time it will take to move to that location.  If"
        +"\nyou decide to move, you will confirm that you would like to move.  Your map position"
        +"\nwill then change to the location that you entered."
        +"\n");
        this.quitTheOption();
    }

    private void displayHowCheckEnergy() {
    String quit; //Variable used to return to the help menu
        System.out.println("\n"
        +"\nTo check energy levels, enter an 'L' from the Game Menu screen."
        +"\n"
        + "\n  Your current energy level will be displayed."
        +"\n");
         this.quitTheOption();
    }

    private void displayHowCheckTime() {
    String quit; //Variable used to return to the help menu
        System.out.println("\n"
        +"\nTo check time remaining and time spent, enter a 'T' from the Game Menu screen.  "
        +"\n"
        +"\nYour Total Time Spent and Total Time Remaining will be displayed."
        +"\n");
        this.quitTheOption();
    }

    private void displayHowRechargeEnergy() {
    String quit; //Variable used to return to the help menu
        System.out.println("\n"
        +"\nEnergy may be recharged any of the following 3 ways:"
        +"\n"
        +"\n1)- View your Backpack by entering a 'B' from the Game Menu.  If you have an emergency"
        +"\nsnack or emergency water remaining, you may use one of those to recharge energy."
        +"\n	"
        +"\n2)- Move to a snack location and purchase a snack.  A snack will recharge energy."
        +"\n    "
        +"\n3)- Enter an 'R' from the Game Menu and take the option to rest for 15 minutes. This " 
        +"\nwill recharge your energy by 20."
	+"\n    ");
        this.quitTheOption();
    }

    private void displayHowSearch() {
    String quit; //Variable used to return to the help menu
        System.out.println("\n"
        +"\n   When exploring rides or store locations, you will be given the option to 'Search  "
        +"\nfor Mickey Head.'  If you choose to search, you will enter guesses that are words"
        +"\nand objects contained withinthe ride description where you believe a Mickey Head  " 
        +"\ncould be."
	+"\n    "
        +"\n   Mickey Heads will be hidden on objects that are mentioned in the description"
        +"\n	"
        +"\n   A helpful strategy would be to find nouns within the description and use those"
        +"\nas guesses."
	+"\n    ");
        this.quitTheOption();
    }

    private void quitTheOption(){
        //change the prompt message temporarily
                this.promptMessage = "Enter Q to Return";
                String option = this.getHelpMenuOption();
                //reset the prompt message
                this.promptMessage = "\nWhat would you like help with? ";
                //it doesn't matter what the user enters-- go back to the help menu
                this.doAction(option);
    }
  
      private void displayMenu() {
       System.out.println("\n"
        + "\n---------------------------------------------------"
        +"\n|  Help Menu                                      |"
        +"\n---------------------------------------------------"
        +"\nG - What is the goal/objective of the game?"
        +"\nM - How to move"
        +"\nE - How to check energy levels"
        +"\nT - How to check time remaining"
        +"\nR - How to re-charge energy"
        +"\nS - How to search for Mickey Heads"
        +"\nQ - Return to previous screen"
        +"\n---------------------------------------------------" );
    }
}
