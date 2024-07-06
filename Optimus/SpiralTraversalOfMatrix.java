
// A Java program to print a given matrix in spiral form

// Spiral Traverse of Matrix is a process of printing all the elements of a matrix in a spiral order starting from the top-left corner and moving in a clockwise direction.

// For Example:
// Input:
// 1 2 3
// 4 5 6
// 7 8 9

// Output:
// 1 2 3 6 9 8 7 4 5

// Approach:
// 1. Initialize four variables top, bottom, left, and right to 0, rows-1, 0, and columns-1 respectively.
// 2. Run a loop until top is less than or equal to bottom and left is less than or equal to right.
// 3. Print the elements of the top row from left to right.
// 4. Increment the value of top by 1.
// 5. Print the elements of the rightmost column from top to bottom.
// 6. Decrement the value of right by 1.
// 7. Print the elements of the bottom row from right to left.
// 8. Decrement the value of bottom by 1.
// 9. Print the elements of the leftmost column from bottom to top.
// 10. Increment the value of left by 1.                                        
// 11. Repeat the above steps until top is less than or equal to bottom and left is less than or equal to right.

// Complexity Analysis:
// 1. Time Complexity: O(rows*columns), where rows is the number of rows and columns is the number of columns in the matrix.
// 2. Space Complexity: O(1), as no extra space is used.

public class SpiralTraversalOfMatrix {

    public static void spiralTraversal(int[][] matrix, int rows, int columns) {
        int top = 0, bottom = rows - 1, left = 0, right = columns - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int rows = 3, columns = 3;
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        spiralTraversal(matrix, rows, columns);
    }
}
