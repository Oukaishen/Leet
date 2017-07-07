package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class leet94 {
	//recursive method
//	public List<Integer> inorderTraversal(TreeNode root) {
//	         List<Integer> result = new LinkedList<Integer>();
//	         if(root == null) return result;
//	         Vis(root, result);
//	         return result;
//	}
//	public void Vis(TreeNode root, List<Integer> list){
//		if (root == null ) return;
//		Vis(root.left,list);
//		list.add(root.val);
//		Vis(root.right,list);
//	}
	
	//iterative method
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if(root == null) return result;
        Vis(root, result);
        return result;
	}
	public void Vis(TreeNode root, List<Integer> list){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(root.left != null){ // push all the left
			root = root.left;
			stack.push(root);
		}
		
		//begin to pop and insert into list
		while(root != null){
			
			root = stack.pop();
			// update the value in list
			list.add(root.val);
			
			// has right child
			if(root.right != null){
				root = root.right;
				stack.push(root);
				while(root.left != null){ // push all the left
					root = root.left;
					stack.push(root);
				}
				continue;
			}
			if(stack.isEmpty()) break;
			
			
		}
		
	}
}
