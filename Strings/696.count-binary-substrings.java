/*
 * @lc app=leetcode id=696 lang=java
 *
 * [696] Count Binary Substrings
 */


//  Count Binary Substrings
// Category	Difficulty	Likes	Dislikes
// algorithms	Easy (65.55%)	3946	859
// Tags
// Companies
// Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

// Substrings that occur multiple times are counted the number of times they occur.

 

// Example 1:

// Input: s = "00110011"
// Output: 6
// Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
// Notice that some of these substrings repeat and are counted the number of times they occur.
// Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
// Example 2:

// Input: s = "10101"
// Output: 4
// Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 

// Constraints:

// 1 <= s.length <= 105
// s[i] is either '0' or '1'.
// Submissions | Solution

// Approach:  
// Count the number of consecutive 0’s (or 1’s) from start of the string.
// Then count the number of consecutive 1’s (or 0’s) from the position in the string str where count of 0’s (or 1’s) ends.
// The total number of substrings with consecutive 0’s and 1’s is the minimum of the count of consecutive 0’s and 1’s found in above two steps.
// Repeat the above steps till the end of the string str.

// @lc code=start
class Solution696 {
    public int countBinarySubstrings(String S) {
        
        // To store the total count of substrings
        int ans = 0;
        int n = S.length();
 
        int i = 0;
 
        // Traversing the string
        while (i < n) {
 
            // Count of consecutive 0's & 1's
            int cnt0 = 0, cnt1 = 0;
 
            // Counting subarrays of type "01"
            if (S.charAt(i) == '0') {
 
                // Count the consecutive 0's
                while (i < n && S.charAt(i) == '0') {
                    cnt0++;
                    i++;
                }
 
                // If consecutive 0's ends then check for
                // consecutive 1's
                int j = i;
 
                // Counting consecutive 1's
                while (j < n && S.charAt(j) == '1') {
                    cnt1++;
                    j++;
                }
            }
 
            // Counting subarrays of type "10"
            else {
 
                // Count consecutive 1's
                while (i < n && S.charAt(i) == '1') {
                    cnt1++;
                    i++;
                }
 
                // If consecutive 1's ends then check for
                // consecutive 0's
                int j = i;
 
                // Count consecutive 0's
                while (j < n && S.charAt(j) == '0') {
                    cnt0++;
                    j++;
                }
            }
 
            // Update the total count of substrings with
            // minimum of (cnt0, cnt1)
            ans += Math.min(cnt0, cnt1);
        }
 
        // Return answer
        return ans;
    }
}
// @lc code=end

