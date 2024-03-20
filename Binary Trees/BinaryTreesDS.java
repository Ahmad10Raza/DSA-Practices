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

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal:");
        tree.inorder();

        System.out.println("\nPreorder traversal:");
        tree.preorder();

        System.out.println("\nPostorder traversal:");
        tree.postorder();

        System.out.println("\nLevel order traversal:");
        levelOrder(tree.root);
    }
}