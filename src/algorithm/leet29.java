package algorithm;

public class leet29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new leet29().divide(-2147483648		,-1));
	}
	
	/*
	 * No1. minus Time exceed
	 * No2. times Time exceed
	 * I find the following in the example answer, the original is close to my thought
	 * 		Find the largest multiple so that (divisor * multiple <= dividend), 
	 *      	whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
	 *    	Think this as a binary search.
	 * 
	 * but this is not enough. Java always lead to overflow of the boundary.
	 * need to use the long to calculate.
	 * 
	 * */
	
	public int divide(int dividend, int divisor) {
		if(dividend == 0)
			return 0;
		
		boolean signNegative = false;
		
		if (dividend < 0 && divisor < 0)
			;
		else if(dividend < 0 || divisor < 0){
			signNegative = true;	
		}
		long ldividend = Math.abs((long)dividend);
		long ldivisor  = Math.abs((long)divisor);

		long res = 0;		
		while( ldividend >= ldivisor){
			long temp = ldivisor;
			long k = 1;
			while (ldividend >= temp ){
				ldividend -= temp;
				res += k;
				temp <<= 1;
				k <<= 1;
			}
		}
		
		if(signNegative)
			res = -res;
		
		return (int)Math.min(2147483647, Math.max(-2147483648, res));
    }
}
