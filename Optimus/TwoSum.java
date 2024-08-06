
// Given an array A and an integer target, find the indices of the two numbers in the array whose sum is equal to the given target.

// Note: The problem has exactly one solution. Do not use the same element twice.

// Example
// A: [1, 3, 3, 4]
// target: 5
// Answer: [0, 3]

// Approach: Use a HashMap to store the elements of the array and their indices. For each element, check if the difference between the target and the element is present in the HashMap. If it is present, return the indices of the two elements.

// Complexity Analysis
// Time Complexity: O(N), where N is the number of elements in the array.
// Space Complexity: O(N), where N is the number of elements in the array.

// Follow below steps to implement the code:
// 1. Create a hashmap to store the elements of the array and their indices.
// 2. Iterate through the array and check if the difference between the target and the element is present in the hashmap.
// 3. If it is present, return the indices of the two elements.
// 4. If no such pair is found, return an empty array.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(target - A[i])) {
                return new int[] { map.get(target - A[i]), i };
            }
            map.put(A[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] A = { 1, 3, 3, 4 };
        int target = 5;
        int[] result = twoSum(A, target);
        System.out.println(Arrays.toString(result));
    }
}
