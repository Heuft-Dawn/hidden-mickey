/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.model.Scene;


/**
 *
 * @author Dawn
 */
public class ExploreFoodLocationView extends View {    
    
    public ExploreFoodLocationView(Scene scene){
        super("------------------------------"
            +"\nFood Menu"
            +"\n------------------------------"
            +"\n1 - Purchase Item 1 " + scene.getItemName()[0]
            +"\n2 - Purchase Item 2 " + scene.getItemName()[1]
            +"\n3 - Purchase Item 3 " + scene.getItemName()[2]
            +"\nQ - Return to Game Menu"
            +"\n------------------------------"
            +"\n Please enter your choice.");
}

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        boolean returnToMenu = false;
        switch (choice) {
            case "Q": //go back to menu
                break;
            default:
            int choiceNum = 0;    
            try {
                choiceNum = Integer.parseInt(choice);
                switch (choiceNum){
                    case 1: 
                    case 2: 
                    case 3: 
                        //Buy item and pass the position in the array
                        //this.buyItem(choiceNum-1);
                        break;
                    default:
                        System.out.println("\nYou must enter a valid option.");
                        returnToMenu = true;
                        break;
                        
                }
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number or Q");
                //prompt the user to try again
                return false;
            }
           break;     
        }
        return !returnToMenu;
        }

       
            

    private void exploreFood() {
        //this will display a description for the user - telling them 
        //about the food location and what is available
        this.getFoodDescription();
        //This calls a menu that gives the player a chance to search for Mickeys or exit.
        MickeyLocationEndView  locationEndMenu = new MickeyLocationEndView();
        locationEndMenu.display();
                
 
    }

    private void getFoodDescription() {
       System.out.println("This kiosk sells popcorn in souvenir containers."
                +"\nYou purchased a Star Wars souvenir container and ate"
                + "\nseveral handfuls of popcorn.  It was delicious.");
    }

    private void updateEnergy() {
       System.out.println("\n***updateEnergy()function called***");
    }

    private void buyFood() {
        System.out.println("\n***buyFood()function called***");
    }

}