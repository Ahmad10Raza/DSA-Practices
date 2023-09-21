import java.util.*;

public class Minimum_Subset_Sum_Difference 
{

    // Function to find the minimum difference between the sum of two subsets of a given array using recursion
    public static int minSubsetSumDiffRecursion(int[] arr, int n, int sum1, int sum2) {
        // Base case: If all elements have been processed, return the absolute difference between the two sums
        if (n == 0) {
            return Math.abs(sum1 - sum2);
        }
        // Recursive cases: Include the current element in either subset and compute the minimum difference
        int diff1 = minSubsetSumDiffRecursion(arr, n - 1, sum1 + arr[n - 1], sum2);
        int diff2 = minSubsetSumDiffRecursion(arr, n - 1, sum1, sum2 + arr[n - 1]);
        return Math.min(diff1, diff2);
    }

    // Function to find the minimum difference between the sum of two subsets of a given array using memoization
    public static int minSubsetSumDiffMemoization(int[] arr, int n, int sum1, int sum2, int[][] memo) {
        // Base case: If all elements have been processed, return the absolute difference between the two sums
        if (n == 0) {
            return Math.abs(sum1 - sum2);
        }
        // If the result for this state has already been computed, return it
        if (memo[n][sum1] != -1) {
            return memo[n][sum1];
        }
        // Recursive cases: Include the current element in either subset and compute the minimum difference
        int diff1 = minSubsetSumDiffMemoization(arr, n - 1, sum1 + arr[n - 1], sum2, memo);
        int diff2 = minSubsetSumDiffMemoization(arr, n - 1, sum1, sum2 + arr[n - 1], memo);
        // Memoize the result for this state
        memo[n][sum1] = Math.min(diff1, diff2);
        return memo[n][sum1];
    }

    // Function to find the minimum difference between the sum of two subsets of a given array using tabulation
    public static int minSubsetSumDiffTabulation(int[] arr, int n) {
        // Compute the total sum of the array
        int totalSum = Arrays.stream(arr).sum();
        // Compute the maximum possible sum for each subset
        int maxSum = totalSum / 2;
        // Initialize the tabulation table
        int[][] table = new int[n + 1][maxSum + 1];
        // Fill the table for all possible sums and array elements
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxSum; j++) {
                // Base case: If there are no elements left or the sum is 0, return 0
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                }
                // If the current element can be included in the current subset, choose the maximum of including and not including it
                else if (arr[i - 1] <= j) {
                    table[i][j] = Math.max(table[i - 1][j], arr[i - 1] + table[i - 1][j - arr[i - 1]]);
                }
                // If the
                else {
                    // If the current element cannot be included in the current subset, exclude it
                    table[i][j] = table[i - 1][j];
                    }
                    }
                    }
                    // Find the largest sum that can be obtained in the first subset
                    int sum1 = table[n][maxSum];
                    // Compute the minimum difference between the sum of the two subsets
                    int sum2 = totalSum - sum1;
                    System.out.println("2D Tabulation Matrix:");
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= maxSum; j++) {
            System.out.print(table[i][j] + " ");
        }
        System.out.println();
    }
                    return Math.abs(sum1 - sum2);
                    

                    
                    }
                    
// Main function to test the above algorithms
public static void main(String[] args) {
    int[] arr = {1, 6, 11, 5};
    int n = arr.length;

    // Test the recursion algorithm
    int minDiffRecursion = minSubsetSumDiffRecursion(arr, n, 0, 0);
    System.out.println("Minimum difference between the sum of two subsets (recursion): " + minDiffRecursion);

    // Test the memoization algorithm
    int[][] memo = new int[n + 1][Arrays.stream(arr).sum() + 1];
    for (int[] row : memo) {
        Arrays.fill(row, -1);
    }
    int minDiffMemoization = minSubsetSumDiffMemoization(arr, n, 0, 0, memo);
    System.out.println("Minimum difference between the sum of two subsets (memoization): " + minDiffMemoization);

    // Test the tabulation algorithm
    int minDiffTabulation = minSubsetSumDiffTabulation(arr, n);
    System.out.println("Minimum difference between the sum of two subsets (tabulation): " + minDiffTabulation);



    
}
   
}