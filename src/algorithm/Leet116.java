package algorithm;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Leet116 {
    public static void main(String[] agrs){

    }

    public Node connect(Node root) {
        if(root == null)
            return;
        /*
        * assume all node are perfect binary tree
        * 做一个层级访问应该是OK的
        * */
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        que.offer(null);

        while(que.size() > 1){
            Node cur = que.poll();
            if(cur == null ){
                que.offer(null);
                continue;
            }
            Node next = que.peek();
            if(cur.left != null){
                que.offer(cur.left);
                que.offer(cur.right);
            }
            cur.next = next;
        }

        return root;
    }

}
