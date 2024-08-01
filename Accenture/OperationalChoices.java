
// Problem Statement

// You are required to implement the following function.

// Int OperationChoices(int c, int n, int a , int b )

// The function accepts 3 positive integers ‘a’ , ‘b’ and ‘c ‘ as its arguments. Implement the function to return.

// ( a+ b ) , if c=1
// ( a – b ) , if c=2
// ( a * b ) ,  if c=3
// (a / b) ,  if c =4
// Assumption : All operations will result in integer output.

// Example:

// Input
// c :1
// a:12
// b:16
// Output:
// Since ‘c’=1 , (12+16) is performed which is equal to 28 , hence 28 is returned.
// Sample Input

//  c : 2

//  a : 16

//  b : 20

// Sample Output
// -4

// Approach: We will take the input of three positive integers a, b, and c. We are required to implement the function to return (a + b), if c = 1, (a - b), if c = 2, (a * b), if c = 3, and (a / b), if c = 4. We will implement the function to return the result based on the value of c.

// Follow the below steps to implement the code:
// 1. Take the input of three positive integers a, b, and c.
// 2. Implement the function to return (a + b), if c = 1.
// 3. Implement the function to return (a - b), if c = 2.
// 4. Implement the function to return (a * b), if c = 3.
// 5. Implement the function to return (a / b), if c = 4.

public class OperationalChoices {

    public static void main(String[] args) {
        int c = 2;
        int a = 16;
        int b = 20;
        System.out.println(OperationChoices(c, a, b));
    }

    public static int OperationChoices(int c, int a, int b) {
        if (c == 1) {
            return a + b;
        } else if (c == 2) {
            return a - b;
        } else if (c == 3) {
            return a * b;
        } else {
            return a / b;
        }
    }
}
