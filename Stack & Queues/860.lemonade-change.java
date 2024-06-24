/*
 * @lc app=leetcode id=860 lang=java
 *
 * [860] Lemonade Change
 */

//  Lemonade Change
//  Category	Difficulty	Likes	Dislikes
//  algorithms	Easy (53.23%)	2339	163
//  Tags
//  Companies
//  At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
 
//  Note that you do not have any change in hand at first.
 
//  Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.
 
  
 
//  Example 1:
 
//  Input: bills = [5,5,5,10,20]
//  Output: true
//  Explanation: 
//  From the first 3 customers, we collect three $5 bills in order.
//  From the fourth customer, we collect a $10 bill and give back a $5.
//  From the fifth customer, we give a $10 bill and a $5 bill.
//  Since all customers got correct change, we output true.
//  Example 2:
 
//  Input: bills = [5,5,10,10,20]
//  Output: false
//  Explanation: 
//  From the first two customers in order, we collect two $5 bills.
//  For the next two customers in order, we collect a $10 bill and give back a $5 bill.
//  For the last customer, we can not give the change of $15 back because we only have two $10 bills.
//  Since not every customer received the correct change, the answer is false.
  
 
//  Constraints:
 
//  1 <= bills.length <= 105
//  bills[i] is either 5, 10, or 20.
//  Submissions | Solution

// Approach 1: Greedy
// Time Complexity: O(N), where N is the length of bills
// Space Complexity: O(1)

// Follow this step to solve the problem:
// 1. Initialize two variables, five and ten, to keep track of the number of $5 and $10 bills we have.
// 2. Iterate through the bills array and do the following:
//     - If the current bill is $5, increment the five variable by 1.
//     - If the current bill is $10, increment the ten variable by 1 and decrement the five variable by 1.
//     - If the current bill is $20, we have two options:
//         - If we have a $10 bill, decrement the ten variable by 1 and decrement the five variable by 1.
//         - If we don't have a $10 bill, decrement the five variable by 3.
// 3. If the five variable is less than 0 or the ten variable is less than 0, return false.
// 4. If we can provide change to all customers, return true.


// @lc code=start
class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        
        int five = 0;
        int ten = 0;
        
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                five--;
            } else {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            
            if (five < 0 || ten < 0) {
                return false;
            }
        }
        
        return true;
    }
}
// @lc code=end

