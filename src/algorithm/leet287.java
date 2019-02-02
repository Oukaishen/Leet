package algorithm;

public class leet287 {
	public int findDuplicate(int[] nums) {
        int n = nums.length;
        if (n <= 1) return -1;
        int slow = nums[0];
        int fast = nums[ nums[0] ];
        
        while(slow != fast ){
        		slow = nums[slow];
        		fast = nums [ nums [fast] ];
        }
        
        // find the entry of the loop
        fast = 0;
        while(slow != fast ){
        		fast = nums[fast];
        		slow = nums[slow];
        }
        
        return slow;
    }
}
