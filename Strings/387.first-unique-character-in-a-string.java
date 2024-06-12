/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

 // First Unique Character in a String

// Example 1:
// Input: s = "leetcode"
// Output: 0
// Explanation: The first unique character is "l".

// Example 2:
// Input: s = "loveleetcode"
// Output: 2
// Explanation: The first unique character is "v".

// Approach: Count Array and single string traversal
// Time Complexity: O(n)
// Space Complexity: O(1) - As the count array will have at most 26 characters

// Follow the steps below to solve the problem:

// Make a count array of a maximum number of characters(256) and initialize all the elements in this array to -1. 
// Then loop through the string character by character and check if the array element with this character as the index is -1 or not. 
// If it is -1 then change it to i and. If it is not -1, then this means that this character already appeared before, so change it to -2. 
// In the end, all the repeating characters will be changed to -2 and all non-repeating characters will contain the index where they occur. 
// Now, just loop through all the non-repeating characters and find the minimum index or the first index.


// @lc code=start
class Solution387 {
    public int firstUniqChar(String str) {
        
        int[] fi = new int[256]; // array to store First Index

    // initializing all elements to -1
    for (int i = 0; i < 256; i++)
        fi[i] = -1;

    // sets all repeating characters to -2 and
    // non-repeating characters contain the index where
    // they occur
    for (int i = 0; i < str.length(); i++) {
        if (fi[str.charAt(i)] == -1) {
            fi[str.charAt(i)] = i;
        }
        else {
            fi[str.charAt(i)] = -2;
        }
    }

    int res = Integer.MAX_VALUE;

    for (int i = 0; i < 256; i++) {

        // If this character is not -1 or -2 then it
        // means that this character occurred only once
        // so find the min index of all characters that
        // occur only once, that's our first index
        if (fi[i] >= 0)
            res = Math.min(res, fi[i]);
    }

    // if res remains  Integer.MAX_VALUE, it means there
    // are no characters that repeat only once or the
    // string is empty
    if (res == Integer.MAX_VALUE)
        return -1;
    else
        return res;

    }
}
// @lc code=end

