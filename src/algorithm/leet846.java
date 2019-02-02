package algorithm;

import java.util.Map;
import java.util.TreeMap;

public class leet846 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isNStraightHand(int[] hand, int W) {
        if(hand == null || hand.length % W !=0) 
        		return false;
        Map<Integer, Integer> c = new TreeMap<>();
        for(int num : hand) c.put(num, c.getOrDefault(num, 0)+1 );
        for(int it: c.keySet())
        		if(c.get(it) > 0)
        			for(int i = W-1; i>=0; --i){
        				if(c.getOrDefault(it+i, 0) < c.get(it)) return false;
        				c.put(it + i, c.get(it+i) - c.get(it));
        			}
        return true;
    }
}
