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
 * @author Hannah Mars
 */
public class BackpackControlTest {
    
    public BackpackControlTest() {
    }

    /**
     * Test of calcNewBalance method, of class BackpackControl.
     */
    @Test
    public void testCalcNewBalance() {
        System.out.println("calcNewBalance");
        
        /*
        ******************
        TEST CASE #1
        ******************
        */
        System.out.println("\tTest 1");
        //input values for test case 1
        double price = 15.75;
        double curBalance = 50;

        
        //create instance of MapControl class
        BackpackControl instance = new BackpackControl();
        
         //expected output return value
        double expResult = 34.25;
        
        //call function to run test
        double result = instance.calcNewBalance(price);
        
        //compare expected return value to actual return value
        assertEquals(expResult, result, 0.0);
        
        
        
        
        /*
        ******************
        TEST CASE #2
        ******************
        */
        System.out.println("\tTest 2");
        //input values for test case 2
        price = -19;
        curBalance = 50;

         //expected output return value
        expResult = -1;
        
        //call function to run test
        result = instance.calcNewBalance(price);
        
        //compare expected return value to actual return value
        assertEquals(expResult, result, 0.0);
        
        
        
        
        /*
        ******************
        TEST CASE #3
        ******************
        */
        System.out.println("\tTest 3");
        //input values for test case 3
        price = 100;
        curBalance = 50;

         //expected output return value
        expResult = -1;
        
        //call function to run test
        result = instance.calcNewBalance(price);
        
        //compare expected return value to actual return value
        assertEquals(expResult, result, 0.0);
        
        
        
        
        /*
        ******************
        TEST CASE #4
        ******************
        */
        System.out.println("\tTest 4");
        //input values for test case 4
        price = 0;
        curBalance = 50;

         //expected output return value
        expResult = 50;
        
        //call function to run test
        result = instance.calcNewBalance(price);
        
        //compare expected return value to actual return value
        assertEquals(expResult, result, 0.0);
        
        
        
        
        /*
        ******************
        TEST CASE #5
        ******************
        */
        System.out.println("\tTest 5");
        //input values for test case 5
        price = 1;
        curBalance = 50;

         //expected output return value
        expResult = 49;
        
        //call function to run test
        result = instance.calcNewBalance(price);
        
        //compare expected return value to actual return value
        assertEquals(expResult, result, 0.0);
        
        
        
        
        /*
        ******************
        TEST CASE #6
        ******************
        */
        System.out.println("\tTest 6");
        //input values for test case 6
        price = 50;
        curBalance = 50;

         //expected output return value
        expResult = 0;
        
        //call function to run test
        result = instance.calcNewBalance(price);
        
        //compare expected return value to actual return value
        assertEquals(expResult, result, 0.0);
        

    }
    
}
