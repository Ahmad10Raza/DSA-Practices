/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */


//  Add Binary
//  Category	Difficulty	Likes	Dislikes
//  algorithms	Easy (53.48%)	9348	965
//  Tags
//  Companies
//  Given two binary strings a and b, return their sum as a binary string.
 
  
 
//  Example 1:
 
//  Input: a = "11", b = "1"
//  Output: "100"
//  Example 2:
 
//  Input: a = "1010", b = "1011"
//  Output: "10101"
  
 
//  Constraints:
 
//  1 <= a.length, b.length <= 104
//  a and b consist only of '0' or '1' characters.
//  Each string does not contain leading zeros except for the zero itself.
//  Submissions | Solution
 
// Approach 1: The idea is start from last charcter of both strings and keep adding the characters by converting them to integer and keep track of carry.
// If the sum is 0 or 2 then carry is 0 else carry is 1.
// At the end if carry is 1 then add it to the result.
// Reverse the result and return it.
 
// @lc code=start
class Solution67 {
    public String addBinary(String A, String B) {
        // initialize the ith index
        int i = A.length()-1;
        // initialize the jth index
        int j = B.length()-1;
        // initialize the carry 
        int carry = 0;
      // initialize the sum
        int sum = 0;
        StringBuilder result =  new StringBuilder();
        while(i>=0 || j>=0 || carry == 1){
            
            sum = carry;
            // if i is greater than 0 then add the ith character of A to sum '0' to convert it to integer
            if(i>=0) sum = sum+A.charAt(i)-'0';
            // if j is greater than 0 then add the jth character of B to sum '0' to convert it to integer
            if(j>=0) sum = sum+B.charAt(j)-'0';
            // append the sum%2 to the result and convert it to char
            result.append((char)(sum%2+'0'));
            // calculate the carry
            carry = sum/2;
            i--;
            j--;
        }
        // reverse the result and return it
        return result.reverse().toString();
    }
}
// @lc code=end

