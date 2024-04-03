// Given three stacks of the positive numbers, the task is to find the possible 
// equal maximum sum of the stacks with the removal of top elements allowed. 
// Stacks are represented as an array, and the first index of the array represent the top element of the stack.

// Examples: 

// Input : stack1[] = { 3, 10}
//   stack2[] = { 4, 5 }
//   stack3[] = { 2, 1 }
// Output : 0
// Sum can only be equal after removing all elements 
// from all stacks.

public  class MaxEqualSumOfThreeStacks {
    
    public static void main(String[] args) {
        int stack1[] = { 3, 2, 1, 1, 1 };
        int stack2[] = { 4, 3, 2 };
        int stack3[] = { 1, 1, 4, 1 };

        System.out.println(maxSum(stack1, stack2, stack3));
    }

    // Approach 1:The idea is to compare the sum of each stack, if they are not same, remove the 
                    // top element of the stack having the maximum sum.

// Algorithm for solving this problem: 

// Find the sum of all elements of in individual stacks.
// If the sum of all three stacks is the same, then this is the maximum sum.
// Else remove the top element of the stack having the maximum sum among three of stacks. Repeat step 1 and step 2.
// The approach works because elements are positive. To make sum equal, we must remove some element from stack having more sum, and we can only remove from the top.

// Below is the implementation of this approach: 



    public static int maxSum(int stack1[], int stack2[], int stack3[]) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i = 0; i < stack1.length; i++) {
            sum1 += stack1[i];
        }

        for (int i = 0; i < stack2.length; i++) {
            sum2 += stack2[i];
        }

        for (int i = 0; i < stack3.length; i++) {
            sum3 += stack3[i];
        }

        int top1 = 0, top2 = 0, top3 = 0;

        while (true) {
            if (top1 == stack1.length || top2 == stack2.length || top3 == stack3.length) {
                return 0;
            }

            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= stack1[top1++];
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= stack2[top2++];
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= stack3[top3++];
            }
        }
    }
}
