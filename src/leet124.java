
public class leet124 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int max = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
		maxSub(root);
		return max;
	}
	
public int maxSub(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(0, maxSub(root.left));
        int right = Math.max(0, maxSub(root.right));
        
        if(max < root.val+left+right) max = root.val + right+left;
        
        return Math.max(left, right) + root.val;
    }
}
