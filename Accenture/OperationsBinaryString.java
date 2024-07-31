
// Problem Description :
// The Binary number system only uses two digits, 0 and 1 and number system can be called binary string. You are required to implement the following function:

// int OperationsBinaryString(char* str);

// The function accepts a string str as its argument. The string str consists of binary digits eparated with an alphabet as follows:

// – A denotes AND operation
// – B denotes OR operation
// – C denotes XOR Operation
// You are required to calculate the result of the string str, scanning the string to right taking one opearation at a time, and return the same.

// Note:

// No order of priorities of operations is required
// Length of str is odd
// If str is NULL or None (in case of Python), return -1
// Input:
// str: 1C0C1C1A0B1

// Output:
// 1

// Explanation:
// The alphabets in str when expanded becomes “1 XOR 0 XOR 1 XOR 1 AND 0 OR 1”, result of the expression becomes 1, hence 1 is returned.

// Sample Input:
// 0C1A1B1C1C1B0A0

// Output:
// 0

// Approach: We need to calculate the result of the binary string. We will iterate through the string and perform the operations as per the alphabets. We will maintain a variable ‘result’ to store the result of the operations. We will initialize the result with the first binary digit. We will iterate through the string from 1 to n-1 and perform the operations as per the alphabets. If the alphabet is ‘A’, we will perform the AND operation. If the alphabet is ‘B’, we will perform the OR operation. If the alphabet is ‘C’, we will perform the XOR operation. We will return the result after performing all the operations.

// Follow the below steps to solve the problem:
// 1. Check if the string is null. If yes, return -1.
// 2. Initialize a variable ‘result’ to store the result of the operations and initialize it with the first binary digit.
// 3. Iterate through the string from 1 to n-1 and perform the operations as per the alphabets.
// 4. If the alphabet is ‘A’, perform the AND operation.
// 5. If the alphabet is ‘B’, perform the OR operation.
// 6. If the alphabet is ‘C’, perform the XOR operation.
// 7. Return the result after performing all the operations.

public class OperationsBinaryString {

    public static int operationsBinaryString(String str) {
        if (str == null) {
            return -1;
        }
        int result = str.charAt(0) - '0'; // Initialize result with the first binary digit in the string
        for (int i = 1; i < str.length(); i += 2) {
            if (str.charAt(i) == 'A') {
                result = result & (str.charAt(i + 1) - '0');
            } else if (str.charAt(i) == 'B') {
                result = result | (str.charAt(i + 1) - '0');
            } else if (str.charAt(i) == 'C') {
                result = result ^ (str.charAt(i + 1) - '0');
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "1C0C1C1A0B1";
        System.out.println(operationsBinaryString(str));

        String str1 = "0C1A1B1C1C1B0A0";
        System.out.println(operationsBinaryString(str1));
    }
}
