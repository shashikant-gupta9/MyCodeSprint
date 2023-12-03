import java.util.Scanner;

public class WordReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // Your code to reverse the order of words goes here
        StringBuilder rev = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            rev.append(input.charAt(i));
        }

        System.out.println("Reversed sentence: " + rev);

        scanner.close();
    }
}

