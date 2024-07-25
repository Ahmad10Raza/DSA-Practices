
// Problem Statement: Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero. In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their sum is equal to zero.

// Example 1:
// Input:
//  nums = [-1,0,1,2,-1,-4]

// Output:
//  [[-1,-1,2],[-1,0,1]]

// Explanation:
//  Out of all possible unique triplets possible, [-1,-1,2] and [-1,0,1] satisfy the condition of summing up to zero with i!=j!=k

// Example 2:
// Input:
//  nums=[-1,0,1,0]
// Output:
//  Output: [[-1,0,1],[-1,1,0]]
// Explanation:
//  Out of all possible unique triplets possible, [-1,0,1] and [-1,1,0] satisfy the condition of summing up to zero with i!=j!=k

// In this approach, we intend to get rid of two things i.e. the HashSet we were using for the look-up operation and the set data structure used to store the unique triplets.

// So, We will first sort the array. Then, we will fix a pointer i, and the rest 2 pointers j and k will be moving. 

// Now, we need to first understand what the HashSet and the set were doing to make our algorithm work without them. So, the set data structure was basically storing the unique triplets in sorted order and the HashSet was used to search for the third element.

// That is why, we will first sort the entire array, and then to get the unique triplets, we will simply skip the duplicate numbers while moving the pointers.

// How to skip duplicate numbers:
// As the entire array is sorted, the duplicate numbers will be in consecutive places. So, while moving a pointer, we will check the current element and the adjacent element. Until they become different, we will move the pointer by 1 place. We will follow this process for all 3 pointers. Thus, we can easily skip the duplicate elements while moving the pointers.

// Now, we can also remove the HashSet as we have two moving pointers i.e. j and k that will find the appropriate value of arr[j] and arr[k]. So, we do not need that HashSet anymore for the look-up operations.

// The process will look like the following:

// Among the 3 pointers, 1 will be fixed and 2 will be moving. In each iteration, we will check if the sum i.e.arr[i]+arr[j]+arr[k] is equal to the target i.e. 0. 

// If the sum is greater, then we need lesser elements and so we will decrease the value of k(i.e. k--). 
// If the sum is lesser than the target, we need a bigger value and so we will increase the value of j (i.e. j++). 
// If the sum is equal to the target, we will simply insert the triplet i.e. arr[i], arr[j], arr[k], into our answer and move the pointers j and k skipping the duplicate elements.

// Approach: Sort and Three Pointer
// Time Complexity: O(N^2)
// Space Complexity: O(1)

// The steps are as follows:
//1. Sort the array.
//2. Initialize an empty list to store the triplets.
//3. Iterate the array from 0 to n-1.
//4. If the current element is the same as the previous element, then continue to the next element.
//5. Initialize two pointers j and k. j will start from i+1 and k will start from n-1.
//6. While j<k, check if the sum of the elements at i, j, and k is equal to 0.
//7. If the sum is equal to 0, then add the elements at i, j, and k to the list.
//8. If the sum is less than 0, then increment j.
//9. If the sum is greater than 0, then decrement k.
//10. If the sum is equal to 0, then increment j and decrement k while the elements at j and k are the same as the previous elements.
//11. Return the list of triplets.

// First, we will sort the entire array.
// We will use a loop(say i) that will run from 0 to n-1. This i will represent the fixed pointer. In each iteration, this value will be fixed for all different values of the rest of the 2 pointers. Inside the loop, we will first check if the current and the previous element is the same and if it is we will do nothing and continue to the next value of i.
// After that, there will be 2 moving pointers i.e. j(starts from i+1) and k(starts from the last index). The pointer j will move forward and the pointer k will move backward until they cross each other while the value of i will be fixed.
// Now we will check the sum i.e. arr[i]+arr[j]+arr[k].
// If the sum is greater, then we need lesser elements and so we will decrease the value of k(i.e. k--). 
// If the sum is lesser than the target, we need a bigger value and so we will increase the value of j (i.e. j++). 
// If the sum is equal to the target, we will simply insert the triplet i.e. arr[i], arr[j], arr[k] into our answer and move the pointers j and k skipping the duplicate elements(i.e. by checking the adjacent elements while moving the pointers).
// Finally, we will have a list of unique triplets.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> triplet(int n, int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            // remove duplicates:
            if (i != 0 && arr[i] == arr[i - 1])
                continue;

            // moving 2 pointers:
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    // skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1])
                        j++;
                    while (j < k && arr[k] == arr[k + 1])
                        k--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        int n = arr.length;
        List<List<Integer>> ans = triplet(n, arr);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
