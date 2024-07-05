
// Write a program to add two fractions.

// Input: 1/3 + 3/9
// Output: 2/3

// Approach: We can add two fractions by following below steps:
// 1. Find the LCM of the denominators of the fractions.
// 2. Multiply the numerators of the fractions with the LCM/denominator of the
// fraction.
// 3. Add the numerators of the fractions.
// 4. Find the GCD of the numerator and denominator of the result.
// 5. Divide the numerator and denominator of the result by the GCD to get the
// final result.

public class AddTwoFraction {

    public static void AddFraction(int num1, int den1, int num2, int den2) {
        int den3 = den1 * den2;
        int num3 = num1 * den2 + num2 * den1;
        int gcd = GCD(num3, den3);
        num3 = num3 / gcd;
        den3 = den3 / gcd;
        System.out.println(num3 + "/" + den3);
    }

    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    public static void main(String[] args) {
        AddFraction(1, 3, 3, 9);
    }
}