import java.math.BigDecimal;

public class EulerNumber {
    public static void main(String[] args) {
        int terms = 20; // Number of terms to approximate e
        
        BigDecimal eulerNumber = calculateEulerNumber(terms);
        
        System.out.println("Approximated value of Euler's number (e): " + eulerNumber);
    }

    public static BigDecimal calculateEulerNumber(int terms) {
        BigDecimal e = BigDecimal.ONE; // Initialize e as 1
        
        BigDecimal factorial = BigDecimal.ONE; // Factorial starts from 1
        
        for (int i = 1; i < terms; i++) {
            factorial = factorial.multiply(BigDecimal.valueOf(i)); // Calculate factorial
            
            BigDecimal term = BigDecimal.ONE.divide(factorial, 25, BigDecimal.ROUND_HALF_UP); // Calculate 1/factorial
            
            e = e.add(term); // Add the term to e
        }
        
        return e;
    }
}
