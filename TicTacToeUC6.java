// Use Case 6: Update Board with Player Symbol
// Goal: Update the board with the given symbol after a valid move.
// Actor: Human Player / Computer Player

public class TicTacToeUC6 {

    // 2D array representing the Tic-Tac-Toe board
    static char[][] board = new char[3][3];

    // Initialize board with empty '-' placeholders
    public static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    // Reusable Method: Update board with given symbol
    // State Update: places the symbol at the correct position
    // Array Indexing: directly accesses board[row][col]
    public static void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;   // State Update: board is now changed
        System.out.println("Board updated! '" + symbol + "' placed at row " + row + ", col " + col);
    }

    // Reusable Method: Print the board
    public static void printBoard() {
        System.out.println("Current Board:");
        System.out.println("-----------");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    public static void main(String[] args) {

        // Step 1: Initialize the board
        initializeBoard();
        printBoard();

        // Step 2: Player 1 places X at slot 1 → row 0, col 0
        System.out.println("\nPlayer 1 places X at slot 1 (row 0, col 0):");
        updateBoard(0, 0, 'X');
        printBoard();

        // Step 3: Player 2 places O at slot 5 → row 1, col 1
        System.out.println("\nPlayer 2 places O at slot 5 (row 1, col 1):");
        updateBoard(1, 1, 'O');
        printBoard();

        // Step 4: Player 1 places X at slot 9 → row 2, col 2
        System.out.println("\nPlayer 1 places X at slot 9 (row 2, col 2):");
        updateBoard(2, 2, 'X');
        printBoard();
    }
}