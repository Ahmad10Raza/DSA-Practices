// Given an Array of N integers, the task is to maximize the value of the product 
// of each array element with their corresponding indices by rearranging the array.

// Examples:

// Input: N = 4, arr[] = { 3, 5, 6, 1 }
// Output: 31
// Explanation: If we arrange arr[] as { 1, 3, 5, 6 }. Sum of arr[i]*i is 1*0 + 3*1 + 5*2 + 6*3 = 31, which is maximum

// Input: N = 2, arr[] = { 19, 20 }
// Output: 20

// Approach 🍎 : The idea is based on the fact that the largest value should be scaled 
//              maximum and the smallest value should be scaled minimum. So we multiply 
//              the minimum value of i with the minimum value of arr[i]. So, 
//              sort the given array in increasing order and compute the sum of arr[i]*i.

// Follow the steps mentioned below to implement the idea:

// Sort the array.
// Create a variable sum to store the final answer
// Traverse The array, while traversing the array increases the value of the sum by arr[I]*i.
// Return sum. 


// Java program to find the
// maximum value of i*arr[i]
import java.util.*;

public class MaximizeProductWithIndices {

	static int maxSum(int arr[], int n)
	{
		// Sort the array
		Arrays.sort(arr);

		// Finding the sum of arr[i]*i
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += (arr[i] * i);

		return sum;
	}

	// Driven Program
	public static void main(String[] args)
	{
		int arr[] = { 3, 5, 6, 1 };
		int n = arr.length;

		System.out.println(maxSum(arr, n));
	}
}
