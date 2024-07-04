
// Write a code to Remove space from a string

// Input: "Hello World"
// Output: "HelloWorld"

// Approach: Iterate over the string and check if the character is not a space then add it to the result string.

public class RemoveSpace {

    public static String removeSpace(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeSpace("Hello World")); // HelloWorld
    }
}
