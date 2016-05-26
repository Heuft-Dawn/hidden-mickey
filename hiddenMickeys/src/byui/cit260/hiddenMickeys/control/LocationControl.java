/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.control;

/**
Author: Susan Allen
 */
public class LocationControl {
    
   public int calcFastPassTime(int time) {
	//check for negatives
       if (time < 0) {
            return -1;
            }
       //check for blank values
	if (time == 0) {
            return -2;
            }
        //check for values less than 5
	if (time < 5) {
            return 999;
            }
	
        double halfTime = (double)time /2;
        int roundHalfTime = (int)Math.round(halfTime);
        System.out.println(halfTime);
        System.out.println(roundHalfTime);
        int adjustment = roundHalfTime % 5;
        int fastPassTime = roundHalfTime - adjustment; 

        return fastPassTime;	
        }
 
}
