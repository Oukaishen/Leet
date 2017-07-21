package algorithm;

public class leet110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// this is my own method, O(N) but there is one state, not the best
//	boolean flag = true;
//	public boolean isBalanced(TreeNode root) {
//		 if(root == null) return true;
//		 int nouse = depth(root);
//		 return flag;
//    }
//	private int depth(TreeNode root){
//		if(root == null) return 0;
//		int left = depth(root.left);
//		int right = depth(root.right);
//		int compare = left - right;
//		if(compare > 1 || compare <-1) flag = false;
//		return Math.max(left, right)+1;
//	}
	
	// others method // the gist is that when u have find the unblancd. never go to detect others depth. just make them -1;
	public boolean isBalanced(TreeNode root){
		int result = depth(root);
		return result != -1;
	}
	private int depth(TreeNode root){
		if(root == null) return 0;
		int left = depth(root.left);
		if(left == -1) return -1;
		int right = depth(root.right);
		if(right == -1) return -1;
		
		if(Math.abs(left - right) >1) return -1;
		return Math.max(left, right)+1;
	}
}
