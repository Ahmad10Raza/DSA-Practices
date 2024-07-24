// Given a array find two sum

// Example 1:
// Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
// Result: YES (for 1st variant)
//        [1, 3] (for 2nd variant)
// Explanation: arr[1] + arr[3] = 14. So, the answer is “YES” for the first variant and [1, 3] for 2nd variant.

// Example 2:
// Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 15
// Result: NO (for 1st variant)
// 	[-1, -1] (for 2nd variant)
// Explanation: There exist no such two numbers whose sum is equal to the target.

// Approach: Hashing
// Time Complexity: O(N)
// Space Complexity: O(N)

// Following is the code implementation of the above approach:
// 1. Create a map to store the index of the elements.
// 2. Traverse the array and check if the target – arr[i] is present in the map or not.
// 3. If it is present, then return the index of the current element and the index of the target – arr[i].
// 4. If it is not present, then insert the current element in the map.
// 5. If no such pair is found, return -1.

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] arr, int target) {
        // Create a map to store the index of the elements
        Map<Integer, Integer> map = new HashMap<>();
        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the target - arr[i] is present in the map or not
            if (map.containsKey(target - arr[i])) {
                // If it is present, return the index of the current element and the index of
                // the target - arr[i]
                return new int[] { map.get(target - arr[i]), i };
            }
            // If it is not present, insert the current element in the map
            map.put(arr[i], i);
        }
        // If no such pair is found, return -1
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = { 2, 6, 5, 8, 11 };
        int target = 14;
        int[] result = twoSum.twoSum(arr, target);
        if (result[0] == -1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(Arrays.toString(result));
        }
    }
}
