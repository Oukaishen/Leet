package algorithm;

import java.util.Arrays;

public class leet3redo {
public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) return 0;
        int[] map = new int[256];
        Arrays.fill(map, 0);
        
        int counter = 0, begin = 0, end = 0, d = Integer.MIN_VALUE, head = 0;
        
        while(end < s.length()){
        		if( map[ s.charAt(end++) ]++ > 0 ) counter++;
        		while(counter > 0){
        			if(map[ s.charAt(begin++) ]-- > 1) counter--;
        		}
        		if(d < end - begin){
        			d = end - (head = begin);
        		}
        }
        return d;
    }
}
