/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class LocationControlTest {
    
    public LocationControlTest() {
    }

    /**
     * Test of calcFastPassTime method, of class LocationControl.
     */
    @Test
    public void testCalcFastPassTime() {
        System.out.println("calcFastPassTime");
        
        //Create instance for testing
        LocationControl instance = new LocationControl();
        
        /**
         * TEST #1
         */
        System.out.println("TEST #1");
        //input value
        int time = 10;
        //expected value
        int expResult = 5;
        //run the function on the input value
        int result = instance.calcFastPassTime(time);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
                /**
         * TEST #2
         */
        System.out.println("TEST #2");
        //input value
        time = 120;
        //expected value
        expResult = 60;
        //run the function on the input value
        result = instance.calcFastPassTime(time);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
                /**
         * TEST #3
         */
        System.out.println("TEST #3");
        //input value
        time = 47;
        //expected value
        expResult = 20;
        //run the function on the input value
        result = instance.calcFastPassTime(time);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
                /**
         * TEST #4
         */
        System.out.println("TEST #4");
        //input value
        time = 189;
        //expected value
        expResult = 95;
        //run the function on the input value
        result = instance.calcFastPassTime(time);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
                /**
         * TEST #5
         */
        System.out.println("TEST #5");
        //input value
        time = -20;
        //expected value
        expResult = -1;
        //run the function on the input value
        result = instance.calcFastPassTime(time);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
                /**
         * TEST #6
         */
        System.out.println("TEST #6");
        //input value 
        time = 0;
        //expected value
        expResult = -2;
        //run the function on the input value
        result = instance.calcFastPassTime(time);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
                /**
         * TEST #7
         */
        System.out.println("TEST #7");
        //input value
        time = 4;
        //expected value
        expResult = 999;
        //run the function on the input value
        result = instance.calcFastPassTime(time);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
    }
    
}
