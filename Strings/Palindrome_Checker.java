public class Palindrome_Checker {
    public static void main(String[] args) {
        String input = "racecar";

        // Method 1: Using a StringBuilder to reverse the string
        boolean isPalindrome1 = isPalindromeUsingStringBuilder(input);
        System.out.println("Method 1 (StringBuilder): " + isPalindrome1);

        // Method 2: Using a char array to reverse the string
        boolean isPalindrome2 = isPalindromeUsingCharArray(input);
        System.out.println("Method 2 (Char Array): " + isPalindrome2);

        // Method 3: Using a loop to compare characters
        boolean isPalindrome3 = isPalindromeUsingLoop(input);
        System.out.println("Method 3 (Loop): " + isPalindrome3);

        // Method 4: Using Java 8 Streams
        boolean isPalindrome4 = isPalindromeUsingStreams(input);
        System.out.println("Method 4 (Streams): " + isPalindrome4);

        // Method 5: Using recursion
        boolean isPalindrome5 = isPalindromeUsingRecursion(input);
        System.out.println("Method 5 (Recursion): " + isPalindrome5);
    }

    // Method 1: Using a StringBuilder to reverse the string
    public static boolean isPalindromeUsingStringBuilder(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

    // Method 2: Using a char array to reverse the string
    public static boolean isPalindromeUsingCharArray(String input) {
        char[] charArray = input.toCharArray();
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method 3: Using a loop to compare characters
    public static boolean isPalindromeUsingLoop(String input) {
        int length = input.length();
        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Method 4: Using Java 8 Streams
    public static boolean isPalindromeUsingStreams(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.chars().boxed()
            .collect(StringBuilder::new, (sb, c) -> sb.append((char) c.intValue()), StringBuilder::append)
            .toString().equals(reversed);
    }

    // Method 5: Using recursion
    public static boolean isPalindromeUsingRecursion(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return isPalindromeUsingRecursion(input.substring(1, input.length() - 1));
        }
        return false;
    }
}
