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


        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(array.minJumps(arr));


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
        


    }
}