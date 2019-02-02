package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leet565 {

public int arrayNesting(int[] nums) {
       	if(nums == null ) return -1;
       	if(nums.length == 0) return 0;
		// first can we do this by brutal force
       	// cannot， brutal force exceed time limit. so use flag to skip those have pass before.
		int max = Integer.MIN_VALUE;
		boolean [] flag = new boolean[nums.length];
		Arrays.fill(flag, true);
		Set<Integer> temp = new HashSet<>();
		
		for(int i = 0; i< nums.length; i++){
			if(!flag[i]) continue;
			temp.clear();
			int next = i;
			while(temp.add(nums[next])){
				flag[next] = false; // add the flag and trade space for time;
				next = nums[next];
			}
			if(temp.size() > max) 
				max = temp.size();
		}
		return max;
    }

// but we can still make our method more concisely. thank for those genius
public int arrayNesting1(int[] nums) {
	if(nums == null ) return -1;
	if(nums.length == 0) return 0;
	int res = Integer.MIN_VALUE;
	
	for(int i = 0; i < nums.length; i++){
		int size = 0;
		for(int next =  i; nums[next] >= 0; size++){  //please be very careful to the this line, we do not increase the next but the size
			// this is very neat and beautiful
			int temp = nums[next];
			nums[next] = -1;
			next = temp;
		}
		res = Math.max(res, size);
	}
	return res;
}

}
