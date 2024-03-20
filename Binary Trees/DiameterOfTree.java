public class DiameterOfTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];        
    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        DiameterOfTree diameterOfTree = new DiameterOfTree();
        TreeNode root = diameterOfTree.new TreeNode(1);
        root.left = diameterOfTree.new TreeNode(2);
        root.right = diameterOfTree.new TreeNode(3);
        root.left.left = diameterOfTree.new TreeNode(4);
        root.left.right = diameterOfTree.new TreeNode(5);
        System.out.println(diameterOfTree.diameterOfBinaryTree(root));
    }
}