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
        this.console.println(
        "\n*******************************************************************************************"
        +"\n*                                                                                         *"
        +"\n*    | | | |(_)  __| |  __| |  ___  _ __   |  \\/  |(_)  ___ | | __ ___  _   _  ___        *"
        +"\n*    | |_| || | / _` | / _` | / _ \\| '_ \\  | |\\/| || | / __|| |/ // _ \\| | | |/ __|       *"
        +"\n*    |  _  || || (_| || (_| ||  __/| | | | | |  | || || (__ |   <|  __/| |_| |\\__ \\       *"
        +"\n*    |_| |_||_| \\__,_| \\__,_| \\___||_| |_| |_|  |_||_| \\___||_|\\_\\\\___| \\__, ||___/       *"
        +"\n*                                                                       |___/             *"
        +"\n* In this game, you are a Disneyland Guest with a one day, one park ticket. Your          *"
        +"\n* challenge is to find 10 or more hidden Mickeys by the time the park closes.  There are  *"
        +"\n* hidden Mickeys in rides and souvenir shops.                                             *"
        +"\n*                                                                                         *"        
        +"\n* You must pay attention to the time and your energy levels to ensure that you don't run  *"
        +"\n* out of either before you find the 10 Mickeys. Before moving to locations in the  park,  *"
        +"\n* you will be shown an estimated time that your move will take. You have the opportunity  *"
        +"\n* to collect Fast Passes. Fast passes will cut the wait time for a ride by half.          *"
        +"\n*                                                                                         *"        
        +"\n* You may also collect snacks or meals along the way to charge your energy levels. Your   *"
        +"\n* energy decreases by 1% for every 5 minutes you are in the park.                         *"
        +"\n* You will begin the game with a bag packed with the following:                           *"
        +"\n* 1 emergency snack, 1 bottle of water, and $100 for food and souvenirs.                  *"
        +"\n*                                                                                         *"        
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
        
 }

    private String getPlayerName() {
    
        String value = ""; //value to be returned
        boolean valid = false; //initialize to not valid
        try {
        while (!valid) { //loop while an invalid value is entered
            this.console.println("\n" + this.promptMessage);
            
            value = this.keyboard.readLine(); //get next line typed on keyboard
            value = value.trim(); //trim off leading and trailing blanks
            
            if (value.length() < 1) { //value is blank
                ErrorView.display(this.getClass().getName(), "\nInvalid value: value cannot be blank");
                continue;
            }
            break; //end the loop
        }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
        }
        return value; //return the value entered
    }
    
    @Override
     public boolean doAction(String playerName) {
        if (playerName.length() < 2) {
            this.console.println("\nInvalid player's name: "
            + "The name must be greater than one character in length.");
            return false;
        }
        
        //call createPlayer() control function
        Player player = GameControl.createPlayer(playerName);
        
        if (player == null) { //if unsuccessful
            this.console.println("\nError creating the player");
            return false;
        }
        this.displayNextView(player);
        return true;
    }

    private void displayNextView(Player player) {
        this.console.println("\n================================"
                          +"\nWelcome to the game, " + player.getPlayerName() +"!"
                          +"\nEnjoy the hunt!"
                          +"\n================================");
        
        
        
        
        //create MainMenuView object
        
        MainMenuView mainMenuView = new MainMenuView();
        
        //display the Main Menu View
        
        mainMenuView.display();
    }
            
            
            
    
}
