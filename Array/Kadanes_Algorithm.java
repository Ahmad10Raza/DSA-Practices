public class Kadanes_Algorithm {
    public static void kadanes(int nums[]){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            currSum += nums[i];
            if(currSum<0){
                currSum=0;
            }
            maxSum=Math.max(maxSum,currSum);
        }
        System.out.println("The Maximum Sum is :" + maxSum);
    }
    public static void main(String[] args) {
        int nums[]={-2,3,4,-1,5,-12,6,1,3};
        kadanes(nums);
    }
}
