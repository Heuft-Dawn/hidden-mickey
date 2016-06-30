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
public class Game implements Serializable{
   
    private int currentRow;
    private int currentColumn;
    private int currentLocationNo;

    private int energyLevel;
    private int timeExpired;
    private int timeRemaining;
    private int mickeysCollected;
    private Character character;
    private Backpack backpack;
    private Player player;
    private Map map;

   
   
    
    

   //Getter and Setter functions 
    public int getCurrentRow() {
        return currentRow;
    }

    
    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }
    
    
    public int getCurrentColumn() {
        return currentColumn;
    }

   
    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    
    public int getCurrentLocationNo() {
        return currentLocationNo;
    }

    public void setCurrentLocationNo(int currentLocationNo) {
        this.currentLocationNo = currentLocationNo;
    }
    
    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public int getTimeExpired() {
        return timeExpired;
    }

    public void setTimeExpired(int timeExpired) {
        this.timeExpired = timeExpired;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public int getMickeysCollected() {
        return mickeysCollected;
    }

    public void setMickeysCollected(int mickeysCollected) {
        this.mickeysCollected = mickeysCollected;
    }
    
        public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }
    
     public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.currentRow;
        hash = 47 * hash + this.currentColumn;
        hash = 47 * hash + this.energyLevel;
        hash = 47 * hash + this.timeExpired;
        hash = 47 * hash + this.timeRemaining;
        hash = 47 * hash + this.mickeysCollected;
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
        final Game other = (Game) obj;
        if (this.currentRow != other.currentRow) {
            return false;
        }
        if (this.currentColumn != other.currentColumn) {
            return false;
        }
        if (this.energyLevel != other.energyLevel) {
            return false;
        }
        if (this.timeExpired != other.timeExpired) {
            return false;
        }
        if (this.timeRemaining != other.timeRemaining) {
            return false;
        }
        if (this.mickeysCollected != other.mickeysCollected) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "currentRow=" + currentRow + ", currentColumn=" + currentColumn + ", energyLevel=" + energyLevel + ", timeExpired=" + timeExpired + ", timeRemaining=" + timeRemaining + ", mickeysCollected=" + mickeysCollected + '}';
    }

   

}
