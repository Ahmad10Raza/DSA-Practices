public class Check_Strings_is_Palindrome {
    public static boolean palindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1))
                return false;
        }
        return true;
    }

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        // Remove spaces and convert to lowercase for case-insensitive comparison
        str = str.replaceAll("\\s", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }

        return true; // It's a palindrome
    }




// recursive function to check if a string is palindrome
// Function to check if a string is a palindrome using recursion
    public static boolean isPalindrome_rec(String str) {
        // Remove spaces and convert to lowercase for case-insensitive comparison
        str = str.replaceAll("\\s", "").toLowerCase();
        return isPalindromeRecursive(str, 0, str.length() - 1);
    }

    // Recursive helper function to check if a string is a palindrome
    private static boolean isPalindromeRecursive(String str, int left, int right) {
        if (left >= right) {
            return true; // Base case: When the entire string is checked
        }

        if (str.charAt(left) != str.charAt(right)) {
            return false; // Characters at the current positions don't match
        }

        // Recursively check the remaining substring
        return isPalindromeRecursive(str, left + 1, right - 1);
    }


    public static void main(String[] args) {
        String str = "madam";
        System.out.println(palindrome(str));
        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome_rec(str));
    }
}