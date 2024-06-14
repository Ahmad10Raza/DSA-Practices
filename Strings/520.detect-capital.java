/*
 * @lc app=leetcode id=520 lang=java
 *
 * [520] Detect Capital
 */



//  Detect Capital
// Category	Difficulty	Likes	Dislikes
// algorithms	Easy (56.49%)	3388	460
// Tags
// Companies
// We define the usage of capitals in a word to be right when one of the following cases holds:

// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital, like "Google".
// Given a string word, return true if the usage of capitals in it is right.

 

// Example 1:

// Input: word = "USA"
// Output: true
// Example 2:

// Input: word = "FlaG"
// Output: false
 

// Constraints:

// 1 <= word.length <= 100
// word consists of lowercase and uppercase English letters.
// Submissions | Solution


// Approach 1: Using Regular Expression
// Time Complexity = O(n)
// Space Complexity = O(1)

// This approach uses regular expression to check if the given string is having the right usage of capitals or not.
// Fllow the steps below to solve the problem:

// Create a regular expression pattern to match the given string with the following conditions:
// ^[a-z]+$ : to match the string with all lowercase letters.
// ^[A-Z]+$ : to match the string with all uppercase letters.
// ^[A-Z][a-z]+$ : to match the string with the first letter as uppercase and the rest as lowercase.
// Use the matches() method of the string class to check if the given string matches the regular expression pattern.
// If the string matches any of the above patterns, return true. Else, return false.

// @lc code=start
class Solution520 {
    public boolean detectCapitalUse(String word) {
        
        return word.matches("[a-z]+|[A-Z]+|[A-Z][a-z]+");
    }

    public boolean detectCapitalUse2(String word) {
        return word.equals(word.toUpperCase()) ||
            word.substring(1).equals(word.substring(1).toLowerCase());
      }

    
}
// @lc code=end

