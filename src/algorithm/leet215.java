package algorithm;

import java.util.PriorityQueue;

public class leet215 {
	 
	public static void main(String [] args){
		leet215 test = new leet215();
		int[] nums = {2, 1};
		int k=1;
		System.out.println(test.findKthLargest1(nums, k));
	}
	
public int findKthLargest(int[] nums, int k) {
		// review heap-sort 
	    if(k < 1 || nums ==null) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i:nums){
        		pq.offer(i);
        		if(pq.size()>k)
        			pq.poll();
        }
        return pq.peek();
    }
public int findKthLargest1(int[] nums, int k) {
	k = nums.length - k;
	int lo = 0; int hi = nums.length-1;
	while(lo < hi){
		 int tmp = partition(nums,lo,hi);
		if(tmp > k) hi = tmp-1;
		else if(tmp < k) lo = tmp+1;
		else 
			break;
	}
	return nums[k];
}
private int partition(int [] nums, int lo, int hi){
	int i = lo; int j = hi+1;
	while(true){
//		while(i<= hi && less(nums[i], nums[lo])) i++; // here is wrong because the i wont increase
//		while(j>= lo  && less(nums[lo],nums[j])) j--;
		while(i< hi && less(nums[++i], nums[lo])); // here is ok
		while(j> lo  && less(nums[lo],nums[--j]));
		if(i>=j) break;
		exch(nums,i,j);
	}
	exch(nums,lo,j);
	return j;
}
private void exch(int [] nums, int i, int j){
	int tmp = nums[i];
	nums[i] = nums[j];
	nums[j] = tmp;
}
private boolean less(int a, int b){
	return a<b;
}
}
