
package Main;

import BattleShipEntity.Ship;
import Game.Game;

import Player.Computer;
import Player.Human;

import java.util.Scanner;

/**
 *
 * @author Duc Nguyen
 */
public class A2_ClassDiagram {
    
    /**
     * @description In this main testing class, I simulate human vs computer
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create players
        //      1 human and 1 computer
        Human humanPlayer = new Human(1, "Player 1");
        Computer computerPlayer = new Computer(2, "Computer");

        // Create a new game between human and computer
        Game battleShipGame = new Game("Human vs Computer", humanPlayer, computerPlayer);

        // Start the game
        battleShipGame.startGame();
        
        // Add game to game history of each player
        humanPlayer.addGame(battleShipGame);
        computerPlayer.addGame(battleShipGame);
        
        // Create ships for both players
        // Ship is created :
        //      ship_id, ship_size, ship_value, ship_health, ship own by
        Ship humanShip1 = new Ship(1, 1, 5, 1,humanPlayer); 
        Ship humanShip2 = new Ship(2, 2, 7, 2, humanPlayer); 
        
        Ship computerShip1 = new Ship(3, 1, 5, 1, computerPlayer); 
        Ship computerShip2 = new Ship(4, 2, 7, 2, computerPlayer); 

        // Add ships to both players
        //      In this demo, I only add 2 ship to each player, for best testing
        humanPlayer.addShip(humanShip1);
        humanPlayer.addShip(humanShip2);
        computerPlayer.addShip(computerShip1);
        computerPlayer.addShip(computerShip2);

        // Manually place ships on the grid
        //      In the future, this can be developed furthermore, however in this assigment I manually set the position
        // @params: x: x_coordinate , y: y_coordinate, ishorizontal: check the position of the ship
        humanShip1.setShipPosition(1, 1, true); 
        humanShip2.setShipPosition(5, 5, false); 
        
        computerShip1.setShipPosition(3, 3, true);
        computerShip2.setShipPosition(7, 7, false); 

        // Display the ship information (optional)
        System.out.println("Human Player Ship Info:");
        humanPlayer.getShipList();
        System.out.println("Computer Player Ship Info:");
        computerPlayer.getShipList();

        // Battle loop: check if game is ended or not
        //      Players will fire torpedoes until one player loses all ships
        while (!battleShipGame.isEndGame()) {
            // Human player's turn to shot torpedo
            System.out.println("\n------------------------------------------------------------------------------");
            System.out.println("\nHuman Player's turn to fire. Enter coordinates - enter x first and y (x y): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            humanPlayer.shotTorpedo(x, y);

            // Check if human hits any of the computer's ships
            if (computerShip1.isHit(x, y)) {
                System.out.println("Human hit Computer's Ship 1!");
                computerShip1.takeDamage();
                if (computerShip1.isEliminate()) {
                    System.out.println("Computer's Ship 1 is eliminated!");
                }
            } else if (computerShip2.isHit(x, y)) {
                System.out.println("Human hit Computer's Ship 2!");
                computerShip2.takeDamage();
                if (computerShip2.isEliminate()) {
                    System.out.println("Computer's Ship 2 is eliminated!");
                }
            } else {
                System.out.println("Human missed!");
            }

            // Check if the computer has lost all ships
            if (computerShip1.isEliminate() && computerShip2.isEliminate()) {
                System.out.println("Computer has lost all ships! Human wins!");
                humanPlayer.collectScoreAfterGame("win");
                computerPlayer.collectScoreAfterGame("lose");
                // End the game
                battleShipGame.endGame();
                break;
            }

            // Computer player's turn to fire (randomly choose coordinates for simplicity)
            int computerX = (int) (Math.random() * 8);
            int computerY = (int) (Math.random() * 8);
            System.out.println("\nComputer fires at coordinates: (" + computerX + ", " + computerY + ")");
            computerPlayer.shotTorpedo(computerX, computerY);

            // Check if computer hits any of the human's ships
            if (humanShip1.isHit(computerX, computerY)) {
                System.out.println("Computer hit Human's Ship 1!");
                humanShip1.takeDamage();
                if (humanShip1.isEliminate()) {
                    System.out.println("Human's Ship 1 is eliminated!");
                }
            } else if (humanShip2.isHit(computerX, computerY)) {
                System.out.println("Computer hit Human's Ship 2!");
                humanShip2.takeDamage();
                if (humanShip2.isEliminate()) {
                    System.out.println("Human's Ship 2 is eliminated!");
                }
            } else {
                System.out.println("Computer missed!");
            }

            // Check if the human has lost all ships
            if (humanShip1.isEliminate() && humanShip2.isEliminate()) {
                System.out.println("Human has lost all ships! Computer wins!");
                computerPlayer.collectScoreAfterGame("win");
                humanPlayer.collectScoreAfterGame("lose");
                battleShipGame.endGame();
                break;
            }
        }

        // End the game
        battleShipGame.endGame();

        // Show final scores
        System.out.println("\nFinal Scores:");
        System.out.println(humanPlayer.getName() + " Score: " + humanPlayer.getScore());
        System.out.println(computerPlayer.getName() + " Score: " + computerPlayer.getScore());
    }
}
