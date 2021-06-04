package algorithm;

import java.util.LinkedList;
import java.util.List;

public class leet1022 {

    public int sumRootToLeaf(TreeNode root) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, sb, root);
        int sum = 0;
        for(String path: res){
            sum += Integer.parseInt(path,2);
        }
        return sum;
    }

    private void helper(List<String> res, StringBuilder sb, TreeNode root){
        if(root == null){
            return;
        }
        sb.append(root.val);
        if(root.left == null && root.right == null){
            res.add(sb.toString());
        }
        helper(res, sb, root.left);
        helper(res,sb,root.right);
        sb.deleteCharAt(sb.length()-1);
    }
}
