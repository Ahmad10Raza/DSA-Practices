
// Problem Statement :

// An autographical number is a special type of number in which the digit describe how many times each digit appears in the number itself. For example, 6210001000 is an autographical number. The first digit is 6, which indicates that there are 6 zeros in the number, the second digit is 2, which indicates that there are 2 ones in the number, and so on. You are given a function,

// An Autobiographical Number is a number N such that the first digit of N represents the count of how many zeroes are there in N, the second digit represents the count of how many ones are there in N and so on.

// You are given a function, def FindAutoCount(n):

// The function accepts string “n” which is a number and checks whether the number is an autobiographical number or not. If it is, an integer is returned, i.e. the count of distinct numbers in ‘n’. If not, it returns 0.

// Assumption:

// The input string will not be longer than 10 characters.
// Input string will consist of numeric characters.
// Note:

// If string is None return 0.

// Example:

// Input:

// n: “1210”

// Output:

// 3

// Explanation:

// 0th position in the input contains the number of 0 present in input, i.e. 1, in 1st position the count of number of 1s in input i.e. 2, in 2nd position the count of 2s in input i.e. 1, and in 3rd position the count of 3s i.e. 0, so the number is an autobiographical number.

// Now unique numbers in the input are 0, 1, 2, so the count of unique numbers is 3. So 3 is returned.

// Approach: We need to check if the given number is an autobiographical number or not. We will iterate through the number and check if the count of each digit in the number is equal to the digit itself. We will maintain a list to store the count of each digit in the number. We will iterate through the number and increment the count of each digit in the list. We will check if the count of each digit is equal to the digit itself. If the condition is satisfied, we will increment the count of distinct numbers in the number. We will return the count of distinct numbers in the number after iterating through the number.

// Follow the below steps to solve the problem:
// 1. Check if the string is None. If yes, return 0.
// 2. Initialize a list ‘count’ of size 10 to store the count of each digit in the number.
// 3. Initialize a variable ‘distinct’ to 0 to store the count of distinct numbers in the number.
// 4. Iterate through the string from 0 to n-1 and increment the count of each digit in the list ‘count’.
// 5. Iterate through the list ‘count’ and check if the count of each digit is equal to the digit itself.
// 6. If the condition is satisfied, increment the ‘distinct’.
// 7. Return the ‘distinct’ after iterating through the list ‘count’.

public class AutobiographicalNumber {

    public static int FindAutoCount(String n) {
        if (n == null) {
            return 0;
        }
        int[] count = new int[10];
        int distinct = 0;
        for (int i = 0; i < n.length(); i++) {
            // Increment the count of each digit in the list
            count[n.charAt(i) - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            if (count[i] == i) {
                distinct++;
            }
        }
        return distinct;
    }

    public static void main(String[] args) {
        String n = "1210";
        System.out.println(FindAutoCount(n));
    }
}
