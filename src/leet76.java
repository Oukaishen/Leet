package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class leet76 {
	// this is the quite genius problem, i cannot do it myself
public String minWindow(String s, String t) {
        int[] map = new int[256];
        Arrays.fill(map, 0);
        for(char c: t.toCharArray()){
        		map[c]++;
        }
        
        int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        
        while(end < s.length()){
        		if( map[ s.charAt(end++) ]-- > 0 ) counter --;
        		while(counter == 0){
        			if(end - begin < d) d = end - (head = begin);
        			if( map[ s.charAt(begin++) ]++ == 0 ) counter++;
        		}
        }
        
        return d == Integer.MAX_VALUE? "" : s.substring(head, head+d);
    }
}
