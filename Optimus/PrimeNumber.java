
// Write a program to check if a number is prime or not.

// Input: 5
// Output: Prime

// Approach: The idea is to iterate from 2 to sqrt(n) and check if the number is divisible by any number in this range. If the number is divisible by any number in this range, then the number is not prime. Otherwise, the number is prime.

public class PrimeNumber {

    public static String isPrime(int n) {
        if (n <= 1) {
            return "Not Prime";
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return "Not Prime";
            }
        }
        return "Prime";
    }

    // Function for prime upto n
    public static void primeUptoN(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i).equals("Prime")) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(isPrime(n));
    }
}
