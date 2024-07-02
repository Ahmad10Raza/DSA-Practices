
// We have given two strings and we have to check whether they are anagram or not.

// An anagram of a string is another string that contains same characters, only the order of characters can be different.

// Input:
// str1 = "listen"
// str2 = "silent"
// Output: Yes

// Approach: An efficient approach is to use the hashing technique. We will use a hash table to store the frequency of each character of the first string. Then we will iterate over the second string and decrement the frequency of each character of the second string from the hash table. If the frequency of each character is zero, then the strings are anagram otherwise not.

// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramString {
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str2.length(); i++) {
            if (!map.containsKey(str2.charAt(i))) {
                return false;
            }
            map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
            if (map.get(str2.charAt(i)) == 0) {
                map.remove(str2.charAt(i));
            }
        }

        return map.size() == 0;
    }

    // Approach2: Sorting
    // Just sort the strings and compare them.
    // Time Complexity: O(nlogn)
    // Space Complexity: O(1)

    public static boolean isAnagram2(String str1, String str2) {
    String s1 = str1.replaceAll("[\\s]", "");
    String s2 = str2.replaceAll("[\\s]", "");
    boolean status = true;

    if (s1.length() != s2.length())
      status = false;
    else {
      char[] a1 = s1.toLowerCase().toCharArray();
      char[] a2 = s2.toLowerCase().toCharArray();
      Arrays.sort(a1);
      Arrays.sort(a2);
      status = Arrays.equals(a1, a2);
    }
    return status;
  }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println(isAnagram(str1, str2));
        System.out.println(isAnagram2(str1, str2));
    }
}