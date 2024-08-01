
// Problem Statement

// You are given a function,

// Int MaxExponents (int a , int b);

// You have to find and return the number between ‘a’ and ‘b’ ( range inclusive on both ends) which has the maximum exponent of 2.

// The algorithm to find the number with maximum exponent of 2 between the given range is

// Loop between ‘a’ and ‘b’. Let the looping variable be ‘i’.
// Find the exponent (power) of 2 for each ‘i’ and store the number with maximum exponent of 2 so faqrd in a variable , let say ‘max’. Set ‘max’ to ‘i’ only if ‘i’ has more exponent of 2 than ‘max’.
// Return ‘max’.
// Assumption: a <b

// Note: If two or more numbers in the range have the same exponents of  2 , return the small number.

// Example

// Input:
// 7
// 12
// Output:
// 8
// Explanation:

// Exponents of 2 in:

// 7-0

// 8-3

// 9-0

// 10-1

// 11-0

// 12-2

// Hence maximum exponent if two is of 8.

// Approach: We will take the input of two integers a and b. We have to find and return the number between a and b (range inclusive on both ends) which has the maximum exponent of 2. We will loop between a and b and find the exponent (power) of 2 for each i. We will store the number with the maximum exponent of 2 so far in a variable, let's say max. We will set max to i only if i has more exponent of 2 than max. Finally, we will return max.

// Follow the below steps to implement the code:
// 1. Take the input of two integers a and b.
// 2. Initialize a variable max to store the number with the maximum exponent of 2.
// 3. Loop between a and b.
// 4. Find the exponent (power) of 2 for each i.
// 5. Store the number with the maximum exponent of 2 so far in a variable max.
// 6. Set max to i only if i has more exponent of 2 than max.
// 7. Return max.

public class MaxExponentOf2 {

    public static void main(String[] args) {
        int a = 7;
        int b = 12;
        System.out.println(MaxExponents(a, b));

        int a1 = 1;
        int b1 = 10;
        System.out.println(MaxExponents(a1, b1));
    }

    public static int MaxExponents(int a, int b) {

        int maxExponent = 0;
        for (int i = a; i <= b; i++) {
            int exponent = 0;
            int num = i;
            while (num % 2 == 0) {
                exponent++;
                num /= 2;
            }
            if (exponent > maxExponent) {

                maxExponent = exponent;

            }
        }
        return maxExponent;
    }
}
