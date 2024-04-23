//import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
// import java.util.Iterator;
import java.util.Set;
//import java.util.Iterator;
import java.util.Map;
import java.util.Iterator;



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



    // Q_07: Write a program to cyclically rotate an array by one.

    // Given an array, the task is to cyclically rotate the array clockwise by one time.
    // Examples:  
    // Input: arr[] = {1, 2, 3, 4, 5}
    // Output: arr[] = {5, 1, 2, 3, 4} 
    // Input: arr[] = {2, 3, 4, 5, 1}
    // Output: {1, 2, 3, 4, 5}

    // Approach: Using a Temporary Variable
    // T.C = O(n), S.C = O(1)

    // Store the last element of the array in a temporary variable.
    // Shift all the elements of the array to the right by one position.
    // Store the temporary variable in the first position of the array.

    public void rotateArray() {
        if (size == 0) {
            System.out.println("Array is empty");
            return;
        }
        int temp = array[size - 1];
        for (int i = size - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = temp;
    }


    // Approach 2: Using Two Pointers
    // T.C = O(n), S.C = O(1)

    /// Follow the steps to solve the problem:

    // Take two pointers i and j which point to first and last element of array respectively.
    // Start swapping arr[i] and arr[j] and keep j fixed and i moving towards j.
    // Repeat above step till i is not equal to j.

    public void rotateArray2() {
        if (size == 0) {
            System.out.println("Array is empty");
            return;
        }
        int i = 0;
        int j = size - 1;
        while (i != j) {
            swap(i, j);
            i++;
        }
    }



    // Q_08: find Largest sum contiguous Subarray [V. IMP]((Kadane’s Algorithm))

    // Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum.
    // Examples:
    // Input: [-2, -3, 4, -1, -2, 1, 5, -3]
    // Output: 7
    // Explanation: The contiguous subarray [4, -1, -2, 1, 5] has the largest sum = 7.

    // Approach: Kadane’s Algorithm
    // T.C = O(n), S.C = O(1)

    // Initialize two variables, maxSum and currentSum, to store the maximum sum of the subarray and the sum of the current subarray.
    // Traverse the array from start to end.
    // Update the currentSum by adding the current element to it.
    // If the currentSum is less than 0, update the currentSum to 0.
    // If the currentSum is greater than the maxSum, update the maxSum to the currentSum.
    // Print the maxSum.


    public int largestSumContiguousSubarray(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    // Approach 2: Using Dynamic Programming
    // T.C = O(n), S.C = O(n)

    // Create an array dp[] of the same size as the given array to store the maximum sum of the subarray ending at the current index.
    // Initialize the first element of the dp[] array to the first element of the given array.
    // Traverse the array from the second element to the end.
    // Update the dp[i] to the maximum of dp[i-1] + arr[i] and arr[i].
    // Print the maximum element of the dp[] array.

    public int largestSumContiguousSubarray2(int arr[]) {
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        int maxSum = dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
    


    // Q_09: Minimise the maximum difference between heights [V.IMP]
//     Given the heights of N towers and a value of K, Either increase or decrease the 
//     height of every tower by K (only once) where K > 0. After modifications, 
//     the task is to minimize the difference between the heights of the longest 
//     and the shortest tower and output its difference.

// Examples: 
// Input: arr[] = {1, 15, 10}, k = 6
// Output:  Maximum difference is 5.
// Explanation: Change 1 to 7, 15 to 9 and 10 to 4. Maximum difference is 5 (between 4 and 9). We can’t get a lower difference.
// Input: arr[] = {1, 5, 15, 10}, k = 3   
// Output: Maximum difference is 8, arr[] = {4, 8, 12, 7}

// Approach: Sorting
// T.C = O(n log n), S.C = O(1)

// Sort the array in ascending order.
// Initialize two variables, smallest and largest, to store the smallest and largest elements of the array. 
// Initialize a variable, result, to store the difference between the largest and smallest elements.
// Traverse the array from start to end.
// Update the smallest element by adding K and the largest element by subtracting K.
// Update the result to the minimum of the current result and the difference between the updated largest and smallest elements.
// Print the result.

    // User function Template for Java
    public  int getMinDiff(int[] arr, int n, int k)
    {
 
        Arrays.sort(arr);
        // Maximum possible height difference
        int ans = arr[n - 1] - arr[0];
 
        int tempmin, tempmax;
        tempmin = arr[0];
        tempmax = arr[n - 1];
 
        for (int i = 1; i < n; i++) {
 
            // if on subtracting k we got negative then
            // continue
            if (arr[i] - k < 0)
                continue;
 
            // Minimum element when we add k to whole array
            tempmin = Math.min(arr[0] + k, arr[i] - k);
 
            // Maximum element when we subtract k from whole
            // array
            tempmax = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            ans = Math.min(ans, tempmax - tempmin);
        }
        return ans;
    }


    // Q_10: Minimum number of Jumps to reach end of an array
//     Given an array arr[] where each element represents the max number of steps 
//     that can be made forward from that index. The task is to find the minimum 
//     number of jumps to reach the end of the array starting from index 0.

// Examples: 
// Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
// Output: 3 (1-> 3 -> 9 -> 9)
// Explanation: Jump from 1st element to 2nd element as there is only 1 step.
// Now there are three options 5, 8 or 9. If 8 or 9 is chosen then the end node 9 can be reached. So 3 jumps are made.

// Input:  arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
// Output: 10
// Explanation: In every step a jump is needed so the count of jumps is 10.


    // Approach: Greedy Algorithm
    // T.C = O(n), S.C = O(1)

    // Initialize three variables, maxReach, steps, and jumps, to store the maximum reachable index, 
        // the number of steps that can be taken from the current index, and the number of jumps made so far.
    // Traverse the array from start to end.
    // Update the maxReach to the maximum of maxReach and the sum of the current index and the 
        //number of steps that can be taken from the current index.
    // Decrement the steps by 1.
    // If steps becomes 0, increment the jumps by 1 and update the steps to the difference between 
        //the current index and maxReach.
    // Print the number of jumps.

    public int minJumps(int[] arr) {
        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) {
                return jumps;
            }
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i >= maxReach) {
                    return -1;
                }
                steps = maxReach - i;
            }
        }
        return -1;
    }


    // Approach 2: Dynamic Programming

    // Create an array dp[] of the same size as the given array to store the minimum number of
        // jumps required to reach the end of the array starting from the current index.
    // Initialize the first element of the dp[] array to 0.
    // Traverse the array from the second element to the end.
    // Initialize the current element of the dp[] array to a large value.
    // Traverse the array from the start to the current index.
    // If the current element is greater than or equal to the difference between the current
        //  index and the start index, update the current element of the dp[] array to the minimum of the current element and the sum of the element at the start index and 1.
    // Print the last element of the dp[] array.
    
    public int minJumpsDP(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j] && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
        }
        return dp[n - 1];
    }



    // Q_11: Find duplicate in an array of N+1 Integers
    // Given a constant array of n elements which contains elements from 1 to n-1, 
    // with any of these numbers appearing any number of times. Find any one of these 
    // repeating numbers in O(n) and using only constant memory space.

    // Examples: 
    // Input : arr[] = {1, 2, 3, 4, 5, 6, 3}
    // Output : 3

    // Approach: Floyd’s Cycle Detection Algorithm
    // T.C = O(n), S.C = O(1)

    // Initialize two variables, slow and fast, to store the current index.
    // Traverse the array from the first element.
    // Update the slow variable to the element at the current index.
    // Update the fast variable to the element at the element at the element at the current index.
    // If the slow and fast variables are equal, break the loop.
    // Initialize the slow variable to the first element.
    // Traverse the array from the first element.
    // Update the slow variable to the element at the current index.
    // Update the fast variable to the element at the current index.
    // If the slow and fast variables are equal, return the slow variable.

    public int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }


    // Approach 2: We will use the concept that all elements here are between 1 and n-1.

// So we will perform these steps to find the Duplicate element

