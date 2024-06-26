import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.Iterator;
import java.util.Iterator;

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

        // Approach2: Using Concatenation itself
        // Time complexity: O(n)
        // Space complexity: O(n)

        // We will concatenate the first string with itself
        // Then we will check if the second string is a substring of the concatenated string
        // If the second string is a substring of the concatenated string, then the strings are rotations of each other

        public boolean isRotation2(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            return (s1.length() == s2.length()) && ((s1 + s1).indexOf(s2) != -1);
        }



        // Function to check whether a string is a valid shuffle of two strings or not

        // Given two strings str1 and str2, and a third-string shuffle, determine if shuffle is a valid shuffle 
        // of str1 and str2, where a valid shuffle contains all characters from str1 and str2 occurring
        // the same number of times, regardless of order. Print “YES” if valid, and “NO” otherwise.

        // Examples: 

        // Input: str1 = BA, str2 = XY, shuffle = XYAB 
        // Output: YES

        // Input: str1 = BA, str2 = XY, shuffle = XUMB 
        // Output: NO

        // Input: str1 = ABC, str2 = ZYS, shuffle = YBAZSC 
        // Output:YES


        // Approach: Using HashMap
        // Time complexity: O(n)
        // Space complexity: O(n)
        
        // The simplest approach that comes to mind is when we observe the given inputs carefully, 
        // we see that we only need to check if the frequency of each character in the 
        // string shuffle is exactly as it is in both the str1 and str2 and also the length 
        // should be of the length of str1 + length of str2. So, we can use a hashmap here.

        // We will use a HashMap to store the characters of the two strings
        // We will iterate through the shuffle string and check if the character is present in the HashMap
        // If the character is present in the HashMap, we will decrement the count of the character
        // If the character is not present in the HashMap, we will return false
        // If the count of the character is less than 0, we will return false
        // If the count of the characters in the HashMap is not 0, we will return false
        // If all the characters are present in the HashMap and the count of the characters is 0, we will return true

        public boolean isValidShuffle(String str1, String str2, String shuffle) {
            if (str1.length() + str2.length() != shuffle.length()) {
                return false;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str1.toCharArray()) { // storing the characters of str1 and str2 in the map
                map.put(ch, map.getOrDefault(ch, 0) + 1); // incrementing the count of the characters by 1
            }
            for (char ch : str2.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (char ch : shuffle.toCharArray()) {
                if (!map.containsKey(ch)) {
                    return false;
                }
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) < 0) {
                    return false;
                }
            }
            for (int count : map.values()) {
                if (count != 0) {
                    return false;
                }
            }
            return true;
        }

        public boolean validShuffle(String str1, String str2, String shuffle)
    {
        int n1 = str1.length();
        int n2 = str2.length();
        int n = shuffle.length();

        if (n != n1 + n2) {
            return false;
        }

        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            freq.put(str1.charAt(i),freq.getOrDefault(str1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < n2; i++) {
            freq.put(str2.charAt(i),freq.getOrDefault(str2.charAt(i), 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (freq.containsKey(shuffle.charAt(i))) {
                freq.put(shuffle.charAt(i),freq.get(shuffle.charAt(i)) - 1);
            }
            else {
                return false;
            }
        }

        // Checks whether all the elements's frequency in
        // hashmap becomes 0
        for (Map.Entry<Character, Integer> entry :
             freq.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }


    // Approach2: Using Two Pointers
    // Time complexity: O(n)
    // Space complexity: O(1)

    public boolean isValidShuffle2(String str1, String str2, String shuffle) {
        if (str1.length() + str2.length() != shuffle.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < shuffle.length()) {
            if (i < str1.length() && str1.charAt(i) == shuffle.charAt(k)) {
                i++;
            } else if (j < str2.length() && str2.charAt(j) == shuffle.charAt(k)) {
                j++;
            } else {
                return false;
            }
            k++;
        }
        return i == str1.length() && j == str2.length();
    }


    // Function to Count and Say problem

    // Find the n’th term in Look-and-say (Or Count and Say) Sequence. The look-and-say sequence is the sequence of the below integers:
    // 1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211, …
    // How is the above sequence generated?
    // n’th term is generated by reading (n-1)’th term.
    // The first term is "1"
    // Second term is "11", generated by reading first term as "One 1"
    // (There is one 1 in previous term)
    // Third term is "21", generated by reading second term as "Two 1"
    // Fourth term is "1211", generated by reading third term as "One 2 One 1"
    // and so on

    // Approach: Using Recursion
    // Time complexity: O(n)
    // Space complexity: O(n)

    // We will use recursion to find the n’th term in the Look-and-say sequence
    // We will keep the first term as "1"
    // Then we will find the (n-1)’th term in the Look-and-say sequence
    // Then we will read the (n-1)’th term and generate the n’th term

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        int count = 1;
        int num = s.charAt(0) - '0';
        StringBuilder temp = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - '0' == num) {
                count++;
            } else {
                temp.append(count);
                temp.append(num);
                num = s.charAt(i) - '0';
                count = 1;
            }
        }
        temp.append(count);
        temp.append(num);
        return temp.toString();
    }

    // Function to find the longest palindrome substring in a string

    // Given a string, we need to find the longest palindrome substring in the string

    // Example:
    // Input: "babad"
    // Output: "bab" or "aba"

    // Approach: Using Two pointer approach
    // Time complexity: O(n^2)
    // Space complexity: O(1)

    // We will use two pointers, low and high
    // We will iterate through the string and check for the longest palindrome substring
    // We will check for the palindrome substring with even length and odd length

    // Follow the steps mentioned below to implement the idea:

    // Use two pointers, low and hi, for the left and right end of the current     palindromic substring being found. 
    // Then checks if the characters at str[low] and str[hi] are the same. 
    //     If they are, it expands the substring to the left and right by decrementing     low and incrementing hi. 
    //     It continues this process until the characters at str[low] and str[hi] are  unequal or until the indices are in bounds.
    // If the length of the current palindromic substring becomes greater than the     maximum length, it updates the maximum length.

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public  String palindrome(String s){
        int start=0,end=0;
        for(int i=1;i<s.length();i++){
            int low=i-1,high=i;
     //even length
            while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){ //check if the characters are equal or not 
                if(high-low+1>end){ //if the length of the substring is greater than the previous substring then update the start and end
                    start=low; //update the start
                    end=high-low+1; //update the end
                }
                low--; //decrement the low
                high++; //increment the high
            }
    
            // odd length
            low=i-1;
            high=i+1;
            while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){ //check if the characters are equal or not 
                if(high-low+1>end){ //if the length of the substring is greater than the previous substring then update the start and end
                    start=low;
                    end=high-low+1;
                }
                low--;
                high++;
            }
        }
        return s.substring(start,start+end); //substring(start,end) end is exclusive so we add 1 to end 
    
        }


        // Function to find the longest recurring subsequence in a string

        // Given a string, we need to find the longest recurring subsequence in the string

        // Example:
        // Input: "AABEBCDD"
        // Output: 3
        // Explanation: The longest recurring subsequence is "ABD" with length 3 

        // Approach: Using Recursion
        // Time complexity: O(m*n)
        // Space complexity: O(m*n)

        // We will use recursion to find the longest recurring subsequence in the string
        // We will keep two pointers, i and j
        // If the characters at index i and j are the same and i is not equal to j, we will return 1 + the longest recurring subsequence
        // If the characters at index i and j are not the same, we will return the maximum of the two subsequences

        public int longestRecurringSubsequence(String s, int i, int j) {
            if (i == 0 || j == 0) {
                return 0;
            }
            if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                return 1 + longestRecurringSubsequence(s, i - 1, j - 1);
            } else {
                return Math.max(longestRecurringSubsequence(s, i - 1, j), longestRecurringSubsequence(s, i, j - 1));
            }
        }


        // Function to print all subsequences of a string

        // Given a string, we need to print all the subsequences of the string

        // Example:
        // Input: "abc"
        // Output: "a", "b", "c", "ab", "ac", "bc", "abc"

        // Approach: Using Recursion
        // Time complexity: O(2^n)
        // Space complexity: O(n)

        // We will use recursion to print all the subsequences of the string
        // We will keep two pointers, i and j
        // If the characters at index i and j are the same and i is not equal to j, we will return 1 + the longest recurring subsequence
        // If the characters at index i and j are not the same, we will return the maximum of the two subsequences
        // First we include the character at index i and then we exclude the character at index i

        public void printSubsequences(String str) {
            printSubsequencesRecursive(str, "");
        }

        private void printSubsequencesRecursive(String remaining, String current) {
            if (remaining.isEmpty()) {
                System.out.println(current);
                return;
            }
            // include the character at index 0
            printSubsequencesRecursive(remaining.substring(1), current + remaining.charAt(0));
            // exclude the character at index 0
            printSubsequencesRecursive(remaining.substring(1), current);
        }


        // Function to print all permutations of a string

        // Given a string, we need to print all the permutations of the string

        // Example:
        // Input: "abc"
        // Output: "abc", "acb", "bac", "bca", "cab", "cba"

        // Approach: Using Recursion
        // Time complexity: O(n!)
        // Space complexity: O(n)

        // We will use recursion to print all the permutations of the string
        // We will keep two pointers, i and j
        // If the characters at index i and j are the same and i is not equal to j, we will return 1 + the longest recurring subsequence
        // If the characters at index i and j are not the same, we will return the maximum of the two subsequences
        // First we include the character at index i and then we exclude the character at index i

        public void printPermutations(String str) {
            printPermutationsRecursive(str, "");
        }

        private void printPermutationsRecursive(String remaining, String current) {
            if (remaining.isEmpty()) {
                System.out.println(current);
                return;
            }
            for (int i = 0; i < remaining.length(); i++) {
                printPermutationsRecursive(remaining.substring(0, i) + remaining.substring(i + 1), current + remaining.charAt(i));
            }
        }

        // Approach2: Using Backtracking
        // Time complexity: O(n^2)
        // Space complexity: O(R-L)

        // Follow the given steps to solve the problem:

        // Create a function permute() with parameters as input string, starting index of the      string,ending index of the string
        // Call this function with values input string, 0, size of string – 1
        // In this function, if the value of  L and R is the same then print the same string
            // Else run a for loop from L to R and swap the current element in the for loop with the       inputString[L]
            // Then again call this same function by increasing the value of L by 1
            // After that again swap the previously swapped values to initiate backtracking

        public void permute(String str,int index){
            if(index==str.length()){
                System.out.println(str);
                return;
            }
            // iterate over the string
            for(int i=index;i<str.length();i++){ 
                str = swap(str,index,i); // swap the characters at index and i
                permute(str,index+1); // call the function recursively
                str = swap(str,index,i); // backtrack to the original string
            }
        
        }

        public String swap(String str,int i,int j){
            char[] arr = str.toCharArray(); // convert the string to char array
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            return String.valueOf(arr); // convert the char array to string
        }


        // Function to split the string into two parts such that both parts have equal number of 0s and 1s

        // Given a string, we need to split the string into two parts such that both parts have an equal number of 0s and 1s

        // Example:
        // Input: "010011"
        // Output: 2 ("01", "0011") 
        // Input: str = “0100110101” 
        // Output: 4 
        // The required substrings are “01”, “0011”, “01” and “01”.
        // Input: str = “0111100010” 
        // Output: 3 

        // Input: str = “0000000000” 
        // Output: -1

        // Approach: Using Count of 0s and 1s
        // Time complexity: O(n)
        // Space complexity: O(1)

        // We will keep two variables, count0 and count1
        // We will iterate through the string and count the number of 0s and 1s
        // If the count of 0s and 1s is not equal, we will return -1
        // If the count of 0s and 1s is equal, we will return the count of 0s or 1s

        public int splitString(String str) {
            int count0 = 0;
            int count1 = 0;
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    count0++;
                } else {
                    count1++;
                }

                if(count0 == count1){
                    count++;
                }
            }
            if (count0 != count1) {
                return -1;
            }
            return count;
        }


        // Function to word break problem

