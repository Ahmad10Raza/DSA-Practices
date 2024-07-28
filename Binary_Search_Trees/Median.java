/* Java program to find the median of BST in O(n) 
time and O(1) space*/
class GfG {

    /*
     * A binary search tree Node has data, pointer
     * to left child and a pointer to right child
     */
    static class Node {
        int data;
        Node left, right;
    }

    // A utility function to create a new BST node
    static Node newNode(int item) {
        Node temp = new Node();
        temp.data = item;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    /*
     * A utility function to insert a new node with
     * given key in BST
     */
    static Node insert(Node node, int key) {
        /* If the tree is empty, return a new node */
        if (node == null)
            return newNode(key);

        /* Otherwise, recur down the tree */
        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);

        /* return the (unchanged) node pointer */
        return node;
    }

    /*
     * Function to count nodes in a binary search tree
     * using Morris Inorder traversal
     */
    static int counNodes(Node root) {
        Node current, pre;

        // Initialise count of nodes as 0
        int count = 0;

        if (root == null)
            return count;

        current = root;
        while (current != null) {
            if (current.left == null) {
                // Count node if its left is NULL
                count++;

                // Move to its right
                current = current.right;
            } else {
                /* Find the inorder predecessor of current */
                pre = current.left;

                while (pre.right != null &&
                        pre.right != current)
                    pre = pre.right;

                /*
                 * Make current as right child of its
                 * inorder predecessor
                 */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                /*
                 * Revert the changes made in if part to
                 * restore the original tree i.e., fix
                 * the right child of predecessor
                 */
                else {
                    pre.right = null;

                    // Increment count if the current
                    // node is to be visited
                    count++;
                    current = current.right;
                } /* End of if condition pre->right == NULL */
            } /* End of if condition current->left == NULL */
        } /* End of while */

        return count;
    }

    /*
     * Function to find median in O(n) time and O(1) space
     * using Morris Inorder traversal
     */
    static int findMedian(Node root) {
        if (root == null)
            return 0;

        int count = counNodes(root);
        int currCount = 0;
        Node current = root, pre = null, prev = null;

        while (current != null) {
            if (current.left == null) {
                // count current node
                currCount++;

                // check if current node is the median
                // Odd case
                if (count % 2 != 0 && currCount == (count + 1) / 2)
                    return current.data;

                // Even case
                else if (count % 2 == 0 && currCount == (count / 2) + 1)
                    return (prev.data + current.data) / 2;

                // Update prev for even no. of nodes
                prev = current;

                // Move to the right
                current = current.right;
            } else {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                /*
                 * Revert the changes made in if part to restore the original
                 * tree i.e., fix the right child of predecessor
                 */
                else {
                    pre.right = null;

                    prev = pre;

                    // Count current node
                    currCount++;

                    // Check if the current node is the median
                    if (count % 2 != 0 && currCount == (count + 1) / 2)
                        return current.data;

                    else if (count % 2 == 0 && currCount == (count / 2) + 1)
                        return (prev.data + current.data) / 2;

                    // update prev node for the case of even
                    // no. of nodes
                    prev = current;
                    current = current.right;

                } /* End of if condition pre->right == NULL */
            } /* End of if condition current->left == NULL */
        } /* End of while */
        return -1;
    }

    /* Driver code */
    public static void main(String[] args) {

        /*
         * Let us create following BST
         * 50
         * / \
         * 30 70
         * / \ / \
         * 20 40 60 80
         */
        Node root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);

        System.out.println("Median of BST is " + findMedian(root));
    }
}
