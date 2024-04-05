// Given an array, we need to find the maximum sum of the absolute difference of any permutation of the given array.

// Examples:  

// Input : { 1, 2, 4, 8 }
// Output : 18
// Explanation : For the given array there are 
// several sequence possible
// like : {2, 1, 4, 8}
//        {4, 2, 1, 8} and some more.
// Now, the absolute difference of an array sequence will be
// like for this array sequence {1, 2, 4, 8}, the absolute
// difference sum is 
// = |1-2| + |2-4| + |4-8| + |8-1|
// = 14
// For the given array, we get the maximum value for
// the sequence {1, 8, 2, 4}
// = |1-8| + |8-2| + |2-4| + |4-1|
// = 18

// Approach : To solve this problem, we have to think greedily that how can we maximize 
//             the difference value of the elements so that we can have a maximum sum. 
//             This is possible only if we calculate the difference between some 
//             very high values and some very low values like (highest – smallest). 
//             This is the idea which we have to use to solve this problem.
//             Let us see the above example, we will have maximum difference possible 
//             for sequence {1, 8, 2, 4} because in this sequence we will get 
//             some high difference values, ( |1-8| = 7, |8-2| = 6 .. ). Here,
//             by placing 8(highest element) in place of 1 and 2 we get two high difference values. 
//             Similarly, for the other values, we will place next highest values in between other, 
//             as we have only one left i.e 4 which is placed at last. 


// We will sort the array. 
// Calculate the final sequence by taking one smallest element and largest element 
//     from the sorted array and make one vector array of this final sequence. 
// Finally, calculate the sum of absolute difference between the elements of the array.


// Java implementation of
// above algorithm
import java.util.*;

public class MaxSumOfAbsoluteDifference {
	
	static int MaxSumDifference(Integer []a, int n)
	{
		
		// final sequence stored in the vector
		List<Integer> finalSequence = new ArrayList<Integer>();
	
		// sort the original array
		// so that we can retrieve
		// the large elements from
		// the end of array elements
		Arrays.sort(a);
	
		// In this loop first we will insert
		// one smallest element not entered
		// till that time in final sequence
		// and then enter a highest element
		// (not entered till that time) in
		// final sequence so that we
		// have large difference value. This
		// process is repeated till all array
		// has completely entered in sequence.
		// Here, we have loop till n/2 because
		// we are inserting two elements at a
		// time in loop.
		for (int i = 0; i < n / 2; ++i) {
			finalSequence.add(a[i]);
			finalSequence.add(a[n - i - 1]);
		}

		// If there are odd elements, push the
		// middle element at the end.
		if (n % 2 != 0)
			finalSequence.add(a[n/2]);

		// variable to store the
		// maximum sum of absolute
		// difference
		int MaximumSum = 0;
	
		// In this loop absolute difference
		// of elements for the final sequence
		// is calculated.
		for (int i = 0; i < n - 1; ++i) {
			MaximumSum = MaximumSum + Math.abs(finalSequence.get(i) - finalSequence.get(i + 1));
		}
	
		// absolute difference of last element
		// and 1st element
		MaximumSum = MaximumSum + Math.abs(finalSequence.get(n - 1) - finalSequence.get(0));
	
		// return the value
		return MaximumSum;
	}
	// Space optimized approach: Follow the below steps to implement the above idea:

// Sort the array
// Initialize 2 variable i=0, j = size – 1
// Set a flag (true if we will increment i and false if we will decrement j) 
//     in order to track which variable needs to be changed. since after first move we will 
//     select next min value i.e. increment i, it will be initialised as true;
// Run the while loop and calculate sum for every i and j, and change i and j accordingly
// After the loop we need to calculate the difference of middle element and first. this will be done separately.


    public static int maxSum(int[] arr, int n) {
        Arrays.sort(arr);
        int i = 0, j = n - 1, sum = 0;
        boolean off = true;
        while(i < j) {
          sum += Math.abs(arr[i] - arr[j]);
          if(off) {
            i++;
          } else {
            j--;
          }
          off = !off;
        }
        sum += Math.abs(arr[0] - arr[n/2]);
        return sum;
      }

	// Driver Code
	public static void main(String args[])
	{
		Integer []a = { 1, 2, 4, 8 };
		int n = a.length;
	
		System.out.print(MaxSumDifference(a, n));
	}
}
