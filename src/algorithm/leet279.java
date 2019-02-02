package algorithm;

public class leet279 {
	public static void main(String [] args){
		leet279 test = new leet279();
		System.out.println(test.numSquares(12));
	}
public int numSquares(int n) {
	 // the gist is that, once again, if we are one step before to find the answer
	 // the one more step is must a perfect square number, in this way
	 // dp[i] = 1 + min(dp[i-s1], dp[i-s2], dp[i-s3], ...)
     int root =(int) Math.sqrt(n);
     if(root*root == n)
    	 	 return 1;
     int [] dp = new int[n+1]; dp[0] = 0;
     
     for(int i = 1; i<=n; i++){
    	 	 int tmpRoot = (int) Math.sqrt(i);
    	 	 if(tmpRoot * tmpRoot == i){
    	 		 dp[i] = 1;
    	 		 continue;
    	 	 }
    	 	 int tmp = Integer.MAX_VALUE;
    	 	 for(int j = 1; j <= root && j*j<i; j++){
    	 		 //if (dp[i-j*j]+1 >= tmp) continue;
    	 		 if(dp[i-j*j]+1 < tmp)
    	 			 tmp = 1+dp[i-j*j];
    	 	 }
    	 	 dp[i] = tmp;
     }
     return dp[n];
}
}
