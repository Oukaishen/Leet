package algorithm;

import java.util.HashMap;
import java.util.Map;

public class leet1 {
public int[] twoSum(int[] nums, int target) {
		int [] result = new int [2];
		if(nums == null || nums.length == 0) return result;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
        		if(map.containsKey(nums[i])){
        			result[0] = map.get(nums[i]);
        			result[1] = i;
        			return result;
        		}
        		else{
        			map.put(target - nums[i], i);
        		}
        }
        return result;
    }
}
