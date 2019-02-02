package algorithm;

public class leet41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int[]{3,4,-1,1};
		System.out.println(new leet41().firstMissingPositive(nums));
	}
	
	public int firstMissingPositive(int[] nums) {
        	int i =0;
        	while(i< nums.length){
        		if(nums[i] <= 0 || nums[i] > nums.length || nums[i] == i+1){
        			i++;
        		}
        		else if( nums[ nums[i]-1  ] != nums[i]) swap(nums, nums[i]-1, i);
        		else
        			i++;
        	}
        	i=0;
    		while(i< nums.length && nums[i] == i+1){
    			i++;
    		}
    		return i+1;
    }
	
	public void swap(int [] A, int i, int j){
		if(i != j){
			A[i] ^= A[j];
			A[j] ^= A[i];
			A[i] ^= A[j];
		}
	}
	
}
