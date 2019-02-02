package algorithm;

import java.util.Arrays;

public class leet416 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canPartition1(int[] nums) {
		int sum = 0;
		for(int num :nums){
			sum += num;
		}
		if( (sum & 1) == 1) return false;
		sum /= 2;
		boolean [] dp = new boolean[sum+1];
		Arrays.fill(dp, false);
		dp[0] = true;
		
		for( int num:nums){ // this can ensure that every number use only once
			for(int j = sum; j>=num ;j --){
				dp[j] = dp[j] || dp[j-num];
			}
		}
		return dp[sum];
	}
	
	public boolean canPartition(int[] nums) {
        //this problem is very important 
		// the gist is still that we have to think in dp
		int sum = 0;
		for(int num: nums){
			sum += num;
		}
		if( (sum & 1) ==1 ) return false;
		sum /= 2;
		int n = nums.length;
		boolean [][] dp = new boolean [n+1][sum+1]; // n is the first number we have used; // sum is the sum can we can achieve
		//dp[i][j] with i numbers in the origin array, we can achieve the sum j;
		
		for(int i = 0; i< dp.length; i++){
			Arrays.fill(dp[i], false);
		}
		dp[0][0] = true;  //with no number, we can achieve sum 0;
		for(int i = 1; i<n+1;i++){
			dp[i][0] = true;
		}
//		for(int j = 1; j<sum+1; j ++){
//			dp[0][j] = false;
//		} // not necessary
		
		for(int i = 1; i<n+1; i++){
			for(int j = 1; j< sum+1; j++){
				dp[i][j] = dp[i-1][j];
				if(j >= nums[i-1])
					dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
			}
		}
		return dp[n][sum];
    }
}
