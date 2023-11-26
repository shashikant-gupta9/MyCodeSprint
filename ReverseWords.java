import java.util.Scanner;
import java.util.Stack;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> words = new Stack<>();

        System.out.println("Enter words (type 'exit' to end):");

        while (true) {
            String word = scanner.next();

            if (word.equals("exit")) {
                break;
            }

            words.push(word);
        }

        System.out.println("\nWords in reverse order:");

        while (!words.isEmpty()) {
            System.out.print(words.pop() + " ");
        }

        scanner.close();
    }
}
