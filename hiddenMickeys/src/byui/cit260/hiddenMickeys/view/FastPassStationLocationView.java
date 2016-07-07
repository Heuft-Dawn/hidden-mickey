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
public class FastPassStationLocationView extends View {
    
    public FastPassStationLocationView(){
        super("You have arrived at a Fast Pass Kiosk. Would you like to get a Fast Pass now?");
    }
    
    @Override
     public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "Y": //Yes, add a Fast Pass to your backpack
                this.addFastpass();
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

    private void addFastpass() {
         //update fast pass number and next availability time is in 90 minutes
        //display the number of fast passes
        //notify user when the next fast pass will be available
        System.out.println("TODO: Should say You have added another Fast Pass to your backpack. You now have ___ Fast Passes.");
    }

   
}
