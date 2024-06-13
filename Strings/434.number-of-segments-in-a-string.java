/*
 * @lc app=leetcode id=434 lang=java
 *
 * [434] Number of Segments in a String
 */


//  Number of Segments in a String
// Category	Difficulty	Likes	Dislikes
// algorithms	Easy (36.39%)	784	1256
// Tags
// Companies
// Given a string s, return the number of segments in the string.

// A segment is defined to be a contiguous sequence of non-space characters.

 

// Example 1:

// Input: s = "Hello, my name is John"
// Output: 5
// Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
// Example 2:

// Input: s = "Hello"
// Output: 1
 

// Constraints:

// 0 <= s.length <= 300
// s consists of lowercase and uppercase English letters, digits, or one of the following characters "!@#$%^&*()_+-=',.:".
// The only space character in s is ' '.
// Submissions | Solution

// Approach 1: Counting the Number of Segments
// Time complexity : O(n)
// Space complexity : O(1)

// Follow this algorithm to count the number of segments in the given string:

// Initialize the variable count to 0.
// Iterate over the string from left to right:
// If the current character is not a space and the previous character is a space, increment the count.
// Return the value of count as the result.


// @lc code=start
class Solution434 {
    public int countSegments(String s) {
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

