public class SubsetSumCount {
    
    public static int countSubsets(int[] arr, int sum, int n) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }
        return countSubsets(arr, sum, n-1) + countSubsets(arr, sum-arr[n-1], n-1);
    }
    


    public static int countSubsets_Tabulation(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
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
        int[] arr = {3, 4, 5, 2};
        int sum = 7;
        int n = arr.length;
        int count = countSubsets(arr, sum, n);
        System.out.println("Count of subsets with sum " + sum + " is " + count);
        int count2 = countSubsets_Tabulation(arr, sum);
        System.out.println("Count of subsets with sum " + sum + " is " + count2);
    }
}
