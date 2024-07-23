
// Problem Description
// In the given problem, we have a box represented by a 2-D grid of size m x n, where m is the number of rows and n is the number of columns. There are n balls that we will be dropping from each column's top. Each cell in the grid has a diagonal board that can either redirect the ball to the right or to the left. The boards are represented by either a 1 (redirects to the right) or a -1 (redirects to the left). Our objective is to determine the final column where each ball lands at the bottom, or decide that the ball is stuck in the box. A ball is considered stuck if it encounters a 'V' shaped pattern formed by two adjacent cells with diagonal boards pointing towards each other or if it is redirected into a wall.

// To summarize, we need to simulate the path of each ball dropped from the top and see where, if at all, it comes out at the bottom. We must return an array where each index contains the column number where the corresponding ball exits, or -1 if the ball gets stuck.

// Solution Approach
// The solution implements a recursive Depth-First Search (DFS) function dfs which takes two parameters, i and j, corresponding to the current cell's row and column indexes. It attempts to follow the ball's path from the top of the column where it is dropped, until it either falls out of the grid or gets stuck according to the rules described in the problem.

// Here is a step-by-step walkthrough of the recursive dfs function implemented in the solution:

// Base Case: If i equals the number of rows m, it means the ball has reached the bottom of the grid. The function then returns the column index j, indicating the exit column.

// Boundary Check: If the ball is at the first column and the current board directs to the left (grid[i][j] == -1), or it's at the last column and the board directs to the right (grid[i][j] == 1), the ball is stuck because it will collide with the wall. In these cases, the function returns -1.

// V-shaped Pattern Check: If the current board directs the ball to the right (grid[i][j] == 1) but the next column's board directs to the left (grid[i][j + 1] == -1), the ball is stuck in a 'V' shaped pattern. The same check applies if the current board directs left (grid[i][j] == -1) and the previous column's board directs to the right (grid[i][j - 1] == 1). Again, the function returns -1 if any of these scenarios occur.

// Recursive Case: If none of these conditions apply, the ball can continue to the next row. The direction is determined by the current board: if grid[i][j] == 1, the ball will go to the cell on the right (j+1), while if grid[i][j] == -1, it will go to the cell on the left (j-1). It then calls itself with the new cell's coordinates and continues the path tracing.

// Loop Through Columns: The function findBall sets up a loop that goes through all columns (for each ball). "dfs(0, j)" calls the recursive dfs function from the top row (0) of each column (j). The results are added to the return list, which eventually contains the outcome for each ball's path.

// It’s important to note that the recursion in this solution serves as backtracking through the grid. At any point, if a ball cannot move downwards, it returns -1, effectively "backtracking" and ending that path. The use of the list comprehension [dfs(0, j) for j in range(n)] succinctly executes this process for each ball and compiles the results into the final list.

// In summary, the algorithm employs DFS and checks for boundary conditions as well as path continuity (no 'V' pattern obstruction) to determine the ball's final position. It leverages recursion to elegantly handle the traversal of each possible pathway.

public class WhereTheBallFall {

    // Dimensions of the grid
    private int rowCount;
    private int columnCount;
    // The grid to operate on
    private int[][] grid;

    // Finds the eventual positions of the balls
    public int[] findBall(int[][] grid) {
        // Initialize the dimensions based on the input grid
        rowCount = grid.length;
        columnCount = grid[0].length;
        // Store the grid in the field for easy access
        this.grid = grid;

        // Result array to store the final position of each ball
        int[] result = new int[columnCount];
        // Simulate the path for each ball starting from the top row
        for (int col = 0; col < columnCount; ++col) {
            result[col] = dropBall(0, col);
        }
        return result;
    }

    // Runs the simulation for a single ball drop, returning its final position
    private int dropBall(int row, int col) {
        // If the ball has reached the bottom row, return the column index
        if (row == rowCount) {
            return col;
        }
        // Check for out-of-bound scenarios or cases where the ball gets stuck
        if (col == 0 && grid[row][col] == -1 || col == columnCount - 1 && grid[row][col] == 1 ||
                grid[row][col] == 1 && grid[row][col + 1] == -1 ||
                grid[row][col] == -1 && grid[row][col - 1] == 1) {
            return -1; // Ball is stuck or fell out of the grid
        }
        // Recursively drop the ball into the next slot based on the current direction
        return grid[row][col] == 1 ? dropBall(row + 1, col + 1) : dropBall(row + 1, col - 1);
    }
}
