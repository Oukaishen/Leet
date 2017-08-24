package algorithm;

import java.util.Arrays;

public class leet647 {
	// cool this is my own method
	// there is still better method
public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int N = s.length();
        boolean [][] dp = new boolean[N][N];
        	// explicit initialize
        for(int i = 0; i<N; i++)
        		Arrays.fill(dp[i], false);
        
        for(int j = 0; j< N; j++){
        		for(int i = 0; i<N; i++){
        			if(i>j)
        				break;
        			else if(i==j)
        				dp[i][j] = true;
        			else{
        				if(s.charAt(i) != s.charAt(j))
        					dp[i][j] = false;
        				else if(i == j-1)
        					dp[i][j] = true;
        				else
        					dp[i][j] = dp[i+1][j-1];
        			}
        		}
        }
        
        //calculate how many 
        int res = 0;
        for(int j = 0; j<N; j++){
        		for(int i = 0; i <N; i++){
        			if(i>j) break;
        			if(dp[i][j] == true)
        				res++;
        		}
        }
        
        return res;
    }

int count = 0;
public int countSubstrings1(String s) {
    for(int i = 0; i<s.length(); i++){
    		sub(s,i,i);
    		sub(s,i,i+1);
    }
    return count;
}

private void sub(String s, int lo, int hi){
	while(lo >= 0 && hi < s.length()  && s.charAt(lo) == s.charAt(hi)){
		count++;
		lo--;
		hi++;
	}
}

}
