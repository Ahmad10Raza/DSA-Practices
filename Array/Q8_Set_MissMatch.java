// 💡 **Q8.** You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
// You are given an integer array nums representing the data status of this set after the error.
// Find the number that occurs twice and the number that is missing and return them in the form of an array.


public class Q8_Set_MissMatch {
    public static int[] findErrorNums(int[] nums) {
        int ans[] = {-1,-1};
        for(int i=0;i<nums.length;i++)
        {
            int curr=Math.abs(nums[i])-1;
            if(nums[curr]<0)
                ans[0] = curr + 1;
            else
                nums[curr] = nums[curr] * -1;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
                ans[1] = i + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 1,2,2,4 };
        int[] repeatingNum = findErrorNums(arr);
 
        
        System.out.println(repeatingNum);
    }
}
