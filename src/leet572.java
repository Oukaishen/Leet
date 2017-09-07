package algorithm;

public class leet572 {
	// this question is so fucked. redo
public boolean isSubtree(TreeNode s, TreeNode t) {
		return traverse(s,t);
    }

private boolean traverse(TreeNode s, TreeNode t){
	return s != null && ( match(s,t) || traverse(s.left, t) || traverse(s.right, t));
}

private boolean match(TreeNode x, TreeNode y){
	if(x == null && y == null)
		return true;
	else if( x == null || y == null)
		return false;
	return x.val == y.val && match(x.left, y.left) && match(x.right, y.right);
}

}
