
// Given two arrays arr1[] and arr2[] of size m and n respectively, the task is to determine whether arr2[] is a subset of arr1[]. Both arrays are not sorted, and elements are distinct.

// Examples: 

// Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1} 
// Output: Yes

// Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4} 
// Output: Yes

// Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3} 
// Output: No

// Approach: The idea is to use a HashMap to store the frequency of elements in arr1[]. Then, iterate through arr2[] and check if the element is present in the HashMap. If the element is present, decrement the frequency of the element in the HashMap. If the frequency becomes 0, remove the element from the HashMap. If all elements of arr2[] are present in arr1[], then arr2[] is a subset of arr1[].

// Follow below steps to implement the code:
// 1. Create a HashMap to store the frequency of elements in arr1[].
// 2. Iterate through arr1[] and store the frequency of each element in the HashMap.
// 3. Iterate through arr2[] and check if the element is present in the HashMap.
// 4. If the element is present, decrement the frequency of the element in the HashMap.
// 5. If the frequency becomes 0, remove the element from the HashMap.
// 6. If all elements of arr2[] are present in arr1[], then arr2[] is a subset of arr1[].

import java.util.HashMap;

public class SubsetOfArray {

    public static boolean isSubset(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            } else {
                map.put(arr1[i], 1);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                if (map.get(arr2[i]) == 0) {
                    return false;
                }
                map.put(arr2[i], map.get(arr2[i]) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = { 11, 1, 13, 21, 3, 7 };
        int[] arr2 = { 11, 3, 7, 1 };
        System.out.println(isSubset(arr1, arr2)); // Output: true

        int[] arr3 = { 1, 2, 3, 4, 5, 6 };
        int[] arr4 = { 1, 2, 4 };
        System.out.println(isSubset(arr3, arr4)); // Output: true

        int[] arr5 = { 10, 5, 2, 23, 19 };
        int[] arr6 = { 19, 5, 3 };
        System.out.println(isSubset(arr5, arr6)); // Output: false
    }
}
