package algorithm;

public class leet121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		leet121 test = new leet121();
		int[] prices = {7,1,5,3,6,4};
		System.out.println(test.maxProfit(prices));
	}
	// this is my method O(n) time O(n) space
	public int maxProfit(int[] prices) {
		if(prices.length <= 1) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0; int buy = prices[0]; int sell = prices[0];
        for(int i = 1; i<prices.length; i++){
        		if(prices[i] > sell){
        			sell = prices[i];
        			dp[i] = sell - buy;
        		}
        		else if(prices[i] <=sell && prices[i] >= buy){
        			dp[i] = dp[i-1];
        		}
        		else{
        			dp[i] = dp[i-1];
        			buy = prices[i];
        			sell = prices[i];
        		}
        }
        int res=Integer.MIN_VALUE;
        for(int i = 0 ; i< dp.length; i++){
        		if(dp[i] > res)
        			res = dp[i];
        }
        return res;
    }
	
	// others' method 
	// O(n) time O(1) space, which is very cool
	public int maxProfit2(int[] prices) {
		int res = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<prices.length;i++){
			if(prices[i] < min)
				min = prices[i];
			else if(prices[i] - min > res){
				res = prices[i] - min;
			}
		}
		return res;
	}
}
