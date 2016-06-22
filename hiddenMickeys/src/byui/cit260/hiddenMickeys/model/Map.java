/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Hannah Mars
 */
public class Map implements Serializable{
    //class instance variables
    private int rowCount;
    private int columnCount;
    private Location[][] locations;

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }
    

    public Map(int noOfRows, int noOfColumns) {
            if (noOfRows < 1 || noOfColumns < 1) {
               System.out.println("The number of rows and columns must be > zero");
               return;
            }

            this.rowCount = noOfRows;
            this.columnCount = noOfColumns;
            int locationNo = 1;

            //create 2-D array for Location objects
            this.locations = new Location[noOfRows][noOfColumns];

            for (int column = 0; column < noOfColumns; column++){
                for (int row = 0; row < noOfRows; row++) {
                    //create and initialize new Location object instance      
                    Location location = new Location();
                    location.setColumn(column);
                    location.setRow(row);
                    location.setVisited(false);
                    location.setMickeyCollected(false);
                    location.setLocationNo(locationNo);
                    locationNo++;

            //assign the Location object to the current position in array
            locations[row][column] = location;
		}
	}
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.rowCount;
        hash = 61 * hash + this.columnCount;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        if (this.rowCount != other.rowCount) {
            return false;
        }
        if (this.columnCount != other.columnCount) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + '}';
    }
    
    
}
