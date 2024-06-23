import java.util.Iterator;
import java.util.Iterator;
/*
 * @lc app=leetcode id=859 lang=java
 *
 * [859] Buddy Strings
 */

//  Buddy Strings
//  Category	Difficulty	Likes	Dislikes
//  algorithms	Easy (33.08%)	3169	1791
//  Tags
//  Companies
//  Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
 
//  Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
 
//  For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
  
 
//  Example 1:
 
//  Input: s = "ab", goal = "ba"
//  Output: true
//  Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
//  Example 2:
 
//  Input: s = "ab", goal = "ab"
//  Output: false
//  Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
//  Example 3:
 
//  Input: s = "aa", goal = "aa"
//  Output: true
//  Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
  
 
//  Constraints:
 
//  1 <= s.length, goal.length <= 2 * 104
//  s and goal consist of lowercase letters.
//  Submissions | Solution


// Approach 1: Two Pointers
// Time Complexity: O(N), where N is the length of A and B
// Space Complexity: O(1)

// Fllow this step to solve the problem:
// 1. If the length of A and B are different, then we can't make them equal by swapping two characters.
// 2. If A == B, we need to check if there are duplicate characters in A. If there are, we can swap two of them to make the strings equal. Otherwise, the strings are not equal.
// 3. If A != B, we need to check if we can swap two characters in A to make the strings equal. We can do this by checking if there are exactly two differences between A and B, and if the characters at these differences are the same.
// 4. If we can swap two characters in A to make the strings equal, we return true. Otherwise, we return false.


// @lc code=start
class Solution859 {
    public boolean buddyStrings(String s, String goal) {
        
        if (s.length() != goal.length()) return false;
        
        // if s and goal are the same, we can swap two characters in s to make the strings equal
        if (s.equals(goal)) {
            int[] count = new int[26];
            // count the number of each character in s
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            // if there is a character that appears more than once, we can swap two of them to make the strings equal
            for (int c : count) {
                if (c > 1) return true;
            }
            return false;

        // if s and goal are different, we need to check if we can swap two characters in s to make the strings equal
        } else {
            // find the differences between s and goal
            int first = -1, second = -1;
            // find the first and second differences between s and goal
            for (int i = 0; i < s.length(); i++) {
                // if the characters at these differences are the same, we can swap them to make the strings equal
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }

            // if there are exactly two differences between s and goal, and the characters at these differences are the same, we can swap them to make the strings equal
            return (second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first));
        }
    }
}
// @lc code=end

