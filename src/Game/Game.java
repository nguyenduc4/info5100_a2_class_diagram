package Game;

import Game.GameBoard;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import Player.Player;


/**
 * 
 * @author Duc Nguyen
 */
public class Game {
    private LocalTime start_time;
    private LocalTime end_time;
    private String type_of_game;
    private int total_round;
    private List<GameBoard> game_history; // Assuming game history is a list of strings
    
    private final int DEFAULT_TOTAL_ROUND = 90;

    public Game(String type_of_game) {
        this.start_time = null;
        this.end_time = null;
        this.type_of_game = type_of_game;
        this.total_round = DEFAULT_TOTAL_ROUND;
        this.game_history = new ArrayList<>();
    }  

    public LocalTime getStart_time() {
        return this.start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return this.end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }
    
    /*
        @params type (ONLINE_GAME, OFFLINE_GAME)
    */
    public String getType_of_game(String type) {
        return this.type_of_game;
    }

    public void setType_of_game(String type_of_game) {
        this.type_of_game = type_of_game;
    }

    public int getTotal_round() {
        return this.total_round;
    }

    public void setTotal_round(int total_round) {
        this.total_round = total_round;
    }

    public List<GameBoard> getGame_history() {
        return this.game_history;
    }

    public void setGame_history(List<GameBoard> game_history) {
        this.game_history = game_history;
    }
    
    public void startGame() { 
        this.start_time = java.time.LocalTime.now();
        System.out.println("Game Mode: " + this.type_of_game + "Game begin time: " + this.start_time.toString());
    }
    
    public void endGame() { 
        this.end_time = java.time.LocalTime.now();
        System.out.println("Game end at: " + this.end_time.toString());
    }
    
    public void declareGameResult(Player player1, Player player2) {
        if(player1.getScore() > player2.getScore()){ 
            System.out.println(player1.getName() + " win!");
        }else if (player2.getScore() > player1.getScore()) { 
            System.out.println(player2.getName() + " win!");
        } else { 
            System.out.println("Tie Game!");
        }
    }
    
    public void create_game(Player player1, Player player2) { 
        GameBoard newGame = new GameBoard();
        System.out.println("Creating game between " + player1.getName() + " and " + player2.getName());
        this.total_round ++;
        this.game_history.add(newGame);
    }
}
