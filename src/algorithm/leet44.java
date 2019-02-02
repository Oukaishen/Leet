package algorithm;

public class leet44 {
	public static void main(String[] args){
		String s = "zacabz";
		String p = "*a?b*";
		leet44 test = new leet44();
		System.out.println(test.isMatch(s, p));
	}
	//there is still a concise method, but thats not very likely i can think. -.-
public boolean isMatch(String s, String p) {
        if(s == null || p == null ) return false;
        int row = s.length();
        int col = p.length();
        
        boolean [][] dp = new boolean[row+1][col+1];
        dp[0][0] = true;
        for(int i = 1; i<= col; i++){
        		if(p.charAt(i-1) == '*') dp[0][i] = dp[0][i-1];
        }
        
        for(int i = 1; i<=row; i++){
        		char c1 = s.charAt(i-1);
        		for(int j = 1; j<=col; j++){
        			char c2 = p.charAt(j-1);
        			if(c1 == c2 || c2 == '?')
        				dp[i][j] = dp[i-1][j-1];
        			else if(c2 == '*')
        				dp[i][j] = dp[i][j-1] || dp[i-1][j-1] || dp[i-1][j];
        			else
        				dp[i][j] = false;
        		}
        }
        return dp[row][col];
}
}
