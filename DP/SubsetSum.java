public class SubsetSum {
    static boolean subsetSumRecursion(int[] set, int n, int sum) {
        // Base Cases
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        // If last element is greater than sum, ignore it
        if (set[n-1] > sum) {
            return subsetSumRecursion(set, n-1, sum);
        }
        /* Check if sum can be obtained by including or excluding
        the last element */
        return subsetSumRecursion(set, n-1, sum) || subsetSumRecursion(set, n-1, sum-set[n-1]);
    }

    static boolean subsetSumMemoization(int[] set, int n, int sum, Boolean[][] memo) {
        // Base Cases
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (memo[n][sum] != null) {
            return memo[n][sum];
        }
        // If last element is greater than sum, ignore it
        if (set[n-1] > sum) {
            memo[n][sum] = subsetSumMemoization(set, n-1, sum, memo);
            return memo[n][sum];
        }
        /* Check if sum can be obtained by including or excluding
        the last element */
        memo[n][sum] = subsetSumMemoization(set, n-1, sum, memo) || subsetSumMemoization(set, n-1, sum-set[n-1], memo);
        return memo[n][sum];
    }

    static boolean subsetSumTabulation(int[] set, int n, int sum) {
        boolean[][] tab = new boolean[n+1][sum+1];
        // Base Cases
        for (int i = 0; i <= n; i++) {
            tab[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {
            tab[0][j] = false;
        }
        // Fill the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (set[i-1] > j) {
                    tab[i][j] = tab[i-1][j];
                }
                else {
                    tab[i][j] = tab[i-1][j] || tab[i-1][j-set[i-1]];
                }
            }
        }
        return tab[n][sum];
    }
    
    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        // Using recursion
        if (subsetSumRecursion(set, n, sum) == true) {
            System.out.println("Found a subset with given sum (using recursion)");
        }
        else {
            System.out.println("No subset with given sum (using recursion)");
        }
        // Using memoization
        Boolean[][] memo = new Boolean[n+1][sum+1];
        if (subsetSumMemoization(set, n, sum, memo) == true) {
            System.out.println("Found a subset with given sum (using memoization)");
        }
        else {
            System.out.println("No subset with given sum (using memoization)");
        }
            // Using tabulation
            if (subsetSumTabulation(set, n, sum) == true) {
                System.out.println("Found a subset with given sum (using tabulation)");
            }
            else {
                System.out.println("No subset with given sum (using tabulation)");
            }
        }
    }
    