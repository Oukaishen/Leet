package algorithm;

import java.util.*;
import java.util.stream.Collectors;


public class leet239 {
	
	public static void main(String [] args){
	  leet239 test = new leet239();
	  
	  int nums [] = {1,3,-1,-3,5,3,6,7};
	  int k = 3;
	  List<Integer> res = Arrays.stream(test.maxSlidingWindow(nums, k)).boxed().collect(Collectors.toList());
	  System.out.println(res);

	}
	// this method is called montonic queue. it has deep thought
	//  redo on August 12th
	public int[] maxSlidingWindowBak(int[] nums, int k) {
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

  public int[] maxSlidingWindow(int[] nums, int k){

		if(nums == null || k == 0){
			return new int[0];
		}

		int N = nums.length;
		int [] res = new int[N - k + 1];
		int ptr = 0;

		Deque<Integer> deque = new LinkedList<>();

		for(int i = 0; i < N; i++){
			while(!deque.isEmpty() && deque.peek() < i - k + 1 ){
				deque.poll();
			}
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i] ){
				deque.pollLast();
			}
			deque.offer(i);

			if(i - k + 1 >= 0){
				res[ptr++] = nums[deque.peek()];
			}
		}

		return res;
	}
}
