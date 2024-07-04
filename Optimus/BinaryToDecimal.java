
// Write a program to convert binary number to decimal number.

// Input: 1010
// Output: 10

// Approach: To convert a binary number to a decimal number, we need to iterate over each digit of the binary number from right to left. For each digit, we need to multiply the digit with 2 raised to the power of its position from the right. The sum of these products will be the decimal number.

public class BinaryToDecimal {

    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int n = binary.length();

        for (int i = 0; i < n; i++) {
            // Convert character to integer
            int digit = binary.charAt(i) - '0';
            // Calculate decimal number
            decimal += digit * Math.pow(2, n - i - 1);
        }

        return decimal;
    }

    public static void main(String[] args) {
        String binary = "1010";
        int decimal = binaryToDecimal(binary);
        System.out.println(decimal);
    }
}
