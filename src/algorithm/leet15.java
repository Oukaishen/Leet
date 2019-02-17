package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 3Sum
 * */
public class leet15 {
public List<List<Integer>> threeSum(int[] nums) {
		if( nums == null) return null;
        List<List<Integer>> res = new LinkedList<List<Integer>> ();
        if( nums.length == 0 ) return res;
        
        // O(n2) method, fucking genius 
        Arrays.sort(nums);
        for(int i = 0; i< nums.length-2;i++){
        		if(i == 0 || (i>0 && nums[i] != nums[i-1]) ){
        			int lo = i+1; int hi = nums.length-1; int sum = 0 - nums[i];
        			while(lo < hi){
        				if(nums[lo] + nums[hi] == sum){
        					List<Integer> temp = new LinkedList<Integer>();
        					temp.add(nums[i]);
        					temp.add(nums[lo]);
        					temp.add(nums[hi]);
        					res.add(temp);
        					while(lo < hi && nums[lo] == nums[++lo]);
        					while(lo < hi && nums[hi] == nums[--hi]);
        				}
        				else if(nums[lo] + nums[hi] < sum) lo++;
        				else hi--;
        			}
        		}
        }
        return res;
    }
}
