
//  Write a code to check for the longest palindrome in an array.

// We have given an array of strings, we have to find the longest palindrome string from the given array.

// Input : {"a", "b", "c", "ab", "ac", "aa"}
// Output : aa

// Input : {"a", "b", "c", "ab", "ac", "aa", "aaa"}
// Output : aaa

// Approach: Traverse the array and for each string, check if it is a palindrome or not. If it is a palindrome and its length is greater than the previous palindrome string, then update the longest palindrome string.

// Time Complexity: O(n^2)
// Space Complexity: O(1)

public class LongestPalindrome {

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String findLongestPalindrome(String[] arr) {
        String longestPalindrome = "";
        for (int i = 0; i < arr.length; i++) {
            if (isPalindrome(arr[i]) && arr[i].length() > longestPalindrome.length()) {
                longestPalindrome = arr[i];
            }
        }
        return longestPalindrome;
    }

    public static void main(String[] args) {
        String[] arr = { "a", "b", "c", "ab", "ac", "aa", "aaa" };
        System.out.println(findLongestPalindrome(arr));
    }
}
