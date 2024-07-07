
// Given an array of integers, rotate the array by 'k' elements. Here, 'k' is an integer.
// For example, if the array is [1, 2, 3, 4, 5, 6, 7] and k is 3, the array should be rotated to [5, 6, 7, 1, 2, 3, 4].
// The array should be rotated in-place, which means that the original array should be 
// modified and no additional memory should be allocated.

// Approach: The idea is to reverse the array in two parts. First, we will reverse the array from 0 to k-1,
// then we will reverse the array from k to n-1, and finally, we will reverse the whole array.
// Time Complexity: O(n)
// Space Complexity: O(1)

public class CircularKRotationArray {

    public static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        // If k is greater than the length of the array, then we will take the modulo of
        // k with n
        k = k % n;
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotateArray(arr, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
