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
public class StartProgramView {
    private String promptMessage;    
    public StartProgramView() {
        
        this.promptMessage = "\nPlease enter your name: ";
        //display the banner when view is created
        this.displayBanner();
    }

    private void displayBanner() {
        System.out.println(
        "\n**************************************************"
        +"\n*                                                *"
        +"\n* In this game, you are a Disneyland Guest with  *"
        +"\n* a one-day ticket.  Your challenge is to        *"
        +"\n* collect 10+ hidden Mickey heads by the time    *"
        +"\n* the park closes. Mickey heads are located in   *"
        +"\n* rides and souvenir shops. Your challenge is to *"
        +"\n* find 10 of the Mickey heads before the park    *"
        +"\n* closes in 10 hours.  You must pay attention to *"
        +"\n* the time and your energy levels to ensure      *"
        +"\n* that you don't run out of either before you    *"
        +"\n* find the 10 Mickeys. Before moving to          *"
        +"\n* locations in the park, you will be shown an    *"
        +"\n* estimated time that your move will take. You   *"
        +"\n* can speed up ride wait times (cut the wait     *"
        +"\n* time in half) by using one of your 3 fast      *"
        +"\n* passes.  You may also collect snacks or meals  *"
        +"\n* along the way to charge your energy levels     *"
        +"\n*(which will decrease 1% for every 5 minutes in  *"
        +"\n* in the park).                                  *"
        +"\n* You will begin the game with a bag packed with *"
        +"\n* the following: 3 fast passes, 1 emergency      *"
        +"\n* snack, a bottle of water, and $50 for food.    *"
        +"\n* From there, you will explore the park, decide  *"
        +"\n* which rides to go on to find Mickey Heads.     *"
        +"\n*                                                *"
        +"\n**************************************************");
    }

    //display the start program view
    public void displayStartProgramView() {
        
        boolean done = false;
        do {
            //prompt for and get player's name
            String playersName = this.getPlayersName();
            if (playersName.toUpperCase().equals("Q"))
                return; //exit the game
            
            //do the requested action and display the next view
            done = this.doAction(playersName);
            
        } while (!done);
        
        /*
        do
            Prompt for and get the player's name
            if (playersName == "Q") then
            exit
        
            do the action and display the next view
        
        while the action is not successful
        */
        
        
        
        
        //Do the action
        //Determine and display the next view
    }

    private String getPlayersName() {
       System.out.println("\n*** getPlayersName() function was called ***");
       return "Dawn";
    }

    private boolean doAction(String playersName) {
        System.out.println("\n*** doAction() function was called ***");
        return true;
    }
            
            
            
    
}
