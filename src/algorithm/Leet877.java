package algorithm;

public class Leet877 {
    public boolean stoneGame(int[] piles) {
//        return dfs(piles, 0, piles.length-1, 0,0, 0);
        int N = piles.length;
        int [][] dp = new int [N][N];
        for(int i = 0; i< N; i++) dp[i][i] = piles[i];
        for(int size = 1; size < N; size ++){
            for(int i = 0; i+size < N; i++){
                // 斜对角地填充
                dp[i][i+size] = Math.max(piles[i] - dp[i+1][i+size], piles[i+size] - dp[i][i+size -1]);
            }
        }
        return dp[0][N-1] > 0 ;
    }

    /**
     * 这个解法有问题在于，局部最优解不一定是全剧最优解
     */
//    public boolean dfs(int[] piles, int start, int end , int first, int second, int turn){
//        if(start >= end)
//            return first > second;
//
//        int nextFirst = first;
//        int nextSecond = second;
//
//        if(piles[start] > piles[end]){
//            if(turn % 2 == 0){
//                nextFirst += piles[start];
//            }
//            else {
//                nextSecond += piles[start];
//            }
//            return dfs(piles, start + 1, end, nextFirst, nextSecond, turn +1);
//        }
//        else if (piles[start] < piles[end]){
//            if(turn % 2 == 0){
//                nextFirst += piles[end];
//            }
//            else {
//                nextSecond += piles[end];
//            }
//            return dfs(piles, start , end -1 , nextFirst, nextSecond, turn +1);
//        }
//        else{
//            if(turn % 2 == 0){
//                nextFirst += piles[end];
//            }
//            else {
//                nextSecond += piles[end];
//            }
//            return  dfs(piles, start + 1, end, nextFirst, nextSecond, turn +1)
//                    || dfs(piles, start , end -1 , nextFirst, nextSecond, turn +1) ;
//        }
//    }



}
