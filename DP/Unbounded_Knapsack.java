import java.util.Arrays;

public class Unbounded_Knapsack {
    
    public static void main(String[] args) {
        int[] weights = { 2, 3, 4, 5 };
        int[] values = { 3, 4, 5, 6 };
        int capacity = 8;
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Using recursion: " + unboundedKnapsackRec(weights, values, capacity, n));
        System.out.println("Using memoization: " + unboundedKnapsackMemo(weights, values, capacity, n, dp));
        System.out.println("Using tabulation: " + unboundedKnapsackTab(weights, values, capacity, n));
    }

    public static int unboundedKnapsackRec(int[] weights, int[] values, int capacity, int n) {
        if (n == 0 || capacity == 0) {
            return 0;
        }
        if (weights[n - 1] <= capacity) {
            return Math.max(values[n - 1] + unboundedKnapsackRec(weights, values, capacity - weights[n - 1], n), 
                            unboundedKnapsackRec(weights, values, capacity, n - 1));
        } else {
            return unboundedKnapsackRec(weights, values, capacity, n - 1);
        }
    }
    
    public static int unboundedKnapsackMemo(int[] weights, int[] values, int capacity, int n, int[][] dp) {
        if (n == 0 || capacity == 0) {
            return 0;
        }
        if (dp[n][capacity] != -1) {
            return dp[n][capacity];
        }
        if (weights[n - 1] <= capacity) {
            return dp[n][capacity] = Math.max(values[n - 1] + unboundedKnapsackMemo(weights, values, capacity - weights[n - 1], n, dp), 
                                              unboundedKnapsackMemo(weights, values, capacity, n - 1, dp));
        } else {
            return dp[n][capacity] = unboundedKnapsackMemo(weights, values, capacity, n - 1, dp);
        }
    }
    
    public static int unboundedKnapsackTab(int[] weights, int[] values, int capacity, int n) {
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacity];
    }
}
