/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.util.List;
import java.util.ArrayList;

import BattleShipEntity.Torpedo;
import BattleShipEntity.Ship;

/**
 *
 * @author Duc Nguyen
 */
public class GameBoard {
    private int horizontal_size;
    private int vertical_size;
    private List<Torpedo> torpedo_position;
    private List<Ship> ship_position;
    
    private int HORIZONTAL_SIZE = 8;
    private int VERTICAL_SIZE = 8;

    public GameBoard() {
        this.horizontal_size = HORIZONTAL_SIZE;
        this.vertical_size = VERTICAL_SIZE;
        this.torpedo_position = new ArrayList<>();
        this.ship_position = new ArrayList<>();
    }

    public int getHorizontal_size() {
        return horizontal_size;
    }

    public void setHorizontal_size(int horizontal_size) {
        this.horizontal_size = horizontal_size;
    }

    public int getVertical_size() {
        return vertical_size;
    }

    public void setVertical_size(int vertical_size) {
        this.vertical_size = vertical_size;
    }

    public List<Torpedo> getTorpedo_position() {
        return torpedo_position;
    }

    public void setTorpedo_position(List<Torpedo> torpedo_position) {
        this.torpedo_position = torpedo_position;
    }

    public List<Ship> getShip_position() {
        return ship_position;
    }

    public void setShip_position(List<Ship> ship_position) {
        this.ship_position = ship_position;
    }
    
    public void addShip(Ship ship) { 
        this.ship_position.add(ship);
    }
    
    public void removeShip(Ship ship) { 
        this.ship_position.remove(ship);
    }
    
    public void displayHitTorpedo() {
        for (Torpedo torpedo : this.torpedo_position) {
            boolean hit = false;
            for (Ship ship : this.ship_position) {
                // Check each coordinate of the torpedo
                for (int[] torpedoCoords : torpedo.coordinates) {
                    int torpedoX = torpedoCoords[0];
                    int torpedoY = torpedoCoords[1];

                    // Check if this torpedo hit the ship at any of its positions
                    if (ship.isHit(torpedoX, torpedoY)) {
                        System.out.println("Hit at coordinates: (" + torpedoX + ", " + torpedoY + ")");
                        ship.take_damage();  // Ship takes damage

                        // Check if ship is eliminated after taking damage
                        if (ship.isEliminate()) {
                            System.out.println("Ship ID: " + ship.getShip_id() + " is eliminated.");
                        }

                        hit = true;
                        break;  
                    }
                }
            }

            // If no ship was hit at the torpedo's coordinates
            if (!hit) {
                System.out.println("Missed! No ship hit.");
            }
        }
    }
}
