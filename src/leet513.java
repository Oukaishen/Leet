package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class leet513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(4);
//		root.right.left = new TreeNode(5);
//		root.right.right = new TreeNode(6);
//		root.right.left.left = new TreeNode(7);
		
		TreeNode root = new TreeNode(0);
		
		System.out.println(findBottomLeftValue(root));
	}

	static TreeMap<Integer, Integer> res = new TreeMap<>();
	/*
	 * 
	 * The thought is 
	 * 1. find the bottom level
	 * 2. find the left from the bottom
	 * 
	 * recursive seem better, use a field
	 * */
	public static int findBottomLeftValue(TreeNode root) {
        if(root == null) 
        		return -1;
        helper(0,root);
        return res.lastEntry().getValue();
    }
	
	private static void helper(int level, TreeNode root){
		if(root == null)
			return;
		helper(level+1, root.left);
		if(!res.containsKey(level))
			res.put(level, root.val);
		helper(level+1, root.right);
	}
	
}


