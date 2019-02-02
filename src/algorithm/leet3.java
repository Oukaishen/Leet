package algorithm;

import java.util.HashMap;
import java.util.Map;

public class leet3 {
	 public int lengthOfLongestSubstring(String s) {
	        Map<Character,Integer> position = new HashMap<Character,Integer>();
	        if(s == null || s.length() == 0) return -1;
	        int result = 0;
	        int [] f = new int[s.length()];
	        f[0] = 1;
	        char c = s.charAt(0);
	        position.put(c, 0);
	        for(int i = 1; i<s.length();i++){
	        		c = s.charAt(i);
	        		boolean flag = position.containsKey(c);
	        		if(!flag){ // never appear before
	        			f[i] = f[i-1] +1;
	        		}
	        		else{ // appear before, calculate the distance between this time and the last time 
	        			int index = position.get(c);
	        			int d = i - index; 
	        			if(d <= f[i-1]){ // there is no other overlap letter
	        				f[i] = d;
	        			}
	        			else{ // there exists other overlap letter
	        				f[i] = f[i-1] +1;
	        			}
	        		}
	        		position.put(c, i);
	        }
	        for(int i = 0;i < f.length;i++){
	        		if(f[i] > result) 
	        			result = f[i];
	        }
	        return result;
	    }
}
