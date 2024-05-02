

// Array: [23, 1, 10, 5, 2]
// First Pass:
// Current element is 23
// The first element in the array is assumed to be sorted.
// The sorted part until 0th index is : [23]

// Second Pass:
// Compare 1 with 23 (current element with the sorted part).
// Since 1 is smaller, insert 1 before 23.
// The sorted part until 1st index is: [1, 23]

// Third Pass:
// Compare 10 with 1 and 23 (current element with the sorted part).
// Since 10 is greater than 1 and smaller than 23, insert 10 between 1 and 23.
// The sorted part until 2nd index is: [1, 10, 23]

// Fourth Pass:
// Compare 5 with 1, 10, and 23 (current element with the sorted part).
// Since 5 is greater than 1 and smaller than 10, insert 5 between 1 and 10.
// The sorted part until 3rd index is: [1, 5, 10, 23]

// Fifth Pass:
// Compare 2 with 1, 5, 10, and 23 (current element with the sorted part).
// Since 2 is smaller than all elements in the sorted part, insert 2 at the beginning.
// The sorted part until 4th index is: [2, 1, 5, 10, 23]

// Final Array:
// The sorted array is: [2, 1, 5, 10, 23]

public class Insertion_Sort {
    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }

    public static void main(String a[]){
        int[] arr1 = {9,14,3,2,43,11,58,22};
        System.out.println("Before Insertion Sort");
        for(int i:arr1){
            System.out.print(i+" ");
        }
        System.out.println();

        insertionSort(arr1);//sorting array using insertion sort

        System.out.println("After Insertion Sort");
        for(int i:arr1){
            System.out.print(i+" ");
        }
    }    
}
