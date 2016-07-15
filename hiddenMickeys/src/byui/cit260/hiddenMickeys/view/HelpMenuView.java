/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;


/**
 *
 * @author Hannah Mars
 */
public class HelpMenuView extends View{
private String promptMessage;
    
public HelpMenuView() {//Constructor Function
   super("---------------------------------------------------"
        +"\n|  Help Menu                                      |"
        +"\n---------------------------------------------------"
        +"\nG - What is the goal/objective of the game?"
        +"\nM - How to move"
        +"\nT - How to check time remaining and energy levels"
        +"\nR - How to re-charge energy"
        +"\nS - How to search for Hidden Mickeys"
        +"\nQ - Return to previous screen"
        +"\n---------------------------------------------------"
        + "\n \n"
        + "\n What would you like help with?" );
  
}
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        
        switch (choice) {
            case "G": //goal/objective of the game
                this.displayGameGoal();
                break;
            case "M": //how to move
                this.displayHowMove();
                break;   
            case "T": //check time remaining
                this.displayHowCheckTime();
                break;
            case "R": //recharge energy
                this.displayHowRechargeEnergy();
                break;
            case "S": //search for Hidden Mickeys
                this.displayHowSearch();
                break;
            case "Q": //exit this portion
                break;
            default:
                ErrorView.display(this.getClass().getName(),
                        "\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

    private void displayGameGoal() {
    
        this.console.println("\n"
            +"\n   The objective of the game is to find 10 Hidden Mickeys.  You must do this before "
            +"\nyou run out of time and energy."
            +"\n"
            +"\n  Hidden Mickeys are located within rides and shopping locations.  While exploring "
            +"\nthese locations, you will be given opportunities to search for the Hidden Mickeys. "
            +"\nThere will be 1 or 0 Hidden Mickeys at each location. Once you have found 10, the game"
            +"\nends."
            +"\n"
            +"\n   You begin the game with 600 minutes and 100% energy.  The game ends when the   "
            +"\nminutes remaining is 0, or the energy percent reaches 0%.  "
            +"\n"                
            +"\n   When you move to a new location in the game, the time it will to move will be given"
            +"\nto you.  If you decide to move, the minutes will be deducted from your time remaining.  "
            +"\nWhen you choose to go on a ride, the line wait-time will also be deducted from your "
            +"\ntime remaining."
            +"\n  "
            +"\n   Throughout the game your energy level will decrease 1% for every 5 minutes in the "
            +"\npark. You may recharge the energy by eating a snack at a snack location, by resting, "
            +"\nor by using emergency food contained in your backpack.  "
            +"\n  ");
            
        this.quitTheOption();
            
    }
    
   

    private void displayHowMove() {
    String quit; //Variable used to return to the help menu
       this.console.println("\n"
        +"\n   To move to a new location in the game, enter an 'M' from the Game Menu. A map will"
        +"\nthen be displayed.  Enter the location number of the location that you wish to move to"
        +"\nand the program will tell you how much time it will take to move to that location.  If"
        +"\nyou decide to move, you will confirm that you would like to move.  Your map position"
        +"\nwill then change to the location that you entered."
        +"\n");
        this.quitTheOption();
    }

    private void displayHowCheckTime() {
    String quit; //Variable used to return to the help menu
        this.console.println("\n"
        +"\nTo check time remaining and energy levels, enter a 'T' from the Game Menu screen.  "
        +"\n"
        +"\nYour Total time remaining and current energy levels will be displayed."
        +"\n");
        this.quitTheOption();
    }

    private void displayHowRechargeEnergy() {
    String quit; //Variable used to return to the help menu
        this.console.println("\n"
        +"\nEnergy may be recharged any of the following 3 ways:"
        +"\n"
        +"\n1)- View your Backpack by entering a 'B' from the Game Menu.  If you have an emergency"
        +"\nsnack or emergency water remaining, you may use one of those to recharge energy."
        +"\n	"
        +"\n2)- Move to a snack location and purchase a snack.  A snack will recharge energy."
        +"\n    "
        +"\n3)- Select one of the 'Rest Locations' from the map.  Once you arrive you will"
                + "\nbe given the choice of whether to rest or not."
	+"\n    ");
        this.quitTheOption();
    }

    private void displayHowSearch() {
    String quit; //Variable used to return to the help menu
        this.console.println("\n"
        +"\n   When exploring rides or store locations, you will be given the option to 'Search  "
        +"\nfor Hidden Mickey.'  If you choose to search, and a Hidden Mickey exists at that, "
                + "\nlocation, you will see a description of where the Hidden Mickey is located "
        +"\nand your Hidden Mickey count will be increased.  " );
        this.quitTheOption();
    }

  
     
}
