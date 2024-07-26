
// Given a binary tree, return the postorder traversal of its nodes' values.
// Postorder Traversal: Left, Right, Root

// Example:     50
//            /    \
//          30     70
//         /  \    /  \
//       20   40  60   80

// Postorder Traversal: 20, 40, 30, 60, 80, 70, 50

// Approach:
// 1. Traverse the left subtree
// 2. Traverse the right subtree
// 3. Visit the root

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

public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }
}
