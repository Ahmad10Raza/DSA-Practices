
// Given an array arr[] of size n, return an equilibrium index (if any) or -1 if no equilibrium index exists. The equilibrium index of an array is an index such that the sum of elements at lower indexes equals the sum of elements at higher indexes.

// Note: Return equilibrium point in 1-based indexing. Return -1 if no such point exists. 

// Examples:

// Input: arr[] = {-7, 1, 5, 2, -4, 3, 0}
// Output: 4
// Explanation: In 1-based indexing, 4 is an equilibrium index, because: arr[1] + arr[2] + arr[3] = arr[5] + arr[6] + arr[7]

// Input: arr[] = {1, 2, 3}
// Output: -1
// Explanation: There is no equilibrium index in the array.

// Approach: The idea is to calculate the total sum of the array and then iterate through the array to find the equilibrium index. At each index, check if the sum of elements on the left side is equal to the sum of elements on the right side. If it is equal, return the index. If no equilibrium index is found, return -1.

// Follow below steps to implement the code:
// 1. Calculate the total sum of the array.
// 2. Initialize the left sum as 0.
// 3. Iterate through the array and check if the left sum is equal to the total sum minus the current element and the left sum. 
// 4. If it is equal, return the index.
// 5. If no equilibrium index is found, return -1.

public class EquilibriumIndex {

    public static int equilibriumIndex(int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (leftSum == totalSum - arr[i] - leftSum) {
                return i + 1;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println(equilibriumIndex(arr1)); // Output: 4

        int[] arr2 = { 1, 2, 3 };
        System.out.println(equilibriumIndex(arr2)); // Output: -1
    }
}
