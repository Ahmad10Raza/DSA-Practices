
// Java implementation of the
// above approach
import java.util.*;

class GFG {

    // Node of the binary tree
    static class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    };

    // Function to print flattened
    // binary tree
    static void print(node parent) {
        node curr = parent;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    static node prev;

    // Function to perform
    // in-order traversal
    static void Inorder(node curr) {
        // Base case
        if (curr == null)
            return;
        Inorder(curr.left);
        prev.left = null;
        prev.right = curr;
        prev = curr;
        Inorder(curr.right);
    }

    // Function to flatten binary
    // tree using level order
    // traversal
    static node flatten(node parent) {
        // Dummy node
        node dummy = new node(-1);

        // Pointer to previous
        // element
        prev = dummy;

        // Calling in-order
        // traversal
        Inorder(parent);

        prev.left = null;
        prev.right = null;
        node ret = dummy.right;

        // Delete dummy node
        // delete dummy;
        return ret;
    }

    // Driver code
    public static void main(String[] args) {
        node root = new node(5);
        root.left = new node(3);
        root.right = new node(7);
        root.left.left = new node(2);
        root.left.right = new node(4);
        root.right.left = new node(6);
        root.right.right = new node(8);

        // Calling required function
        print(flatten(root));
    }
}

// This code is contributed by Debojyoti Mandal
