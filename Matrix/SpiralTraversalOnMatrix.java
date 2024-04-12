
// Given a 2D array, print it in spiral form.

// Examples: 

// Input:  {{1,    2,   3,   4},
//               {5,    6,   7,   8},
//              {9,   10,  11,  12},
//             {13,  14,  15,  16 }}
// Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 

// Aproach: Print a given matrix in spiral form using the simulation approach:
// To solve the problem follow the below idea:

// Draw the path that the spiral makes. We know that the path should turn clockwise 
// whenever it would go out of bounds or into a cell that was previously visited

// Follow the given steps to solve the problem:

// Let the array have R rows and C columns
// seen[r] denotes that the cell on the r-th row and c-th column was previously visited. 
// Our current position is (r, c), facing direction di, and we want to visit R x C total cells.
// As we move through the matrix, our candidate’s next position is (cr, cc). 
// If the candidate is in the bounds of the matrix and unseen, then it becomes our next position; 
// otherwise, our next position is the one after performing a clockwise turn


// Java program for the above approach
import java.util.*;

class Solution {

	// Function to print in spiral order
	public static List<Integer> spiralOrder(int[][] matrix)
	{
		List<Integer> ans = new ArrayList<Integer>();

		if (matrix.length == 0)
			return ans;

		int m = matrix.length, n = matrix[0].length;
		boolean[][] seen = new boolean[m][n];
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int x = 0, y = 0, di = 0;

		// Iterate from 0 to R * C - 1
		for (int i = 0; i < m * n; i++) {
			ans.add(matrix[x][y]);
			seen[x][y] = true;
			int cr = x + dr[di];
			int cc = y + dc[di];

			if (0 <= cr && cr < m && 0 <= cc && cc < n
				&& !seen[cr][cc]) {
				x = cr;
				y = cc;
			}
			else {
				di = (di + 1) % 4;
				x += dr[di];
				y += dc[di];
			}
		}
		return ans;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int a[][] = { { 1, 2, 3, 4 },
					{ 5, 6, 7, 8 },
					{ 9, 10, 11, 12 },
					{ 13, 14, 15, 16 } };

		// Function call
		System.out.println(spiralOrder(a));
	}
}
