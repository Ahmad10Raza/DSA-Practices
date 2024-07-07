
// Write a code to Count Inversion

// Count Inversion: Inversion Count for an array indicates – how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0. If the array is sorted in the reverse order that the inversion count is the maximum. Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
// Input: [2, 4, 1, 3, 5]
// Output: 3
// Explanation: (2, 1), (4, 1), (4, 3) are the inversions.

// Approach: The idea is to use the merge sort technique to count the number of inversions. The inversion count will be the sum of inversions in the left subarray, right subarray, and the number of inversions formed by merging the two subarrays.
// Time Complexity: O(n log n)
// Space Complexity: O(n)

public class CountInversion {

    public static int countInversion(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int inversionCount = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            inversionCount += mergeSort(arr, low, mid);
            inversionCount += mergeSort(arr, mid + 1, high);
            inversionCount += merge(arr, low, mid, high);
        }
        return inversionCount;
    }

    public static int merge(int[] arr, int low, int mid, int high) {
        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0, k = low, inversionCount = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                inversionCount += (mid - i);
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return inversionCount;
    }

    public static void main(String[] args) {
        System.out.println(countInversion(new int[] { 2, 4, 1, 3, 5 })); // 3
    }

}
