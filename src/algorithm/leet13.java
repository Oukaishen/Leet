package algorithm;

import java.util.HashMap;

public class leet13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = Integer.MAX_VALUE;
		System.out.println(a);
		System.out.println(leet13.romanToInt("MCMXCIV"));
	}
	
	public static int romanToInt(String s) {
		
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int res = 0;
		
		for(int i = 0, j=1; j<s.length(); i++,j++){
			if(map.get(s.charAt(i)) < map.get(s.charAt(j))){
				res -= map.get(s.charAt(i));
			}
			else
				res += map.get(s.charAt(i));
		}
		res += map.get(s.charAt(s.length()-1));
		return res;
    }
	
}
