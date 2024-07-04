
// Write a program to reverse the elements of an array.

// Input: [1, 2, 3, 4, 5]
// Output: [5, 4, 3, 2, 1]

// Approach: Iterate over the array from start to end and swap the elements from start to end.

// Time complexity: O(n)
// Space complexity: O(1)

public class ReverseElementOfArray {

    public static void reverseElementOfArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        reverseElementOfArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
