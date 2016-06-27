/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.control;

import byui.cit260.hiddenMickeys.model.Location;
import byui.cit260.hiddenMickeys.model.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class MapControlIT {
    
    public MapControlIT() {
    }


    /**
     * Test of calcRowsPerColumn method, of class MapControl.
     */
    @Test
    public void testCalcRowsPerColumn() {
        System.out.println("calcRowsPerColumn");
        int noLocations = 25;
        int numColumns = 2;
        int expResult = 13;
        int result = MapControl.calcRowsPerColumn(noLocations, numColumns);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
        noLocations = 36;
        numColumns = 3;
        expResult = 12;
        result = MapControl.calcRowsPerColumn(noLocations, numColumns);
        assertEquals(expResult, result);
       
        
        noLocations = 45;
        numColumns = 4;
        expResult = 12;
        result = MapControl.calcRowsPerColumn(noLocations, numColumns);
        assertEquals(expResult, result);
        
        noLocations = 73;
        numColumns = 5;
        expResult = 15;
        result = MapControl.calcRowsPerColumn(noLocations, numColumns);
        assertEquals(expResult, result);
        
        noLocations = 66;
        numColumns = -5;
        expResult = 1;
        result = MapControl.calcRowsPerColumn(noLocations, numColumns);
        assertEquals(expResult, result);
        
        noLocations = 0;
        numColumns = 4;
        expResult = -1;
        result = MapControl.calcRowsPerColumn(noLocations, numColumns);
        assertEquals(expResult, result);
        
        noLocations = 20;
        numColumns = 8;
        expResult = -999;
        result = MapControl.calcRowsPerColumn(noLocations, numColumns);
        assertEquals(expResult, result);
    }
}