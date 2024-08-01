
// Implement the following Function

// def ProductSmallestPair(sum, arr)

// The function accepts an integers sum and an integer array arr of size n. Implement the function to find the pair, (arr[j], arr[k]) where j!=k, Such that arr[j] and arr[k] are the least two elements of array (arr[j] + arr[k] <= sum) and return the product of element of this pair

// NOTE

// Return -1 if array is empty or if n<2
// Return 0, if no such pairs found
// All computed values lie within integer range
// Example

// Input

// sum:9

// size of Arr = 7

// Arr:5 2 4 3 9 7 1

// Output

// 2

// Explanation

// Pair of least two element is (2, 1) 2 + 1 = 3 < 9, Product of (2, 1) 2*1 = 2. Thus, output is 2

// Sample Input

// sum:4

// size of Arr = 6

// Arr:9 8 3 -7 3 9

// Sample Output

// -21
// Explanation: Pair of least two element is (3, -7) 3 + (-7) = -4 < 4, Product of (3, -7) 3 * (-7) = -21. Thus, output is -21

// Approach: We need to find the pair of elements in the array whose sum is less than or equal to the given sum and the product of the pair is minimum. We will iterate through the array and find the least two elements whose sum is less than or equal to the given sum. We will return the product of the least two elements.

// Follow the below steps to solve the problem:
// 1. Check if the array is empty or the length of the array is less than 2. If yes, return -1.
// 2. Sort the array in ascending order.
// 3. Initialize two variables ‘j’ and ‘k’ to 0 and 1 to store the indices of the least two elements.
// 4. Iterate through the array from 0 to n-1 and find the indices of the least two elements whose sum is less than or equal to the given sum.
// 5. Return the product of the least two elements.

import java.util.Arrays;

public class ProductSmallestPair {

    public static int productSmallestPair(int sum, int[] arr) {
        if (arr.length == 0 || arr.length < 2) {
            return -1;
        }
        Arrays.sort(arr);
        int j = 0;
        int k = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[j] + arr[k] <= sum) {
                break;
            }
            j++;
            k++;
        }
        return arr[j] * arr[k];
    }

    public static int productSmallestPair2(int arr[], int n, int sum) {
        if (n < 2)
            return -1;
        int temp, check;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        check = arr[0] + arr[1];
        if (check <= sum)
            return arr[0] * arr[1];
        else
            return 0;
    }

    public static void main(String[] args) {
        int sum = 9;
        int[] arr = { 5, 2, 4, 3, 9, 7, 1 };
        System.out.println(productSmallestPair(sum, arr));
    }
}
