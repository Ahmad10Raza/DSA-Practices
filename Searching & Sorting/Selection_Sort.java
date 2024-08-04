
// The algorithm repeatedly selects the smallest (or largest) element from the unsorted 
// portion of the list and swaps it with the first element of the unsorted part. 
// This process is repeated for the remaining unsorted portion until the entire list is sorted.

// Follow below steps to solve problems:
// 1. Find the smallest element in the array.
// 2. Swap the smallest element with the first element of the array.
// 3. Repeat the same process for the remaining elements of the array.

public class Selection_Sort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;// searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public static void main(String a[]) {
        int[] arr1 = { 9, 14, 3, 2, 43, 11, 58, 22 };
        System.out.println("Before Selection Sort");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();

        selectionSort(arr1);// sorting array using selection sort

        System.out.println("After Selection Sort");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }
}
