
// Implement the following Function 

// def differenceofSum(n. m)

// The function accepts two integers n, m as arguments Find the sum of all numbers in range from 1 to m(both inclusive) that are not divisible by n. Return difference between sum of integers not divisible by n with sum of numbers divisible by n.

// Assumption:

// n>0 and m>0
// Sum lies between integral range
// Example

// Input
// n:4
// m:20
// Output
// 90

// Explanation

// Sum of numbers divisible by 4 are 4 + 8 + 12 + 16 + 20 = 60
// Sum of numbers not divisible by 4 are 1 +2 + 3 + 5 + 6 + 7 + 9 + 10 + 11 + 13 + 14 + 15 + 17 + 18 + 19 = 150
// Difference 150 – 60 = 90
// Sample Input
// n:3
// m:10
// Sample Output
// 19

// Approach: We need to find the sum of all numbers in the range from 1 to m that are not divisible by n. We will iterate through the range from 1 to m and check if the number is not divisible by n. If the number is not divisible by n, we will add it to the sum. We will return the difference between the sum of numbers not divisible by n and the sum of numbers divisible by n.

// Follow the below steps to solve the problem:
// 1. Initialize two variables ‘sumNotDivisible’ and ‘sumDivisible’ to 0 to store the sum of numbers not divisible by n and the sum of numbers divisible by n.
// 2. Iterate through the range from 1 to m and check if the number is not divisible by n.
// 3. If the number is not divisible by n, add it to ‘sumNotDivisible’.
// 4. If the number is divisible by n, add it to ‘sumDivisible’.
// 5. Return the difference between ‘sumNotDivisible’ and ‘sumDivisible’.

public class DifferenceOfSum {

    public static int differenceOfSum(int n, int m) {
        int sumNotDivisible = 0;
        int sumDivisible = 0;
        for (int i = 1; i <= m; i++) {
            if (i % n != 0) {
                sumNotDivisible += i;
            } else {
                sumDivisible += i;
            }
        }
        return sumNotDivisible - sumDivisible;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 10;
        System.out.println(differenceOfSum(n, m));
    }
}
