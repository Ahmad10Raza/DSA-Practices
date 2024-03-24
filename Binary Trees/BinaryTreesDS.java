import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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



    // Function to check given  Tree Isomorphism Problem

    // Two trees are called isomorphic if one of them can be obtained from other by a series of flips,
    // i.e. by swapping left and right children of a number of nodes. Any number of nodes at any level can have their children swapped.
    // Two empty trees are isomorphic.

    //       1              T1: 
    //     /   \
    //    2     3
    //   / \   / \
    //  4   5 6   7

    //       1          T2: 
    //     /   \
    //    3     2
    //   / \   / \
    //  7   6 5   4

    // output: true


    public boolean isIsomorphic(Node root1, Node root2){

        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.data != root2.data){
            return false;
        }
        return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)) ||
               (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));
    }



    // Function to find all duplicate subtrees in a binary tree

    // Given a binary tree, find all duplicate subtrees. For each duplicate subtrees, we only need to return the root node of any one of them.
    // Two trees are duplicate if they have the same structure with same node values.

    //       1
    //     /   \
    //    2     3
    //   /     / \
    //  4     2   4
    //       /
    //      4

    // output: 2 4
    //         4

    public List<Node> findDuplicateSubtrees(Node root) {

        List<Node> res = new ArrayList<>(); // create a list to store the duplicate subtrees

        Map<String, Integer> map = new HashMap<>(); // create a map to store the serial of the subtrees
        postorder(root, map, res);
        return res;
    }

    public String postorder(Node cur, Map<String, Integer> map, List<Node> res) {

        if (cur == null) return "#";
        // serialize the tree to a string. 
        String serial = cur.data + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
        map.put(serial, map.getOrDefault(serial, 0) + 1); // store the serial of the subtree in the map
        if (map.get(serial) == 2) res.add(cur); // if the serial is already present in the map then add the node to the list
        return serial;
    }


    // Function to find LCA(Lowest Common Ancestor) in a Binary Tree

    // Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    //       3
    //     /   \
    //    5     1
    //   / \   / \
    //  6   2 0   8
    //     / \
    //    7   4

    // input: 6,4
    // output: 5


    public Node lowestCommonAncestor(Node root, Node p, Node q) {

        if(root == null || root == p || root == q){
            return root;
        }
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }


    // Function to Print all "K" Sum paths in a Binary tree

    // Given a binary tree and an integer k, print all paths that sum to k. The paths can only go down from the root to a leaf node.

    //       1
    //     /   \
    //    3     -1
    //   / \   / \
    //  2   1 4   5

    // input: 5
    // output: 1 3 1
    //         3 2
    //         1 -1 4

    public void printKPath(Node root, int k) {

        int path[] = new int[1000];
        printKPathUtil(root, path, 0, k);

    }

    public void printKPathUtil(Node root, int path[], int pathLen, int k) {

        if(root == null){
            return;
        }
        path[pathLen] = root.data;
        int sum = 0;
        for(int i = pathLen; i >= 0; i--){
            sum += path[i];
            if(sum == k){
                for(int j = i; j <= pathLen; j++){
                    System.out.print(path[j]+" ");
                }
                System.out.println();
            }
        }
        printKPathUtil(root.left, path, pathLen + 1, k);
        printKPathUtil(root.right, path, pathLen + 1, k);
    }



    // Function to find Kth Ancestor of node in a Binary tree

    // Given a binary tree in which nodes are numbered from 1 to n. Given a node and a positive integer K,
    // we have to print the K-th ancestor of the given node in the binary tree. If there does not exist any such ancestor then print -1.

    //       1
    //     /   \
    //    2     3
    //   / \   / \
    //  4   5 6   7

    // input: N = 5,K = 2
    // output: 1

    public int kthAncestor(Node root, int node, int k) {

        if(root == null){
            return -1;
        }
        // if the root is the node then return 0 as the kth ancestor of the node is the node itself 
        if(root.data == node || kthAncestor(root.left, node, k) == 1 || kthAncestor(root.right, node, k) == 1){ // if the node is found then return 1   
            if(k > 0){
                k--;
            } else if(k == 0){
                System.out.println(root.data);
                return -1;
            }
            return root.data;
        }
        return -1;
    }


    private int[][] p;

    public void TreeAncestor(int n, int[] parent) {
        p = new int[n][18];
        for (var e : p) {
            Arrays.fill(e, -1);
        }
        for (int i = 0; i < n; ++i) {
            p[i][0] = parent[i];
        }
        for (int j = 1; j < 18; ++j) {
            for (int i = 0; i < n; ++i) {
                if (p[i][j - 1] == -1) {
                    continue;
                }
                p[i][j] = p[p[i][j - 1]][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 17; i >= 0; --i) {
            if (((k >> i) & 1) == 1) {
                node = p[node][i];
                if (node == -1) {
                    break;
                }
            }
        }
        return node;
    }



    // Function to Find distance between 2 nodes in a Binary tree

    // Given a binary tree and two node values your task is to find the minimum distance between them.

    //       1
    //     /   \
    //    2     3
    //   / \   / \
    //  4   5 6   7

    // input: 4,5
    // output: 2
    // input: 2,6
    // output: 3

/*
    public int lca2(Node root, int val) {
        if(root == null){
            return 0;
        }

        if(root.data == val){
            return 1;
        }

        int left = lca2(root.left, val);
        int right = lca2(root.right, val);

        if(left == 0 && right == 0){
            return 0;
        }

        else{
            return left + right +1 ;
        }
    }

    public int findDistance(Node root, int a, int b) {

        Node lca = lowestCommonAncestor(root, a, b);
        int d1 = lca2(lca, a);
        int d2 = lca2(lca, b);
       
        return d1 + d2 - 2 ;
    }

    */


    // Function to Find distance between 2 nodes in a Binary tree

    public int findDistance(Node root, int p, int q) {
        if (p == q)
            return 0;
        Node ancestor = lowestCommonAncestor2(root, p, q);
        return getDistance(ancestor, p) + getDistance(ancestor, q);
    }

    public Node lowestCommonAncestor2(Node root, int p, int q) {
        if (root == null)
            return null;
        if (root.data == p || root.data == q)
            return root;
        Node left = lowestCommonAncestor2(root.left, p, q);
        Node right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }

    public int getDistance(Node node, int data) {
        if (node == null)
            return -1;
        if (node.data == data)
            return 0;
        int leftDistance = getDistance(node.left, data);
        int rightDistance = getDistance(node.right, data);
        int subDistance = Math.max(leftDistance, rightDistance);
        return subDistance >= 0 ? subDistance + 1 : -1;
    }



    // Function to find Maximum Sum of nodes in Binary tree such that no two are adjacent to each other

    // Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that the sum of chosen nodes is maximum under a constraint that no two chosen node in the subset should be directly connected that is, if we have taken a node in our sum then we can’t take its any children in consideration and vice versa.

    //       10
    //     /    \
    //    1      2
    //     \    / \
    //      3  4   5

    // output: 19

    public int maxSum(Node root) {

        int[] res = maxSumUtil(root);
        return Math.max(res[0], res[1]);

    }


    public int[] maxSumUtil(Node root) {
            
            if(root == null){
                return new int[]{0, 0};
            }
            int[] left = maxSumUtil(root.left);
            int[] right = maxSumUtil(root.right);
            int[] res = new int[2];
            res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            res[1] = root.data + left[0] + right[0];
            return res;
    }

    // Maximum sum of nodes in Binary tree such that no two are adjacent to each other using DP

    // declare map /dp array as global
    static HashMap<Node, Integer> umap = new HashMap<>();
    static int maxSumDP(Node root)
    {
        // base case
        if (root == null)
            return 0;
 
        // if the max sum from the node is already in
        // map,return the value
        if (umap.containsKey(root))
            return umap.get(root);
 
        // if the current node(root) is included in result
        // then find maximum sum
        int inc = root.data;
 
        // if left of node exists, add their grandchildren
        if (root.left != null) {
            inc += maxSumDP(root.left.left) + maxSumDP(root.left.right);
        }
        // if right of node exist,add their grandchildren
        if (root.right != null) {
            inc += maxSumDP(root.right.left) + maxSumDP(root.right.right);
        }
 
        // if the current node(root) is excluded, find the
        // maximum sum
        int ex = maxSumDP(root.left) + maxSumDP(root.right);
 
        // store the maximum of including & excluding the
        // node in map
        umap.put(root, Math.max(inc, ex));
        return Math.max(inc, ex);
    }



    // Function to  Find Largest subtree sum in a tree

    // Given a binary tree, task is to find subtree with maximum sum in tree.

    // T1:   1
    //     /   \
    //    2     3
    //   / \   / \
    //  4   5 6   7

    // output: 28

    // T2:   1
    //     /   \
    //   -2     3
    //   / \   / \
    //  4   5 -6   2

    // output: 7
        static int ma = 0;
    public int maxSumSubtree(Node root) {

        if(root == null){
            return 0;
        }

        int left = maxSumSubtree(root.left);
        int right = maxSumSubtree(root.right);

        ma = Math.max(ma, left + right + root.data);

        return left + right + root.data;
        
    }
 
   

    // Function to get Check if all leaf nodes are at same level or not

    // Given a Binary Tree, check if all leaves are at same level or not.

    //       12
    //     /    \
    //    5      7

    // output: true

    //       12
    //     /    \
    //    5      7
    //   /
    //  3

    // output: false

    public boolean checkLevelLeafNode(Node root) {
            
            int level = 0;
            return checkLevelLeafNodeUtil(root, 0, level);
    }

    public boolean checkLevelLeafNodeUtil(Node root, int level, int leafLevel) {
            
            if(root == null){
                return true;
            }
            if(root.left == null && root.right == null){
                if(leafLevel == 0){
                    leafLevel = level;
                    return true;
                }
                return level == leafLevel;
            }
            return checkLevelLeafNodeUtil(root.left, level + 1, leafLevel) && 
                   checkLevelLeafNodeUtil(root.right, level + 1, leafLevel); 

        }


        // Function to find Check if a Binary Tree contains duplicate subtrees of size 2 or more [ IMP ]

        // Given a binary tree, find out whether it contains a duplicate sub-tree of size two or more, or not.

        //       1
        //     /   \
        //    2     3
        //   /     / \
        //  4     2   4

        // output: true

        //       1
        //     /   \
        //    2     3
        //         / \
        //        2   4

        // output: false

        public boolean dupSubUtil(Node root, HashMap<String, Integer> m) {
            if (root == null)
                return false;
            String s = "";
            if (root.left != null)
                s += root.left.data;
            s += " ";
            s += root.data;
            s += " ";
            if (root.right != null)
                s += root.right.data;
            if (m.get(s) != null && m.get(s) == 1)
                return true;
            else
                m.put(s, 1);
            return dupSubUtil(root.left, m) || dupSubUtil(root.right, m);
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

        // System.out.println("\nConstruct a binary tree from inorder and preorder traversal of the tree:");    
        // int in[] = {4, 2, 5, 1, 6, 3, 7};
        // int pre[] = {1, 2, 4, 5, 3, 6, 7};
        // Node root = tree.buildTree(in, pre, 0, in.length - 1);
        // levelOrder(root);
        

        // System.out.println("\nConstruct a binary tree from inorder and postorder traversal of the tree:");
        // int in[] = {4, 2, 5, 1, 6, 3, 7};
        // int post[] = {4, 5, 2, 6, 7, 3, 1};
        // preIndex = post.length - 1;
        // Node root = tree.buildTree2(in, post, 0, in.length - 1);
        // levelOrder(root);

        // System.out.println("\nConstruct a binary tree from inorder and level order traversal of the tree:");
        // int in[] = {4, 8, 10, 12, 14, 20, 22};
        // int level[] = {20, 8, 22, 4, 12, 14, 10};
        // Node root = tree.buildTree3(in, level, 0, in.length - 1);
        // levelOrder(root);

        // System.out.println("\nCheck if Binary tree is Sum tree or not:");
        // System.out.println(tree.isSumTree(tree.root));

        // System.out.println("\nCheck given  Tree Isomorphism Problem:");
        // Node root1 = new Node(1);
        // root1.left = new Node(2);
        // root1.right = new Node(3);
        // root1.left.left = new Node(4);
        // root1.left.right = new Node(5);
        // root1.right.left = new Node(6);
        // root1.left.right = new Node(7);

        // Node root2 = new Node(1);
        // root2.left = new Node(3);
        // root2.right = new Node(2);
        // root2.left.left = new Node(7);
        // root2.left.right = new Node(6);
        // root2.right.left = new Node(5);
        // root2.left.right = new Node(4);

        // System.out.println(tree.isIsomorphic(root1, root2));


        // System.out.println("\nFind all duplicate subtrees in a binary tree:");
        // List<Node> res = tree.findDuplicateSubtrees(tree.root);
        // for(Node node : res){
        //     levelOrder(node);
        //     System.out.println();
        // }


        // System.out.println("\nFind LCA(Lowest Common Ancestor) in a Binary Tree:");
        // Node p = new Node(6);
        // Node q = new Node(4);
        // Node lca = tree.lowestCommonAncestor(tree.root, p, q);
        // System.out.println(lca.data);


        // System.out.println("\nPrint all K Sum paths in a Binary tree:");
        // tree.printKPath(tree.root, 5);


        // System.out.println("\nFind Kth Ancestor of node in a Binary tree:");
        // int k = 2;
        // int node = 5;
        // System.out.println(tree.kthAncestor(tree.root, node, k));


        // System.out.println("\nFind distance between 2 nodes in a Binary tree:");
        // int p = 6;
        // int q = 4;
        // System.out.println(tree.findDistance(tree.root, p, q));


        // System.out.println("\nFind Maximum Sum of nodes in Binary tree such that no two are adjacent to each other:");
        // System.out.println(tree.maxSum(tree.root));

        // System.out.println("\nMaximum sum of nodes in Binary tree such that no two are adjacent to each other using DP:");
        // System.out.println(maxSumDP(tree.root));


        // System.out.println("\nFind Largest subtree sum in a tree:");
        // tree.maxSumSubtree(tree.root);
        // System.out.println(ma);

        
        System.out.println("\nCheck if all leaf nodes are at same level or not:");
        System.out.println(tree.checkLevelLeafNode(tree.root));


        
    }
}