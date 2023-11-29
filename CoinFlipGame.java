import java.util.Random;
import java.util.Scanner;

public class CoinFlipGame {

    public static void main(String[] args) {
        System.out.println("Welcome to the Coin Flip Game!");
        System.out.println("Can you guess the outcome? Enter 'H' for Heads or 'T' for Tails:");

        char userGuess = getUserGuess();
        char coinResult = flipCoin();

        System.out.println("The coin landed on: " + coinResult);

        if (userGuess == coinResult) {
            System.out.println("Congratulations! You guessed correctly!");
        } else {
            System.out.println("Oops! You guessed wrong. Better luck next time!");
        }
    }

    private static char getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        char userGuess;

        do {
            System.out.print("Enter your guess (H/T): ");
            userGuess = scanner.next().toUpperCase().charAt(0);
        } while (userGuess != 'H' && userGuess != 'T');

        return userGuess;
    }

    private static char flipCoin() {
        Random random = new Random();
        return random.nextBoolean() ? 'H' : 'T';
    }
}
