// Method 2: Using Recursion 
    // Recursive approach to solving this question.
    // Traverse the BST1 and for each node find the diff i.e. (x – root1.data) in BST2 and increment the count.
    

// Java implementation to count pairs from two
// BSTs whose sum is equal to a given value x
public class CountsPairSumInTwoBST {

	// structure of a node of BST
	static class Node {
		int data;
		Node left, right;

		// constructor
		public Node(int data)
		{
			this.data = data;
			left = null;
			right = null;
		}
	}

	static Node root1;
	static Node root2;

	// function to count pairs from two BSTs
	// whose sum is equal to a given value x
	public static int pairCount = 0;
	public static void traverseTree(Node root1, Node root2,
									int sum)
	{
		if (root1 == null || root2 == null) {
			return;
		}
		traverseTree(root1.left, root2, sum);
		traverseTree(root1.right, root2, sum);
		int diff = sum - root1.data;
		findPairs(root2, diff);
	}

	private static void findPairs(Node root2, int diff)
	{
		if (root2 == null) {
			return;
		}
		if (diff > root2.data) {
			findPairs(root2.right, diff);
		}
		else {
			findPairs(root2.left, diff);
		}
		if (root2.data == diff) {
			pairCount++;
		}
	}

	public static int countPairs(Node root1, Node root2,
								int sum)
	{
		traverseTree(root1, root2, sum);
		return pairCount;
	}

	// Driver program to test above
	public static void main(String args[])
	{
		// formation of BST 1
		root1 = new Node(5); /*			 5	 */
		root1.left = new Node(3); /*		 / \	 */
		root1.right = new Node(7); /*		 3	 7	 */
		root1.left.left = new Node(2); /* / \ / \ */
		root1.left.right = new Node(4); /* 2 4 6 8 */
		root1.right.left = new Node(6);
		root1.right.right = new Node(8);

		// formation of BST 2
		root2 = new Node(10); /*		 10		 */
		root2.left = new Node(6); /*		 / \ */
		root2.right = new Node(15); /*	 6	 15 */
		root2.left.left = new Node(3); /* / \ / \ */
		root2.left.right
			= new Node(8); /* 3 8 11 18 */
		root2.right.left = new Node(11);
		root2.right.right = new Node(18);

		int x = 16;
		System.out.println("Pairs = "
						+ countPairs(root1, root2, x));
	}
}

