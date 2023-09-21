public class Print_Subarray {
    public static void Subarray(int nums[]){
        for(int i=0;i<nums.length;i++){
            int start=i;
            for(int j=i;j<nums.length;j++){
                int end=j;
                for(int k=start;k<=end;k++){
                    System.out.print(nums[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int nums[]={1,2,3,4};
        Subarray(nums);
    }
}
