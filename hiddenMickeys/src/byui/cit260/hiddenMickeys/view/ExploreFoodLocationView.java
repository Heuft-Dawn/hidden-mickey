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
public class ExploreFoodLocationView extends View {    
    
    public ExploreFoodLocationView(){
        super("\n"
            +"\n------------------------------"
            +"\nFood Menu"
            +"\n------------------------------"
            +"\nB - Buy Food"
            +"\nY - Continue "
            +"\nQ - Return to Game Menu"
            +"\n------------------------------"
            +"\n\n\nThis location sells popcorn, "
            +"what would you like to do?");
}

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "B": //Buy food
                this.buyFood();
                break;
            case "Y": //Continue and explore
                this.exploreFood();
                break;   
            case "N": //go back to menu
                break;
            case "Q": //go back to menu
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

 

    private void exploreFood() {
        //this will display a description for the user - telling them what they experienced during the ride
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
