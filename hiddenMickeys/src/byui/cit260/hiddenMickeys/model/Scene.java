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
public class Scene implements Serializable{
   
    private String description;
    private String locationType;
    private String mapSymbol;
    private boolean mickeyPresent;
    private String mickeyLocation;
    private int waitTime;
    private String[] itemName;
    private double itemPrice;
    
    //class instance variables
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getMapSymbol() {
        return mapSymbol;
    }

    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }

    public boolean isMickeyPresent() {
        return mickeyPresent;
    }

    public void setMickeyPresent(boolean mickeyPresent) {
        this.mickeyPresent = mickeyPresent;
    }

    public String getMickeyLocation() {
        return mickeyLocation;
    }

    public void setMickeyLocation(String mickeyLocation) {
        this.mickeyLocation = mickeyLocation;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public String[] getItemName() {
        return itemName;
    }

    public void setItemName(String[] itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    

    public Scene() {
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + Objects.hashCode(this.mickeyLocation);
        return hash;
    }

    @Override
    public String toString() {
        return "Scene{" + "description=" + description + ", mickeyLocation=" + mickeyLocation + '}';
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
        final Scene other = (Scene) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.mickeyLocation, other.mickeyLocation)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
