/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */

//  Ransom Note
//  Category	Difficulty	Likes	Dislikes
//  algorithms	Easy (61.25%)	4935	497
//  Tags
//  Companies
//  Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 
//  Each letter in magazine can only be used once in ransomNote.
 
  
 
//  Example 1:
 
//  Input: ransomNote = "a", magazine = "b"
//  Output: false
//  Example 2:
 
//  Input: ransomNote = "aa", magazine = "ab"
//  Output: false
//  Example 3:
 
//  Input: ransomNote = "aa", magazine = "aab"
//  Output: true
  
 
//  Constraints:
 
//  1 <= ransomNote.length, magazine.length <= 105
//  ransomNote and magazine consist of lowercase English letters.
//  Submissions | Solution
 
// Approach 1: Hash Map
// Time Complexity: O(m+n)
// Space Complexity: O(C)

// Follow the steps below to solve the problem:

// Create a hash map, magazineMap, to store the frequency of each character in the magazine string.
// Iterate through the magazine string and update the frequency of each character in the magazineMap.
// Iterate through the ransomNote string and do the following:
// If the character is not present in the magazineMap or its frequency is 0, return false.
// Otherwise, decrement the frequency of the character in the magazineMap.
// If the loop completes successfully, return true.

// Let's implement the algorithm now.

// @lc code=start
class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {

        // Create a hash map, magazineMap, to store the frequency of each character in the magazine string.
        int[] magazineMap = new int[26];
        // Iterate through the magazine string and update the frequency of each character in the magazineMap.
        for (char c : magazine.toCharArray()) {
            // here c - 'a' will give the index of the character in the array
            magazineMap[c - 'a']++;
        }
        // Iterate through the ransomNote string and do the following:
        for (char c : ransomNote.toCharArray()) {
            // If the character is not present in the magazineMap or its frequency is 0, return false.
            if (magazineMap[c - 'a'] == 0) {
                return false;
            }
            // Otherwise, decrement the frequency of the character in the magazineMap.
            magazineMap[c - 'a']--;
        }

        return true;
        
    }
}
// @lc code=end