//         Given a valid sentence without any spaces between the words and a dictionary of valid English words, find all possible ways to break the sentence into individual dictionary words.

// Example:

// Consider the following dictionary 
// { i, like, sam, sung, samsung, mobile, ice, 
//   and, cream, icecream, man, go, mango}

// Input: "ilikesamsungmobile"
// Output: i like sam sung mobile
//         i like samsung mobile

// Input: "ilikeicecreamandmango"
// Output: i like ice cream and man go
//         i like ice cream and mango
//         i like icecream and man go
//         i like icecream and mango


        // Approach: Using Recursion
        // Time complexity: O(2^n)
        // Space complexity: O(n)

        // We start scanning the sentence from the left. As we find a 
        // valid word, we need to check whether the rest of the sentence 
        // can make valid words or not. Because in some situations the first 
        // found word from the left side can leave a remaining portion that is 
        // not further separable. So, in that case, we should come back and 
        // leave the currently found word and keep on searching for the next 
        // word. And this process is recursive because to find out whether 
        // the right portion is separable or not, we need the same logic. 
        // So we will use recursion and backtracking to solve this problem. 
        // To keep track of the found words we will use a stack. 
        // Whenever the right portion of the string does not make valid words, 
        // we pop the top string from the stack and continue finding
       
        // Prints all possible word breaks of given string
    public  void wordBreak(int n, List<String> dict, String s)
    {
    String ans="";
    wordBreakUtil(n, s, dict, ans);
    }
 
    public void wordBreakUtil(int n, String s, List<String> dict, String ans)
     {
      for(int i = 1; i <= n; i++)
     {
 
      // Extract substring from 0 to i in prefix
      String prefix=s.substring(0, i);
 
      // If dictionary contains this prefix, then
      // we check for remaining string. Otherwise
      // we ignore this prefix (there is no else for
      // this if) and try next
      if(dict.contains(prefix))
      {
        // If no more elements are there, print it
        if(i == n)
        {
 
          // Add this element to previous prefix
          ans += prefix;
          System.out.println(ans);
          return;
        }
        wordBreakUtil(n - i, s.substring(i,n), dict, ans+prefix+" ");
      }
    }
  }

    // public boolean wordBreak(String str){

    //     int size = str.length();
    //     if (size == 0) {
    //         return true;
    //     }

    //     for(int i=1;i<=size;i++){
    //         if(dict.contains(str.substring(0,i)) && wordBreak(str.substring(i,size))){
    //             return true;
    //         }
    //     }

    //     return false;
    // }


    // Function for Edit Distance problem

    // Given two strings str1 and str2, we need to find the minimum number of operations required to convert str1 to str2.

    // Operations allowed are:
    // Insert a character
    // Delete a character
    // Replace a character

    // Example:
    // Input: str1 = "sunday", str2 = "saturday"
    // Output: 3
    // Explanation: The minimum number of operations required to convert "sunday" to "saturday" is 3
    // We can replace 'n' with 'r', insert 't' at the end, and insert 'a' at the end

    // Approach: Using Recursion
    // Time complexity: O(3^n)
    // Space complexity: O(n)

    // We will use recursion to find the minimum number of operations required to convert str1 to str2
    // We will keep two pointers, i and j
    // If the characters at index i and j are the same, we will return the minimum number of operations required to convert the rest of the strings
    // If the characters at index i and j are not the same, we will return the minimum of the three operations
    // We will insert a character, delete a character, and replace a character
    // Recuurence relation:
    // case1: If the characters at index i and j are the same, we will return the minimum number of operations required to convert the rest of the strings
    // case2: If the characters at index i and j are not the same, we will return the minimum of the three operations
    //EditDistance(str1, str2, i, j) = 1 + min(EditDistance(str1, str2, i, j + 1), EditDistance(str1, str2, i + 1, j), EditDistance(str1, str2, i + 1, j + 1))


    public int editDistance(String str1, String str2, int i, int j) {
        if (i == str1.length()) {
            return str2.length() - j;
        }
        if (j == str2.length()) {
            return str1.length() - i;
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return editDistance(str1, str2, i + 1, j + 1);
        }
        return 1 + Math.min(editDistance(str1, str2, i, j + 1), Math.min(editDistance(str1, str2, i + 1, j), editDistance(str1, str2, i + 1, j + 1)));
    }


    public int editDist(String str1, String str2, int m,
                        int n)
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0)
            return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0)
            return m;

        // If last characters of two strings are same,
        // nothing much to do. Get the count for remaining
        // strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return editDist(str1, str2, m - 1, n - 1);

        // If last characters are not same, consider all
        // three operations on last character of first
        // string, recursively compute minimum cost for all
        // three operations and take minimum of three
        // values.
        return 1 + min(editDist(str1, str2, m, n - 1), // Insert
                  editDist(str1, str2, m - 1, n), // Remove
                  editDist(str1, str2, m - 1, n - 1)) ;// Replace );
    }
        
    int min(int x, int y, int z)
    {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }


    // Function to find next greater number with same set of digits

    // Given a number, we need to find the next greater number with the same set of digits

    // Example:
    // Input: 1234
    // Output: 1243

    // Approach: Using Recursion
    // Time complexity: O(n)
    // Space complexity: O(n)

    // Following are few observations about the next greater number. 
