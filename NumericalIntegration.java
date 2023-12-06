public class NumericalIntegration {
    public static void main(String[] args) {
        double lowerLimit = 0.0;
        double upperLimit = 1.0;
        int numIntervals = 1000; // Increase for more accuracy
        
        double integral = calculateIntegral(lowerLimit, upperLimit, numIntervals);
        
        System.out.println("Approximated integral: " + integral);
    }

    public static double function(double x) {
        return x * x;
    }

    public static double calculateIntegral(double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0.5 * (function(a) + function(b));

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += function(x);
        }

        return sum * h;
    }
}
