
// Given a string s, find the length of the longest substring without repeating characters.

// Example
// s: “workattech”
// Result: 6
// Explanation: Longest vaild substring is “workat”.
// s: “mississippi”
// Result: 3
// Explanation: Longest vaild substrings are “mis” and “sip”, both of length 3.

// Approach: Use a HashMap to store the characters of the string and their indices. Use two pointers to keep track of the start and end of the substring. For each character, check if it is present in the HashMap. If it is present, update the start pointer to the next index of the repeating character. Update the maximum length of the substring. Update the HashMap with the character and its index. Return the maximum length of the substring.

// Complexity Analysis
// Time Complexity: O(N), where N is the length of the string.
// Space Complexity: O(N), where N is the length of the string.

// Follow below steps to implement the code:
// 1. Create a hashmap to store the characters of the string and their indices.
// 2. Use two pointers to keep track of the start and end of the substring.
// 3. Iterate through the string and check if the character is present in the hashmap.
// 4. If it is present, update the start pointer to the next index of the repeating character.
// 5. Update the maximum length of the substring.

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            maxLength = Math.max(maxLength, end - start + 1);
            map.put(c, end);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "workattech";
        String s2 = "mississippi";
        System.out.println(lengthOfLongestSubstring(s1)); // Output: 6
        System.out.println(lengthOfLongestSubstring(s2)); // Output: 3
    }

}
