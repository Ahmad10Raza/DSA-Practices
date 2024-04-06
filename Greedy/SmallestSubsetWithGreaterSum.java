// Given an array of non-negative integers, the task is to find the minimum number of elements 
// such that their sum should be greater than the sum of the rest of the elements of the array.

// Example: 

// Input: arr[] = [ 3 , 1 , 7, 1 ]
// Output: 1
// Explanation: Smallest subset is {7}. Sum of this subset is greater than the sum of all 
// other elements left after removing subset {7} from the array

// Input:  arr[] = [ 2 , 1 , 2 ]
// Output: 2
// Explanation: Smallest subset is {2 , 1}. Sum of this subset is greater than the 
// sum of all other elements left after removing subset {2 , 1} from the array

// Approach: The approach is to take the largest elements from the array , 
//             in that way we can decrease the size of the subset that has sum 
//             greater than the sum of rest of the elements of the array , 
//             so we sort the array in descending order, then take the largest elements,
//             until we get strictly more than half of total sum of the given array. 

// Follow the steps mentioned below to implement the idea:

// Create a variable halfSum to store half of the overall sum of the array arr[].
// Sort the array in descending order.
// Create a variable curr_sum and increase the value of curr_sum by arr[i]
    // while traversing the array from index 0 till the value of curr_sum is less than halfSum
// When curr_sum is greater than halfSum return index+1. 


// Java code to find minimum number of elements
// such that their sum is greater than sum of
// remaining elements of the array.
import java.util.*;

public class SmallestSubsetWithGreaterSum {

	// Function to find minimum elements needed
	static int minElements(int arr[], int n)
	{
		// Calculating HALF of array sum
		int halfSum = 0;
		for (int i = 0; i < n; i++)
			halfSum = halfSum + arr[i];
		halfSum = halfSum / 2;

		// Sort the array in ascending order and
		// start traversing array from the ascending
		// sort in descending order.
		Arrays.sort(arr);

		int res = 0, curr_sum = 0;
		for (int i = n - 1; i >= 0; i--) {

			curr_sum += arr[i];
			res++;

			// Current sum greater than sum
			if (curr_sum > halfSum)
				return res;
		}
		return res;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int arr[] = { 3, 1, 7, 1 };
		int n = arr.length;
		System.out.println(minElements(arr, n));
	}
}


// Time Complexity: O(n log n)
// Auxiliary Space: O(1)