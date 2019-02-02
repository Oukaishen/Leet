package algorithm;

import java.util.LinkedList;
import java.util.List;

public class leet139 {
	
	public static void main(String[] args){
		leet139 test = new leet139();
		String s = "aaaaaaa";
		String s1 = new String("leectcode");
		List<String> l = new LinkedList<String>();
		l.add("aaaa"); l.add("aa");
		System.out.println(test.wordBreak(s, l));
	}
	// this seems work but the time exceed the limit.
public boolean wordBreak(String s, List<String> wordDict) {
	if(s.length() == 0) return true;	
	if(wordDict.size() == 0) return false;
	boolean res = false;
	for(String word: wordDict){
		int wordlength = word.length();
		for(int i = 0; i<= s.length() - wordlength + 1; i++){
			if(s.startsWith(word,i)){
				String newString1 = s.substring(0, i); 
				String newString2 = s.substring(i + wordlength, s.length());
//				List<String> newList = new LinkedList<String>(wordDict);
//				newList.remove(word);
				res = res || ( wordBreak(newString1, wordDict) && wordBreak(newString2, wordDict) );
			}
		}
	}
	
	return res;
    }

// fucking genius dp, thats very cool
// very good dp thinking problem
public boolean wordBreak1(String s, List<String> wordDict){
	boolean [] dp = new boolean[s.length() + 1];
	dp[0] = true;
	
	for(int i = 1; i<= s.length(); i++){
		for(int j = 0; j<i; j++){
			if(dp[j] && wordDict.contains(s.substring(j, i))){
				dp[i] = true;
				break;
			}
		}
	}
	return dp[s.length()];
}
}
