
// You are given a function,
// int findCount(int arr[], int length, int num, int diff);

// The function accepts an integer array ‘arr’, its length and two integer variables ‘num’ and ‘diff’. Implement this function to find and return the number of elements of ‘arr’ having an absolute difference of less than or equal to ‘diff’ with ‘num’.
// Note: In case there is no element in ‘arr’ whose absolute difference with ‘num’ is less than or equal to ‘diff’, return -1.

// Example:
// Input:

// arr: 12 3 14 56 77 13
// num: 13
// diff: 2
// Output:
// 3

// Explanation:
// Elements of ‘arr’ having absolute difference of less than or equal to ‘diff’ i.e. 2 with ‘num’ i.e. 13 are 12, 13 and 14.

// Approach: We need to find the number of elements of the array having an absolute difference of less than or equal to ‘diff’ with ‘num’. We will iterate through the array and check if the absolute difference of the element with ‘num’ is less than or equal to ‘diff’. If the condition is satisfied, we will increment the count. We will return the count after iterating through the array.

// Follow the below steps to solve the problem:
// 1. Initialize a variable ‘count’ to 0 to store the number of elements having an absolute difference of less than or equal to ‘diff’ with ‘num’.
// 2. Iterate through the array from 0 to length-1 and check if the absolute difference of the element with ‘num’ is less than or equal to ‘diff’.
// 3. If the condition is satisfied, increment the ‘count’.
// 4. Return the ‘count’ after iterating through the array.

public class FindCount {

    public static int findCount(int arr[], int length, int num, int diff) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (Math.abs(arr[i] - num) <= diff) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 3, 14, 56, 77, 13 };
        int num = 13;
        int diff = 2;
        int length = arr.length;
        System.out.println(findCount(arr, length, num, diff));
    }
}
