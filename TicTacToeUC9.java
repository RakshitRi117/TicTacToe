// Use Case 9: Random Toss and Symbol Assignment
// Goal: Randomly decide which player starts and assign X or O to each player.
// Actor: Game System – automatically performs the toss and assigns roles.

import java.util.Random;

public class TicTacToeUC9 {

    // Game State Variables
    static String player1Symbol;
    static String player2Symbol;
    static String currentPlayer;

    // Method to perform toss and assign symbols
    public static void performToss() {
        Random random = new Random();

        // Random Number Generation: 0 = Player 1 starts, 1 = Player 2 starts
        int tossResult = random.nextInt(2);

        // Conditional Logic: assign symbols based on toss result
        if (tossResult == 0) {
            // Player 1 wins the toss
            currentPlayer = "Player 1";
            player1Symbol = "X";
            player2Symbol = "O";
        } else {
            // Player 2 wins the toss
            currentPlayer = "Player 2";
            player2Symbol = "X";
            player1Symbol = "O";
        }
    }

    // Method to display toss result
    public static void displayResult() {
        System.out.println("=== TOSS RESULT ===");
        System.out.println(currentPlayer + " wins the toss and goes first!");
        System.out.println("Player 1 Symbol : " + player1Symbol);
        System.out.println("Player 2 Symbol : " + player2Symbol);
        System.out.println("Current Player  : " + currentPlayer + " (" 
                           + (currentPlayer.equals("Player 1") ? player1Symbol : player2Symbol) + ")");
        System.out.println("===================");
    }

    public static void main(String[] args) {
        // Step 1: Perform the toss
        performToss();

        // Step 2: Display the result
        displayResult();
    }
}