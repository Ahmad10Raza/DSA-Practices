
// Write a code to replace a substring in a string.
// We have given two strings str1 and str2. We have to replace the substring str1 in the string str2.
// 
// Input : str1 = "Geeks", str2 = "GeeksforGeeks"
// Output : "for"
// Explanation : The substring "Geeks" is replaced by "for" in the string "GeeksforGeeks".

// Input : str1 = "is", str2 = "This is a string"
// Output : "This a string"

// Approach: The idea is to use the indexOf() method to find the index of the substring str1 in the string str2.
// If the substring is found, we will replace it with an empty string. 
// If the substring is not found, we will return the original string.

// Time Complexity: O(n)
// Space Complexity: O(1)

public class ReplaceSubstring {
    
    public static String replaceSubstring(String str1, String str2) {
        int index = str2.indexOf(str1);
        if (index != -1) {
            return str2.replace(str1, "");
        }
        return str2;
    }

    public static void main(String[] args) {
        String str1 = "Geeks";
        String str2 = "GeeksforGeeks";
        System.out.println(replaceSubstring(str1, str2));
    }
}
