
// Category	Difficulty	Likes	Dislikes
// algorithms	Medium (33.80%)	29075	1764
// Tags
// Companies
// Given a string s, return the longest palindromic substring in s.

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"

// Constraints:

// 1 <= s.length <= 1000
// s consist of only digits and English letters.

// Approach: Using Two pointer approach
// Time complexity: O(n^2)
// Space complexity: O(1)

// We will use two pointers, low and high
// We will iterate through the string and check for the longest palindrome substring
// We will check for the palindrome substring with even length and odd length

// Follow the steps mentioned below to implement the idea:

// Use two pointers, low and hi, for the left and right end of the current     palindromic substring being found. 
// Then checks if the characters at str[low] and str[hi] are the same. 
//     If they are, it expands the substring to the left and right by decrementing     low and incrementing hi. 
//     It continues this process until the characters at str[low] and str[hi] are  unequal or until the indices are in bounds.
// If the length of the current palindromic substring becomes greater than the     maximum length, it updates the maximum length.

class Solution {
    public String longestPalindrome(String s) {

        // if string length is 0
        if (s.length() == 0)
            return "";

        // if string length is 1
        if (s.length() == 1)
            return s;

        // if string length is more than 2
        int maxLength = 0;
        int start = 0;
        int low, high;

        for (int i = 0; i < s.length(); i++) {

            // for even length palindrome
            low = i;
            high = i + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                low--;
                high++;
            }

            // for odd length palindrome
            low = i;
            high = i;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                low--;
                high++;
            }
        }

        return s.substring(start, start + maxLength);
    }

    public boolean isPlaindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    public String LPS(String s) {
        int n = s.length();
        int max = 0, start = 0, end = 0;

        for (int i = n; i >= 1; i--) {
            for (int j = 0; j <= n - i; j++) {
                if (isPlaindrome(s, j, j + i - 1) == true) {
                    max = j - i + 1;
                    start = j;
                    end = j;
                    break;

                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "babad";
        String s2 = "cbbd";
        System.out.println(sol.longestPalindrome(s1)); // Output: "bab"
        System.out.println(sol.longestPalindrome(s2)); // Output: "bb"
    }
}
