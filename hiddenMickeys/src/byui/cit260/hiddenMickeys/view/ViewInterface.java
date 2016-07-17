
package byui.cit260.hiddenMickeys.view;


public interface ViewInterface {
    
    public void display();
    
    public String getInput();
    
    public boolean doAction(String value);
    
    public void quitTheOption();
    
    public void displayCurrentTimeAndEnergy();
    
    public void displayFastPassInfo();

}
