package algorithm;

public class Leet718LCSubstring {
    public static void main(String [] args){
        Leet718LCSubstring test = new Leet718LCSubstring();
        int [] A = new int[]{1,2,3,2,1};
        int [] B = new int[]{3,2,1,4,7};
        System.out.println(test.findLength(A, B));
    }

    public int findLength(int[] A, int[] B) {

        if(A == null || B == null || A.length == 0 || B.length == 0)
            return 0;

        int M = A.length, N = B.length;
        int [][] dp = new int[M][N];

        for(int i = 0; i < M; i++){
            if(A[i] == B[0]){
                dp[i][0] = 1;
            }
        }

        for(int j = 0; j < N; j++){
            if(A[0] == B[j]){
                dp[0][j] = 1;
            }
        }

        int res = 0;

        for(int i = 1; i < M; i++){
            for(int j = 1; j < N; j++){
                if(A[i] == B[j])
                    dp[i][j] = dp[i-1][j-1] + 1;
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}
