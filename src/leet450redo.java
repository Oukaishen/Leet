package algorithm;

public class leet450redo {
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = null;
		root.right.right = new TreeNode(7);
		leet450redo test = new leet450redo();
		TreeNode result = test.deleteNode(root, 3);
		System.out.println(" ");
	}
	//just for redo to be more skillful
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null ) return root;
		if(key < root.val ) root.left = deleteNode(root.left, key);
		else if( key > root.val) root.right = deleteNode(root.right, key);
		else{
			if(root.left == null ) return root.right;
			if(root.right == null) return root.left;
			TreeNode tmpNode = root;
			root = findmin(root.right);
			root.right = delmin(tmpNode.right); // this have to be before the next command, very important/
			root.left = tmpNode.left;
			
		}
		return root;
    }
	public TreeNode findmin(TreeNode root){
		 if(root == null) return root;
		 while(root.left != null){
			 root = root.left;
		 }
		 return root;
	}
	
	public TreeNode delmin(TreeNode root){
		if(root == null ) return  root;
		if(root.left == null ) return root.right;
		root.left = delmin(root.left);
		return root;
	}
}
