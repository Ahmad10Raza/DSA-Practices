
// Write a code to Print the smallest element of the array

// Input: [4, 2, 1, 5, 3]
// Output: 1

// Approach: Iterate over the array and keep track of the smallest element.

// Time complexity: O(n)
// Space complexity: O(1)

public class SmallestElementsInArray {

    public static int smallestElement(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        System.out.println(smallestElement(new int[] { 4, 2, 1, 5, 3 })); // 1
    }
}
