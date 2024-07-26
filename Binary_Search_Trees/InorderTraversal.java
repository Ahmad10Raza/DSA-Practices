
// Given a binary tree, return the inorder traversal of its nodes' values.
// Inorder Traversal: Left, Root, Right

// Example:     50
//            /    \
//          30     70
//         /  \    /  \
//       20   40  60   80

// Inorder Traversal: 20, 30, 40, 50, 60, 70, 80

// Approach: 
// 1. Traverse the left subtree
// 2. Visit the root
// 3. Traverse the right subtree

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}
