
// Function to print all permuataion of String

// Approach: The idea is to use backtracking to solve this problem. We will
// create a recursive function that will generate all the permutations of the
// given string. The recursive function will take the following parameters:

// Input: str = "abc"
// Output: abc
//         acb
//         bac
//         bca
//         cba
//         cab

// Time Complexity: O(n*n!)
// Space Complexity: O(n)

public class PrintAllPermutation {

    public static void printAllPermutation(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
            return;
        }

        for (int i = l; i <= r; i++) {
            str = swap(str, l, i);
            printAllPermutation(str, l + 1, r);
            str = swap(str, l, i);
        }
    }

    public static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String str = "abc";
        printAllPermutation(str, 0, str.length() - 1);
    }
}
