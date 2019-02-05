package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 牛逼，独立完成
 */
public class Leet16 {
    public static void main(String [] args){
        int [] nums = new int[]{-1,2,1,-4};
        int target = 1;
        Leet16 test = new Leet16();
        System.out.println(test.threeSumClosest(nums, target));

    }

    public int threeSumClosest(int[] nums, int target){
        if(nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i< nums.length ;i++){
            int threeSum = nums[i] + twoSumclosest(nums, target- nums[i], i);
            if(Math.abs((long)(target - res)) > Math.abs((long)(target - threeSum)) ){
                res = threeSum;
            }
        }
        return res;
    }

    public int twoSumclosest(int [] nums, int target, int forbidIndex)
    {
        int i = 0, j = nums.length - 1;
        int least = Integer.MAX_VALUE;
        while(i < j && j > 0){
            if (i == forbidIndex){
                i++;
                continue;
            }
            if(j == forbidIndex){
                j--;
                continue;
            }
            int twoSum = nums[i] + nums[j];
            if(twoSum > target){
                j--;
            }
            else if (twoSum < target){
                i++;
            }
            else{
                return target;
            }
            if( Math.abs((long)(target - least)) > Math.abs((long)(target - twoSum))){
                least = twoSum;
            }
        }
        return least;
    }

}
