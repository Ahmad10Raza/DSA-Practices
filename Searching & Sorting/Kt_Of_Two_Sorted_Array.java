/*package whatever //do not write package name here */

import java.util.Arrays;


class MainClass {
	// kth function to find kth element in the merged array
	static int kth(int[] arr1, int[] arr2, int n, int m, int k) {
		// base cases
		if (n == 1 || m == 1) {
			// if one array is empty or only has one element, find the kth element in the other array
			if (m == 1) {
				int[] temp = arr1;
				arr1 = arr2;
				arr2 = temp;
				m = n;
			}
			if (k == 1) {
				return Math.min(arr1[0], arr2[0]);
			} else if (k == m + 1) {
				return Math.max(arr1[0], arr2[0]);
			} else {
				if (arr2[k - 1] < arr1[0]) {
					return arr2[k - 1];
				} else {
					return Math.max(arr1[0], arr2[k - 2]);
				}
			}
		}

		int mid1 = (n - 1) / 2;
		int mid2 = (m - 1) / 2;

		if (mid1 + mid2 + 1 < k) {
			// if k is greater than the sum of midpoints, discard the smaller half of the arrays and recurse
			if (arr1[mid1] < arr2[mid2]) {
				return kth(
						Arrays.copyOfRange(arr1, mid1 + 1, n),
						arr2,
						n - (mid1 + 1),
						m,
						k - (mid1 + 1)
				);
			} else {
				return kth(
						arr1,
						Arrays.copyOfRange(arr2, mid2 + 1, m),
						n,
						m - (mid2 + 1),
						k - (mid2 + 1)
				);
			}
		} else {
			if (arr1[mid1] < arr2[mid2]) {
				return kth(
						arr1,
						Arrays.copyOfRange(arr2, 0, mid2 + 1),
						n,
						mid2 + 1,
						k
				);
			} else {
				return kth(
						Arrays.copyOfRange(arr1, 0, mid1 + 1),
						arr2,
						mid1 + 1,
						m,
						k
				);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr1 = {2, 3, 6, 7, 9};
		int[] arr2 = {1, 4, 8, 10};
		int k = 5;
		System.out.println(kth(arr1, arr2, 5, 4, k));
	}
}


// Java Program to find kth element from two sorted arrays
class GFG 
{

	static int kth(int arr1[], int arr2[], int m,
				int n, int k, int st1, int st2) 
	{
		// In case we have reached end of array 1
		if (st1 == m) 
		{
			return arr2[st2 + k - 1];
		}

		// In case we have reached end of array 2
		if (st2 == n) 
		{
			return arr1[st1 + k - 1];
		}

		// k should never reach 0 or exceed sizes
		// of arrays
		if (k == 0 || k > (m - st1) + (n - st2)) 
		{
			return -1;
		}

		// Compare first elements of arrays and return
		if (k == 1) 
		{
			return (arr1[st1] < arr2[st2])
					? arr1[st1] : arr2[st2];
		}
		int curr = k / 2;

		// Size of array 1 is less than k / 2
		if (curr - 1 >= m - st1)
		{
			
			// Last element of array 1 is not kth
			// We can directly return the (k - m)th
			// element in array 2
			if (arr1[m - 1] < arr2[st2 + curr - 1]) 
			{
				return arr2[st2 + (k - (m - st1) - 1)];
			} 
			else
			{
				return kth(arr1, arr2, m, n, k - curr,
						st1, st2 + curr);
			}
		}

		// Size of array 2 is less than k / 2
		if (curr - 1 >= n - st2)
		{
			if (arr2[n - 1] < arr1[st1 + curr - 1]) 
			{
				return arr1[st1 + (k - (n - st2) - 1)];
			}
			else
			{
				return kth(arr1, arr2, m, n, k - curr,
						st1 + curr, st2);
			}
		} 
		else
		
		// Normal comparison, move starting index
		// of one array k / 2 to the right
		if (arr1[curr + st1 - 1] < arr2[curr + st2 - 1])
		{
			return kth(arr1, arr2, m, n, k - curr,
					st1 + curr, st2);
		} 
		else
		{
			return kth(arr1, arr2, m, n, k - curr,
					st1, st2 + curr);
		}
	}

	// Driver code
	public static void main(String[] args) 
	{
		int arr1[] = {2, 3, 6, 7, 9};
		int arr2[] = {1, 4, 8, 10};
		int k = 5;
		int st1 = 0, st2 = 0;
		System.out.println(kth(arr1, arr2, 5, 4, k, st1, st2));
	}
} 

// This code is contributed by 29AjayKumar
