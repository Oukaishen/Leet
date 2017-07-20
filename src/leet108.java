package algorithm;

public class leet108 {
		// thought 1 try recursion
	public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0, nums.length-1);
    }
	public TreeNode sortedArrayToBST(int[] nums, int start, int end){
		if(start > end) return null;
		if(start == end) return new TreeNode(nums[end]);
		
		int mid = start + (end - start)/2; 
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums,start,mid-1);
		root.right = sortedArrayToBST(nums,mid+1, end);
		return root;
	}
}
