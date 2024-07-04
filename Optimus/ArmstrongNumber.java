
// Write the code to for Armstrong number

// An Armstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.
// For example:
// 153 = 1^3 + 5^3 + 3^3
// 153 is an Armstrong number.

// Approach: To check if a number is an Armstrong number, we need to calculate the sum of the cube of each digit of the number. If the sum is equal to the original number, then the number is an Armstrong number.

public class ArmstrongNumber {

    public static boolean isArmstrong(int n) {
        int originalNumber = n;
        int numDigits = String.valueOf(n).length();
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, numDigits);
            n /= 10;
        }

        return sum == originalNumber;
    }

    public static void main(String[] args) {
        int n = 153;
        System.out.println(isArmstrong(n));
    }
}
