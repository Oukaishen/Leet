package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leet15redo {
public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null) return null;
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length == 0) return res;
        
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length-2; i++){
        		if(i == 0 || (i>0 && nums[i] != nums[i-1]) ){
        			int lo = i+1; int hi = nums.length-1; int sum = 0 - nums[i];
        			while(lo< hi){
        				if(nums[lo] + nums[hi] == sum){
        					List<Integer> temp = new LinkedList<>();
        					temp.add(nums[i]);
        					temp.add(nums[lo]);
        					temp.add(nums[hi]);
        					res.add(temp);
        					while( lo < hi && nums[lo] == nums[++lo]);
        					while( lo < hi && nums[hi] == nums[--hi]);
        				}
        				else if(nums[lo] + nums[hi]< sum) lo++;
        				else hi--;
        			}
        		}
        }
        return res;
    } 
}
