/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Player;
import java.util.List;
import java.util.ArrayList;

import BattleShipEntity.Torpedo;
import BattleShipEntity.Ship;
import Game.Game;

/**
 *
 * @author Duc Nguyen
 */
public class Player {
    private int player_id; 
    private int player_score;
    private String player_name; 
    private int torpedoes_count = 45;
    private List<Torpedo> shot_history;
    private List<Ship> ship_list;
    private List<Game> game_history;

    public Player(int player_id, String player_name) {
        this.player_id = player_id;
        this.player_score = 0;
        this.player_name = player_name;
        
        this.shot_history = new ArrayList<>();
        this.ship_list = new ArrayList<>();
        this.game_history = new ArrayList<>(); 
    }

    public void addShip(Ship ship) { 
        if(this.ship_list.size() <= 5) { 
            this.ship_list.add(ship);
        }else { 
            System.out.println("Maximum number of ships have reached");
        }
    }

    public void removeShip(Ship ship) { 
        if(this.ship_list.contains(ship)) { 
            this.ship_list.remove(ship);
        }else { 
            System.out.println("No ship to remove");
        }
    }

    public void getShipList() { 
        for(Ship ship : this.ship_list) { 
            System.out.println("Ship ID: " + ship.getShip_id() + " Size: " + ship.getSize() + " Value: " + ship.getValue() + " Health: " + ship.getHealth() + " Is Eliminiate: " + ship.isEliminate());
        }
    }

    public int getScore() { 
        return this.player_score;
    }
    
    public String getName() { 
        return this.player_name;
    }
    
    public void setName(String name) { 
        this.player_name = name;
    }
    
    public void shotTorpedo(int x, int y) { 
        if(this.torpedoes_count > 0) { 
            Torpedo torpedo = new Torpedo(x,y);
            this.shot_history.add(torpedo);
            this.torpedoes_count--;
        }else { 
            System.out.println("No more torpedoes left");
        }
    }

    /*
    * Collect score after game - if win then + 2, if tie then - 1
    * @param game_result
    * @return none
    */
    public void collectScoreAfterGame(String game_result) {
        if(game_result == "win") { 
            this.player_score += 2;
        }else if (game_result == "tie") { 
            this.player_score -= 1;
        }
    }
    
    public void createGame(Game game) { 
        this.game_history.add(game);
    }
}