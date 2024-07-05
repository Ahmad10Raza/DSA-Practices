
// Write a program to find the largest element in an array.

// Input: [1, 2, 3, 4, 5]
// Output: 5

// Approach: We can find the largest element in an array by following below steps:
// 1. Initialize a variable max with the first element of the array.
// 2. Traverse the array from the second element to the last element.
// 3. If the current element is greater than max, update max with the current element.
// 4. Finally, max will have the largest element in the array.

public class LargestElementInArray {

    public static int FindLargestElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(FindLargestElement(arr));
    }
}
