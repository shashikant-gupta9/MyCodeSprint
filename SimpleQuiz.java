import java.util.Scanner;

public class SimpleQuiz{

    public static void main(String[] args) {
        System.out.println("Welcome to the Simple Quiz!");
        System.out.println("Answer the following questions:");

        int score = startQuiz();

        System.out.println("\nQuiz completed! Your score: " + score + " out of 3");
        if (score == 3) {
            System.out.println("Great job! You got all the questions right!");
        } else {
            System.out.println("Better luck next time. Keep learning!");
        }
    }

    private static int startQuiz() {
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        // Question 1
        System.out.println("\nQuestion 1: What is the capital of France?");
        System.out.println("a) Berlin");
        System.out.println("b) Madrid");
        System.out.println("c) Paris");
        char answer1 = scanner.next().charAt(0);
        if (answer1 == 'c' || answer1 == 'C') {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is Paris.");
        }

        // Question 2
        System.out.println("\nQuestion 2: Which planet is known as the Red Planet?");
        System.out.println("a) Mars");
        System.out.println("b) Venus");
        System.out.println("c) Jupiter");
        char answer2 = scanner.next().charAt(0);
        if (answer2 == 'a' || answer2 == 'A') {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is Mars.");
        }

        // Question 3
        System.out.println("\nQuestion 3: What programming language is this quiz written in?");
        System.out.println("a) Java");
        System.out.println("b) Python");
        System.out.println("c) C++");
        char answer3 = scanner.next().charAt(0);
        if (answer3 == 'a' || answer3 == 'A') {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is Java.");
        }

        scanner.close();
        return score;
    }
}
