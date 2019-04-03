package algorithm;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Leet414 {
    public static void main(String [] agrs){
        int [] nums = new int[]{2,2,3,1};
        Leet414 test = new Leet414();
        System.out.println(test.thirdMax(nums));
    }

    /**
     * quite ugly method 1
     * */
    public int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0){
            return  -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(3);
        HashSet<Integer> setNum = new HashSet<>();
        for(int num : nums){
            setNum.add(num);
        }
        for(int num : setNum){
            if(pq.size() < 3){
                pq.add(num);
            }
            else if(num > pq.peek()){
                pq.poll();
                pq.offer(num);
            }
        }
        int res = pq.peek();
        while (pq.size() < 3 && !pq.isEmpty())
            res = pq.poll();
        return res;
    }

    
}
