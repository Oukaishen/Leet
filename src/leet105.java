package algorithm;

import java.util.Arrays;

public class leet105 {
		// dont afraid just do that 
		// be confident
public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        if(preorder.length == 0 || inorder.length == 0) return null;
        if(preorder.length != inorder.length ) return null;
        
        int rootval = preorder[0];
        int lo=0; int hi=inorder.length;
        int index = 0;
        
        for(int i =0; i< inorder.length; i++){
        		if(inorder[i] == rootval){
        			index = i;
        		}
        }
        if(inorder[index] != rootval) return null;
        TreeNode root = new TreeNode(rootval);
        
        int [] inorder_left = Arrays.copyOfRange(inorder, lo, index);
        int [] inorder_right = Arrays.copyOfRange(inorder, index+1, hi);
        
        int [] preorder_left = Arrays.copyOfRange(preorder, 1, 1+index);
        int [] preorder_right = Arrays.copyOfRange(preorder, index+1, hi);
        
        root.left = buildTree(preorder_left, inorder_left);
        root.right = buildTree(preorder_right, inorder_right);
        
        return root;
        
    }
}
