import java.util.Arrays;

public class Minimum_Subset_Sum_Memoization {

    static int[][] memo;

    public static int minSubsetSum(int[] arr, int n, int sum1, int sum2) {
        if (n == 0) {
            return Math.abs(sum1 - sum2);
        }

        if (memo[n][sum1] != -1) {
            return memo[n][sum1];
        }

        int diff1 = minSubsetSum(arr, n - 1, sum1 + arr[n - 1], sum2);
        int diff2 = minSubsetSum(arr, n - 1, sum1, sum2 + arr[n - 1]);

        memo[n][sum1] = Math.min(diff1, diff2);

        return memo[n][sum1];
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 2, 2, 1 };
        int n = arr.length;

        memo = new int[n + 1][Arrays.stream(arr).sum() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int minDiff = minSubsetSum(arr, n, 0, 0);

        System.out.println("Minimum subset sum difference is " + minDiff);
    }
}
