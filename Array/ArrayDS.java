import java.util.Arrays;
public class ArrayDS {
    private int[] array;
    private int size;

    public ArrayDS(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int element) {
        if (size == array.length) {
            resizeArray();
        }
        array[size] = element;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return array[index];
    }

    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        array[index] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    private void resizeArray() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    // Q_01: Reverse the array

    //Array reverse or reverse a array means changing the position of each 
    // number of the given array to its opposite position from end, 
    // i.e. if a number is at position 1 then its new position will be Array.length, 
    // similarly if a number is at position 2 then its new position will be Array.length – 1, and so on.

// Approach 1: Using a temporary array
// T.C = O(n), S.C = O(n)

// Create a temporary array of the same size as the given array.
// Traverse the given array from start to end and copy each element to the temporary array from end to start.
// Copy the elements of the temporary array back to the given array.
// Print the reversed array.

    public void reverse2() {
        int[] tempArray = new int[size];
        for (int i = 0; i < size; i++) {
            tempArray[i] = array[size - i - 1];
        }
        System.arraycopy(tempArray, 0, array, 0, size);
    }

    // Approach 2: Using Two Pointers
    // T.C = O(n), S.C = O(1)

    // Initialize two pointers, first and last, pointing to the first and last element of the array respectively.
    // Swap the elements at the first and last pointers.
    // Increment the first pointer and decrement the last pointer.
    // Repeat the above steps until the first pointer is less than the last pointer.

    public void reverse() {
        int first = 0;
        int last = size - 1;
        while (first < last) {
            int temp = array[last];
            array[last] = array[first];
            array[first] = temp;
            first++;
            last--;
        }
    }

    // Approach 3: Using Recursion

    // T.C = O(n), S.C = O(n)

    // Base Case: If the start index is greater than or equal to the end index, return.
    // Swap the elements at the start and end index.
    // Recur for the remaining elements by incrementing the start index and decrementing the end index.

    public void reverse(int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = array[end];
        array[end] = array[start];
        array[start] = temp;
        reverse(start + 1, end - 1);
    }


    // Q_02: Find the maximum and minimum element in an array
    // Input: [2, 4, 1, 6, 8, 5]
    // Output: Maximum: 8, Minimum: 1

    // Approach: Linear Search
    // T.C = O(n), S.C = O(1)

    // Initialize two variables, max and min, to store the maximum and minimum elements of the array.
    // Traverse the array from start to end.
    // If the current element is greater than the max element, update the max element.
    // If the current element is less than the min element, update the min element.
    // Print the maximum and minimum elements.

    public void findMaxMin() {
        if (size == 0) {
            System.out.println("Array is empty");
            return;
        }
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Maximum: " + max + ", Minimum: " + min);
    }


    // Q_03: Find the kth maximum and minimum element in an array
//     Given an array arr[] of size N and a number K, where K is smaller than the size of the array. 
//     Find the K’th smallest element in the given array. Given that all array elements are distinct.

// Examples:  
// Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 3 
// Output: 7
// Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 4 
// Output: 10 

// Approach: Sorting
// T.C = O(n log n), S.C = O(1)

// Sort the array in ascending order.
// Print the K’th(k-1) element of the sorted array.

    public void findKthMaxMin(int k) {
        if (size == 0) {
            System.out.println("Array is empty");
            return;
        }
        if (k > size) {
            System.out.println("K is greater than the size of the array");
            return;
        }
        Arrays.sort(array);
        System.out.println(k + "th Minimum: " + array[k - 1]);
        System.out.println(k + "th Maximum: " + array[size - k]);
    }

    // Others Approach:
    // Approach 2: Using Priority Queue
    // T.C = O(n log k), S.C = O(k)
    // Approach 3: Using Quick Select Algorithm
    // T.C = O(n), S.C = O(1)
    // Approach 4: Using Min-Max Heap
    // T.C = O(n log k), S.C = O(k)
    // Approach 5: Using Counting Sort
    // T.C = O(n + k), S.C = O(k)
    // Approach 6: Using Binary Search
    // T.C = O(n log n), S.C = O(1)



    // Q_04: Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algorithm.
    // Given an array A[] consisting of only 0s, 1s, and 2s. The task is to write a function 
    // that sorts the given array. The functions should put all 0s first, then all 1s and all 2s in last.

// Examples:
// Input: {0, 1, 2, 0, 1, 2}
// Output: {0, 0, 1, 1, 2, 2}

// Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
// Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

// Approach: Dutch National Flag Algorithm
// T.C = O(n), S.C = O(1)

// Initialize three variables low, mid, and high to 0, 0, and n-1 respectively.
// Traverse the array from start to end.
// If the current element is 0, swap the element at index low with the element at index mid and increment low and mid by 1.
// If the current element is 1, increment mid by 1.
// If the current element is 2, swap the element at index mid with the element at index high and decrement high by 1.
// Repeat the above steps until mid is less than or equal to high.


