package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class leet101 {
public boolean isSymmetric(TreeNode root) {
        return match(root.left, root.right);
    }

private boolean match(TreeNode node1, TreeNode node2){
	if(node1 == null && node2 == null) return true;
	if(node1 == null || node2 == null) return false;
	if(node1.val != node2.val) return false;
	
	return match(node1.left, node2.right) && match(node1.right, node2.left);
}

public boolean isSymmetric1(TreeNode root){
	Queue<TreeNode> que = new LinkedList<>();
	que.add(root); // for use
	que.add(root);
	
	while(!que.isEmpty()){
		TreeNode node1 = que.poll();
		TreeNode node2 = que.poll();
		if(node1 == null && node2 == null) continue;
		if(node1 == null || node2 == null) return false;
		if(node1.val != node2.val) return false;
		que.offer(node1.left);
		que.offer(node2.right);
		que.offer(node2.left);
		que.offer(node1.right);
	}
	return true;
}
}
