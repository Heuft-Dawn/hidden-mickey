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
public class MickeySearchMenuView extends View {
    private String promptMessage;  
 
       
    public MickeySearchMenuView(){//constructor Function
    super("-----------------------------------------------------"
            +"\nInstructions"
            +"\n-----------------------------------------------------"
            +"\nEnter a location where you believe the Mickey is hidden."
            +"\n"
            +"\nQ - Exit Ride/ Stop Exploring"
            +"\n-----------------------------------------------------"
            +"\n \n"
            +"\n Enter your choice:");    
}

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        //System.out.println("The choice you entered is " + choice);
        if (choice.equals("V")) {
                //show the description for the ride
                this.showRideDescription();
                //have the user enter q to continue with the search menu
                this.quitTheOption();
        }else if (choice.equals("Q")) {
                return false;
        }else {
                this.searchDescription(choice);
                
        }
        return false;
    }
    
    
    private void searchDescription(String choice) {
        System.out.println("\n***searchDescription()function called on " + choice + "***");
        System.out.println("\nSorry, no Mickey found there.");
    }

   
   private void showRideDescription() {
        System.out.println("Here is the description of the ride...");
    }
     
    
}

