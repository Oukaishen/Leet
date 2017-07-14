package algorithm;

public class leet450 {
	// this is fucking annoying. need to redo after one week on 20 July
public TreeNode deleteNode(TreeNode root, int key) {
//        if(root == null ) return root;
//		//1 search for the node
//        //TreeNode virtual = new TreeNode(-1);
//        //virtual.left = root;
//		TreeNode tmpNode = root;
//		TreeNode parNode = null;
//		while(tmpNode != null){
//			if(key < tmpNode.val){
//				parNode = tmpNode;
//				tmpNode = tmpNode.left;
//				continue;
//			}
//			else if(key > tmpNode.val){
//				parNode = tmpNode;
//				tmpNode = tmpNode.right;
//				continue;
//			}
//			else{
//				// hit and find the key
//				break;
//			}
//		}
//		if(tmpNode == null) return root; // not find the key
//		//else if(tmpNode == root) parNode = root; 
//		
//		//2 delete the node
//		
//		  //special case : if the delete node is root
//		if (tmpNode == root){
//			if(root.left == null && root.right == null)
//				return null; // delete the only one root
//			else if (root.right != null){
//				int tmp = findmin()
//				
//			}
//		}
//		else{
//			//case 1 if node have no child
//		if(tmpNode.left == null && tmpNode.right == null){
//			if(key < parNode.val) {
//				parNode.left = null;
//				return root;}
//			else if(key > parNode.val) {
//				parNode.right = null;
//				return root;}
//		}
//		//case 2 have one child
//		else if(tmpNode.left == null || tmpNode.right == null){
//			if(tmpNode.left != null){
//				parNode
//			}
//		}
//		}
//		
		if(root == null) return root; // not found , do nothing
		int compare = key - root.val;
		if(compare < 0 ){
			root.left = deleteNode(root.left,key);
		}
		else if(compare > 0){
			root.right = deleteNode(root.right,key);
		}
		else if(root.left != null && root.right != null){
			// have two children
			// this can work, just change the value but not change the node
//			root.val = findmin(root.right).val;
//			root.right = delmin2(root.right);
			
			// another method
			TreeNode tmp = root;
			root = findmin(root.right);
			root.right = delmin(tmp.right);
			root.left = tmp.left;
		}
		else{
			root = (root.left != null) ? root.left : root.right;
		}
		return root;
    }

private TreeNode findmin(TreeNode root){
	if(root == null) return null;
	//else if(root.left == null) return root;
	else{
		TreeNode tmpNode = root;
		while(tmpNode.left != null){
			tmpNode = tmpNode.left;
		}
		return tmpNode;
	}
}

//del min iterative
private TreeNode delmin(TreeNode root){
	if(root == null) return null;
	else if(root.left == null ){
		return root.right;
	}
	else {
		TreeNode tmp = root;
		TreeNode tmp2 = root.left;
		while(tmp2.left != null){
			tmp = tmp2;
			tmp2 = tmp.left;
		}
//		if(tmp2.right != null){
//			tmp.left = tmp2.right;
//		}
//		else{
//			tmp.left = null;
//		}
		tmp.left = tmp2.right;
		return root;
	}
}

//recursive delmin2
private TreeNode delmin2(TreeNode root){
	if(root == null) return null;
	if(root.left != null){
		root.left = delmin2(root.left);
		return root;
	}
	else
		return root.right;
}


}
