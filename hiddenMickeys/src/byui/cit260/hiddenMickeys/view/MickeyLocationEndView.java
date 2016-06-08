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
public class MickeyLocationEndView {
   private String promptMessage; 
    //Constructor function
    public MickeyLocationEndView(){//constructor Function
    this.promptMessage = "\nEnter your choice";
}

    public void displayMickeyLocationEndView() {
        boolean done = false; //set flag to not done
    
        do { //prompt for and get selected menu option
            displayMenu();
            String gameMenuOption = this.getEndLocationMenuOption();
            if (gameMenuOption.toUpperCase().equals("Q"))  //user wants to quit
                return; //exit the game

            //this will do the requested action and display the next view
            done = this.doAction(gameMenuOption);

        } while(!done);
    }

     private String getEndLocationMenuOption() {
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
            case "S": //Search for Mickey
                this.displayMickeySearch();
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
            +"\nRide Exit Menu"
            +"\n------------------------------"
            +"\nS - Search for Mickey Head"
            +"\nQ - Exit Ride/ Stop Exploring"
            +"\n------------------------------");
    
     }

    private void displayMickeySearch() {
        MickeySearchMenuView  mickeySearchMenu = new MickeySearchMenuView();
        mickeySearchMenu.displayMickeySearchMenuView();
    }
}
