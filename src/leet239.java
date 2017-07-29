package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;




public class leet239 {
	
	public static void main(String [] args){
	  leet239 test = new leet239();
	  
	  int nums [] = {1,3,-1,-3,5,3,6,7};
	  int k = 3;
	  System.out.println(test.maxSlidingWindow(nums, k));
	}
	// this method is called montonic queue. it has deep thought
	//  redo on August 12th
	public int[] maxSlidingWindow(int[] nums, int k) {
		if ( nums == null || k ==0 ) return new int[0];
		
		int n = nums.length;
		int [] res = new int[n-k+1];
		int ri = 0;
		
		Deque<Integer> dque = new ArrayDeque<Integer>();
		
		for(int i = 0; i<nums.length; i++){
			while(!dque.isEmpty() && dque.peek() < i-k+1){
				dque.poll();
			}
			while(!dque.isEmpty() && nums[dque.peekLast()] < nums[i]){
				dque.pollLast();
			}
			dque.offer(i);
			if(i >= k - 1 ) {
				res[ri++] = nums[dque.peek()];
			}
		}
		return res;
    }
}
