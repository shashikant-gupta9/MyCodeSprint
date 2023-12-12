import java.util.*;

public class SieveOfEratostheness {
    public static void main(String[] args) {
        int n = 30; // Change this number to find primes within a different range
        System.out.println("Prime numbers up to " + n + ":");
        List<Integer> primes = getPrimes(n);
        System.out.println(primes);
    }

    public static List<Integer> getPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        List<Integer> primes = new ArrayList<>();

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
