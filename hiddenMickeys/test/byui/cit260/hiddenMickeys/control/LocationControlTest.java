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
    @Test
    public void testCalcEnergyUsed() {
        System.out.println("calcEnergyUsed");
        
        //Create instance for testing
        LocationControl instance = new LocationControl();
        
        /**
         * TEST #1
         */
        System.out.println("ENERGY TEST #1");
        //input value
        int timeUsed = 50;
        int curEnergy = 100;
        int energyUsed = timeUsed/5;
        int level = curEnergy - energyUsed;
        //expected value
        int expResult = 10;
        //run the function on the input value
        int result = instance.calcEnergyUsed(timeUsed, curEnergy);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
                /**
         * TEST #2
         */
        System.out.println("ENERGY TEST #2");
        //input value
        timeUsed = 90;
        curEnergy = 20;
        energyUsed = timeUsed/5;
        level = curEnergy - energyUsed;
        //expected value
        expResult = 18;
        //run the function on the input value
        result = instance.calcEnergyUsed(timeUsed, curEnergy);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
          /**
         * TEST #3
         */
        System.out.println("ENERGY TEST #3");
        //input value
        timeUsed = -1;
        curEnergy = 100;
        energyUsed = timeUsed/5;
        level = curEnergy - energyUsed;
        //expected value
        expResult = -1;
        //run the function on the input value
        result = instance.calcEnergyUsed(timeUsed, curEnergy);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
          /**
         * TEST #4
         */
        System.out.println("ENERGY TEST #4");
        //input value
        timeUsed = 40;
        curEnergy = -1;
        energyUsed = timeUsed/5;
        level = curEnergy - energyUsed;
        //expected value
        expResult = -2;
        //run the function on the input value
        result = instance.calcEnergyUsed(timeUsed, curEnergy);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
          /**
         * TEST #5
         */
        System.out.println("ENERGY TEST #5");
        //input value
        timeUsed = 40;
        curEnergy =  0;
        energyUsed = timeUsed/5;
        level = curEnergy - energyUsed;
        //expected value
        expResult = -2;
        //run the function on the input value
        result = instance.calcEnergyUsed(timeUsed, curEnergy);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
          /**
         * TEST #6
         */
        System.out.println("ENERGY TEST #6");
        //input value
        timeUsed = 0;
        curEnergy = 50;
        energyUsed = timeUsed/5;
        level = curEnergy - energyUsed;
        //expected value
        expResult = -1;
        //run the function on the input value
        result = instance.calcEnergyUsed(timeUsed, curEnergy);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
          /**
         * TEST #7
         */
        System.out.println("ENERGY TEST #7");
        //input value
        timeUsed = 4;
        curEnergy = 100;
        energyUsed = timeUsed/5;
        level = curEnergy - energyUsed;
        //expected value
        expResult = -1;
        //run the function on the input value
        result = instance.calcEnergyUsed(timeUsed, curEnergy);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
          /**
         * TEST #8
         */
        System.out.println("ENERGY TEST #8");
        //input value
        timeUsed = 60;
        curEnergy = 0;
        energyUsed = timeUsed/5;
        level = curEnergy - energyUsed;
        //expected value
        expResult = -2;
        //run the function on the input value
        result = instance.calcEnergyUsed(timeUsed, curEnergy);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
          /**
         * TEST #9
         */
        System.out.println("ENERGY TEST #9");
        //input value
        timeUsed = 125;
        curEnergy = 80;
        energyUsed = timeUsed/5;
        level = curEnergy - energyUsed;
        //expected value
        expResult = -1;
        //run the function on the input value
        result = instance.calcEnergyUsed(timeUsed, curEnergy);
        //test if the result is the expected value;
        assertEquals(expResult, result);
        
          /**
         * TEST #10
         */
        System.out.println("ENERGY TEST #10");
        System.out.println();
        //input value
        timeUsed = 115;
        curEnergy = 301;
        energyUsed = timeUsed/5;
        level = curEnergy - energyUsed;
        //expected value
        expResult = -2;
        //run the function on the input value
        result = instance.calcEnergyUsed(timeUsed, curEnergy);
        //test if the result is the expected value;
        assertEquals(expResult, result);
    }
   
}
