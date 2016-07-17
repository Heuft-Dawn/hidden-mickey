
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.GameControl;
import byui.cit260.hiddenMickeys.model.Player;
import java.util.Scanner;


public class StartProgramView extends View {
    private String promptMessage;    
    public StartProgramView() {
        
        this.promptMessage = "\nPlease enter your name: ";
        //display the banner when view is created
        this.displayBanner();
    }

    private void displayBanner() {
        this.console.println(
                "\n******************************************************************************************"
                +"\n*                                                                                        *"
                +"\n*    | | | |(_)  __| |  __| |  ___  _ __   |  \\/  |(_)  ___ | | __ ___  _   _  ___       *"
                +"\n*    | |_| || | / _` | / _` | / _ \\| '_ \\  | |\\/| || | / __|| |/ // _ \\| | | |/ __|      *"
                +"\n*    |  _  || || (_| || (_| ||  __/| | | | | |  | || || (__ |   <|  __/| |_| |\\__ \\      *"
                +"\n*    |_| |_||_| \\__,_| \\__,_| \\___||_| |_| |_|  |_||_| \\___||_|\\_\\\\___| \\__, ||___/      *"
                +"\n*                                                                       |___/            *" +
                "\n* In this game, you are a Disneyland Guest with a one-day ticket. Your challenge is to   *" +
                "\n* find 12 Hidden Mickeys by the time the park closes.                                    *" +
                "\n*                                                                                        *" +
                "\n* What are Hidden Mickeys? They’re hidden Mickey Mouse heads that Disney designers have   *" +
                "\n* built into the park itself. They might be trimmed into bushes, or pieced together with *" +
                "\n* paving stones, or tucked into the back corner of some dark ride. In this game, you’ll   *" +
                "\n* find them only on rides or in souvenir shops.                                          *" +
                "\n*                                                                                        *" +
                "\n* As you explore the park, your energy level will fall. If it reaches 0, you lose. Your  *" +
                "\n* energy decreases by 2% for every 5 minutes you are in the park, but you can            * " +
                "\n* recharge it by resting, eating, or drinking. Use the emergency water and snack in your *" +
                "\n* backpack or buy refreshments from restaurants in the park. But spend your money        *" +
                "\n* carefully. You have just $50 for food and souvenirs.                                   *" +
                "\n*                                                                                        *" +
                "\n* You will have a limited amount of time in the park—just 480 minutes (8 hours). Some    *" +
                "\n* rides have longer wait times than others, and moving from place to place will take     *" +
                "\n* time. Budget your time wisely, and collect fast passes to cut your wait times for      *" +
                "\n* rides in half. If time runs out before you’ve collected 12 Hidden Mickeys, you lose.    *" +
                "\n*                                                                                        *" +
                "\n* So manage your time, your energy, and your money well.  Good luck and happy searching! *" +
                "\n*                                                                                        *" +
                "\n******************************************************************************************");
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
