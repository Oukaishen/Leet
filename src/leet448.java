package algorithm;

import java.util.ArrayList;
import java.util.List;

public class leet448 {
	// first method to make negative as marker
	public List<Integer> findDisappearedNumbers(int[] nums) {
        // cannot think of these solutions. 
		// redo on  August 4th
		List<Integer> res = new ArrayList<Integer>();
		
		for(int i = 0; i< nums.length; i++){
			int index = Math.abs(nums[i])  - 1;
			if(nums[index] > 0) 
				nums[index] = - nums[index];
 		}
		for(int i = 0; i< nums.length; i++){
			if(nums[i] > 0 )
				res.add(i+1);
		}
		return res;
    }
	// second method to make larger than the range as marker
	public List<Integer> findDisappearedNumbers1(int[] nums){
		List<Integer> res = new ArrayList<Integer>();
		int n = nums.length;
		for(int i = 0; i<n; i++){
			int index = (nums[i] - 1) % n;
			nums[index] += n;
		}
		for(int i = 0; i<n; i++){
			if(nums[i]<=n)
				res.add(i+1);
		}
		return res;
	}
}
