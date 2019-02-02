package algorithm;

import java.util.Arrays;

public class leet55 {
	// this method can not pass because the time limited problem
//public boolean canJump(int[] nums) {
//        if(nums.length == 1) return true;
//        else if(nums.length > 1 && nums[0] == 0) return false;
//        else if(nums.length > 1 && nums[0] >= nums.length-1) return true;
//        else {
//        		boolean flag = false;
//        		for(int i = 1; i <= nums[0]; i++){
//        			flag = flag || canJump(Arrays.copyOfRange(nums, i, nums.length));
//        		}
//        		return flag;
//        }
//    }

	// this is the solutions form others, which is very impressive
public boolean canJump(int[] nums) {
    int max=0;
    for(int i = 0; i< nums.length; i++){
    	   // this method is quite clever.
    	   // the key point is that we save the maximum index that we can reach
    	   // once we found that max < i, means that we cannot reach this i.
    	   // then we can quit and return false;
    		if(max < i) return false;
    		max = Math.max(nums[i]+i, max);
    }
    return true;
}

}
