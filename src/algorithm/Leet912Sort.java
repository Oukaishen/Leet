package algorithm;

import java.util.*;

/**
 * 这个题目起始挺好的，挺单纯，让我联系快排，等等各种排序
 */
public class Leet912Sort {

    public static void main(String [] args){
        int [] nums = new int[]{-4,0,7,4,9,-5,-1,0,-7,-1};
        Leet912Sort test = new Leet912Sort();
        System.out.println(test.sortArray(nums));
    }

    public List<Integer> sortArray(int[] nums) {
        if( nums == null )
            return null;
        quickSort(nums,0, nums.length-1);
        List<Integer> res = new ArrayList<>(nums.length);
        for(int num : nums){
            res.add(num);
        }
        return res;
    }

    /**
     * 复习熟悉快排
     * @param nums
     * @return
     */
    public void quickSort(int[] nums, int lo, int hi){
        //回忆，快排是先分割，再排序子序列
        if( hi <= lo ){
            return;
        }

        int j = pivotHepler(nums, lo, hi);
        quickSort(nums, lo, j-1);
        quickSort(nums, j+1, hi);

    }

    private int pivotHepler(int [] nums, int lo, int hi){
        //回忆，使用第一个数字num[lo]做分解值，左右两部一起历遍，左边找第一个比他大的数字，右边找第一个比他小的数字；
        int cutNum = nums[lo], i = lo, j = hi + 1;
        while( true ){
            while(cutNum >= nums[++i]) if(i == hi) break;
            while(cutNum <= nums[--j]) if(j == lo) break;
            if(i >= j ) break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int tmp = nums[j];
        nums[j] = cutNum;
        nums[lo] = tmp;

        return j;
    }

}
