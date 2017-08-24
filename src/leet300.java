package algorithm;

import java.util.Arrays;

public class leet300 {
	public static void main(String [] args){
		int [] nums = {1,3,6,7,9,4,10,5,6};
		int res = lengthOfLIS(nums);
        System.out.println(res);
	}
	
//	 static int [] aux;
	 public static int lengthOfLIS(int[] nums) {
		 if(nums == null || nums.length == 0) return 0;
	     int [] dp  = new int[nums.length];
	     dp[0] = 1; int count = 1; int res = 1;
	     for(int i = 1; i< nums.length ; i++){
	    	 	count = 1;
	    	 	for(int j = 0; j< i; j++){
	    	 		if(nums[i] > nums[j])
	    	 			count = Math.max(count, 1+dp[j]);
	    	 	}
	    	 	dp[i] = count;
	    	 	res = Math.max(res, count);
	     }
	     return res;
	    }
	 
	 // the merge sort is no use here. -.-  okay, just consider it as an practise 
//	 private static void mergesort(int [] nums, int [] index, int lo, int hi){
//		 if(lo >= hi) return;
//		 int mid = (lo+hi)/2;
//		 mergesort(nums, index, lo, mid);
//		 mergesort(nums, index, mid+1, hi);
//		 merge(nums, index, lo, hi);
//	 }
//	 
//	 private static void merge(int [] nums, int[] index, int lo, int hi){
//		 int mid = (lo+hi)/2;
//		 int i = lo; int j = mid+1;
//		 
//		 for(int k = lo; k<= hi; k++)
//			 aux[k] = index[k];
//		 
//		 for(int k = lo; k<=hi; k++){
//			 if(i>mid) index[k] = aux[j++];
//			 else if(j > hi) index[k] = aux[i++];
//			 else if( nums[ aux[i] ]  < nums[ aux[j] ]) index[k] = aux[i++];
//			 else index[k] = aux[j++];
//		 }
//	 }
	 
	 
}
