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
    private boolean emergencyWaterUsed;
    private boolean emergencySnackUsed;
    private int numberFastPasses;
    private double moneyBalance;

    public Backpack() {
    }

    
    
    public boolean isEmergencyWaterUsed() {
        return emergencyWaterUsed;
    }

    public void setEmergencyWaterUsed(boolean emergencyWaterUsed) {
        this.emergencyWaterUsed = emergencyWaterUsed;
    }

    public boolean isEmergencySnackUsed() {
        return emergencySnackUsed;
    }

    public void setEmergencySnackUsed(boolean emergencySnackUsed) {
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
        hash = 29 * hash + (this.emergencyWaterUsed ? 1 : 0);
        hash = 29 * hash + (this.emergencySnackUsed ? 1 : 0);
        hash = 29 * hash + this.numberFastPasses;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.moneyBalance) ^ (Double.doubleToLongBits(this.moneyBalance) >>> 32));
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
        if (this.emergencyWaterUsed != other.emergencyWaterUsed) {
            return false;
        }
        if (this.emergencySnackUsed != other.emergencySnackUsed) {
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