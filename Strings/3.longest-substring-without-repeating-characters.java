/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start



    // Given a string s, find the length of the longest substring without repeating characters.
    // Example 1:
    // Input: s = "abcabcbb"
    // Output: 3

    // Example 2:
    // Input: s = "bbbbb"
    // Output: 1

    // Example 3:
    // Input: s = "pwwkew"
    // Output: 3

    // Approach 1: Sliding Window
    // Time Complexity: O(2n) = O(n). In the worst case each character will be visited twice by i and j
    // Space Complexity: O(min(m, n)). We need O(k) space for the sliding window, where k is the size of the Set. The size of the Set is upper bounded by the size of the string n and the size of the charset/alphabet m.

//     Follow the steps below to solve the problem:

// Intialize two pointers left and right with 0, which define the current window being considered.
// The right pointer moves from left to right, extending the current window.
// If the character at right pointer is not visited , it’s marked as visited.
// If the character at right pointer is visited, it means there is a repeating character. The left pointer moves to the right while marking visited characters as false until the repeating character is no longer part of the current window.
// The length of the current window (right - left + 1) is calculated and answer is updated accordingly.

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String str) {

        // if string length is 0
        if (str.length() == 0)
            return 0;

        // if string length 1
        if (str.length() == 1)
            return 1;

        // if string length is more than 2
        int maxLength = 0;
        boolean[] visited = new boolean[256];

        // left and right pointer of sliding window
        int left = 0, right = 0;
        while (right < str.length()) {

            // if character is visited
            if (visited[str.charAt(right)]) {

                // The left pointer moves to the right while
                // marking visited characters as false until
                // the repeating character is no longer part
                // of the current window.
                while (visited[str.charAt(right)]) {

                    visited[str.charAt(left)] = false;
                    left++;
                }
            }

            visited[str.charAt(right)] = true;

            // The length of the current window (right -
            // left + 1) is calculated and answer is updated
            // accordingly.
            maxLength  = Math.max(maxLength, (right - left + 1));
            right++;
        }
        return maxLength;

        
    }

    public int lengthOfLongestSubstring2(String s) {
        Set<Character>set=new HashSet<>();
        int maxLength=0;
        int left=0;
        for(int right=0;right<s.length();right++){
           
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength=Math.max(maxLength,right-left+1);
                
            }else{
                while(s.charAt(left)!=s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));left++;
                set.add(s.charAt(right));
            }
            
        }
        return maxLength;
    }
}
// @lc code=end

