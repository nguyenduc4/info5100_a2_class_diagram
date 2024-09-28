/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BattleShipEntity;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Duc Nguyen
 */
public class Torpedo {
    public int torpedo_id;
    public List<int[]> coordinates;
       
    public Torpedo(int x, int y) { 
        this.coordinates = new ArrayList<>();

    }
    
    public void shot_torpedo(int x, int y) { 
        this.coordinates.add(new int[]{x,y});
    }
    
    // * This method will not be likely to be used in the application, however as the requirement 
    // * Of the assignemnt, I implement this feature, it can be viewed as future development.
    public void remove_shot_torpedo(int x, int y){ 
        this.coordinates.removeIf(coordinate -> coordinate[0] == x && coordinate[1] == y);
    }
    
    public void display_torpedo_coordinates() { 
        int count = 1;
        for (int[] coordinate : coordinates) {
            System.out.println("Torpedo #" + count + " fired at: [" + coordinate[0] + "," + coordinate[1] + "]");
            count++;
        }
    }
    
    public int[] getCoordinates(int index) {
        if (index >= 0 && index < this.coordinates.size()) {
            return this.coordinates.get(index);
        } else {
            System.out.println("Invalid index for torpedo coordinates.");
            throw new IndexOutOfBoundsException("Out of bounds");
        }
    }
}
