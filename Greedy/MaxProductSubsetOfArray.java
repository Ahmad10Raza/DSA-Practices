// Given an array a, we have to find the maximum product possible with the subset 
// of elements present in the array. The maximum product can be a single element also.
// Examples: 

// Input: a[] = { -1, -1, -2, 4, 3 }
// Output: 24
// Explanation : Maximum product will be ( -2 * -1 * 4 * 3 ) = 24

// Input: a[] = { -1, 0 }
// Output: 0
// Explanation: 0(single element) is maximum product possible


// Approach: The idea is to count the occurrence of positive and negative elements 
// If there are even number of negative numbers and no zeros, the result is simply the product of all
// If there are odd number of negative numbers and no zeros,then the result is the product of all 
//     except the negative integer with the least absolute value.
// If there are zeros, the result is the product of all except these zeros with one exceptional case. 
//     The exceptional case is when there is one negative number and all other elements are 0. In this case, the result is 0.

//     Follow the steps mentioned below to implement the idea:
// Create 3 variables count_neg , count_zero and prod , to store the occurrence of negative elements, 
//     zeros, and the product of the subset.
// If count_neg is even then return prod.
// If count_neg is odd then divide the smallest absolute negative element from prod and return prod.
// If the array is filled with zeroes and negative elements then  return 0.


// Java program to find maximum product of
// a subset.

public class MaxProductSubsetOfArray {

	static int maxProductSubset(int a[], int n) {
		if (n == 1) {
			return a[0];
		}

		// Find count of negative numbers, count 
		// of zeros, negative number 
		// with least absolute value
		// and product of non-zero numbers
		int max_neg = Integer.MIN_VALUE;
		int count_neg = 0, count_zero = 0;
		int prod = 1;
		for (int i = 0; i < n; i++) {

			// If number is 0, we don't
			// multiply it with product.
			if (a[i] == 0) {
				count_zero++;
				continue;
			}

			// Count negatives and keep
			// track of negative number
			// with least absolute value.
			if (a[i] < 0) {
				count_neg++;
				max_neg = Math.max(max_neg, a[i]);
			}

			prod = prod * a[i];
		}

		// If there are all zeros
		if (count_zero == n) {
			return 0;
		}

		// If there are odd number of
		// negative numbers
		if (count_neg % 2 == 1) {

			// Exceptional case: There is only
			// negative and all other are zeros
			if (count_neg == 1 && count_zero > 0 && count_zero + count_neg == n) {
				return 0;
			}

			// Otherwise result is product of 
			// all non-zeros divided by 
			//negative number with 
			// least absolute value.
			prod = prod / max_neg;
		}

		return prod;
	}

	// Driver Code
	public static void main(String[] args) {
		int a[] = {-1, -1, -2, 4, 3};
		int n = a.length;
		System.out.println(maxProductSubset(a, n));

	}
}
