
// Write a code to replace each element in an array by its rank in the array

// Input: [10, 8, 15, 12, 6, 20, 1]
// Output: [4, 3, 6, 5, 2, 7, 1]
// Explanation: The rank of 10 is 4, the rank of 8 is 3, the rank of 15 is 6, 
// the rank of 12 is 5, the rank of 6 is 2, the rank of 20 is 7, and the rank of 1 is 1.

// Input: [100, 200, 150, 50]
// Output: [3, 4, 2, 1]

// Approach: The idea is to create a copy of the original array and sort the copy array.
// Then, we will create a map to store the rank of each element in the sorted array.
// Finally, we will iterate through the original array and replace each element with its rank in the map.

// Time Complexity: O(nlogn)
// Space Complexity: O(n)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReplaceArrayWithRank {
    
    public static int[] replaceArrayWithRank(int[] arr) {
        int[] copy = arr.clone();
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < copy.length; i++) {
            if (!map.containsKey(copy[i])) {
                map.put(copy[i], rank);
                rank++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {10, 8, 15, 12, 6, 20, 1};
        System.out.println(Arrays.toString(replaceArrayWithRank(arr)));
    }
}
