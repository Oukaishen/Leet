package algorithm;

import java.util.HashMap;
import java.util.Map;

public class leet128 {
		public static void main(String[] args){
			leet128 test = new leet128();
			int [] nums = {100,4,200,1,3,2};
			System.out.println(test.longestConsecutive(nums));
		}
public int longestConsecutive(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i<nums.length; i++){
        		int key = nums[i];
        		if(map.containsKey(key))
        			continue;
        		else{
        			int left  = map.getOrDefault(key-1, 0);
        			int right = map.getOrDefault(key+1, 0);
        			int sum = left + right + 1;
        			map.put(key, sum);
        			res = Math.max(res, sum);
        			
        			// this is the key point that i did not notice.
        			// we only need to update the two bound of the sequence, no need to maintain all the sequence
        			map.put(key-left, sum);
        			map.put(key+right, sum);
        		}
        }
        return res;
    }
}
