
// Problem Statement: Given an array of integers arr, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

// Examples:

// Example 1:

// Input: arr = [4,0,-1,3,5,3,6,8], k = 3

// Output: [4,3,5,5,6,8]

// Explanation: 

// Window position                   Max
// ------------------------         -----
// [4  0  -1] 3  5  3  6  8           4
//  4 [0  -1  3] 5  3  6  8           3
//  4  0 [-1  3  5] 3  6  8           5
//  4  0  -1 [3  5  3] 6  8           5
//  4  0  -1  3 [5  3  6] 8           6
//  4  0  -1  3  5 [3  6  8]          8

// For each window of size k=3, we find the maximum element in the window and add it to our output array.

// Example 2:

// Input: arr= [20,25], k = 2

// Output: [25]

// Explanation: There’s just one window is size 2 that is possible and the maximum of the two elements is our answer.

// Approach: We will use the deque to solve this problem. We will traverse the array from left to right. We will keep pushing the elements in the deque until we find the element which is greater than the current element. If we find the element which is greater than the current element, we will pop the elements from the deque until we find the element which is greater than the current element. While popping the elements from the deque, we will calculate the maximum element in the window of size k. We will keep track of the maximum element in the window of size k. We will keep doing this until we reach the end of the array. At the end, we will have the maximum element in the window of size k.

// Follow below steps to solve the problem:
// 1. Create a deque to store the index of the elements.
// 2. Create a variable maxWindow to store the maximum element in the window of size k.
// 3. Traverse the array from left to right.
// 4. If the deque is not empty and the current element is greater than the element at the back of the deque, pop the elements from the back of the deque.
// 5. Push the current element in the deque.
// 6. If the index of the front element of the deque is less than or equal to the current index - k, pop the front element of the deque.
// 7. at the end of the window of size k, add the front element of the deque to the output array.

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {

    public static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // remove elements from the back of the deque which are less than the current
            // element
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                // remove the element from the back of the deque
                dq.pollLast();
            }
            // add the current element to the deque
            dq.offerLast(i);
            // if the index of the front element of the deque is less than or equal to the
            // current index - k, remove the front element of the deque
            if (i >= k - 1) {
                // add the front element of the deque to the output array
                res[index++] = arr[dq.peekFirst()];
                // remove the front element of the deque
                if (dq.peekFirst() == i - k + 1) {
                    dq.pollFirst();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 0, -1, 3, 5, 3, 6, 8 };
        int k = 3;
        int res[] = maxSlidingWindow(arr, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
