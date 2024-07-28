import java.util.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BinarySearchTreesDS {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTreesDS() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    Node insertIterative(Node root, int key) {
        Node newNode = new Node(key);
        Node parent = null, current = root;

        while (current != null) {
            parent = current;
            if (key < current.key)
                current = current.left;
            else
                current = current.right;
        }

        if (parent == null)
            parent = newNode;
        else if (key < parent.key)
            parent.left = newNode;
        else
            parent.right = newNode;

        return parent;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null || root.key == key)
            return root != null;

        if (key < root.key)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }

    int searchIterative(Node root, int key) {
        Node current = root;
        while (current != null) {
            if (key == current.key)
                return current.key;
            else if (key < current.key)
                current = current.left;
            else
                current = current.right;
        }
        return -1;
    }

    void delete(int key) {
        root = deleteRec(root, key);
    }

    // Follows the below steps to delete the node from the BST:
    // 1. If the node to be deleted is a leaf node, then delete the node.
    // 2. If the node to be deleted has only one child, then copy the child to the
    // node and delete the child.
    // 3. If the node to be deleted has two children, then find the inorder
    // successor of the node. Copy the inorder successor to the node and delete the
    // inorder successor.

    Node deleteRec(Node root, int key) {
        if (root == null)
            return root;

        // If the key to be deleted is smaller than the root's key, then it lies in the
        // left subtree
        if (key < root.key)
            // Recursively call the delete function for the left subtree
            root.left = deleteRec(root.left, key);
        // If the key to be deleted is greater than the root's key, then it lies in the
        // right subtree
        else if (key > root.key)
            // Recursively call the delete function for the right subtree
            root.right = deleteRec(root.right, key);

        // If the key is same as root's key, then this is the node to be deleted
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right
            // subtree)
            root.key = inorderSuccessor(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // Find the inorder successor of the node

    // Inorder successor is the leftmost node in the right subtree

    // Tree: 50
    // / \
    // 30 70
    // / \ / \
    // 20 40 60 80

    // Inorder traversal of the tree: 20 30 40 50 60 70 80
    // Inorder successor of 50: 60

    int inorderSuccessor(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Function to print node in range k1 and k2

    // Tree: 50
    // / \
    // 30 70
    // / \ / \
    // 20 40 60 80

    // Input: k1 = 20, k2 = 70
    // Output: 20 30 40 50 60 70

    // Follows the below steps to print the nodes in the given range:
    // 1. If the root is null, then return.
    // 2. If the k1 is less than the root's key, then recursively call the function
    // for
    // the left subtree.
    // 3. If the k1 is less than or equal to the root's key and k2 is greater than
    // or
    // equal to the root's key, then print the root's key.
    // 4. If the k2 is greater than the root's key, then recursively call the
    // function
    // for the right subtree.

    public void printInRange(Node root, int k1, int k2) {
        if (root == null)
            return;

        if (k1 < root.key)
            printInRange(root.left, k1, k2);

        if (k1 <= root.key && k2 >= root.key)
            System.out.print(root.key + " ");

        if (k2 > root.key)
            printInRange(root.right, k1, k2);
    }

    // Function to count node in given range in a BST

    // Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number
    // of nodes in the BST that lie in the given range.

    // The values smaller than root go to the left side
    // The values greater and equal to the root go to the right side

    // Input:
    // 10
    // / \
    // 5 50
    // / / \
    // 1 40 100
    // l = 5, h = 45
    // Output: 3
    // Explanation: 5 10 40 are the node in the
    // range

    // Follows the below steps to count the nodes in the given range:
    // 1. If the root is null, then return 0.
    // 2. If the root's key is greater than h, then recursively call the function
    // for
    // the left subtree.
    // 3. If the root's key is smaller than l, then recursively call the function
    // for
    // the right subtree.
    // 4. If the root's key is in the range, then recursively call the function for
    // both left and right subtrees.

    public int getCountOfNode(Node root, int l, int h) {
        if (root == null)
            return 0;

        if (root.key == h && root.key == l)
            return 1;

        if (root.key <= h && root.key >= l)
            return 1 + getCountOfNode(root.left, l, h) + getCountOfNode(root.right, l, h);
        else if (root.key < l)
            return getCountOfNode(root.right, l, h);
        else
            return getCountOfNode(root.left, l, h);
    }

    // Function to print node to root node path to leaf node

    // Tree: 50
    // / \
    // 30 70
    // / \ / \
    // 20 40 60 80

    // Input: ~
    // Output: 50 30 20
    // 50 30 40
    // 50 70 60
    // 50 70 80

    // Follows the below steps to print the path from the root node to the leaf
    // node:
    // 1. If the root is null, then return.
    // 2. Add the root's key to the path.
    // 3. If the root is a leaf node, then print the path.
    // 4. Recursively call the function for the left and right subtrees.
    // 5. Remove the last element from the path.

    public void printRootToLeaf(Node root, List<Integer> path) {
        if (root == null)
            return;

        path.add(root.key);

        if (root.left == null && root.right == null) {
            System.out.println(path);
            path.remove(path.size() - 1);
            return;
        }

        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);

        path.remove(path.size() - 1); // Backtrack to the parent node after printing the path
    }

    // Function to check given tree is BST or not

    // Tree: 50
    // / \
    // 30 70
    // / \ / \
    // 20 40 60 80

    // Output: Given tree is a BST

    // Approach: The idea is to do an inorder traversal of the BST and keep track of
    // the previous node visited.
    // If the current node's value is less than the previous node's value, then the
    // tree is not a BST.

    public boolean isBST(Node root) {
        List<Integer> nodes = new ArrayList<>();
        inorder2(root, nodes);
        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(i) <= nodes.get(i - 1))
                return false;
        }
        return true;
    }

    public boolean isValidBST(Node root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(Node root, long minVal, long maxVal) {
        if (root == null)
            return true;
        // If the current node's value is less than the minimum value or greater than
        // the maximum value, then the tree is not a BST.
        if (root.key >= maxVal || root.key <= minVal)
            return false;
        // Recursively call the function for the left subtree with the updated maximum
        // value and minimum value.
        return isValidBST(root.left, minVal, root.key) && isValidBST(root.right, root.key, maxVal);
    }

    // Using prev pointer to check if the tree is BST or not

    public boolean isBSTUsingPrev(Node root) {
        Node prev = null;
        return isBSTUsingPrev(root, prev);
    }

    public boolean isBSTUsingPrev(Node root, Node prev) {
        if (root != null) {
            if (!isBSTUsingPrev(root.left, prev))
                return false;

            if (prev != null && root.key <= prev.key)
                return false;

            prev = root;
            return isBSTUsingPrev(root.right, prev);
        }
        return true;
    }

    // Function to print mirror of the tree

    // Tree: 50
    // / \
    // 30 70
    // / \ / \
    // 20 40 60 80

    // Output: 50 70 80 60 30 40 20

    // Follows the below steps to print the mirror of the tree:
    // 1. If the root is null, then return.
    // 2. Recursively call the function for the left and right subtrees.
    // 3. Swap the left and right child of the root.

    public void mirror(Node root) {
        if (root == null)
            return;

        mirror(root.left);
        mirror(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // function to construct Balanced BST from sorted array

    // Input: 1 2 3 4 5 6 7
    // Output: 4 2 6 1 3 5 7 (Inorder traversal of the constructed BST)
    // Tree: 4
    // / \
    // 2 6
    // / \ / \
    // 1 3 5 7

    // Approach: The idea is to insert the middle element of the array to the root
    // and recursively construct the left and right subtrees.

    // Follows the below steps to construct the Balanced BST from the sorted array:
    // 1. If the start is greater than the end, then return null.
    // 2. Find the middle element of the array.
    // 3. Create a new node with the middle element.
    // 4. Recursively call the function for the left and right subtrees.
    // 5. Return the root node.

    public Node sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = sortedArrayToBST(arr, start, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, end);

        return root;
    }

    public Node sortedArrayToBST(int[] arr) {
        return sortedArrayToBST(arr, 0, arr.length - 1);
    }

    // Function to convert BST to Balanced BST

    public Node balanceBST(Node root) {
        List<Node> nodes = new ArrayList<>();
        inorder(root, nodes);

        return buildBalancedBST(nodes, 0, nodes.size() - 1);
    }

    void inorder(Node root, List<Node> nodes) {
        if (root == null)
            return;

        inorder(root.left, nodes);
        nodes.add(root);
        inorder(root.right, nodes);
    }

    Node buildBalancedBST(List<Node> nodes, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node root = nodes.get(mid);

        root.left = buildBalancedBST(nodes, start, mid - 1);
        root.right = buildBalancedBST(nodes, mid + 1, end);

        return root;
    }

    // Function to merge two BSTs

    // Tree1: 50
    // / \
    // 30 70
    // / \ / \
    // 20 40 60 80

    // Tree2: 55
    // / \
    // 35 75
    // / \ / \
    // 25 45 65 85

    // Output: 20 25 30 35 40 45 50 55 60 65 70 75 80 85

    // Approach: The idea is to do an inorder traversal of both BSTs and merge the
    // nodes of both BSTs into a single list.
    // After merging the nodes, construct a balanced BST from the merged list.

    // Follows the below steps to merge two BSTs:
    // 1. Do an inorder traversal of the first BST and store the nodes in a list.
    // 2. Do an inorder traversal of the second BST and store the nodes in a list.
    // 3. Merge the nodes of both BSTs into a single list.
    // 4. Construct a balanced BST from the merged list.

    public Node mergeBSTs(Node root1, Node root2) {
        List<Node> nodes1 = new ArrayList<>();
        List<Node> nodes2 = new ArrayList<>();

        inorder(root1, nodes1);
        inorder(root2, nodes2);

        List<Node> merged = merge(nodes1, nodes2);

        return buildBalancedBST(merged, 0, merged.size() - 1);
    }

    List<Node> merge(List<Node> nodes1, List<Node> nodes2) {
        List<Node> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nodes1.size() && j < nodes2.size()) {
            if (nodes1.get(i).key < nodes2.get(j).key)
                merged.add(nodes1.get(i++));
            else
                merged.add(nodes2.get(j++));
        }

        while (i < nodes1.size())
            merged.add(nodes1.get(i++));

        while (j < nodes2.size())
            merged.add(nodes2.get(j++));

        return merged;
    }

    // Function to find minimum and maximum element in the BST

    // Tree: 50
    // / \
    // 30 70
    // / \ / \
    // 20 40 60 80

    // Output: Minimum: 20, Maximum: 80

    public void findMinMax(Node root) {
        Node current = root;
        while (current.left != null)
            current = current.left;

        System.out.println("Minimum: " + current.key);

        current = root;
        while (current.right != null)
            current = current.right;

        System.out.println("Maximum: " + current.key);
    }

    // Function to find get predecessor of the node

    // Inorder predecessor is the rightmost node in the left subtree

    // Tree: 50
    // / \
    // 30 70
    // / \ / \
    // 20 40 60 80

    // Inorder traversal of the tree: 20 30 40 50 60 70 80
    // Inorder predecessor of 50: 40

    public int inorderPredecessor(Node root) {
        int maxv = root.key;
        while (root.right != null) {
            maxv = root.right.key;
            root = root.right;
        }
        return maxv;
    }

    // Function to find Populate Inorder successor of all nodes

    // Given a Binary Tree, write a function to populate next pointer for all nodes.
    // The next pointer for every node should be set
    // to point to inorder successor.

    // Tree: 50
    // / \
    // 30 70
    // / \ / \
    // 20 40 60 80

    // Output: 20->30->40->50->60->70->80

    public void populateInorderSuccessor(Node root) {
        Node next = null;
        populateInorderSuccessor(root, next);
    }

    public void populateInorderSuccessor(Node root, Node next) {

        // The first visited node will be the rightmost node
        // next of the rightmost node will be NULL
        if (root != null) {
            // First set the next pointer in right subtree
            populateInorderSuccessor(root.right, next);

            // Set the next as previously visited node in
            // reverse Inorder
            root.right = next;
            next = root;
            // Finally, set the next pointer in left subtree
            populateInorderSuccessor(root.left, next);
        }
    }

    // Function to Find LCA of 2 nodes in a BST

    // LCA means Lowest Common Ancestor

    // Tree: 50
    // / \
    // 30 70
    // / \ / \
    // 20 40 60 80

    // Input: 20, 40
    // Output: 30

    // Approach: The idea is to traverse the tree starting from the root node.
    // If both n1 and n2 are smaller than the root, then the LCA lies in the left
    // subtree.
    // If both n1 and n2 are greater than the root, then the LCA lies in the right
    // subtree.
    // Otherwise, the root is the LCA.
    public Node LCA(Node root, int n1, int n2) {
        if (root == null)
            return null;

        if (root.key > n1 && root.key > n2)
            return LCA(root.left, n1, n2);

        if (root.key < n1 && root.key < n2)
            return LCA(root.right, n1, n2);

        return root;
    }

    // Function to find LCA of 2 nodes in a BST Using Iterative Approach

    public Node LCAIterative(Node root, int n1, int n2) {
        while (root != null) {
            if (root.key > n1 && root.key > n2)
                root = root.left;
            else if (root.key < n1 && root.key < n2)
                root = root.right;
            else
                break;
        }
        return root;
    }

    // Function to Construct BST from preorder traversal

    // Input: 10 5 1 7 40 50

    // Output: 10
    // / \
    // 5 40
    // / \ \
    // 1 7 50

    /*
     * Approach
     * 
     * Follow the below steps to solve the problem:
     * 
     * Initialize the range as {INT_MIN .. INT_MAX}
     * The first node will definitely be in range, so create a root node.
     * To construct the left subtree, set the range as {INT_MIN …root->data}.
     * If a value is in the range {INT_MIN .. root->data}, the values are part of
     * the left subtree.
     * To construct the right subtree, set the range as {root->data..max ..
     * INT_MAX}.
     * If a value is in the range {root->data..max .. INT_MAX}, the values are part
     * of the right subtree.
     * 
     */

    // Follows the below steps to construct the BST from the preorder traversal:
    // 1. If the index is greater than or equal to the length of the preorder array,
    // then return null.
    // 2. If the value is not in the range, then return null.
    // 3. Create a new node with the value.
    // 4. Recursively call the function for the left and right subtrees.
    // 5. Return the root node.

    public Node constructBSTFromPreorder(int[] preorder) {
        return constructBSTFromPreorder(preorder, new int[] { 0 }, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public Node constructBSTFromPreorder(int[] preorder, int[] index, int min, int max) {
        if (index[0] >= preorder.length)
            return null;

        int key = preorder[index[0]];
        if (key < min || key > max)
            return null;

        Node root = new Node(key);
        index[0]++;

        root.left = constructBSTFromPreorder(preorder, index, min, key);
        root.right = constructBSTFromPreorder(preorder, index, key, max);

        return root;
    }

    // Function to Convert Binary tree into BST
    /*
     * Example 1
     * Input:
     * 10
     * / \
     * 2 7
     * / \
     * 8 4
     * Output:
     * 8
     * / \
     * 4 10
     * / \
     * 2 7
     * 
     * Solution:
     * 
     * Following is a 3 step solution for converting Binary tree to Binary Search
     * Tree.
     * 
     * 1. Create a temp array arr[] that stores inorder traversal of the tree. This
     * step takes O(n) time.
     * 2. Sort the temp array arr[]. Time complexity of this step depends upon the
     * sorting algorithm.
     * In the following implementation, Quick Sort is used which takes (n^2) time.
     * This can be done in O(nLogn) time using Heap Sort or Merge Sort.
     * 3. Again do inorder traversal of tree and copy array elements to tree nodes
     * one by one. This step takes O(n) time.
     */

    public Node binaryTreeToBST(Node root) {
        List<Integer> nodes = new ArrayList<>();
        inorder2(root, nodes);
        Collections.sort(nodes);
        return binaryTreeToBST(root, nodes, new int[] { 0 });
    }

    public Node binaryTreeToBST(Node root, List<Integer> nodes, int[] index) {
        if (root == null)
            return null;

        root.left = binaryTreeToBST(root.left, nodes, index);
        root.key = nodes.get(index[0]++);
        root.right = binaryTreeToBST(root.right, nodes, index);

        return root;
    }

    public void inorder2(Node root, List<Integer> nodes) {
        if (root == null)
            return;

        inorder2(root.left, nodes);
        nodes.add(root.key);
        inorder2(root.right, nodes);
    }

    // Function to find kth smallest element in the BST

    // Tree: 50
    // / \
    // 30 70
    // / \ / \
    // 20 40 60 80

    // Input: 3
    // Output: 40

    // Approach: The idea is to do an inorder traversal of the BST and store the
    // nodes in a list.
    // The kth smallest element will be the k-1th element in the list.

    public int kthSmallestNaive(Node root, int k) {
        List<Integer> nodes = new ArrayList<>();
        inorder2(root, nodes);
        return nodes.get(k - 1);
    }

    // Approach: The idea is to do an inorder traversal of the BST and keep a count
    // of the number of nodes visited.
    // The count will be equal to k when the kth smallest element is visited.

    // Using Iterative Approach
    public int kthSmallestIterative(Node root, int k) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        int count = 0;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            count++;
            if (count == k)
                return current.key;

            current = current.right;
        }

        return -1;
    }

    // Using recursive approach to find kth smallest element in the BST

    public int kthSmallest(Node root, int k, int[] count) {
        if (root == null)
            return -1;

        int left = kthSmallest(root.left, k, count);
        if (left != -1)
            return left;

        count[0]++;
        if (count[0] == k)
            return root.key;

        return kthSmallest(root.right, k, count);
    }

    public int kthSmallest(Node root, int k) {
        return kthSmallest(root, k, new int[] { 0 });
    }

    // Function to find kth largest element in the BST

    // Tree: 50
    // / \
    // 30 70
    // / \ / \
    // 20 40 60 80

    // Input: 3
    // Output: 60

    // Approach: The idea is to do a reverse inorder traversal of the BST and keep a
    // count of the number of nodes visited.
    // The count will be equal to k when the kth largest element is visited.

    public int kthLargest(Node root, int k) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        int count = 0;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }

            current = stack.pop();
            count++;
            if (count == k)
                return current.key;

            current = current.left;
        }

        return -1;
    }

    // Function to find kth largest element in the BST using recursive approach

    // Follows the below steps to find the kth largest element in the BST:
    // 1. If the root is null, then return -1.
    // 2. Recursively call the function for the right subtree.
    // 3. Increment the count.
    // 4. If the count is equal to k, then return the root's key.
    // 5. Recursively call the function for the left subtree.

    public int kthLargest(Node root, int k, int count[]) {
        if (root == null)
            return -1;

        int right = kthLargest(root.right, k, count);
        if (right != -1)
            return right;

        count[0]++;
        if (count[0] == k)
            return root.key;

        return kthLargest(root.left, k, count);
    }

    public int kthLargest2(Node root, int k) {
        return kthLargest(root, k, new int[] { 0 });
    }

    // Function to Count pairs from 2 BST whose sum is equal to given value "X"

    // Input : BST 1: 5
    // / \
    // 3 7
    // / \ / \
    // 2 4 6 8

    // BST 2: 10
    // / \
    // 6 15
    // / \ / \
    // 3 8 11 18
    // x = 16

    // Output : 3
    // The pairs are:
    // (5, 11), (6, 10) and (8, 8)

    // Follows the below steps to count the pairs from 2 BSTs whose sum is equal to
    // the given value:
    // 1. Create an empty set to store the nodes of the second BST.
    // 2. Do an inorder traversal of the second BST and store the nodes in the set.
    // 3. Traverse the first BST and search for (x-a) in the set.
    // 4. If the (x-a) is found in the set, then increment the count.

    public int countPairs(Node root1, Node root2, int x) {
        Set<Integer> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        Node curr = root2;

        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            set.add(curr.key);
            curr = curr.right;
        }

        // Traverse BST 1 and search for (x-a) in the set
        int count = 0;
        curr = root1;

        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (set.contains(x - curr.key))
                count++;
            curr = curr.right;
        }
        return count;
    }

    // Function to Count BST nodes that lie in a given range

    // Tree1: 50
    // / \
    // 30 70
    // / \ / \
    // 20 40 60 80

    // Input: lb = 30, ub = 60
    // Output: 5

    public int getCount(Node root, int lb, int ub) {

        if (root.key >= lb && root.key <= ub) {
            return 1 + getCount(root.left, lb, ub) + getCount(root.right, lb, ub);
        }

        else if (root.key < lb) {
            return getCount(root.right, lb, ub);
        } else {
            return getCount(root.left, lb, ub);
        }
    }

    // Function to Find the median of BST in O(n) time and O(1) space

    // Tree: 50
    // / \
    // 30 70
    // / \ / \
    // 20 40 60 80

    // Output: 50

    // Approach: The idea is to do a reverse inorder traversal of the BST and keep a
    // count of the number of nodes visited.
    // The count will be equal to n/2 when the median element is visited.

    // Follows the below steps to find the median of the BST:
    // 1. If the root is null, then return 0.
    // 2. Recursively call the function for the right subtree.
    // 3. Increment the count.
    // 4. If the count is equal to n/2, then return the root's key.
    // 5. Recursively call the function for the left subtree.

    public int countNodes(Node root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int findMedian(Node root, int count, int[] median) {
        if (root == null)
            return 0;

        findMedian(root.left, count, median);
        count--;

        if (count == 0)
            median[0] = root.key;

        findMedian(root.right, count, median);

        return median[0];
    }

    public int findMedian(Node root) {
        int count = countNodes(root);
        int[] median = new int[] { 0 };
        return findMedian(root, (count + 1) / 2, median);
    }

    // Function to Replace every element with the least greater element on its right

    // Tree: 8
    // / \
    // 58 71
    // / \ \
    // 13 47 74

    // Output: 13 47 58 71 74

    // Approach: If we traverse the array from backwards, we need a data
    // structure(ds) to support:
    // Insert an element into our ds in sorted order (so at any point of time the
    // elements in our ds are sorted)
    // Finding the upper bound of the current element (upper bound will give just
    // greater element from our ds if present)

    public void replaceWithLeastGreater(Node root, int[] succ) {
        if (root == null)
            return;

        replaceWithLeastGreater(root.right, succ);
        if (succ[0] != -1)
            root.key = succ[0];
        succ[0] = root.key;
        replaceWithLeastGreater(root.left, succ);
    }

    public void replaceWithLeastGreater(Node root) {
        int[] succ = new int[] { -1 };
        replaceWithLeastGreater(root, succ);
    }

    public void replaceWithLeastGreater2(int[] arr) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = arr.length - 1; i >= 0; i--) { // traversing the array backwards
            s.add(arr[i]); // inserting the element into set
            Integer it = s.higher(arr[i]); // finding upper bound
            // (higher in java)
            if (it == null)
                arr[i] = -1; // if upper_bound does not
                             // exist then -1
            else
                arr[i] = it; // if upper_bound exists, lets
                             // take it
        }
    }

    // Function to print Flatten BST to sorted list

    // Tree: 5
    // / \
    // 3 7
    // / \ / \
    // 2 4 6 8

    // Output: 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
    // | | | | | |
    // NULL NULL NULL NULL NULL NULL

    // Approach 1: In this approach we will use inorder traversal to flatten the BST
    // when we move to next node just after leaving
    // the current node we will set the left of current node to null and right of
    // current node to next node.
    // Time Complexity: O(n) and Space Complexity: O(H)

    public void flattenBST(Node root) {
        if (root == null)
            return;

        Node current = root;
        while (current != null) {
            if (current.left != null) {
                Node right = current.left;
                while (right.right != null)
                    right = right.right;

                right.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    // Approach 2: In this approch we will use inorder traversal to flatten the BST
    // when we move to next node just after leaving
    // the current node we will set the left of current node to null and right of
    // current node to next node.
    public void inorder3(Node root, Node prev) {
        if (root == null)
            return;

        inorder3(root.left, prev);
        root.left = null;
        prev.right = root;
        prev = root;
        inorder3(root.right, prev);
    }

    static Node prev;

    // Function to perform
    // in-order traversal
    public void Inorder(Node curr) {
        // Base case
        if (curr == null)
            return;
        Inorder(curr.left);
        prev.left = null;
        prev.right = curr;
        prev = curr;
        Inorder(curr.right);
    }

    /*
     * // Function to flatten binary
     * // tree using level order
     * // traversal
     * public Node flattenBST(Node parent)
     * {
     * // Dummy node
     * Node dummy = new Node(-1);
     * 
     * // Pointer to previous
     * // element
     * prev = dummy;
     * 
     * // Calling in-order
     * // traversal
     * Inorder(parent);
     * 
     * prev.left = null;
     * prev.right = null;
     * Node ret = dummy.right;
     * 
     * // Delete dummy node
     * //delete dummy;
     * return ret;
     * }
     */
    public Node flattenBST2(Node root) {
        Node dummy = new Node(-1);
        Node prev = dummy;
        inorder3(root, dummy);

        prev.left = null;
        prev.right = null;
        Node ret = dummy.right;

        return ret;

    }

    // Function to Check whether BST contains Dead end

    // Tree: 8
    // / \
    // 5 9
    // / \
    // 2 7
    // /
    // 6

    // Output: Yes

    // Approach: The idea is to do an inorder traversal of the BST and keep track of
    // the minimum and maximum values visited so far.
    // For each node, check if the node value is equal to the minimum value or
    // maximum value. If yes, then it is a dead end.

    public boolean isDeadEnd(Node root, int min, int max) {
        if (root == null)
            return false;

        if (min == max)
            return true;

        return isDeadEnd(root.left, min, root.key - 1) || isDeadEnd(root.right, root.key + 1, max);
    }

    public boolean isDeadEnd(Node root) {
        return isDeadEnd(root, 1, Integer.MAX_VALUE);
    }

    // Function to Check preorder is valid or not

    // Tree: 8
    // / \
    // 5 1
    // / \
    // 7 6

    // Input: 8 5 1 7 6
    // Output: False

    // Approach: The idea is to use a stack to simulate the preorder traversal of
    // the BST.
    // For each node, if the current node value is less than the previous node
    // value,
    // then it is not a valid preorder traversal.

    public boolean isValidPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < root)
                return false;

            while (!stack.isEmpty() && stack.peek() < preorder[i])
                root = stack.pop();

            stack.push(preorder[i]);
        }

        return true;
    }

    // Using O(1) space

    public boolean isValidPreorder2(int[] preorder) {
        int root = Integer.MIN_VALUE;
        int i = -1;

        for (int j = 0; j < preorder.length; j++) {
            if (preorder[j] < root)
                return false;

            while (i >= 0 && preorder[j] > preorder[i])
                root = preorder[i--];

            preorder[++i] = preorder[j];
        }

        return true;
    }

    // Function to Given "n" appointments, find the conflicting appointments

    // Input: 1 5, 3 7, 2 6, 10 15, 5 6
    // Output: 3 7, 2 6, 5 6

    // Approach: The idea is to use a TreeMap to store the end time of the
    // appointments.
    // For each appointment, check if the start time is less than the end time of
    // the previous appointment.
    // If yes, then it is a conflicting appointment.

    public void conflictingAppointments(int[][] appointments) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] appointment : appointments) {
            Integer prev = map.floorKey(appointment[0]);
            if (prev != null && map.get(prev) > appointment[0])
                System.out.println(prev + " " + map.get(prev));

            Integer next = map.ceilingKey(appointment[0]);
            if (next != null && next < appointment[1])
                System.out.println(next + " " + map.get(next));

            map.put(appointment[0], appointment[1]);
        }
    }

    public static void main(String[] args) {
        BinarySearchTreesDS bst = new BinarySearchTreesDS();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder traversal of the BST:");
        bst.inorder();

        // int key = 60;
        // if (bst.search(key))
        // System.out.println("\nKey " + key + " found in the BST");
        // else
        // System.out.println("\nKey " + key + " not found in the BST");

        // bst.delete(20);
        // System.out.println("\nInorder traversal after deleting 20:");
        // bst.inorder();

        // System.out.println("\nFollowing Ouput is the nodes in the range K1 and K2:");
        // bst.printInRange(bst.root, 20, 70);

        // System.out.println("\nFollowing Ouput is the nodes from root to leaf:");
        // bst.printRootToLeaf(bst.root, new ArrayList<>());

        // if (bst.isBST(bst.root))
        // System.out.println("Given tree is a BST");
        // else
        // System.out.println("Given tree is not a BST");

        // if (bst.isBSTUsingPrev(bst.root))
        // System.out.println("Given tree is a BST");
        // else
        // System.out.println("Given tree is not a BST");

        // System.out.println("\nInorder traversal of the BST before mirroring:");
        // bst.inorder();
        // System.out.println("\nInorder traversal of the BST after mirroring:");
        // bst.mirror(bst.root);
        // bst.inorder();

        // int[] arr = {1, 2, 3, 4, 5, 6, 7};
        // Node root = bst.sortedArrayToBST(arr);
        // System.out.println("\nInorder traversal of the constructed BST:");
        // bst.inorderRec(root);

        // Node root = bst.balanceBST(bst.root);
        // System.out.println("\nInorder traversal of the Balanced BST:");
        // bst.inorderRec(root);

        /*
         * BinarySearchTreesDS bst1 = new BinarySearchTreesDS();
         * bst1.insert(55);
         * bst1.insert(35);
         * bst1.insert(25);
         * bst1.insert(45);
         * bst1.insert(75);
         * bst1.insert(65);
         * bst1.insert(85);
         * 
         * System.out.println("\nInorder traversal of the BST1:");
         * bst.inorder();
         * Node root = bst.mergeBSTs(bst.root, bst1.root);
         * System.out.println("\nInorder traversal of the merged BST:");
         * bst.inorderRec(root);
         */

        // bst.findMinMax(bst.root);

        // System.out.println("\nInorder predecessor of 50: " +
        // bst.inorderPredecessor(bst.root));
        // System.out.println("Inorder successor of 50: " +
        // bst.inorderSuccessor(bst.root));

        // bst.populateInorderSuccessor(bst.root);
        // System.out.println("\nInorder traversal of the BST after populating inorder
        // successor:");
        // bst.inorder();

        // int n1 = 20, n2 = 40;
        // Node t = bst.LCA(bst.root, n1, n2);
        // System.out.println("\nLCA of " + n1 + " and " + n2 + " is :" + t.key);

        // Node t = bst.LCAIterative(bst.root, n1, n2);
        // System.out.println("\nLCA of " + n1 + " and " + n2 + " is :" + t.key);

        // int[] preorder = {10, 5, 1, 7, 40, 50};
        // Node root = bst.constructBSTFromPreorder(preorder);
        // System.out.println("\nInorder traversal of the constructed BST:");
        // bst.inorderRec(root);

        // Node root = bst.binaryTreeToBST(bst.root);
        // System.out.println("\nInorder traversal of the BST after converting binary
        // tree to BST:");
        // bst.inorderRec(root);

        // int k = 3;
        // System.out.println("\n" + k + "th smallest element in the BST: " +
        // bst.kthSmallestNaive(bst.root, k));
        // System.out.println("\n" + k + "th smallest element in the BST: " +
        // bst.kthSmallestIterative(bst.root, k));
        // System.out.println("\n" + k + "th smallest element in the BST: " +
        // bst.kthSmallest(bst.root, k));

        // int k = 3;
        // System.out.println("\n" + k + "th largest element in the BST: " +
        // bst.kthLargest(bst.root, k));
        // System.out.println("\n" + k + "th largest element in the BST: " +
        // bst.kthLargest(bst.root, k, new int[] {0}));

        /*
         * BinarySearchTreesDS bst1 = new BinarySearchTreesDS();
         * bst1.insert(55);
         * bst1.insert(35);
         * bst1.insert(25);
         * bst1.insert(45);
         * bst1.insert(75);
         * bst1.insert(65);
         * bst1.insert(85);
         * 
         * int X = 100;
         * System.out.println("\nNumber of pairs from 2 BSTs whose sum is equal to " + X
         * + ": " + bst.countPairs(bst.root, bst1.root, X));
         */

        // int lb = 30, ub = 60;
        // System.out.println("\nNumber of nodes in the range [" + lb + ", " + ub + "]:
        // " + bst.getCount(bst.root, lb, ub));

        // System.out.println("\nMedian of the BST: " + bst.findMedian(bst.root));

        // BinarySearchTreesDS bst2 = new BinarySearchTreesDS();
        // bst2.replaceWithLeastGreater2(new int[]{8, 58, 71, 18, 31, 32, 63, 92, 43, 3,
        // 91, 93, 25, 80, 28});
        // System.out.println("\nInorder traversal of the BST after replacing with least
        // greater element:");
        // bst2.inorder();

        /*
         * BinarySearchTreesDS bst2 = new BinarySearchTreesDS();
         * bst2.insert(5);
         * bst2.insert(3);
         * bst2.insert(2);
         * bst2.insert(4);
         * bst2.insert(7);
         * bst2.insert(6);
         * bst2.insert(8);
         * 
         * Node root = bst2.flattenBST2(bst2.root);
         * System.out.println("\nFlatten BST to sorted list:");
         * while (root != null) {
         * System.out.print(root.key + " -> ");
         * root = root.right;
         * }
         */

        /*
         * BinarySearchTreesDS bst2 = new BinarySearchTreesDS();
         * bst2.insert(8);
         * bst2.insert(5);
         * bst2.insert(2);
         * bst2.insert(7);
         * bst2.insert(6);
         * bst2.insert(9);
         * bst2.insert(13);
         * bst2.insert(47);
         * bst2.insert(6);
         * 
         * if (bst2.isDeadEnd(bst2.root))
         * System.out.println("Yes");
         * else
         * System.out.println("No");
         */

        // BinarySearchTreesDS bst2 = new BinarySearchTreesDS();
        // int[] preorder = {8, 5, 1, 7, 6};
        // if (bst2.isValidPreorder(preorder))
        // System.out.println("Valid preorder");
        // else
        // System.out.println("Invalid preorder");

        // BinarySearchTreesDS bst2 = new BinarySearchTreesDS();
        // int[] preorder = {8, 5, 1, 7, 6};
        // if (bst2.isValidPreorder2(preorder))
        // System.out.println("Valid preorder");
        // else
        // System.out.println("Invalid preorder");

        // BinarySearchTreesDS bst2 = new BinarySearchTreesDS();
        // int[][] appointments = {{1, 5}, {3, 7}, {2, 6}, {10, 15}, {5, 6}};
        // System.out.println("Conflicting appointments:");
        // bst2.conflictingAppointments(appointments);

    }
}
