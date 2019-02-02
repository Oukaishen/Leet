package algorithm;

public class leet283 {
public void moveZeroes(int[] nums) {
		if(nums == null || nums.length == 0) return;
        // O(n2) insertion sort, 51 ms , fuck
		for(int i = 1; i<nums.length; i++)
			for(int j = i; j>0 && nums[j-1] == 0; j--)
				swap(nums, j, j-1);
        
    }

public void moveZeroes1(int[] nums) {
	if(nums == null || nums.length == 0) return;
    
	int i = 0, j = 0;
	while(j < nums.length){
		if(nums[j] != 0)
			swap(nums,i++,j);
		j++;
	}
    
}

private void swap(int [] nums, int i, int j){
	int tmp = nums[i];
	nums[i] = nums[j];
	nums[j] = tmp;
}
}
