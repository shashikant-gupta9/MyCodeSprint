import java.util.Random;

public class DiceRoll {
    public static void main(String[] args) {
        Random random = new Random();
        int min = 1; // Minimum value of a dice
        int max = 6; // Maximum value of a dice

        // Simulate a dice roll
        int result = random.nextInt(max - min + 1) + min;

        System.out.println("You rolled a: " + result);
    }
}
