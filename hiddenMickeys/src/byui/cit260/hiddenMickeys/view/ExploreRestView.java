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
        super("\nYou have arrived at a Fast Pass Kiosk. Would you like to get a Fast Pass now?");
    }
    
    @Override
     public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "Y": //Yes, add a Fast Pass to your backpack
                
                break;
            case "N": //No, do not add a Fast Pass to your backpack
                
                break;
            case "Q":
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
}
}
