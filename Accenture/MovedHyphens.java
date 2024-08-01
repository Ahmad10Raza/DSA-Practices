
// Implement the following functions.a

// char*MoveHyphen(char str[],int n);

// The function accepts a string “str” of length ‘n’, that contains alphabets and hyphens (-). Implement the function to move all hyphens(-) in the string to the front of the given string.

// NOTE:- Return null if str is null.

// Example :-

// Input:
// str.Move-Hyphens-to-Front
// Output:
// —MoveHyphenstoFront
// Explanation:-

// The string “Move-Hyphens -to-front” has 3 hyphens (-), which are moved to the front of the string, this output is “— MoveHyphen”

// Sample Input

// Str: String-Compare
// Sample Output-

// -StringCompare

// Approach: We will take the input of a string str of length n. We are required to move all hyphens (-) in the string to the front of the given string. We will iterate through the string and move all hyphens to the front of the string. Finally, we will return the modified string.

// Follow the below steps to implement the code:
// 1. Take the input of a string str of length n.
// 2. Check if the string is null. If it is null, return null.
// 3. Initialize a variable count to store the count of hyphens.
// 4. Iterate through the string and count the number of hyphens.
// 5. Move all hyphens to the front of the string.
// 6. Return the modified string.

public class MovedHyphens {

    public static void main(String[] args) {
        char[] str = "Move-Hyphens-to-Front".toCharArray();
        System.out.println(MoveHyphen(str, str.length));
    }

    public static char[] MoveHyphen(char[] str, int n) {
        if (str == null) {
            return null;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] == '-') {
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            str[i] = '-';
        }
        return str;
    }
}
