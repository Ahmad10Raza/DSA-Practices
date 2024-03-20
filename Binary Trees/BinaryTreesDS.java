import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
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

    // funtion to inorder traversal of the tree using iterative approach
    public void inorderIterative(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data+" ");
            curr = curr.right;
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

    // funtion to preorder traversal of the tree using iterative approach
    public void preorderIterative(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.print(curr.data+" ");
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }
    }


    void postorder() {
        postorderRec(root);
    }

    // function to postorder traversal of the tree using iterative approach
    public void postorderIterative(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            Node curr = stack1.pop();
            stack2.push(curr);
            if(curr.left != null){
                stack1.push(curr.left);
            }
            if(curr.right != null){
                stack1.push(curr.right);
            }
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().data+" ");
        }
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
        Queue<Node> q = new LinkedList<>(); // create a queue to store the nodes
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


    // function to mirror the tree
     
    /* Change a tree so that the roles of the left and
    right pointers are swapped at every node.
 
So the tree...
     4
    / \
   2   5
  / \
 3   1
 
is changed to...
     4
    / \
   5   2
      / \
     1   3
*/

     
    public Node mirror(Node root){
        if(root == null){
            return null;
        }
        Node left = mirror(root.left);
        Node right = mirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // function to check if the tree is mirror of itself

    public boolean isMirror(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return (root1.data == root2.data) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    // function to print left view of the tree
 
  /*  Input: 
                   4
                /   \
              5     2
                   /   \
                3     1
              /  \
           6    7

Output: 4 5 3 6 */ 
    static int max_level = 0;

    public void leftViewRec(Node root,int level){
        

        // base case
        if(root == null){
            return;
        }

        if (max_level < level) {
            System.out.print(root.data + " ");
            max_level = level;
        }

        leftViewRec(root.left, level + 1);
        leftViewRec(root.right, level + 1);

    }

    // function to print left view iteratively

    public void leftViewIterative(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 1; i <= n; i++){
                Node temp = q.poll();
                if(i == 1){
                    System.out.print(temp.data+" ");
                }
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
    }

    // function to print right view of the tree using recursive approach

    public void rightViewRec(Node root,int level){
        if(root == null){
            return;
        }
        if(max_level < level){
            System.out.print(root.data+" ");
            max_level = level;
        }
        rightViewRec(root.right, level + 1);
        rightViewRec(root.left, level + 1);
    }

    // function to print right view of the tree using iterative approach

    public void rightViewIterative(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 1; i <= n; i++){
                Node temp = q.poll();
                if(i == n){
                    System.out.print(temp.data+" ");
                }
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
    }


    // function to print the top view of the tree

    public void topView(Node root){
        if(root == null){
            return;
        }
        class QueueObj{ // class to store the node and its horizontal distance
            Node node;
            int hd;
            QueueObj(Node node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<>(); // create a queue to store the nodes and its horizontal distance
        Map<Integer, Node> topViewMap = new TreeMap<>(); // create a map to store the top view of the tree
        q.add(new QueueObj(root, 0));
        while(!q.isEmpty()){
            QueueObj tempNode = q.poll();
            if(!topViewMap.containsKey(tempNode.hd)){
                topViewMap.put(tempNode.hd, tempNode.node);
            }
            if(tempNode.node.left != null){
                q.add(new QueueObj(tempNode.node.left, tempNode.hd - 1));
            }
            if(tempNode.node.right != null){
                q.add(new QueueObj(tempNode.node.right, tempNode.hd + 1));
            }
        }
        for(Map.Entry<Integer, Node> entry : topViewMap.entrySet()){
            System.out.print(entry.getValue().data+" ");
        }
    }

    // function to print the bottom view of the tree

    public void bottomView(Node root){
        if(root == null){
            return;
        }
        class QueueObj{ // class to store the node and its horizontal distance
            Node node;
            int hd;
            QueueObj(Node node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<>(); // create a queue to store the nodes and its horizontal distance
        Map<Integer, Node> bottomViewMap = new TreeMap<>(); // create a map to store the bottom view of the tree
        q.add(new QueueObj(root, 0));
        while(!q.isEmpty()){
            QueueObj tempNode = q.poll();
            bottomViewMap.put(tempNode.hd, tempNode.node);
            if(tempNode.node.left != null){
                q.add(new QueueObj(tempNode.node.left, tempNode.hd - 1));
            }
            if(tempNode.node.right != null){
                q.add(new QueueObj(tempNode.node.right, tempNode.hd + 1));
            }
        }
        for(Map.Entry<Integer, Node> entry : bottomViewMap.entrySet()){
            System.out.print(entry.getValue().data+" ");
        }
    }



    // functiona to print the zigzag traversal of the tree

    public void zigzagTraversal(Node root){
        if(root == null){
            return;
        }
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        boolean leftToRight = true;
        currentLevel.push(root);
        while(!currentLevel.isEmpty()){
            Node temp = currentLevel.pop();
            System.out.print(temp.data+" ");
            if(leftToRight){
                if(temp.left != null){
                    nextLevel.push(temp.left);
                }
                if(temp.right != null){
                    nextLevel.push(temp.right);
                }
            } else {
                if(temp.right != null){
                    nextLevel.push(temp.right);
                }
                if(temp.left != null){
                    nextLevel.push(temp.left);
                }
            }
            if(currentLevel.isEmpty()){
                leftToRight = !leftToRight;
                Stack<Node> tempStack = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tempStack;
            }
        }
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

        // System.out.println("\nInorder traversal using iterative approach:");
        // tree.inorderIterative(tree.root);

        // System.out.println("\nPreorder traversal:");
        // tree.preorder();

        // System.out.println("\nPreorder traversal using iterative approach:");
        // tree.preorderIterative(tree.root);


        // System.out.println("\nPostorder traversal:");
        // tree.postorder();

        // System.out.println("\nPostorder traversal using iterative approach:");
        // tree.postorderIterative(tree.root);

        System.out.println("\nLevel order traversal:");
        levelOrder(tree.root);

        // System.out.println("\nHeight of the tree:");
        // System.out.println(tree.height(tree.root));

        // System.out.println("\nCount of the nodes of the tree:");
        // System.out.println(tree.countNodes(tree.root));

        // System.out.println("\nSum of the nodes of the tree:");
        // System.out.println(tree.sumOfNodes(tree.root));

        // System.out.println("\nDiameter of the tree:");
        // System.out.println(tree.diameter(tree.root));

        // System.out.println("\nDiameter of the tree using O(n) approach:");
        // int height = 0;
        // System.out.println(tree.diameterOptimized(tree.root, height));

        // System.out.println("\nMirror of the tree:");
        // Node mirror = tree.mirror(tree.root);
        // levelOrder(mirror);

        // System.out.println("\nIs tree mirror of itself:");
        // System.out.println(tree.isMirror(tree.root, tree.root));

        // System.out.println("\nLeft view of the tree:");
        // int level = 1;
        // tree.leftViewRec(tree.root, level);

        // System.out.println("\nLeft view of the tree using iterative approach:");
        // tree.leftViewIterative(tree.root);

        // System.out.println("\nRight view of the tree:");
        // tree.rightViewRec(tree.root, level);

        // System.out.println("\nRight view of the tree using iterative approach:");
        // tree.rightViewIterative(tree.root);

        System.out.println("\nTop view of the tree:");
        tree.topView(tree.root);

        System.out.println("\nBottom view of the tree:");
        tree.bottomView(tree.root);


        
    }
}