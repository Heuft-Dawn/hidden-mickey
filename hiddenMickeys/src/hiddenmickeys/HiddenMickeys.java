
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiddenmickeys;

/**
 *
 * @author Hannah Mars
 */
import byui.cit260.hiddenMickeys.model.*;
        


import byui.cit260.hiddenMickeys.view.StartProgramView;

public class HiddenMickeys {
    
    private static Game currentGame = null;
    private static Player player = null;

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create the start program view and display the start program view
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();
        
       

}


    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        HiddenMickeys.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }
    

    public static void setPlayer(Player player) {
        HiddenMickeys.player = player;
    }
    
}


