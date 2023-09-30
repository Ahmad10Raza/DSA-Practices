public class Reverse_String {
    public static void main(String[] args) {
        String input = "Hello, World!";
        
        // Method 1: Using a StringBuilder
        String reversedString1 = reverseWithStringBuilder(input);
        System.out.println("Method 1 (StringBuilder): " + reversedString1);
        
        // Method 2: Using a char array
        String reversedString2 = reverseWithCharArray(input);
        System.out.println("Method 2 (Char Array): " + reversedString2);
        
        // Method 3: Using recursion
        String reversedString3 = reverseWithRecursion(input);
        System.out.println("Method 3 (Recursion): " + reversedString3);
    }
    
    // Method 1: Using a StringBuilder
    public static String reverseWithStringBuilder(String input) {
        return new StringBuilder(input).reverse().toString();
    }
    
    // Method 2: Using a char array
    public static String reverseWithCharArray(String input) {
        char[] charArray = input.toCharArray();
        int left = 0;
        int right = input.length() - 1;
        
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        
        return new String(charArray);
    }
    
    // Method 3: Using recursion
    public static String reverseWithRecursion(String input) {
        if (input.isEmpty()) {
            return input;
        }
        return reverseWithRecursion(input.substring(1)) + input.charAt(0);
    }
}
