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
public class Backpack implements Serializable{
    //class instance variables
    private double emergencyWaterUsed;
    private double emergencySnackUsed;
    private int numberFastPasses;
    private double moneyBalance;

    public Backpack() {
    }

    public double getEmergencyWaterUsed() {
        return emergencyWaterUsed;
    }

    public void setEmergencyWaterUsed(double emergencyWaterUsed) {
        this.emergencyWaterUsed = emergencyWaterUsed;
    }

    public double getEmergencySnackUsed() {
        return emergencySnackUsed;
    }

    public void setEmergencySnackUsed(double emergencySnackUsed) {
        this.emergencySnackUsed = emergencySnackUsed;
    }

    public int getNumberFastPasses() {
        return numberFastPasses;
    }

    public void setNumberFastPasses(int numberFastPasses) {
        this.numberFastPasses = numberFastPasses;
    }

    public double getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(double moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.emergencyWaterUsed) ^ (Double.doubleToLongBits(this.emergencyWaterUsed) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.emergencySnackUsed) ^ (Double.doubleToLongBits(this.emergencySnackUsed) >>> 32));
        hash = 79 * hash + this.numberFastPasses;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.moneyBalance) ^ (Double.doubleToLongBits(this.moneyBalance) >>> 32));
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
        final Backpack other = (Backpack) obj;
        if (Double.doubleToLongBits(this.emergencyWaterUsed) != Double.doubleToLongBits(other.emergencyWaterUsed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.emergencySnackUsed) != Double.doubleToLongBits(other.emergencySnackUsed)) {
            return false;
        }
        if (this.numberFastPasses != other.numberFastPasses) {
            return false;
        }
        if (Double.doubleToLongBits(this.moneyBalance) != Double.doubleToLongBits(other.moneyBalance)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Backpack{" + "emergencyWaterUsed=" + emergencyWaterUsed + ", emergencySnackUsed=" + emergencySnackUsed + ", numberFastPasses=" + numberFastPasses + ", moneyBalance=" + moneyBalance + '}';
    }
    
    
}
