package Game;

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
    private List<Round> round_list;
    
    private Player player1;
    private Player player2;
    
    private final int DEFAULT_TOTAL_ROUND = 90;

    public Game(String type_of_game, Player player1, Player player2) {
        this.start_time = null;
        this.end_time = null;
        this.type_of_game = type_of_game;
        this.total_round = DEFAULT_TOTAL_ROUND;
        this.round_list = new ArrayList<Round>();
        
        this.player1 = player1;
        this.player2 = player2;
    }  

    public LocalTime getStartTime() {
        return this.start_time;
    }

    public void setStartTime(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEndTime() {
        return this.end_time;
    }

    public void setEndTime(LocalTime end_time) {
        this.end_time = end_time;
    }
    
    /*
        @params type (ONLINE_GAME, OFFLINE_GAME)
    */
    public String getTypeOfGame(String type) {
        return this.type_of_game;
    }

    public void setTypeOfGame(String type_of_game) {
        this.type_of_game = type_of_game;
    }

    public int getTotalRound() {
        return this.total_round;
    }

    public void setTotalRound(int total_round) {
        this.total_round = total_round;
    }

    public List<Round> getRoundList() {
        return this.round_list;
    }

    public void setRoundList(List<Round> round_list) {
        this.round_list = round_list;
    }
    
    public void startGame() {
        this.start_time = java.time.LocalTime.now();
        System.out.println("Game Mode: " + this.type_of_game + "Game begin time: " + this.start_time.toString());
    }
    
    public void endGame() {
        this.end_time = java.time.LocalTime.now();
        System.out.println("Game end at: " + this.end_time.toString());
    }
    
    public boolean isEndGame() { 
        return this.end_time != null;
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
}
