/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

/**
 *
 * @author Administrator
 */
public class TMPExploreLocationView extends View {
   
    public TMPExploreLocationView() {
    
        super("Enter S for Shop Location, R for Ride Location, F for \nFood Location, or Q to Quit");
}
    
  @Override
    public boolean doAction(String choice) { 
    
        choice = choice.toUpperCase();
        //R=Ride, S=Shop, F=Food
        switch (choice) {
            case "R":
                //open the menu for a ride location 
                ExploreRideLocationView exploreRideView = new ExploreRideLocationView();
                exploreRideView.display();
                break;
            case "S":
                //open menu for a shop location
                ExploreShopLocationView exploreShopView = new ExploreShopLocationView();
                exploreShopView.display();
                break;
            case "F":
                //open menu for a food location
                ExploreFoodLocationView exploreFoodView = new ExploreFoodLocationView();
                exploreFoodView.display();
                break;
            case "Q":
                break;
            default:
                System.out.println("Invalid Location Type");
                break;
         }
        return true;
    }
    
}