import java.math.BigDecimal;

public class EulerNumber {
    public static void main(String[] args) {
        int terms = 20; 
        
        BigDecimal eulerNumber = calculateEulerNumber(terms);
        
        System.out.println("Approximated value of Euler's number (e): " + eulerNumber);
    }

    public static BigDecimal calculateEulerNumber(int terms) {
        BigDecimal e = BigDecimal.ONE; 
        
        BigDecimal factorial = BigDecimal.ONE; 
        
        for (int i = 1; i < terms; i++) {
            factorial = factorial.multiply(BigDecimal.valueOf(i));
            
            BigDecimal term = BigDecimal.ONE.divide(factorial, 25, BigDecimal.ROUND_HALF_UP); 
            
            e = e.add(term); 
        }
        
        return e;
    }
}