// 
// If all digits sorted in descending order, then output is always “Not Possible”. For example, 4321. 
// If all digits are sorted in ascending order, then we need to swap last two digits. For example, 1234. 
// For other cases, we need to process the number from rightmost side (why? because we need to find the smallest of all greater numbers)
// You can now try developing an algorithm yourself. 
// 
// Following is the algorithm for finding the next greater number. 
// 
// Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller than the previously traversed digit. For example, if the input number is “534976”, we stop at 4 because 4 is smaller than next digit 9. If we do not find such a digit, then output is “Not Possible”.
// Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’. For “534976″, the right side of 4 contains “976”. The smallest digit greater than 4 is 6.
// Swap the above found two digits, we get 536974 in above example.
// Now sort all digits from position next to ‘d’ to the end of number. The number that we get after sorting is the output. For above example, we sort digits in bold 536974. We get “536479” which is the next greater number for input 534976.


    
    public int nextGreaterNumber(int num,int n) {
        char[] digits = String.valueOf(num).toCharArray();
        int i;
        // I) Start from the right most digit and find the first digit that is smaller than the digit next to it.

        for( i = n-1; i>0; i++){
            if(digits[i] > digits[i-1]){
                break;
            }
        }

        // If no such digit is found, then all digits are in descending order means there cannot be a greater number with same set of digits
        if(i == 0){
            return -1;
        }
        else{
            int x = digits[i-1], min = i;
            // II) Find the smallest digit on right side of (i-1)'th digit that is greater than number[i-1]
            for(int j = i+1; j<n; j++){
                if(digits[j] > x && digits[j] < digits[min]){
                    min = j;
                }
            }

            // III) Swap the above found smallest digit with number[i-1]
            swap(digits,i-1,min);

            // IV) Sort the digits after (i-1) in ascending order
            Arrays.sort(digits,i,n);
        }

        return Integer.parseInt(String.valueOf(digits));
    }

    public void swap(char[] digits,int i,int j){
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }


    // Function for balancing the parentheses

    // Given a string with parentheses, we need to balance the parentheses

    // Example:
    // Input: "((()"
    // Output: NO

    // Input: "(()())"
    // Output: YES

    // Approach: Using Stack
    // Time complexity: O(n)
    // Space complexity: O(n)

    // We will use a stack to balance the parentheses
    // We will iterate through the string and push the opening parentheses onto the stack
    // If current bracket is closing then pop from stack and check if they are pair
    // If they are not pair, return false
    // If the stack is not empty, we will return true

    public boolean isBalanced(String str) {
        
        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
                continue;
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')){
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }


    // function to check if brackets are balanced
    public boolean areBracketsBalanced(String expr)
    {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<Character>();
 
        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
 
            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 
        // Check Empty Stack
        return (stack.isEmpty());
    }


    // Function for Robin Karp Algorithm

    // Given a text and a pattern, we need to find the pattern in the text

    // Example:
    // Input: text = "ABABDABACDABABCABAB", pattern = "ABABCABAB"
    // Output: 10

    // Approach: Using Robin Karp Algorithm
    // Time complexity: O(n)
    // Space complexity: O(1)

    // We will use Robin Karp Algorithm to find the pattern in the text
    // We will calculate the hash value of the pattern and the text
    // We will iterate through the text and check if the hash value of the pattern and the text is the same
    // If the hash value of the pattern and the text is the same, we will check if the characters are the same
    // If the characters are the same, we will return the index
    // If the characters are not the same, we will continue the iteration


    public int robinKarp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int p = 0;
        int t = 0;
        int d = 256;
        int q = 101;
        int h = 1;
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }
        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }
        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                int j = 0;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == m) {
                    return i;
                }
            }
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0) {
                    t = t + q;
                }
            }
        }
        return -1;
    }


    public final static int d = 256;
 
    /* pat -> pattern
        txt -> text
        q -> A prime number
    */
    public void search(String pat, String txt, int q)
    {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;
 
        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;
 
        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }
 
        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {
 
            // Check the hash values of current window of
            // text and pattern. If the hash values match
            // then only check for characters one by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
 
                // if p == t and pat[0...M-1] = txt[i, i+1,
                // ...i+M-1]
                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }
 
            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
 
                // We might get negative value of t,
                // converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }
    }


    // Function to convert the sentence to mobile keypad numbers sequence

    // Given a sentence, we need to convert the sentence to mobile keypad numbers sequence

    // Example:
    // Input: "HELLO"
    // Output: 43556

//     Approach: Follow the steps given below to convert a sentence into its equivalent mobile numeric keypad sequence. 

