
package byui.cit260.hiddenMickeys.model;

import java.io.Serializable;


public enum Character implements Serializable{
    
    Hannah("First time visitor"),
    Dawn("Season Pass-holder"),
    Suzy("Dole-whip lover"),
    Ben("Thrill Seeker"),
    Josh("Star Wars Geek");
    
    
    private final String description;

    
    Character(String description){
    this.description= description;
            }
    
    public String getDescription() {
        return description;
    }

   

    
}
