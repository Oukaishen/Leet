package algorithm;

public class leet34 {
	public int[] searchRange(int[] nums, int target) {
        //binary search  my own method is the find the mid, then O(n) to find the first and the last
		if(nums == null || nums.length == 0) return new int[]{-1,-1};
		
		int lo = 0; int hi = nums.length-1; int mid;
		
		while(lo <= hi){
			mid = (lo + hi)/2;
			int compare = target - nums[mid];
			if(compare > 0) {
				lo = mid+1;
			}
			else if(compare < 0) {
				hi = mid-1;
			}
			else{
				int first = mid; int last = mid;
				while(first >= 0 && nums[first] == nums[mid]) first--;
				while(last < nums.length  && nums[last] == nums[mid]) last++;
				return new int[]{first+1,last-1};
			}
		}
		return new int[] {-1,-1};
    }

	// there is still another method that is very powerful
	// the gist is that  we find the first appearance 
	public int[] searchRange1(int[] nums, int target){
		int [] res = new int[]{-1,-1};
		if( nums == null || nums.length == 0) return res;
		
		int lo = 0; int hi = nums.length - 1; int mid;
		
		while(lo < hi ){
			mid = (lo+hi)/2;
			if(target > nums[mid]) lo = mid+1;
			else
				hi = mid;
		}
		if(nums[lo] != target) return res;
		res[0] = lo;
		hi = nums.length-1;
		while(lo < hi){
			mid = (lo+hi)/2+1;
			if(target < nums[mid]) hi = mid -1;
			else 
				lo = mid;
		}
		res[1] = hi;
		
		return res;
	}
}
