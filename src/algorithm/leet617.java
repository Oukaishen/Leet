package algorithm;

class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	public TreeNode(int val){
		this.val = val;
	}
}


public class leet617 {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        	if(t1 == null && t2 == null) return null;
        	// if one is null, then its subtree will be the same with the non-null one;
        	if(t1 == null) return  t2;
        	if(t2 == null) return  t1;
        	
        	TreeNode root = new TreeNode(t1.val + t2.val);
        	root.left = mergeTrees(t1.left, t2.left);
        	root.right = mergeTrees(t1.right, t2.right);
        	
        	return root;
    }
}