// For each character, store the sequence which should be obtained at its respective position in an array, i.e. for Z, store 9999. For Y, store 999. For K, store 55 and so on.
// For each character, subtract ASCII value of ‘A’ and obtain the position in the array pointed 
// by that character and add the sequence stored in that array to a string.
// If the character is a space, store 0
// Print the overall sequence.
    // Function which computes the sequence
    public String printSequence(String arr[], String input)
    {
        String output = "";
 
        // length of input string
        int n = input.length();
        for (int i = 0; i < n; i++) {
            // Checking for space
            if (input.charAt(i) == ' ')
                output = output + "0";
 
            else {
                // Calculating index for each
                // character
                int position = input.charAt(i) - 'A';
                output = output + arr[position];
            }
        }
 
        // Output sequence
        return output;
    }


    // Function for minimum number of bracket reversals needed to make an expression balanced

    // Given an expression with only ‘}’ and ‘{‘. The expression may not be balanced. We need to find the minimum number of bracket reversals needed to make the expression balanced.

    // Example:
    // Input: "}}{{"
    // Output: 2

    // Approach: Using Stack
    // Time complexity: O(n)
    // Space complexity: O(n)

    // We will use a stack to balance the parentheses
    // We will iterate through the string and push the opening parentheses onto the stack
    // If current bracket is closing then pop from stack and check if they are pair
    // If they are not pair, return false
    // If the stack is not empty, we will return true

    public int countMinReversals(String str) {
        int n = str.length();
        if (n % 2 != 0) {
            return -1;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '}' && !stack.isEmpty()) {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        int m = stack.size();
        int count = 0;
        while (!stack.isEmpty() && stack.peek() == '{') {
            stack.pop();
            count++;
        }
        return (m / 2 + count % 2);
    }

    // Approach2: Using Recursion

    // 1. Check for length of the string, if it is odd then return -1.
    // 2. Initialize two variables left_brace and right_brace to 0.
    // 3. Traverse the string from left to right.
    // 4. If the current character is ‘{‘ then increment left_brace by 1.
    // 5. If the current character is ‘}’ then increment right_brace by 1.
    // 6. If right_brace is greater
    // than left_brace then increment left_brace by 1 and right_brace by 1.
    // 7. If left_brace is greater than right_brace then increment right_brace by 1 and left_brace by 1.
    // 8. Return the minimum of left_brace and right_brace divided by 2 and added to the sum of left_brace and right_brace modulo 2.

    public int countMinReversals2(String str) {
        int n = str.length();
        if (n % 2 != 0) {
            return -1;
        }
        int left_brace = 0, right_brace = 0;
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '{') {
                left_brace++;
            }
            else{
                if(left_brace == 0){
                    right_brace++;
                }
                else{
                    left_brace--;
                }
            }
        }
         
        int ans = (int)(Math.ceil((0.0 + left_brace) / 2) + Math.ceil((0.0 + right_brace) / 2));
        return ans;
    }

    // Function for finding the minimum number of bracket reversals needed to make an expression balanced

    // Given an expression with only ‘}’ and ‘{‘. The expression may not be balanced. We need to find the minimum number of bracket reversals needed to make the expression balanced.

    // Example:
    // Input: "}}{{"
    // Output: 2

    // Approach: Using Stack
    // Time complexity: O(n)

    // We will use a stack to balance the parentheses
    // We will iterate through the string and push the opening parentheses onto the stack
    // If current bracket is closing then pop from stack and check if they are pair
    // If they are not pair, return false
    // If the stack is not empty, we will return true

    public int countMinReversals22(String str) {
        int n = str.length();
        if (n % 2 != 0) {
            return -1;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '}' && !stack.isEmpty()) {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        int m = stack.size();
        int count = 0;
        while (!stack.isEmpty() && stack.peek() == '{') {
            stack.pop();
            count++;
        }
        return (m / 2 + count % 2);
    }


    // Function for count all palindrome subsequence in a given string

    // Given a string, we need to count all the palindromic subsequences in the string

    // Example:
    // Input: "abba"
    // Output: 4
    // Explanation: The palindromic subsequences are "a", "b", "b", "a"

    // Approach: Using Recursion
    // Time complexity: O(2^n)
    // Space complexity: O(n)

    // We will use recursion to count all the palindromic subsequences in the string
    // We will keep two pointers, i and j
    // If the characters at index i and j are the same, we will return 1 + the longest recurring subsequence
    // If the characters at index i and j are not the same, we will return the maximum of the two subsequences
    // First we include the character at index i and then we exclude the character at index i

    public int palindromeCount(String str) {
        return palindromeRecursive(str, 0, str.length() - 1);
    }

    private int palindromeRecursive(String str, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (str.charAt(i) == str.charAt(j)) {
            // If the characters at index i and j are the same, we will return 1 + the longest recurring subsequence
            return 1 + palindromeRecursive(str, i + 1, j) + palindromeRecursive(str, i, j - 1);
        }
        // If the characters at index i and j are not the same, we will return the maximum of the two subsequences
        return palindromeRecursive(str, i + 1, j) + palindromeRecursive(str, i, j - 1) - palindromeRecursive(str, i + 1, j - 1);
    }


    // Function for count of number of given in 2D character array

    // Given a 2D character array, we need to count the number of given words in the 2D character array

    // Example:
    // Input: 2D character array
    // [['G', 'E', 'E', 'K', 'S'],
    // ['F', 'O', 'R', 'G', 'E', 'E', 'K', 'S'],
    // ['A', 'B', 'C', 'D', 'E', 'E', 'K', 'S']]
    // Words: GEEKS, FOR, GEEKS
    // Output: 3

    // Approach: Using Recursion
    // Time complexity: O(n)
    // Space complexity: O(n)

    // We will use recursion to count the number of given words in the 2D character array
    // We will iterate through the 2D character array and check if the current character is the first character of the word
    // If the current character is the first character of the word, we will check if the rest of the characters are the same
    // If the rest of the characters are the same, we will return the count of the word
    // If the rest of the characters are not the same, we will continue the iteration

    public int countWords(char[][] board, String[] words) {
        int count = 0;
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        if (searchWord(board, i, j, word, 0)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    private boolean searchWord(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = searchWord(board, i + 1, j, word, index + 1) || searchWord(board, i - 1, j, word, index + 1)
                || searchWord(board, i, j + 1, word, index + 1) || searchWord(board, i, j - 1, word, index + 1);
        board[i][j] = temp;
        return found;
    }

    // Function for convert a Roman numeral to an Decimal number

    // Given a Roman numeral, we need to convert the Roman numeral to a Decimal number

    // Example:
    // Input: "XIV"
    // Output: 14

    // Approach: Using HashMap
    // Time complexity: O(n)
    // Space complexity: O(1)

    // We will use a hashmap to store the Roman numerals and their corresponding Decimal numbers
    // We will iterate through the Roman numeral and check if the current Roman numeral is less than the next Roman numeral
    // If the current Roman numeral is less than the next Roman numeral, we will subtract the current Roman numeral from the Decimal number
    // If the current Roman numeral is greater than the next Roman numeral, we will add the current Roman numeral to the Decimal number
    // else subtract this value by adding the value of next symbol to the running total.

    public int romanToDecimal(String roman) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int decimal = 0;
        for (int i = 0; i < roman.length(); i++) {
            int current = map.get(roman.charAt(i));
            if (i + 1 < roman.length()) {
                int next = map.get(roman.charAt(i + 1));
                if (current < next) {
                    decimal -= current;
                } else {
                    decimal += current;
                }
            } else {
                decimal += current;
            }
        }
        return decimal;
    }

    // Function for longest common prefix 

    // Given an array of strings, we need to find the longest common prefix among the strings

    // Example:
    // Input: ["flower","flow","flight"]
    // Output: "fl"

    // Approach: Using Recursion
    // Time complexity: O(n)
    // Space complexity: O(n)

    // We will use recursion to find the longest common prefix among the strings
    // We will keep two pointers, i and j
    // If the characters at index i and j are the same, we will return the longest common prefix
    // If the characters at index i and j are not the same, we will return the longest common prefix

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        return longestCommonPrefixRecursive(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefixRecursive(String[] strs, int i, int j) {
        if (i == j) {
            return strs[i];
        }
        int mid = (i + j) / 2;
        String left = longestCommonPrefixRecursive(strs, i, mid);
        String right = longestCommonPrefixRecursive(strs, mid + 1, j);
        return commonPrefix(left, right);
    }

    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    // Approach2: Using Horizontal scanning
    // The Idea is to find unique prefix without sorting the string array. Extract substring by comparing current substring with  the previous substring and update it’s result. For large string it work much faster.
    
    public String longestCommonPrefixLC(String[] strs) {
        // If the input is empty, return an empty string
        if(strs.length == 0) return "";
        // Initialize the prefix as the first string
        String prefix = strs[0];
        // Iterate through the strings
        for(int i = 1; i < strs.length; i++){
            // While the current string does not start with the prefix
            while(strs[i].indexOf(prefix) != 0){
                // Remove the last character from the prefix
                prefix = prefix.substring(0, prefix.length()-1);
                // If the prefix is empty, return an empty string
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }


    
    // Function for number of flips to make binary string alternate

    // Given a binary string, we need to find the minimum number of flips to make the binary string alternate

    // Example:
    // Input: "0001010111"
    // Output: 2
    // Explanation: The minimum number of flips to make the binary string alternate is 2
    // We can flip the 2nd and 4th characters to make the binary string alternate

    // Approach: Using Recursion
    // Time complexity: O(n)
    // Space complexity: O(n)

    // We will use recursion to find the minimum number of flips to make the binary string alternate
    // We will keep two pointers, i and j
    // If the characters at index i and j are the same, we will return the minimum number of flips
    // If the characters at index i and j are not the same, we will return the minimum number of flips

    public int minFlips(String str) {
        return Math.min(minFlipsRecursive(str, '0'), minFlipsRecursive(str, '1'));
    }

    private int minFlipsRecursive(String str, char expected) {
        int flips = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != expected) {
                flips++;
            }
            expected = (expected == '0') ? '1' : '0';
        }
        return flips;
    }

    // Approach2: 
//     We can solve this problem by considering all possible results, As we are supposed to get 
// alternate string, there are only 2 possibilities, alternate string starting with 0 and alternate 
// string starting with 1. We will try both cases and choose the string which will require minimum 
// number of flips as our final answer. 

// // Trying a case requires O(n) time in which we will loop over all characters of given string, 
// if current character is expected character according to alternation then we will do nothing 
// otherwise we will increase flip count by 1. After trying strings starting with 0 and starting with 1, 
// we will choose the string with minimum flip count. 

// // Total time complexity of solution will be O(n) 


public static char flip(char ch)
{
    return (ch == '0') ? '1' : '0';
}
  
//  Utility method to get minimum flips when
//  alternate string starts with expected char
public static int getFlipWithStartingCharcter(String str,
                                char expected)
{
    int flipCount = 0;
    for (int i = 0; i < str.length(); i++)
    {
        //  if current character is not expected,
        // increase flip count
        if (str.charAt(i) != expected)
            flipCount++;
  
        //  flip expected character each time
        expected = flip(expected);
    }
    return flipCount;
}
  
// method return minimum flip to make binary
// string alternate
public static int minFlipToMakeStringAlternate(String str)
{
    //  return minimum of following two
    //  1) flips when alternate string starts with 0
    //  2) flips when alternate string starts with 1
    return Math.min(getFlipWithStartingCharcter(str, '0'),
               getFlipWithStartingCharcter(str, '1'));
}


    // Function for minimum number of swap operations for bracket balancing
    
    // Given a string with parentheses, we need to find the minimum number of swap operations needed to balance the parentheses

    // Example:
    // Input: "[]][]["
    // Output: 2
    // Explanation: The minimum number of swap operations needed to balance the parentheses is 2
    // We can swap the 2nd and 4th characters to balance the parentheses

    // Approach: Using Stack
    // Time complexity: O(n)
    // Space complexity: O(n)

    // We will use a stack to balance the parentheses
    // We will iterate through the string and push the opening parentheses onto the stack
    // If current bracket is closing then pop from stack and check if they are pair
    // If they are not pair, return false
    // If the stack is not empty, we will return true


    public int minSwaps(String str) {
        int n = str.length();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // If the current character is opening bracket, push its index
            if (str.charAt(i) == '[') {
                stack.push(i);
            } else {
                // If the current character is closing bracket and the stack is not empty and the top of the stack is opening bracket, pop from the stack
                if (!stack.isEmpty() && str.charAt(stack.peek()) == '[') {
                    stack.pop();
                } else {
                    // 
                    stack.push(i);
                }
            }
        }
        int count = 0;
        while (!stack.isEmpty()) {
            stack.pop();
            count++;
            stack.pop();
            count++;
        }
        return count;
    }
  

    // Function for longest common subsequence

    // Given two strings, we need to find the longest common subsequence between the two strings

    // Example:
    // Input: "abcde", "ace"
    // Output: 3
    // Explanation: The longest common subsequence between the two strings is "ace"

    // Approach: Using Recursion
    // Time complexity: O(n)
    // Space complexity: O(n)

    // We will use recursion to find the longest common subsequence between the two strings
    // We will keep two pointers, i and j
    // If the characters at index i and j are the same, we will return 1 + the longest common subsequence
    // If the characters at index i and j are not the same, we will return the maximum of the two subsequences
    // First we include the character at index i and then we exclude the character at index i

    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequenceRecursive(text1, text2, text1.length(), text2.length());
    }

    private int longestCommonSubsequenceRecursive(String text1, String text2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            return 1 + longestCommonSubsequenceRecursive(text1, text2, m - 1, n - 1);
        }
        return Math.max(longestCommonSubsequenceRecursive(text1, text2, m - 1, n),
                longestCommonSubsequenceRecursive(text1, text2, m, n - 1));
    }


    // Function for Recursively print all sentences that can be formed from list of word lists

    // Given a list of word lists, we need to print all sentences that can be formed from the list of word lists

    // Example:
    // Input: [["you", "we"], ["have", "are"], ["sleep", "eat", "drink"]]
    // Output: you have sleep
    //         you have eat
    //         you have drink
    //         you are sleep
    //         you are eat
    //         you are drink
    //         we have sleep
    //         we have eat
    //         we have drink
    //         we are sleep
    //         we are eat
    //         we are drink

    // Approach: Using Depth First Traverse
    // Time complexity: O(n^m)
    // Space complexity: O(n)

    // We will use depth first traverse to print all sentences that can be formed from the list of word lists
    // We start from every word of the first list and recursively call for the next list
    // If the current list is the last list, we will print the sentence
    // If the current list is not the last list, we will recursively call for the next list

    public void printSentences(List<List<String>> wordLists) {
        List<String> result = new ArrayList<>();
        printSentencesRecursive(wordLists, 0, result);
    }

    private void printSentencesRecursive(List<List<String>> wordLists, int index, List<String> result) {
        // If the current list is the last list, we will print the sentence
        if (index == wordLists.size()) {
            System.out.println(String.join(" ", result));
            return;
        }
        // We start from every word of the first list and recursively call for the next list
        for (String word : wordLists.get(index)) { // for each word in the current list of words 
            // If the current list is not the last list, we will recursively call for the next list
            result.add(word);
            printSentencesRecursive(wordLists, index + 1, result);
            // remove the last word from the result list to backtrack and try the next word
            result.remove(result.size() - 1);
        }
    }


    // Function for Check if two given strings are isomorphic to each other

    // Given two strings, we need to check if the two strings are isomorphic to each other

    // Example:
    // Input: "egg", "add"
    // Output: true
    // Explanation: The two strings are isomorphic to each other
    // We can map 'e' to 'a' and 'g' to 'd'

    // Input: "foo", "bar"
    // Output: false
    // Explanation: The two strings are not isomorphic to each other
    // We cannot map 'f' to 'b' and 'o' to 'a'

    // Approach: Using HashMap
    // Time complexity: O(n)
    // Space complexity: O(1)

    // Follow the steps to solve the problem:

    // Create a hashmap of (char, char) to store the mapping of str1 and str2.
    // Now traverse on the string and check whether the current character is present in the Hashmap.
    //     If it is present then the character that is mapped is there at the ith index or not.
    //     Else check if str2[i] is not present in the key then add the new mapping.
    //     Else return false.

    public boolean isIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if (map.containsKey(ch1)) {
                if (map.get(ch1) != ch2) {
                    return false;
                }
            } else {
                if (set.contains(ch2)) {
                    return false;
                }
                map.put(ch1, ch2);
                set.add(ch2);
            }
        }
        return true;
    }


    public boolean areIsomorphic(String str1, String str2)
    {

        HashMap<Character, Character> charCount = new HashMap<>();
        char c = 'a';
        for (int i = 0; i < str1.length(); i++) {
            if (charCount.containsKey(str1.charAt(i))) {
                c = charCount.get(str1.charAt(i));
                if (c != str2.charAt(i))
                    return false;
            }
            else if (!charCount.containsValue(
                         str2.charAt(i))) {
                charCount.put(str1.charAt(i),
                              str2.charAt(i));
            }
            else {
                return false;
            }
        }
        return true;
    }


    // Function for Transform One String to Another using Minimum Number of Given Operation

