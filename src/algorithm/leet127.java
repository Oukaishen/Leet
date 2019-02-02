package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//time limited exceed
// 19/39 passed
// maybe we can use hashMap to speed up
// cannot do this myself 
//really a tough day on 26 sep
public class leet127 {
	int res = Integer.MAX_VALUE;
	int count = 1;
	HashMap<String,Integer> map = new HashMap<>();
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        sub(wordList,beginWord,endWord);
        return res != Integer.MAX_VALUE? res : 0;
    }

private void sub(List<String> tempList, String nowWord, String endWord){
	if(nowWord.equals(endWord)) {
		res = Math.min(res, count);
	}
	for(String nextWord: tempList){
		if(isCandidate(nowWord, nextWord)){
			List<String> newlist = new ArrayList<>(tempList);
			newlist.remove(nextWord);
			count++;
			sub(newlist,nextWord,endWord);
			count--;
		}
	}
}


private boolean isCandidate(String beginWord, String targetWord){
	int dif = 0;
	for(int i = 0; i < beginWord.length(); i++){
		if(beginWord.charAt(i) != targetWord.charAt(i)) dif++;
	}
	return dif == 1;
}

//lets see that what is the two end BFS
public int ladderLength1(String beginWord, String endWord, List<String> wordlist){
	
	Set<String> beginSet = new HashSet<>(),  endSet = new HashSet<>();
	
	int len = 1;
	int strLen = beginWord.length();
	HashSet<String> visited  = new HashSet<>();
	
	beginSet.add(beginWord);
	endSet.add(endWord);
	while(!beginSet.isEmpty() && !endSet.isEmpty()){
		if (beginSet.size() > endSet.size()) {
			Set<String> set = beginSet;
			beginSet = endSet;
			endSet = set;
		}
		
		Set<String> temp = new HashSet<String>();
		
		for (String word : beginSet) {
			char[] chs = word.toCharArray();

			for (int i = 0; i < chs.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char old = chs[i];
					chs[i] = c;
					String target = String.valueOf(chs);

					if (endSet.contains(target)) {
						return len + 1;
					}

					if (!visited.contains(target) && wordlist.contains(target)) {
						temp.add(target);
						visited.add(target);
					}
					chs[i] = old;
				}
			}
		}
		beginSet = temp;
		len++;
	}
	return 0;
}

// this is very strong point to prove the set's search speed.
public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>(), vis = new HashSet<>();
    qs.add(beginWord);
    if (dict.contains(endWord)) qe.add(endWord); // all transformed words must be in dict (including endWord)
    for (int len = 2; !qs.isEmpty(); len++) {
        Set<String> nq = new HashSet<>();
        for (String w : qs) {
            for (int j = 0; j < w.length(); j++) {
                char[] ch = w.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == w.charAt(j)) continue; // beginWord and endWord not the same, so bypass itself
                    ch[j] = c;
                    String nb = String.valueOf(ch);
                    if (qe.contains(nb)) return len; // meet from two ends
                    if (dict.contains(nb) && vis.add(nb)) nq.add(nb); // not meet yet, vis is safe to use
                }
            }
        }
        qs = (nq.size() < qe.size()) ? nq : qe; // switch to small one to traverse from other end
        qe = (qs == nq) ? qe : nq;
    }
    return 0;
}

}
