

// Exponential search is a searching algorithm that is used to find the position of a specific value in a sorted array.
// It is similar to binary search, but it finds the range where the element is present and then performs a binary search in that range.
// The time complexity of exponential search is O(log n) for the average case, O(n) for the worst case, and O(1) for the best case.
// The space complexity of exponential search is O(1).

// Exponential search works by:
// 1. Finding the range where the element is present by doubling the index starting from 1 until the element at that index is greater than the target value.
// 2. Performing a binary search in that range to find the position of the target value.

// How to find the range where the element is present in exponential search:
// 1. Initialize the index variable to 1.
// 2. Double the index value until the element at that index is greater than the target value.
// 3. Set the low index to the previous index value and the high index to the minimum of the current index value and the array length.
// 4. Perform a binary search in the range [low, high] to find the position of the target value.

// Exponential search is useful when the array is unbounded or the size of the array is unknown, as it can find the range where the element is present in logarithmic time.

// Java program to implement Exponential Search

public class ExponentialSearch {
    
    // Function to perform exponential search
    public static int exponentialSearch(int[] arr, int x) {
        int n = arr.length;
        
        // If the element is present at the first position
        if (arr[0] == x) {
            return 0;
        }
        
        // Find the range where the element is present
        int i = 1;
        while (i < n && arr[i] <= x) {
            i = i * 2;
        }
        
        // Perform binary search in the range [i/2, min(i, n)]
        return binarySearch(arr, x, i / 2, Math.min(i, n));
    }
    
    // Function to perform binary search in the range [low, high]
    public static int binarySearch(int[] arr, int x, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    // Main function to test the Exponential Search algorithm
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int x = 23;
        int index = exponentialSearch(arr, x);
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}
