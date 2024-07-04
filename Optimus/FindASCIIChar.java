
// Write a code to find Find the ASCII value of a character

// Input: A
// Output: 65

// Input: a
// Output: 97

// Approach: To find the ASCII value of a character, we can use the char data type in Java. The char data type is a 16-bit unsigned integer that represents a Unicode character. We can convert a character to its ASCII value by casting the character to an integer.

public class FindASCIIChar {

    public static int findASCIIValue(char ch) {
        // Convert character to ASCII value
        return (int) ch;
    }

    public static void main(String[] args) {
        char ch1 = 'A';
        char ch2 = 'a';

        System.out.println(findASCIIValue(ch1)); // 65
        System.out.println(findASCIIValue(ch2)); // 97
    }
}
