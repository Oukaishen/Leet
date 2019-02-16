package algorithm;

import java.util.HashMap;
import java.util.Objects;

public class Leet688 {
    public static void main(String[] args){
        Leet688 test = new Leet688();
        int N = 8, K = 30, r = 6, c = 4;
        System.out.println(test.knightProbability(N,K,r,c));
    }
    HashMap<entry,Double> map;
    long totalMove;
    double remain;
    int boardSize;
    public double knightProbability(int N, int K, int r, int c) {
        totalMove=0;
        boardSize=N;
        map = new HashMap<>(N*N);
        remain = dfs(K,r,c);
        return  remain/(Math.pow(8,K));
    }
    private double dfs(int stepToDo, int r, int c){
        entry tmp = new entry(r,c,stepToDo);
        if(map.containsKey(tmp)){
            return map.get(tmp);
        }
        if(stepToDo == 0){
            if(inBoard(r,c)){
                return 1;
            }
            return 0;
        }
        if(!inBoard(r,c)){
            return 0;
        }
        double res = 0;
//        totalMove++;
        res += dfs(stepToDo - 1, r+2, c+1);
//        totalMove++;
        res += dfs(stepToDo - 1, r+2, c-1);
//        totalMove++;
        res += dfs(stepToDo - 1, r-2, c+1);
//        totalMove++;
        res += dfs(stepToDo - 1, r-2, c-1);
//        totalMove++;
        res += dfs(stepToDo - 1, r+1, c+2);
//        totalMove++;
        res += dfs(stepToDo - 1, r-1, c+2);
//        totalMove++;
        res += dfs(stepToDo - 1, r+1, c-2);
//        totalMove++;
        res += dfs(stepToDo - 1, r-1, c-2);
        map.put(tmp, res);
        return res;
    }
    private boolean inBoard(int r, int c){
        return r >= 0 && r < boardSize && c >= 0 && c < boardSize;
    }
    private class entry{
        int r;
        int c;
        int step;
        entry(int r, int c, int step){
            this.r = r;
            this.c = c;
            this.step = step;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            entry entry = (entry) o;
            return r == entry.r &&
                    c == entry.c &&
                    step == entry.step;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c, step);
        }
    }
}
