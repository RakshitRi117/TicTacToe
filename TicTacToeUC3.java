// Use Case 3: Player Input Handling
// Goal: Allow the user to enter a slot number between 1 and 9.
// Actor: Human Player

import java.util.Scanner;

public class TicTacToeUC3 {

    // Method to get player input
    // Separation of Concerns: input logic is isolated in its own method
    public static int getPlayerInput() {
        Scanner scanner = new Scanner(System.in);

        // User Input Handling: read integer input from the player
        System.out.print("Enter a slot number (1-9): ");
        int slot = scanner.nextInt();

        // Return the slot value back to game logic
        return slot;
    }

    public static void main(String[] args) {
        // Step 1: Get input from the player
        int selectedSlot = getPlayerInput();

        // Step 2: Control returns to game logic
        System.out.println("You selected slot: " + selectedSlot);
    }
}