//     Given two strings A and B, the task is to convert A to B if possible. The only operation allowed is to put any character from A and insert it at front. Find if it’s possible to convert the string. If yes, then output minimum no. of operations required for transformation.

// Examples: 

// Input:  A = "ABD", B = "BAD"
// Output: 1
// Explanation: Pick B and insert it at front.
// Input:  A = "EACBD", B = "EABCD"
// Output: 3
// Explanation: Pick B and insert at front, EACBD => BEACD
//              Pick A and insert at front, BEACD => ABECD
//              Pick E and insert at front, ABECD => EABCD


    // Approach: Using HashMap
    // Time complexity: O(n)
    // Space complexity: O(n)

    // Follow the steps to solve the problem:

    // We declare a HashMap<Character,Integer> to store frequency map.
    // We store the character of string 1 in the map and then while traversing string 2 ,we erase the characters and if the map is empty at the end that means the characters in both the string are same and we can continue,else we return -1.
    // We make a variable res and point two pointer i and j to the last of both strings and start traversing from back.
    // As soon as see a ith character that doesn’t match with jth character ,we start increasing res by 1 until again both the characters are same.
    // Atlast we return res.

    public int minOps(String A, String B)
    {
        if (A.length() != B.length())
            return -1;
        int n = A.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(A.charAt(i), mp.getOrDefault(A.charAt(i), 0) + 1);
            mp.put(B.charAt(i), mp.getOrDefault(B.charAt(i), 0) - 1);
        }
        for (int val : mp.values()) {
            if (val != 0)
                return -1;
        }
        int res = 0;
        for (int i = n - 1, j = n - 1; i >= 0;) {
            while (i >= 0 && A.charAt(i) != B.charAt(j)) {
                i--;
                res++;
            }
            if (i >= 0) {
                i--;
                j--;
            }
        }
        return res;
    }


    //  Function to find Number of customers who could not get a computer

//     Write a function “runCustomerSimulation” that takes following two inputs 

// An integer ‘n’: total number of computers in a cafe and a string: 
// A sequence of uppercase letters ‘seq’: Letters in the sequence occur in pairs. The first occurrence indicates the arrival of a customer; the second indicates the departure of that same customer. 
// A customer will be serviced if there is an unoccupied computer. No letter will occur more than two times. 
// Customers who leave without using a computer always depart before customers who are currently using the computers. There are at most 20 computers per cafe.

// For each set of input the function should output a number telling how many customers, if any walked away without using a computer. Return 0 if all the customers were able to use a computer.
// runCustomerSimulation (2, “ABBAJJKZKZ”) should return 0
// runCustomerSimulation (3, “GACCBDDBAGEE”) should return 1 as ‘D’ was not able to get any computer
// runCustomerSimulation (3, “GACCBGDDBAEE”) should return 0
// runCustomerSimulation (1, “ABCBCA”) should return 2 as ‘B’ and ‘C’ were not able to get any computer.
// runCustomerSimulation(1, “ABCBCADEED”) should return 3 as ‘B’, ‘C’ and ‘E’ were not able to get any computer.
    

    // Algorithm:
//     Below are simple steps to find number of customers who could not get any computer.

// Initialize result as 0.
// Traverse the given sequence. While traversing, keep track of occupied computers (this can be done by keeping track of characters which have appeared only once and a computer was available when they appeared). At any point, if count of occupied computers is equal to ‘n’, and there is a new customer, increment result by 1.
// The important thing is to keep track of existing customers in cafe in a way that can indicate whether the customer has got a computer or not. Note that in sequence “ABCBCADEED”, customer ‘B’ did not get a seat, but still in cafe as a new customer ‘C’ is next in sequence.
    
static int MAX_CHAR = 26; 
 
// n is number of computers in cafe. 
// 'seq' is given sequence of customer entry, exit events 
public int runCustomerSimulation(int n, char []seq) 
{ 
    // seen[i] = 0, indicates that customer 'i' is not in cafe 
    // seen[1] = 1, indicates that customer 'i' is in cafe but 
    //         computer is not assigned yet. 
    // seen[2] = 2, indicates that customer 'i' is in cafe and 
    //         has occupied a computer. 
    char []seen = new char[MAX_CHAR]; 
 
    // Initialize result which is number of customers who could 
    // not get any computer. 
    int res = 0; 
 
    int occupied = 0; // To keep track of occupied computers 
 
    // Traverse the input sequence 
    for (int i=0; i< seq.length; i++) 
    { 
        // Find index of current character in seen[0...25] 
        int ind = seq[i] - 'A'; 
 
        // If First occurrence of 'seq[i]' 
        if (seen[ind] == 0) 
        { 
            // set the current character as seen 
            seen[ind] = 1; 
 
            // If number of occupied computers is less than 
            // n, then assign a computer to new customer 
            if (occupied < n) 
            { 
                occupied++; 
 
                // Set the current character as occupying a computer 
                seen[ind] = 2; 
            } 
 
            // Else this customer cannot get a computer, 
            // increment result 
            else
                res++; 
        } 
 
        // If this is second occurrence of 'seq[i]' 
        else
        { 
             
        // Decrement occupied only if this customer 
        // was using a computer 
        if (seen[ind] == 2) 
            occupied--; 
        seen[ind] = 0; 
        } 
    } 
    return res; 
} 


    // Function for String matching where one string contains wildcard characters

//     Given two strings where first string may contain wild card characters and second string is a normal string. Write a function that returns true if the two strings match. The following are allowed wild card characters in first string. 

