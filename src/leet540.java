package algorithm;

public class leet540 {
	public static void main(String [] args){
		leet540 test = new leet540();
		int [] nums = {3,3,7,7,10,11,11};
		System.out.println(test.singleNonDuplicate(nums));
	}
public int singleNonDuplicate(int[] nums) {
        	if(nums.length<3) return -1;
        	else {
        		int res;
        		if(nums.length == 3){
        			res = nums[0];
        			for(int i = 1; i<nums.length;i++){
        				res ^= nums[i];
        			}
        		}
        		else{
        			int i = 0; int j = nums.length-1; int mid = (i+j)/2;
        			while(j-i+1 >3){
        				mid = (i+j)/2;
        				if(nums[mid] == nums[mid+1])
        					mid ++; // this is for special case that we divide a pair into two array.
        				if( (mid & 1) == 1) // odd then mid+1 is even
        					i = mid+1;
        				else
        					j = mid;
        			}
        			res = nums[i] ^ nums[i+1] ^ nums[i+2];
        		}
        		return res;
        	}
    }
}
