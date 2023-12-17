import java.util.Scanner;

class AdventureGame {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Adventure Game!");

        // Game introduction
        System.out.println("You find yourself in a mysterious house...");
        System.out.println("Your goal is to find the treasure.");

        // Start the game
        exploreHouse();
    }

    private static void exploreHouse() {
        while (true) {
            System.out.println("\nYou are in a room. What do you want to do?");
            System.out.println("1. Go to the next room");
            System.out.println("2. Search the room");
            System.out.println("3. Quit the game");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    System.out.println("You move to the next room.");
                    // Implement logic to move to the next room or generate a new room
                    // You can use a map or predefined rooms connected to each other
                    break;
                case 2:
                    System.out.println("You search the room...");
                    // Implement logic to search the room for items, clues, monsters, etc.
                    break;
                case 3:
                    System.out.println("Exiting the game. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next(); // Consume invalid input
        }
        return scanner.nextInt();
    }
}
