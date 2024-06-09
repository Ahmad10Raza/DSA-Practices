/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */



//  Longest Common Prefix
// Category	Difficulty	Likes	Dislikes
// algorithms	Easy (42.71%)	17370	4518
// Tags
// Companies
// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

 

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
 

// Constraints:

// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lowercase English letters.
// Submissions | Solution
// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
// @lc code=end

