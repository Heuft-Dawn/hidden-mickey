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
 * @author Dawn
 */
public class Location implements Serializable{
    
    //class instance variables
    private String name;
    private int row;
    private int column;
    private String land;
    private boolean returnAllowed;
    private boolean visited;

    public Location() {
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public boolean isReturnAllowed() {
        return returnAllowed;
    }

    public void setReturnAllowed(boolean returnAllowed) {
        this.returnAllowed = returnAllowed;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + this.row;
        hash = 23 * hash + this.column;
        hash = 23 * hash + Objects.hashCode(this.land);
        hash = 23 * hash + (this.returnAllowed ? 1 : 0);
        hash = 23 * hash + (this.visited ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Location{" + "name=" + name + ", row=" + row + ", column=" + column + ", land=" + land + ", returnAllowed=" + returnAllowed + ", visited=" + visited + '}';
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
        final Location other = (Location) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (this.returnAllowed != other.returnAllowed) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.land, other.land)) {
            return false;
        }
        return true;
    }
    
    
    
}
