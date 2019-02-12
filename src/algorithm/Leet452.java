package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet452 {
    public static void main(String[] args){

    }

    /**这个方法学习到了，但是还不够好*/
    public int findMinArrowShots(int[][] points){
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        for(int[] tuple2 : points){
            queue.add(tuple2);
        }
        int res = 0;
        while(!queue.isEmpty()){
            int [] curArrow = queue.poll();
            while(!queue.isEmpty() && curArrow[1] >= queue.peek()[0]){
                curArrow[1] = Math.min(curArrow[1], queue.poll()[1]);
            }
            res++;
        }
        return res;
    }

    /**方法2*/
    public int findMinArrowShots2(int[][] points){
        if(points.length <=1){
            return points.length;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int res = 1;
        int curEnd = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= curEnd){
                continue;
            }
            res++;
            curEnd = points[i][1];
        }
        return res;
    }
}
