package algorithm;

import java.util.HashSet;

public class leet421 {
public int findMaximumXOR(int[] nums) {
        // brutal force of course this will exceed time limit
		int res = Integer.MIN_VALUE;
		for(int i = 0 ; i< nums.length ; i++){
			for(int j = i; j<nums.length; j++){
				res = Math.max(res, nums[i] ^ nums[j]);
			}
		}
		return res;
    }
 		// fuck those genius 
	public int findMaximumXOR1(int [] nums){
		HashSet<Integer> set = new HashSet<Integer>();
		int mask = 0; int max = 0;
		for(int i = 31; i>=0; i--){
			mask |= 1<<i;
			set.clear();
			for(int num:nums){
				set.add(num & mask);
			}
			
			int tryMax = max | 1<<i;
			for(Integer num:set){
				if(set.contains(num ^ tryMax)){
					max = tryMax;
				} // this is very gist ->     tryMax ^ num ^ num = tryMax;
			}
		}
		return max;
	}
}
