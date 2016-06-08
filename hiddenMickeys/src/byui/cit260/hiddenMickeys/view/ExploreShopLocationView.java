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
public class ExploreShopLocationView {
    private String promptMessage;
    
    public ExploreShopLocationView(){
    this.promptMessage = "\nThis location sells souvenirs for $10.  Would you like to purchase something?";
}

    public void displayExploreShopLocationView() {
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
            case "Y": //Yes, buy a souvenir
                this.buySouvenir();
                break;
            case "N": //No, do not buy a souvenir
                this.notBuySouvenir();
                break;
            case "Q": //go back to menu
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

    private void displayMenu() {
        System.out.println("\n"
            +"\n------------------------------"
            +"\nShop Menu"
            +"\n------------------------------"
            +"\nY - Yes, buy a souvenir"
            +"\nN - No, do not buy a souvenir"
            +"\nQ - Return to Game Menu"
            +"\n------------------------------");
    }

    private void buySouvenir() {
        System.out.println("You bought a souvenir for $10. Enjoy!");
        //this will update the amount of money left in the player's backpack
        this.updateMoney();
    }

    private void notBuySouvenir() {
        System.out.println("You did not buy a souvenir. Enjoy the rest of your time!");
    }

    private void updateMoney() {
        System.out.println("updateMoney() function called. I want this to be able to call the function I already created to calculate the new balance.");
    }
    
}
