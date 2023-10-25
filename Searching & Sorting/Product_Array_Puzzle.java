import java.util.Arrays;
class Product_Array_Puzzle {
    static long[] productExceptSelf(int arr[], int n) 
    { 
        // code here
        long[] result = new long[n];
        long product = 1;
        int zeroCount = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                zeroCount++;
            }else{
                product *= arr[i];
            }
        }
        if(zeroCount > 1){
            return result;
        }
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                result[i] = product;
            }else if(zeroCount == 1){
                result[i] = 0;
            }else{
                result[i] = product / arr[i];
            }
        }
        return result;
    }

    public static int[] Product_Array(int[] nums){
        int n = nums.length;
        int[] res=new int[n];
        int productOfAllBeforeCurrent=1;
        int productOfAllAfterCurrent=1;

        for(int i=0;i<n;i++){
            res[i]=productOfAllBeforeCurrent;
            productOfAllBeforeCurrent*=nums[i];
        }
        // System.out.println(Arrays.toString(res));
        // System.out.println(Arrays.toString(res));

        for(int i=n-1;i>=0;i--){
            res[i]*=productOfAllAfterCurrent;
            productOfAllAfterCurrent*=nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 2};
        int n = arr.length;
        long[] result = productExceptSelf(arr, n);
        for(int i = 0; i < n; i++){
            System.out.print(result[i] + " ");
        }

        System.out.println();
        System.out.println(Arrays.toString(Product_Array(arr)));
    }
}