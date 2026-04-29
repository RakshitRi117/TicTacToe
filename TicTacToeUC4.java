// Use Case 4: Convert Slot Number to Row and Column Indices
// Goal: Convert user-entered slot number (1-9) into row and column indices.
// Actor: Human Player

public class TicTacToeUC4 {

    // Utility Method: converts slot number to row index
    // Mathematical Mapping using Division
    // Zero-based Indexing: row 0, 1, 2
    public static int getRow(int slot) {
        return (slot - 1) / 3;  // slot 1-3 → row 0, slot 4-6 → row 1, slot 7-9 → row 2
    }

    // Utility Method: converts slot number to column index
    // Mathematical Mapping using Modulo
    // Zero-based Indexing: col 0, 1, 2
    public static int getCol(int slot) {
        return (slot - 1) % 3;  // slot 1,4,7 → col 0, slot 2,5,8 → col 1, slot 3,6,9 → col 2
    }

    public static void main(String[] args) {

        // Test all slots 1-9 and display their row & column
        System.out.println("Slot → Row & Column Mapping:");
        System.out.println("-----------------------------");
        System.out.println("Slot | Row | Column");
        System.out.println("-----------------------------");

        for (int slot = 1; slot <= 9; slot++) {
            int row = getRow(slot);
            int col = getCol(slot);
            System.out.println("  " + slot + "  |  " + row + "  |   " + col);
        }

        System.out.println("-----------------------------");

        // Example: user enters slot 5
        int userSlot = 5;
        System.out.println("\nUser entered slot: " + userSlot);
        System.out.println("Converted to → Row: " + getRow(userSlot) + ", Column: " + getCol(userSlot));
    }
}