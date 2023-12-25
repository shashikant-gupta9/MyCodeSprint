import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[] choices = {"rock", "paper", "scissors"};
        
        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println("Enter your choice: rock, paper, or scissors");
        String playerChoice = scanner.nextLine().toLowerCase();
        
        int computerChoiceIndex = random.nextInt(3);
        String computerChoice = choices[computerChoiceIndex];
        
        System.out.println("Computer's choice: " + computerChoice);
        
        // Determine the winner
        if (playerChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }
        
        scanner.close();
    }
}
