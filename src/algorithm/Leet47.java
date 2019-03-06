package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leet47 {

    public static void main(String [] args){
        int [] nums = new int[]{1,1,2};
        Leet47 test = new Leet47();
        System.out.println(test.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        boolean [] used = new boolean[nums.length];
        List<Integer> tmpResult = new LinkedList<>();
        Arrays.sort(nums);
        helper(nums, used, res, tmpResult);
        return res;
    }

    private void helper(int [] nums, boolean [] used, List<List<Integer>> res, List<Integer> tmpRes){
        if(tmpRes.size() == nums.length){
            res.add(new LinkedList<>(tmpRes));
        }
        for(int i = 0; i< nums.length; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            used[i] = true;
            tmpRes.add(nums[i]);
            helper(nums,used, res, tmpRes);
            used[i] = false;
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
}
