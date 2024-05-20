import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StringDS {
    private char[] chars;
    
    public StringDS(String str) {
        chars = str.toCharArray();
    }
    
    public int length() {
        return chars.length;
    }
    
    public char charAt(int index) {
        if (index < 0 || index >= chars.length) {
            throw new IndexOutOfBoundsException();
        }
        return chars[index];
    }
    
    public StringDS substring(int beginIndex, int endIndex) {
        if (beginIndex < 0 || endIndex > chars.length || beginIndex > endIndex) {
            throw new IndexOutOfBoundsException();
        }
        char[] subChars = new char[endIndex - beginIndex];
        System.arraycopy(chars, beginIndex, subChars, 0, endIndex - beginIndex);
        return new StringDS(new String(subChars));
    }
    
    public boolean equals(StringDS other) {
        if (other == null || chars.length != other.length()) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != other.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public String toString() {
        return new String(chars);
    }


    // Function to reverse a string

    // A string is given as input, we need to reverse the string
    // and return the reversed string

    // Example:
    // Input: "hello"
    // Output: "olleh"

    // Approach1: Using StringBuilder

    public String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    // Approach2: Using StringBuffer

    public String reverseString2(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }

    // Approach3: Using char array
    // Time complexity: O(n)
    // Space complexity: O(n)

    // We will convert the string to char array
    // Then we will swap the characters from start and end  
    // till we reach the middle of the array

    public String reverseString3(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }

    // Approach4: Using Recursion
    // Time complexity: O(n)
    // Space complexity: O(n)

    // We will use recursion to reverse the string
    // We will keep the first character as it is and reverse the rest of the string
    // Then we will append the first character at the end of the reversed string

    public String reverseString4(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return reverseString4(str.substring(1)) + str.charAt(0);
    }

    // Approach5: Using Iterative
    // Time complexity: O(n)
    // Space complexity: O(n)

    //  Iterate the string from end to start and append the characters to a new string

    public  String reverseIteratively(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }


    // Function to check if a string is palindrome
    // A string is said to be palindrome if the reverse of the string is the same as the string. 
    // For example, “abba” is a palindrome because the reverse of “abba” will be equal 
    // to “abba” so both of these strings are equal and are said to be a palindrome, but “abbc” is not a palindrome.
    
    // Approach: Two pointer approach
    // Time complexity: O(n)
    // Space complexity: O(1)
//     Algorithm 1 :
// Initialize 2 variables, l from the start and h from the end of the given string.
// Now, we will compare the characters at index l and h with each other
// If the characters are not equal, the string is not palindrome.
// If the characters are equal, we will increment l and decrement h.
// Steps 2,3 and 4 will be repeated till ( l < h ) or we find unequal characters.
// If we reach the condition ( l < h ), it means all the corresponding characters are equal and the string is palindrome.

        public boolean isPalindrome(String str) {
            int l = 0;
            int h = str.length() - 1;
            while (l < h) {
                if (str.charAt(l) != str.charAt(h)) {
                    return false;
                }
                l++;
                h--;
            }
            return true;
        }

        // Approach2: Using Recursion
        // Time complexity: O(n)
        // Space complexity: O(n)

        // We will use recursion to check if the string is palindrome
        // We will keep the first and last character as it is and check if the rest of the string is palindrome
        // If the rest of the string is palindrome, we will return true else false

        public boolean isPalindrome2(String str) {
            if (str == null || str.length() == 0) {
                return true;
            }
            if (str.charAt(0) != str.charAt(str.length() - 1)) {
                return false;
            }
            return isPalindrome2(str.substring(1, str.length() - 1));
        }


        // Function to Find Duplicate characters in a string
        // Given a string, we need to find the duplicate characters in the string
        // and return the duplicate characters

        // Input: "hello"
        // Output: "l"

        // Approach: Using HashSet
        // Time complexity: O(n)
        // Space complexity: O(n)

        // We will use a HashSet to store the characters of the string
        // If we find a character that is already present in the HashSet, we will add it to the result
        // If the character is not present in the HashSet, we will add it to the HashSet

        public String findDuplicateCharacters(String str) {
            HashSet<Character> set = new HashSet<>();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (set.contains(ch)) {
                    result.append(ch);
                } else {
                    set.add(ch);
                }
            }
            return result.toString();
        }


        public void printDups(String str)
        {
          Map<Character, Integer> count = new HashMap<>();
          for (int i = 0; i < str.length(); i++) {
            if(count.containsKey(str.charAt(i)))
              count.put(str.charAt(i) , count.get(str.charAt(i))+1); 
            else count.put(str.charAt(i),1);
            //increase the count of characters by 1 
          }
      
          for (Map.Entry<Character,Integer> mapElement : count.entrySet()) {   //iterating through the unordered map 
            if (mapElement.getValue() > 1)   //if the count of characters is greater than 1 then duplicate found
              System.out.println(mapElement.getKey() + ", count = " + mapElement.getValue());
          }
        }
      
        // Approach2: Using Sorting
        // Time complexity: O(nlogn)
        // Space complexity: O(1)

        // Steps to implement the above approach:

        // Sort the given string.
        // Loop through the sorted string to find the duplicates.
        // If the next character is the same as the current character then we keep on counting the occurrence of that char.
        // If the count is greater than one then we print the character and its count.

        public void printDups2(String str)
        {
          char[] arr = str.toCharArray();
          Arrays.sort(arr);
          int count = 1;
          for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1 && arr[i] == arr[i + 1]) {
              count++;
            } else {
              if (count > 1) {
                System.out.println(arr[i] + ", count = " + count);
              }
              count = 1;
            }
          }
        }


        // Function to check whether one string is a rotation of another string
        // Given a string s1 and a string s2, write a function to check whether s2 is a rotation of s1. 

        // Examples: 

        // Input: S1 = ABCD, S2 = CDAB
        // Output: Strings are rotations of each other

        // Input: S1 = ABCD, S2 = ACBD
        // Output: Strings are not rotations of each other

        // Approach: Using Concatenation
        // Time complexity: O(n)
        // Space complexity: O(n)

        // We will concatenate the first string with itself
        // Then we will check if the second string is a substring of the concatenated string
        // If the second string is a substring of the concatenated string, then the strings are rotations of each other

        public boolean isRotation(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            return (s1 + s1).contains(s2);
        }

    // Driver program to test above function
    public static void main(String []args) {
        
        // Testing the Reverse String function
        // StringDS str = new StringDS("hello");
        // System.out.println(str.reverseString("hello"));
        // System.out.println(str.reverseString2("hello"));
        // System.out.println(str.reverseString3("hello"));
        // System.out.println(str.reverseString4("hello"));
        // System.out.println(str.reverseIteratively("hello"));

        // Testing the Palindrome function
        // StringDS str = new StringDS("");
        // System.out.println(str.isPalindrome("abba"));
        // System.out.println(str.isPalindrome("abbc"));


        // Testing the Find Duplicate Characters function
        // StringDS str = new StringDS("");
        // str.printDups("hello");
        // str.printDups2("hello");
        // String result = str.findDuplicateCharacters("hello");
        // System.out.println(result);

        // Testing the Rotation function
        StringDS str = new StringDS("");
        System.out.println(str.isRotation("ABCD", "CDAB"));
        System.out.println(str.isRotation("ABCD", "ACBD"));

        


        
    }
}
