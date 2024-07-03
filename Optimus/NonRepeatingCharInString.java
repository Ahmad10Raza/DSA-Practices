
//  Find non-repeating characters in a string
//  Given a string, find the first non-repeating character in it. For example, 
// if the input string is “GeeksforGeeks”, then the output should be ‘f’ and if the input string is “GeeksQuiz”, then the output should be ‘G’.

//  Method 1: Using HashMap
//  Approach:
//  1. Create a count array of size 256(assuming only ASCII characters are present) and initialize it with zero.
//  2. Traverse the string and increase the count of each character in the count array.
//  3. Traverse the string again and check the count of each character, if you find an element who’s count is 1, return it.
//  4. If no such element is found, return null.



public class NonRepeatingCharInString {
    
    public static Character nonRepeatingChar(String str) {
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String str = "GeeksforGeeks";
        System.out.println(nonRepeatingChar(str));
    }
}
