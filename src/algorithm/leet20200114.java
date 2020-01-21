package algorithm;

public class leet20200114 {

    // STR 最长公共子序列
    public int largetCommon(String str1, String str2){

        if(str1 == null || str2 == null)
            return -1;

        // 求出DP矩阵
        int M = str1.length(); int N = str2.length();
        int [][] dp = new int [M][N];

        int tmp = 0;

        //dp[i][j] 代表STR1[0..I] STR2[0..J]的最大长度
        for(int i = 0; i < M ; i++){
            if(str1.charAt(i) == str2.charAt(0)){
                tmp = 1;
            }
            dp[i][0] = tmp;
        }

        tmp = 0;
        for(int j = 0; j < N; j++){
            if(str1.charAt(0) == str2.charAt(j)){
                tmp = 1;
            }
            dp[0][j] = tmp;
        }

        for (int i = 1; i < M; i++){
            for (int j = 1; j< N; j++){

                tmp = Math.max(dp[i][j-1], dp[i-1][j]);
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = Math.max(dp[i-1][j-1],tmp) + 1;
                }
                else {
                    dp[i][j] = tmp;
                }
            }
        }


        return dp[N-1][M-1];
    }

}
