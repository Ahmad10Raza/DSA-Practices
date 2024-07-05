
// Write a Program to Find the Prime Factors of a Number.

// A prime factor is a factor of a number that is a prime number. For example, the prime factors of 12 are 2 and 3.

// Example
// Input: 12
// Output: 2, 3

// Approach: We can find the prime factors of a number by following the below steps:
// 1. Initialize a variable num with the given number.
// 2. Initialize a variable i with 2.
// 3. While i is less than or equal to num, do the following:
//    a. If num is divisible by i, then i is a prime factor of num. Print i.
//    b. Divide num by i.
//    c. If num is not divisible by i, increment i by 1.
// 4. If num is greater than 1, then num is a prime factor of the given number. Print num.

// The time complexity of this approach is O(sqrt(n)), where n is the given number.

public class PrimeFactorOfNumber {

    public static void FindPrimeFactors(int num) {
        int i = 2;
        while (i <= num) {
            if (num % i == 0) {
                System.out.print(i + " ");
                num = num / i;
            } else {
                i++;
            }
        }
        if (num > 1) {
            System.out.print(num);
        }
    }

    public static void main(String[] args) {
        FindPrimeFactors(12);
    }
}
