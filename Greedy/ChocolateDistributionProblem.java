// Given an array of N integers where each value represents the number of chocolates in a packet. 
// Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that: 

// Each student gets one packet.
// The difference between the number of chocolates in the packet with maximum 
// chocolates and the packet with minimum chocolates given to the students is minimum.
// Examples:

// Input : arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3 
// Output: Minimum Difference is 2 
// Explanation:
// We have seven packets of chocolates and we need to pick three packets for 3 students 
// If we pick 2, 3 and 4, we get the minimum difference between maximum and minimum packet sizes.

// Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12} , m = 5 
// Output: Minimum Difference is 6 

// Input : arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50} , m = 7 
// Output: Minimum Difference is 10 

// Approach: The idea is based on the observation that to minimize the difference, 
            // we must choose consecutive elements from a sorted packet. 
            // We first sort the array arr[0..n-1], then find the subarray of size m
            // with the minimum difference between the last and first elements.
// Follow the steps mentioned below to implement the approach:


// Initially sort the given array. And declare a variable to store the minimum difference, 
//     and initialize it to INT_MAX. Let the variable be min_diff.
// Find the subarray of size m such that the difference between the last
//      (maximum in case of sorted) and first (minimum in case of sorted) elements of the subarray is minimum.
// We will run a loop from 0 to (n-m), where n is the size of the given array and m is the size of the subarray.
// We will calculate the maximum difference with the subarray and store it in diff = arr[highest index] – arr[lowest index]
// Whenever we get a diff less than the min_diff, we will update the min_diff with diff.



// JAVA Code For Chocolate Distribution Problem
import java.util.Arrays;

public class ChocolateDistributionProblem {

	
	public static int chocolateDistribution(int arr[], int m) {
		// Check base cases
		if (arr.length == 0 || m == 0) {
			return 0;
		}

		// Sort the array to simplify calculations
		Arrays.sort(arr);

		// Check if there are enough packets for the given number of students
		if (arr.length - 1 < m) {
			// Invalid input
			return -1;
		}

		// Initialize minimum difference to the maximum possible integer value
		int min_diff = Integer.MAX_VALUE;

		// Iterate through the array to find the minimum difference
		for (int i = 0; i < arr.length; i++) {
			// Calculate the ending index of the current window
			int nextWindow = i + m - 1;

			// Break if the window goes beyond the bounds of the array
			if (nextWindow >= arr.length)
				break;

			// Calculate the difference between the last and first elements in the window
			int diff = arr[nextWindow] - arr[i];

			// Update the minimum difference if a smaller difference is found
			min_diff = Math.min(min_diff, diff);
		}

		// Return the calculated minimum difference
		return min_diff;
	}

	public static void main(String[] args) {
		// Example input
		int arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
		int m = 7;

		// Calculate the result using the chocolateDistribution method
		int result = chocolateDistribution(arr, m);

		// Print the result or indicate an invalid input
		if (result != -1) {
			System.out.println("Minimum difference is " + result);
		} else {
			System.out.println("Invalid input");
		}
	}
}
