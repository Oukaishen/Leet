package algorithm;

import java.util.Arrays;

public class leet494redo {
	 public int findTargetSumWays(int[] nums, int S) {
		 int [][] dp = new int[nums.length][2001];
		 for(int[] row: dp)
			 Arrays.fill(row, Integer.MIN_VALUE);
		 return DFS(nums, dp,S,0,0);
	 }
	 
	 private int DFS(int [] nums, int[][] dp, int S, int pre, int now){
		 if(now > nums.length) throw new UnsupportedOperationException();
		 if(now == nums.length  ){
			 if( pre == S ) return 1;
			 return 0;
		 }
		 if(dp[now][pre+1000] != Integer.MIN_VALUE) return dp[now][pre+1000];
		 else{
			 int addNow = DFS(nums, dp, S, pre+nums[now], now+1);
			 int minNow = DFS(nums, dp, S, pre-nums[now], now+1);
			 dp[now][pre+1000] = addNow + minNow;
			 return dp[now][pre+1000];
		 }
	 }
}
