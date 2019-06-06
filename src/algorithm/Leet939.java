package algorithm;

import java.util.*;

public class Leet939 {
    public int minAreaRect(int[][] points) {
        int res = 0;
        if(points == null){
            return res;
        }
        // 思路是：groupBy X, 得到一些边
        Map<Integer, List<Integer>> cols = new TreeMap<>();

        for(int [] point: points){
            int x = point[0], y = point[1];
            cols.computeIfAbsent(x, z -> new ArrayList()).add(y);
        }

        // 然后计算
        res = Integer.MAX_VALUE;
        Map<Integer, Integer> lastx = new HashMap<>();

        for(int x : cols.keySet()){
            List<Integer> col = cols.get(x);
            Collections.sort(col);
            for(int i = 0; i<col.size(); i++){
                for(int j = i+1; j< col.size(); j++){
                    int y1 = col.get(i), y2 = col.get(j);
                    int hashCode = 40001* y1 + y2;
                    if(lastx.containsKey(hashCode)){
                        res = Math.min(res, (x - lastx.get(hashCode))*(y2 - y1) );
                    }
                    lastx.put(hashCode, x);
                }
            }
        }

        return res < Integer.MAX_VALUE ? res : 0;
    }
}
