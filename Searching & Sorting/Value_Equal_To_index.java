public class Value_Equal_To_index {
    
    static int valueEqualToIndex(int arr[], int low, int high) 
    { 
        if (high >= low) { 
            int mid = low + (high - low) / 2; 
            if (mid == arr[mid]) 
                return mid; 
            int res = -1; 
            if (mid + 1 <= arr[high]) 
                res = valueEqualToIndex(arr, (mid + 1), high); 
            if (res != -1) 
                return res; 
            if (mid - 1 >= arr[low]) 
                return valueEqualToIndex(arr, low, (mid - 1)); 
        } 
  
        /* Return -1 if there is no Fixed Point */
        return -1; 
    } 

    public static void main(String args[]) {
        int arr[] = { 15, 2,45, 12, 7 };
        int arr2[] = { 1, 2,3, 3, 4, 5 };
        int n2 = arr2.length;
        int n = arr.length;
        System.out.println(valueEqualToIndex(arr,0, n-1));
        System.out.println(valueEqualToIndex(arr2,0, n2-1));
    }
}