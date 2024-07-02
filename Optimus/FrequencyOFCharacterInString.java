
// Write a program to find the frequency of each character in a string.
// We have given a string, and we have to find the frequency of each character in the string.
// Example
// Input: "hello"
// Output: h:1, e:1, l:2, o:1

// Approach : An efficient approach is to use a hash table to store the frequency of each character in the string.
// We will iterate over the string and store the frequency of each character in the hash table.
// Finally, we will print the frequency of each character in the hash table.

// Time Complexity: O(n)
// Space Complexity: O(1)

public class FrequencyOFCharacterInString {
    
    public static void frequencyOfCharacter(String str) {
        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                System.out.println((char)i + ":" + freq[i]);
            }
        }
    }

    public static void main(String[] args) {
        String str = "hello";
        frequencyOfCharacter(str);
    }
}
