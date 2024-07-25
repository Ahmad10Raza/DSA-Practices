
// Majority Elements(&gt;N/3 times) | Find the elements that appears more than N/3 times in the array

// 96

// 1
// Problem Statement: Given an array of N integers. Find the elements that appear more than N/3 times in the array. If no such element exists, return an empty vector.

// Examples
// Example 1:
// Input Format
// : N = 5, array[] = {1,2,2,3,2}
// Result
// : 2
// Explanation:
//  Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.Therefore, the count of 2 is greater than N/3 times. Hence, 2 is the answer.

// Example 2:
// Input Format
// :  N = 6, array[] = {11,33,33,11,33,11}
// Result:
//  11 33
// Explanation:
//  Here we can see that the Count(11) = 3 and Count(33) = 3. Therefore, the count of both 11 and 33 is greater than N/3 times. Hence, 11 and 33 is the answer.

// Approach: Extended Boyer-Moore Voting Algorithm 
// Time Complexity: O(N)
// Space Complexity: O(1)

// The steps are as follows:
// 1. Initialize two variables candidate1, candidate2, count1, count2 to 0.
// 2. Iterate the array from 0 to n-1.
// 3. If the count1 is 0, then update the candidate1 to the current element.
// 4. If the count2 is 0, then update the candidate2 to the current element.
// 5. If the current element is equal to the candidate1, then increment the count1.
// 6. If the current element is equal to the candidate2, then increment the count2.
// 7. If the current element is not equal to the candidate1 and candidate2, then decrement the count1 and count2.
// 8. Return the candidate1 and candidate2.

import java.util.ArrayList;
import java.util.List;

public class MajorityElements {

    public static List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // check the count of candidate1 and candidate2 are majority or not
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // add the candidate1 and candidate2 to the list
        List<Integer> ans = new ArrayList<>();
        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            ans.add(candidate2);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 2 };
        System.out.println(majorityElement(nums));

        int[] nums1 = { 11, 33, 33, 11, 33, 11 };
        System.out.println(majorityElement(nums1));
    }
}
