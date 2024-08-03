
// Given a positive integer n, find the smallest integer which has exactly the
// same digits existing in the integer n and is greater in value than n. If no
// such positive integer exists, return -1.

// Note that the returned integer should fit in 32-bit integer, if there is a
// valid answer but it does not fit in 32-bit integer, return -1.

// Example 1:
// Input: n = 12
// Output: 21
// Explanation: The next greater number to 12 is 21.

// Example 2:
// Input: n = 21
// Output: -1
// Explanation: No greater number than 21 exists.

// Approach: We will convert the given number to a character array. We will
// traverse the array from right to left. We will keep popping the elements from
// the stack until we find the element which is greater than the current
// element. If we don't find any element greater than the current element, we
// will push -1 in the resultant array. If we find the element greater than the
// current element, we will push that element in the resultant array. We will
// push the index of the element in the stack. We will keep doing this until we
// reach the end of the array. At the end, we will have the resultant array with
// the next greater element for every element in the array. We will convert the
// resultant array to a number and return it.

// Follow below steps to solve the problem:
// 1. Convert the given number to a character array.
// 2. Create a stack to store the index of the elements.
// 3. Create a resultant array to store the next greater element for every
// element in the array.
// 4. Traverse the array from right to left.
// 5. If the stack is empty, push -1 in the resultant array.
// 6. If the stack is not empty and the element at the top of the stack is less
// than the current element, pop the element from the stack.
// 7. If the stack is empty, push -1 in the resultant array.
// 8. If the stack is not empty, push the element at the top of the stack in the
// resultant array.
// 9. Push the index of the current element in the stack.
// 10. Repeat steps 5 to 9 until we reach the end of the array.
// 11. Convert the resultant array to a number and return it.

// import java.util.Stack;

public class NextGreaterElement3 {

    public static int nextGreaterElement(int n) {
        // Convert the integer to a char array for easy manipulation of digits
        char[] digits = String.valueOf(n).toCharArray();
        int length = digits.length;

        // Start from the second last digit and move left until you find a digit
        // that is less than its immediate right digit.
        int i = length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such digit is found, no greater permutation exists.
        if (i < 0) {
            return -1;
        }

        // Start from the end of the array and move left until you find a digit
        // that is greater than the digit found above.
        int j = length - 1;
        while (digits[i] >= digits[j]) {
            j--;
        }

        // Swap the two digits found above.
        swap(digits, i, j);

        // Reverse the digits to the right of the position where the swap was made
        // to get the next greater permutation with the smallest increase.
        reverse(digits, i + 1, length - 1);

        // Convert the resultant char array back to long to check for integer overflow.
        long result = Long.parseLong(new String(digits));

        // If the result is greater than the max value for int,
        // return -1, otherwise, cast to int and return.
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    // Helper method to swap two elements in a char array.
    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Helper method to reverse a part of the char array between two indices.
    private static void reverse(char[] array, int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(nextGreaterElement(n));
    }
}