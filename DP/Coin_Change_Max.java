import java.util.*;

public class Coin_Change_Max {
    
    // Function to solve the coin change problem using recursion
    public static int coinChangeRecursion(int[] coins, int n, int amount) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || n == 0) {
            return 0;
        }
        return coinChangeRecursion(coins, n - 1, amount) + coinChangeRecursion(coins, n, amount - coins[n - 1]);
    }
    
    // Function to solve the coin change problem using memoization
    public static int coinChangeMemoization(int[] coins, int n, int amount, int[][] memo) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || n == 0) {
            return 0;
        }
        if (memo[n][amount] != -1) {
            return memo[n][amount];
        }
        memo[n][amount] = coinChangeMemoization(coins, n - 1, amount, memo) + coinChangeMemoization(coins, n, amount - coins[n - 1], memo);
        return memo[n][amount];
    }
    
    // Function to solve the coin change problem using tabulation
    public static int coinChangeTabulation(int[] coins, int n, int amount) {
        int[][] table = new int[n + 1][amount + 1];
        
        for (int i = 0; i <= n; i++) {
            table[i][0] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = table[i - 1][j] + table[i][j - coins[i - 1]];
                }
            }
        }
        
        return table[n][amount];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of coins: ");
        int n = sc.nextInt();
        int[] coins = new int[n];
        System.out.print("Enter the values of the coins: ");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.print("Enter the amount to make change for: ");
        int amount = sc.nextInt();
        
        int[][] memo = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        sc.close();
        System.out.println("Number of ways using recursion: " + coinChangeRecursion(coins, n, amount));
        System.out.println("Number of ways using memoization: " + coinChangeMemoization(coins, n, amount, memo));
        System.out.println("Number of ways using tabulation: " + coinChangeTabulation(coins, n, amount));
    }
}
