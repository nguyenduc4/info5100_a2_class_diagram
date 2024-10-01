/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BattleShipEntity;

import java.util.ArrayList;
import java.util.List;
import Player.Player;
/**
 *
 * @author danie
 */
public class Ship {
    private int ship_id;
    private int size; 
    private int value; 
    private int health;
    private boolean is_down;
    private List<int[]> ship_position;

    private Player player;
    
    public Ship(int ship_id, int size, int value, int health, Player player) {
        this.ship_id = ship_id;
        this.size = size;
        this.value = value;
        this.health = health;
        this.is_down = false;
        this.ship_position = new ArrayList<>();
        this.player = player;
    }

    public int getShipId() {
        return ship_id;
    }

    public void setShipId(int ship_id) {
        this.ship_id = ship_id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isEliminate() {
        return is_down;
    }

    public void setIsEliminated(boolean is_down) {
        this.is_down = is_down;
    }
    
    public void displayStatus() { 
        System.out.println("Your ship is: " + (this.is_down ? "Down" : "Alive"));
    }
    
    public void takeDamage() {
        this.health --; 
        if(this.health <= 0) { 
            this.is_down = true;
        }
    }
    
    public String displayInfo() { 
        String ship_information = "Ship ID: " + this.ship_id + ", Size: " + this.size + ", Value: " + this.value + ", Health: " +this.health + ", is_eliminated: " + this.is_down;
        System.out.println(ship_information);
        return ship_information;
    }
    
    public void setShipPosition(int startX, int startY, boolean isHorizontal) { 
        this.ship_position.clear() ;
        for( int i = 0 ; i < this.size; i++ ){  
            if(isHorizontal) {
                this.ship_position.add(new int[]{startX + i, startY});
            }else { 
                this.ship_position.add(new int[]{startX, startY + i});
            }
        }
    }
    
    public List<int[]> getPosition() { 
        return this.ship_position;
    }
    
    public boolean isHit(int x, int y) { 
        for(int[] coordinate  : this.ship_position)  { 
            if(coordinate[0] == x && coordinate[1] == y) { 
                return true;
            }
        }
        return false;
    }
}
