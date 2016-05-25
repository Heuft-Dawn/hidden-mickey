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
public class MapControlTest {
    
    public MapControlTest() {
    }

    /**
     * Test 1 of calcMoveTime method, of class MapControl.
     */
    @Test
    public void testCalcMoveTime() {
        System.out.println("calcMoveTime");
        /*
        ******************
        TEST CASE #1
        ******************
        */
        System.out.println("\tTest 1");
        //input values for test case 1
        int curRow = 3;
        int curCol = 5;
        int newRow = 1;
        int newCol = 1;
        
        //create instance of MapControl class
        MapControl instance = new MapControl();
        
         //expected output return value
        int expResult = 10;
        
        //call function to run test
        int result = instance.calcMoveTime(curRow, curCol, newRow, newCol);
        
        //compre expected return value to actual return value
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
        
        
        /*
        ******************
        TEST CASE #2
        ******************
        */
        System.out.println("\tTest 2");
        //input values for test case 2
        curRow = 1;
        curCol = 1;
        newRow = 2;
        newCol = 5;
        
        //create instance of MapControl class
        //MapControl instance = new MapControl();
        
         //expected output return value
        expResult = 7;
        
        //call function to run test
        result = instance.calcMoveTime(curRow, curCol, newRow, newCol);
        
        //compre expected return value to actual return value
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
        
        
        
        /*
        ******************
        TEST CASE #3
        ******************
        */
        System.out.println("\tTest 3");
        //input values for test case 3
        curRow = -1;
        curCol = 1;
        newRow = 4;
        newCol = 5;
        
         //expected output return value
        expResult = -1;
        
        //call function to run test
        result = instance.calcMoveTime(curRow, curCol, newRow, newCol);
        
        //compre expected return value to actual return value
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
        
        
        
        
        /*
        ******************
        TEST CASE #4
        ******************
        */
        System.out.println("\tTest 4");
        //input values for test case 4
        curRow = 3;
        curCol = -1;
        newRow = 4;
        newCol = 5;
        
         //expected output return value
        expResult = -1;
        
        //call function to run test
        result = instance.calcMoveTime(curRow, curCol, newRow, newCol);
        
        //compre expected return value to actual return value
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
        
        
        
        
        /*
        ******************
        TEST CASE #5
        ******************
        */
        System.out.println("\tTest 5");
        //input values for test case 5
        curRow = 3;
        curCol = 1;
        newRow = -1;
        newCol = 5;
        
         //expected output return value
        expResult = -1;
        
        //call function to run test
        result = instance.calcMoveTime(curRow, curCol, newRow, newCol);
        
        //compre expected return value to actual return value
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
        
        
        
        
        /*
        ******************
        TEST CASE #6
        ******************
        */
        System.out.println("\tTest 6");
        //input values for test case 6
        curRow = 3;
        curCol = 1;
        newRow = 4;
        newCol = -1;
        
         //expected output return value
        expResult = -1;
        
        //call function to run test
        result = instance.calcMoveTime(curRow, curCol, newRow, newCol);
        
        //compre expected return value to actual return value
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
        
        
        
        
        /*
        ******************
        TEST CASE #7
        ******************
        */
        System.out.println("\tTest 7");
        //input values for test case 7
        curRow = 0;
        curCol = 1;
        newRow = 4;
        newCol = 5;
        
         //expected output return value
        expResult = 999;
        
        //call function to run test
        result = instance.calcMoveTime(curRow, curCol, newRow, newCol);
        
        //compre expected return value to actual return value
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
        
        
        
        
        /*
        ******************
        TEST CASE #8
        ******************
        */
        System.out.println("\tTest 8");
        //input values for test case 8
        curRow = 2;
        curCol = 0;
        newRow = 4;
        newCol = 5;
        
         //expected output return value
        expResult = 999;
        
        //call function to run test
        result = instance.calcMoveTime(curRow, curCol, newRow, newCol);
        
        //compre expected return value to actual return value
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
        
        
        
        
        /*
        ******************
        TEST CASE #9
        ******************
        */
        System.out.println("\tTest 9");
        //input values for test case 9
        curRow = 2;
        curCol = 3;
        newRow = 0;
        newCol = 5;
        
         //expected output return value
        expResult = 999;
        
        //call function to run test
        result = instance.calcMoveTime(curRow, curCol, newRow, newCol);
        
        //compre expected return value to actual return value
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
        
        
        
        
        /*
        ******************
        TEST CASE #10
        ******************
        */
        System.out.println("\tTest 10");
        //input values for test case 10
        curRow = 2;
        curCol = 3;
        newRow = 4;
        newCol = 0;
        
         //expected output return value
        expResult = 999;
        
        //call function to run test
        result = instance.calcMoveTime(curRow, curCol, newRow, newCol);
        
        //compre expected return value to actual return value
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
        
        
        
        
        /*
        ******************
        TEST CASE #11
        ******************
        */
        System.out.println("\tTest 11");
        //input values for test case 11
        curRow = 7;
        curCol = 3;
        newRow = 4;
        newCol = 5;
        
         //expected output return value
        expResult = 999;
        
        //call function to run test
        result = instance.calcMoveTime(curRow, curCol, newRow, newCol);
        
        //compre expected return value to actual return value
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
        
        
        
        
        /*
        ******************
        TEST CASE #12
        ******************
        */
        System.out.println("\tTest 12");
        //input values for test case 12
        curRow = 2;
        curCol = 11;
        newRow = 4;
        newCol = 5;
        
         //expected output return value
        expResult = 999;
        
        //call function to run test
        result = instance.calcMoveTime(curRow, curCol, newRow, newCol);
        
        //compre expected return value to actual return value
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
        
        
        
        
        /*
        ******************
        TEST CASE #13
        ******************
        */
        System.out.println("\tTest 13");
        //input values for test case 13
        curRow = 2;
        curCol = 3;
        newRow = 7;
        newCol = 5;
        
         //expected output return value
        expResult = 999;
        
        //call function to run test
        result = instance.calcMoveTime(curRow, curCol, newRow, newCol);
        
        //compre expected return value to actual return value
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
        
        
        
        
        /*
        ******************
        TEST CASE #14
        ******************
        */
        System.out.println("\tTest 14");
        //input values for test case 14
        curRow = 2;
        curCol = 3;
        newRow = 4;
        newCol = 11;
        
         //expected output return value
        expResult = 999;
        
        //call function to run test
        result = instance.calcMoveTime(curRow, curCol, newRow, newCol);
        
        //compre expected return value to actual return value
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
