public class GoldenRatioFibonacci {
    public static void main(String[] args) {
        int limit = 20; // Change this limit to generate Fibonacci sequence up to a different value
        
        System.out.println("Generating Fibonacci sequence up to " + limit + ":");
        int[] fibonacciSequence = generateFibonacciSequence(limit);
        displayArray(fibonacciSequence);

        double goldenRatio = calculateGoldenRatio(fibonacciSequence);
        System.out.println("\nApproximated Golden Ratio: " + goldenRatio);
    }

    public static int[] generateFibonacciSequence(int limit) {
        int[] fibonacci = new int[limit];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < limit; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci;
    }

    public static double calculateGoldenRatio(int[] fibonacciSequence) {
        double goldenRatio = 0.0;
        int length = fibonacciSequence.length;

        if (length > 2) {
            double previous = (double) fibonacciSequence[length - 2];
            double current = (double) fibonacciSequence[length - 1];
            goldenRatio = current / previous;
        }

        return goldenRatio;
    }

    public static void displayArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
