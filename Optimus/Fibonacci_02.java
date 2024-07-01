
// We have given a number n, we have to find the nth Fibonacci number.

// Input: 5
// Output: 1 1 2 3 5

// Approach 1: Using a while loop
// Time Complexity: O(n)
// Space Complexity: O(1)

// Follow this step to solve the problem:
// 1. Initialize two variables a and b to 1.
// 2. Iterate while n is greater than 0.
// 3. Print the value of a.
// 4. Update the value of a and b by swapping them.
// 5. Decrement the value of n by 1.


public class Fibonacci_02 {

    public static void fibonacci(int n) {
        int a = 1, b = 1;

        while (n > 0) {
            System.out.print(a + " ");
            int temp = a;
            a = b;
            b = temp + b;
            n--;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        fibonacci(n);
    }
    
}
