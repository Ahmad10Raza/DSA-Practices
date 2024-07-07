import java.util.HashSet;
import java.util.Set;

// Write a code to find consecutive largest subsequence

// Consecutive Largest Subsequence: Given an array of integers, find the length of the longest subsequence such that all elements of the subsequence are consecutive integers. The subsequence should contain all distinct elements.

// Input: [1, 9, 3, 10, 4, 20, 2]
// Output: 4
// Explanation: The subsequence [1, 3, 4, 2] is the longest subsequence of consecutive elements.

// Approach: Create a HashSet and add all the elements of the array. Iterate over the array and check if the current element is the starting element of the subsequence. If it is the starting element, then iterate over the consecutive elements and check if they are present in the HashSet. If they are present, then increment the count of the subsequence. Update the maximum length of the subsequence.

// Time Complexity: O(n)
// Space Complexity: O(n)

public class ConsecutiveLargestSubsequence {

    public static int consecutiveLargestSubsequence(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i] - 1)) {
                int currentElement = arr[i];
                int currentLength = 1;
                while (set.contains(currentElement + 1)) {
                    currentElement++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 9, 3, 10, 4, 20, 2 };
        System.out.println(consecutiveLargestSubsequence(arr));
    }

}
