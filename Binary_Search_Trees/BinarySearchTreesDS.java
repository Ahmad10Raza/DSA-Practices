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



        System.out.println("\nInorder traversal of the BST before mirroring:");
        bst.inorder();
        System.out.println("\nInorder traversal of the BST after mirroring:");
        bst.mirror(bst.root);
        bst.inorder();


        
    }
}
