package algorithm;

public class leet152 {
	public int maxProduct(int[] nums) {
        // this method is quite impressive, there is nothing done with the 1....-.- pyb u little bitch
		if(nums == null || nums.length == 0) return 0;
		int res = nums[0];
		
		for(int i = 1, imax = res, imin = res; i< nums.length;i++){
			if(nums[i] < 0){
				int tmp = imax;
				imax = imin;
				imin = tmp;
			}
			
			imax = Math.max(nums[i], imax*nums[i]);
			imin = Math.min(nums[i], imin*nums[i]);
			
			res = Math.max(res, imax);
		}
		return res;
    }
}
