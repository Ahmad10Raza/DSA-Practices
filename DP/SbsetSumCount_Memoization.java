import java.util.HashMap;
import java.util.Map;

public class SbsetSumCount_Memoization {
    
    public static int countSubsets(int[] arr, int sum, int n, Map<String, Integer> memo) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }
        String key = sum + "," + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int count = countSubsets(arr, sum, n-1, memo) + countSubsets(arr, sum-arr[n-1], n-1, memo);
        memo.put(key, count);
        return count;
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 2};
        int sum = 7;
        int n = arr.length;
        Map<String, Integer> memo = new HashMap<>();
        int count = countSubsets(arr, sum, n, memo);
        System.out.println("Count of subsets with sum " + sum + " is " + count);
    }
}
