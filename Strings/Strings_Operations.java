public class Strings_Operations {
    public static void main(String[] args) {
        // Declare and initialize strings
        String str1 = "Hello, ";
        String str2 = "World!";
        
        // Concatenation
        String greeting = str1 + str2;
        System.out.println("Concatenation: " + greeting);
        
        // Length
        int length = greeting.length();
        System.out.println("Length: " + length);
        
        // Character access
        char firstChar = greeting.charAt(0);
        char lastChar = greeting.charAt(length - 1);
        System.out.println("First Character: " + firstChar);
        System.out.println("Last Character: " + lastChar);
        
        // String comparison
        String str3 = "Hello, World!";
        boolean isEqual = greeting.equals(str3);
        boolean isEqualIgnoreCase = greeting.equalsIgnoreCase(str3);
        System.out.println("Equality: " + isEqual);
        System.out.println("Case-Insensitive Equality: " + isEqualIgnoreCase);
        
        // Substring
        String sub = greeting.substring(0, 5); // Extract "Hello"
        System.out.println("Substring: " + sub);
        
        // Uppercase and lowercase
        String upperCaseGreeting = greeting.toUpperCase();
        String lowerCaseGreeting = greeting.toLowerCase();
        System.out.println("Uppercase: " + upperCaseGreeting);
        System.out.println("Lowercase: " + lowerCaseGreeting);
        
        // Replace
        String replacedGreeting = greeting.replace("World", "Java");
        System.out.println("Replace: " + replacedGreeting);
        
        // Trim
        String spacedText = "   Trim me   ";
        String trimmedText = spacedText.trim();
        System.out.println("Trimmed Text: '" + trimmedText + "'");
    }
}


// Output
// Concatenation: Hello, World!
// Length: 13
// First Character: H
// Last Character: !
// Equality: true
// Case-Insensitive Equality: true
// Substring: Hello
// Uppercase: HELLO, WORLD!
// Lowercase: hello, world!
// Replace: Hello, Java!
// Trimmed Text: 'Trim me'
