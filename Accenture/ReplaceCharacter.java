
// Problem Statement

// You are given a function,

// Void *ReplaceCharacter(Char str[], int n, char ch1, char ch2);

// The function accepts a string  ‘ str’ of length n and two characters ‘ch1’ and ‘ch2’ as its arguments . Implement the function to modify and return the string ‘ str’ in such a way that all occurrences of ‘ch1’ in original string are replaced by ‘ch2’ and all occurrences of ‘ch2’  in original string are replaced by ‘ch1’.

// Assumption: String Contains only lower-case alphabetical letters.

// Note:

// Return null if string is null.
// If both characters are not present in string or both of them are same , then return the string unchanged.
// Example:

// Input:
// Str: apples
// ch1:a
// ch2:p
// Output:
// paales
// Explanation:

// ‘A’ in original string is replaced with ‘p’ and ‘p’ in original string is replaced with ‘a’, thus output is paales.

// Approach: We will take the input of a string str of length n and two characters ch1 and ch2. We are required to modify and return the string str in such a way that all occurrences of ch1 in the original string are replaced by ch2 and all occurrences of ch2 in the original string are replaced by ch1. We will iterate through the string and replace the characters as required. Finally, we will return the modified string.

// Follow the below steps to implement the code:
// 1. Take the input of a string str of length n and two characters ch1 and ch2.
// 2. Check if the string is null. If it is null, return null.
// 3. Check if both characters are not present in the string or both of them are the same. If it is true, return the string unchanged.  
// 4. Iterate through the string.
// 5. Replace all occurrences of ch1 with ch2 and all occurrences of ch2 with ch1.
// 6. Return the modified string.

public class ReplaceCharacter {

    public static void main(String[] args) {
        char[] str = "apples".toCharArray();
        char ch1 = 'a';
        char ch2 = 'p';
        System.out.println(ReplaceChar(str, str.length, ch1, ch2));
    }

    public static char[] ReplaceChar(char[] str, int n, char ch1, char ch2) {
        if (str == null) {
            return null;
        }
        if (str.length == 0 || ch1 == ch2) {
            return str;
        }
        for (int i = 0; i < n; i++) {
            if (str[i] == ch1) {
                str[i] = ch2;
            } else if (str[i] == ch2) {
                str[i] = ch1;
            }
        }
        return str;
    }
}
