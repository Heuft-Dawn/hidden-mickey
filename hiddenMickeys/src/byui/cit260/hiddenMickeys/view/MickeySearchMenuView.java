
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.model.Mickey;
import byui.cit260.hiddenMickeys.model.Scene;
import java.util.ArrayList;

public class MickeySearchMenuView extends View {
    private String promptMessage; 
    private Scene myScene;
    private ArrayList<Mickey> mickeys;
 
       
    public MickeySearchMenuView(Scene myScene, ArrayList<Mickey> mickeys){//constructor Function
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
            +"\n " + myScene.getMickeyLocation()
            +"\n "
            +"\n Congratulations, you found a Mickey!  Current Mickey Count = " + Integer.toString(mickeys.size()) 
            +"\n\n Press Q - Return to Game Menu or M - Return to Map"
            
            
            );    
            this.myScene = myScene;
            this.mickeys = mickeys;
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
                if(mickeys.size()== 12){
                    this.console.println("------------------------------------------------------------"
                            + "\nCONGRATULATIONS!  YOU HAVE FOUND 12 MICKEYS.  You may continue"
                            + "\nto search for more Mickeys, or quit the game."
                            + "\n------------------------------------------------------------");
                } 
                return true;
        }else if (choice.equals("M")) {
                if(mickeys.size()== 12){
                    this.console.println("------------------------------------------------------------"
                            + "\nCONGRATULATIONS!  YOU HAVE FOUND 12 MICKEYS.  You may continue"
                            + "\nto search for more Mickeys, or quit the game."
                            + "\n------------------------------------------------------------");
                } 
                GameMenuView gmv = new GameMenuView();
                gmv.mapAndMove();
                return true;
        }else {
                this.searchDescription(choice);
                
        }
        return false;
    }
    
   @Override
    public void display(){
        boolean done = false; //set flag to not done
        
        do { //prompt for and get selected menu option
            this.console.println("\n" + this.displayMessage);
            String value = this.getInput();
                    
        //this will do the requested action and display the next view
        
         done = this.doAction(value);
         
         
        } while(!done);
    }
    
    private void searchDescription(String choice) {
        this.console.println("\n***searchDescription()function called on " + choice + "***");
        this.console.println("\nSorry, no Mickey found there.");
    }

   
   private void showRideDescription() {
        this.console.println("Here is the description of the ride...");
    }
     
    
}

