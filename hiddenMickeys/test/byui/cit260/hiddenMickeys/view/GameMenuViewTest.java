/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class GameMenuViewTest {
    
    public GameMenuViewTest() {
    }

   
    /**
     * Test of displayMap method, of class GameMenuView.
     */
    @Test
    public void testDisplayMap() {
        System.out.println("displayMap");
        GameMenuView instance = new GameMenuView();
        instance.displayMap();

    }

    /**
     * Test of displayLocations method, of class GameMenuView.
     */
    @Test
    public void testDisplayLocations() {
        System.out.println("displayLocations");
        int numColumns = 2;
        int colWidth = 60;
        GameMenuView instance = new GameMenuView();
        instance.displayLocations(numColumns, colWidth);
    
        numColumns = 4;
        colWidth = 45;
        instance.displayLocations(numColumns, colWidth);
      
        numColumns = 6;
        colWidth = 20;
        instance.displayLocations(numColumns, colWidth);
        
    }
    
}
