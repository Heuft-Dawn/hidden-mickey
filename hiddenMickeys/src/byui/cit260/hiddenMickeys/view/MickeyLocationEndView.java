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
public class MickeyLocationEndView extends View{
   private String promptMessage; 
    //Constructor function
    public MickeyLocationEndView(){//constructor Function
        super("\n"
            +"\n------------------------------"
            +"\nRide Exit Menu"
            +"\n------------------------------"
            +"\nS - Search for Mickey Head"
            +"\nQ - Exit Ride/ Stop Exploring"
            +"\n------------------------------"
            +"\n \n"
            +"\n Enter your choice");
}

   @Override
    public boolean doAction(String choice) {
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
    
    
     

    private void displayMickeySearch() {
        MickeySearchMenuView  mickeySearchMenu = new MickeySearchMenuView();
        mickeySearchMenu.display();
    }
}
