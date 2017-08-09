package algorithm;

public class leet72redo {
	// kaishen dont afraid just do it
public int minDistance(String word1, String word2) {
	
        if(word1 == null && word2 == null) return -1;
        int row = word1.length();
        int col = word2.length();
        
        int [] dp = new int [col+1];
        for(int j = 0; j<=col;j++){
        		dp[j] = j;
        }
        
        for(int i = 1; i<=row; i++){
        		int prev = dp[0];
        		dp[0] = i;
        		char c1 = word1.charAt(i-1);
        		for(int j = 1; j<=col; j++){
        			int temp = dp[j];
        			char c2 = word2.charAt(j-1);
        			if(c1 == c2){
        				dp[j] = prev;
        			}
        			else{
        				dp[j] = Math.min(prev, Math.min(dp[j], dp[j-1]))+1;
        			}
        			prev = temp;
        		}
        }
        return dp[col];
    }
}
