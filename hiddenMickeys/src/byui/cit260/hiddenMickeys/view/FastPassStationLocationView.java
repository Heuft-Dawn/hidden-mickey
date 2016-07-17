
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.LocationControl;
import byui.cit260.hiddenMickeys.model.Backpack;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import hiddenmickeys.HiddenMickeys;


public class FastPassStationLocationView extends View {
    
    public FastPassStationLocationView(){
        super("---------------------------------------------------"
                + "\nYou have arrived at a Fast Pass Kiosk. "
                + "\n---------------------------------------------------"
                + "\nC - Check Fast Pass Eligibility" 
                + "\nP - Gather a Fast Pass"
                + "\nQ - Quit and go to another location"
                + "\n---------------------------------------------------");
    }
    
    @Override
     public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "P": //Yes, add a Fast Pass to your backpack
                this.addFastpass();
                break;
            case "C": 
                this.displayFastPassInfo();
                return false;
                
            case "Q":
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n***Invalid selection. Try again.");
                return false;
               
        }
        return true;
}

    private void addFastpass() {
        Game game = HiddenMickeys.getCurrentGame();
        int locationNum = game.getCurrentLocationNo();
        Location myLocation = LocationControl.getLocationByNumber(locationNum);
        myLocation.setVisited(true);
        Backpack backpack = game.getBackpack();
        
        int numFastPasses = backpack.getNumberFastPasses();
        int curFastPassReturnTime = game.getFastPassReturnTime();
        int curTimeRemaining = game.getTimeRemaining();
        int fastPassInterval = game.getFastPassReturnInterval();
                
        //check for eligibility
        if(curTimeRemaining<= curFastPassReturnTime){
            numFastPasses++;
            backpack.setNumberFastPasses(numFastPasses);
            //update fast pass availability time
            curFastPassReturnTime= curTimeRemaining - fastPassInterval;
            game.setFastPassReturnTime(curFastPassReturnTime);
            
        }else{
           int minRemaining = curTimeRemaining - curFastPassReturnTime;
           ErrorView.display("","You may not collect a fast pass yet."
                   + "\nCome back in " + Integer.toString(minRemaining) + " minutes.");
           
        }
        this.displayFastPassInfo();
    }

   
}
