import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;




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

    //       1
    //      / \
    //     2   3
    //    / \ / \
    //   4  5 6  7

    // output: 1 3 7

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

    //        1
    //       / \
    //      2   3
    //     / \ / \
    //    4  5 6  7

    // output: 4 2 1 3 7

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

    //        20
    //       /  \
    //      8    22
    //     / \   / \
    //    5  3 4   25
    //       / \
    //      10 14

    // output: 5 10 4 14 25

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
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    7   6 5   4

        // output: 1 3 2 7 6 5 4

    public void zigzagTraversal(Node root){
        if(root == null){
            return;
        }
// create a stack to store the current level nodes 
        Stack<Node> currentLevel = new Stack<>(); 
           // create a stack to store the next level nodes
        Stack<Node> nextLevel = new Stack<>(); 
        
        boolean leftToRight = true; 
        // boolean variable to check the direction of the traversal
        currentLevel.push(root);
        while(!currentLevel.isEmpty()){  
             // iterate until the current level stack is empty
            Node temp = currentLevel.pop();
             // pop the node from the current level stack and store it in temp
            System.out.print(temp.data+" ");
            if(leftToRight){ // if leftToRight is true then push the left node first and then right node    
                if(temp.left != null){
                    nextLevel.push(temp.left);
                }
                if(temp.right != null){
                    nextLevel.push(temp.right);
                }
            } else { 
                // if leftToRight is false then push the right node first and then left node   
                if(temp.right != null){
                    nextLevel.push(temp.right);
                }
                if(temp.left != null){
                    nextLevel.push(temp.left);
                }
            }
            if(currentLevel.isEmpty()){ 
                // if the current level stack is empty then swap the current level 
                // stack with next level stack and change the direction of the traversal    
                leftToRight = !leftToRight;
                Stack<Node> tempStack = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tempStack;
            }
        }
    }

    // zig-zag traversal using odd even level approach

    // Function to print the zigzag traversal
    public static Vector<Integer> zigZagTraversal(Node root) {

        Deque<Node> q = new LinkedList<Node>();
        Vector<Integer> v = new Vector<Integer>();
        q.add(root);
        v.add(root.data);
        Node temp;
        
        // set initial level as 1, because root is
        // already been taken care of.
        int l = 1;
                     
        while (q.size() > 0) {
            int n = q.size();
      
            for (int i = 0; i < n; i++) {
      
                // popping mechanism
                if (l % 2 == 0) {
                    temp = q.peekLast();
                    q.pollLast();
                }
                else {
                    temp = q.peekFirst();
                    q.pollFirst();
                }
      
                // pushing mechanism
                if (l % 2 != 0) {
      
                    if (temp.right != null) {
                        q.add(temp.right);
                        v.add(temp.right.data);
                    }
                    if (temp.left != null) {
                        q.add(temp.left);
                        v.add(temp.left.data);
                    }
                }
                else if (l % 2 == 0) {
      
                    if (temp.left != null) {
                        q.offerFirst(temp.left);
                        v.add(temp.left.data);
                    }
                    if (temp.right != null) {
                        q.offerFirst(temp.right);
                        v.add(temp.right.data);
                    }
                }
            }
            l++; // level plus one
        }
        return v;
    }
 

    // function to check height balanced tree

    public int isBalanced(Node root){
    
        if(root == null){
            return 0;
        }
        int lh = isBalanced(root.left);
        if(lh == -1){
            return -1;
        }
        int rh = isBalanced(root.right);
        if(rh == -1){
            return -1;
        }
        if(Math.abs(lh - rh) > 1){
            return -1;
        }
        return Math.max(lh, rh) + 1; // 1 is for the root node
    }


    // function to diagonal traversal of the tree
    //        8
    //       / \
    //      3   10
    //     / \    \
    //    1   6    14
    //       / \   /
    //      4   7 13

    // output: 8 10 14 3 6 7 13 1 4

    public void diagonalTraversal(Node root){
        
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp == null){
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
                System.out.println();
            } else {
                while(temp != null){
                    System.out.print(temp.data+" ");
                    if(temp.left != null){
                        q.add(temp.left);
                    }
                    temp = temp.right;
                }
            }
        }
    }



    // function to print the boundary of the tree

    //       20
    //      /  \
    //     8    22
    //    / \   / \
    //   4  12 21  25
    //     /  \
    //    10  14

    // output: 20 8 4 10 14 25 22 21

    

    // function to print the left boundary of the tree

    public void printLeftBoundary(Node root){
         
        if(root == null){
            return;
        }
        if(root.left != null){
            System.out.print(root.data+" ");
            printLeftBoundary(root.left);
        } else if(root.right != null){
            System.out.print(root.data+" ");
            printLeftBoundary(root.right);
        }

    }

    // function to print the right boundary of the tree

    public void printRightBoundary(Node root){
        
        if(root == null){
            return;
        }
        if(root.right != null){
            printRightBoundary(root.right);
            System.out.print(root.data+" ");
        } else if(root.left != null){
            printRightBoundary(root.left);
            System.out.print(root.data+" ");
        }
    }

    // function to print the leaves of the tree

    public void printLeaves(Node root){
        
        if(root == null){
            return;
        }
        printLeaves(root.left);
        if(root.left == null && root.right == null){
            System.out.print(root.data+" ");
        }
        printLeaves(root.right);
    }

    // function to print the boundary of the tree
    
    public void printBoundary(Node root){
        
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }


    // function to Construct Binary Tree from String with Bracket Representation

    public Node constructTree(String str){

        if(str.length() == 0){
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node root = null;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '('){
                stack.push(root);
            } else if(Character.isDigit(ch) || ch == '-'){
                int num = 0;
                int sign = 1;
                if(ch == '-'){
                    sign = -1;
                    i++;
                    ch = str.charAt(i);
                }
                while(i < str.length() && Character.isDigit(str.charAt(i))){
                    num = num * 10 + (str.charAt(i) - '0');
                    i++;
                }
                i--;
                num = num * sign;
                Node temp = new Node(num);
                if(root == null){
                    root = temp;
                } else {
                    if(stack.peek().left == null){
                        stack.peek().left = temp;
                    } else {
                        stack.peek().right = temp;
                    }
                }
            } else if(ch == ')'){
                stack.pop();
            }
        }
        return root;
    }


    // function to convert a binary tree to a doubly linked list

    //      10
    //     /  \
    //    12   15
    //   /  \   \
    //  25  30   36

    // output: 25 <-> 12 <-> 30 <-> 10 <-> 36 <-> 15

    public Node convertToDLL(Node root){

        if(root == null){
            return null;
        }
        Node head = convertToDLL(root.left);
        if(head == null){
            head = root;
        } else {
            Node temp = head;
            while(temp.right != null){
                temp = temp.right;
            }
            temp.right = root;
            root.left = temp;
        }
        Node right = convertToDLL(root.right);
        if(right != null){
            root.right = right;
            right.left = root;
        }
        return head;
    }

    // function to Convert Binary tree into Sum tree

    //     10
    //    /  \
    //   -2    6
    //  / \   / \
    // 8  -4  7  5

    // output: 20 
    //        /  \
    //      4    12
    //     / \   / \
    //    0  0   0  0

    public int convertToSumTree(Node node){
                // Base case
                if (node == null)
                return 0;

                // Store the old value
                int old_val = node.data;

                // Recursively call for left and right subtrees and store the sum
                // as new value of this node
                node.data = convertToSumTree(node.left) + convertToSumTree(node.right);

                // Return the sum of values of nodes in left and right subtrees
                // and old_value of this node
                return node.data + old_val;

    }


    // function to construct a binary tree from inorder and preorder traversal  of the tree

    //         1
    //       /   \
    //      2     3
    //     / \   / \
    //    4   5 6   7

    // Inorder: 4 2 5 1 6 3 7
    // Preorder: 1 2 4 5 3 6 7


    static int preIndex = 0;

    public Node buildTree(int in[], int pre[], int inStrt, int inEnd){

        if(inStrt > inEnd){
            return null;
        }
        Node tNode = new Node(pre[preIndex++]);
        if(inStrt == inEnd){
            return tNode;
        }
        int inIndex = search(in, inStrt, inEnd, tNode.data);
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
        return tNode;

    }

    public int search(int arr[], int strt, int end, int value){

        int i;
        for(i = strt; i <= end; i++){
            if(arr[i] == value){
                return i;
            }
        }
        return i;
    }

    // function to build the tree from inorder and postorder traversal of the tree

    //        1
    //       / \
    //      2   3
    //     / \ / \
    //    4  5 6  7

    // Inorder: 4 2 5 1 6 3 7
    // Postorder: 4 5 2 6 7 3 1

    public Node buildTree2(int in[], int post[], int inStrt, int inEnd){

        if(inStrt > inEnd){
            return null;
        }
        Node tNode = new Node(post[preIndex--]);
        if(inStrt == inEnd){
            return tNode;
        }
        int inIndex = search(in, inStrt, inEnd, tNode.data);
        tNode.right = buildTree2(in, post, inIndex + 1, inEnd);
        tNode.left = buildTree2(in, post, inStrt, inIndex - 1);
        return tNode;
    }


    // function to build the tree from inorder and level order traversal of the tree    

    //        1
    //       / \
    //      2   3
    //     / \ / \
    //    4  5 6  7

    // Inorder: 4 2 5 1 6 3 7
    // Level order: 1 2 3 4 5 6 7

    public Node buildTree3(int in[], int level[], int inStrt, int inEnd){

        if(inStrt > inEnd){
            return null;
        }
        Node tNode = new Node(level[0]);
        if(inStrt == inEnd){
            return tNode;
        }
        int inIndex = search(in, inStrt, inEnd, tNode.data);
        int[] lvec = extract(in, level, inStrt, inEnd, inIndex);
        int[] rvec = extract(in, level, inStrt, inEnd, inIndex);
        tNode.left = buildTree3(in, lvec, inStrt, inIndex - 1);
        tNode.right = buildTree3(in, rvec, inIndex + 1, inEnd);
        return tNode;
    }

    public int[] extract(int in[], int level[], int inStrt, int inEnd, int inIndex){
        
        Vector<Integer> vec = new Vector<>();
        for(int i = 0; i < level.length; i++){
            for(int j = inStrt; j <= inEnd; j++){
                if(level[i] == in[j]){
                    vec.add(level[i]);
                    break;
                }
            }
        }
        int[] arr = new int[vec.size()];
        for(int i = 0; i < vec.size(); i++){
            arr[i] = vec.get(i);
        }
        return arr;
    }


    // Function Check if Binary tree is Sum tree or not

    // A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its 
    // left subtree and right subtree. An empty tree is SumTree and sum of an empty tree can be considered as 0. 
    // A leaf node is also considered as SumTree.

    //       26
    //     /    \
    //    10     3
    //   /  \     \
    //  4    6     3

    // output: true

    public boolean isSumTree(Node root){

        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        int ls = sum(root.left);
        int rs = sum(root.right);
        if((root.data == ls + rs) && isSumTree(root.left) && isSumTree(root.right)){
            return true;
        }
        return false;

    }

    public int sum(Node root){

        if(root == null){
            return 0;
        }
        return sum(root.left) + root.data + sum(root.right);
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

        // System.out.println("\nTop view of the tree:");
        // tree.topView(tree.root);

        // System.out.println("\nBottom view of the tree:");
        // tree.bottomView(tree.root);

        // System.out.println("\nZigzag traversal of the tree:");
        // tree.zigzagTraversal(tree.root);

        // System.out.println("\nZigzag traversal of the tree using odd even level approach:");
        // Vector<Integer> v = zigZagTraversal(tree.root);
        // for(int i = 0; i < v.size(); i++){
        //     System.out.print(v.get(i)+" ");  
        // }


        // System.out.println("\nHeight balanced tree:");
        // int balanced = tree.isBalanced(tree.root);
        // if(balanced == -1){
        //     System.out.println("Tree is not height balanced");
        // } else {
        //     System.out.println("Tree is height balanced");
        // }


        // System.out.println("\nDiagonal traversal of the tree:"); 
        // tree.diagonalTraversal(tree.root);

        // System.out.println("\nBoundary of the tree:");
        // tree.printBoundary(tree.root);

        // System.out.println("\nConstruct Binary Tree from String with Bracket Representation:");
        // String str = "4(2(3)(1))(6(5))";

        // Node root = tree.constructTree(str);
        // levelOrder(root);

        // System.out.println("\nConvert a binary tree to a doubly linked list:");
        // Node head = tree.convertToDLL(tree.root);
        // while(head != null){
        //     System.out.print(head.data+" ");
        //     head = head.right;
        // }

        // System.out.println("\nConvert Binary tree into Sum tree:");
        // tree.convertToSumTree(tree.root);
        // levelOrder(tree.root);

        System.out.println("\nConstruct a binary tree from inorder and preorder traversal of the tree:");    
        int in[] = {4, 2, 5, 1, 6, 3, 7};
        int pre[] = {1, 2, 4, 5, 3, 6, 7};
        Node root = tree.buildTree(in, pre, 0, in.length - 1);
        levelOrder(root);





        
    }
}