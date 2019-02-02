package algorithm;

public class leet334 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = new int[]{5, 4, 3, 2, 1};
		System.out.println(new leet334().increasingTriplet(input));
	}
	
	public boolean increasingTriplet(int[] nums) {
        
		int small  = Integer.MAX_VALUE; 
		int big = Integer.MAX_VALUE;
		for(int num : nums){
			if(num < small) small = num;
			else if(num < big) big = num;
			else 
				return true;
		}
		
		return false;
    }
}
