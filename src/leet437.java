package algorithm;

import java.util.HashMap;
import java.util.Map;

public class leet437 {
	public static void main(String[] args){
		leet437 test = new leet437();
		TreeNode root = new TreeNode(3);
		System.out.println(test.pathSum(root, 3));
	}
	//genius technique. i like this method.
public int pathSum(TreeNode root, int sum) {
       HashMap<Integer, Integer> map = new HashMap<>();
       map.put(0, 1);
       
       return sub(root, 0, sum, map);
}
private int sub(TreeNode root, int presum, int target, Map<Integer,Integer> map  ){
	if(root == null ) return 0;
	presum += root.val;
	int Atpoint = map.getOrDefault(presum-target, 0);
	
	map.put(presum, map.getOrDefault(presum, 0)+1);
	
	Atpoint += sub(root.left, presum, target, map) + sub(root.right, presum, target, map);
	
	map.put(presum, map.get(presum)-1);
	
	return Atpoint;
}

// try another dfs method
private int pathSum1(TreeNode root, int sum){
	if(root == null) return 0;
	return dfs(root,sum) + pathSum1(root.left, sum) + pathSum1(root.right, sum);
}

// calculate all the numbers of way to get sun ended at this root
private int dfs(TreeNode root, int sum){
	if(root == null) return 0;
	return (root.val == sum ? 1:0) + dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);
}

}
