
// You are given a function.
// int CheckPassword(char str[], int n);
// The function accepts string str of size n as an argument. Implement the function which returns 1 if given string str is valid password else 0.
// str is a valid password if it satisfies the below conditions.

// – At least 4 characters
// – At least one numeric digit
// – At Least one Capital Letter
// – Must not have space or slash (/)
// – Starting character must not be a number
// Assumption:
// Input string will not be empty.

// Example:

// Input 1:
// aA1_67
// Input 2:
// a987 abC012

// Output 1:
// 1
// Output 2:
// 0

// Approach: We need to check if the given string is a valid password or not. We will iterate through the string and check if the string satisfies the given conditions. We will maintain a variable ‘digit’ to check if the string has at least one numeric digit. We will maintain a variable ‘capital’ to check if the string has at least one capital letter. We will maintain a variable ‘space’ to check if the string has space or slash. We will check if the string has at least 4 characters. We will check if the starting character is not a number. If all the conditions are satisfied, we will return 1 else we will return 0.

// Follow the below steps to solve the problem:
// 1. Check if the string has at least 4 characters. If not, return 0.
// 2. Check if the starting character is a number. If yes, return 0.
// 3. Initialize a variable ‘digit’ to 0 to check if the string has at least one numeric digit.
// 4. Initialize a variable ‘capital’ to 0 to check if the string has at least one capital letter.
// 5. Initialize a variable ‘space’ to 0 to check if the string has space or slash.
// 6. Iterate through the string from 0 to n-1 and check if the string satisfies the given conditions.
// 7. If the character is a numeric digit, increment the ‘digit’.
// 8. If the character is a capital letter, increment the ‘capital’.
// 9. If the character is a space or slash, increment the ‘space’.
// 10. If the string has at least one numeric digit, at least one capital letter, and does not have space or slash, return 1.
// 11. If the string does not satisfy the given conditions, return 0.

public class PasswordChecker {

    public static int CheckPassword(String str, int n) {
        // check if the string has at least 4 characters, first character is not a
        // number, and the string has at least one numeric digit, at least one capital
        // letter, and does not have space or slash
        if (n < 4 || str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            return 0;
        }
        int digit = 0;
        int capital = 0;
        int space = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                digit++;
            }
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                capital++;
            }
            if (str.charAt(i) == ' ' || str.charAt(i) == '/') {
                space++;
            }
        }
        if (digit > 0 && capital > 0 && space == 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = "aA1_67";
        System.out.println(CheckPassword(str, str.length()));

        String str1 = "a987 abC012";
        System.out.println(CheckPassword(str1, str1.length()));
    }
}