// Consider a pointer ‘p’ which is currently at index 0.
// Run a while loop until the pointer p reaches the value n.
// if the value of a[p] is -1 then increment the pointer by 1 and skip the iteration 
// Else,go to the position of the element to which the current pointer is pointing i.e. at index a[p].
// Now if the value at index a[p] i.e. a[a[p]] is -1 then break the loop as the element a[p] is the duplicate one.
// Otherwise store the value of a[a[p]] in a[p] i.e. a[p]=a[a[p]] and put -1 in a[a[p]] i.e. a[a[p]]=-1.

    public void find_duplicate(int a[], int n)
    {
        int p = 0;
        while (p != n) {
            if (a[p] == -1) {
                p++;
            }
            else {
                if (a[a[p] - 1] == -1) {
                    System.out.println(a[p]);
                    break;
                }
                else {
                    a[p] = a[a[p] - 1];
                    a[a[p] - 1] = -1;
                }
            }
        }
    }



    // Q_12: Merge two sorted arrays with O(1) extra space
    // We are given two sorted arrays. We need to merge these 
    // two arrays such that the initial numbers (after complete sorting) 
    // are in the first array and the remaining numbers are in the second array

    // Examples: 
    // Input: ar1[] = {10}, ar2[] = {2, 3}
    // Output: ar1[] = {2}, ar2[] = {3, 10}    
    // Input: ar1[] = {1, 5, 9, 10, 15, 20}, ar2[] = {2, 3, 8, 13}
    // Output: ar1[] = {1, 2, 3, 5, 8, 9}, ar2[] = {10, 13, 15, 20}
    
    // Approach: Gap Algorithm
    // T.C = O((n+m) log(n+m)), S.C = O(1)

    // Initialize a variable, gap, to store the sum of the sizes of the two arrays.
    // Initialize two variables, i and j, to store the starting indices of the two arrays.
    // Initialize a variable, temp, to store the temporary value.
    // Run a while loop until the gap is greater than 0.
    // Traverse the first array from start to end.  
    // If the current element is greater than the element at the index gap, swap the elements.
    // Traverse the second array from the minimum of the current index and the gap to the end.
    // If the current element is greater than the element at the index gap, swap the elements.
    // Update the gap to the ceiling value of the gap divided by 2.
    // Print the first and second arrays.

    public void merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int gap = (n + m + 1) / 2;
        int i, j;
        while (gap > 0) {
            for (i = 0; i + gap < n; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
            }
            for (j = gap > n ? gap - n : 0; i < n && j < m; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
            if (j < m) {
                for (j = 0; j + gap < m; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
                }
            }
            gap = gap == 1 ? 0 : (gap + 1) / 2;
        }
    }


    // Approach 2: To solve the problem follow the below idea:

// We can compare the last element of array one with first element of 
// array two and if the last element is greater than first element the 
// swap the elements and sort the second array as the elements of first array should be less than or equal to elements in second array. Repeating this process while this condition holds true will give us two sorted arrays 

// Follow the below steps to solve the problem:

// Initialize i with 0
// Iterate while loop until the last element of array 1 is greater than the first element of array 2
// if arr1[i] greater than first element of arr2
// swap arr1[i] with arr2[0]
// sort arr2
// Incrementing i by 1
// Print the arrays

    public void merge(int[] arr1, int[] arr2, int n, int m)
    {
        int i = 0;
        int temp = 0;
 
        // While loop till last element
        // of array 1(sorted)
        // is greater than first element
        // of array 2(sorted)
        while (arr1[n - 1] > arr2[0]) {
            if (arr1[i] > arr2[0]) {
 
                // Swap arr1[i] with first element
                // of arr2 and sorting the updated
                // arr2(arr1 is already sorted)
                // swap(arr1[i],arr2[0]);
                temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
                Arrays.sort(arr2);
            }
            i++;
        }
    }


    // Q_13: Merge Overlapping Intervals
    // Given a set of time intervals in any order, our task is to merge all overlapping
    // intervals into one and output the result which should have only mutually exclusive intervals.

    // Example:  
    // Input: Intervals = {{1,3},{2,4},{6,8},{9,10}}
    // Output: {{1, 4}, {6, 8}, {9, 10}}
    // Explanation: Given intervals: [1,3],[2,4],[6,8],[9,10], we have only two overlapping 
    // intervals here,[1,3] and [2,4]. Therefore we will merge these two and return [1,4],[6,8], [9,10]. 
    // Input: Intervals = {{6,8},{1,9},{2,4},{4,7}}
    // Output: {{1, 9}} 

    // Approach: Sorting
    // T.C = O(n log n), S.C = O(n)

//     To solve this problem optimally we have to first sort the intervals according to 
//     the starting time. Once we have the sorted intervals, we can combine all intervals 
//     in a linear traversal. The idea is, in sorted array of intervals, if interval[i] 
//     doesn’t overlap with interval[i-1], then interval[i+1] cannot overlap with interval[i-1] 
//     because starting time of interval[i+1] must be greater than or equal to interval[i].

// Follow the steps mentioned below to implement the approach:

// Sort the intervals based on the increasing order of starting time.
// Push the first interval into a stack.
// For each interval do the following:
// If the current interval does not overlap with the top of the stack then, push the current interval into the stack.
// If the current interval overlap with the top of the stack then, update the stack top with the ending time of the current interval.
// The end stack contains the merged intervals. 


class Interval {
    int start, end;
    Interval(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}
        // The main function that takes a set of intervals,
    // merges overlapping intervals and prints the result
    public  void mergeIntervals(Interval arr[])
    {
        // Test if the given set has at least one interval
        if (arr.length <= 0)
            return;
 
        // Create an empty stack of intervals
        Stack<Interval> stack = new Stack<>();
 
        // sort the intervals in increasing order of start
        // time
        Arrays.sort(arr, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2)
            {
                return i1.start - i2.start;
            }
        });
 
        // push the first interval to stack
        stack.push(arr[0]);
 
        // Start from the next interval and merge if
        // necessary
        for (int i = 1; i < arr.length; i++) {
            // get interval from stack top
            Interval top = stack.peek();
 
            // if current interval is not overlapping with
            // stack top, push it to the stack
            if (top.end < arr[i].start)
                stack.push(arr[i]);
 
            // Otherwise update the ending time of top if
            // ending of current interval is more
            else if (top.end < arr[i].end) {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }
 
        // Print contents of stack
        System.out.print("The Merged Intervals are: ");
        while (!stack.isEmpty()) {
            Interval t = stack.pop();
            System.out.print("[" + t.start + "," + t.end
                             + "] ");
        }
    }


    // Approach 2: Sorting and Merging In Space Efficient Way
    // T.C = O(n log n), S.C = O(1)

    // Sort the intervals based on the increasing order of starting time.
    // Initialize a variable, index, to store the index of the current interval.
    // Traverse the intervals from the second interval to the end.
    // If the current interval does not overlap with the previous interval, 
        // increment the index and update the interval at the index to the current interval.
    // If the current interval overlaps with the previous interval, update the ending time of the
        // interval at the index to the maximum of the ending time of the interval at the index and the ending time of the current interval.
    // Print the intervals from the first interval to the index.

    public void mergeIntervalsOptimized(Interval arr[]) {
        if (arr.length <= 0) {
            return;
        }
        Arrays.sort(arr, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[index].end < arr[i].start) {
                index++;
                arr[index] = arr[i];
            } else {
                arr[index].end = Math.max(arr[index].end, arr[i].end);
            }
        }
        for (int i = 0; i <= index; i++) {
            System.out.print("[" + arr[i].start + "," + arr[i].end + "] ");
        }
    }


    // Q_14: Optimal Strategy For A Game
    // You are given an array arr of size n. The elements of the array represent n 
    // coin of values v1, v2, ....vn. You play against an opponent in an alternating way.
    // In each turn, a player selects either the first or last coin from the row, 
    // removes it from the row permanently, and receives the value of the coin.
    // You need to determine the maximum possible amount of money you can win if you go first.
    // Note: Both the players are playing optimally.   
    // Example 1: 
    // Input:
    // n = 4
    // arr[] = {5, 3, 7, 10}
    // Output: 15
    // Explanation: The user collects maximum
    // value as 15(10 + 5). It is guarantee that we cannot get more than 15 by any possible moves.

    // Approach: Dynamic Programming

    // Create a 2D array dp[][] of size n x n to store the maximum possible amount of money that can be won by the first player.
    // Initialize the diagonal elements of the dp[][] array to the values of the coins.
    // Traverse the array from the second diagonal to the first diagonal.
    // For each element dp[i][j], update it to the maximum of the sum of the value of the coin at 
        //the ith index and the minimum of the value of the coin at the (i+2)th index and the value 
        //  of the coin at the jth index and the sum of the value of the coin at the (i+1)th index and 
        // the minimum of the value of the coin at the (i+1)th index and the value of the coin at the (j-1)th index.
    // Print the value of dp[0][n-1].


    public int optimalStrategy(int arr[], int n) {
        int dp[][] = new int[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                int x = ((i + 2) <= j) ? dp[i + 2][j] : 0;
                int y = ((i + 1) <= (j - 1)) ? dp[i + 1][j - 1] : 0;
                int z = (i <= (j - 2)) ? dp[i][j - 2] : 0;
                dp[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
            }
        }
        return dp[0][n - 1];
    }

    // Approach 2: Recursive Approach

    // Create a recursive function, solve(arr, i, j), to find the maximum possible amount of money that can be won by the first player.
    // If the starting index is greater than or equal to the ending index, return 0.
    // If the value of the coin at the starting index is greater than the value of the coin at the ending index, 
        // return the maximum of the sum of the value of the coin at the starting index and the result of the recursive function 
        // called with the starting index incremented by 1 and the ending index, and the sum of the value of the coin at the 
        // starting index and the result of the recursive function called with the starting index and the ending index decremented by 1.
    // If the value of the coin at the starting index is less than or equal to the value of the coin at the ending index,
        // return the maximum of the sum of the value of the coin at the ending index and the result of the recursive function 
        // called with the starting index incremented by 1 and the ending index decremented by 1, and the sum of the value of the 
        // coin at the starting index and the result of the recursive function called with the starting index and the ending index decremented by 1.

    public int solve(int arr[], int i, int j) {
        if (i >= j) {
            return 0;
        }
        int x = arr[i] + Math.min(solve(arr, i + 2, j), solve(arr, i + 1, j - 1));
        int y = arr[j] + Math.min(solve(arr, i + 1, j - 1), solve(arr, i, j - 2));
        return Math.max(x, y);
    }


    // Q_15: Next Permutation
