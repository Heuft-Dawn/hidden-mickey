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
public class MapAndMoveView extends View{
    
    public MapAndMoveView() {
        super("\nMap under Construction"
              +"\nUsing the map above, enter a location number that you would "
              +"\nlike to move to or enter Q to exit map");
    }
    
    /*
    Ladies, I don't know how many locations we will have, or what their names 
    will be so for right now, I am just doing it like this. I know this will cause
    a little more work later, but this is what we have to roll with right now.
    */
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "1": //move to location 1
                this.locationOne();
                break;
            case "2": //move to location 2
                this.locationTwo();
                break;   
            case "3": //move to location 3
                this.locationThree();
                break;
            case "4": //move to location 4
                this.locationFour();
                break;
            case "5": //move to location 5
                this.locationFive();
                break;
            case "6": //move to location 6
                this.locationSix();
                break;
            case "7": //move to location 7
                this.locationSeven();
                break;
            case "8": //move to locatoin 8
                this.locationEight();
                break;
            case "Q":
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

    private void locationOne() {
        System.out.println("locationOne() function called");
    }

    private void locationTwo() {
        System.out.println("locationTwo() function called");
    }

    private void locationThree() {
        System.out.println("locationThree() function called");    
    }

    private void locationFour() {
        System.out.println("locationFour() function called");
    }

    private void locationFive() {
        System.out.println("locationFive() function called");
    }

    private void locationSix() {
        System.out.println("locationSix() function called");
    }

    private void locationSeven() {
        System.out.println("locationSeven() function called");
    }

    private void locationEight() {
        System.out.println("locationEight() function called");
    }

}