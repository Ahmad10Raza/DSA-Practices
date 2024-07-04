
// Write a code to Remove all characters from string except alphabets

// Input: "Hello123"
// Output: "Hello"

// Input: "Hello@123"
// Output: "Hello"

// Approach: Iterate over the string and check if the character is alphabet or not. If it is alphabet then add it to the result string.

public class RemoveAllCharExceptAlphabet {

    public static String removeAllCharExceptAlphabet(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeAllCharExceptAlphabet("Hello123")); // Hello
        System.out.println(removeAllCharExceptAlphabet("Hello@123")); // Hello
    }
}
