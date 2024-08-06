
// QuickSort is a sorting algorithm based on the Divide and Conquer algorithm that picks an element 
// as a pivot and partitions the given array around the picked pivot by placing the pivot in its correct position in the sorted array.

// Quick Sort Algorithm:
// Choose an element from the array and call it the "pivot". (There are multiple ways to choose the pivot element,
// the simplest way is to choose the last element of the array as the pivot element.)
// Partitioning: Rearrange the array in such a way that all elements less than the pivot are to the left of the pivot,
// and all elements greater than the pivot are to the right of the pivot.
// Recursively apply the above steps to the sub-arrays of elements with smaller values and separately to the sub-arrays of elements with greater values.
// The base case of the recursion is when the size of the sub-array is less than or equal to 1.
// The pivot element is now in its correct sorted position.
// The above steps are repeated for each sub-array until the entire array is sorted.
// The time complexity of Quick Sort is O(n log n) in the average case and O(n^2) in the worst case.

// Following is the implementation of the Quick Sort algorithm in Java:
// 1. The quickSort() method is a recursive method that takes the input array, the low index, and the high index as parameters.
// 2. The partition() method is used to rearrange the array in such a way that all elements less than the pivot are to the left of the pivot, and all elements greater than the pivot are to the right of the pivot.
// 3. The swap() method is used to swap two elements in the array.
// 4. The main() method initializes an array and calls the quickSort() method to sort the array.

public class Quick_Sort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr)
            System.out.print(i + " ");
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        // Move all elements smaller than pivot to the left of the pivot
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i++, j);
            }
        }

        // Move the pivot to its correct position in the sorted array
        swap(arr, i, high);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}