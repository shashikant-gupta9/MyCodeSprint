import java.util.Random;
import java.util.Scanner;

public class MathQuizGame {

    public static void main(String[] args) {
        System.out.println("Welcome to the Math Quiz Game!");
        System.out.println("You will be asked a series of math questions. Let's get started!");

        int numberOfQuestions = 5; // You can change this to adjust the number of questions
        int score = startMathQuiz(numberOfQuestions);

        System.out.println("\nQuiz completed! Your score: " + score + " out of " + numberOfQuestions);
    }

    private static int startMathQuiz(int numberOfQuestions) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 1; i <= numberOfQuestions; i++) {
            int num1 = random.nextInt(20) + 1; // Random number between 1 and 20
            int num2 = random.nextInt(20) + 1;

            char operator = (random.nextBoolean()) ? '+' : '-'; // Randomly choose addition or subtraction

            int correctAnswer = (operator == '+') ? num1 + num2 : num1 - num2;

            System.out.print("\nQuestion " + i + ": " + num1 + " " + operator + " " + num2 + " = ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("Correct! Well done.");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswer);
            }
        }

        scanner.close();
        return score;
    }
}
