import java.util.*;

public class Target_Sum {
    
    // Using Recursion
    public static int targetSumRecursion(int[] nums, int target) {
        return targetSumRecursionHelper(nums, target, 0);
    }
    
    private static int targetSumRecursionHelper(int[] nums, int target, int index) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        int waysWithPlus = targetSumRecursionHelper(nums, target - nums[index], index + 1);
        int waysWithMinus = targetSumRecursionHelper(nums, target + nums[index], index + 1);
        return waysWithPlus + waysWithMinus;
    }
    
    // Using Memoization
    public static int targetSumMemoization(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return targetSumMemoizationHelper(nums, target, 0, memo);
    }
    
    private static int targetSumMemoizationHelper(int[] nums, int target, int index, Map<String, Integer> memo) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        String key = index + ":" + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int waysWithPlus = targetSumMemoizationHelper(nums, target - nums[index], index + 1, memo);
        int waysWithMinus = targetSumMemoizationHelper(nums, target + nums[index], index + 1, memo);
        int result = waysWithPlus + waysWithMinus;
        memo.put(key, result);
        return result;
    }
    
    // Using Tabulation
    public static int targetSumTabulation(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int newTarget = (sum + target) / 2;
        int[] dp = new int[newTarget + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = newTarget; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[newTarget];
    }
    
    // Main method to test
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};
        int target = 1;
        System.out.println("Using Recursion: " + targetSumRecursion(nums, target));
        System.out.println("Using Memoization: " + targetSumMemoization(nums, target));
        System.out.println("Using Tabulation: " + targetSumTabulation(nums, target));
    }
}
