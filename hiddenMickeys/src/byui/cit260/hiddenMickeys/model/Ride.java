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
public class Ride implements Serializable{
    
    //class instance variables
    private int waitTime;
    private String description;
    private int energyUsed;
    private boolean fastPassEligible;
    private boolean mickeyAvailable;

    public Ride() {
    }

    
    
    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEnergyUsed() {
        return energyUsed;
    }

    public void setEnergyUsed(int energyUsed) {
        this.energyUsed = energyUsed;
    }

    public boolean isFastPassEligible() {
        return fastPassEligible;
    }

    public void setFastPassEligible(boolean fastPassEligible) {
        this.fastPassEligible = fastPassEligible;
    }

    public boolean isMickeyAvailable() {
        return mickeyAvailable;
    }

    public void setMickeyAvailable(boolean mickeyAvailable) {
        this.mickeyAvailable = mickeyAvailable;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.waitTime;
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + this.energyUsed;
        hash = 53 * hash + (this.fastPassEligible ? 1 : 0);
        hash = 53 * hash + (this.mickeyAvailable ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Ride{" + "waitTime=" + waitTime + ", description=" + description + ", energyUsed=" + energyUsed + ", fastPassEligible=" + fastPassEligible + ", mickeyAvailable=" + mickeyAvailable + '}';
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
        final Ride other = (Ride) obj;
        if (this.waitTime != other.waitTime) {
            return false;
        }
        if (this.energyUsed != other.energyUsed) {
            return false;
        }
        if (this.fastPassEligible != other.fastPassEligible) {
            return false;
        }
        if (this.mickeyAvailable != other.mickeyAvailable) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    
    
}
