
// Write code to check if two strings match where one string contains wildcard characters

// Given two strings str1 and str2, write a function that returns true if str1 can be converted to str2 by replacing '*' with any character.

// For Example:
// Input:
// String str1 = "abc*xy";
// String str2 = "abcdfxy";
// Output: True
// Explanation: '*' can be replaced by 'd' to match the strings. 

public class MatchStringWhichContainWildCard {

    public static boolean matchStrings(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (str1.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1) || str1.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (str1.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "abc*xy";
        String str2 = "abcdfxy";
        System.out.println(matchStrings(str1, str2));
    }
}
