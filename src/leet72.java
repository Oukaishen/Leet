package algorithm;

public class leet72 {
	// very typical dp problem. redo on Aug 9th
public int minDistance(String word1, String word2) {
        // i think this is an very important problem.
		if(word1 == null && word2 == null) return 0;
		
		int m = word1.length();  int n = word2.length();
		int [][] dp = new int[m+1][n+1];
		
		for(int i = 0 ; i<=m ;i++){
			dp[i][0] = i;
		}
		for(int j = 0; j<=n; j++){
			dp[0][j] = j;
		}
		for(int i = 1; i<=m ;i++){
			char c1 = word1.charAt(i-1);
			for(int j = 1; j<= n; j++){
				char c2 = word2.charAt(j-1);
				
				// if equal, then no further operation
				if(c1 == c2)
					dp[i][j] = dp[i-1][j-1];
				else{
					//there are three situations
					// 1 replace  the word1[i-1] to the word[j-1] so that is dp[i-1][j-1]+1
					// 2 delete   the word1[i-1]    that is dp[i-1][j] + 1
					// 3 insert   the word2[j-1]    that is dp[i][j-1] + 1
					int tmp = Math.min(dp[i-1][j-1]+1, dp[i-1][j]+1);
					dp[i][j] = Math.min(tmp, dp[i][j-1]+1);
				}
			}
		}
		return dp[m][n];
    }

	// can we make this space less ? 
public int minDistance1(String word1, String word2) {
	int m = word1.length();  int n = word2.length(); 
	int[][] dp = new int[2][n+1];
	for(int j = 0; j<=n; j++){
		dp[0][j] = j;
	}
	for(int i = 1; i<=m ;i++){
		dp[1][0] = i;
		char c1 = word1.charAt(i-1);
		for(int j = 1; j<=n;j++){
			char c2 = word2.charAt(j-1);
			
			if(c1 == c2) dp[1][j] = dp[0][j-1];
			else{
				int tmp = Math.min(dp[1][j-1]+1, dp[0][j-1]+1);
				dp[1][j] = Math.min(tmp, dp[0][j]+1);
			}
		}
		
		for(int j = 0; j<=n; j++){
			dp[0][j] = dp[1][j];
		}
		
	}
	return dp[1][n];
}

}
