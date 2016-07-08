/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.model.Scene;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class MickeySearchMenuView extends View {
    private String promptMessage; 
    private Scene myScene;
 
       
    public MickeySearchMenuView(Scene myScene){//constructor Function
    super("       .:::::::::.                    .:::::::::."
            +"\n     :::::::::::::::                :::::::::::::::"
            +"\n    :::::::::::::::::              :::::::::::::::::"
            +"\n   ::::::::::::::::::              ::::::::::::::::::"
            +"\n    :::::::::::::::::ud$$b;::;d$$bu:::::::::::::::::"
            +"\n     ::::::::::::::d$$F,$$$ii$$$,?$$h::::::::::::::"
            +"\n      `'::::::::::d$$,d$$$$$$$$$$b,$$b::::::::::'`"
            +"\n               ::d$$$$$F\'?$$$$P\'?$$$$$b:"
            +"\n              :::$$$$$'d$b`$$'d$b`$$$$$::"
            +"\n              :::?$$$$ $$$ $$ $$$ $$$$F:::"
            +"\n              ::::$$$$,\' ' $$ ' \',$$$$::::"
            +"\n              ;d$$$$$$$\',='\'\''=,\'$$$$$$$b;"
            +"\n             <$$,`$$$$$$  \'**\'  $$$$$$`,$$>"
            +"\n              ?$$$,?$$$$$e....e$$$$$F,$$$F"
            +"\n               `?$$$c.\'?$$$$$$$$F\'.c$$$F"
            +"\n                   \'?$e          e$F\'"
            +"\n                      ?$g      g$F"
            +"\n                         \'#**#\'"
            +"\n"
            +"\n " + myScene.getMickeySearchDescription() 
            +"\n "
            +"\n Congratulations, you found a Mickey!  Current Mickey Count = INSERT COUNT HERE"
            +"\n\n Press Q to Return to Game Menu"
            
            
            );    
            this.myScene = myScene;
}

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        
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
        this.console.println("\n***searchDescription()function called on " + choice + "***");
        this.console.println("\nSorry, no Mickey found there.");
    }

   
   private void showRideDescription() {
        this.console.println("Here is the description of the ride...");
    }
     
    
}

