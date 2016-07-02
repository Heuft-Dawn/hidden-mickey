/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

/**
 *
 * @author Dawn
 */
public class ExploreRestView extends View {
     public ExploreRestView(){
        super("Would you like to stop and rest at this location?");
    }
    
    @Override
     public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "Y": 
                    this.rest();
                break;
            case "N": 
                    this.markAsVisited();
                break;
            case "Q":
                    this.markAsVisited();
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
}

    private void rest() {
        //display description of place
        
        //charge 20 min to the time
        
        //increase energy by 15
        
        //quit the option? or ??go to Mickey search view??
        
        //mark location as visited
        
    }

    private void markAsVisited() {
        System.out.println("TODO write mark as visited function");
    }
}
