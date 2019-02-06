package algorithm;

import java.util.HashSet;

public class Leet904 {
    public static void main(String [] args){

    }

    /**
     * 独立解决，但是感觉太慢
     * */
    public int totalFruit(int[] tree){
        if(tree == null || tree.length == 0){
            return 0;
        }
        int begin = 0, end = 0, res = 0, tmp = 0;
        HashSet<Integer> buckets = new HashSet<>();
        while(begin < tree.length && end < tree.length){
            int newNum = tree[end];
            if(buckets.contains(newNum)){
                end++;
                tmp++;
                res = Math.max(res, tmp);
            }
            else if (buckets.size() < 2){
                end++;
                buckets.add(newNum);
                tmp++;
                res = Math.max(res, tmp);
            }
            else{
                begin++;
                end = begin;
                buckets.clear();
                tmp = 0;
            }
        }
        return res;
    }

    public int totalFruit2(int[] tree){
        int res = 0, begin = 0;
        Leet659.Counters cnt = new Leet659().new Counters();
        for(int end = 0; end< tree.length; end++){
            cnt.add(tree[end], 1);
            while(cnt.size() > 2 ){
                cnt.add(tree[begin], -1);
                if(cnt.get(tree[begin]) == 0){
                    cnt.remove(tree[begin]);
                }
                begin++;
            }
            res = Math.max(res, end - begin + 1);
        }
        return res;
    }
}
