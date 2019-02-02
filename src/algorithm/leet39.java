package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class leet39 {
	public static void main(String[] args){
		leet39 test = new leet39();
		int [] candidates = {2,3,6,7};
		int target = 7;
		System.out.println(test.combinationSum(candidates, target));
	}
	// my own prefix method accept again. beat 1.3% -.- what the fuck
	// rethink why i am slow. 1. i do not detect duplicate myself, i use the set to do it for me
	// recursive too many times
public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null ) return null;
        List<List<Integer>> res = new LinkedList<>();
        Set<List<Integer>> res1 = new HashSet<>();
        if(candidates.length == 0 ) return res;
        Arrays.sort(candidates);
        if(target < candidates[0]) return res;
        List<Integer> prefix = new LinkedList<>();
        sub(res1,prefix,candidates,target);
        for(List<Integer> l: res1)
        		res.add(l);
        return res;
}

private void sub(Set<List<Integer>> res, List<Integer> prefix, int [] candidates, int target){
	if(target == 0){
		Collections.sort(prefix);
		res.add(prefix);
		return;
	}
	
	for(int i = 0; i < candidates.length; i++){
		if(target >= candidates[i]){
			List<Integer> newPrefix = new LinkedList<>(prefix);
			newPrefix.add(candidates[i]);
			sub(res,newPrefix,candidates,target-candidates[i]);
		}
		else 
			break;
	}
	
}


// finally, i got a new skill called backtrack as a standard weapon like below
public List<List<Integer>> combinationSum1(int [] candidates, int target){
	List<List<Integer>> res = new LinkedList<>();
	Arrays.sort(candidates);
	backtrack(res,new LinkedList<Integer>(),candidates,target,0);
	return res;
}

private void backtrack(List<List<Integer>> res, List<Integer> templist, int [] candidates, int target, int start ){
	if(target < 0) return;
	if(target == 0) res.add(new LinkedList<Integer>(templist));
	else {
		 for(int i = start; i<candidates.length; i++){
			 templist.add(candidates[i]);
			 backtrack(res,templist,candidates,target-candidates[i],i);
			 templist.remove(templist.size()-1);
		 }
	}
}

}