// * --> Matches with 0 or more instances of any character or set of characters.
// ? --> Matches with any one character.
// For example, “g*ks” matches with “geeks” match. And string “ge?ks*” matches with “geeksforgeeks” (note ‘*’ at the end of first string). But “g*k” doesn’t match with “gee” as character ‘k’ is not present in second string. 


    // Approach: Using Recursion
    // Time complexity: O(n)
    // Space complexity: O(n)

    // Follow the steps to solve the problem:

    // If the first string is empty, return true if the second string is also empty, else return false.
    // If the first string is not empty and the second string is empty, return false.
    // If the first character of the first string is ‘*’, then return true if any of the following is true:
    //     Ignore the ‘*’ and match the remaining characters of the first string with the second string.
    //     Ignore the first character of the first string and match the remaining characters of the first string with the second string.
    // If the first character of the first string is ‘?’ or the first character of the first string is equal to the first character of the second string, then return true if the remaining characters of the first string match the remaining characters of the second string.
    // If the first character of the first string is not equal to the first character of the second string, return false.
    public boolean match(String first, String second)  
    { 
      
        // If we reach at the end of both strings,  
        // we are done 
        if (first.length() == 0 && second.length() == 0) 
            return true; 
        
      // Make sure to eliminate consecutive '*' 
        if (first.length() > 1 && first.charAt(0) == '*') { 
          int i=0; 
            while (i+1<first.length() && first.charAt(i+1) == '*') 
              i++; 
          first=first.substring(i); 
        } 
      
        // Make sure that the characters after '*'  
        // are present in second string.  
        // This function assumes that the first 
        // string will not contain two consecutive '*' 
        if (first.length() > 1 && first.charAt(0) == '*' &&  second.length() == 0) 
            return false; 
      
        // If the first string contains '?',  
        // or current characters of both strings match 
        if ((first.length() > 1 && first.charAt(0) == '?') ||  
            (first.length() != 0 && second.length() != 0 &&  
             first.charAt(0) == second.charAt(0))) 
            return match(first.substring(1),  
                         second.substring(1)); 
      
        // If there is *, then there are two possibilities 
        // a) We consider current character of second string 
        // b) We ignore current character of second string. 
        if (first.length() > 0 && first.charAt(0) == '*') 
            return match(first.substring(1), second) ||  
                   match(first, second.substring(1)); 
        return false; 
    } 
      
    // A function to run test cases 
    public void testWildCard(String first, String second) 
    { 
        if (match(first, second)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
    } 

    // Function for Recursively remove all adjacent duplicates

    //     Given a string s, recursively remove adjacent duplicate characters from the string s. The output string should not have any adjacent duplicates.

    // Example:
    // Input: "geeksforgeek"
    // Output: "gksforgk"

    // Approach: Using Recursion
    // Time complexity: O(n)
    // Space complexity: O(n)

    // Follow the steps to solve the problem:

    // If the string is empty, return the empty string.
    // If the string has only one character, return the string.
    // If the first character of the string is the same as the second character of the string, then remove the first character and recursively call the function on the remaining string.
    // If the first character of the string is not the same as the second character of the string, then append the first character to the result and recursively call the function on the remaining string.

    public String removeDuplicates(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        if (s.charAt(0) == s.charAt(1)) {
            int i = 1;
            while (i < s.length() && s.charAt(0) == s.charAt(i)) {
                i++;
            }
            return removeDuplicates(s.substring(i));
        }
        return s.charAt(0) + removeDuplicates(s.substring(1));
    }


    // Function for Find the smallest window in a string containing all characters of another string

    // Given two strings, we need to find the smallest window in the first string that contains all characters of the second string

    // Example:
    // Input: "this is a test string", "tist"
    // Output: "t stri"
    // Explanation: The smallest window in the first string that contains all characters of the second string is "t stri"

    // Approach: Using Hashing and Two Pointers
    // Time complexity: O(n)
    // Space complexity: O(n)

    // Follow the steps to solve the problem:

    // Create a hashmap to store the frequency of characters in the second string.
    // Create a hashmap to store the frequency of characters in the window.
    // Initialize the start and end pointers to 0.
    // Initialize the minLen to the maximum value.
    // Initialize the count to 0.
    // Iterate through the first string using the end pointer.
    //     If the character at the end pointer is present in the second string, increment the frequency of the character in the window.
    //     If the frequency of the character in the window is less than or equal to the frequency of the character in the second string, increment the count.
    //     If the count is equal to the length of the second string, increment the start pointer until the count is less than the length of the second string.
    //     If the length of the window is less than the minimum length, update the minimum length and the start and end pointers.
    // Return the substring from the start to the end pointers.

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int minStart = 0;
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch) <= map.get(ch)) {
                    count++;
                }
            }
            while (count == t.length()) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }
                char startCh = s.charAt(start);
                if (map.containsKey(startCh)) {
                    window.put(startCh, window.get(startCh) - 1);
                    if (window.get(startCh) < map.get(startCh)) {
                        count--;
                    }
                }
                start++;
            }
            end++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    
    // Function for Given a sequence of words, print all anagrams together

    // Given an array of words, we need to print all anagrams together

    // Example:
    // Input: ["cat", "dog", "tac", "god", "act"]
    // Output: ["cat", "tac", "act", "dog", "god"]
    
    // Approach: Using HashMap
    // Time complexity: O(n)
    // Space complexity: O(n)

    // Follow the steps to solve the problem:

    // Create a hashmap to store the sorted word as the key and the list of words as the value.
    // Iterate through the array of words.
    //     Sort the word.
    //     If the sorted word is present in the hashmap, add the word to the list of words.
    //     If the sorted word is not present in the hashmap, add the sorted word as the key and the list of words as the value.
    // Iterate through the hashmap and print the list of words.

    public void printAnagrams(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if (map.containsKey(sortedWord)) {
                map.get(sortedWord).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(sortedWord, list);
            }
        }
        for (List<String> list : map.values()) {
            System.out.println(list);
        }
    }

    // Function for Minimum characters to be added at front to make string palindrome

    // Given a string, we need to find the minimum number of characters to be added at the front of the string to make the string a palindrome

    // Example:
    // Input: "AACECAAAA"
    // Output: 2
    // Explanation: The minimum number of characters to be added at the front of the string to make the string a palindrome is 2
    // We can add "AA" at the front of the string to make the string a palindrome

    // Approach: Using Recursion
    // Time complexity: O(n)
    // Space complexity: O(n)

    // Follow the steps to solve the problem:

    // If the string is empty, return 0.
    // If the string is a palindrome, return 0.
    // If the first character of the string is equal to the last character of the string, return the minimum characters to be added at the front of the substring.
    // If the first character of the string is not equal to the last character of the string, return 1 + the minimum of the two characters to be added at the front of the substring.


    public int minCharsToBeAdded(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (isPalindrome(s)) {
            return 0;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return minCharsToBeAdded(s.substring(1, s.length() - 1));
        }
        return 1 + Math.min(minCharsToBeAdded(s.substring(1)), minCharsToBeAdded(s.substring(0, s.length() - 1)));
    }

    // Approach2: lps array of KMP algorithm
    // Time complexity: O(n)
    // Space complexity: O(n)

    // Follow the steps to solve the problem:

    // Create a string s1 by concatenating the string s with a special character and the reverse of the string s.
    // Create an lps array using the KMP algorithm on the string s1.
    // Return the length of the string s minus the last element of the lps array.

    public int minCharsToBeAdded2(String s) {
        String s1 = s + "$" + new StringBuilder(s).reverse().toString();
        int[] lps = new int[s1.length()];
        int len = 0;
        int i = 1;
        while (i < s1.length()) {
            if (s1.charAt(i) == s1.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return s.length() - lps[s1.length() - 1];
    }


    // Function for Rearrange characters in a string such that no two adjacent are same

    // Given a string, we need to rearrange the characters in the string such that no two adjacent characters are the same

    // Example:
    // Input: "aaabc"
    // Output: "abaca"

    // Approach: Using HashMap and PriorityQueue
    // Time complexity: O(n)
    // Space complexity: O(n)

    // Follow the steps to solve the problem:

    // Create a hashmap to store the frequency of characters in the string.
    // Create a priority queue to store the characters in the string based on their frequency.
    // Iterate through the hashmap and add the characters to the priority queue based on their frequency.
    // Create a string builder to store the rearranged string.
    // Iterate through the priority queue and append the characters to the string builder.
    // If the priority queue is not empty, add the characters back to the priority queue.
    // If the priority queue is empty, break the loop.
    // Return the rearranged string.

    public String rearrangeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            List<Character> list = new ArrayList<>();
            int k = 2;
            while (k-- > 0 && !pq.isEmpty()) {
                char ch = pq.poll();
                sb.append(ch);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) > 0) {
                    list.add(ch);
                }
            }
            for (char ch : list) {
                pq.offer(ch);
            }
            if (pq.size() == 1 && map.get(pq.peek()) > 1) {
                return "";
            }
        }
        return sb.toString();
    }

    // Approach2: From GeekforGeeks

//     To solve the problem using this approach follow the below idea:

// Fill all the even positions of the result string first, with the highest frequency character. If there are still some even positions remaining, fill them first. Once even positions are done, then fill the odd positions. This way, it can be ensured that no two adjacent characters are the same. 

// Follow the given steps to solve the problem:

