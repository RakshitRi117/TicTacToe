// Use Case 7: Computer Makes a Random Valid Move
// Goal: Allow the computer to make a random valid move.
// Actor: Computer Player

import java.util.Random;

public class TicTacToeUC7 {

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

    // Logic Reuse: reused from UC4 - convert slot to row
    public static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    // Logic Reuse: reused from UC4 - convert slot to column
    public static int getCol(int slot) {
        return (slot - 1) % 3;
    }

    // Logic Reuse: reused from UC5 - validate the move
    public static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        if (board[row][col] != '-') {
            return false;
        }
        return true;
    }

    // Logic Reuse: reused from UC6 - update board with symbol
    public static void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Computer Move Method
    // Random Generation: generates random slot 1-9
    // Loop Until Valid: keeps trying until a valid move is found
    public static void computerMove() {
        Random random = new Random();
        int slot, row, col;

        // Loop Until Valid: keep generating until an empty cell is found
        do {
            slot = random.nextInt(9) + 1;   // Random Generation: slot between 1 and 9
            row  = getRow(slot);             // Convert slot to row
            col  = getCol(slot);             // Convert slot to column
        } while (!isValidMove(row, col));    // Repeat if cell is already occupied

        // Valid move found - place computer's symbol
        updateBoard(row, col, 'O');
        System.out.println("Computer chose slot " + slot + " → row " + row + ", col " + col);
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

        // Step 2: Player places X manually at slot 5
        System.out.println("\nPlayer places X at slot 5 (row 1, col 1):");
        updateBoard(1, 1, 'X');
        printBoard();

        // Step 3: Computer makes its random valid move
        System.out.println("\nComputer is making a move...");
        computerMove();
        printBoard();

        // Step 4: Computer makes another move
        System.out.println("\nComputer is making another move...");
        computerMove();
        printBoard();
    }
}