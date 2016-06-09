/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;
import java.util.Scanner;

/**
 *
 * @author Dawn
 */
public class BackpackView {
   private String promptMessage;
   
   public BackpackView() {
       this.promptMessage = "\nYou have several items in your backpack,"
               + "which one would you like to check?";
    }
   public void displayBackpackView() {
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
            case "P": //View Fast Passes
                this.viewFastPass();
                break;
            case "M": //Check Money balance
                this.viewMoneyBalance();
                break;   
            case "W": //Use emergency water
                break;
            case "S": //Use emergency snack
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
            +"\n----------------------------------------------"
            +"\nView Backpack Menu"
            +"\n----------------------------------------------"
            +"\nP - Check number of fast passes"
            +"\nM - Check Money Balance "
            +"\nW - Use Emergency Water"
            +"\nS - Use Emergency Snack"
            +"\nq - Return to menu"   
            +"\n----------------------------------------------");
     }

    private void viewFastPass() {
         System.out.println("\n***viewFastPasses()function called***");
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

    private void viewMoneyBalance() {
         System.out.println("You have ______ money in your backpack");
    }

    private void useEmergencyWater() {
        System.out.println("\n Whew, you are feeling refreshed after drinking"
                + "your emergency water.");
    }

    private void useEmergencySnack() {
        System.out.println("\nYummy, You have eaten your emergency snack and "
                + "it was delicious.");
    }
    
}


