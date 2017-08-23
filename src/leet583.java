package algorithm;

public class leet583 {
public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return -1;
        if(word1.length() == 0 && word2.length() == 0) return 0;
        int M = word1.length();
        int N = word2.length();
        int[][] dp = new int[M+1][N+1];
        
        dp[0][0] = 0;
        for(int i = 0; i<=M;i++)
        		dp[i][0] = i;
        for(int j = 0; j<=N;j++)
    			dp[0][j] = j;
        
        for(int i = 1; i<=M; i++){
        		for(int j = 1; j<= N; j++){
        			if(word1.charAt(i-1) == word2.charAt(j-1))
        				dp[i][j] = dp[i-1][j-1];
        			else{
        				dp[i][j] = Math.min(dp[i-1][j-1]+2, Math.min(dp[i-1][j], dp[i][j-1])+1);
        				// here need to think. 
        				// dp[i-1][j-1]+1 >= max(dp[i-1][j], dp[i][j-1]), so no need to check that 
        			}
        		}
        }
        return dp[M][N];
    }
}
