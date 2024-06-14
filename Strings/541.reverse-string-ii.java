/*
 * @lc app=leetcode id=541 lang=java
 *
 * [541] Reverse String II
 */

//  Reverse String II
// Category	Difficulty	Likes	Dislikes
// algorithms	Easy (50.64%)	1968	3785
// Tags
// Companies
// Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

// If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

 

// Example 1:

// Input: s = "abcdefg", k = 2
// Output: "bacdfeg"
// Example 2:

// Input: s = "abcd", k = 2
// Output: "bacd"
 

// Constraints:

// 1 <= s.length <= 104
// s consists of only lowercase English letters.
// 1 <= k <= 104
// Submissions | Solution

// Approach 1: Using StringBuilder
// Time Complexity = O(n)
// Space Complexity = O(n)

// This approach uses a StringBuilder to reverse the first k characters of every 2k characters in the given string. Follow the steps below to solve the problem:

// Initialize a StringBuilder to store the result.
// Iterate through the given string with a step size of 2k.
// Reverse the first k characters of the substring starting from the current index.
// Append the reversed substring to the StringBuilder.
// Append the remaining characters of the substring to the StringBuilder.
// Return the StringBuilder as a string.


// @lc code=start
class Solution541 {
    public String reverseStr(String s, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i += 2 * k) {
            int start = i;
            int end = Math.min(i + k, s.length());
            sb.append(new StringBuilder(s.substring(start, end)).reverse());
            sb.append(s.substring(end, Math.min(i + 2 * k, s.length())));
        }
        
        return sb.toString();
    }
}
// @lc code=end

