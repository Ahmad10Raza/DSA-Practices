
// Write a Program to Find out the Sum of Digits of a Number.
// Input: 123
// Output: 6
// Explanation: The sum of the digits of the number 123 is 1 + 2 + 3 = 6.

// Approach: Iterate over the number and extract the last digit of the number by taking the modulo of 10. Add the last digit to the sum of the digits. Update the number by dividing it by 10. Continue this process until the number becomes 0.

public class SumOfDigitOfNumber {

    public static int sumOfDigitOfNumber(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigitOfNumber(123)); // 6
    }

}
