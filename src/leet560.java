package algorithm;

import java.util.HashMap;
import java.util.Map;

public class leet560 {
	
	public static void main(String[] args){
		leet560 test = new leet560();
		int [] nums = {1,1,1};
		int k = 2;
		System.out.println(test.subarraySum(nums, k));
	}
	
	public int subarraySum(int[] nums, int k) {
        // lets try the brute force method
		// brutal force accepted but it take 600ms -.-
		if(nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int [] temp = new int[n];
		for(int i = n-1; i>= 0; i--){
			if(i == n-1) 
				temp[i] = nums[i];
			else
				temp[i] = temp[i+1] + nums[i];
		}
		
		int res = 0;
		for(int i = 0; i<n; i++){
			if(temp[i] < k ) {
				int j = i;
				if(j == n-1) continue;
				j++;
				while(j<n){
					int compare = temp[i] - temp[j];
					if(compare == k) {
						res++;
					}
					j++;
				}
			}
			else if(temp[i] == k) {
				res++;
				int j = i;
				if(j == n-1) continue;
				j++;
				while(j<n){
					int compare = temp[i] - temp[j];
					if(compare == k) {
						res++;
					}
					j++;
				}
			}
			else{
				int j = i;
				if(j == n-1) continue;
				j++;
				while(j<n){
					int compare = temp[i] - temp[j];
					if(compare == k) {
						res++;
					}
					j++;
				}
			}
		}
		return res;
    }

	public int subarraySum1(int [] nums, int k){
		// this method is 6666
		// O(n) time and O(n) space
		// 41 ms,  10 times faster
		if(nums == null || nums.length == 0 ) return 0;
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		map.put(0, 1);
		int sum = 0;
		int res = 0;
		for(int i = 0; i<nums.length; i++){
			sum += nums[i];
			
			// the procedure is critical, u must detect first. then add the current sum.
			int compare = sum - k;
			if(map.containsKey(compare))
				res += map.get(compare);
			
			
			if(map.containsKey(sum))
				map.put(sum, map.get(sum)+1);
			else
				map.put(sum, 1);
			
			
		}
		return res;
	}
}
