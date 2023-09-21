public class Reverse_Array {
    public static void reverse(int nums[]){
        int first=0,last=nums.length-1;
        if(first<last){
            int temp=nums[last];
            nums[last]=nums[first];
            nums[first]=temp;
        }
    }
    public static void main(String[] args) {
        int nums[]={2,4,5,6,10};
        reverse(nums);
        for(int i=0;i<nums.length;i++){
        System.out.print(nums[i]);
        }
    }
}
