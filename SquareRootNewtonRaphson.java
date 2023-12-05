public class SquareRootNewtonRaphson {

    // Function to find the square root using Newton-Raphson method
    public static double squareRoot(double number) {
        double epsilon = 0.000001; // Small value to determine convergence
        double guess = number / 2.0; // Initial guess for the square root

        while (Math.abs(guess * guess - number) > epsilon) {
            guess = (guess + number / guess) / 2.0; // Update the guess using the formula
        }

        return guess;
    }

    public static void main(String[] args) {
        double number = 25.0; // The number for which we want to find the square root

        double sqrt = squareRoot(number);

        System.out.println("Square root of " + number + " is: " + sqrt);
    }
}
