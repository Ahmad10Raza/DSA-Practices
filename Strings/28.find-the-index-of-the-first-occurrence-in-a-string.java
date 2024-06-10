/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Find the Index of the First Occurrence in a String
 */

//  Find the Index of the First Occurrence in a String
// Category	Difficulty	Likes	Dislikes
// algorithms	Easy (42.21%)	5709	397
// Tags
// Companies
// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

// Example 1:

// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.
// Example 2:

// Input: haystack = "leetcode", needle = "leeto"
// Output: -1
// Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

// Constraints:

// 1 <= haystack.length, needle.length <= 104
// haystack and needle consist of only lowercase English characters.
// Submissions | Solution

// Algorithm to find the index of the first occurrence of a string in another string:

// Find the length of the needle string.
// Find the length of the haystack string.
// If the length of the needle string is greater than the length of the haystack string, return -1.
// If the length of the needle string is 0, return 0.
// Iterate through the haystack string.
// If the current character of the haystack string is equal to the first character of the needle string, check if the substring of the haystack string starting from the current index and having the length of the needle string is equal to the needle string.
// If the substring is equal to the needle string, return the current index.
// If the substring is not equal to the needle string, continue iterating through the haystack string.


// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        
        if(needleLength > haystackLength) return -1;
        if(needleLength == 0) return 0;
        
        for(int i = 0; i < haystackLength; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(haystack.substring(i, i + needleLength).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

