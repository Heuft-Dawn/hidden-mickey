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
public class Kiosk implements Serializable{
    
    
    // class instance variables
    private String foodItem;
    private int cost;
    private int energyBoostIncrease;

    public Kiosk() {
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getEnergyBoostIncrease() {
        return energyBoostIncrease;
    }

    public void setEnergyBoostIncrease(int energyBoostIncrease) {
        this.energyBoostIncrease = energyBoostIncrease;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.foodItem);
        hash = 17 * hash + this.cost;
        hash = 17 * hash + this.energyBoostIncrease;
        return hash;
    }

    @Override
    public String toString() {
        return "Kiosk{" + "foodItem=" + foodItem + ", cost=" + cost + ", energyBoostIncrease=" + energyBoostIncrease + '}';
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
        final Kiosk other = (Kiosk) obj;
        if (this.cost != other.cost) {
            return false;
        }
        if (this.energyBoostIncrease != other.energyBoostIncrease) {
            return false;
        }
        if (!Objects.equals(this.foodItem, other.foodItem)) {
            return false;
        }
        return true;
    }
    
    
}
