package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Leet442 {

    public static void main(String[] args){
        int [] nums = {4,3,2,7,8,2,3,1};
        Leet442 test = new Leet442();
        System.out.println(test.findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums){
        for(int i = 0; i <nums.length; i++){
            while(nums[i] != i+1){
                if(nums[ nums[i] -1 ] == nums[i]) {
                    break;
                }
                swap(nums, i, nums[i]-1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != i+1){
                res.add(nums[i]);
            }
        }
        return res;
    }

    private void swap(int [] nums, int i, int j){
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
