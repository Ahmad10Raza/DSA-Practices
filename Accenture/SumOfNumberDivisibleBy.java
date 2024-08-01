
// Problem Statement

// You are required to implement the following function:

// Int Calculate(int m, int n);

// The function accepts 2 positive integer ‘m’ and ‘n’ as its arguments.You are required to calculate the sum of numbers divisible both by 3 and 5, between ‘m’ and ‘n’ both inclusive and return the same.
// Note
// 0 < m <= n

// Example

// Input:

// m : 12

// n : 50

// Output

// 90

// Explanation:
// The numbers divisible by both 3 and 5, between 12 and 50 both inclusive are {15, 30, 45} and their sum is 90.
// Sample Input
// m : 100
// n : 160
// Sample Output
// 510

// Approach: We will take the input of two positive integers m and n. We are required to calculate the sum of numbers divisible by both 3 and 5 between m and n, both inclusive. We will iterate from m to n and check if the number is divisible by both 3 and 5. If it is divisible, we will add it to the sum. Finally, we will return the sum.

// Follow the below steps to implement the code:
// 1. Take the input of two positive integers m and n.
// 2. Initialize a variable sum to store the sum of numbers divisible by both 3 and 5.
// 3. Iterate from m to n.
// 4. Check if the number is divisible by both 3 and 5.
// 5. If it is divisible, add it to the sum.
// 6. Return the sum.

public class SumOfNumberDivisibleBy {

    public static void main(String[] args) {
        int m = 12;
        int n = 50;
        System.out.println(Calculate(m, n));
    }

    public static int Calculate(int m, int n) {
        int sum = 0;
        for (int i = m; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
