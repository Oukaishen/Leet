package algorithm;

import java.util.LinkedList;
import java.util.List;

public class leet98 {
	// inorder trasvel is very useful here
public boolean isValidBST(TreeNode root) {
       	List<Integer> list = new LinkedList();
       	inOrder(root, list);
       	//int temp = list.get(0);
       	for(int i = 1; i<list.size();i++){
       		if(list.get(i) <= list.get(i-1)) return false;
       	}
       	return true;
    }

public void inOrder(TreeNode root, List<Integer> List){
	if (root == null) return;
	inOrder(root.left, List);
	List.add(root.val);
	inOrder(root.right,List);
	}
}
