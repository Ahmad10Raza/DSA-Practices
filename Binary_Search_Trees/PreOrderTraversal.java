
// Given a binary tree, return the preorder traversal of its nodes' values.
// Preorder Traversal: Root, Left, Right

// Example:     50
//            /    \
//          30     70
//         /  \    /  \
//       20   40  60   80

// Preorder Traversal: 50, 30, 20, 40, 70, 60, 80

// Approach:
// 1. Visit the root
// 2. Traverse the left subtree
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

public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }
}
