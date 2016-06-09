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
public class ExploreFoodLocationView {
   private String promptMessage;  
    
    
    public ExploreFoodLocationView(){
    this.promptMessage = "\nThis location sells popcorn, "
      + "what would you like to do?";
}

    public void displayExploreFoodLocationView() {
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
            case "B": //Buy food
                this.buyFood();
                break;
            case "Y": //Continue and explore
                this.exploreFood();
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
            +"\nFood Menu"
            +"\n------------------------------"
            +"\nB - Buy Food"
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

    private void exploreFood() {
        //this will display a description for the user - telling them what they experienced during the ride
        this.getFoodDescription();
        //This calls a menu that gives the player a chance to search for Mickeys or exit.
        MickeyLocationEndView  locationEndMenu = new MickeyLocationEndView();
        locationEndMenu.displayMickeyLocationEndView();
                
 
    }

    private void getFoodDescription() {
       System.out.println("This kiosk sells popcorn in souvenir containers."
                +"\nYou purchased a Star Wars souvenir container and ate"
                + "\nseveral handfuls of popcorn.  It was delicious.");
    }

    private void updateEnergy() {
       System.out.println("\n***updateEnergy()function called***");
    }

    private void buyFood() {
        System.out.println("\n***buyFood()function called***");
    }
}
