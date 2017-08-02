package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet102 {
	
	public static void main(String [] ars){
		leet102 test = new leet102();
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(test.levelOrder(root));
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		List<List<Integer>> res = new LinkedList<>();
		List<Integer> temp = new LinkedList<>();
		if(root == null) return res;
		
		que.add(null);
		que.add(root);
		
		while(que.size()>1){
			TreeNode node = que.poll();
			if(node == null) {
				res.add(temp);
				temp = new LinkedList<>();
				que.offer(null);
			}
			else{
				temp.add(node.val);
				if(node.left != null) que.offer(node.left);
				if(node.right != null) que.offer(node.right);
			}
		}
		res.add(temp);
		res.remove(0);
		return res;
    }
}
