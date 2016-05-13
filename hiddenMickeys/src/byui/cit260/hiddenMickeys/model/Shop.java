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
 * @author Administrator
 */
public class Shop implements Serializable{
    private double cost;
    private boolean mickeyAvailable;
    private String productName;

    public Shop() {
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isMickeyAvailable() {
        return mickeyAvailable;
    }

    public void setMickeyAvailable(boolean mickeyAvailable) {
        this.mickeyAvailable = mickeyAvailable;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        hash = 97 * hash + (this.mickeyAvailable ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.productName);
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
        final Shop other = (Shop) obj;
        if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost)) {
            return false;
        }
        if (this.mickeyAvailable != other.mickeyAvailable) {
            return false;
        }
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Shop{" + "cost=" + cost + ", mickeyAvailable=" + mickeyAvailable + ", productName=" + productName + '}';
    }
    
    
}
