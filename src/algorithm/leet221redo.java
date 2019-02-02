package algorithm;

public class leet221redo {
public int maximalSquare(char[][] matrix) {
        if(matrix == null) return -1;
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int [] dp = new int[col+1];
        int res = Integer.MIN_VALUE;
        
        for(int i = 1; i<= row; i++){
        		int prev = 0;
        		for(int j = 1; j<= col; j++){
        			int temp = dp[j];
        			if(matrix[i-1][j-1] == '1'){
	        			dp[j] = Math.min(prev, Math.min(dp[j-1], dp[j]))+1;
	        			res = Math.max(res, dp[j]);
        			}
        			else {
        				dp[j] = 0;
        				}
        			prev = temp;
        		}
        }
        
        return res*res;
    }
}
