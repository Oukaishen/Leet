package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] candidates = new int []{10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(new leet40().combinationSum2(candidates, target));
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(res, temp, candidates, 0, 0,target);
		
		return res;
    }
	
	private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int start, int current, int target){
		if(current > target)
			return;
		else if(current == target){
			
			res.add(new ArrayList<>(temp));
		}
		
		for(int i = start; i < candidates.length; i++){
			if(i > start && candidates[i] == candidates[i-1])
				continue;
			temp.add(candidates[i]);
			backtrack(res,temp,candidates,i+1,current+candidates[i],target);
			temp.remove(temp.size()-1);
		}
		
	}
	
}
