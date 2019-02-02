package algorithm;

public class leet209 {
public int minSubArrayLen(int s, int[] nums) {
       int counter = 0, begin = 0, end = 0;
       int res = Integer.MAX_VALUE;
       while(end < nums.length){
    	   // no need of this two lines
//    	   		if(nums[end] >= s)
//    	   			return 1;        
    	   		counter += nums[end++];
    	   		while(counter >= s){
    	   			res = Math.min(res, end - begin);
    	   			counter -= nums[begin++];
    	   		}
       }
       
       return res==Integer.MAX_VALUE? 0:res;
    }
}
