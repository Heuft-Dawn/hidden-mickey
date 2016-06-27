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
    /**
     * This function calculates fast pass time by dividing the 
     * current wait time in half and rounding it down to a 
     * 5 minute interval
     */   
       
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
	
        //calculate what half the time would be
        double halfTime = (double)time /2;
        
        //round the halfTime value 
        int roundHalfTime = (int)Math.round(halfTime);

        //find how many minutes the value is above the 5 minute time interval below it   
        int adjustment = roundHalfTime % 5;
        
        //adjust the rounded half time down to the 5 minute interval
        int fastPassTime = roundHalfTime - adjustment; 

        return fastPassTime;	
        }
 
   
   // author - Dawn Heuft
   
   public int calcEnergyUsed (int timeUsed, int curEnergy) {
       if (timeUsed < 5 || timeUsed > 120) { // check range
          return -1;
       }
      if (curEnergy < 1 || curEnergy > 300) { // check range
          return -2;
      }
      int energyUsed = timeUsed/5;
      int level = curEnergy - energyUsed;
      curEnergy = level;
      
      if (curEnergy < 10){ //check energy level
          System.out.println ("Caution energy level is below 10, replenish soon");
          return energyUsed; 
      }    
      return energyUsed;
      }
   
   
}
