public class Factorial {
    public static void main(String[] args) {
        int number = 5; // Change this number to calculate factorial for a different value
        
        long factorial = calculateFactorial(number);
        
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
    
    public static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}
