
// Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
// has the largest sum and returns its sum and prints the subarray.

// Examples
// Example 1:
// Input:
//  arr = [-2,1,-3,4,-1,2,1,-5,4] 

// Output: 6
// [4,-1,2,1] 

// Explanation:
//  [4,-1,2,1] has the largest sum = 6. 

// Examples 2:
// Input:
//  arr = [1] 

// Output:
//  1 

// Explanation:
//  Array has only one element and which is giving positive sum of 1. 

// Approach: Kadane's Algorithm
// Time Complexity: O(N)
// Space Complexity: O(1)

// The steps are as follows:
// 1. Initialize two variables maxSum and currentSum to 0.
// 2. Iterate the array from 0 to n-1.
// 3. Add the current element to the currentSum.
// 4. If the currentSum is greater than the maxSum, then update the maxSum.
// 5. If the currentSum is less than 0, then update the currentSum to 0.
// 6. Return the maxSum.

public class KadaneAlgorithm {

    public static int maxSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0;
        int end = 0;
        int s = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = s;
                end = i;
            }
            if (currentSum < 0) {
                currentSum = 0;
                s = i + 1;
            }
        }
        System.out.println("[" + start + "," + end + "]");
        return maxSum;
    }

    public static long maxSubarraySum(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE; // maximum sum
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        // To consider the sum of the empty subarray
        // uncomment the following check:

        // if (maxi < 0) maxi = 0;

        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(arr));
    }
}
