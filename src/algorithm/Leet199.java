package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Leet199 {
    public static void main(String[] args){

    }
    public List<Integer> rightSideView(TreeNode root) {

        /**
         * 思路，树的层级历遍，借用队列的功效；
         */
        List<Integer> res = new LinkedList<>();
        if(root == null ) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (queue.size() > 1){
            TreeNode node = queue.poll();
            if(node == null){
                queue.offer(null);
                continue;
            }
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
            if(queue.peek() == null) res.add(node.val);
        }
        return res;
    }

    public List<Integer> rightSideView2(TreeNode root) {

        /**
         * 思路2，树的DFS；
         */
        List<Integer> res = new LinkedList<>();
        dfs(root, res, 0);
        return  res;

    }
    private void dfs(TreeNode root, List<Integer> res, int level){
        if(root == null) return;
        if(res.size() == level) res.add(root.val);
        dfs(root.right, res, level +1);
        dfs(root.left, res, level +1);
    }
}
