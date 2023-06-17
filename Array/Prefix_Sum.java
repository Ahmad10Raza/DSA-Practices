public class Prefix_Sum {
    public static void Prefix__Sum(int nums[]){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        int prefixSum[]=new int[nums.length];
        prefixSum[0]=nums[0];

        //calculate the prefix sum
        for(int i=1;i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            int start=i;
            for(int j=i;j<nums.length;j++){
                int end=j;
                
                if(start>0){
                    currSum=prefixSum[end]-prefixSum[start-1];
                }
                else{
                    currSum=prefixSum[end];
                }
            }
            if(maxSum<currSum){
                maxSum=currSum;
            }
        }
        System.out.println("The Maximum Sum is :" + maxSum);
    }
    public static void main(String[] args) {
        int nums[]={1,-2,6,-1,3};
        Prefix__Sum(nums);
    }
}
