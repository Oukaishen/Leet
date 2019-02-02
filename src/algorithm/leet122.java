package algorithm;

public class leet122 {
	
public static void main(String [] args){
	int [] input = new int[]{7,1,5,3,6,4};
	System.out.println(maxProfit(input));
}
	
public static int maxProfit(int[] prices) {
        
		if(prices == null || prices.length == 0 || prices.length == 1)
			return 0;
		int profit = 0;
		for(int i=1; i<prices.length; i++){
			if(prices[i] > prices[i-1])
				profit +=  (prices[i] - prices[i-1]);
		}
        
        
        return profit;
    }
}
