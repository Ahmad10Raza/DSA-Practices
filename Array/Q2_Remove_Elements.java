
// 💡 **Q2.** Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
// Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
// - Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
// - Return k.




public class Q2_Remove_Elements {
    public static int removeElements(int nums[], int val){
        int end=nums.length-1;
        int start=0;
        while(start<=end){
        if(nums[end]==val){
            end--;
        }
        else{
            if(nums[start]==val){
                int temp=nums[end];
                nums[end]=nums[start];
                nums[start]=temp;
                start++;
                end--;
            }
            else{
                start++;
            }
        }
        }
        return end+1;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int result = removeElements(nums, val);
        System.out.println(result);
    }
}
