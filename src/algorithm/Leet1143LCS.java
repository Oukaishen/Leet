package algorithm;

/**
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted
 * without changing the relative order of the remaining characters.
 * (eg, "ace" is a subsequence of "abcde" while "aec" is not).
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class Leet1143LCS {

    public static void main(String[] args){
        String text1 = "bsbininm";
        String text2 = "jmjkbkjkv";

        Leet1143LCS test = new Leet1143LCS();
        System.out.println(test.longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null)
            return 0;
        if(text1.isEmpty() || text2.isEmpty())
            return 0;

        int M = text1.length(), N = text2.length();
        int [][] dp = new int[M][N];

        for(int i = 0; i < M; i++){
            if(text1.charAt(i) == text2.charAt(0)){
                dp[i][0] = 1;
            }
            if(i >0 && dp[i-1][0] == 1)
                dp[i][0] = 1;

        }

        for(int j = 0; j < N; j++){
            if(text1.charAt(0) == text2.charAt(j)){
                dp[0][j] = 1;
            }
            if(j > 0 && dp[0][j-1] == 1)
                dp[0][j] = 1;
        }

        for(int i = 1; i < M; i++){
            for(int j = 1; j < N; j++){
                int res = Math.max(dp[i-1][j], dp[i][j-1]);
                if(text1.charAt(i) == text2.charAt(j)) {
                    res = Math.max(res, dp[i-1][j-1]+1);
                }
                dp[i][j] = res;
            }
        }

        return dp[M-1][N-1];
    }

}
