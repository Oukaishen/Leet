package algorithm;

public class leet538 {
	
	int sum = 0;
public TreeNode convertBST(TreeNode root) {
       sub(root);
       return root;
    }

public void sub(TreeNode root){
	if(root == null ) return;
	sub(root.right);
	int tmp = root.val;
	root.val += sum;
	sum += tmp;
	sub(root.left);
}
}
