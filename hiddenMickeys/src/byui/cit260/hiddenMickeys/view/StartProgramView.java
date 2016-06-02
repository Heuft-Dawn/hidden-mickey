/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.GameControl;
import byui.cit260.hiddenMickeys.model.Player;
import java.util.Scanner;

/**
 *
 * @author Hannah Mars
 */
public class StartProgramView {
    private String promptMessage;    
    public StartProgramView() {
        
        this.promptMessage = "\nPlease enter your name: ";
        //display the banner when view is created
        this.displayBanner();
    }

    private void displayBanner() {
        System.out.println(
        "\n**************************************************"
        +"\n*                                                *"
        +"\n* In this game, you are a Disneyland Guest with  *"
        +"\n* a one-day ticket.  Your challenge is to        *"
        +"\n* collect 10+ hidden Mickey heads by the time    *"
        +"\n* the park closes. Mickey heads are located in   *"
        +"\n* rides and souvenir shops. Your challenge is to *"
        +"\n* find 10 of the Mickey heads before the park    *"
        +"\n* closes in 10 hours.  You must pay attention to *"
        +"\n* the time and your energy levels to ensure      *"
        +"\n* that you don't run out of either before you    *"
        +"\n* find the 10 Mickeys. Before moving to          *"
        +"\n* locations in the park, you will be shown an    *"
        +"\n* estimated time that your move will take. You   *"
        +"\n* can speed up ride wait times (cut the wait     *"
        +"\n* time in half) by using one of your 3 fast      *"
        +"\n* passes.  You may also collect snacks or meals  *"
        +"\n* along the way to charge your energy levels     *"
        +"\n*(which will decrease 1% for every 5 minutes in  *"
        +"\n* in the park).                                  *"
        +"\n* You will begin the game with a bag packed with *"
        +"\n* the following: 3 fast passes, 1 emergency      *"
        +"\n* snack, a bottle of water, and $50 for food.    *"
        +"\n* From there, you will explore the park, decide  *"
        +"\n* which rides to go on to find Mickey Heads.     *"
        +"\n*                                                *"
        +"\n**************************************************");
    }

    //display the start program view
    public void displayStartProgramView() {
        
        boolean done = false; //set flag to not done
        do {
            //prompt for and get player's name
            String playerName = this.getPlayerName();
            if (playerName.toUpperCase().equals("Q"))
                return; //exit the game
            
            //do the requested action and display the next view
            done = this.doAction(playerName);
            
        } while (!done);
        
        /*
        do
            Prompt for and get the player's name
            if (playersName == "Q") then
            exit
        
            do the action and display the next view
        
        while the action is not successful
        */
        
        
        
        
        //Do the action
        //Determine and display the next view
    }

    private String getPlayerName() {
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
    
     private boolean doAction(String playerName) {
        if (playerName.length() < 2) {
            System.out.println("\nInvalid player's name: "
            + "The name must be greater than one character in length.");
            return false;
        }
        
        //call createPlayer() control function
        Player player = GameControl.createPlayer(playerName);
        
        if (player == null) { //if unsuccessful
            System.out.println("\nError creating the player");
            return false;
        }
        this.displayNextView(player);
        return true;
    }

    private void displayNextView(Player player) {
        System.out.println("\n*** displayNextView() function called ***");
    }
            
            
            
    
}
