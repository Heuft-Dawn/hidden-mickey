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
public class UseEmergencyWaterView extends View {
    
    public UseEmergencyWaterView(){
        super("Drinking your emergency water will replenish your energy by 40%.  \n Continue? (Y/N)\n");
    }
    
    @Override
    
   public boolean doAction(String choice){
       choice = choice.toUpperCase();
       switch(choice){
           case "Y":
               this.updateBackpackWater();
               System.out.println("\n Whew, you are feeling refreshed after drinking your emergency water.. \nYour energy has increased.\n");
               this.quitTheOption();
               break;
           case "N":
               break;
           case "Q":
               break;
           default:
               System.out.println("\nInvalid choice try again");
               break;
       }
       return true;
   }

    public static void updateBackpackWater() {
        System.out.println("TODO: UpdateBackpackWater"); }
}
