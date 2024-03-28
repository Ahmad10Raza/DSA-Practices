import java.util.*;
    
    
    
    
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

    Node deleteRec(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = inorderSuccessor(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // Find the inorder successor of the node

    // Inorder successor is the leftmost node in the right subtree


    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

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

    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

    // Input: k1 = 20, k2 = 70
    // Output: 20 30 40 50 60 70

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


    // Function to print node to root node path to leaf node

    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

    // Input: ~
    // Output: 50 30 20
    //         50 30 40
    //         50 70 60
    //         50 70 80

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

    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

    // Output: Given tree is a BST

    public boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.key < min || root.key > max)
            return false;

        return isBST(root.left, min, root.key - 1) && isBST(root.right, root.key + 1, max);
    }

    public boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
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

    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

    // Output: 50 70 80 60 30 40 20

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
    // Tree:        4
    //            /     \
    //          2         6
    //         /  \     /  \
    //       1   3     5    7


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

    // Tree1:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

    // Tree2:        55
    //            /     \
    //          35       75
    //         /  \     /  \
    //       25   45   65   85

    // Output: 20 25 30 35 40 45 50 55 60 65 70 75 80 85

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

    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

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

    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

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

   // Given a Binary Tree, write a function to populate next pointer for all nodes. The next pointer for every node should be set
   //  to point to inorder successor.


    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

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


    // Function to  Find LCA  of 2 nodes in a BST

    // LCA means Lowest Common Ancestor 


    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

    // Input: 20, 40
    // Output: 30

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
    //         /  \
    //        5    40
    //       / \     \
    //      1   7     50


    /* Approach

    Follow the below steps to solve the problem:

Initialize the range as {INT_MIN .. INT_MAX}
The first node will definitely be in range, so create a root node. 
To construct the left subtree, set the range as {INT_MIN …root->data}. 
If a value is in the range {INT_MIN .. root->data}, the values are part of the left subtree. 
To construct the right subtree, set the range as {root->data..max .. INT_MAX}. 
If a value is in the range {root->data..max .. INT_MAX}, the values are part of the right subtree.
    
        */


    public Node constructBSTFromPreorder(int[] preorder) {
        return constructBSTFromPreorder(preorder, new int[] {0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
    Example 1
Input:
          10
         /  \
        2    7
       / \
      8   4
Output:
          8
         /  \
        4    10
       / \
      2   7

Solution:

Following is a 3 step solution for converting Binary tree to Binary Search Tree.

1. Create a temp array arr[] that stores inorder traversal of the tree. This step takes O(n) time.
2. Sort the temp array arr[]. Time complexity of this step depends upon the sorting algorithm. 
In the following implementation, Quick Sort is used which takes (n^2) time. This can be done in O(nLogn) time using Heap Sort or Merge Sort.
3. Again do inorder traversal of tree and copy array elements to tree nodes one by one. This step takes O(n) time. */

    public Node binaryTreeToBST(Node root) {
        List<Integer> nodes = new ArrayList<>();
        inorder2(root, nodes);
        Collections.sort(nodes);
        return binaryTreeToBST(root, nodes, new int[] {0});
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

    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

    // Input: 3
    // Output: 40



    public int kthSmallestNaive(Node root, int k) {
        List<Integer> nodes = new ArrayList<>();
        inorder2(root, nodes);
        return nodes.get(k - 1);
    }


    //Approach: The idea is to do an inorder traversal of the BST and keep a count of the number of nodes visited.
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
        return kthSmallest(root, k, new int[] {0});
    }

    // Function to find kth largest element in the BST

    // Tree:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

    // Input: 3
    // Output: 60

    // Approach: The idea is to do a reverse inorder traversal of the BST and keep a count of the number of nodes visited.
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


    // Function to Count pairs from 2 BST whose sum is equal to given value "X"

    // Tree1:        50
    //            /     \
    //          30       70
    //         /  \     /  \
    //       20   40   60   80

    // Tree2:        55
    //            /     \
    //          35       75
    //         /  \     /  \
    //       25   45   65   85

    // Input: X = 100
    // Output: 3

    // Approach: Method 1: For each node value a in BST 1, search the value (x – a) in BST 2. 
    // If value found then increment the count. For searching a value in BST.
    public static int countPairs(Node root1, Node root2, int x)
    {
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
        //     System.out.println("\nKey " + key + " found in the BST");
        // else
        //     System.out.println("\nKey " + key + " not found in the BST");

        // bst.delete(20);
        // System.out.println("\nInorder traversal after deleting 20:");
        // bst.inorder();

        // System.out.println("\nFollowing Ouput is the nodes in the range K1 and K2:");
        // bst.printInRange(bst.root, 20, 70);


        // System.out.println("\nFollowing Ouput is the nodes from root to leaf:");
        // bst.printRootToLeaf(bst.root, new ArrayList<>());

        // if (bst.isBST(bst.root))
        //     System.out.println("Given tree is a BST");
        // else
        //     System.out.println("Given tree is not a BST");


        // if (bst.isBSTUsingPrev(bst.root))
        //     System.out.println("Given tree is a BST");
        // else
        //     System.out.println("Given tree is not a BST");



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
        BinarySearchTreesDS bst1 = new BinarySearchTreesDS();
        bst1.insert(55);
        bst1.insert(35);
        bst1.insert(25);
        bst1.insert(45);
        bst1.insert(75);
        bst1.insert(65);
        bst1.insert(85);

        System.out.println("\nInorder traversal of the BST1:");
        bst.inorder();
        Node root = bst.mergeBSTs(bst.root, bst1.root);
        System.out.println("\nInorder traversal of the merged BST:");
        bst.inorderRec(root);
        */


        // bst.findMinMax(bst.root);    

        // System.out.println("\nInorder predecessor of 50: " + bst.inorderPredecessor(bst.root));
        // System.out.println("Inorder successor of 50: " + bst.inorderSuccessor(bst.root));


        // bst.populateInorderSuccessor(bst.root);
        // System.out.println("\nInorder traversal of the BST after populating inorder successor:");
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
        // System.out.println("\nInorder traversal of the BST after converting binary tree to BST:");
        // bst.inorderRec(root);


        // int k = 3;
        // System.out.println("\n" + k + "th smallest element in the BST: " + bst.kthSmallestNaive(bst.root, k));
        // System.out.println("\n" + k + "th smallest element in the BST: " + bst.kthSmallestIterative(bst.root, k));
        // System.out.println("\n" + k + "th smallest element in the BST: " + bst.kthSmallest(bst.root, k));

        // int k = 3;
        // System.out.println("\n" + k + "th largest element in the BST: " + bst.kthLargest(bst.root, k));
        // System.out.println("\n" + k + "th largest element in the BST: " + bst.kthLargest(bst.root, k, new int[] {0}));


        BinarySearchTreesDS bst1 = new BinarySearchTreesDS();
        bst1.insert(55);
        bst1.insert(35);
        bst1.insert(25);
        bst1.insert(45);
        bst1.insert(75);
        bst1.insert(65);
        bst1.insert(85);

        int X = 100;
        System.out.println("\nNumber of pairs from 2 BSTs whose sum is equal to " + X + ": " + bst.countPairs(bst.root, bst1.root, X));





    }
}
