package algorithm;

import java.util.HashMap;

public class leet91 {
	
	public static void main(String[] args){
		leet91 test = new leet91();
		System.out.println(test.numDecodings("10"));
	}
	
	HashMap<String, Integer> map = new HashMap<>();
public int numDecodings(String s) {
     if(s == null || s.isEmpty() || s.equals("0")) return 0;
     map.clear();
     map.put("0", 0);
     return sub(s);
    }
// this is my own method. there is still a dp method. do that next time
private int sub(String remain){
	if(map.containsKey(remain)) return map.get(remain);
	if(remain.length() == 0) return 1;
	if(remain.charAt(0) == '0') return 0;
	if(remain.length() == 1) return 1;
	if(Integer.parseInt(remain.substring(0, 2)) > 26){
		// this means the first cannot be two character
		int one = sub(remain.substring(1));
		map.put(remain, one);
		return one;
	}
	else{
		int one = sub(remain.substring(1));
		int two = sub(remain.substring(2));
		map.put(remain, one+two);
		return one+two;
	}
}

}
