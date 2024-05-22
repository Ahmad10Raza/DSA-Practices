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
        StringDS str = new StringDS("");
        System.out.println(str.splitString("010011"));
        System.out.println(str.splitString("0100110101"));
        


        
    }
}
