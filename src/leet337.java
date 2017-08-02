package algorithm;

import java.util.HashMap;
import java.util.Map;

public class leet337 {
	
	// for the very first stage, we can think of an naive recursive problem
	public int rob(TreeNode root) {
        if(root == null) return 0;
		int val = 0;
		
		if(root.left != null){
			val += rob(root.left.left) + rob(root.left.right);
		}
		
		if(root.right != null){
			val += rob(root.right.left) + rob(root.right.right);
		}
		
		return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
	
	public int rob1(TreeNode root){
		return robSub(root, new HashMap<>());
	}
	// then we need to think more deeper
	private int robSub(TreeNode root, Map<TreeNode, Integer> map){
		if(root == null) return 0;
		if(map.containsKey(root)) return map.get(root);
		
		int val = 0;
		
		if(root.left != null ){
			val += robSub(root.left.left, map) + robSub(root.left.right,map);
		}
		
		if(root.right != null){
			val += robSub(root.right.right,map) + robSub(root.right.left, map);
		}
		val = Math.max(root.val + val, robSub(root.left,map) + robSub(root.right,map));
		map.put(root, val);
		
		return val;
	}
	
	// then we can think much deeper 
	
	public int rob2(TreeNode root){
		int [] res =  robSub(root);
		return Math.max(res[0], res[1]);
	}
	
	private int[] robSub(TreeNode root){
		if(root == null ) return new int[]{0,0};
		
		int [] left = robSub(root.left);
		int [] right = robSub(root.right);
		int [] res = new int[2];
		
		// the first is the max without the root
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		
		// the second is the max with the root
		res[1] = root.val + left[0] + right[0];
		
		return res;
	}
}
