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
public class ExploreShopLocationView extends View {
    
    public ExploreShopLocationView(){
    super("\n"
            +"\n------------------------------"
            +"\nShop Menu"
            +"\n------------------------------"
            +"\nY - Yes, buy a souvenir"
            +"\nN - No, do not buy a souvenir"
            +"\nQ - Return to Game Menu"
            +"\n------------------------------"
            +"\n\n\nThis location sells souvenirs for $10.  Would you like to purchase something?");
    }

     @Override
     public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "Y": //Yes, buy a souvenir
                this.buySouvenir();
                break;
            case "N": //No, do not buy a souvenir
                this.notBuySouvenir();
                break;
            case "Q": //go back to menu
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

   
    private void buySouvenir() {
        System.out.println("You bought a souvenir for $10. Enjoy!");
        //this will update the amount of money left in th e player's backpack
        this.updateMoney();
    }

    private void notBuySouvenir() {
        System.out.println("You did not buy a souvenir. Enjoy the rest of your time!");
    }

    private void updateMoney() {
        System.out.println("updateMoney() function called. I want this to be able to call the function I already created to calculate the new balance.");
    }
    
}
