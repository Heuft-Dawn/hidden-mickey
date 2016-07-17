
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.model.Backpack;
import byui.cit260.hiddenMickeys.model.Game;
import hiddenmickeys.HiddenMickeys;
import static hiddenmickeys.HiddenMickeys.getCurrentGame;
import java.io.BufferedReader;
import java.io.PrintWriter;


public abstract class View implements ViewInterface {
    
    protected String displayMessage;
    
    
    protected final BufferedReader keyboard = HiddenMickeys.getInFile();
    protected final PrintWriter console = HiddenMickeys.getOutFile();
    
    public View() {
    }
   
    public View(String message){
        this.displayMessage = message;
    }
    
    @Override
    public void display(){
        boolean done = false; //set flag to not done
        
        do { //prompt for and get selected menu option
            this.console.println("\n" + this.displayMessage);
            String value = this.getInput();
            if (value.toUpperCase().equals("Q"))  //user wants to quit
              return; //exit the game
            
           
        
        //this will do the requested action and display the next view
        
         done = this.doAction(value);
         
         
        } while(!done);
    }
 
    @Override
    public String getInput() {
        String value = ""; //value to be returned
        boolean valid = false; //initialize to not valid
        try {
        while (!valid) { //loop while an invalid value is entered
            
            
            
            value = this.keyboard.readLine(); //get next line typed on keyboard
            value = value.trim(); //trim off leading and trailing blanks
            
            if (value.length() < 1) { //value is blank
                ErrorView.display(this.getClass().getName(),"\nInvalid value: value cannot be blank");
                continue;
            }
            break; //end the loop
        }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(),"Error reading input: " + e.getMessage());
        }
        return value; //return the value entered
    }
    
    @Override
    public void quitTheOption() {
         
          this.console.println("Enter Q - Return to Menu or M - Map");
          
               String option = this.getInput();
                if (option.toUpperCase().equals("M")) {
                    try{
                         Game game= getCurrentGame();
                        int gameCheck = game.getTimeRemaining();
                        if(gameCheck>0){
                        GameMenuView gameMenu = new GameMenuView();
                        gameMenu.mapAndMove();}
                        }catch (Exception e){
                            ErrorView.display(this.getClass().getName(), "You have not begun a game yet.\nStart a New Game then go to the map");
                        }
                    
                   
                    
                }
                else {   
                this.doAction(option);
                }
    }
    
    @Override
    public void displayCurrentTimeAndEnergy() {
        Game game = HiddenMickeys.getCurrentGame();
          this.console.println("\nCurrent Time Remaining: " + Integer.toString(game.getTimeRemaining()) 
                  + "  Current Energy: " + Integer.toString(game.getEnergyLevel()) + "%");
    }
    
    @Override
    public void displayFastPassInfo(){
        Game game = HiddenMickeys.getCurrentGame();
        Backpack backpack = game.getBackpack();
        int numFastPasses = backpack.getNumberFastPasses();
        int curFastPassReturnTime = game.getFastPassReturnTime();
        int curTimeRemaining = game.getTimeRemaining();
        int timeToNextPass = 999;
        String displayText = new String();
        
        if(curTimeRemaining<= curFastPassReturnTime){
            timeToNextPass = 0; 
            displayText =  "You may collect another pass.";
            
        }else{
            timeToNextPass = curTimeRemaining -curFastPassReturnTime;
            displayText = "There are " + Integer.toString(timeToNextPass) + 
                    " minutes remaining until you may collect another.";
        }
        this.console.println("\n---------------------------------------------------------"+
                "\nYou have " + Integer.toString(numFastPasses) + " Fast Passes."
                +"\n" + displayText 
                + "\n---------------------------------------------------------");
                
    }
}
