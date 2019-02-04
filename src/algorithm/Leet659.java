package algorithm;

import java.util.HashMap;

public class Leet659 {
    public static void main(String[] args){

    }

    /**
    * 参考答案的解法2
    * */
    public boolean isPossible(int[] nums){
        Counters cnt = new Counters();
        Counters tails = new Counters();
        for(int x: nums){
            cnt.add(x, 1);
        }
        for(int x : nums){
            if(cnt.get(x) == 0) {
                continue;
            }
            else if (tails.get(x) > 0){
                tails.add(x, -1);
                tails.add(x+1, 1);
            }
            else if(cnt.get(x+1) > 0 && cnt.get(x+2) > 0){
                cnt.add(x+1, -1);
                cnt.add(x+2, -1);
                tails.add(x+3, 1);
            }
            else{
                return false;
            }
            cnt.add(x, -1);
        }
        return true;

    }

    class Counters extends HashMap<Integer,Integer> {
        public int get(int k){
            return containsKey(k) ? super.get(k) : 0;
        }
        public void add(int k, int v){
            put(k, get(k) + v);
        }
    }
}
