import java.util.Arrays;

public class SubSet_Difference_Count {

    // Recursive solution
    static int countSubsetsRec(int[] arr, int n, int diff) {
        if (n == 0) {
            return diff == 0 ? 1 : 0;
        }
        return countSubsetsRec(arr, n-1, diff) + countSubsetsRec(arr, n-1, diff-arr[n-1]) + countSubsetsRec(arr, n-1, diff+arr[n-1]);
    }

    // Memoization solution
    static int countSubsetsMemo(int[] arr, int n, int diff, int[][] memo) {
        if (n == 0) {
            return diff == 0 ? 1 : 0;
        }
        if (memo[n][diff] != -1) {
            return memo[n][diff];
        }
        int count = countSubsetsMemo(arr, n-1, diff, memo) + countSubsetsMemo(arr, n-1, diff-arr[n-1], memo) + countSubsetsMemo(arr, n-1, diff+arr[n-1], memo);
        memo[n][diff] = count;
        return count;
    }

    // Tabulation solution
    static int countSubsetsTabulation(int[] arr, int n, int diff, int range) {
        int[][] dp = new int[n+1][range+1];

        // Initializing the dp[][] array
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= range; j++) {
                dp[i][j] = (j == 0) ? 1 : 0;
            }
        }

        // Filling the remaining elements of dp[][] array
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= range; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
            }
        }

        return dp[n][(range-diff)/2];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;
        int n = arr.length;

        // Calculate the range of subset sum
        int range = 0;
        for (int i = 0; i < n; i++) {
            range += arr[i];
        }

        // Recursive solution
        int countRec = countSubsetsRec(arr, n, diff);
        System.out.println("Number of subsets with difference " + diff + " (recursive): " + countRec);

        // Memoization solution
        int[][] memo = new int[n+1][range+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int countMemo = countSubsetsMemo(arr, n, diff, memo);
        System.out.println("Number of subsets with difference " + diff+ " (memoization): " + countMemo);

        // Tabulation solution
        int countTabulation = countSubsetsTabulation(arr, n, diff, range);
        System.out.println("Number of subsets with difference " + diff + " (tabulation): " + countTabulation);
    }
}