//     Given an array arr[] of size N, the task is to print the lexicographically 
//     next greater permutation of the given array. If there does not exist any greater 
//     permutation, then print the lexicographically smallest permutation of the given array.

// Examples:

// Input: N = 6, arr = {1, 2, 3, 6, 5, 4}
// Output: {1, 2, 4, 3, 5, 6}
// Explanation: The next permutation of the given array is {1, 2, 4, 3, 5, 6}.

// Input: N = 3, arr = {3, 2, 1}
// Output: {1, 2, 3}
// Explanation: As arr[] is the last permutation. 
// So, the next permutation is the lowest one.

    // Approach: Two-Pointer Approach
    // T.C = O(n), S.C = O(1)

    // Initialize two variables, i and j, to store the indices of the elements to be swapped.
    // Traverse the array from the second last element to the first element.
    // Find point of change i.e. the element at the index i such that the element at the 
        // index i is less than the element at the index i+1.(First deacreasing sequence)
    // Find number to be swapped with i.e. the element at the index j such that the element 
        // at the index j is greater than the element at the index i.(Just first greater element than i)
    // Swap the elements at the indices i and j.
    // Reverse/Sort rest of the array from the index i+1 to the end.
    // Print the array.

    public void nextPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = arr.length - 1;
            while (j >= 0 && arr[j] <= arr[i]) {
                j--;
            }
            swap2(i, j, arr);
        }
        reverse2(i + 1, arr.length - 1, arr);
    }

    public void swap2(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse2(int i, int j, int[] arr) {
        while (i < j) {
            swap2(i, j, arr);
            i++;
            j--;
        }
    }



    // Q_16: Count Inversions
    // Inversion Count for an array indicates – how far (or close) the array is 
    // from being sorted. If the array is already sorted, then the inversion count is 0, 
    // but if the array is sorted in reverse order, the inversion count is the maximum. 

    // Given an array arr[]. The task is to find the inversion count of arr[]. 
    // Where two elements arr[i] and arr[j] form an inversion if a[i] > a[j] and i < j.
    
    // Examples: 
    
    // Input: arr[] = {8, 4, 2, 1}
    // Output: 6
    // Explanation: Given array has six inversions: (8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).  


    // Approach: Merge Sort
    // T.C = O(n log n), S.C = O(n)

    // Create a recursive function, mergeSortAndCount(arr, l, r), to find the inversion count of the array.
    // If the left index is greater than or equal to the right index, return 0.
    // Initialize a variable, count, to store the inversion count.
    // Calculate the middle index, m, as the sum of the left and right indices divided by 2.
    // Recursively call the mergeSortAndCount function with the left index and the middle index and add the result to the count.
    // Recursively call the mergeSortAndCount function with the middle index + 1 and the right index and add the result to the count.
    // Merge the two sorted halves of the array and add the number of inversions to the count.
    // Return the count.

    public int mergeSortAndCount(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = l + (r - l) / 2;
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }

    public int mergeAndCount(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + 1 + i];
        }
        int i = 0, j = 0, k = l, swaps = 0;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
        return swaps;
    }


    // Q_17: find all pairs on integer array whose sum is equal to given number
    // Given an array of N integers, and an integer K, the task is to find the number 
    // of pairs of integers in the array whose sum is equal to K.

    // Examples:  
    // Input: arr[] = {1, 5, 7, -1}, K = 6
    // Output:  2
    // Explanation: Pairs with sum 6 are (1, 5) and (7, -1).   
    // Input: arr[] = {1, 5, 7, -1, 5}, K = 6
    // Output:  3
    // Explanation: Pairs with sum 6 are (1, 5), (7, -1) & (1, 5).    

    // Approach: Hashing
    // T.C = O(n), S.C = O(n)

    // Initialize a variable, count, to store the number of pairs.
    // Initialize a HashMap, map, to store the frequency of the elements in the array.
    // Traverse the array from start to end.
    // If the element K minus the current element is present in the map and the frequency of the 
        // element K minus the current element is greater than 0, increment the count by 
        // the frequency of the element K minus the current element.
    // Increment the frequency of the current element in the map.
    // Print the count.

    public int getPairsCount(int[] arr, int n, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // Check if pairs exist in map
            if (map.containsKey(k - arr[i])) {
                count += map.get(k - arr[i]);
            }
            // If element is present in map, increment the count by the frequency of the element
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        return count;
    }

    // Approach 2: Binary Search 
    // T.C = O(n log n), S.C = O(1)

    // Follow the steps below to solve the given problem:

    // Sort the array arr[] in increasing order.
    // Loop from i = 0 to N-1.
    // Find the index of the first element having value same or just greater than (K – arr[i]) using lower bound.
    // Find the index of the first element having value just greater than (K – arr[i]) using upper bound.
    // The gap between these two indices is the number of elements with value same as (K – arr[i]).
    // Add this with the final count of pairs.
    // Return the final count after the iteration is over.
    
        // lowerBound implementation
  public static int lowerBound(int[] arr, int start,
                               int end, int key)
  {
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] < key) {
        start = mid + 1;
      }
      else {
        end = mid;
      }
    }
    return start;
  }
 
  // upperBound implementation
  public static int upperBound(int[] arr, int start,
                               int end, int key)
  {
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] <= key) {
        start = mid + 1;
      }
      else {
        end = mid;
      }
    }
    return start;
  }
 
  // Function to find the count of pairs
  public static int getPairsCount2(int[] arr, int n, int k)
  {
    Arrays.sort(arr);
    int c = 0;
    for (int i = 0; i < n - 1; i++) {
      int x = k - arr[i];
      int y = lowerBound(arr, i + 1, n, x);
      int z = upperBound(arr, i + 1, n, x);
      c = c + z - y;
    }
    return c;
  }


    // Q_18: find common elements In 3 sorted arrays
    // Given three Sorted arrays in non-decreasing order, print all common elements in these arrays.

    // Examples:   
    // Input: 
    // ar1[] = {1, 5, 10, 20, 40, 80} 
    // ar2[] = {6, 7, 20, 80, 100} 
    // ar3[] = {3, 4, 15, 20, 30, 70, 80, 120} 
    // Output: 20, 80
    
    // Input: 
    // ar1[] = {1, 5, 5} 
    // ar2[] = {3, 4, 5, 5, 10} 
    // ar3[] = {5, 5, 10, 20} 
    // Output: 5, 5 

    // Approach: Three-Pointer Approach
    // T.C = O(n1 + n2 + n3), S.C = O(1)

    // It is known that the arrays are sorted in a non-decreasing order. When a 
        // common integer has been found, we want to move forward in each array in
        // search of another common integer. Otherwise, the smaller integer among the three must not be common.

    // The reason for this is that at least one of the other integers is a larger integer, 
    // and as we move forward in the array, we only encounter larger integers. 
    // In this case, we want to proceed with only the array that contains the smaller integer.
    
    // Create and initialize three variables i, j, and k with 0, it will point to the indices of the arrays.
    // Repeat the following steps until we reach the end of any one of the arrays:
        // Check whether the integers appointed by i, j, and k are equal or not.
        // If they are equal, print any of the integers and increase i, j, and k by 1.
        // Otherwise, increase the index that points to the smaller integer by 1.

    public  void findCommon(int ar1[], int ar2[], int ar3[])
    {
        // Initialize starting indexes for ar1[], ar2[] and
        // ar3[]
        int i = 0, j = 0, k = 0;
 
        // Iterate through three arrays while all arrays
        // have elements
        while (i < ar1.length && j < ar2.length
               && k < ar3.length) {
            // If x = y and y = z, print any of them and
            // move ahead in all arrays
            if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                System.out.print(ar1[i] + " ");
                i++;
                j++;
                k++;
            }
 
            // x < y
            else if (ar1[i] < ar2[j])
                i++;
 
            // y < z
            else if (ar2[j] < ar3[k])
                j++;
 
            // We reach here when x > y and z < y, i.e., z
            // is smallest
            else
                k++;
        }
    }


    // Approach 2: Using Two-Pointer Approach
    // T.C = O(n1 + n2 + n3), S.C = O(1)

    // A simple solution is to first find the intersection of two arrays and store 
    // the intersection in a temporary array, then find the intersection of the third array and temporary array. 

    // Initialize both pointers i and j to 0, and an empty list common.
    // While both pointers i and j are within the bounds of the two arrays:
    // If arr1[i] is less than arr2[j], increment i by 1.
    // If arr2[j] is less than arr1[i], increment j by 1.
    // If arr1[i] is equal to arr2[j]:
    // Add arr1[i] to the common list.
    // Increment both i and j by 1.
    // Return the common list containing the common elements of the two arrays.
    
     // Function to find the intersection of two arrays
    public void findIntersection(int[] arr1, int[] arr2,int[] temp, int m, int n,int[] k)
    {
        int i = 0, j = 0;
        // Loop to find the intersection of arr1[] and
        // arr2[]
        while (i < m && j < n) {
            // ith element can't be a common element
            if (arr1[i] < arr2[j]) {
                i++;
            }
            // jth element can't be a common element
            else if (arr2[j] < arr1[i]) {
                j++;
            }
            // if arr1[i] == arr2[j]
            else {
                temp[k[0]] = arr1[i];
                i++;
                j++;
                k[0]++;
            }
        }
    }


    // Q_19: Rearrange the array in alternating positive and negative items with O(1) extra space
    // Given an array having positive and negative numbers, our task is to arrange them in an alternate 
    // fashion such that every positive number is followed by a negative number and vice-versa maintaining 
    // the order of appearance. The number of positive and negative numbers need not to be equal. 
    // If there are more positive numbers then they have to appear at the end of the array , same condition for negative numbers also .

    // Examples:   
    // Input:  arr[] = {1, 2, 3, -4, -1, 4}
    // Output: arr[] = {-4, 1, -1, 2, 3, 4}
    
    // Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
    // Output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}

    // Approach: Two-Pointer Approach
    // T.C = O(n), S.C = O(1)

    // Initialize two variables, i and j((arr.length-1)), to store the indices of the elements to be swapped.
    // Traverse the array from the start to the end.
    // If i is negative, increment i by 1 and swap to j or if j is positive increment j by one and swap otherwise increment i and j one by one.
    // Now first half have positive and second half have negative elements.
    // Inilize pointer k to 0 and swap the elements at the index k and j or i.
    // Find the index of the first positive element after the current element.
    // If the index is found, swap the elements at the current index and the index found.   
    // increment k by 2.
    // Print the array.
    public void rearrangePosNeg(int arr[], int n)
    {
        int i = 0, j = n - 1;
 
        // shift all negative values to the end
        while (i < j) {
            while (i <= n - 1 && arr[i] > 0)
                i += 1;
            while (j >= 0 && arr[j] < 0)
                j -= 1;
            if (i < j)
                swap3(arr, i, j);
        }
 
        // i has index of leftmost negative element
        if (i == 0 || i == n)
            return;
 
        // start with first positive
        // element at index 0
 
        // Rearrange array in alternating positive &
        // negative items
        int k = 0;
        while (k < n && i < n) {
            // swap next positive element
            // at even position
            // from next negative element.
            swap3(arr, k, i);
            i = i + 1;
            k = k + 2;
        }
    }

    static void swap3(int arr[], int index1, int index2)
    {
        int c = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = c;
    }
 


    // Q_20: Find if there is any subarray with sum equal to 0
    // Given an array of positive and negative numbers, the task is to find if there 
    // is a subarray (of size at least one) with 0 sum.

    // Examples:  
    // Input: {4, 2, -3, 1, 6}
    // Output: true 
    // Explanation:
    // There is a subarray with zero sum from index 1 to 3.
    
    // Input: {4, 2, 0, 1, 6}
    // Output: true
    // Explanation: The third element is zero. A single element is also a sub-array.


    // Approach: Hashing
    // T.C = O(n), S.C = O(n)

    // Initialize a variable, sum, to store the sum of the elements.
    // Initialize a HashSet, set, to store the prefix sum of the elements.
    // Traverse the array from start to end.
    // If the sum is equal to 0 or the sum is already present in the set, return true.
    // Add the sum to the set.
    // Print false.

    public boolean subArrayExists(int arr[], int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0 || set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }
    
    
    
    // Q_21: Find factorial of a large number
    // Given an integer N, the task is to find the factorial of the number.

    // Examples:
    // Input: N = 10
    // Output: 3628800

    // Input: N = 100
    // Output: 933262154439441526816992388562667004907159682
                // 6438162146859296389521759999322991560894146397615651828
                // 6253697920827223758251185210916864000000000000000000000000


    // Approach: Array Implementation
    // T.C = O(n), S.C = O(n)

    // Create an array, res[], of size 5000 to store the result.
    // Initialize the result with 1 and the size of the result with 1.  
    // Traverse the array from 2 to N.
    // To store single digit in each cell use modulo 10 and rest of digit as carry.
        // 
    // Multiply the current element with the result and update the result.
    // Print the result.

    public void factorial(int N) {
        int res[] = new int[5000];
        res[0] = 1;
        int res_size = 1;
        for (int x = 2; x <= N; x++) {
            res_size = multiply(x, res, res_size);
        }
        for (int i = res_size - 1; i >= 0; i--) {
            System.out.print(res[i]);
        }
    }

    public int multiply(int x, int res[], int res_size) {
        int carry = 0;
        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10;
            carry = prod / 10;
        }
        // Put carry in res and increase result size
        while (carry != 0) {
            // increase result size
            res[res_size] = carry % 10;
            // make carry 0
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }


    // Approach 2: LinkedList Implementation
    // T.C = O(n), S.C = O(n)

    // Create a LinkedList, res, to store the result.
    // Add 1 to the LinkedList.
    // Traverse the array from 2 to N.
    // Initialize a variable, carry, to store the carry.
    // Traverse the LinkedList from the start to the end.
    // Multiply the current element with the current number and add the carry.
    // Update the current element with the modulo 10 of the product.
    // Update the carry with the division of the product by 10.
    // If the carry is not equal to 0, add the carry to the LinkedList.
    // Print the LinkedList.

    public class Node {
        public Node prev;
        public int data;

        
            Node(int data) {
                this.data = data;
                this.prev = null;
            }
        }
        
    

    public  void Multiply(Node head, int i) {
        Node temp = head;
        Node prevPtr = head; // Temp variable for keeping head
        int carry = 0;
 
        //* Perform operation until temp becomes null
        while (temp != null) {
            int prod = temp.data * i + carry;
            temp.data = prod % 10; //* Stores the last digit
            carry = prod / 10;
            prevPtr = temp; //* Change Links
            temp = temp.prev; //* Moving temp to next node
        }
 
        //* If carry is greater than 0 then we create new nodes
        //* to store remaining digits.
        while (carry != 0) {
            prevPtr.prev = new Node( (carry % 10));
            carry /= 10;
            prevPtr = prevPtr.prev;
        }
    }
 
    //* Using head recursion to print the linked list's data in reverse
    public  void print(Node head) {
        if (head == null)
            return;
        print(head.prev);
        System.out.print(head.data); // Print linked list in reverse order
    }



    // Q_22: Find longest coinsecutive subsequence
    // Given an array of integers, find the length of the longest sub-sequence 
    // such that elements in the subsequence are consecutive integers, 
    // the consecutive numbers can be in any order. 

    // Examples:      
    // Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
    // Output: 4
    // Explanation: The subsequence 1, 3, 4, 2 is the longest subsequence of consecutive elements    
    // Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
    // Output: 5
    // Explanation: The subsequence 36, 35, 33, 34, 32 is the longest subsequence of consecutive elements.
    
    // Approach: Hashing
    // T.C = O(n), S.C = O(n)

    // Follow the steps below to solve the problem:

    // Create an empty hash.
    // Insert all array elements to hash.
    // Do the following for every element arr[i]
    // Check if this element is the starting point of a subsequence. To check this, 
    //     simply look for arr[i] – 1 in the hash, if not found, then this is the first element of a subsequence.
    // If this element is the first element, then count the number of elements in the 
    //     consecutive starting with this element. Iterate from arr[i] + 1 till the last element that can be found.
    // If the count is more than the previous longest subsequence found, then update this.
    

     // consecutive subsequence
     public int findLongestConseqSubseq(int arr[], int n)
     {
         HashSet<Integer> S = new HashSet<Integer>();
         int ans = 0;
 
         // Hash all the array elements
         for (int i = 0; i < n; ++i)
             S.add(arr[i]);
 
         // check each possible sequence from the start
         // then update optimal length
         for (int i = 0; i < n; ++i) {
             // if current element is the starting
             // element of a sequence
             if (!S.contains(arr[i] - 1)) {
                 // Then check for next elements
                 // in the sequence
                 int j = arr[i];
                 while (S.contains(j))
                     j++;
 
                 // update  optimal length if this
                 // length is more
                 if (ans < j - arr[i])
                     ans = j - arr[i];
             }
         }
         return ans;
     }
     

     // Approach 2: Sorting
    // T.C = O(n log n), S.C = O(1)

    // Sort the array.
    // Initialize a variable, count, to store the count of the longest subsequence.
    // Initialize a variable, max_count, to store the maximum count of the longest subsequence.
    // Traverse the array from the second element to the end.
    // If the current element is equal to the previous element plus 1, increment the count.
    // Otherwise, update the max_count with the maximum of the count and max_count and reset the count to 1.
    // Print the max_count.


    public int findLongestConseqSubseq2(int arr[], int n)
    {
        Arrays.sort(arr);
        int count = 1;
        int max_count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                count++;
            } else if (arr[i] != arr[i - 1]) {
                max_count = Math.max(count, max_count);
                count = 1;
            }
        }
        return Math.max(count, max_count);
    }


    // Q_23: Given an array of size n and a number k, fin all elements that appear more than " n/k " times.
    // Given an array of size n and an integer k, find all elements in the array that appear more than n/k times. 

    // Examples:
    // Input: arr[] = {3, 1, 2, 2, 1, 2, 3, 3}, k = 4
    // Output: {2, 3}
    // Explanation: Here n/k is 8/4 = 2, therefore 2 appears 3 times in the array that is 
    //     greater than 2 and 3 appears 3 times in the array that is greater than 2    
    // Input: arr[] = {9, 8, 7, 9, 2, 9, 7}, k = 3
    // Output: {9}
    // Explanation: Here n/k is 7/3 = 2, therefore 9 appears 3 times in the array that is greater than 2.


    // Approach: Hashing
    // T.C = O(n), S.C = O(n)

    // Create a HashMap, map, to store the frequency of the elements in the array.
    // Traverse the array from start to end.
    // If the element is present in the map, increment the frequency of the element.
    // Otherwise, add the element to the map with a frequency of 1.
    // Traverse the map and print the elements with a frequency greater than n/k.

    
    public  void morethanNdK(int a[], int n, int k)
    {
        int x = n / k;
 
        // Hash map initialization
        HashMap<Integer, Integer> y = new HashMap<>();
 
        // count the frequency of each element.
        for (int i = 0; i < n; i++) {
            // is element doesn't exist in hash table
            if (!y.containsKey(a[i]))
                y.put(a[i], 1);
 
            // if element does exist in the hash table
            else {
                int count = y.get(a[i]);
                y.put(a[i], count + 1);
            }
        }
 
        // iterate over each element in the hash table
        // and check their frequency, if it is more than
        // n/k, print it.
        for (@SuppressWarnings("rawtypes") Map.Entry m : y.entrySet()) {
            Integer temp = (Integer)m.getValue();
            if (temp > x)
                System.out.println(m.getKey());
        }
    }

    public void morethanNdK2(int a[], int n , int k){
        int x = n/k;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > x) {
                System.out.println(entry.getKey());
            }
        }
    }
 

    // Q_24: Maximum profit by buying and selling a share atmost twice
    // In daily share trading, a buyer buys shares in the morning and sells them on 
    // the same day. If the trader is allowed to make at most 2 transactions in a day, 
    // the second transaction can only start after the first one is complete (Buy->sell->Buy->sell). 
    // Given stock prices throughout the day, find out the maximum profit that a share trader could have made.

    // Examples: 
    // Input:   price[] = {10, 22, 5, 75, 65, 80}
    // Output:  87
    // Trader earns 87 as sum of 12, 75 
    // Buy at 10, sell at 22, 
    // Buy at 5 and sell at 80
    // Input:   price[] = {2, 30, 15, 10, 8, 25, 80}
    // Output:  100
    // Trader earns 100 as sum of 28 and 72
    // Buy at price 2, sell at 30, buy at 8 and sell at 80
    
    // Approach: Dynamic Programming
    // T.C = O(n), S.C = O(n)

    // Create two arrays, profit1 and profit2, to store the maximum profit for the first and second transactions.
    // Initialize the profit1 and profit2 arrays with 0.
    // Initialize two variables, min_price1 and min_price2, to store the minimum price for the first and second transactions.
    // Traverse the array from the start to the end.
    // Update the min_price1 with the minimum of the current element and min_price1.
    // Update the profit1 with the maximum of the current element minus min_price1 and profit1.
    // Update the min_price2 with the minimum of the current element minus profit1 and min_price2.
    // Update the profit2 with the maximum of the current element minus min_price2 and profit2.
    // Print the maximum of profit1 and profit2.


    public int maxProfit(int price[], int n)
    {
        int profit1[] = new int[n];
        for (int i = 0; i < n; i++)
            profit1[i] = 0;
 
        int profit2[] = new int[n];
        for (int i = 0; i < n; i++)
            profit2[i] = 0;
 
        int min_price1 = price[0];
        for (int i = 1; i < n; i++) {
            min_price1 = Math.min(min_price1, price[i]);
            profit1[i] = Math.max(profit1[i - 1], price[i] - min_price1);
        }
 
        int min_price2 = price[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            min_price2 = Math.max(min_price2, price[i]);
            profit2[i] = Math.max(profit2[i + 1], min_price2 - price[i]);
        }
 
        int max_profit = 0;
        for (int i = 0; i < n; i++)
            max_profit = Math.max(max_profit, profit1[i] + profit2[i]);
 
        return max_profit;
    }


    // Approach 2: Efficient Approach 
    // T.C = O(n), S.C = O(1)

    // Follow the steps below to solve the problem:

    // Initialize four variables for taking care of the first buy, first sell, 
    // second buy, second sell. Set first buy and second buy as INT_MIN and 
    // first and second sell as 0. This is to ensure to get profit from transactions. 
    // Iterate through the array and return the second sell as it will store maximum profit.

    public int maxtwobuysell(int arr[],int size) {
        int first_buy = Integer.MIN_VALUE;
          int first_sell = 0;
          int second_buy = Integer.MIN_VALUE;
          int second_sell = 0;
           
          for(int i = 0; i < size; i++) {
             
              first_buy = Math.max(first_buy,-arr[i]); 
              first_sell = Math.max(first_sell,first_buy+arr[i]); 
              second_buy = Math.max(second_buy,first_sell-arr[i]);
              second_sell = Math.max(second_sell,second_buy+arr[i]);
           
        }
         return second_sell;
    }


    // Q_25: Find whether an array is a subset of another array
    // Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is 
    // a subset of arr1[] or not. Both arrays are not in sorted order. 
    // It may be assumed that elements in both arrays are distinct.
    // Examples:     
    // Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1} 
    // Output: arr2[] is a subset of arr1[]
    // Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4} 
    // Output: arr2[] is a subset of arr1[]

    // Approach: Hashing
    // The idea is to insert all the elements of the first array in a HashSet, 
    // and then iterate on the second array and find if the element exists in the HashSet, 
    // if the HashSet doesn’t contain any particular value then the second array is not the subset of the first array.
    // Note: This approach works perfectly if there are no duplicate elements.

    // Algorithm:
    // The algorithm is pretty straightforward. 
    // Store the first array arr1[] in a HashSet.
    // Look for the elements of arr2[] in the HashSet.
    // If we encounter a particular value that is present in arr2[] but not in the HashSet, 
    //     the code will terminate, arr2[] can never be the subset of arr1[].
    // Else arr2[] is the subset of arr1[].

    public boolean isSubset(int arr1[], int arr2[], int m,int n)
    {
        HashSet<Integer> hset = new HashSet<>();

        // hset stores all the values of arr1
        for (int i = 0; i < m; i++) {
            if (!hset.contains(arr1[i]))
                hset.add(arr1[i]);
        }

        // loop to check if all elements
        //  of arr2 also lies in arr1
        for (int i = 0; i < n; i++) {
            if (!hset.contains(arr2[i]))
                return false;
        }
        return true;
    }


    // Q_26: Find the triplet that sum to a given value
    // Given an array arr[] of size n and an integer X. Find if there’s a 
    // triplet in the array which sums up to the given integer X.
    // Examples: 
    // Input: array = {12, 3, 4, 1, 6, 9}, sum = 24; 
    // Output: 12, 3, 9 
    // Explanation: There is a triplet (12, 3 and 9) present 
    // in the array whose sum is 24.     
    // Input: array = {1, 2, 3, 4, 5}, sum = 9 
    // Output: 5, 3, 1 
    // Explanation: There is a triplet (5, 3 and 1) present 
    // in the array whose sum is 9

    // Approach: Sorting and Two-Pointer Technique
    // By Sorting the array the efficiency of the algorithm can be improved. 
    // This efficient approach uses the two-pointer technique. Traverse the array 
    // and fix the first element of the triplet. Now use the Two Pointers algorithm to 
    // find if there is a pair whose sum is equal to x – array[i]. Two pointers algorithm 
    // take linear time so it is better than a nested loop.

    // Algorithm:
    // Sort the given array.
    // Iterate over the array and fix the first element of the possible triplet, arr[i].
    // Then fix two pointers, one at i + 1 and the other at n – 1. And look at the sum,
    // If the sum is smaller than the required sum, increment the first pointer.
    // If the sum is bigger, decrements the end pointer to reduce the sum.
    // If the sum of elements at two-pointer is equal to the required sum then print the triplet and return.
    // The implementation of the above approach is as follows:

    public boolean find3Numbers(int A[], int arr_size, int sum)
    {
        int l, r;
 
        // Fix the first element as A[i]
        for (int i = 0; i < arr_size - 2; i++) {
 
            // Fix the second element as A[j]
            l = i + 1; // Initialize the left pointer
            r = arr_size - 1; // Initialize the right pointer
            while (l < r) {
                if (A[i] + A[l] + A[r] == sum) {
                    System.out.println("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]);
                    return true;
                } else if (A[i] + A[l] + A[r] < sum)
                    l++;
                else // A[i] + A[l] + A[r] > sum
                    r--;
            }
        }
        return false;
    }


    // Q_27: Trapping Rain water problem
    // Given an array of N non-negative integers arr[] representing an elevation 
    // map where the width of each bar is 1, compute how much water it is able to trap after raining.

    // Examples:  
    // Input: arr[] = {2, 0, 2}
    // Output: 2
    // Explanation: The structure is like below.
    // We can trap 2 units of water in the middle gap.  
    // Input: arr[]   = {3, 0, 2, 0, 4}
    // Output: 7
    // Explanation: Structure is like below.
    // We can trap “3 units” of water between 3 and 2,
    // “1 unit” on top of bar 2 and “3 units” between 2 and 4.


    // Approach: Two-Pointer Technique
    // T.C = O(n), S.C = O(1)
    // At every index, The amount of rainwater stored is the difference between the current 
    // index height and a minimum of left max height and right max-height.

    // Here we can use the two-pointer approach to find the minimum among the left-max and
    // right-max of the probable outermost boundary for any index and iterate likewise.
    
    // For example: 
    
    // Say we have indices i, j and a boundary of (left, right). where i is the left pointer and j is the right pointer.
    // If the minimum is arr[left], we can say that i is bounded in one side by left and no matter whatever the values 
    // are in between (i, right), the rightmost boundary of i will at  least have height arr[right] which is the 
    // probable outermost boundary for i. 
    // So the water height of water column at index i is arr[left] – arr[i] and we can increment i then.
    // Similar things happen for j also.

    // Follow the steps mentioned below to implement the idea:

    // Take two pointers l and r. Initialize l to the starting index 0 and r to the last index N-1.
    // Since l is the first element, left_max would be 0, and right_max for r would be 0.
    // While l ? r, iterate the array. We have two possible conditions
    // Condition1 : left_max <= right max
    // Consider Element at index l
    // Since we have traversed all elements to the left of l, left_max is known 
    // For the right max of l, We can say that the right max would  always be >= current r_max here
    // So, min(left_max,right_max) would always equal to left_max in this case
    // Increment l.
    // Condition2 : left_max > right max
    // Consider Element at index r
    // Since we have traversed all elements to the right of r, right_max is known
    // For the left max of l, We can say that the left max would  always be >= current l_max here
    // So, min(left_max,right_max) would always equal to right_max in this case
    // Decrement r.
    

    public int maxWater(int[] arr, int n) 
    { 
  
        // Indices to traverse the array 
        int left = 0; 
        int right = n - 1; 
  
        // To store Left max and right max 
        // for two pointers left and right 
        int l_max = 0; 
        int r_max = 0; 
  
        // To store the total amount 
        // of rain water trapped 
        int result = 0; 
        while (left <= right) { 
  
            // We need check for minimum of left 
            // and right max for each element 
            if (r_max <= l_max) { 
  
                // Add the difference between 
                // current value and right max at index r 
                result += Math.max(0, r_max - arr[right]); 
  
                // Update right max 
                r_max = Math.max(r_max, arr[right]); 
  
                // Update right pointer 
                right -= 1; 
            } 
            else { 
                
                // Add the difference between 
                // current value and left max at index l 
                result += Math.max(0, l_max - arr[left]); 
  
                // Update left max 
                l_max = Math.max(l_max, arr[left]); 
  
                // Update left pointer 
                left += 1; 
            } 
        } 
        return result; 
    } 


    // Approach 2: Pre-compute left and right max
    // T.C = O(n), S.C = O(n)

    // The above approach can be optimized by pre-computing the left and right max for each element.
    // Follow the steps below to solve the problem:
    // Follow the steps mentioned below to implement the approach:

    // Create two arrays left[] and right[] of size N. Create a variable (say max) 
    // to store the maximum found till a certain index during traversal.
    // Run one loop from start to end: 
    // In each iteration update max and also assign left[i] = max.
    // Run another loop from end to start: 
    // In each iteration update max found till now and also assign right[i] = max.
    // Traverse the array from start to end.
    // The amount of water that will be stored in this column is min(left[i], right[i]) – array[i]
    // Add this value to the total amount of water stored
    // Print the total amount of water stored.
    // Below is the implementation of the above approach.

    public int findWater(int arr[],int n) 
    { 
        // left[i] contains height of tallest bar to the 
        // left of i'th bar including itself 
        int left[] = new int[n]; 
  
        // Right [i] contains height of tallest bar to 
        // the right of ith bar including itself 
        int right[] = new int[n]; 
  
        // Initialize result 
        int water = 0; 
  
        // Fill left array 
        left[0] = arr[0]; 
        for (int i = 1; i < n; i++) 
            left[i] = Math.max(left[i - 1], arr[i]); 
  
        // Fill right array 
        right[n - 1] = arr[n - 1]; 
        for (int i = n - 2; i >= 0; i--) 
            right[i] = Math.max(right[i + 1], arr[i]); 
  
        // Calculate the accumulated water element by 
        // element consider the amount of water on i'th bar, 
        // the amount of water accumulated on this 
        // particular bar will be equal to min(left[i], 
        // right[i]) - arr[i] . 
        for (int i = 0; i < n; i++) 
            water += Math.min(left[i], right[i]) - arr[i]; 
  
        return water; 
    } 
  


    // Q_28: Smallest Subarray with sum greater than a given value
    // Given an array arr[] of integers and a number x, the task is to find the smallest 
    // subarray with a sum greater than the given value. 

    // Examples:
    
    // arr[] = {1, 4, 45, 6, 0, 19}
    //    x  =  51
    // Output: 3
    // Minimum length subarray is {4, 45, 6}
    // arr[] = {1, 10, 5, 2, 7}
    //    x  = 9
    // Output: 1
    // Minimum length subarray is {10}
    // arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    //     x = 280
    // Output: 4
    // Minimum length subarray is {100, 1, 0, 200}
    // arr[] = {1, 2, 4}
    //     x = 8
    // Output : Not Possible
    // Whole array sum is smaller than 8.
    
    // Approach: Two-Pointer Technique
    // T.C = O(n), S.C = O(1)

    // The idea is to maintain a window that has a sum greater than the given value.
    // We maintain a window by having two pointers, l and r.
    // We keep incrementing r until the sum of the window is greater than the given value.
    // Once the sum is greater, we increment l until the sum is less than the given value.
    // We keep track of the minimum length of the window.
    // The implementation of the above approach is as follows:

    public int smallestSubWithSum(int arr[], int n, int x)
    {
        // Initialize current sum and minimum length
        int curr_sum = 0, min_len = n + 1;
 
        // Initialize starting and ending indexes
        int start = 0, end = 0;
        while (end < n) {
            // Keep adding array elements while the current sum
            // is smaller than or equal to x
            while (curr_sum <= x && end < n)
                curr_sum += arr[end++];
 
            // If current sum becomes greater than x.
            while (curr_sum > x && start < n) {
                // Update minimum length if needed
                if (end - start < min_len)
                    min_len = end - start;
 
                // remove starting elements
                curr_sum -= arr[start++];
            }
        }
        return min_len;
    }


    // Q_29: Minimum swaps required bring elements less equal K together
    // Given an array of n positive integers and a number k. Find the minimum number 
    // of swaps required to bring all the numbers less than or equal to k together. 

    // Example: 
    
    // Input:  arr[] = {2, 1, 5, 6, 3}, k = 3
    // Output: 1
    // Explanation: 
    // To bring elements 2, 1, 3 together, swap element ‘5’ with ‘3’ such that final array will be arr[] = {2, 1, 3, 6, 5}
    
    // Input:  arr[] = {2, 7, 9, 5, 8, 7, 4}, k = 5
    // Output: 2
    
    // Approach: Sliding Window Technique
    // T.C = O(n), S.C = O(1)

    // The idea is to count the number of elements greater than k.
//     Find the count of all elements which are less than or equal to ‘k’. Let’s say the count is ‘cnt’
// Using the two-pointer technique for a window of length ‘cnt’, each time keep track of how many 
// elements in this range are greater than ‘k’. Let’s say the total count is ‘bad’.
// Repeat step 2, for every window of length ‘cnt’ and take a minimum of count ‘bad’ among them. This will be the final answer.
    // We maintain a window of size equal to the count of elements greater than k.
    // We keep track of the minimum number of elements greater than k in the window.
    // The implementation of the above approach is as follows:

    public int minSwap(int arr[], int n, int k)
    {
        // Find count of elements which are less than
        // equals to k
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (arr[i] <= k)
                ++count;
     
        // Find unwanted elements in current window of
        // size 'count'
        int bad = 0;
        for (int i = 0; i < count; ++i)
            if (arr[i] > k)
                ++bad;
     
        // Initialize answer with 'bad' value of
        // current window
        int ans = bad;
        for (int i = 0, j = count; j < n; ++i, ++j) {
     
            // Decrement count of previous window
            if (arr[i] > k)
                --bad;
     
            // Increment count of current window
            if (arr[j] > k)
                ++bad;
     
            // Update ans if count of 'bad'
            // is less in current window
            ans = Math.min(ans, bad);
        }
        return ans;
    }


    // Q_30: Minimum no. of operations required to make an array palindrome
    // Given an array of positive integers. We need to make the given array a ‘Palindrome’. 
    // The only allowed operation is”merging” (of two adjacent elements). 
    // Merging two adjacent elements means replacing them with their sum. 
    // The task is to find the minimum number of merge operations required to make the given array a ‘Palindrome’.

    // To make any array a palindrome, we can simply apply merge operation n-1 times 
    // where n is the size of the array (because a single-element array is always palindromic, 
    // similar to single-character string). In that case, the size of array will be reduced to 1. 
    // But in this problem, we are asked to do it in the minimum number of operations.
    
    // Example : 
    
    // Input : arr[] = {15, 4, 15}
    // Output : 0
    // Array is already a palindrome. So we
    // do not need any merge operation.
    // Input : arr[] = {1, 4, 5, 1}
    // Output : 1
    // We can make given array palindrome with
    // minimum one merging (merging 4 and 5 to
    // make 9)
    // Input : arr[] = {11, 14, 15, 99}
    // Output : 3
    // We need to merge all elements to make
    // a palindrome.
      
    // Approach: Two-Pointer Technique
    // T.C = O(n), S.C = O(1)

    // Let f(i, j) be minimum merging operations to make subarray arr[i..j] a palindrome. 
    // If i == j answer is 0. We start i from 0 and j from n-1.

    // If arr[i] == arr[j], then there is no need to do any merging operations at index i or index j. 
    // Our answer in this case will be f(i+1, j-1).
    // Else, we need to do merging operations. Following cases arise.
    // If arr[i] > arr[j], then we should do merging operation at index j. We merge index j-1 and j, 
    // and update arr[j-1] = arr[j-1] + arr[j]. Our answer in this case will be 1 + f(i, j-1).
    // For the case when arr[i] < arr[j], update arr[i+1] = arr[i+1] + arr[i]. Our answer in this case will be 1 + f(i+1, j).
    // Our answer will be f(0, n-1), where n is the size of array arr[].
    // Therefore this problem can be solved iteratively using two pointers (first pointer 
    // pointing to start of the array and second pointer pointing to the last element 
    // of the array) method and keeping count of total merging operations done till now.

    public int findMinOps(int[] arr, int n) {
        int ans = 0; // Initialize result

        // Start from leftmost and rightmost corners of arr[]
        for (int i = 0, j = n - 1; i <= j;) {

            // If corner elements are same, problem reduces arr[i+1..j-1]
            if (arr[i] == arr[j]) {
                i++;
                j--;
            }

            // If left element is greater, then we merge right two elements
            else if (arr[i] > arr[j]) {
                // need to merge from head.
                i++;
                arr[i] += arr[i - 1];
                ans++;
            }

            // Else we merge right two elements
            else {
                j--;
                arr[j] += arr[j + 1];
                ans++;
            }
        }

        return ans;
    }

    public static int palinArray(int[] a, int n)
           {
                  //add code here.
                  int ans = 1;
                  for(int i = 0 ; i < n ; i++){  
                      String str = Integer.toString(a[i]);
                      if(ans == 0){
                          break;
                      }   
                      for(int j = 0 ; j <= str.length()-1-j ; j++){
                          if(str.charAt(j) == str.charAt(str.length()-1-j)){
                             ans = 1;
                          }
                          else{
                              ans = 0;
                             break; 
                          }    
                      }
                  }
                  return ans;  
           }


    // Q_31: Median of 2 sorted arrays of equal size
    // There are 2 sorted arrays A and B of size n each. Write an algorithm to find the 
    // median of the array obtained after merging the above 2 arrays(i.e. array of length 2n). 
    // The complexity should be O(log(n))

    // Example:
    // Input: ar1[] = {1, 12, 15, 26, 38}
    //        ar2[] = {2, 13, 17, 30, 45}
    // Output: 16
    // Explanation: After merging two arrays, we get 1 2 12 13 15 17 26 30 38 45
    // The median of the merged array is 15 (average of 15 and 17)


    // Approach: Simply Count while Merging
    // T.C = O(n), S.C = O(1)

    // The idea is to use the merge procedure of the merge sort.
    // Keep track of count while comparing elements of two arrays.
    // If count is equal to n1, we have reached the median. Take the average of the elements at the last index and last-1 index in the merged array.
    // Below is the implementation of the above approach:

    public int getMedian2(int ar1[], int ar2[], int n)
    {
        int i = 0; /* Current index of i/p array ar1[] */
        int j = 0; /* Current index of i/p array ar2[] */
        int count;
        int m1 = -1, m2 = -1;
     
        /* Since there are 2n elements, median will be average
        of elements at index n-1 and n in the array obtained after
        merging ar1 and ar2 */
        for (count = 0; count <= n; count++) {
            /* Below is to handle case where all elements of ar1[] are
            smaller than smallest(or first) element of ar2[] */
            if (i == n) {
                m1 = m2;
                m2 = ar2[0];
                break;
            }
     
            /* Below is to handle case where all elements of ar2[] are
            smaller than smallest(or first) element of ar1[] */
            else if (j == n) {
                m1 = m2;
                m2 = ar1[0];
                break;
            }
            /* equals sign because if two
            arrays have some common elements */
            if (ar1[i] <= ar2[j]) {
                /* Store the prev median */
                m1 = m2;
                m2 = ar1[i];
                i++;
            }
            else {
                /* Store the prev median */
                m1 = m2;
                m2 = ar2[j];
                j++;
            }
        }
     
        return (m1 + m2) / 2;
    }


    // Approach 2: Binary Search
    // We can find the kth element by using binary search on whole range of constraints of elements.

    // Initialize ans = 0.0
    // Initialize low = -10^9, high = 10^9 and pos = n
    // Run a loop while(low <= high):
        // Calculate mid = (low + (high – low)>>1)
        // Find total elements less or equal to mid in the given arrays
        // If the count is less or equal to pos
            // Update low = mid + 1
            // Else high = mid – 1
    // Store low in ans, i.e., ans = low.
    // Again follow step3 with pos as n – 1
    // Return (sum + low * 1.0)/2

    public  double getMedian(int[] nums1, int[] nums2,
                                   int n)
    {
        // according to given constraints all numbers are in
        // this range
        int low = (int)-1e9, high = (int)1e9;
 
        int pos = n;
        double ans = 0.0;
        // binary search to find the element which will be
        // present at pos = totalLen/2 after merging two
        // arrays in sorted order
        while (low <= high) {
            int mid = low + ((high - low) >> 1); // same as (low + high)/2
 
            // total number of elements in arrays which are
            // less than mid
            int ub = upperBound(nums1, mid) + upperBound(nums2, mid);
 
            if (ub <= pos)
                low = mid + 1;
            else
                high = mid - 1;
        }
 
        ans = low;
 
        // As there are even number of elements, we will
        // also have to find element at pos = totalLen/2 - 1
        pos--;
        low = (int)-1e9;
        high = (int)1e9;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int ub = upperBound(nums1, mid)
                     + upperBound(nums2, mid);
 
            if (ub <= pos)
                low = mid + 1;
            else
                high = mid - 1;
        }
 
        // average of two elements in case of even
        // number of elements
        ans = (ans + low * 1.0) / 2;
 
        return ans;
    }
 
    // a function which returns the index of smallest
    // element which is strictly greater than key (i.e. it
    // returns number of elements which are less than or
    // equal to key)
    public static int upperBound(int[] arr, int key)
    {
        int low = 0, high = arr.length;
 
        while (low < high) {
            int mid = low + ((high - low) >> 1);
 
            if (arr[mid] <= key)
                low = mid + 1;
            else
                high = mid;
        }
 
        return low;
    }


    // Q_32: Median of 2 sorted arrays of different size
    // Given two sorted arrays, a[] and b[], the task is to find the median of these sorted arrays, 
    // where N is the number of elements in the first array, and M is the number of elements in the second array. 

    // This is an extension of Median of two sorted arrays of equal size problem. 
    // Here we handle arrays of unequal size also.
    
    // Examples: 
    
    // Input: a[] = {-5, 3, 6, 12, 15}, b[] = {-12, -10, -6, -3, 4, 10}
    // Output: The median is 3.
    // Explanation: The merged array is: ar3[] = {-12, -10, -6, -5 , -3, 3, 4, 6, 10, 12, 15}.
    // So the median of the merged array is 3


    // Approach: Binary Search
    // T.C = O(log(min(n, m))), S.C = O(1)

    // The idea is to use the binary search approach to find the partition of the arrays.
    // The partition should be such that the elements on the left side should be less than the elements on the right side.
    // The partition should be such that the number of elements on the left side should be equal to the number of elements on the right side.
    // The implementation of the above approach is as follows:

