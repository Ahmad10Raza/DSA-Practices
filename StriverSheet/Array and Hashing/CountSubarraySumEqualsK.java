
// Problem Statement: Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Pre-requisite: Longest subarray with given sum

// Examples
// Example 1:
// Input Format:
//  N = 4, array[] = {3, 1, 2, 4}, k = 6
// Result:
//  2
// Explanation:
//  The subarrays that sum up to 6 are [3, 1, 2] and [2, 4].

// Example 2:
// Input Format:
//  N = 3, array[] = {1,2,3}, k = 3
// Result:
//  2
// Explanation:
//  The subarrays that sum up to 3 are [1, 2], and [3].

// Approach: Prefix Sum and Hashing
// Time Complexity: O(N)
// Space Complexity: O(N)

// The steps are as follows:
// 1. Initialize a variable count to 0 and a variable sum to 0. 
// 2. Initialize a HashMap to store the prefix sum and its frequency.
// 3. Iterate the array from 0 to n-1.
// 4. Add the current element to the sum.
// 5. If the sum is equal to k, then increment the count.
// 6. If the difference between the sum and k is present in the HashMap, then increment the count by the frequency of the difference.
// 7. Increment the frequency of the sum in the HashMap.
// 8. Return the count.

import java.util.HashMap;
import java.util.Map;

public class CountSubarraySumEqualsK {

    public static int subarraySum(int[] arr, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        int k = 6;
        System.out.println(subarraySum(arr, k));
    }
}
