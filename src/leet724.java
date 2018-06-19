package algorithm;

public class leet724 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = new int[]{1, 7, 3, 6, 5, 6};
		System.out.println(new leet724().pivotIndex(input));
	}
	
	public int pivotIndex(int[] nums) {
        
		if(nums == null || nums.length == 0)
			return -1;
		if(nums.length == 1) 
			return 0;
		
		
		int totalSum = 0;
		int leftSum = 0;
		int rightSum = 0;
		
		// calculate the total sum
		for(int num: nums){
			totalSum += num;
		}
		
		rightSum = totalSum;
		
		for(int i = 0; i<nums.length;i++){
			if(i > 0){
				leftSum += nums[i-1];
			}
			rightSum -= nums[i];
			
			if(leftSum == rightSum)
				return i;
		}
		
		
		return -1;
    }
	
}
