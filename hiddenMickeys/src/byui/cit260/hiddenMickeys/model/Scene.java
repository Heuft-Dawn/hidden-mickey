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
    
    //class instance variables
    private String description;
    private String mickeyLocation;

    public Scene() {
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMickeyLocation() {
        return mickeyLocation;
    }

    public void setMickeyLocation(String mickeyLocation) {
        this.mickeyLocation = mickeyLocation;
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
