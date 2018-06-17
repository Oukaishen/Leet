package algorithm;

public class leet268 {
public static void main(String[] args){
	int [] input = new int []{9,6,4,2,3,5,7,0,1};
	System.out.println(missingNumber(input));
}

public static int missingNumber(int[] nums) {
    if( nums == null || nums.length == 0)
    		return -1;
	int N = nums.length;
    int res = N;
	for(int i=0;i<N;i++){
    		res ^= nums[i]^i;
    }
	return res;
}

public static int missingNumber1(int[] nums) {
	if( nums == null || nums.length == 0)
		return -1;
	int N = nums.length;
	int sum = N*(N+1)/2;
	for(int i=0;i<N;i++){
		sum -= nums[i];
	}
	return sum;
}

}
