/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */

//  Add Strings
// Category	Difficulty	Likes	Dislikes
// algorithms	Easy (51.70%)	5003	748
// Tags
// Companies
// Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

// You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

 

// Example 1:

// Input: num1 = "11", num2 = "123"
// Output: "134"
// Example 2:

// Input: num1 = "456", num2 = "77"
// Output: "533"
// Example 3:

// Input: num1 = "0", num2 = "0"
// Output: "0"
 

// Constraints:

// 1 <= num1.length, num2.length <= 104
// num1 and num2 consist of only digits.
// num1 and num2 don't have any leading zeros except for the zero itself.
// Submissions | Solution

// Approach 1: Elementary Math
// Time complexity : O(max(n1,n2)). Here, n1 and n2 refer to the lengths of num1 and num2 respectively. The algorithm traverses the length of the maximum number which is max(n1,n2).
// Space complexity : O(max(n1,n2)). The length of the new string is at most max(n1,n2)+1.

// Follow this steps to solve the problem:

// Initialize an empty string, resres, to store the result.
// Convert the strings num1 and num2 into integers, x and y, respectively.
// Compute the sum x+y and convert it back into a string.
// Return the result resres.




// @lc code=start
class Solution415 {
    public String addStrings(String num1, String num2) {
        
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0){
                sum += num1.charAt(i) - '0';
                i--;
            }
            if(j>=0){
                sum += num2.charAt(j) - '0';
                j--;
            }
            res.append(sum%10);
            carry = sum/10;
        }
        if(carry!=0){
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
// @lc code=end

