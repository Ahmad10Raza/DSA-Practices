
// A plaindrome string is a string that reads the same forwards and backwards.
// For example, "abba" is a plaindrome string.
// Given a string, write a function to determine if it is a plaindrome string.

// Input: "abba"
// Output: Yes

// Approach: An efficient approach is to use the two-pointer technique. We will use two pointers,
//  one at the start and one at the end of the string. We will compare the characters at both pointers. 
// If they are equal, we will move the pointers towards each other. If they are not equal, we will return false. 
// If the pointers meet, we will return true.

// Time Complexity: O(n)
// Space Complexity: O(1)

public class PlaindromeString {
    
    public static boolean isPlaindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(isPlaindrome(str) ? "Yes" : "No");
    }
}
