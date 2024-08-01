
// Problem Statement :

// You are given a function, void MaxInArray(int arr[], int length); The function accepts an integer array ‘arr’ of size ‘length’ as its argument. Implement the function to find the maximum element of the array and print the maximum element and its index to the standard output 

// (STDOUT). The maximum element and its index should be printed in separate lines.

// Note: 

// Array index starts with 0 
// Maximum element and its index should be separated by a line in the output 
// Assume there is only 1 maximum element in the array 
// Print exactly what is asked, do not print any additional greeting messages 
// Example: 

// Input: 

// 23 45 82 27 66 12 78 13 71 86 

// Output: 

// 86 

// 9 

// Explanation: 

// 86 is the maximum element of the array at index 9. 

// Approach: We need to find the maximum element of the array and print the maximum element and its index. We will iterate through the array and find the maximum element. We will print the maximum element and its index to the standard output.

// Follow the below steps to solve the problem:
// 1. Initialize two variables ‘max’ and ‘index’ to store the maximum element and its index.
// 2. Iterate through the array from 0 to length-1 and find the maximum element and its index.
// 3. Print the maximum element and its index to the standard output.

public class MaxInArray {

    public static void MaximumInArray(int arr[], int length) {
        int max = arr[0];
        int index = 0;
        for (int i = 1; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }

    public static void main(String[] args) {
        int arr[] = { 23, 45, 82, 27, 66, 12, 78, 13, 71, 86 };
        int length = arr.length;
        MaximumInArray(arr, length);
    }
}
