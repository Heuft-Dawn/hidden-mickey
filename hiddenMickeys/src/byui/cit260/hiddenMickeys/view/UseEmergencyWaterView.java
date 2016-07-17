
package byui.cit260.hiddenMickeys.view;


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
               this.console.println("\n Whew, you are feeling refreshed after drinking your emergency water.. \nYour energy has increased.\n");
               this.quitTheOption();
               break;
           case "N":
               break;
           case "Q":
               break;
           default:
               ErrorView.display(this.getClass().getName(),"\nInvalid choice try again");
               break;
       }
       return true;
   }

    public void updateBackpackWater() {
        this.console.println("TODO: UpdateBackpackWater"); }
}
