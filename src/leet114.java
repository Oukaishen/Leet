package algorithm;

public class leet114 {
	TreeNode prev = null;
	// cannot figure it out myself, very concise solution
public void flatten(TreeNode root) {
        if (root == null ) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
