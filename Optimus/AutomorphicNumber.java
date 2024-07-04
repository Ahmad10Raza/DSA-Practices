
// An automorphic number is a number whose square ends with the number itself. For example, 5 is an automorphic number, 5^2 = 25. Write a program to check if a number is an automorphic number or not.

// Input: 5
// Output: Automorphic number

// Input: 6
// Output: Not an automorphic number

// Approach: To check if a number is an automorphic number, we need to calculate the square of the number and check if the square ends with the number itself. To check if the square ends with the number, we can convert the square and the number to strings and compare the last digits of the strings.

public class AutomorphicNumber {

    public static boolean isAutomorphic(int num) {
        // Calculate square of the number
        int square = num * num;

        // Convert number and square to strings
        String numStr = String.valueOf(num);
        // Convert square to string
        String squareStr = String.valueOf(square);

        // Check if square ends with the number
        return squareStr.endsWith(numStr);
    }

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 6;

        if (isAutomorphic(num1)) {
            System.out.println("Automorphic number");
        } else {
            System.out.println("Not an automorphic number");
        }

        if (isAutomorphic(num2)) {
            System.out.println("Automorphic number");
        } else {
            System.out.println("Not an automorphic number");
        }
    }
}
