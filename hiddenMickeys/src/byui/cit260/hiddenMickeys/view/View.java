/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public abstract class View implements ViewInterface {
    
    protected String displayMessage;
    
    public View() {
    }
   
    public View(String message){
        this.displayMessage = message;
    }
    
    @Override
    public void display(){
        boolean done = false; //set flag to not done
        System.out.println("\n" + this.displayMessage);
        do { //prompt for and get selected menu option
            
            String value = this.getInput();
            if (value.toUpperCase().equals("Q"))  //user wants to quit
              return; //exit the game
        
        //this will do the requested action and display the next view
        done = this.doAction(value);
            
        } while(!done);
    }
 
    @Override
    public String getInput() {
        Scanner keyboard = new Scanner(System.in); //get in file for keyboard
        String value = ""; //value to be returned
        boolean valid = false; //initialize to not valid
        
        while (!valid) { //loop while an invalid value is entered
            
            
            
            value = keyboard.nextLine(); //get next line typed on keyboard
            value = value.trim(); //trim off leading and trailing blanks
            
            if (value.length() < 1) { //value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }
            break; //end the loop
        }
        return value; //return the value entered
    }
    
    @Override
    public void quitTheOption() {
         
          System.out.println("Enter Q to Return");
          
               String option = this.getInput();
          
                this.doAction(option);
            
    }
}
