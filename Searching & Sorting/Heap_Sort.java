// Heap Sort Algorithm
// To solve the problem follow the below idea:

// First convert the array into heap data structure using heapify, then one by one delete the root node of the Max-heap and replace it with the last node in the heap and then heapify the root of the heap. Repeat this process until size of heap is greater than 1.

// Build a heap from the given input array.
// Repeat the following steps until the heap contains only one element:
// Swap the root element of the heap (which is the largest element) with the last element of the heap.
// Remove the last element of the heap (which is now in the correct position).
// Heapify the remaining elements of the heap.
// The sorted array is obtained by reversing the order of the elements in the input array.


// Time Complexity: O(nlogn) where n is the number of elements in the array.


import java.util.Arrays;


public class Heap_Sort {

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}