
// Write a program to find the sum of Natural Numbers using Recursion.

// Input : 5
// Output : 15
// Explanation: 1 + 2 + 3 + 4 + 5 = 15

// Approach: To find the sum of natural numbers, we can use recursion. The base case for the recursion will be when the number becomes 0. In this case, we will return 0. Otherwise, we will return the sum of the number and the sum of the number - 1.

public class SumOfNaturalNumber {

    public static int sumOfNaturalNumbers(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumOfNaturalNumbers(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(sumOfNaturalNumbers(n));
    }
}
