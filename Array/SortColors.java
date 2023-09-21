import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                nums[low] = nums[mid];
                nums[mid] = 0;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                nums[high] = nums[mid];
                nums[mid] = 2;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 1, 1, 0, 2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
