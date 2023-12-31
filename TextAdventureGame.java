import java.util.Scanner;

public class TextAdventureGame {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Text Adventure Game!");

        boolean gameOver = false;
        int currentRoom = 1;

        while (!gameOver) {
            displayRoom(currentRoom);
            int choice = getPlayerChoice();

            switch (currentRoom) {
                case 1:
                    if (choice == 1) {
                        System.out.println("You chose to move to Room 2.");
                        currentRoom = 2;
                    } else {
                        System.out.println("You decided to stay in Room 1.");
                        System.out.println("Game Over!");
                        gameOver = true;
                    }
                    break;
                case 2:
                    if (choice == 1) {
                        System.out.println("You encountered a monster!");
                        System.out.println("You fought bravely and defeated the monster!");
                        System.out.println("Congratulations! You won the game!");
                        gameOver = true;
                    } else {
                        System.out.println("You decided to retreat to Room 1.");
                        currentRoom = 1;
                    }
                    break;
                default:
                    System.out.println("Invalid room!");
                    break;
            }
        }

        scanner.close();
    }

    public static void displayRoom(int roomNumber) {
        System.out.println("You are in Room " + roomNumber);
        System.out.println("What do you want to do?");
        if (roomNumber == 1) {
            System.out.println("1. Move to Room 2");
            System.out.println("2. Stay in Room 1");
        } else if (roomNumber == 2) {
            System.out.println("1. Fight the monster");
            System.out.println("2. Retreat to Room 1");
        }
    }

    public static int getPlayerChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
