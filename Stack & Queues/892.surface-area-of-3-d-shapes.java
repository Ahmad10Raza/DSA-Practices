/*
 * @lc app=leetcode id=892 lang=java
 *
 * [892] Surface Area of 3D Shapes
 */


     
//  Surface Area of 3D Shapes
//  Category	Difficulty	Likes	Dislikes
//  algorithms	Easy (65.73%)	564	746
//  Tags
//  Companies
//  You are given an n x n grid where you have placed some 1 x 1 x 1 cubes. Each value v = grid[i][j] represents a tower of v cubes placed on top of cell (i, j).
 
//  After placing these cubes, you have decided to glue any directly adjacent cubes to each other, forming several irregular 3D shapes.
 
//  Return the total surface area of the resulting shapes.
 
//  Note: The bottom face of each shape counts toward its surface area.
 
  
 
//  Example 1:
 
 
//  Input: grid = [[1,2],[3,4]]
//  Output: 34
//  Example 2:
 
 
//  Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
//  Output: 32
//  Example 3:
 
 
//  Input: grid = [[2,2,2],[2,1,2],[2,2,2]]
//  Output: 46
  
 
//  Constraints:
 
//  n == grid.length == grid[i].length
//  1 <= n <= 50
//  0 <= grid[i][j] <= 50
//  Submissions | Solution

// @lc code=start

// Approach 1: Greedy
// Time Complexity: O(N^2), where N is the length of grid
// Space Complexity: O(1)

// Follow this step to solve the problem:
// 1. Initialize the variables totalArea and overlap to 0.
// 2. Iterate through the grid array and do the following:
//     - Increment the totalArea by 4 times the value of the current cell.
//     - If the current cell is not the first row, increment the overlap by the minimum of the current cell and the cell above it.
//     - If the current cell is not the first column, increment the overlap by the minimum of the current cell and the cell to the left of it.
// 3. Return the totalArea minus the overlap multiplied by 2.

// java Approach 

class Solution892 {
    public int surfaceArea(int[][] grid) {
        
        int totalArea = 0;
        int overlap = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                
                totalArea += grid[i][j] * 4;
                
                if (i > 0) {
                    overlap += Math.min(grid[i][j], grid[i - 1][j]);
                }
                
                if (j > 0) {
                    overlap += Math.min(grid[i][j], grid[i][j - 1]);
                }
            }
        }
        
        return totalArea - overlap * 2;
    }
}
// @lc code=end

