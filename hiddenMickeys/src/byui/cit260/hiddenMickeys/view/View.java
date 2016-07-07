/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.model.Game;
import hiddenmickeys.HiddenMickeys;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
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
            System.out.println("\n" + this.displayMessage);
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
    public void quitTheOption() {
         
          System.out.println("Enter Q to Return");
          
               String option = this.getInput();
          
                this.doAction(option);
            
    }
    
    @Override
    public void displayCurrentTimeAndEnergy() {
        Game game = HiddenMickeys.getCurrentGame();
          this.console.println("\nCurrent Time Remaining: " + Integer.toString(game.getTimeRemaining()) 
                  + "  Current Energy: " + Integer.toString(game.getEnergyLevel()) + "%");
    }
}
