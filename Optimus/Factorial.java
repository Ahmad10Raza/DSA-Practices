
// We need to find the factorial of a number.

// Input : 5
// Output : 120

// Approach: The factorial of a number n is the product of all positive integers less than or equal to n.
// We can calculate the factorial of a number using recursion or iteration.

public class Factorial {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
    }
}
