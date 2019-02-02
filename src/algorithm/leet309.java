package algorithm;

public class leet309 {
	public static void main(String[] agrs){
		leet309 test = new leet309();
		int [] prices =  {1,7,2,2};
		System.out.println(test.maxProfit(prices));
	}
public int maxProfit(int[] prices) {	
        //fucking damn question
		// cannot find any clue myself
	     // there are still otehr methods. however not as simple to understand as this one.
		// key thinking is that u can use more that one array to do the dp
		// dp don't have to be restricted in using only one array
		// we can tried to user more array to represent its states.
		// also, we have no idea how to represent states. but what we are clear is that we have 3 actions
		// so we start from those actions. give a whatever state called s0, s1, s2.
		// s0 buy -> s1;  s0 reset -> s0;
	    // s1 sell -> s2; s1 reset -> s1;
	    // s2 reset -> s0; 
		int n = prices.length;
		if(prices == null || n == 0) return 0;
		int s0[] = new int[n]; s0[0] = 0;
		int s1[] = new int[n]; s1[0] = 0 - prices[0];
		int s2[] = new int[n]; s2[0] = Integer.MIN_VALUE;
		
		for(int i = 1; i<n ;i++){
			s0[i] = Math.max(s0[i-1], s2[i-1]);
			s1[i] = Math.max(s0[i-1]-prices[i], s1[i-1]);
			s2[i] = s1[i-1]+prices[i];
		}
		return Math.max(s0[n-1], s2[n-1]);
    }
}
