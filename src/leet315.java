package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class leet315 {
	//this problem is quite interesting. Redo on July 31.
	int [] count;
	public static void main(String[] args){
		leet315 test = new leet315();
		int [] nums = {5,2,6,1};
		System.out.println(test.countSmaller(nums));
	}
public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        count = new int[nums.length];
        int [] index = new int[nums.length];
        for(int i = 0; i< nums.length;i++){
        		index[i] = i;
        }
        mergesort(nums, index, 0, nums.length-1);
        for(int i = 0; i < count.length;i++){
        		result.add(count[i]);
        }
        return result;
    }

private void mergesort(int [] nums, int[] index, int lo, int hi){
	if(lo >= hi) return;
	int mid = (lo+hi)/2;
	mergesort(nums,index,lo,mid);
	mergesort(nums,index,mid+1,hi);
	merge(nums,index,lo,mid,hi);
}

private void merge(int [] nums, int[] index, int lo,int mid, int hi){
	// note we have to keep the origin the same, and sort the index. there is a little strange
	int i = mid;
	int j = hi;
	int rightcount = 0;
	int [] tmp = new int[hi-lo+1];
	for(int k = tmp.length-1; k>= 0; k--){
		if(j<=mid){
			tmp[k] = index[i--];
		}
		else if(i<lo){
			tmp[k] = index[j--];
		}
		else if( nums[ index[i] ] > nums[index[j]]  ){
			count[ index[i] ] += j- mid;
			tmp[k] = index[i--];
		}
		else{
			tmp[k] = index[j--];
		}
	}
	for(int k = 0; k<tmp.length; k++){
		index[lo+k]  = tmp[k];
	}
}
}
