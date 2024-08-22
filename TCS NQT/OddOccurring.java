
// Given an array of integers where every element appears even number of times except one element which appears odd number of times, write a program to find that odd occurring element in O(log n) time. The equal elements must appear in pairs in the array but there cannot be more than two consecutive occurrences of an element. 

// Example
// A: [1, 2, 3, 2, 3, 1, 3]
// Answer: 3
// Explanation: The element 3 appears 3 times in the array, which is odd.

// // // Approach: 
// This is not an efficient approach but just another way to get the desired results. If we add each number once and multiply the sum by 2, we will get twice the sum of each element of the array. Then we will subtract the sum of the whole array from the twice_sum and get the required number (which appears once in the array).
// Array [] : [a, a, b, b, c, c, d] 
// Mathematical Equation = 2*(a+b+c+d) – (a + a + b + b + c + c + d) 

// In more simple words: 2*(sum_of_array_without_duplicates) – (sum_of_array) 

// let arr[] = {7, 3, 5, 4, 5, 3, 4}
// Required no = 2*(sum_of_array_without_duplicates) - (sum_of_array)
//             = 2*(7 + 3 + 5 + 4) - (7 + 3 + 5 + 4 + 5 + 3 + 4) 
//             = 2*     19         -      31 
//             = 38 - 31
//             = 7 (required answer)

// Follow below steps to implement the code:
// 1. Create a variable sum and initialize it to 0.
// 2. Iterate through the array and add each element to the sum.
// 3. Create a variable twice_sum and initialize it to 0.
// 4. Iterate through the array and add each element to the twice_sum.
// 5. Return the result of 2 * twice_sum - sum.

import java.util.HashMap;

public class OddOccurring {

    public static int oddOccurring(int[] A) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                sum1 += A[i];
                map.put(A[i], 1);
            }
            sum2 += A[i];
        }
        return (2 * (sum1) - sum2);
    }

    // Approach: Use XOR operation to find the odd occurring element.
    // The best solution is to use XOR. XOR of all array elements gives us the
    // number with a single occurrence. The idea is based on the following two
    // facts.

    // XOR of a number with itself is 0.
    // XOR of a number with 0 is number itself.
    // Let us consider the above example.
    // Let ^ be xor operator as in C and C++.

    // res = 7 ^ 3 ^ 5 ^ 4 ^ 5 ^ 3 ^ 4

    // Since XOR is associative and commutative, above
    // expression can be written as:
    // res = 7 ^ (3 ^ 3) ^ (4 ^ 4) ^ (5 ^ 5)
    // = 7 ^ 0 ^ 0 ^ 0
    // = 7 ^ 0
    // = 7

    // Follow below steps to implement the code:
    // 1. Create a variable res and initialize it to 0.
    // 2. Iterate through the array and perform XOR of each element with res.
    // 3. Return the value of res.

    public static int oddOccurringXOR(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res = res ^ A[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 2, 3, 1, 3 };
        System.out.println(oddOccurring(A));
        System.out.println(oddOccurringXOR(A));
    }
}
