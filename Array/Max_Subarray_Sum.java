public class Max_Subarray_Sum {
    public static void Subarray_Sum(int nums[]){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int start=i;
            for(int j=i;j<nums.length;j++){
                int end=j;
                currSum=0;
                for(int k=start;k<=end;k++){
                    currSum += nums[k];
                }
            }
            System.out.println(currSum);
            if(maxSum<currSum){
                maxSum=currSum;
            }
        }
        System.out.println("The Maximum Sum is :" + maxSum);
    }
    public static void main(String[] args) {
        int nums[]={2,4,6,8,10};
        Subarray_Sum(nums);
    }
}
