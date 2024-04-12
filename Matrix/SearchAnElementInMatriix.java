// Given an n x n matrix and an integer x, find the position of x in the matrix 
// if it is present. Otherwise, print “Element not found”. Every row and column 
// of the matrix is sorted in increasing order. The designed algorithm should have linear time complexity

// Examples: 

// Input: mat[4][4] = { {10, 20, 30, 40},  x = 29
//                                {15, 25, 35, 45},
//                                {27, 29, 37, 48},
//                              {32, 33, 39, 50}}
 
// Output: Found at (2, 1)

// Approach: The simple idea is to remove a row or column in each comparison until an 
//             element is found. Start searching from the top-right corner of the matrix. 
//             There are three possible cases:-

// The given number is greater than the current number: This will ensure that all the elements 
// in the current row are smaller than the given number as the pointer is already at the 
// right-most elements and the row is sorted. Thus, the entire row gets eliminated and 
// continues the search for the next row. Here, elimination means that a row needs not to be searched.
// The given number is smaller than the current number: This will ensure that all 
// the elements in the current column are greater than the given number. Thus, 
// the entire column gets eliminated and continues the search for the previous column, 
// i.e. the column on the immediate left.
// The given number is equal to the current number: This will end the search.
// Follow the given steps to solve the problem:

// Let the given element be x, create two variable i = 0, j = n-1 as index of row and column.
// Run a loop until i < n.
// Check if the current element is greater than x then decrease the count of j. Exclude the current column.
// Check if the current element is less than x then increase the count of i. Exclude the current row.
// If the element is equal, then print the position and end.
// Print the Element is not found


// JAVA Code for Search in a row wise and
// column wise sorted matrix

public class SearchAnElementInMatriix {

	/* Searches the element x in mat[][]. If the
	element is found, then prints its position
	and returns true, otherwise prints "not found"
	and returns false */
	private static void search(int[][] mat, int n, int x)
	{

		// set indexes for top right
		int i = 0, j = n - 1;
		// element

		while (i < n && j >= 0) {
			if (mat[i][j] == x) {
				System.out.print("Element found at " + i + " " + j);
				return;
			}
			if (mat[i][j] > x)
				j--;
			else // if mat[i][j] < x
				i++;
		}

		System.out.print("n Element not found");
		return; // if ( i==n || j== -1 )
	}
	// Driver code
	public static void main(String[] args)
	{
		int mat[][] = { { 10, 20, 30, 40 },
						{ 15, 25, 35, 45 },
						{ 27, 29, 37, 48 },
						{ 32, 33, 39, 50 } };

		// Function call
		search(mat, 4, 29);
	}
}
