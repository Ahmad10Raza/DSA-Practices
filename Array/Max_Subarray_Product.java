public class Max_Subarray_Product {
    public static int Subarray_Product(int nums[]){
        if (nums.length == 0){
                     return 0;
        }
                   int max_so_far = nums[0]; // 2
                int min_so_far = nums[0]; // 2
                int result = max_so_far; // 2
            for (int i = 1; i < nums.length; i++) {
                int curr = nums[i]; // 3
                int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
                min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));
            
            max_so_far = temp_max;
            result = Math.max(max_so_far, result);
        }
            return result;
    }

    public static void main(String[] args) {
        int nums[]={2,3,-2,4};
        System.out.println("Maximu Product:" + Subarray_Product(nums));
    }
}
