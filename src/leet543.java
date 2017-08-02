package algorithm;

public class leet543 {
	public int diameterOfBinaryTree(TreeNode root) {
        int [] res =  sub(root);
        return res[2];
    }
	// take the #337 as example.  did a good job.
	// my own method.
	private int[] sub(TreeNode root){
		
		if(root == null) return new int[]{0,0,0};
		
		if(root.left == null && root.right == null) return new int[]{0,0,0};
		
		int [] left = sub(root.left);
		int [] right = sub(root.right);
		
		int [] res = new int[3];
		
		// the first is not pass the root
		res[0] = Math.max(left[0],right[0])+1;
		
		res[1] = left[0] + right[0] + 2; 
		
		int max = Math.max(left[2], right[2]);
		max = Math.max(max, res[0]);
		max = Math.max(max, res[1]);
		res[2] = max;		
		
		return res;
	}
}
