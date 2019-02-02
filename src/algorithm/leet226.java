package algorithm;

public class leet226 {
	public TreeNode invertTree(TreeNode root) {
        if(root == null ) return root;
        if(root.left == null && root.right == null) return root;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
