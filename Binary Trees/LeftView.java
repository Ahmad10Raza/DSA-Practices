// Java program to print left view of binary tree

/* Class containing left and right child of current
node and key value*/


/* Class to print the left view */
class LeftView {

    class  Node {
        int data;
        Node left, right;
    
        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
	Node root;
	static int max_level = 0;

	// recursive function to print left view
	void leftViewUtil(Node node, int level)
	{
		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(node.data + " ");
			max_level = level;
		}

		// Recur for left and right subtrees
		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);
	}

	// A wrapper over leftViewUtil()
	void leftView()
	{
		max_level = 0;
		leftViewUtil(root, 1);
	}

    public void leftViewRec(Node root,int level){
        //int max_level = 0;

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


	/* testing for example nodes */
public static void main(String args[])
{
    /* creating a binary tree and entering the nodes */
    LeftView tree = new LeftView();
    tree.root = tree.new Node(10);
    tree.root.left = tree.new Node(2);

    tree.root.right = tree.new Node(3);
    tree.root.left.left = tree.new Node(7);
    tree.root.left.right = tree.new Node(8);
    tree.root.right.right = tree.new Node(15);
    tree.root.right.left = tree.new Node(12);
    tree.root.right.right.left = tree.new Node(14);

    tree.leftViewRec(tree.root, 1);
}
}
