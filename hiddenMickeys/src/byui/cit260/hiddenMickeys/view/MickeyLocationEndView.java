/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Mickey;
import byui.cit260.hiddenMickeys.model.Scene;
import hiddenmickeys.HiddenMickeys;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class MickeyLocationEndView extends View{
   private String promptMessage; 
   private Scene myScene;
    //Constructor function
    public MickeyLocationEndView(Scene myScene){//constructor Function
        super("------------------------------"
            +"\nRide Exit Menu"
            +"\n------------------------------"
            +"\nS - Search for Mickey Head"
            +"\nQ - Exit Ride/ Stop Exploring"
            +"\n------------------------------"
            +"\n \n"
            +"\n Enter your choice");
        this.myScene = myScene;
}

   @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        boolean returnToMenu = false;
    
        switch (choice) {
            case "S": //Search for Mickey                
                this.displayMickeySearch();
                break;
            case "Q": //go back to menu
                break;
            default:
                ErrorView.display(this.getClass().getName(),
                        "\n***Invalid selection. Try again.");
                returnToMenu = true;
                break;
                        }
        return !returnToMenu;
    }
    
    
     

    private void displayMickeySearch() {
        
        Game game = HiddenMickeys.getCurrentGame();
        Mickey mickey1 = new Mickey();
        mickey1.setLocationNum(game.getCurrentLocationNo());
        ArrayList<Mickey> mickeysCollected = game.getBackpack().getMickeysCollected();
        mickeysCollected.add(mickey1);
        game.getBackpack().setMickeysCollected(mickeysCollected);
        
        MickeySearchMenuView  mickeySearchMenu = new MickeySearchMenuView(this.myScene);
        mickeySearchMenu.display();
        
       
    }
}
