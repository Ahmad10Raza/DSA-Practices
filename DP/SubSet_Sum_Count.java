public class SubSet_Sum_Count {
    
    // Returns count of subsets of arr[] with given sum
    static int countSubsets(int[] arr, int n, int sum) {
        // Base Cases
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
 
        // If last element is greater than sum, ignore it
        if (arr[n-1] > sum) {
            return countSubsets(arr, n-1, sum);
        }
 
        // Else, count subsets with the last element and without the last element
        return countSubsets(arr, n-1, sum) + countSubsets(arr, n-1, sum-arr[n-1]);
    }



    // Returns count of subsets of arr[] with given sum
    static int countSubsets_Tabulation(int[] arr, int n, int sum) {
        int[][] dp = new int[n+1][sum+1];

        // Initializing the first row and first column of dp[] array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = 0;
        }

        // Filling the remaining elements of dp[] array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
            }
        }

        return dp[n][sum];
    }
 
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int sum = 10;
        int n = arr.length;
        int count = countSubsets(arr, n, sum);
        System.out.println("Count of subsets with sum " + sum + " is " + count);
        int count2 = countSubsets_Tabulation(arr, n, sum);
        System.out.println("Count of subsets with sum " + sum + " is " + count2);
    }
}
