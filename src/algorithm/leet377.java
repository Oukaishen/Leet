package algorithm;

import java.util.Arrays;

public class leet377 {
	//
	public static void main(String[] args){
		int [] nums = {1,2,3};
		int target = 4;
		leet377 test = new leet377();
		System.out.println(test.combinationSum4(nums,target));
	}
	// this is my own thought, mark the start and the target;
	public int combinationSum4(int[] nums, int target) {
		 int N = nums.length;
		 int [][] dp = new int [N+1][target+1];
		 for(int i = 1; i<=N;i++){
			 dp[i][0] = nums[i-1];
		 }
		 for(int i = 1; i<= target; i++){
			 dp[0][i] = i;
		 }
		 
		 for(int col =1; col<=target; col++){
			 int currTar = dp[0][col];
			 for(int row = 1; row<=N;row++){
				  int currStart = dp[row][0];
				  //  start > currTar
				 if(currStart > currTar){
					 dp[row][col] = 0;
					 continue;
				 }
				 else if(currStart == currTar){
					 dp[row][col] = 1;
					 continue;
				 }
				 else{
					 int count = 0;
					 int dis = currTar-currStart;
					 for(int j = 1; j<=N;j++){
						 count += dp[j][dis];
					 }
					 dp[row][col] = count;
				 }
			 }
		 }
		 
		 int result =0;
		 for(int j = 1; j<=N;j++){
			 result += dp[j][target];
		 }
		 return result;
    }
	// this is others very good thought
	// the key is if we only need one more step to accomplished dp(target)
	// then we can see it must for evey number in input that < target
	// we have dp(target) =sigma[ dp(target - i)] 
	public int combinationSum41(int[] nums, int target) {
		int [] result = new int[target+1];
		Arrays.sort(nums);
		for(int curTar = 0; curTar <= target; curTar++){
			for(int curStart:nums){
				if(curStart > curTar){
					break;
				}
				else if(curStart == curTar){
					result[curTar]++;
				}
				else{
					result[curTar] += result[curTar-curStart];
				}
			}
		}
		return result[target];
	}
}
