/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

//  Interleaving String
//  Category	Difficulty	Likes	Dislikes
//  algorithms	Medium (39.93%)	8170	482
//  Tags
//  Companies
//  Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 
//  An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:
 
//  s = s1 + s2 + ... + sn
//  t = t1 + t2 + ... + tm
//  |n - m| <= 1
//  The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
//  Note: a + b is the concatenation of strings a and b.
 
  
 
//  Example 1:
 
 
//  Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//  Output: true
//  Explanation: One way to obtain s3 is:
//  Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
//  Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
//  Since s3 can be obtained by interleaving s1 and s2, we return true.
//  Example 2:
 
//  Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//  Output: false
//  Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
//  Example 3:
 
//  Input: s1 = "", s2 = "", s3 = ""
//  Output: true
  
 
//  Constraints:
 
//  0 <= s1.length, s2.length <= 100
//  0 <= s3.length <= 200
//  s1, s2, and s3 consist of lowercase English letters.
  
 
//  Follow up: Could you solve it using only O(s2.length) additional memory space?
 
//  Submissions | Solution
 

// Approach 1: Recursion
// Time Complexity: O(2^(n+m)), where n and m are the lengths of s1 and s2
// Space Complexity: O(n+m), where n and m are the lengths of s1 and s2

// Follow this step to solve the problem:
// 1. If the length of s3 is not equal to the sum of the lengths of s1 and s2, return false.
// 2. Create a recursive function isInterleave that takes the indices i, j, and k as arguments and returns a boolean value.
// 3. If the indices i, j, and k are equal to the lengths of s1, s2, and s3, respectively, return true.
// 4. If the index k is equal to the length of s3, return false.
// 5. If the character at index k in s3 is equal to the character at index i in s1, recursively call the isInterleave function with the indices i + 1, j, and k + 1.
// 6. If the character at index k in s3 is equal to the character at index j in s2, recursively call the isInterleave function with the indices i, j + 1, and k + 1.
// 7. Return the logical OR of the results obtained from steps 5 and 6.
// 8. Return the result of the isInterleave function with the indices 0, 0, and 0 as arguments.




// @lc code=start
class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        
        return isInterleave(s1, s2, s3, 0, 0, 0);
    }

    private boolean isInterleave(String s1, String s2, String s3, int i, int j, int k) {
        
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        
        if (k == s3.length()) {
            return false;
        }
        
        boolean first = false;
        boolean second = false;
        
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            first = isInterleave(s1, s2, s3, i + 1, j, k + 1);
        }
        
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            second = isInterleave(s1, s2, s3, i, j + 1, k + 1);
        }
        
        return first || second;
    }
}
// @lc code=end

