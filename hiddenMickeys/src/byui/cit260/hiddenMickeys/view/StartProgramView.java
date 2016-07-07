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
public class StartProgramView extends View {
    private String promptMessage;    
    public StartProgramView() {
        
        this.promptMessage = "\nPlease enter your name: ";
        //display the banner when view is created
        this.displayBanner();
    }

    private void displayBanner() {
        System.out.println(
        "\n*******************************************************************************************"
        +"\n*                                                                                         *"
        +"\n*    | | | |(_)  __| |  __| |  ___  _ __   |  \\/  |(_)  ___ | | __ ___  _   _  ___        *"
        +"\n*    | |_| || | / _` | / _` | / _ \\| '_ \\  | |\\/| || | / __|| |/ // _ \\| | | |/ __|       *"
        +"\n*    |  _  || || (_| || (_| ||  __/| | | | | |  | || || (__ |   <|  __/| |_| |\\__ \\       *"
        +"\n*    |_| |_||_| \\__,_| \\__,_| \\___||_| |_| |_|  |_||_| \\___||_|\\_\\\\___| \\__, ||___/       *"
        +"\n*                                                                       |___/             *"
        +"\n* In this game, you are a Disneyland Guest with a one day, one park ticket. Your          *"
        +"\n* challenge is to find 10 or more hidden Mickeys by the time the park closes.  There are  *"
        +"\n* hidden Mickeys in many locations, including rides, some kiosks and many souvenir shops. *"
        +"\n* You must pay attention to the time and your energy levels to ensure that you don't run  *"
        +"\n* out of either before you find the 10 Mickeys. Before moving to locations in the  park,  *"
        +"\n* you will be shown an estimated time that your move will take. You have three Fast       *"
        +"\n* Passes available to use each day. Fast passes will cut the wait time for a ride by half.*"
        +"\n* You may also collect snacks or meals along the way to charge your energy levels. Your   *"
        +"\n* energy decreases by 1% for every 5 minutes you are in the park.                         *"
        +"\n* You will begin the game with a bag packed with the following:                           *"
        +"\n* 3 fast passes, 1 emergency snack, 1 bottle of water, and $50 for food.                  *"
        +"\n* From there, you will explore the park and decide where to look for the hidden Mickeys.  *"
        +"\n* Good Luck and Happy Searching!                                                          *" 
        +"\n*                                                                                         *"
        +"\n*******************************************************************************************");
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
    
        String value = ""; //value to be returned
        boolean valid = false; //initialize to not valid
        try {
        while (!valid) { //loop while an invalid value is entered
            System.out.println("\n" + this.promptMessage);
            
            value = this.keyboard.readLine(); //get next line typed on keyboard
            value = value.trim(); //trim off leading and trailing blanks
            
            if (value.length() < 1) { //value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }
            break; //end the loop
        }
        } catch (Exception e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
        return value; //return the value entered
    }
    
    @Override
     public boolean doAction(String playerName) {
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
        System.out.println("\n================================"
                          +"\nWelcome to the game, " + player.getPlayerName() +"!"
                          +"\nEnjoy the hunt!"
                          +"\n================================");
        
        
        
        
        //create MainMenuView object
        
        MainMenuView mainMenuView = new MainMenuView();
        
        //display the Main Menu View
        
        mainMenuView.display();
    }
            
            
            
    
}
