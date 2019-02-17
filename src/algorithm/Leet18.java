package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leet18 {

    public static void main(String[] args){
        Leet18 test = new Leet18();
        int [] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(test.fourSum(nums,target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        return kSum(4, nums,0,target);
    }

    public List<List<Integer>> kSum(int k, int[] nums, int startIndex, int target){
        List<List<Integer>> res = new LinkedList<>();
        if(k > nums.length - startIndex){
            return res;
        }
        if(k == 2){
            int i = startIndex, j = nums.length-1;
            while(i < j){
                if(nums[i] + nums[j] == target){
                    List<Integer> temp = new LinkedList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    res.add(temp);
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
                else if(nums[i] + nums[j] < target){
                    i++;
                }
                else{
                    j--;
                }
            }
            return res;
        }
        else{
            for(int i = startIndex; i < nums.length; i++){
                if(i > startIndex && nums[i] == nums[i-1]){
                    continue;
                }
                List<List<Integer>> tempLists = kSum(k - 1, nums, i + 1, target - nums[i]);
                for(List<Integer> temp : tempLists){
                    temp.add(0,nums[i]);
                    res.add(temp);
                }
            }
            return res;
        }
    }
}
