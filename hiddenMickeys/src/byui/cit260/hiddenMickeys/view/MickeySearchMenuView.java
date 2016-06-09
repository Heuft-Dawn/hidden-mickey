/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class MickeySearchMenuView {
    private String promptMessage;  
 
    
    
    public MickeySearchMenuView(){//constructor Function
    this.promptMessage = "\nEnter your choice:";
}

    public void displayMickeySearchMenuView() {
        boolean done = false; //set flag to not done
    
        do { //prompt for and get selected menu option
            displayMenu();
            String gameMenuOption = this.getMickeySearchMenuOption();
            if (gameMenuOption.toUpperCase().equals("Q"))  //user wants to quit
                return; //exit the game

            //this will do the requested action and display the next view
            done = this.doAction(gameMenuOption);

        } while(!done);
    }

     private String getMickeySearchMenuOption() {
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
        //System.out.println("The choice you entered is " + choice);
        if (choice.equals("V")) {
                //show the description for the ride
                this.displayRideDescription();
                //have the user enter q to continue with the search menu
                this.quitTheOption();
        }else if (choice.equals("Q")) {
                return false;
        }else {
                this.searchDescription(choice);
                
        }
        return false;
    }
    
     private void displayMenu(){
         System.out.println("\n"
            +"\n-----------------------------------------------------"
            +"\nInstructions"
            +"\n-----------------------------------------------------"
            +"\nEnter a location where you believe the Mickey is hidden."
            +"\nOR"
            +"\nV - View ride description again"
            +"\nQ - Exit Ride/ Stop Exploring"
            +"\n-----------------------------------------------------");
    
     }

    private void searchDescription(String choice) {
        System.out.println("\n***searchDescription()function called on " + choice + "***");
        System.out.println("\nSorry, no Mickey found there.");
    }

    private void quitTheOption() {
        //change the prompt message temporarily
                this.promptMessage = "Try again, or enter Q to quit:";
                //get the user input
                String option = this.getMickeySearchMenuOption();
                //reset the prompt message
                this.promptMessage = "\nEnter your choice: ";
                //do action for a "q"
                this.doAction(option);
    }

   private void displayRideDescription() {
        System.out.println("Here is the description of the ride...");
    }
     
    
}

