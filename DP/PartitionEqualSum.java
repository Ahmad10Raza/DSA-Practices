public class PartitionEqualSum {
    
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return canPartitionHelper(nums, 0, 0, sum);
    }
    
    private static boolean canPartitionHelper(int[] nums, int index, int sum, int target) {
        if (sum * 2 == target) {
            return true;
        }
        if (sum > target / 2 || index >= nums.length) {
            return false;
        }
        return canPartitionHelper(nums, index + 1, sum + nums[index], target) ||
            canPartitionHelper(nums, index + 1, sum, target);
    }





    public static boolean canPartition_Memoization(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        
        Boolean[][] memo = new Boolean[nums.length][sum/2 + 1];
        return canPartitionHelper_Memoization(nums, 0, 0, sum/2, memo);
    }
    
    private static boolean canPartitionHelper_Memoization(int[] nums, int index, int sum, int target, Boolean[][] memo) {
        if (sum == target) {
            return true;
        }
        if (sum > target || index >= nums.length) {
            return false;
        }
        if (memo[index][sum] != null) {
            return memo[index][sum];
        }
        boolean result = canPartitionHelper_Memoization(nums, index+1, sum+nums[index], target, memo) ||
                          canPartitionHelper_Memoization(nums, index+1, sum, target, memo);
        memo[index][sum] = result;
        return result;
    }
    


    public static boolean canPartition_Tabulation(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        
        boolean[][] dp = new boolean[nums.length][sum/2 + 1];
        
        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        
        for(int s = 1; s <= sum/2; s++) {
            dp[0][s] = nums[0] == s;
        }
        
        for(int i = 1; i < nums.length; i++) {
            for(int s = 1; s <= sum/2; s++) {
                if(dp[i-1][s]) {
                    dp[i][s] = true;
                }
                else if(s >= nums[i]) {
                    dp[i][s] = dp[i-1][s-nums[i]];
                }
            }
        }
        
        return dp[nums.length-1][sum/2];
    }
    
    
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums)); // true
        
        int[] nums2 = {1, 2, 3, 5};
        System.out.println(canPartition(nums2)); // false

        System.out.println(canPartition_Memoization(nums)); // true
        
        System.out.println(canPartition_Memoization(nums2)); // false
    
        System.out.println(canPartition_Tabulation(nums)); // true
        
        System.out.println(canPartition_Tabulation(nums2)); // false
    }
}
