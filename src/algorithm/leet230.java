package algorithm;

/*
 * This is quite strange method.
 * I use the in-order thought.
 * But also I need the post-order to get the total number as return.
 * But it pass all the algorithm.test case.
 * I should avoid the usage of such ambiguous method.
 * 
 * */

public class leet230 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(4);
		System.out.println(new leet230().kthSmallest(root, 1));
	}
	
	private int res = -1;
	
	public int kthSmallest(TreeNode root, int k) {
       helper(root,0,k);
       return res;
    }
	
	private int helper(TreeNode root, int current, int k){
		if(root == null) 
			return 0;
		// calculate how many node in the left node
		int leftnum = helper(root.left,current,k);
		
		if(leftnum + 1 + current == k) 
			res = root.val;
		
		int rightnum = helper(root.right, current+leftnum+1, k);
		
		return rightnum+ 1 + leftnum;
	}
}
