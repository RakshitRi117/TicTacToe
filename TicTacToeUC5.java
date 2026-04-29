// Use Case 5: Validate Player Move
// Goal: Ensure the move is within bounds and the cell is empty.
// Actor: Game System

public class TicTacToeUC5 {

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

    // Utility Method: Validate the move
    // Defensive Programming: check all conditions before accepting move
    public static boolean isValidMove(int row, int col) {

        // Boundary Checking: row and column must be between 0 and 2
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid move! Row and column must be between 0 and 2.");
            return false;
        }

        // Conditional Logic: cell must be empty (not already X or O)
        if (board[row][col] != '-') {
            System.out.println("Invalid move! Cell (" + row + "," + col + ") is already occupied.");
            return false;
        }

        // Move is valid
        return true;
    }

    // Print the board
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

        // Step 1: Initialize board
        initializeBoard();
        printBoard();

        // Test Case 1: Valid move - empty cell within bounds
        System.out.println("\nTest 1: Move to (1,1)");
        if (isValidMove(1, 1)) {
            board[1][1] = 'X';  // Place X on valid cell
            System.out.println("Move accepted! X placed at (1,1)");
        }
        printBoard();

        // Test Case 2: Invalid move - cell already occupied
        System.out.println("\nTest 2: Move to (1,1) again");
        if (isValidMove(1, 1)) {
            board[1][1] = 'O';
        }

        // Test Case 3: Invalid move - out of bounds
        System.out.println("\nTest 3: Move to (3,3) - out of bounds");
        if (isValidMove(3, 3)) {
            board[3][3] = 'O';
        }
    }
}