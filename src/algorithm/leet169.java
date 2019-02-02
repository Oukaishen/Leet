package algorithm;

import java.util.Random;

public class leet169 {
	
	public static void main(String[] args){
		int [] nums = {4};
		int j = leet169.sub(nums, 0, 0);
		System.out.println(j);
		for(int num:nums){
			System.out.print(num+" ");
		}
	}
	
public int majorityElement(int[] nums) {
        //O(n) method
		if(nums == null || nums.length == 0) return -1;
		int count = 1;
		int res = nums[0];
		for(int i = 1 ; i< nums.length; i++){
			if(nums[i] == res) count++;
			else{
				if(count == 0 ) {
					res = nums[i];
					count = 1;
				}
				else count--;
			}
		}
		return res;
}
/// annoying  kaishen dont be afraid just do them.
public int majorityElement1(int[] nums) {
    //try the O(logN) method
	int lo = 0;  int hi = nums.length - 1;
	
	int half = nums.length/2;
	
	while ( true ){
		int index =  sub(nums,lo,hi);
		if (index == half) return nums[index];
		else if(index < half){
			lo = index + 1;
		}
		else 
			hi = index - 1;
	}
	
}

private static int sub(int [] nums, int start, int end){
	if(nums == null || start<0 || end >= nums.length || start > end) return -1;
	
	if(start == end ) return start;
	
	Random rand = new Random();
	int chose = rand.nextInt(end - start +1 ) + start;
	swap(nums, start, chose);
	
	int i = start ;  int j =  end + 1;
 	while(i < j){
		while(nums[++i] < nums[start]) if( i >= end) break;
		while(nums[--j] > nums[start]) if( j <= start) break;
		
		if( i < j) swap(nums, i, j);
		
	}
	swap(nums, j, start);
	return j;
}

private static void swap(int [] nums, int i , int j ){
	int tmp = nums[i];
	nums[i] = nums[j];
	nums[j] = tmp;
}


}