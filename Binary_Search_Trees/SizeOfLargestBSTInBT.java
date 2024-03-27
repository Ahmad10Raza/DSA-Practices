// Java program to find largest BST in a Binary Tree.

/* A binary tree node has data, pointer to left child and a
* pointer to right child */
class Node {
	int data;
	Node left, right;

	public Node(final int d) { data = d; }
}

class GFG {

	public static void main(String[] args)
	{

		/* Let us construct the following Tree
		60
		/ \
	65 70
	/
	50 */

		final Node node1 = new Node(60);
		node1.left = new Node(65);
		node1.right = new Node(70);
		node1.left.left = new Node(50);

		System.out.print("Size of the largest BST is "
						+ Solution.largestBst(node1)
						+ "\n");
	}
}

class Solution {
	static int MAX = Integer.MAX_VALUE;
	static int MIN = Integer.MIN_VALUE;

	static class nodeInfo {
		int size; // Size of subtree
		int max; // Min value in subtree
		int min; // Max value in subtree
		boolean isBST; // If subtree is BST

		nodeInfo() {}

		nodeInfo(int size, int max, int min, boolean isBST)
		{
			this.size = size;
			this.max = max;
			this.min = min;
			this.isBST = isBST;
		}
	}

	static nodeInfo largestBST(Node root)
	{

		// Base case : When the current subtree is empty or
		// the node corresponds to a null.
		if (root == null) {
			return new nodeInfo(0, Integer.MIN_VALUE,
								Integer.MAX_VALUE, true);
		}
		// We will here do the postorder traversal since we
		// want our left and right subtrees to be computed
		// first.

		// Recur for left subtree and right subtrees
		nodeInfo left = largestBST(root.left);
		nodeInfo right = largestBST(root.right);

		// Create a new nodeInfo variable to store info
		// about the current node.
		nodeInfo returnInfo = new nodeInfo();

		returnInfo.min = Math.min(left.min, root.data);
		returnInfo.max = Math.max(right.max, root.data);
		returnInfo.isBST = left.isBST && right.isBST
						&& root.data > left.max
						&& root.data < right.min;

		/*
		If suppose the left and right subtrees of the
		current node are BST and the current node value is
		greater than the maximum value in the left subtree
		and also the current node value is smaller that the
		minimum value in the right subtree (Basic conditions
		for the formation of BST) then our whole subtree
		with the root as current root can be consider as a
		BST. Hence the size of the BST will become size of
		left BST subtree + size of right BST subtree +
		1(adding current node).

		Else we will consider the largest of the left BST or
		the right BST.
		*/

		/*We need to find maximum height BST subtree then
		adding the height of left an right subtree will not
		give the maximum height, we need to find max.
		*/
		if (returnInfo.isBST)

			// Calculate the size of subtree if
			// this is a BST
			returnInfo.size = left.size + right.size + 1;
		else
			returnInfo.size
				= Math.max(left.size, right.size);

		return returnInfo;
	}

	// Return the size of the largest sub-tree which is also
	// a BST
	static int largestBst(Node root)
	{
		return largestBST(root).size;
	}
}