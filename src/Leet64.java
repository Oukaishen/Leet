package algorithm;

public class Leet64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] testcase = new int[3][3];
//		testcase[0][0] = 1;
//		testcase[0][1] = 3;
//		testcase[0][2] = 1;
//		testcase[1][0] = 1;
//		testcase[1][1] = 5;
//		testcase[1][2] = 1;
//		testcase[2][0] = 4;
//		testcase[2][1] = 2;
//		testcase[2][2] = 1;
		
		int[][] testcase = new int[2][2];
		testcase[0][0] = 1;
		testcase[0][1] = 2;
		testcase[1][0] = 1;
		testcase[1][1] = 1;
		
	    System.out.println(minPathSum(testcase));	
	}

	public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int M = grid.length; int N = grid[0].length;
        int [][] dp = new int[M][N];
        dp[0][0] = grid[0][0];
        
        for(int i = 1; i < M; i++){
    			dp[i][0] = dp[i-1][0] + grid[i][0];
        }	
        
        for(int j = 1; j< N; j++){
        		dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        
        for(int i = 1; i < M; i++){
        		for(int j = 1; j< N; j++){
        			dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
        		}
        }
        
		return dp[M-1][N-1];
    }
}
