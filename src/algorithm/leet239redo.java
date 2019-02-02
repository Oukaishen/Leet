package algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class leet239redo {
	
public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0) return new int[0];
        
        int n = nums.length;
        int [] res = new int[n-k+1];
        int ri = 0;
        
        Deque<Integer> dq = new LinkedList<Integer>(); 
        
        for(int i = 0; i < n ;i++){
        		while(!dq.isEmpty() && dq.peek() < i-k+1) dq.poll();
        		while(!dq.isEmpty() && nums[dq.peekLast()] <nums[i]) dq.pollLast();
        		dq.offer(i); // here offer index is for convenient to detect whether it is outside the range i-k+1
        		if(i>=k-1){
        			res[ri++] = nums[dq.peek()];
        		}
        }
        return res;
    }

}
