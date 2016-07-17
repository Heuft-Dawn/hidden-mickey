
package byui.cit260.hiddenMickeys.view;


public class UseEmergencySnackView extends View {
    
    public UseEmergencySnackView(){
        super("Eating your emergency snack will replenish your energy by 10%.  \n Continue? (Y/N)\n");
    }
    
    @Override
       public boolean doAction(String choice){
       choice = choice.toUpperCase();
       switch(choice){
           case "Y":
               this.updateBackpackSnack();
               this.console.println("/n Whew!  You feel much better after eating the snack! /nYour energy has increased./n/");
               this.quitTheOption();
               break;
           case "N":
               break;   
           case "Q":
               break;
           default:
               ErrorView.display(this.getClass().getName(),"/nInvalid choice try again");
               break;
       }
       return true;
   }

    private void updateBackpackSnack() {
        this.console.println("TODO: UpdateBackpackSnack"); }
}