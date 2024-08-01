
// Problem Statement

// A carry is a digit that is transferred to left if sum of digits exceeds 9 while adding two numbers from right-to-left one digit at a time

// You are required to implement the following function.

// Int NumberOfCarries(int num1 , int num2);

// The functions accepts two numbers ‘num1’ and ‘num2’ as its arguments. You are required to calculate and return  the total number of carries generated while adding digits of two numbers ‘num1’ and ‘ num2’.

// Assumption: num1, num2>=0

// Example:

// Input
// Num 1: 451
// Num 2: 349
// Output
// 2
// Explanation:

// Adding ‘num 1’ and ‘num 2’ right-to-left results in 2 carries since ( 1+9) is 10. 1 is carried and (5+4=1) is 10, again 1 is carried. Hence 2 is returned.

// Sample Input

// Num 1: 23

// Num 2: 563

// Sample Output

// 0

// Approach: We will take the input of two numbers num1 and num2. We are required to calculate and return the total number of carries generated while adding digits of two numbers num1 and num2. We will iterate from right to left and add the digits of num1 and num2. If the sum of digits exceeds 9, we will increment the carry count. Finally, we will return the carry count.

// Follow the below steps to implement the code:
// 1. Take the input of two numbers num1 and num2.
// 2. Initialize a variable carry to store the total number of carries.
// 3. Initialize a variable sum to store the sum of digits of num1 and num2.
// 4. Initialize a variable carryCount to store the carry count.
// 5. Iterate from right to left.
// 6. Calculate the sum of digits of num1 and num2.
// 7. If the sum of digits exceeds 9, increment the carry count.
// 8. Update the carry to carryCount.
// 9. Return the carry count.

public class TotalNumberCarries {

    public static void main(String[] args) {
        int num1 = 23;
        int num2 = 563;
        System.out.println(NumberOfCarries(num1, num2));
    }

    public static int NumberOfCarries(int num1, int num2) {
        int carry = 0;
        int carryCount = 0;
        while (num1 > 0 || num2 > 0) {
            int sum = (num1 % 10) + (num2 % 10) + carry;
            if (sum > 9) {
                carryCount++;
                carry = 1;
            } else {
                carry = 0;
            }
            num1 /= 10;
            num2 /= 10;
        }
        return carryCount;
    }

    public static int numberOfCarries(int num1, int num2) {
        int count = 0;
        int temp1 = num1, temp2 = num2;
        int rem = 0;
        while (temp1 != 0 && temp2 != 0) {
            int d1 = temp1 % 10, d2 = temp2 % 10;
            if ((d1 + d2 + rem) > 9) {
                count++;
                int sum = d1 + d2 + rem;
                sum = sum / 10;
                rem = sum;
            }
            temp1 = temp1 / 10;
            temp2 = temp2 / 10;
        }
        while (temp1 != 0) {
            int d1 = temp1 % 10;
            if ((d1 + rem) > 9) {
                count++;
                int sum = d1 + rem;
                sum = sum / 10;
                rem = sum;
            }
            temp1 = temp1 / 10;
        }
        while (temp2 != 0) {
            int d2 = temp2 % 10;
            if ((d2 + rem) > 9) {
                count++;
                int sum = d2 + rem;
                sum = sum / 10;
                rem = sum;
            }
            temp2 = temp2 / 10;
        }
        return count;
    }
}
