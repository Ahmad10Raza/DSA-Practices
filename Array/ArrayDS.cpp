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

    ~Array() {
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