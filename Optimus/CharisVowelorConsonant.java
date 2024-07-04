
// Write a program to check whether a character is a vowel or consonant
// Input: a
// Output: Vowel

// Input: z
// Output: Consonant

// Approach: To check whether a character is a vowel or consonant, we need to compare the character with the set of vowels. If the character matches any of the vowels, then it is a vowel; otherwise, it is a consonant.

public class CharisVowelorConsonant {

    public static String checkVowelOrConsonant(char ch) {
        // Convert character to lowercase
        ch = Character.toLowerCase(ch);

        // Check if the character is a vowel
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        } else {
            return "Consonant";
        }
    }

    public static void main(String[] args) {
        char ch1 = 'a';
        char ch2 = 'z';

        System.out.println(checkVowelOrConsonant(ch1)); // Vowel
        System.out.println(checkVowelOrConsonant(ch2)); // Consonant
    }
}
