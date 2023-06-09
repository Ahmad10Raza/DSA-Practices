import java.util.Arrays;

public class Minimum_Subset_Sum {
    
    public static int minSubsetSum(int[] arr, int n, int sum1, int sum2) {
        if (n == 0) {
            return Math.abs(sum1 - sum2);
        }
        int diff1 = minSubsetSum(arr, n-1, sum1+arr[n-1], sum2);
        int diff2 = minSubsetSum(arr, n-1, sum1, sum2+arr[n-1]);
        return Math.min(diff1, diff2);
    }


    public static int minSubsetSum_Tabulation(int[] arr) {
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        boolean[][] dp = new boolean[n+1][sum+1];
        
        // Base case: when sum is zero
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if (arr[i-1] <= j) {
                    dp[i][j] |= dp[i-1][j-arr[i-1]];
                }
            }
        }
        
        // Find the minimum subset sum difference
        int diff = Integer.MAX_VALUE;
        for (int j = 0; j <= sum/2; j++) {
            if (dp[n][j]) {
                diff = Math.min(diff, sum - 2*j);
            }
        }
        
        return diff;
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 2, 1};
        int n = arr.length;
        int minDiff = minSubsetSum(arr, n, 0, 0);
        System.out.println("Minimum subset sum difference is " + minDiff);
        int minDiff2 = minSubsetSum_Tabulation(arr);
        System.out.println("Minimum subset sum difference is " + minDiff2);
    }
}