    public void sort012() {
        int low = 0;
        int mid = 0;
        int high = size - 1;

        while (mid <= high) {
            switch (array[mid]) {
                case 0:
                    swap(low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(mid, high);
                    high--;
                    break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Approach 2: Counting Sort
    // T.C = O(n), S.C = O(1)

    // Count the number of 0s, 1s, and 2s in the array.
    // Fill the array with the count of 0s, 1s, and 2s in the same order.
    // Print the sorted array.

    public void sort012Counting() {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < size; i++) {
            switch (array[i]) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
            }
        }

        int i = 0;
        while (count0 > 0) {
            array[i++] = 0;
            count0--;
        }
        while (count1 > 0) {
            array[i++] = 1;
            count1--;
        }
        while (count2 > 0) {
            array[i++] = 2;
            count2--;
        }
    }


    // Q_05: Move all the negative elements to one side of the array 

// An array contains both positive and negative numbers in random order. 
// Rearrange the array elements so that all negative numbers appear before all positive numbers.

// Examples : 
// Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
// Output: -12 -13 -5 -7 -3 -6 11 6 5

// Approach: Two-Pointer Technique
// T.C = O(n), S.C = O(1)

// Initialize two pointers, left and right, pointing to the start and end of the array respectively.
// Traverse the array from start to end.
// If the element at the left pointer is negative, increment the left pointer.
// If the element at the left pointer is positive and the element at the right pointer is negative, swap the elements at the left and right pointers and increment the left pointer and decrement the right pointer.
// If the element at the left pointer is positive and the element at the right pointer is positive, decrement the right pointer.
// Print the rearranged array.


    public void moveNegative() {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            if (array[left] < 0) {
                left++;
            } else if (array[left] > 0 && array[right] < 0) {
                swap(left, right);
                left++;
                right--;
            } else if (array[left] > 0 && array[right] > 0) {
                right--;
            }
        }
    }



    // Q_06: Find the Union and Intersection of two sorted arrays

// Given two sorted arrays, find their union and intersection.
// Example:
// Input: arr1[] = {1, 3, 4, 5, 7}
//         arr2[] = {2, 3, 5, 6} 
// Output: Union : {1, 2, 3, 4, 5, 6, 7} 
//          Intersection : {3, 5}
// Input: arr1[] = {2, 5, 6}
//         arr2[] = {4, 6, 8, 10} 
// Output: Union : {2, 4, 5, 6, 8, 10} 
//          Intersection : {6}

    // Union of Two-Sorted Arrays using Two-Pointers
// To find union of two sorted arrays using two pointers, follow the following procedure : 

// Use two index variables i and j, initial values i = 0, j = 0 
// If arr1[i] is smaller than arr2[j] then print arr1[i] and increment i. 
// If arr1[i] is greater than arr2[j] then print arr2[j] and increment j. 
// If both are same then print any of them and increment both i and j. 
// Print remaining elements of the larger array.


    public int union(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                System.out.print(array1[i] + " ");
                i++;
            } else if (array1[i] > array2[j]) {
                System.out.print(array2[j] + " ");
                j++;
            } else {
                System.out.print(array1[i] + " ");
                i++;
                j++;
            }
        }
        while (i < array1.length) {
            System.out.print(array1[i] + " ");
            i++;
        }
        while (j < array2.length) {
            System.out.print(array2[j] + " ");
            j++;
        }
        return 0;
    }


    // Intersection of Two-Sorted Arrays using Two-Pointers
//     To find intersection of two sorted arrays using two-pointers, follow the below approach : 

// Use two index variables i and j, initial values i = 0, j = 0 
// If arr1[i] is smaller than arr2[j] then increment i. 
// If arr1[i] is greater than arr2[j] then increment j. 
// If both are same then print any of them and increment both i and j.

    public int intersection(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                i++;
            } else if (array1[i] > array2[j]) {
                j++;
            } else {
                System.out.print(array1[i] + " ");
                i++;
                j++;
            }
        }
        return 0;
    }















    public static void main(String[] args) {
        ArrayDS array = new ArrayDS(5);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        // System.out.println("Size: " + array.getSize());
        // System.out.println("Capacity: " + array.getCapacity());
        // System.out.println("Is empty: " + array.isEmpty());
        // System.out.println("Element at index 2: " + array.get(2));
        // array.set(2, 10);
        // System.out.println("Element at index 2: " + array.get(2));
        // array.remove(2);
        // System.out.println("Size: " + array.getSize());
        // System.out.println("Element at index 2: " + array.get(2));

        // array.reverse();
        // array.reverse(0, array.getSize() - 1);
        // array.reverse2();
        // for (int i = 0; i < array.getSize(); i++) {
        //     System.out.print(array.get(i) + " ");
        // }


        /// array.findMaxMin();


        // array.findKthMaxMin(3);
        // array.findKthMaxMin(4);

        // int[] array1 = {0, 1, 2, 0, 1, 2};
        // int[] array2 = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        // array.sort012();
        // array.sort012Counting();
        // for (int i = 0; i < array.getSize(); i++) {
        //     System.out.print(array.get(i) + " ");
        // }

        // int[] array1 = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        // array.moveNegative();
        // for (int i = 0; i < array.getSize(); i++) {
        //     System.out.print(array.get(i) + " ");
        // }
        
        // int[] array1 = {1, 3, 4, 5, 7};
        // int[] array2 = {2, 3, 5, 6};
        // array.union(array1, array2);
        // System.out.println();
        // array.intersection(array1, array2);

    }
}