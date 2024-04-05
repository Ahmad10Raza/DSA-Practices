// Given an array of size n and a number k. We must modify array K a number of times. 
// Here modify array means in each operation we can replace any array element arr[i] by -arr[i]. 
// We need to perform this operation in such a way that after K operations, the sum of the array must be maximum?

// Examples : 

// Input : arr[] = {-2, 0, 5, -1, 2}, K = 4
// Output: 10
// Explanation:
// 1. Replace (-2) by -(-2), array becomes {2, 0, 5, -1, 2}
// 2. Replace (-1) by -(-1), array becomes {2, 0, 5, 1, 2}
// 3. Replace (0) by -(0), array becomes {2, 0, 5, 1, 2}
// 4. Replace (0) by -(0), array becomes {2, 0, 5, 1, 2}

// Input : arr[] = {9, 8, 8, 5}, K = 3
// Output: 20

// Approach: Follow the steps below to solve this problem:

// Sort the given array arr.
// Then for a given value of k, Iterate through the array till k remains greater than 0, 
// If the value of the array at any index is less than 0 we will change its sign and decrement k by 1.
// If we find a 0 in the array we will immediately set k equal to 0 to maximize our result.
// In some cases, if we have all the values in an array greater than 0 we will change the 
//     sign of positive values, as our array is already sorted we will be changing signs of lower 
//     values present in the array which will eventually maximize our sum.


// Java program to find maximum array sum
// after at most k negations.
import java.util.Arrays;

public class MaximizeArraySumAfterK {

	static int sol(int arr[], int k)
	{
		// Sorting given array using in-built java sort
		// function
		Arrays.sort(arr);
		int sum = 0;

		int i = 0;
		while (k > 0) {
			// If we find a 0 in our sorted array, we stop
			if (arr[i] >= 0)
				k = 0;
			else {
				arr[i] = (-1) * arr[i];
				k = k - 1;
			}
			i++;
		}

		// Calculating sum
		for (int j = 0; j < arr.length; j++)
			sum += arr[j];
		return sum;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int arr[] = { -2, 0, 5, -1, 2 };
		System.out.println(sol(arr, 4));
	}
}

