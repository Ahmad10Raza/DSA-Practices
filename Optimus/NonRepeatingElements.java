
//Write a code to find non-repeating elements in an array. 

// Input : arr[] = {1, 2, 3, 2, 3, 4, 5}
// Output : 1 4 5

// Input : arr[] = {1, 2, 3, 2, 3, 4}
// Output : 1 4

// Approach: Create a hash table and store the count of each element in the array.
// Traverse the array and print the element if the count is 1.

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingElements {

    public static void findNonRepeatingElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 3, 4, 5 };
        findNonRepeatingElements(arr);
    }
}