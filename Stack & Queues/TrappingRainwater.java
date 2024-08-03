
// Problem Statement: Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.

// Examples:

// Example 1:

// Input: height= [0,1,0,2,1,0,1,3,2,1,2,1]

// Output: 6

// Explanation: As seen from the diagram 1+1+2+1+1=6 unit of water can be trapped

// Approach:  Take 2 pointers l(left pointer) and r(right pointer) pointing to 0th and (n-1)th index respectively. Take two variables leftMax and rightMax and initialize them to 0. If height[l] is less than or equal to height[r] then if leftMax is less than height[l] update leftMax to height[l] else add leftMax-height[l] to your final answer and move the l pointer to the right i.e l++. If height[r] is less than height[l], then now we are dealing with the right block. If height[r] is greater than rightMax, then update rightMax to height[r] else add rightMax-height[r] to the final answer. Now move r to the left. Repeat these steps till l and r crosses each other.

// Follow below steps to solve the problem:
// 1. Take 2 pointers l(left pointer) and r(right pointer) pointing to 0th and (n-1)th index respectively.
// 2. Take two variables leftMax and rightMax and initialize them to 0.
// 3. If height[l] is less than or equal to height[r] then
//     a. If leftMax is less than height[l] update leftMax to height[l]
//     b. Else add leftMax-height[l] to your final answer and move the l pointer to the right i.e l++.
// 4. If height[r] is less than height[l], then now we are dealing with the right block.
//     a. If height[r] is greater than rightMax, then update rightMax to height[r]
//     b. Else add rightMax-height[r] to the final answer.
// 5. Now move r to the left.
// 6. Repeat steps 3 to 5 till l and r crosses each other.
// 7. Print the final answer.

public class TrappingRainwater {

    public static int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (leftMax < height[l]) {
                    leftMax = height[l];
                } else {
                    water += leftMax - height[l];
                }
                l++;
            } else {
                if (height[r] >= rightMax) {
                    rightMax = height[r];
                } else {
                    water += rightMax - height[r];
                }
                r--;
            }
        }
        return water;
    }

    public static void main(String[] args) {

        // assuming width of each bar is 1
        int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }
}
