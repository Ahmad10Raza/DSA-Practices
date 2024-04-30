#include <iostream>
#include <string>

class Array {
private:
    int* arr;
    int size;
public:
    Array(int size) {
        this->size = size;
        arr = new int[size];
    }

    Array() {
        delete[] arr;
    }

    int getSize() {
        return size;
    }

    int getElement(int index) {
        if (index >= 0 && index < size) {
            return arr[index];
        } else {
            std::cout << "Invalid index!" << std::endl;
            return -1;
        }
    }

    void setElement(int index, int value) {
        if (index >= 0 && index < size) {
            arr[index] = value;
        } else {
            std::cout << "Invalid index!" << std::endl;
        }
    }


    void print() {
        for (int i = 0; i < size; i++) {
            std::cout << arr[i] << " ";
        }
        std::cout << std::endl;
    }

    void insert(int index, int value) {
        if (index >= 0 && index < size) {
            for (int i = size - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = value;
            size++;
        } else {
            std::cout << "Invalid index!" << std::endl;
        }
    }

    void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
        } else {
            std::cout << "Invalid index!" << std::endl;
        }
    }

    void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[size - i - 1];
            arr[size - i - 1] = temp;
        }
    }

    // Function for Minimum swaps required bring elements less equal K together
    int minSwap(int arr[], int n, int k){
        int count = 0;
        // Find count of elements which are less than
        // equals to k
        for(int i=0; i<n; i++){
            if(arr[i] <= k){
                count++;
            }
        }

        // Find unwanted elements in current window of
        // size 'count'
        int bad = 0;
        for(int i=0; i<count; i++){
            if(arr[i] > k){
                bad++;
            }
        }

        // Initialize answer with 'bad' value of current
        // window
        int ans = bad;
        for(int i=0, j=count; j<n; i++, j++){
            // Decrement count of previous window
            if(arr[i] > k){
                bad--;
            }

            // Increment count of current window
            if(arr[j] > k){
                bad++;
            }

            // Update ans if count of 'bad' is less in
            // current window
            ans = std::min(ans, bad);
        }
        return ans;
    }


    // Function to Minimum no. of operations required to make an array palindrome

    int minOps(int arr[], int n){
        int ans = 0; // Initialize result

        // Start from leftmost and rightmost corners of
        // arr[]
        int i = 0;
        int j = n - 1;

        // Keep moving while the left and right pointers
        // haven't met
        while(i < j){
            // If both elements are same, then no need
            // to do anything
            if(arr[i] == arr[j]){
                i++;
                j--;
            }

            // If left element is greater, then we merge right
            // two elements
            else if(arr[i] > arr[j]){
                // need to merge from tail.
                j--;
                arr[j] += arr[j + 1];
                ans++;
            }

            // Else we merge left two elements
            else{
                i++;
                arr[i] += arr[i - 1];
                ans++;
            }
        }

        return ans;
    }

    // Using Converting into string
    int palinArray(int a[], int n){
        

        int ans = 1; // Change the data type of "ans" to "int"

        for (int i = 0; i < n; i++) {
            std::string s = std::to_string(a[i]); // Convert integer to string
            if (ans == 0) {
                break;
            }
            for (int j = 0; j < s.length(); j++) {
                if (s[j] != s[s.length() - 1 - j]) {
                    ans = 1;
                    break;
                }
            }
        }
        return ans;
    }

    // Function for  Minimum swaps required bring elements less equal K together
    int minSwap(int arr[], int n, int k){
        int count = 0;
        // Find count of elements which are less than
        // equals to k
        for(int i=0; i<n; i++){
            if(arr[i] <= k){
                count++;
            }
        }

        // Find unwanted elements in current window of
        // size 'count'
        int bad = 0;
        for(int i=0; i<count; i++){
            if(arr[i] > k){
                bad++;
            }
        }

        // Initialize answer with 'bad' value of current
        // window
        int ans = bad;
        for(int i=0, j=count; j<n; i++, j++){
            // Decrement count of previous window
            if(arr[i] > k){
                bad--;
            }

            // Increment count of current window
            if(arr[j] > k){
                bad++;
            }

            // Update ans if count of 'bad' is less in
            // current window
            ans = std::min(ans, bad);
        }
        return ans;
    }

    // Function To reverse the array
    void reverseArray(int arr[], int n){
        int low = 0;
        int high = n - 1;
        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    // Using Recursion
    void reverseArray(int arr[], int start, int end){
        if(start >= end){
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start + 1, end - 1);
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

    void findMaxMin(int arr[], int n){
        int max = arr[0];
        int min = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        std::cout << "Maximum: " << max << ", Minimum: " << min << std::endl;
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

        void findKthMaxMin(int arr[], int n, int k){
            std::sort(arr, arr + n);
            std::cout << k << "th Minimum: " << arr[k - 1] << ", " << k << "th Maximum: " << arr[n - k] << std::endl;
        }

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

        void sort012(int arr[], int n){
            int low = 0;
            int mid = 0;
            int high = n - 1;
            while(mid <= high){
                if(arr[mid] == 0){
                    std::swap(arr[low], arr[mid]);
                    low++;
                    mid++;
                }
                else if(arr[mid] == 1){
                    mid++;
                }
                else{
                    std::swap(arr[mid], arr[high]); 
                    high--;
                }
            }
        }

        void swap(int* a, int* b){
            int temp = *a;
            *a = *b;
            *b = temp;
        }


        // Approach2: Counting Sort
        // T.C = O(n), S.C = O(1)

        // Count the number of 0s, 1s, and 2s in the array.
        // Fill the array with 0s, then 1s, and then 2s.

        void sort012(int arr[], int n){
            int count0 = 0;
            int count1 = 0;
            int count2 = 0;
            for(int i=0; i<n; i++){
                if(arr[i] == 0){
                    count0++;
                }
                else if(arr[i] == 1){
                    count1++;
                }
                else{
                    count2++;
                }
            }
            int i = 0;
            while(count0 > 0){
                arr[i++] = 0;
                count0--;
            }
            while(count1 > 0){
                arr[i++] = 1;
                count1--;
            }
            while(count2 > 0){
                arr[i++] = 2;
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
// Traverse the array from start to en d.
// If the element at the left pointer is negative, increment the left pointer.
// If the element at the left pointer is positive and the element at the right pointer is negative, swap the elements at the left and right pointers and increment the left pointer and decrement the right pointer.
// If the element at the left pointer is positive and the element at the right pointer is positive, decrement the right pointer.
// Print the rearranged array.

        void moveNegative(int arr[], int n){
            int left = 0;
            int right = n - 1;
            while(left <= right){
                if(arr[left] < 0){
                    left++;
                }
                else if(arr[left] > 0 && arr[right] < 0){
                    std::swap(arr[left], arr[right]);
                    left++;
                    right--;
                }
                else if(arr[left] > 0 && arr[right] > 0){
                    right--;
                }
            }
        }

        // Union of Two-Sorted Arrays using Two-Pointers
// To find union of two sorted arrays using two pointers, follow the following procedure : 

// Use two index variables i and j, initial values i = 0, j = 0 
// If arr1[i] is smaller than arr2[j] then print arr1[i] and increment i. 
// If arr1[i] is greater than arr2[j] then print arr2[j] and increment j. 
// If both are same then print any of them and increment both i and j. 
// Print remaining elements of the larger array.


        void unionOfArrays(int arr1[], int n, int arr2[], int m){
            int i = 0;
            int j = 0;
            while(i < n && j < m){
                if(arr1[i] < arr2[j]){
                    std::cout << arr1[i] << " ";
                    i++;
                }
                else if(arr1[i] > arr2[j]){
                    std::cout << arr2[j] << " ";
                    j++;
                }
                else{
                    std::cout << arr1[i] << " ";
                    i++;
                    j++;
                }
            }
            while(i < n){
                std::cout << arr1[i] << " ";
                i++;
            }
            while(j < m){
                std::cout << arr2[j] << " ";
                j++;
            }
        }



    // Intersection of Two-Sorted Arrays using Two-Pointers
//     To find intersection of two sorted arrays using two-pointers, follow the below approach : 

// Use two index variables i and j, initial values i = 0, j = 0 
// If arr1[i] is smaller than arr2[j] then increment i. 
// If arr1[i] is greater than arr2[j] then increment j. 
// If both are same then print any of them and increment both i and j.


        void intersectionOfArrays(int arr1[], int n, int arr2[], int m){
            int i = 0;
            int j = 0;
            while(i < n && j < m){
                if(arr1[i] < arr2[j]){
                    i++;
                }
                else if(arr1[i] > arr2[j]){
                    j++;
                }
                else{
                    std::cout << arr1[i] << " ";
                    i++;
                    j++;
                }
            }
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

    void rotateArray(int arr[], int n){
        int temp = arr[n - 1];
        for(int i=n-1; i>0; i--){
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    // Approach 2: Using Two Pointers
    // T.C = O(n), S.C = O(1)

    /// Follow the steps to solve the problem:

    // Take two pointers i and j which point to first and last element of array respectively.
    // Start swapping arr[i] and arr[j] and keep j fixed and i moving towards j.
    // Repeat above step till i is not equal to j.

    void rotateArray(int arr[], int n){
        int i = 0;
        int j = n - 1;
        while(i != j){
            std::swap(arr[i], arr[j]);
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

    int maxSubarraySum(int arr[], int n){
        int maxSum = INT_MIN;
        int currentSum = 0;
        for(int i=0; i<n; i++){
            currentSum += arr[i];
            if(currentSum < 0){
                currentSum = 0;
            }
            maxSum = std::max(maxSum, currentSum);
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

    int maxSubarraySum(int arr[], int n){
        int dp[n];
        dp[0] = arr[0];
        int maxSum = dp[0];
        for(int i=1; i<n; i++){
            dp[i] = std::max(dp[i - 1] + arr[i], arr[i]);
            maxSum = std::max(maxSum, dp[i]);
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

        int getMinDiff(int arr[], int n, int k){
            std::sort(arr, arr + n);
            int smallest = arr[0] + k;
            int largest = arr[n - 1] - k;
            int result = arr[n - 1] - arr[0];
            for(int i=0; i<n-1; i++){
                int minEle = std::min(smallest, arr[i + 1] - k);
                int maxEle = std::max(largest, arr[i] + k);
                if(minEle < 0){
                    continue;
                }
                result = std::min(result, maxEle - minEle);
            }
            return result;
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

    int minJumps(int arr[], int n){
        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;
        for(int i=1; i<n; i++){
            if(i == n - 1){
                return jumps;
            }
            maxReach = std::max(maxReach, i + arr[i]);
            steps--;
            if(steps == 0){
                jumps++;
                if(i >= maxReach){
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

    int minJumps(int arr[], int n){
        int dp[n];
        dp[0] = 0;
        for(int i=1; i<n; i++){
            dp[i] = INT_MAX;
            for(int j=0; j<i; j++){
                if(i <= j + arr[j]){
                    dp[i] = std::min(dp[i], dp[j] + 1);
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

    int findDuplicate(int arr[], int n){
        int slow = arr[0];
        int fast = arr[0];
        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while(slow != fast);
        slow = arr[0];
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
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


    void merge(int arr1[], int arr2[], int n, int m){
        int i = 0;
        while(arr1[n - 1] > arr2[0]){
            if(arr1[i] > arr2[0]){
                std::swap(arr1[i], arr2[0]);
                std::sort(arr2, arr2 + m);
            }
            i++;
        }
    }

    // Q_13: Kadane’s Algorithm [V.V.V.V.V IMP]
    // Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

    // Example 1:
    // Input:
    // N = 5
    // arr[] = {1,2,3,-2,5}
    // Output:
    // 9
    // Explanation:
    // Max subarray sum is 1 + 2 + 3 - 2 + 5 = 9

    // Example 2:
    // Input:
    // N = 4
    // arr[] = {-1,-2,-3,-4}
    // Output:
    // -1
    // Explanation:
    // Max subarray sum is -1

    // Approach: Kadane’s Algorithm
    // T.C = O(n), S.C = O(1)

    // Initialize two variables, maxSum and currentSum, to store the maximum sum of the subarray and the sum of the current subarray.
    // Traverse the array from start to end.
    // Update the currentSum by adding the current element to it.
    // If the currentSum is less than 0, update the currentSum to 0.
    // If the currentSum is greater than the maxSum, update the maxSum to the currentSum.
    // Print the maxSum.

    int maxSubarraySum(int arr[], int n){
        int maxSum = INT_MIN;
        int currentSum = 0;
        for(int i=0; i<n; i++){
            currentSum += arr[i];
            if(currentSum < 0){
                currentSum = 0;
            }
            maxSum = std::max(maxSum, currentSum);
        }
        return maxSum;
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


    std::vector<std::pair<int, int>> mergeIntervals(std::vector<std::pair<int, int>> intervals){
        std::vector<std::pair<int, int>> result;
        if(intervals.size() == 0){
            return result;
        }
        std::sort(intervals.begin(), intervals.end());
        std::stack<std::pair<int, int>> s;
        s.push(intervals[0]);
        for(int i=1; i<intervals.size(); i++){
            std::pair<int, int> top = s.top();
            if(top.second < intervals[i].first){
                s.push(intervals[i]);
            }
            else if(top.second < intervals[i].second){
                top.second = intervals[i].second;
                s.pop();
                s.push(top);
            }
        }
        while(!s.empty()){
            result.push_back(s.top());
            s.pop();
        }
        return result;
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


    void nextPermutation(int arr[], int n){
        int i = n - 2;
        while(i >= 0 && arr[i] >= arr[i + 1]){
            i--;
        }
        if(i >= 0){
            int j = n - 1;
            while(j >= 0 && arr[j] <= arr[i]){
                j--;
            }
            std::swap(arr[i], arr[j]);
        }
        std::reverse(arr + i + 1, arr + n);
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


    int mergeAndCount(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        int left[n1], right[n2];
        for(int i=0; i<n1; i++){
            left[i] = arr[l + i];
        }
        for(int i=0; i<n2; i++){
            right[i] = arr[m + 1 + i];
        }
        int i = 0, j = 0, k = l, count = 0;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
                count += (n1 - i);
            }
        }
        while(i < n1){
            arr[k++] = left[i++];
        }
        while(j < n2){
            arr[k++] = right[j++];
        }
        return count;
    }

    int mergeSortAndCount(int arr[], int l, int r){
        int count = 0;
        if(l < r){
            int m = l + (r - l) / 2;
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }

    
};

int main() {
    Array arr(5);
    arr.setElement(0, 10);
    arr.setElement(1, 20);
    arr.setElement(2, 30);
    arr.setElement(3, 40);
    arr.setElement(4, 50);
    arr.print();
    arr.insert(2, 25);
    arr.print();
    arr.remove(3);
    arr.print();
    arr.reverse();
    arr.print();




    return 0;
}