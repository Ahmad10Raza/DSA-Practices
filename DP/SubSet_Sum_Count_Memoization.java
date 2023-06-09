public class SubSet_Sum_Count_Memoization {
    // Returns count of subsets of arr[] with given sum
    static int countSubsets(int[] arr, int n, int sum, int[][] memo) {
        // Base Cases
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        // Check if the result for the current n and sum has already been computed
        if (memo[n][sum] != -1) {
            return memo[n][sum];
        }

        // If last element is greater than sum, ignore it
        if (arr[n-1] > sum) {
            memo[n][sum] = countSubsets(arr, n-1, sum, memo);
            return memo[n][sum];
        }

        // Else, count subsets with the last element and without the last element
        memo[n][sum] = countSubsets(arr, n-1, sum, memo) + countSubsets(arr, n-1, sum-arr[n-1], memo);
        return memo[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int sum = 10;
        int n = arr.length;
        int[][] memo = new int[n+1][sum+1];

        // Initializing the memoization array with -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                memo[i][j] = -1;
            }
        }

        int count = countSubsets(arr, n, sum, memo);
        System.out.println("Count of subsets with sum " + sum + " is " + count);
    }
}
