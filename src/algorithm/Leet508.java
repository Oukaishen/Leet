package algorithm;


import java.util.*;

public class Leet508 {
    public static void main(String [] args){

        Leet508 test = new Leet508();

    }

    HashMap<Integer, Integer> cntMap;
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> resList = new LinkedList<>();
        if(root == null){
            return new int[]{};
        }
        cntMap = new HashMap<>(16);
        postOrder(root);
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for(int c : cntMap.values()){
            if ( c > max )
                max = c;
        }
        for(int c :cntMap.values()){
            if(c == max){
                cnt++;
            }
        }
        int [] res = new int[cnt];
        cnt=0;
        for(Map.Entry<Integer,Integer> keyValue: cntMap.entrySet()){
            if(keyValue.getValue() == max){
                res[cnt++] = keyValue.getKey();
            }
        }
        return  res;

    }

    private int postOrder(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        int sum = root.val + left + right;
        cntMap.put(sum, cntMap.getOrDefault(sum,0) + 1);
        return sum;
    }
}
