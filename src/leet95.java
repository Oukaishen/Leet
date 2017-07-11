package algorithm;

import java.util.ArrayList;
import java.util.List;

public class leet95 {

	public static void main(String[] args){
		leet95 test = new leet95();
		System.out.println(test.generate(3,1));
	}
	
public List<TreeNode> generateTrees(int n) {
		if(n == 0)
			return new ArrayList<TreeNode>();
        return generate(n, 1);
    }

public List<TreeNode> generate(int n, int start){
	if(n < 0) return null;
    
    List<TreeNode> result = new ArrayList<TreeNode>();
    
    if(n == 0){
    		result.add(null);
    		return result;
    }
    else if (n == 1){
    		result.add(new TreeNode(start));
    		return result;
    }
    else{
    		for(int i = 1; i <= n; i++){
    			
    			// i think this is very cool design that i can consider the start number
    			List<TreeNode> leftlist = generate(i-1, start);
    			List<TreeNode> rightlist = generate(n-i, start+i);
    			
    			for( TreeNode  leftnode: leftlist){
    				for(TreeNode rightnode : rightlist){
    					TreeNode root = new TreeNode(start + i -1);
    					root.left = leftnode;
    					root.right = rightnode;
    					result.add(root);
    				}
    			}
    		}
    		return result;
    }
}
	
}
