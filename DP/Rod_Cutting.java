import java.util.Arrays;

public class Rod_Cutting {
    public static void main(String[] args) {
        int[] lengths = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 4; // the length of the rod to be cut
        
        // solve using recursion
        int maxProfitRecursion = rodCuttingRecursion(n, lengths, prices);
        System.out.println("Maximum profit using recursion: " + maxProfitRecursion);
        
        // solve using memoization
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        int maxProfitMemoization = rodCuttingMemoization(n, lengths, prices, memo);
        System.out.println("Maximum profit using memoization: " + maxProfitMemoization);
        
        // solve using tabulation
        int maxProfitTabulation = rodCuttingTabulation(n, lengths, prices);
        System.out.println("Maximum profit using tabulation: " + maxProfitTabulation);
    }
    
    public static int rodCuttingRecursion(int n, int[] lengths, int[] prices) {
        if (n <= 0) {
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] <= n) {
                maxProfit = Math.max(maxProfit, prices[i] + rodCuttingRecursion(n - lengths[i], lengths, prices));
            }
        }
        return maxProfit;
    }
    
    public static int rodCuttingMemoization(int n, int[] lengths, int[] prices, int[] memo) {
        if (n <= 0) {
            return 0;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] <= n) {
                maxProfit = Math.max(maxProfit, prices[i] + rodCuttingMemoization(n - lengths[i], lengths, prices, memo));
            }
        }
        memo[n] = maxProfit;
        return maxProfit;
    }
    
    public static int rodCuttingTabulation(int n, int[] lengths, int[] prices) {
        int[] table = new int[n+1];
        table[0] = 0;
        for (int i = 1; i <= n; i++) {
            int maxProfit = Integer.MIN_VALUE;
            for (int j = 0; j < lengths.length; j++) {
                if (lengths[j] <= i) {
                    maxProfit = Math.max(maxProfit, prices[j] + table[i - lengths[j]]);
                }
            }
            table[i] = maxProfit;
        }
        return table[n];
    }
}
