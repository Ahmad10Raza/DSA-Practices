
// Given an Array of size N and a value K, around which we need to right rotate the array. How do you quickly print the right rotated array?
// Examples : 

// Input: Array[] = {1, 3, 5, 7, 9}, K = 2.
// Output: 7 9 1 3 5
// Explanation:
// After 1st rotation – {9, 1, 3, 5, 7}After 2nd rotation – {7, 9, 1, 3, 5}

// Input: Array[] = {1, 2, 3, 4, 5}, K = 4.
// Output: 2 3 4 5 1

// Approach: The idea is to reverse the array in two parts. The first part is from 0 to N-K-1 and the second part is from N-K to N-1. After reversing the two parts, reverse the whole array to get the desired output.

// Follow below steps to implement the code:
// 1. Reverse the array from 0 to N-K-1.
// 2. Reverse the array from N-K to N-1.
// 3. Reverse the whole array.

public class Krotation {

    public static void rightRotate(int[] A, int K) {
        int N = A.length;
        K = K % N;
        reverse(A, 0, N - K - 1);
        reverse(A, N - K, N - 1);
        reverse(A, 0, N - 1);
    }

    public static void reverse(int[] A, int start, int end) {
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] A = { 1, 3, 5, 7, 9 };
        int K = 2;
        rightRotate(A, K);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

}
