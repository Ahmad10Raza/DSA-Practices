/*
 * @lc app=leetcode id=551 lang=java
 *
 * [551] Student Attendance Record I
 */

//  Student Attendance Record I
// Category	Difficulty	Likes	Dislikes
// algorithms	Easy (48.73%)	761	49
// Tags
// Companies
// You are given a string s representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:

// 'A': Absent.
// 'L': Late.
// 'P': Present.
// The student is eligible for an attendance award if they meet both of the following criteria:

// The student was absent ('A') for strictly fewer than 2 days total.
// The student was never late ('L') for 3 or more consecutive days.
// Return true if the student is eligible for an attendance award, or false otherwise.

 

// Example 1:

// Input: s = "PPALLP"
// Output: true
// Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.
// Example 2:

// Input: s = "PPALLL"
// Output: false
// Explanation: The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.
 

// Constraints:

// 1 <= s.length <= 1000
// s[i] is either 'A', 'L', or 'P'.
// Submissions | Solution

// Aproach 1: Using Regular Expression
// Intuition

// We can use regular expression to match the given string s against the required pattern. The regular expression we will use is ^.*(A.*A|LLL).*$.

// Here, ^ and $ are the start and end of the string anchors, and . matches any character. The pattern A.*A matches any string that has two A's, and LLL matches any string that has three consecutive L's.

// Thus, the regular expression ^.*(A.*A|LLL).*$ matches any string that has two A's or three consecutive L's. If the given string s matches this pattern, the student is not eligible for the attendance award, and we return false. Otherwise, we return true.

// Algorithm

// We can use the Pattern and Matcher classes in Java to match the given string s against the required pattern. We first compile the regular expression ^.*(A.*A|LLL).*$ into a Pattern object. Then, we create a Matcher object by calling the matcher method on the Pattern object, passing the given string s as an argument. Finally, we return the negation of the matches method on the Matcher object, which returns true if the given string s matches the required pattern, and false otherwise.


// @lc code=start
class Solution551 {
    public boolean checkRecord(String s) {
        
        return !s.matches("^.*(A.*A|LLL).*$");
    }
}
// @lc code=end