// Calculate the frequencies of every character in the input string
// If a character with a maximum frequency has a frequency greater than (n + 1) / 2, then return an empty string, as it is not possible to construct a string
// Now fill the even index positions with the maximum frequency character, if some even positions are remaining then first fill them with remaining characters
// Then fill odd index positions with the remaining characters
// Return the constructed string

    public char getMaxCountChar(int[] count)
    {
        int max = 0;
        char ch = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                ch = (char)((int)'a' + i);
            }
        }
        return ch;
    }
 
    public String rearrangeString2(String S)
    {
 
        int N = S.length();
        if (N == 0)
            return "";
 
        int[] count = new int[26];
        for (int i = 0; i < 26; i++) {
            count[i] = 0;
        }
        for (char ch : S.toCharArray()) {
            count[(int)ch - (int)'a']++;
        }
 
        char ch_max = getMaxCountChar(count);
        int maxCount = count[(int)ch_max - (int)'a'];
 
        // check if the result is possible or not
        if (maxCount > (N + 1) / 2)
            return "";
 
        String res = "";
        for (int i = 0; i < N; i++) {
            res += ' ';
        }
 
        int ind = 0;
        // filling the most frequently occurring char in the
        // even indices
        while (maxCount > 0) {
            res = res.substring(0, ind) + ch_max
                  + res.substring(ind + 1);
            ind = ind + 2;
            maxCount--;
        }
        count[(int)ch_max - (int)'a'] = 0;
 
        // now filling the other Chars, first filling the
        // even positions and then the odd positions
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                ind = (ind >= N) ? 1 : ind;
                res = res.substring(0, ind)
                      + (char)((int)'a' + i)
                      + res.substring(ind + 1);
                ind += 2;
                count[i]--;
            }
        }
        return res;
    }


    // Function for Write a program tofind the smallest window that contains all characters of string itself.

    // Given a string, we need to find the smallest window in the string that contains all characters of the string itself

    // Example:
    // Input: "aabcbcdbca"
    // Output: "dbca"

    // Approach: Using HashMap and Two Pointers
    // Time complexity: O(n)
    // Space complexity: O(n)

    // Follow the steps to solve the problem:

    // Create a hashmap to store the frequency of characters in the string.
    // Create a hashmap to store the frequency of characters in the window.
    // Initialize the start and end pointers to 0.
    // Initialize the minLen to the maximum value.
    // Initialize the count to 0.
    // Iterate through the string using the end pointer.
    //     If the character at the end pointer is present in the hashmap, increment the frequency of the character in the window.
    //     If the frequency of the character in the window is less than or equal to the frequency of the character in the hashmap, increment the count.
    //     If the count is equal to the length of the hashmap, increment the start pointer until the count is less than the length of the hashmap.
    //     If the length of the window is less than the minimum length, update the minimum length and the start and end pointers.
    // Return the substring from the start to the end pointers.


    public String smallestWindow(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int minStart = 0;
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch) <= map.get(ch)) {
                    count++;
                }
            }
            while (count == map.size()) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }
                char startCh = s.charAt(start);
                if (map.containsKey(startCh)) {
                    window.put(startCh, window.get(startCh) - 1);
                    if (window.get(startCh) < map.get(startCh)) {
                        count--;
                    }
                }
                start++;
            }
            end++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
        
    }


    // Function for Program to generate all possible valid IP addresses from given  string.

    // Given a string containing only digits, we need to generate all possible valid IP addresses from the given string.

    // Example:
    // Input: "25525511135"
    // Output: ["255.255.11.135", "255.255.111.35"]

    // Approach: Using Recursion
    // Time complexity: O(n)
    // Space complexity: O(n)

    // Follow the steps to solve the problem:

    // Create a list to store the valid IP addresses.
    // Call the helper function to generate all possible valid IP addresses.
    // Return the list of valid IP addresses.

    public List<String> generateIPAddresses(String s) {
        List<String> result = new ArrayList<>();
        generateIPAddresses(s, 0, 0, "", result);
        return result;
    }

    // Helper function to generate all possible valid IP addresses

    // Follow the steps to solve the problem:

    // If the index is equal to 4 and the start is equal to the length of the string, add the IP address to the result.
    // If the index is equal to 4 and the start is not equal to the length of the string, return.
    // Iterate through the string from the start to the start + 3.
    //     If the substring from the start to the i is valid, call the helper function recursively with the index + 1, i + 1, the current IP address, and the result.
    //     If the substring from the start to the i is not valid, break the loop.

    public void generateIPAddresses(String s, int index, int start, String ipAddress, List<String> result) {
        if (index == 4 && start == s.length()) {
            result.add(ipAddress);
            return;
        }
        if (index == 4) {
            return;
        }
        for (int i = start; i < start + 3 && i < s.length(); i++) {
            String part = s.substring(start, i + 1);
            if (isValid(part)) {
                generateIPAddresses(s, index + 1, i + 1, ipAddress + part + (index == 3 ? "" : "."), result);
            } else {
                break;
            }
        }
    }

    // Function to check if the given string is valid

    // Follow the steps to solve the problem:

    // If the string is empty or the length of the string is greater than 3, return false.
    // If the length of the string is greater than 1 and the first character of the string is '0', return false.
    // If the integer value of the string is greater than 255, return false.
    // Return true.

    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() > 3) {
            return false;
        }
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        if (Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }

    public void solveIP(String s, int i, int j, int level, String temp,ArrayList<String>res)
{
    if (i == (j + 1) && level == 5) {
        res.add(temp.substring(1));
    }
 
    // Digits of a number ranging 0-255 can lie only between
    // 0-3
    for (int k = i; k < i + 3 && k <= j; k++) {
        String ad = s.substring(i, k + 1);
 
        // Return if string starting with '0' or it is
        // greater than 255.
        if ((s.charAt(i) == '0'&& ad.length()>1 ) || Integer.valueOf(ad) > 255)
            return;
 
        // Recursively call for another level.
        solveIP(s, k + 1, j, level + 1, temp + '.' + ad, res);
    }
}

        // Function for Find the first repeated word in string.

        //     Given a string, we need to find the first repeated word in the string.

        // Example:
        // Input: "Ravi had been saying that he had been there"
        // Output: "had"

        // Approach: Using HashSet
        // Time complexity: O(n)
        // Space complexity: O(n)

        // Follow the steps to solve the problem:

        // Create a hashset to store the words in the string.
        // Split the string into words.
        // Iterate through the words.
        //     If the word is present in the hashset, return the word.
        //     If the word is not present in the hashset, add the word to the hashset.
        // Return an empty string.

        public String firstRepeatedWord(String s) {
            Set<String> set = new HashSet<>();
            String[] words = s.split(" ");
            for (String word : words) {
                if (set.contains(word)) {
                    return word;
                }
                set.add(word);
            }
            return "";
        }


        // Function for Boyer Moore Algorithm for Pattern Searching.

        // Given a string and pattern we need to find the pattern in the string using Boyer Moore Algorithm

        // Example:
        // Input: "ABAAABCD", "ABC"
        // Output: 4
        // Explanation: The pattern "ABC" is found in the string "ABAAABCD" at index 4

        // Approach: Using Boyer Moore Algorithm
        // Time complexity: O(n)
        // Space complexity: O(1)

        // Follow the steps to solve the problem:

        // Create a function to find the pattern in the string using the Boyer Moore Algorithm.
        // Create a function to calculate the bad character heuristic.
        // Create a function to calculate the good suffix heuristic.
        // Call the function to find the pattern in the string using the Boyer Moore Algorithm.
        // Return the index of the pattern in the string.

        public int boyerMoore(String s, String pattern) {
            int n = s.length();
            int m = pattern.length();
            int[] badChar = badCharacterHeuristic(pattern);
            int[] goodSuffix = goodSuffixHeuristic(pattern);
            int shift = 0;
            while (shift <= n - m) {
                int j = m - 1;
                while (j >= 0 && pattern.charAt(j) == s.charAt(shift + j)) {
                    j--;
                }
                if (j < 0) {
                    return shift;
                }
                shift += Math.max(j - badChar[s.charAt(shift + j)], goodSuffix[j]);
            }
            return -1;
        }

        // Function to calculate the bad character heuristic

        // Follow the steps to solve the problem:

        // Create an array to store the bad character heuristic.
        // Iterate through the pattern and calculate the bad character heuristic.
        // Return the bad character heuristic.

        public int[] badCharacterHeuristic(String pattern) {
            int m = pattern.length();
            int[] badChar = new int[256];
            Arrays.fill(badChar, -1);
            for (int i = 0; i < m; i++) {
                badChar[pattern.charAt(i)] = i;
            }
            return badChar;
        }

        // Function to calculate the good suffix heuristic

        // Follow the steps to solve the problem:

        // Create an array to store the good suffix heuristic.
        // Create an array to store the suffixes of the pattern.
        // Create an array to store the longest prefix suffix.
        // Calculate the suffixes of the pattern.
        // Calculate the longest prefix suffix.
        // Calculate the good suffix heuristic.
        // Return the good suffix heuristic.

        public int[] goodSuffixHeuristic(String pattern) {
            int m = pattern.length();
            int[] goodSuffix = new int[m];
            int[] suffix = new int[m];
            Arrays.fill(suffix, 0);
            int f = 0;
            int g = m - 1;
            for (int i = m - 2; i >= 0; i--) {
                if (i > g && suffix[i + m - 1 - f] < i - g) {
                    suffix[i] = suffix[i + m - 1 - f];
                } else {
                    if (i < g) {
                        g = i;
                    }
                    f = i;
                    while (g >= 0 && pattern.charAt(g) == pattern.charAt(g + m - 1 - f)) {
                        g--;
                    }
                    suffix[i] = f - g;
                }
            }
            Arrays.fill(goodSuffix, m);
            for (int i = m - 1; i >= 0; i--) {
                if (suffix[i] == i + 1) {
                    for (int j = 0; j < m - 1 - i; j++) {
                        if (goodSuffix[j] == m) {
                            goodSuffix[j] = m - 1 - i;
                        }
                    }
                }
            }
            for (int i = 0; i < m - 1; i++) {
                goodSuffix[m - 1 - suffix[i]] = m - 1 - i;
            }
            return goodSuffix;
        }


        // Function for KMP Algorithm for Pattern Searching.

        // Given a string and pattern we need to find the pattern in the string using KMP Algorithm

        // Example:
        // Input: "ABAAABCD", "ABC"
        // Output: 4
        // Explanation: The pattern "ABC" is found in the string "ABAAABCD" at index 4

        // Approach: Using KMP Algorithm
        // Time complexity: O(n)
        // Space complexity: O(n)

        // Follow the steps to solve the problem:

        // Create a function to find the pattern in the string using the KMP Algorithm.
        // Create an array to store the longest prefix suffix.
        // Calculate the longest prefix suffix.
        // Iterate through the string and pattern to find the pattern in the string using the KMP Algorithm.
        // Return the index of the pattern in the string.

        public int kmp(String s, String pattern) {
            int n = s.length();
            int m = pattern.length();
            int[] lps = new int[m];
            calculateLPS(pattern, lps);
            int i = 0;
            int j = 0;
            while (i < n) {
                if (s.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;
                }
                if (j == m) {
                    return i - j;
                }
                if (i < n && s.charAt(i) != pattern.charAt(j)) {
                    if (j != 0) {
                        j = lps[j - 1];
                    } else {
                        i++;
                    }
                }
            }
            return -1;
        }

        // Function to calculate the longest prefix suffix

        // Follow the steps to solve the problem:

        // Initialize the length to 0.
        // Iterate through the pattern.
        //     If the characters at the start and end pointers are equal, increment the length and store the length in the lps array.
        //     If the characters at the start and end pointers are not equal, check if the length is greater than 0 and update the length.
        // Return the lps array.

        public void calculateLPS(String pattern, int[] lps) {
            int length = 0;
            int i = 1;
            while (i < pattern.length()) {
                if (pattern.charAt(i) == pattern.charAt(length)) {
                    length++;
                    lps[i] = length;
                    i++;
                } else {
                    if (length != 0) {
                        length = lps[length - 1];
                    } else {
                        lps[i] = length;
                        i++;
                    }
                }
            }
        }



        // Function for Robin karp Algorithms for Pattern Searching.

        // Given a string and pattern we need to find the pattern in the string using Robin Karp Algorithm  

        // Example:
        // Input: "ABAAABCD", "ABC"
        // Output: 4
        // Explanation: The pattern "ABC" is found in the string "ABAAABCD" at index 4

        // Approach: Using Robin Karp Algorithm
        // Time complexity: O(n)
        // Space complexity: O(1)

        // Follow the steps to solve the problem:

        // Create a function to find the pattern in the string using the Robin Karp Algorithm.
        // Calculate the hash value of the pattern and the first window of the string.
        // Iterate through the string and calculate the hash value of the next window of the string.
        // If the hash value of the pattern is equal to the hash value of the window of the string, check if the pattern is present in the window of the string.
        // Return the index of the pattern in the string.


        public int robinKarp2(String s, String pattern) {
            int n = s.length();
            int m = pattern.length();
            int prime = 101;
            int d = 256;
            int h = 1;
            int p = 0;
            int t = 0;
            for (int i = 0; i < m - 1; i++) {
                h = (h * d) % prime;
            }
            for (int i = 0; i < m; i++) {
                p = (d * p + pattern.charAt(i)) % prime;
                t = (d * t + s.charAt(i)) % prime;
            }
            for (int i = 0; i <= n - m; i++) {
                if (p == t) {
                    int j = 0;
                    for (j = 0; j < m; j++) {
                        if (s.charAt(i + j) != pattern.charAt(j)) {
                            break;
                        }
                    }
                    if (j == m) {
                        return i;
                    }
                }
                if (i < n - m) {
                    t = (d * (t - s.charAt(i) * h) + s.charAt(i + m)) % prime;
                    if (t < 0) {
                        t = t + prime;
                    }
                }
            }
            return -1;
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
        // StringDS str = new StringDS("");
        // System.out.println(str.isRotation("ABCD", "CDAB"));
        // System.out.println(str.isRotation("ABCD", "ACBD"));

        // Testing the Valid Shuffle function
        // StringDS str = new StringDS("");
        // System.out.println(str.isValidShuffle("BA", "XY", "XYAB"));
        // System.out.println(str.isValidShuffle("BA", "XY", "XUMB"));
        // System.out.println(str.isValidShuffle("ABC", "ZYS", "YBAZSC"));


        // Testing the Count and Say function
        // StringDS str = new StringDS("");
        // System.out.println(str.countAndSay(5));

        // Testing the Longest Palindrome function
        // StringDS str = new StringDS("");
        // System.out.println(str.palindrome("babad"));

        // Testing the Longest Recurring Subsequence function
        // StringDS str = new StringDS("");
        // System.out.println(str.longestRecurringSubsequence("AABEBCDD", 8, 8));

        // Testing the Print All Subsequences function
        // StringDS str = new StringDS("");
        // str.printSubsequences("abc");


        // Testing the Print All Permutations function
        // StringDS str = new StringDS("");
        // str.printPermutations("abc");
        // str.permute("ABC",0);


        // Testing the Split String function
        // StringDS str = new StringDS("");
        // System.out.println(str.splitString("010011"));
        // System.out.println(str.splitString("0100110101"));

        // Testing the Word Break function
        // StringDS str = new StringDS("");
        // List<String> dict = new ArrayList<>();
        // dict.add("i");
        // dict.add("like");
        // dict.add("sam");
        // dict.add("sung");
        // dict.add("samsung");
        // dict.add("mobile");
        // dict.add("ice");
        // dict.add("and");
        // dict.add("cream");
        // dict.add("icecream");
        
        // str.wordBreak(13, dict, "ilikesamsungmobile");
        

        // Testing the Edit Distance function
        // StringDS str = new StringDS("");
        // System.out.println(str.editDistance("sunday", "saturday", 0, 0));


        // Testing the Next Greater Number function
        // StringDS str = new StringDS("");
        // System.out.println(str.nextGreaterNumber(1234, 4));

        // Testing the Balancing Parentheses function
        // StringDS str = new StringDS("");
        // System.out.println(str.isBalanced("((()"));
        // System.out.println(str.isBalanced("(()())"));

        // Testing the Robin Karp Algorithm function
        // StringDS str = new StringDS("");
        // System.out.println(str.robinKarp("ABABDABACDABABCABAB", "ABABCABAB"));

        // Testing the Robin Karp Algorithm function
        // StringDS str = new StringDS("");
        // str.search("ABABCABAB", "ABABDABACDABABCABAB", 101);

        // Testing the Mobile keypad sequence  function
        // StringDS str = new StringDS("");
        // String arr[]
        //     = { "2", "22", "222",
        //         "3", "33", "333",
        //         "4", "44", "444",
        //         "5", "55", "555",
        //         "6", "66", "666",
        //         "7", "77", "777", "7777",
        //         "8", "88", "888",
        //         "9", "99", "999", "9999" };

        // String input = "HELLO";
        // System.out.println(str.printSequence(arr, input));
        // String input2 = "HELLO WORLD";
        // System.out.println(str.printSequence(arr, input2));
        // String input3 = "GEEKSFORGEEKS";
        // System.out.println(str.printSequence(arr, input3));


        // Testing the Minimum Number of Bracket Reversals function
        // StringDS str = new StringDS("");
        // System.out.println(str.countMinReversals("}}{{"));
        // System.out.println(str.countMinReversals2("}}{{"));


        // Testing the Count All Palindrome Subsequence function
        // StringDS str = new StringDS("");
        // System.out.println(str.palindromeCount("abba"));

        // Testing the Count of Number of Given Words in 2D Character Array function
        // StringDS str = new StringDS("");
        // char[][] board = { { 'G', 'E', 'E', 'K', 'S' }, { 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
        //         { 'A', 'B', 'C', 'D', 'E', 'E', 'K', 'S' } };
        // String[] words = { "GEEKS", "FOR", "GEEKS" };
        // System.out.println(str.countWords(board, words));


        // Testing the Roman to Decimal function
        // StringDS str = new StringDS("");
        // System.out.println(str.romanToDecimal("XIV"));


        // Testing the Longest Common Prefix function
        // StringDS str = new StringDS("");
        // String[] strs = { "flower", "flow", "flight" };
        // System.out.println(str.longestCommonPrefix(strs));

        // Testing the Number of Flips to Make Binary String Alternate function
        // StringDS str = new StringDS("");
        // System.out.println(str.minFlips("0001010111"));


        // Testing the Minimum Number of Swap Operations for Bracket Balancing function
        // StringDS str = new StringDS("");
        // System.out.println(str.minSwaps("[]][]["));


        // Testing the Longest Common Subsequence function
        // StringDS str = new StringDS("");
        // System.out.println(str.longestCommonSubsequence("abcde", "ace"));


        // Testing the Recursively Print All Sentences that can be Formed from List of Word Lists function
        // StringDS str = new StringDS("");
        // List<List<String>> wordLists = new ArrayList<>();
        // List<String> list1 = new ArrayList<>();
        // list1.add("you");
        // list1.add("we");
        // List<String> list2 = new ArrayList<>();
        // list2.add("have");
        // list2.add("are");
        // List<String> list3 = new ArrayList<>();
        // list3.add("sleep");
        // list3.add("eat");
        // list3.add("drink");
        // wordLists.add(list1);
        // wordLists.add(list2);
        // wordLists.add(list3);
        // str.printSentences(wordLists);


        // Testing the Check if Two Given Strings are Isomorphic to Each Other function
        // StringDS str = new StringDS("");
        // System.out.println(str.isIsomorphic("egg", "add"));
        // System.out.println(str.isIsomorphic("foo", "bar"));
        // System.out.println(str.areIsomorphic("egg", "add"));
        // System.out.println(str.areIsomorphic("foo", "bar"));


        // Testing the Transform One String to Another using Minimum Number of Given Operation function
        // StringDS str = new StringDS("");
        // System.out.println(str.minOps("ABD", "BAD"));
        // System.out.println(str.minOps("EACBD", "EABCD"));


        // Testing the Number of Customers who could not get a Computer function
        // StringDS str = new StringDS("");
        // System.out.println(str.runCustomerSimulation(2, "ABBAJJKZKZ".toCharArray()));
        // System.out.println(str.runCustomerSimulation(3, "GACCBDDBAGEE".toCharArray()));
        // System.out.println(str.runCustomerSimulation(3, "GACCBGDDBAEE".toCharArray()));
        // System.out.println(str.runCustomerSimulation(1, "ABCBCA".toCharArray()));
        // System.out.println(str.runCustomerSimulation(1, "ABCBCADEED".toCharArray()));


        // Testing the String Matching where One String Contains Wildcard Characters function
        // StringDS str = new StringDS("");
        // str.testWildCard("g*ks", "geeks"); // Yes
        // str.testWildCard("ge?ks*", "geeksforgeeks"); // Yes
        // str.testWildCard("g*k", "gee"); // No
        // str.testWildCard("*pqrs", "pqrst"); // No
        // str.testWildCard("abc*bcd", "abcdhghgbcd"); // Yes
        // str.testWildCard("abc*c?d", "abcd"); // No
        

        // Testing the Recursively Remove All Adjacent Duplicates function
        // StringDS str = new StringDS("");
        // System.out.println(str.removeDuplicates("geeksforgeek"));


        // Testing the Find the Smallest Window in a String Containing All Characters of Another String function
        // StringDS str = new StringDS("");
        // System.out.println(str.minWindow("this is a test string", "tist"));


        // Testing the Given a Sequence of Words, Print All Anagrams Together function
        // StringDS str = new StringDS("");
        // String[] words = { "cat", "dog", "tac", "god", "act" };
        // str.printAnagrams(words);


        // Testing the Minimum Characters to be Added at Front to Make String Palindrome function
        // StringDS str = new StringDS("");
        // System.out.println(str.minCharsToBeAdded("AACECAAAA"));
        // System.out.println(str.minCharsToBeAdded2("AACECAAAA"));

        
        // Testing the Rearrange Characters in a String such that No Two Adjacent are Same function
        // StringDS str = new StringDS("");
        // System.out.println(str.rearrangeString("aaabc"));
        // System.out.println(str.rearrangeString2("aaabc"));


        // Testing the Write a Program to Find the Smallest Window that Contains All Characters of String Itself function
        
        // StringDS str = new StringDS("");
        // System.out.println(str.smallestWindow("aabcbcdbca"));


        // Testing the Program to Generate All Possible Valid IP Addresses from Given String function
        // StringDS str = new StringDS("");
        // System.out.println(str.generateIPAddresses("255255111"));

        // ArrayList<String> res = new ArrayList<>();
        // String s = "25525511135";
        // int n = s.length();
        // str.solveIP(s, 0,n-1, 1, "", res);
        // System.out.println(res);

        
        // Testing the Find the First Repeated Word in String function
        // StringDS str = new StringDS("");
        // System.out.println(str.firstRepeatedWord("Ravi had been saying that he had been there"));


        // Testing the Boyer Moore Algorithm for Pattern Searching function
        // StringDS str = new StringDS("");
        // System.out.println(str.boyerMoore("ABAAABCD", "ABC"));

        
    }
}
