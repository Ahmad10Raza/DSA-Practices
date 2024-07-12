
// Write a program for LCS (Longest Common Subsequence) problem.

// Input: str1 = "abcde", str2 = "ace"
// Output: 3
// Explanation: The longest common subsequence is "ace" and its length is 3.

// Approach: The idea is to use dynamic programming to solve this problem. We will create a 2D array dp[][] where dp[i][j] will store the length of the longest common subsequence of str1[0…i-1] and str2[0…j-1]. We will fill the dp[][] array using the below recursive formula:

// If str1[i-1] == str2[j-1], then dp[i][j] = 1 + dp[i-1][j-1]
// Otherwise, dp[i][j] = max(dp[i-1][j], dp[i][j-1])
// Finally, the length of the longest common subsequence will be stored in dp[m][n] where m and n are the lengths of the strings str1 and str2 respectively.

// Time Complexity: O(m*n)
// Space Complexity: O(m*n)

public class LCS {

    public static int longestCommonSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp[][] array using the below recursive formula
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If str1[i-1] == str2[j-1], then dp[i][j] = 1 + dp[i-1][j-1]
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Otherwise, dp[i][j] = max(dp[i-1][j], dp[i][j-1])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the longest common subsequence will be stored in dp[m][n]
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        System.out.println(longestCommonSubsequence(str1, str2));
    }
}