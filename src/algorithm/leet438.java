package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet438 {
	public static void main(String[] args){
		leet438 test = new leet438();
		System.out.println(test.findAnagrams("cbaebabacd", "abc"));
	}
public List<Integer> findAnagrams(String s, String p) {
		if(s == null) return null;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		List<Integer> result = new ArrayList<Integer>();
		if(s.length() < p.length()) return result;
		if(p.length() == 0) return result;
		for(char c :p.toCharArray()){
			Integer value = map.get(c);
			map.put(c, value == null ? 1: value+1);
		}
		Map<Character,Integer> tmpMap = new HashMap<Character,Integer>();
		for(int i = 0; i<s.length();i++){
			char c = s.charAt(i);
			Integer value = tmpMap.get(c);
			tmpMap.put(c, value == null? 1:value+1);
			if(i>=p.length()){
				char del = s.charAt(i-p.length());
				Integer delvalue = tmpMap.get(del);
				if(delvalue == 1) tmpMap.remove(del);
				else
					tmpMap.put(del, delvalue-1);
			}
			if(map.equals(tmpMap))
				result.add(i-p.length()+1);
		}
		return result;
    }
//	public boolean isMatch(Map<Character,Integer> map1, Map<Character,Integer> map2 ){
//		boolean flag = true;
//		
//		return flag;
//	}
}
