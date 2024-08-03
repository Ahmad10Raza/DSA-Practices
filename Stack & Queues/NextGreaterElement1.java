
// Problem Statement: Given a circular integer array A, return the next greater element for every element in A. The next greater element for an element x is the first element greater than x that we come across while traversing the array in a clockwise manner. If it doesn't exist, return -1 for this element.

// Examples:

// Example 1: 

// Input: N = 11, A[] = {3,10,4,2,1,2,6,1,7,2,9}

// Output: 10,-1,6,6,2,6,7,7,9,9,10

// Explanation: For the first element in A ,i.e, 3, the greater element which comes next to it while traversing and is closest to it is 10. Hence,10 is present on index 0 in the resultant array. Now for the second element,i.e, 10, there is no greater number and hence -1 is it’s next greater element (NGE). Similarly, we got the NGEs for all other elements present in A.  

// Example 2:

// Input:  N = 6, A[] = {5,7,1,7,6,0}

// Output: 7,-1,7,-1,7,5

// import java.util.*;
import java.util.Stack;
import java.util.HashMap;

public class NextGreaterElement1 {

    // Approach: We will use stack to solve this problem. We will traverse the array
    // from right to left. We will keep popping the elements from the stack until we
    // find the element which is greater than the current element. If we don't find
    // any element greater than the current element, we will push -1 in the
    // resultant array. If we find the element greater than the current element, we
    // will push that element in the resultant array. We will push the index of the
    // element in the stack. We will keep doing this until we reach the end of the
    // array. At the end, we will have the resultant array with the next greater
    // element for every element in the array.

    // Follow below steps to solve the problem:
    // 1. Create a stack to store the index of the elements.
    // 2. Create a resultant array to store the next greater element for every
    // element in the array.
    // 3. Traverse the array from right to left.
    // 4. If the stack is empty, push -1 in the resultant array.
    // 5. If the stack is not empty and the element at the top of the stack is less
    // than the current element, pop the element from the stack.
    // 6. If the stack is empty, push -1 in the resultant array.
    // 7. If the stack is not empty, push the element at the top of the stack in the
    // resultant array.
    // 8. Push the index of the current element in the stack.
    // 9. Repeat steps 4 to 8 until we reach the end of the array.
    // 10. Print the resultant array.

    public static int[] nextGreaterElement1(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int nextGrater[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGrater[i] = -1;
            } else {
                nextGrater[i] = arr[s.peek()];
            }
            // push in s
            s.push(i);
        }
        return nextGrater;
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            // i % n will give the index of the element in the array
            while (st.isEmpty() == false && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (i < n) {
                if (st.isEmpty() == false)
                    nge[i] = st.peek();
                else
                    nge[i] = -1;
            }

            st.push(nums[i % n]);
        }
        return nge;
    }

    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums2[s.peek()] <= nums2[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], nums2[s.peek()]);
            }
            // push in s
            s.push(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        Stack<Integer> s = new Stack<>();
        int nextGrater[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGrater[i] = -1;
            } else {
                nextGrater[i] = arr[s.peek()];
            }
            // push in s
            s.push(i);
        }
        for (int i = 0; i < nextGrater.length; i++) {
            System.out.print(nextGrater[i] + " ");
        }
        System.out.println();
    }
}
