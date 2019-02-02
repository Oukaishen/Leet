package algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class leet336 {
	
	public static void main(String [] args){
		System.out.println(leet336.isPalindrome(""));
	}
	
public List<List<Integer>> palindromePairs(String[] words) {
			// if i use brutal force, that is O(n2). 
			// how can i trade space for time? 
			// what i think is that for every single word, we add all its possible suppliment to a palindrome to hashmap.
			
			if(words == null) return null;
			List<List<Integer>> res = new LinkedList<>();
			List<Integer> tempList = new LinkedList<>();
			if(words.length == 0) return res;
			
			// but seems all possible is too many, let try brutal force first, cannot, exceed the time limit.
//			for(int i = 0; i< words.length ; i++){
//				tempList.clear();
//				tempList.add(i);
//				for(int j = 0; j < words.length ; j++){
//					if(j == i) continue;
//					if(isPalindrome(words[i]+words[j])){
//						tempList.add(j);
//						res.add(new LinkedList<>(tempList));
//						tempList.remove(tempList.size()-1);
//					}
//				}
//			}
			Map<String, Integer> map = new HashMap<String, Integer>();
			for(int i = 0; i<words.length; i++) map.put(words[i], i);
			for(int i = 0; i<words.length; i++){
					for(int j = 0; j <= words[i].length(); j++){
						String pre = words[i].substring(0, j);
						String after = words[i].substring(j);
						if(isPalindrome(pre)){
							String afterrev =new StringBuffer(after).reverse().toString();
							if(map.containsKey(afterrev) &&map.get(afterrev) != i){
								tempList.clear();
								tempList.add(map.get(afterrev));
								tempList.add(i);
								res.add(new LinkedList<>(tempList));
							}
						}
						if(isPalindrome(after)){
							String prerev =new StringBuffer(pre).reverse().toString();
							if(map.containsKey(prerev) &&map.get(prerev) != i && after.length() != 0){
								tempList.clear();
								tempList.add(i);
								tempList.add(map.get(prerev));
								res.add(new LinkedList<>(tempList));
							}
						}
					}
			}
			return res;
    }

private static void addSuppliment(String word, Map<String, Integer>  map){
	
}

private static boolean isPalindrome(String word){
	if(word == null) return false;
	if(word.length() == 0 || word.length() == 1) return true;
	int lo = 0; int hi = word.length()-1;
	while(lo <= hi){
		if(word.charAt(lo) != word.charAt(hi))
			return false;
		lo++;
		hi--;
	}
	return true;
}

}
