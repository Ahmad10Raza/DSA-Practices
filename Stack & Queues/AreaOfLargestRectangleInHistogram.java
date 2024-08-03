
// Problem Statement: Given an array of integers heights representing the histogram's bar height where the width of each bar is 1  return the area of the largest rectangle in histogram.

// Example:

// Input: N =6, heights[] = {2,1,5,6,2,3}

// Output: 10
// Explanation: The largest rectangle is formed by the bars 5,6,2,3. The area of the rectangle is 2*5=10.

// Approach: We will use the stack to solve this problem. We will traverse the array from left to right. We will keep pushing the elements in the stack until we find the element which is less than the current element. If we find the element which is less than the current element, we will pop the elements from the stack until we find the element which is less than the current element. While popping the elements from the stack, we will calculate the area of the rectangle formed by the popped element. We will calculate the area by multiplying the height of the popped element with the difference between the current index and the index at the top of the stack. We will keep track of the maximum area of the rectangle formed by the elements in the stack. We will keep doing this until we reach the end of the array. At the end, we will have the maximum area of the rectangle formed by the elements in the array.

// Follow below steps to solve the problem:
// 1. Create a stack to store the index of the elements.
// 2. Create a variable maxArea to store the maximum area of the rectangle.
// 3. Traverse the array from left to right.
// 4. If the stack is empty or the current element is greater than the element at the top of the stack, push the current element in the stack.
// 5. If the current element is less than the element at the top of the stack, pop the elements from the stack until we find the element which is less than the current element.
// 6. While popping the elements from the stack, calculate the area of the rectangle formed by the popped element. Calculate the area by multiplying the height of the popped element with the difference between the current index and the index at the top of the stack.
// 7. Update the maxArea with the maximum of the current maxArea and the area of the rectangle formed by the popped element.
// 8. Repeat steps 4 to 7 until we reach the end of the array.
// 9. If the stack is not empty, pop the elements from the stack and calculate the area of the rectangle formed by the popped element. Calculate the area by multiplying the height of the popped element with the difference between the current index and the index at the top of the stack.
// 10. Update the maxArea with the maximum of the current maxArea and the area of the rectangle formed by the popped element.
// 11. Print the maxArea.

import java.util.Stack;

public class AreaOfLargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int height = heights[st.pop()];
            int width = st.isEmpty() ? n : n - st.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

    public static void main(String[] args) {

        // assuming width of each bar is 1
        int heights[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
    }
}
