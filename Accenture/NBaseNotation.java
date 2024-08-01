
// N-base notation is a system for writing numbers that uses only n different symbols, This symbols are the first n symbols from the given notation list(Including the symbol for o) Decimal to n base notation are (0:0, 1:1, 2:2, 3:3, 4:4, 5:5, 6:6, 7:7, 8:8, 9:9, 10:A,11:B and so on upto 35:Z)

// Implement the following function

// Char* DectoNBase(int n, int num):

// The function accept positive integer n and num Implement the function to calculate the n-base equivalent of num and return the same as a string

// Steps:

// Divide the decimal number by n,Treat the division as the integer division
// Write the the remainder (in  n-base notation)
// Divide the quotient again by n, Treat the division as integer division
// Repeat step 2 and 3 until the quotient is 0
// The n-base value is the sequence of the remainders from last to first
// Assumption:
// 1 < n < = 36

// Example

// Input
// n: 12
// num: 718

// Output
// 4BA

// Explanation
// num       Divisor       quotient       remainder
// 718           12               59                 10(A)
// 59             12                4                   11(B)
// 4               12                0                   4(4)

// Sample Input
// n: 21
// num: 5678

// Sample Output
// CI8

// Approach: We will take the input of two integers n and num. We are required to calculate the n-base equivalent of num and return the same as a string. We will divide the decimal number by n and treat the division as integer division. We will write the remainder in n-base notation. We will divide the quotient again by n and treat the division as integer division. We will repeat steps 2 and 3 until the quotient is 0. The n-base value is the sequence of the remainders from last to first. Finally, we will return the n-base value as a string.

// Follow the below steps to implement the code:
// 1. Take the input of two integers n and num.
// 2. Initialize a variable result to store the n-base equivalent of num.
// 3. Initialize a variable i to store the index of the result.
// 4. Iterate until the quotient is 0.
// 5. Calculate the remainder by dividing the num by n.
// 6. If the remainder is less than 10, add the remainder to the result.
// 7. If the remainder is greater than 10, add the remainder in n-base notation to the result.
// 8. Update the num to quotient.
// 9. Return the result.

public class NBaseNotation {

    public static void main(String[] args) {
        int n = 12;
        int num = 718;
        System.out.println(DectoNBase(n, num));

        int n1 = 21;
        int num1 = 567846549;
        System.out.println(DectoNBase(n1, num1));
    }

    public static String DectoNBase(int n, int num) {
        char[] nBase = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] result = new char[100];
        int i = 0;
        while (num > 0) {
            int rem = num % n;
            if (rem < 10) {
                // If the remainder is less than 10, add the remainder to the result.
                result[i++] = (char) (rem + '0');
            } else {
                // If the remainder is greater than 10, add the remainder in n-base notation to
                // the result.
                result[i++] = nBase[rem];
            }
            num = num / n;
        }

        // Return the result.
        StringBuilder sb = new StringBuilder();
        // The n-base value is the sequence of the remainders from last to first.
        for (int j = i - 1; j >= 0; j--) {
            sb.append(result[j]);
        }
        return sb.toString();
    }
}