//     The given two arrays are sorted, so we can utilize the ability of Binary Search to divide 
//     the array and find the median. 

// Median means the point at which the whole array is divided into two parts. 
// Hence since the two arrays are not merged so to get the median we require merging which is costly. 

// Hence instead of merging, we will use a modified binary search algorithm to efficiently find the median.

// The idea is to divide the two arrays into two halves such that the number of elements in the left half is equal to the number of elements in the right half.


    public double MedianOfTwoSortedArray(int[] A, int[] B)
    {
        int n = A.length;
        int m = B.length;
        if (n > m)
            return MedianOfTwoSortedArray(B,A); // Swapping to make A smaller
 
        int start = 0;
        int end = n;
        int realmidinmergedarray = (n + m + 1) / 2;
 
        while (start <= end) {
            int mid = (start + end) / 2;
            int leftAsize = mid;
            int leftBsize = realmidinmergedarray - mid;
            int leftA = (leftAsize > 0) ? A[leftAsize - 1] : Integer.MIN_VALUE; // checking overflow
                                        // of indices
            int leftB = (leftBsize > 0) ? B[leftBsize - 1]: Integer.MIN_VALUE;
            int rightA = (leftAsize < n) ? A[leftAsize] : Integer.MAX_VALUE;
            int rightB = (leftBsize < m) ? B[leftBsize] : Integer.MAX_VALUE;
 
            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                return Math.max(leftA, leftB);
            }
            else if (leftA > rightB) {
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return 0.0;
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


        // array.rotateArray();
        // array.rotateArray2();
        // for (int i = 0; i < array.getSize(); i++) {
        //     System.out.print(array.get(i) + " ");
        // }


        // int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        // System.out.println(array.largestSumContiguousSubarray(arr));
        // System.out.println(array.largestSumContiguousSubarray2(arr));


        // int arr[] = {1, 15, 10};
        // int n = arr.length;
        // int k = 6;
        // System.out.println(array.getMinDiff(arr, n, k));


        // int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        // System.out.println(array.minJumps(arr));


        // int arr[] = {1, 2, 3, 4, 5, 6, 3};
        // System.out.println(array.findDuplicate(arr));

        
        // int arr1[] = {1, 5, 9, 10, 15, 20};
        // int arr2[] = {2, 3, 8, 13};
        // array.merge(arr1, arr2);
        // for (int i = 0; i < arr1.length; i++) {
        //     System.out.print(arr1[i] + " ");
        // }
        // System.out.println();
        // for (int i = 0; i < arr2.length; i++) {
        //     System.out.print(arr2[i] + " ");
        // }

        
        // Interval arr[] = new Interval[4];
        // arr[0] = new Interval(1, 3);
        // arr[1] = new Interval(2, 4);
        // arr[2] = new Interval(6, 8);
        // arr[3] = new Interval(9, 10);
        // array.mergeIntervals(arr);
        // System.out.println();
        // array.mergeIntervalsOptimized(arr);


        // int arr[] = {5, 3, 7, 10};
        // System.out.println(array.optimalStrategy(arr, arr.length));

        
        // int arr[] = {1, 2, 3, 6, 5, 4};
        // array.nextPermutation(arr);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }


        // int arr[] = {8, 4, 2, 1};
        // System.out.println(array.mergeSortAndCount(arr, 0, arr.length - 1));


        // int arr[] = {1, 5, 7, -1};
        // int n = arr.length;
        // int k = 6;
        // System.out.println(array.getPairsCount(arr, n, k));
        // System.out.println(array.getPairsCount2(arr, n, k));


        // int ar1[] = {1, 5, 10, 20, 40, 80};
        // int ar2[] = {6, 7, 20, 80, 100};
        // int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
        // array.findCommon(ar1, ar2, ar3);

        
        // int arr[] = {1, 2, 3, -4, -1, 4};
        // int n = arr.length;
        // array.rearrangePosNeg(arr, n);
        // for (int i = 0; i < n; i++) {
        //     System.out.print(arr[i] + " ");
        // }


        // int arr[] = {4, 2, -3, 1, 6};
        // int n = arr.length;
        // System.out.println(array.subArrayExists(arr, n));


        // int N = 100;
        // array.factorial(N);


        // int arr[] = {1, 9, 3, 10, 4, 20, 2};
        // int n = arr.length;
        // System.out.println(array.findLongestConseqSubseq(arr, n));


        // int arr[] = {1, 9, 3, 10, 4, 20, 2};
        // int n = arr.length;
        // int k = 4;
        // array.morethanNdK2(arr, n, k);


        // int price[] = {10, 22, 5, 75, 65, 80};
        // int n = price.length;
        // System.out.println(array.maxProfit(price, n));

        // int arr[] = {2, 30, 15, 10, 8, 25, 80};
        // int m = arr.length;
        // System.out.println(array.maxtwobuysell(arr, m));


        // int arr1[] = {11, 1, 13, 21, 3, 7};
        // int arr2[] = {11, 3, 7, 1};
        // int m = arr1.length;
        // int n = arr2.length;
        // System.out.println(array.isSubset(arr1, arr2, m, n));


        // int A[] = {12, 3, 4, 1, 6, 9};
        // int sum = 24;
        // int arr_size = A.length;
        // System.out.println(array.find3Numbers(A, arr_size, sum));


        // int arr[] = {3, 0, 2};
        // int n = arr.length;
        // System.out.println(array.maxWater(arr, n));
        // System.out.println(array.findWater(arr, n));


        // int arr[] = {1, 4, 45, 6, 0, 19};
        // int n = arr.length;
        // int x = 51;
        // System.out.println(array.smallestSubWithSum(arr, n, x));
        

        // int arr[] = {1, 2, 3, 4, 5, 6, 3};
        // int n = arr.length;
        // int k = 3;
        // System.out.println(array.minSwap(arr, n, k));


        // int arr[] = {1, 4, 5, 1};
        // int n = arr.length;
        // System.out.println(array.findMinOps(arr, n));
            

        // int arr[] = {1, 12, 15, 26, 38};
        // int arr2[] = {2, 13, 17, 30, 45};
        // int n = arr.length;
        // System.out.println(array.getMedian2(arr, arr2, n));
        // System.out.println(array.getMedian(arr, arr2, n));


        // int ar1[] = {1, 12, 15, 26, 38};
        // int ar2[] = {2, 13, 17, 30, 45};
        // System.out.println(array.MedianOfTwoSortedArray(ar1, ar2));
        


    }
}