
// Find the Majority Element that occurs more than N/2 times

// 178

// 0
// Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.

// Examples
// Example 1:
// Input Format
// : N = 3, nums[] = {3,2,3}
// Result
// : 3
// Explanation
// : When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution. 

// Example 2:
// Input Format:
//   N = 7, nums[] = {2,2,1,1,1,2,2}

// Result
// : 2

// Explanation
// : After counting the number of times each element appears and comparing it with half of array size, we get 2 as result.

// Example 3:
// Input Format:
//   N = 10, nums[] = {4,4,2,4,3,4,4,3,2,4}

// Result: 4

// Approach: Boyer-Moore Voting Algorithm
// Time Complexity: O(N)
// Space Complexity: O(1)

// The steps are as follows:
// 1. Initialize two variables candidate and count to 0.
// 2. Iterate the array from 0 to n-1.
// 3. If the count is 0, then update the candidate to the current element.
// 4. If the current element is equal to the candidate, then increment the count.
// 5. If the current element is not equal to the candidate, then decrement the count.
// 6. Return the candidate.

public class MajorityElemenst1 {

    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        System.out.println(majorityElement(nums));
    }
}
