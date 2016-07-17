
package byui.cit260.hiddenMickeys.model;

import java.io.Serializable;

public enum Land implements Serializable{
     New_Orleans(1), 
     Critter_Cntry(2), 
     Adventureland(3),  
     Main_Street(4),   
     Fantasyland(5),  
     Tomorrowland(6),  
     Frontierland(7);
     
     private final int column;

    Land(int column){
      this.column = column;
    }

    public int getColumn() {
        return column;
    }
}

