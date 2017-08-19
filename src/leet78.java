package algorithm;

import java.util.LinkedList;
import java.util.List;

public class leet78 {
	// my own thought
public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        sub(res, new LinkedList<Integer>(), nums, 0);
        return res;
    }

private void sub(List<List<Integer>> res, List<Integer> templist, int [] nums, int now){
	if(now > nums.length) throw new UnsupportedOperationException();
	if(now == nums.length) 
		res.add(new LinkedList<Integer>(templist));
	else{
		templist.add(nums[now]);
		sub(res,templist,nums,now+1);
		templist.remove(templist.size()-1);
		sub(res,templist,nums,now+1);
	}
}
}
