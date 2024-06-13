/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

//  Repeated Substring Pattern
// Category	Difficulty	Likes	Dislikes
// algorithms	Easy (46.07%)	6367	518
// Tags
// Companies
// Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

 

// Example 1:

// Input: s = "abab"
// Output: true
// Explanation: It is the substring "ab" twice.
// Example 2:

// Input: s = "aba"
// Output: false
// Example 3:

// Input: s = "abcabcabcabc"
// Output: true
// Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 

// Constraints:

// 1 <= s.length <= 104
// s consists of lowercase English letters.
// Submissions | Solution

// Approach 1: Two pointer Approach
// Time Complexity = O(n)
// Space Complexity = O(1)

// This approach uses two pointers to check the minimum period of a String as a first step. Period of a String is the length of prefix substring which can be repeated x(x=length/period) times to construct the given string. 

// for eg: Input string “abcabcabcabc” is having a period 3. which means we can construct the given string by repeating first 3 characters  4 (length/3=4) number of times.

// Approach:

// Initially set first pointer – i at 0th index of given string and second pointer – j at 1st index.
// check the characters at both index. if both matches, take period as (j-i) and increment i and j.
// if doesn’t match, Once again check if current character matches with first character at 0th index. if matches, update period as j(j-0=j) and set i to next character.
// f both characters not matches, set i to 0 and update period to -1.
// At the end check if the calculated period exactly divides the length of the string. if not, update period to -1. This check eliminates the presence of strings ending with suffix less than the period. for e.g period for the string “GEEKSFORGEEKS” is calculated as 8 but the suffix string(GEEKS) is having 5 characters only and is incomplete.

// @lc code=start
class Solution459 {
    public int repeatedSubstringPattern(String A) {
        int length = A.length();
 
        // Initially consider there is no period for given
        // String
        int period = -1;
 
        /*set two pointers one(i) at
        index 0 and other(j) at index 1. increment j till
        first character is obtained  in the string*/
        int i = 0;
        for (int j = 1; j < length; j++) {
            int currChar = A.charAt(j);
            int comparator = A.charAt(i);
 
            /*If current character matches with first
             *character
             *update period as the difference of j and i*/
            if (currChar == comparator) {
                period = (j - i);
                i++;
            }
 
            /* if any mismatch occurs in between set i to
             * zero also check if current character again
             * matches
             * with starting character. If matches, update
             * period*/
            else {
                if (currChar == A.charAt(0)) {
                    i = 1;
                    period = j;
                }
                else {
                    i = 0;
                    period = -1;
                }
            }
        }
 
        /*check if the period is exactly dividing
         * string if not reset the period to -1
         * this eliminates partial substrings like
         *  e.g string -"GEEKSFORGEEKS"  */
 
        period = (length % period != 0) ? -1 : period;
        return period;
    }
}
// @lc code=end

