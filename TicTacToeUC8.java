// Use Case 8: Main Game Loop
// Goal: Continue gameplay until win or draw is detected.
// Actor: Game System

import java.util.Random;
import java.util.Scanner;

public class TicTacToeUC8 {

    // 2D array representing the Tic-Tac-Toe board
    static char[][] board = new char[3][3];

    // Game State Flags
    static boolean gameOver   = false;   // tracks if game has ended
    static boolean isDraw     = false;   // tracks if game is a draw
    static int     totalMoves = 0;       // tracks number of moves made

    // ─── Board Methods ────────────────────────────────────────────────────────

    public static void initializeBoard() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                board[row][col] = '-';
    }

    public static void printBoard() {
        System.out.println("\nCurrent Board:");
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

    // ─── Logic Reuse from UC4 ─────────────────────────────────────────────────

    public static int getRow(int slot) { return (slot - 1) / 3; }
    public static int getCol(int slot) { return (slot - 1) % 3; }

    // ─── Logic Reuse from UC5 ─────────────────────────────────────────────────

    public static boolean isValidMove(int row, int col) {
        return (row >= 0 && row <= 2 && col >= 0 && col <= 2 && board[row][col] == '-');
    }

    // ─── Logic Reuse from UC6 ─────────────────────────────────────────────────

    public static void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;
        totalMoves++;                    // Game State Flag: increment move count
    }

    // ─── Win Check ────────────────────────────────────────────────────────────

    public static boolean checkWin(char symbol) {
        // Check all 3 rows
        for (int r = 0; r < 3; r++)
            if (board[r][0] == symbol && board[r][1] == symbol && board[r][2] == symbol)
                return true;

        // Check all 3 columns
        for (int c = 0; c < 3; c++)
            if (board[0][c] == symbol && board[1][c] == symbol && board[2][c] == symbol)
                return true;

        // Check diagonal (top-left to bottom-right)
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;

        // Check diagonal (top-right to bottom-left)
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;

        return false;
    }

    // ─── Draw Check ───────────────────────────────────────────────────────────

    public static boolean checkDraw() {
        return totalMoves == 9;          // Game State Flag: all 9 cells filled = draw
    }

    // ─── Player Move (Logic Reuse from UC3) ───────────────────────────────────

    public static void playerMove(char symbol) {
        Scanner scanner = new Scanner(System.in);
        int slot, row, col;

        // Keep asking until valid slot is entered
        do {
            System.out.print("Your turn (" + symbol + ") - Enter slot (1-9): ");
            slot = scanner.nextInt();
            row  = getRow(slot);
            col  = getCol(slot);
            if (!isValidMove(row, col))
                System.out.println("Invalid move! Try again.");
        } while (!isValidMove(row, col));

        updateBoard(row, col, symbol);
    }

    // ─── Computer Move (Logic Reuse from UC7) ─────────────────────────────────

    public static void computerMove(char symbol) {
        Random random = new Random();
        int slot, row, col;

        do {
            slot = random.nextInt(9) + 1;
            row  = getRow(slot);
            col  = getCol(slot);
        } while (!isValidMove(row, col));

        updateBoard(row, col, symbol);
        System.out.println("Computer placed " + symbol + " at slot " + slot);
    }

    // ─── Turn Switching ───────────────────────────────────────────────────────

    public static char switchTurn(char current) {
        return (current == 'X') ? 'O' : 'X';  // Turn Switching: X→O or O→X
    }

    // ─── Main Game Loop ───────────────────────────────────────────────────────

    public static void main(String[] args) {

        initializeBoard();
        printBoard();

        char currentSymbol = 'X';        // Player starts with X
        char computerSymbol = 'O';       // Computer plays O

        // While Loop: keep playing until win or draw
        while (!gameOver) {

            // Player's turn
            playerMove(currentSymbol);
            printBoard();

            // Check win after player move
            if (checkWin(currentSymbol)) {
                System.out.println("\n🎉 You win! Congratulations!");
                gameOver = true;         // Game State Flag: stop the loop
                break;
            }

            // Check draw after player move
            if (checkDraw()) {
                System.out.println("\n🤝 It's a draw!");
                gameOver = true;         // Game State Flag: stop the loop
                break;
            }

            // Computer's turn
            System.out.println("\nComputer is thinking...");
            computerMove(computerSymbol);
            printBoard();

            // Check win after computer move
            if (checkWin(computerSymbol)) {
                System.out.println("\n💻 Computer wins! Better luck next time.");
                gameOver = true;         // Game State Flag: stop the loop
                break;
            }

            // Check draw after computer move
            if (checkDraw()) {
                System.out.println("\n🤝 It's a draw!");
                gameOver = true;         // Game State Flag: stop the loop
                break;
            }

            // Turn Switching: alternate between player and computer
            currentSymbol  = switchTurn(currentSymbol);
            computerSymbol = switchTurn(computerSymbol);
        }

        System.out.println("\nGame Over! Thanks for playing.");
    }
}