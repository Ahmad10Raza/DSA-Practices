/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */


//  Reverse Vowels of a String
//  Category	Difficulty	Likes	Dislikes
//  algorithms	Easy (52.96%)	4503	2778
//  Tags
//  Companies
//  Given a string s, reverse only all the vowels in the string and return it.
 
//  The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 
  
 
//  Example 1:
 
//  Input: s = "hello"
//  Output: "holle"
//  Example 2:
 
//  Input: s = "leetcode"
//  Output: "leotcede"
  
 
//  Constraints:
 
//  1 <= s.length <= 3 * 105
//  s consist of printable ASCII characters.
//  Submissions | Solution
 
// Approach 1: Two Pointers
// Time Complexity: O(n)
// Space Complexity: O(1)

// Follow the steps below to solve the problem:

// Initialize two pointers, left and right, to point to the start and end of the input string s, respectively.
// While the left pointer is less than the right pointer, do the following:
// If the character at the left pointer is not a vowel, move the left pointer to the right.
// If the character at the right pointer is not a vowel, move the right pointer to the left.
// If the characters at both the left and right pointers are vowels, swap them.
// Continue the process until the left pointer is less than the right pointer.
// Return the string obtained after the vowels are reversed.
// Let's implement the algorithm now.

// @lc code=start
class Solution345 {

    public boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
    public String reverseVowels(String s) {
        
        int i = 0;
        int j = s.length() - 1;

        char[] arr = s.toCharArray();
        while(i < j) {
            if(!isVowel(arr[i])) {
                i++;
                continue;
            }
            if(!isVowel(arr[j])) {
                j--;
                continue;
            }
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}
// @lc code=end

