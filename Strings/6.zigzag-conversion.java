/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

//  Zigzag Conversion
//  Category	Difficulty	Likes	Dislikes
//  algorithms	Medium (47.82%)	7556	14530
//  Tags
//  Companies
//  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 
//  P   A   H   N
//  A P L S I I G
//  Y   I   R
//  And then read line by line: "PAHNAPLSIIGYIR"
 
//  Write the code that will take a string and make this conversion given a number of rows:
 
//  string convert(string s, int numRows);
  
 
//  Example 1:
 
//  Input: s = "PAYPALISHIRING", numRows = 3
//  Output: "PAHNAPLSIIGYIR"
//  Example 2:
 
//  Input: s = "PAYPALISHIRING", numRows = 4
//  Output: "PINALSIGYAHRPI"
//  Explanation:
//  P     I    N
//  A   L S  I G
//  Y A   H R
//  P     I
//  Example 3:
 
//  Input: s = "A", numRows = 1
//  Output: "A"
  
 
//  Constraints:
 
//  1 <= s.length <= 1000
//  s consists of English letters (lower-case and upper-case), ',' and '.'.
//  1 <= numRows <= 1000
//  Submissions | Solution

// Approach 1: By Row
// Intuition
// By iterating through the string from left to right, we can easily determine which row in the Zig-Zag pattern that a character belongs to.

// Algorithm
// We can use min(numRows, len(s)) lists to represent the non-empty rows of the Zig-Zag Pattern.

// Iterate through s from left to right, appending each character to the appropriate row. The appropriate row can be tracked using two variables: the current row and the current direction.

// The current direction changes only when we moved up to the topmost row or moved down to the bottommost row.

// Complexity Analysis
// Let N be the length of the string s.
// Time complexity: O(N)
// Space complexity: O(N)

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution6 {
    public String convert(String s, int numRows) {
        
        // If numRows is 1, return the string as it is
        if (numRows == 1) return s;
        
        // Create a list of StringBuilder to store the characters in each row
        List<StringBuilder> rows = new ArrayList<>();
        // Add the number of rows to the list of StringBuilder objects 
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        
        int curRow = 0;
        boolean goingDown = false;
        
        // Iterate through the string and add the characters to the appropriate row
        for (char c : s.toCharArray()) {
            // Append the character to the current row
            rows.get(curRow).append(c);
            // If we are at the topmost row or the bottommost row, change the direction
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        // Combine the characters in each row to get the final Zig-Zag pattern
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }
}
// @lc code=end

