package algorithm;

public class leet221 {
	// total no idea dp problem
	// redo on Aug 15th
public int maximalSquare(char[][] matrix) {
        if(matrix == null ) return  -1;
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int [][] dp = new int[row+1][col+1];
        int res = 0;
        for(int i = 1; i<=row; i++){
        		for(int j = 1; j<=col; j++){
        			if(matrix[i-1][j-1] == '1'){
        				int tmp = Math.min(dp[i-1][j-1], dp[i][j-1]);
        				dp[i][j] = Math.min(dp[i-1][j], tmp) + 1;
        				if(dp[i][j] > res) res = dp[i][j];
        			}
        		}
        }
        
        return res*res;
    }

// finally i know how to reduce the space to only one row
public int maximalSquare1(char[][] matrix){
	if(matrix == null) return -1;
	if(matrix.length == 0 || matrix[0].length == 0) return 0;
	
	int row = matrix.length;
	int col = matrix[0].length;
	int res = 0;
	int dp[] = new int [col+1];
	for(int i = 1; i<= row; i++){
		int prev = 0;
		for(int j = 1; j<= col; j++){
			int temp = dp[j];
			if(matrix[i-1][j-1] == '1'){
				dp[j] = Math.min(prev, Math.min(dp[j-1], dp[j])) +1;
				res = Math.max(res, dp[j]);
			}
			else{
				dp[j] = 0;
			}
			prev = temp;
		}
	}
	return res*res;
}

}
