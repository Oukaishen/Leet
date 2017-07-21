package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class leet297 {
	//fucking annoying, redo on july 28
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.left.left = new TreeNode(3);
		root.right.left.right = new TreeNode(1);
		leet297 test = new leet297();
		System.out.println(test.serialize(root));
		TreeNode result = test.deserialize(test.serialize(root));
		System.out.println(result);
	}
	// seems bfs order will be more simple to deserialize;
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
    		Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        StringBuffer result = new StringBuffer();
        while(!que.isEmpty()){
        		TreeNode tmp = que.poll();
        		if(tmp == null) {
        			result.append("#,");
        			continue;
        		}
        		result.append(tmp.val+",");
        		//if(tmp.left == null && tmp.right == null ) continue;
        		que.offer(tmp.left);
        		que.offer(tmp.right);
        }
        return result.deleteCharAt(result.length()-1).toString();
    }
    	
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       String[] arr = data.split(",");
       if(arr[0].equals("#")) return null;
       Queue<TreeNode> que = new LinkedList<TreeNode>();
       TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
       que.offer(root);
       for(int i = 1; i<arr.length; i++){
    	   		TreeNode par = que.poll();
    	   		if(!arr[i].equals("#")){
    	   			TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
    	   			par.left = left;
    	   			que.offer(left);
    	   		}
    	   		if(!arr[++i].equals("#")){
    	   			TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
    	   			par.right = right;
    	   			que.offer(right);       // this is the example change i in for-loop
    	   		}
       }
       return root;
    }
    
}
