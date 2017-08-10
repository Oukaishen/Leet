package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leet494 {
	int res = 0;
	public static void main(String [] args){
		leet494 test = new leet494();
		int [] nums = {1,1,1,1,1};
		int S = 3;
		System.out.println(test.findTargetSumWays2(nums, S));
	}
	//embrassing, this method is figured out myself, only beat 31.8% and takes 683ms -.-
public int findTargetSumWays(int[] nums, int S) {
        // cannot find some method to do this 
		if(nums == null || nums.length == 0) return -1;
		if(S > 1000) return 0;
		// then i think of tree, this is exactly binaray tree. so i think of dfs
		DFS(nums, S, 0, 0);
		return res;
    }

private void DFS(int [] nums, int S, int pre, int now){
	if(now > nums.length) throw new ArrayIndexOutOfBoundsException();
	if(now == nums.length ){
		if(pre == S ) res++;
		return;
	}
	int addNow = pre + nums[now];
	int minNow = pre - nums[now];
	DFS(nums, S, addNow, now+1);
	DFS(nums, S, minNow, now+1);
}

// can i try using the que, will thie be faster?
// >.< this even cannot pass the time requirement!!
public int findTargetSumWays1(int[] nums, int S){
	if(nums == null || nums.length == 0 ) return 0;
	int res1 = 0;
	Queue<Integer> que = new LinkedList<>();
	que.offer(0);
	que.offer(null);
	for(int i = 0; i< nums.length; i++){
		while(que.peek() != null ){
			int temp = que.poll();
			que.offer(temp + nums[i]);
			que.offer(temp - nums[i]);
		}
		que.poll();
		que.offer(null);
	}
	for(Integer num: que){
		if( num!=null && num == S) res1++;
	}
	return res1;
}

// how to be faster? how?
// lets try to trade space for time
// wocao, the method takes only 32ms.. 20 times daddy. i can only call u daddy
// this i quite impressive
public int findTargetSumWays2(int [] nums, int S){
	int [][] dp = new int[nums.length][2001];
	for(int [] row: dp)
		Arrays.fill(row, Integer.MIN_VALUE);
	return SubDFS(nums, S, 0, 0,dp);
}

private int SubDFS(int [] nums, int S, int pre, int now, int [][] dp){
	if(now == nums.length){
		if(pre == S) return 1;
		else return 0;
	}
	else{
		if(dp[now][pre+1000] != Integer.MIN_VALUE) return dp[now][pre+1000];
		
		int addNow = SubDFS(nums,S,pre+nums[now],now+1, dp);
		int minNow = SubDFS(nums,S,pre-nums[now],now+1, dp);
		dp[now][pre+1000] = addNow+minNow;
		return dp[now][pre+1000];
	}
}
}
