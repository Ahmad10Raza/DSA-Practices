/*
 * @lc app=leetcode id=872 lang=java
 *
 * [872] Leaf-Similar Trees
 */

// @lc code=start

import java.util.List;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


//  Leaf-Similar Trees
// Category	Difficulty	Likes	Dislikes
// algorithms	Easy (70.20%)	4089	112
// Tags
// Companies
// Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.



// For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

// Two binary trees are considered leaf-similar if their leaf value sequence is the same.

// Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 

// Example 1:


// Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
// Output: true
// Example 2:


// Input: root1 = [1,2,3], root2 = [1,3,2]
// Output: false
 

// Constraints:

// The number of nodes in each tree will be in the range [1, 200].
// Both of the given trees will have values in the range [0, 200].
// Submissions | Solution

// Approach: Recursion
// Time Complexity: O(n1 + n2), where n1, n2 are the number of nodes in the two trees
// Space Complexity: O(n1 + n2), the space used in storing the leaf values
// We can use a depth-first search to find the leaf value sequence of the two trees. After finding the leaf value sequence, we can compare the two sequences to determine if they are equal.
// To find the leaf value sequence of a tree, we can use a depth-first search. We can start from the root of the tree and traverse the tree in a depth-first manner. When we reach a leaf node, we can add the value of the leaf node to the leaf value sequence.
// We can use a helper function to perform the depth-first search. The helper function will take the root of the tree and a list to store the leaf values. If the root is a leaf node, we can add the value of the leaf node to the list. Otherwise, we can recursively call the helper function on the left and right children of the root.
// After finding the leaf value sequence of the two trees, we can compare the two sequences to determine if they are equal. If the two sequences are equal, we can return true. Otherwise, we can return false.


class Solution {



    // Helper function to find the leaf value sequence of a tree
    private void findLeafValues(TreeNode root, List<Integer> leafValues) {
        // Base case: if the root is null, return
        if (root == null) {
            return;
        }
        
        // If the root is a leaf node, add the value to the list
        if (root.left == null && root.right == null) {
            leafValues.add(root.val);
        }
        
        // Recursively find the leaf value sequence of the left and right subtrees
        findLeafValues(root.left, leafValues);
        findLeafValues(root.right, leafValues);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        // List to store the leaf values of the two trees
        List<Integer> leafValues1 = new ArrayList<>();
        List<Integer> leafValues2 = new ArrayList<>();
        
        // Find the leaf value sequence of the first tree
        findLeafValues(root1, leafValues1);
        
        // Find the leaf value sequence of the second tree
        findLeafValues(root2, leafValues2);
        
        // Compare the two leaf value sequences
        return leafValues1.equals(leafValues2);
    }
    
}
// @lc code=end

