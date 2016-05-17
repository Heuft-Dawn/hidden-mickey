/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.model;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class FastPassStation implements Serializable{
    private int lastVisitedTime;
    private int nextAvailableTime;

    public FastPassStation() {
    }

    public int getLastVisitedTime() {
        return lastVisitedTime;
    }

    public void setLastVisitedTime(int lastVisitedTime) {
        this.lastVisitedTime = lastVisitedTime;
    }

    public int getNextAvailableTime() {
        return nextAvailableTime;
    }

    public void setNextAvailableTime(int nextAvailableTime) {
        this.nextAvailableTime = nextAvailableTime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.lastVisitedTime;
        hash = 53 * hash + this.nextAvailableTime;
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
        final FastPassStation other = (FastPassStation) obj;
        if (this.lastVisitedTime != other.lastVisitedTime) {
            return false;
        }
        if (this.nextAvailableTime != other.nextAvailableTime) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FastPassStation{" + "lastVisitedTime=" + lastVisitedTime + ", nextAvailableTime=" + nextAvailableTime + '}';
    }
    
    
}
