import java.util.LinkedList;
import java.util.Queue;
class BinaryTree {
    class Node {
        int data;
        Node left, right;

        public Node(int data ) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    Node root;

    BinaryTree() {
        root = null;
    }

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    // function to build the tree 

    public Node buildTree(int nodes[]){
        for(int i = 0; i < nodes.length; i++){
            insert(nodes[i]);
        }
        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // function to level order traversal of the tree

    public static void levelOrder(Node root) {

        if(root == null) {
 
            return;
 
        }
 
        Queue<Node> q = new LinkedList<>();
 
        q.add(root);
 
        q.add(null);
 
        while(!q.isEmpty()) {
 
            Node curr = q.remove();
 
            if(curr == null) {
 
                System.out.println();
 
                //queue empty
 
                if(q.isEmpty()) {
 
                    break;
 
                } else {
 
                    q.add(null);
 
                }
 
            } else {
 
                System.out.print(curr.data+" ");
 
                if(curr.left != null) {
 
                    q.add(curr.left);
 
                }
 
                if(curr.right != null) {
 
                    q.add(curr.right);
 
                }
 
            }
 
        }
 
    }


    // function to calculate the height of the tree

    public int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }



    // funtion to count the node of the tree

    public int countNodes(Node root){
        if(root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }




    // function to calculate sum of all the nodes of the tree

    public int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
    }


    // function to calculate the diameter of the tree using O(n^2) approach
    // diameter means   eg:  1
    //                      5 6
    //                    7 8 9 10
    // diameter = 5

    public int diameter(Node root){  // O(n^2) approach
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }


    // function to calculate the diameter of the tree using O(n) approach

    public int diameterOptimized(Node root, int height){
        if(root == null){
            height = 0;
            return 0;
        }
        int lh = 0, rh = 0;
        int leftDiameter = diameterOptimized(root.left, lh);
        int rightDiameter = diameterOptimized(root.right, rh);
        height = Math.max(lh, rh) + 1;
        return Math.max(lh + rh + 1, Math.max(leftDiameter, rightDiameter));
    }
    
    public int diameterOfBinaryTree(Node root) {
        int[] diameter = new int[1];
        height2(root, diameter);
        return diameter[0];        
    }

    private int height2(Node node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height2(node.left, diameter);
        int rh = height2(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // System.out.println("Inorder traversal:");
        // tree.inorder();

        // System.out.println("\nPreorder traversal:");
        // tree.preorder();

        // System.out.println("\nPostorder traversal:");
        // tree.postorder();

        System.out.println("\nLevel order traversal:");
        levelOrder(tree.root);

        System.out.println("\nHeight of the tree:");
        System.out.println(tree.height(tree.root));

        System.out.println("\nCount of the nodes of the tree:");
        System.out.println(tree.countNodes(tree.root));

        System.out.println("\nSum of the nodes of the tree:");
        System.out.println(tree.sumOfNodes(tree.root));

        System.out.println("\nDiameter of the tree:");
        System.out.println(tree.diameter(tree.root));

        System.out.println("\nDiameter of the tree using O(n) approach:");
        int height = 0;
        System.out.println(tree.diameterOptimized(tree.root, height));
    }
}