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
public class ExploreRideLocationView {
   private String promptMessage;  
 
    
    
    public ExploreRideLocationView(){
    this.promptMessage = "\nThe current Ride wait time is _____.  What would you like to do?";
}

    public void displayExploreRideLocationView() {
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
        // remove quitTheOption function if the coding for the next menu is complete
        switch (choice) {
            case "P": //Use FastPass
                this.useFastPass();
                break;
            case "Y": //Continue and explore
                this.exploreRide();
                break;   
            case "N": //go back to menu
                break;
            case "Q": //go back to menu
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

   private void displayMenu(){
         System.out.println("\n"
            +"\n------------------------------"
            +"\nRide Menu"
            +"\n------------------------------"
            +"\nP - Use Fast Pass"
            +"\nY - Continue "
            +"\nQ - Return to Game Menu"
            +"\n------------------------------");
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

    private void useFastPass() {
        System.out.println("\nYou used a Fast Pass.\n");
        //print a description of the ride
        this.getRideDescription();
        //Go to the end of ride menu that allows Mickey Searching
        MickeyLocationEndView  locationEndMenu = new MickeyLocationEndView();
        locationEndMenu.displayMickeyLocationEndView();
    }

    private void exploreRide() {
        //this will update the player's amount of time spent
        this.updateTime();
        //this will display a description for the user - telling them what they experienced during the ride
        this.getRideDescription();
        //This calls a menu that gives the player a chance to search for Mickeys or exit.
        MickeyLocationEndView  locationEndMenu = new MickeyLocationEndView();
        locationEndMenu.displayMickeyLocationEndView();
                
 
    }

    private void getRideDescription() {
       System.out.println("Here is a description of the ride you just went on.  You saw"
                    +"\nTHIS and THIS and THIS and it was a blast.");
    }

    private void updateTime() {
       System.out.println("\n***updateTime()function called***");
    }
}