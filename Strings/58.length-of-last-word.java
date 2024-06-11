/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

//  Length of Last Word
// Category	Difficulty	Likes	Dislikes
// algorithms	Easy (51.41%)	5137	279
// Tags
// Companies
// Given a string s consisting of words and spaces, return the length of the last word in the string.

// A word is a maximal substring consisting of non-space characters only.

 

// Example 1:

// Input: s = "Hello World"
// Output: 5
// Explanation: The last word is "World" with length 5.
// Example 2:

// Input: s = "   fly me   to   the moon  "
// Output: 4
// Explanation: The last word is "moon" with length 4.
// Example 3:

// Input: s = "luffy is still joyboy"
// Output: 6
// Explanation: The last word is "joyboy" with length 6.
 

// Constraints:

// 1 <= s.length <= 104
// s consists of only English letters and spaces ' '.
// There will be at least one word in s.
// Submissions | Solution

// Approach 2: Iterate the string from the last index. This idea is
// more efficient since we can easily ignore the spaces from the last. 
// The idea is to start incrementing the count when you encounter the 
// first alphabet from the last and stop when you encounter a space 
// after those alphabets.



// @lc code=start
class Solution58 {
    public int lengthOfLastWord(String a) {
        boolean char_flag = false;
        int len = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            // If the character is alphabets 
            if (Character.isLetter(a.charAt(i))) {
                // Once the first character from last
                // is encountered, set char_flag to true.
                char_flag = true;
                len++;
            }
            else {
                // When the first space after the characters
                // (from the last) is encountered, return
                // the length of the last word
                if (char_flag == true)
                    return len;
            }
        }
        return len;
    }
}
// @lc code=end

