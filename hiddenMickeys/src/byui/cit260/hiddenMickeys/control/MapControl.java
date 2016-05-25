/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.control;

/**
 *
 * @author Hannah Mars
 */
public class MapControl {
    public int calcMoveTime(int curRow, int curCol, int newRow, int newCol) {
        if (curRow < 0 || curCol < 0 || newRow < 0 || newCol < 0) {
            //check for negative inputs
            return -1;
        }
        if (curRow > 6 || curCol > 10 || newRow > 6 || newCol > 10) {
            //check for out of range values
            return 999;
        }
        if (curRow < 1 || curCol < 1 || newRow < 1 || newCol < 1) {
            //check for 0 values
            return 999;
            
        }
        int rowChange = Math.abs(curRow - newRow);
        int colChange = Math.abs(curCol - newCol);
        int time = (rowChange * 3) +colChange;
        return time;
    }
}
