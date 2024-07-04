
// Write a program to calculate the power of a number using a recursive function.
// Input: base = 2, exponent = 3
// Output: 8
// Explanation: 2 raised to the power of 3 is equal to 8.

// Approach: The power of a number can be calculated using a recursive function. The base case of the recursive function is when the exponent is 0, the power of the number is 1. If the exponent is greater than 0, then the power of the number is calculated by multiplying the base with the power function recursively called with the base and exponent - 1.

public class PowerOfNumber {

    public static int powerOfNumber(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * powerOfNumber(base, exponent - 1);
    }

    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        System.out.println(powerOfNumber(base, exponent)); // 8
    }

}
