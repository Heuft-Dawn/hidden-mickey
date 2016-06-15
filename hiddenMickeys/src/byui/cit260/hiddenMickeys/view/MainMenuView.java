/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.GameControl;
import hiddenmickeys.HiddenMickeys;
import java.util.Scanner;

/**
 *
 * @author Hannah Mars
 */
public class MainMenuView extends View {

    
    
public MainMenuView() {
    super("\n"
        +"\n---------------------------------------------------"
        +"\n|  Main Menu                                      |"
        +"\n---------------------------------------------------"
        +"\nN - Start new game                                 "
        +"\nG - Get and start saved game"
        +"\nH - Get help on how to play the game"
        +"\nS - Save Game"
        +"\nQ - Quit"
        +"\n---------------------------------------------------"
        +"\n"
        +"\n"
        +"\nPlease enter your choice: ");
    
}

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        
        switch (choice) {
            case "N": //create and start a new game
                this.startNewGame();
                break;
            case "G": //get and start an existing game
                this.startExistingGame();
                this.quitTheOption();
                break;   
            case "H": //display help menu
                this.showHelpMenu();
                break;
            case "S": //save current game
                this.saveGame();
                this.quitTheOption();
                break;
            case "Q":
                 break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

    private void startNewGame() {
        //create new game
        GameControl.createNewGame(HiddenMickeys.getPlayer());
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startExistingGame() {
       System.out.println("\n***startExistingGame()function called***");
    }

    private void showHelpMenu() {
       //display help menu
       // GameControl.createNewGame(HiddenMickeys.getPlayer());
        
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void saveGame() {
       System.out.println("\n***saveGame()function called***");
    }

   
    
    
    
    
}
    
