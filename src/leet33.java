package algorithm;

public class leet33 {
	
	public static void main(String[] args){
		leet33 test = new leet33();
		int [] nums = {3,1};
		System.out.println(test.search1(nums,1));
	}
	
	// dont know why its so slow but this is not very concise
	public int search(int[] nums, int target) {
		if(nums == null) return -1;
		int i = 0;  int j = nums.length-1;
		if( nums[i] <= nums[j] ){
			//sorted array -> binary search
			while(i<=j){
				int mid = (i+j)/2; 
				int compare = target - nums[mid];
				if(compare > 0){
					i = mid+1;
				}
				else if(compare < 0){
					j = mid-1;
				}
				else
					return mid;
			}
			return -1;
		}
		else{
			int pivot = Integer.MIN_VALUE;
			while(nums[i] > nums[j]){
				if(j - i == 1){
					pivot = j;
					break;
				}
				int mid = (i+j)/2;
				if(nums[mid] >= nums[i]){
					i = mid;
				}
				else if(nums[mid] <= nums[j]){
					j = mid;
				}
			}
			pivot = j;
			if(target > nums[pivot-1] || target < nums[pivot]){
				return -1;
			}
			else if( target >= nums[0]){
				// seach form 0 to pivot -1
				i  = 0; j = pivot-1;
				while(i<=j){
					int mid = (i+j)/2; 
					int compare = target - nums[mid];
					if(compare > 0){
						i = mid+1;
					}
					else if(compare < 0){
						j = mid-1;
					}
					else
						return mid;
				}
			}
			else{
				// search form pivot to n-1
				i = pivot; j = nums.length-1;
				while(i<=j){
					int mid = (i+j)/2; 
					int compare = target - nums[mid];
					if(compare > 0){
						i = mid+1;
					}
					else if(compare < 0){
						j = mid-1;
					}
					else
						return mid;
				}
			}
			return -1;
		}
    }

	//more concise method
	public int search1(int[] nums, int target){
		if(nums == null || nums.length == 0) return -1;
		
		int i = 0;
		int j = nums.length-1;
		
		while(i <= j){
			int mid = (i+j)/2;
			
			if(nums[mid] == target) return mid;
			
			if(nums[mid] >= nums[i]){
				if(target < nums[mid] && target >= nums[i]){
					j = mid-1;
				}
				else{
					i = mid + 1;
				}
			}
			else if(nums[mid] <= nums[j]){
				if(target > nums[mid] && target <= nums[j]){
					i = mid+1;
				}
				else{
					j = mid-1;
				}
			}
			
		}
		return -1;
	}
}
