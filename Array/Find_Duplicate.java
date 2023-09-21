public class Find_Duplicate {
    // public static int findDuplicate(int[] nums) {
    //     int slow = nums[0];
    //     int fast = nums[0];
    //     do {
    //         slow=nums[slow];
    //         fast=nums[nums[fast]];
    //     } while (slow!=fast);
    //     fast=nums[0];
    //     while (slow!=fast){
    //         slow=nums[slow];
    //         fast=nums[fast];
    //     }
    //     return slow;
    // }
 
    private static int store(int nums[], int curr){
        if(curr==nums[curr]){
            return curr;
        }
        int nxt=nums[curr];
        nums[curr]=curr;
        return store(nums, nxt);
    }
    public static int findDuplicate(int nums[]){
        
        return store(nums,0);
    }


    public static void main(String[] args) {
        int nums[]={1,3,4,2,2};
        System.out.println("Duplicate element is : "+findDuplicate(nums));
    }
}
