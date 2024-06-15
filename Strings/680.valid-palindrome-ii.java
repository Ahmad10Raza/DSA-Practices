/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

//  Valid Palindrome II
// Category	Difficulty	Likes	Dislikes
// algorithms	Easy (40.59%)	8166	436
// Tags
// Companies
// Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

// Example 1:

// Input: s = "aba"
// Output: true
// Example 2:

// Input: s = "abca"
// Output: true
// Explanation: You could delete the character 'c'.
// Example 3:

// Input: s = "abc"
// Output: false
 

// Constraints:

// 1 <= s.length <= 105
// s consists of lowercase English letters.
// Submissions | Solution

// Approach 1: Greedy
// Time complexity: O(n)
// Space complexity: O(1)

// Follow the steps below to solve the problem:

// Initialize two pointers, left and right, to the start and end of the string, respectively.
// Iterate through the string while the left pointer is less than the right pointer.
// If the characters at the left and right pointers are equal, move the pointers towards the center.
// If the characters at the left and right pointers are not equal, return the result of the helper function that checks if the substring formed by excluding the character at the left pointer is a palindrome or the substring formed by excluding the character at the right pointer is a palindrome.
// Return true if the string is a palindrome or can be a palindrome by deleting at most one character; otherwise, return false.


// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
     
        // Initialize two pointers, left and right, to the start and end of the string, respectively.
        int left = 0, right = s.length() - 1;
        
        // Iterate through the string while the left pointer is less than the right pointer.
        while (left < right) {
            
            // If the characters at the left and right pointers are equal, move the pointers towards the center.
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                
                // If the characters at the left and right pointers are not equal, return the result of the helper function that checks if the substring formed by excluding the character at the left pointer is a palindrome or the substring formed by excluding the character at the right pointer is a palindrome.
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        
        // Return true if the string is a palindrome or can be a palindrome by deleting at most one character; otherwise, return false.
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

