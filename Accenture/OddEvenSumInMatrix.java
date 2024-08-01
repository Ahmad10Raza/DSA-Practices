
// Problem Statement 

// You are required to input the size of the matrix then the elements of matrix, then you have to divide the main matrix in two sub matrices (even and odd) in such a way that element at 0 index will be considered as even and element at 1st index will be considered as odd and so on. then you have sort the even and odd matrices in ascending order then print the sum of second largest number from both the matrices

// Example

// enter the size of array : 5
// enter element at 0 index : 3
// enter element at 1 index : 4
// enter element at 2 index : 1
// enter element at 3 index : 7
// enter element at 4 index : 9
// Sorted even array : 1 3 9
// Sorted odd array : 4 7

// output: 7

// Approach: We will take the input of the size of the matrix and the elements of the matrix. Then we will divide the matrix into two sub-matrices, one for even and one for odd. We will sort both the matrices in ascending order and print the sum of the second largest number from both the matrices.

// Follow the below steps to implement the code:
// 1. Take the input of the size of the matrix.
// 2. Take the input of the elements of the matrix.
// 3. Divide the matrix into two sub-matrices, one for even and one for odd.
// 4. Sort both the matrices in ascending order.
// 5. Print the sum of the second largest number from both the matrices.

import java.util.Arrays;
import java.util.Scanner;

public class OddEvenSumInMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the matrix: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] even = new int[n];
        int[] odd = new int[n];
        int e = 0, o = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element at " + i + " index: ");
            arr[i] = sc.nextInt();
            if (i % 2 == 0) {
                even[e++] = arr[i];
            } else {
                odd[o++] = arr[i];
            }
        }
        Arrays.sort(even, 0, e);
        Arrays.sort(odd, 0, o);
        System.out.print("Sorted even array: ");
        for (int i = 0; i < e; i++) {
            System.out.print(even[i] + " ");
        }
        System.out.println();
        System.out.print("Sorted odd array: ");
        for (int i = 0; i < o; i++) {
            System.out.print(odd[i] + " ");
        }
        System.out.println();
        System.out.println("Output: " + (even[e - 2] + odd[o - 2]));

        sc.close();
    }
}
